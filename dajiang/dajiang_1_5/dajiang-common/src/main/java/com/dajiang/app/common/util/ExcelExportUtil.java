package com.dajiang.app.common.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelExportUtil {

    public static XSSFWorkbook createXssfWorkBook() {
        return new XSSFWorkbook();
    }

    public static XSSFSheet createXssfSheet(XSSFWorkbook workbook, String sheetName) {
        if (sheetName == null) {
            return workbook.createSheet();
        } else {
            return workbook.createSheet(sheetName);
        }
    }


    public static <T> void initXSSFSheetData(XSSFSheet sheet, Map<Integer, ColumnModel> columnModelMap, List<T> dataList) {

        Map<Integer, Integer> columnWidthMap = new HashMap<Integer, Integer>();

        int rowIndex = 0;
        XSSFRow xssfRow = sheet.createRow(rowIndex++);// 创建一行
        XSSFCellStyle styleHead = getSheetHeadStyle(sheet);
        for (int columnIndex = 0; columnIndex < columnModelMap.size(); columnIndex++) {
            ColumnModel columnModel = columnModelMap.get(columnIndex);
            XSSFCell cell = xssfRow.createCell(columnIndex);// 创建一列
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(columnModel.getColumnName());
            cell.setCellStyle(styleHead);
            updateColumnWidth(columnWidthMap, columnIndex, columnModel.getColumnName());
        }

        XSSFCellStyle styleColumn = getSheetColumnStyle(sheet);
        for (T obj : dataList) {
            xssfRow = sheet.createRow(rowIndex++);
            for (int columnIndex = 0; columnIndex < columnModelMap.size(); columnIndex++) {
                XSSFCell cell = xssfRow.createCell(columnIndex);// 创建一列
                ColumnModel columnModel = columnModelMap.get(columnIndex);
                cell.setCellType(columnModel.getCellType());
                Object value;
                if (obj instanceof Map) {
                    value = ((Map) obj).get(columnModel.getDataField());
                } else {
                    value = ReflectionUtils.invokeGetterMethod(obj, columnModel.getDataField());
                }
                columnModel.setColumnValue(value);
                if (columnModel.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    value = value == null ? "0" : value.toString();
                    Double d = Double.valueOf(value.toString());
                    if (columnModel.isDivide100()) {
                        d = d / 100;
                    }
                    cell.setCellValue(d);
                } else {
                    value = columnModel.getColumnValue() == null ? "" : (columnModel.getColumnValue().toString() + columnModel.getSuffix());
                    cell.setCellValue(value.toString());
                }
                if (columnModel.getCellStyle() == null) {
                    cell.setCellStyle(styleColumn);
                } else {
                    cell.setCellStyle(columnModel.getCellStyle());
                }
                updateColumnWidth(columnWidthMap, columnIndex, columnModel.getColumnValue());
            }
        }
        for (int i = 0; i < columnModelMap.size(); i++) {
            if (columnWidthMap.get(i) > 10000) {
                continue;
            }
            sheet.setColumnWidth(i, columnWidthMap.get(i));
        }
    }

    public static XSSFCellStyle getNumericStyle(XSSFSheet sheet) {
        XSSFCellStyle numericStyle = getSheetColumnStyle(sheet);
        XSSFDataFormat format = sheet.getWorkbook().createDataFormat();
        numericStyle.setDataFormat(format.getFormat("0.00"));
        numericStyle.setAlignment(HorizontalAlignment.RIGHT);
        return numericStyle;
    }

    public static XSSFCellStyle getPercentStyle(XSSFSheet sheet) {
        XSSFCellStyle percentStyle = getNumericStyle(sheet);
        XSSFDataFormat format = sheet.getWorkbook().createDataFormat();
        percentStyle.setDataFormat(format.getFormat("0.00%"));
        return percentStyle;
    }

    private static Integer getColumnWidth(Object obj) {
        return obj == null ? 0 : obj.toString().getBytes().length * 256 + 256;
    }

    private static void updateColumnWidth(Map<Integer, Integer> columnWidthMap, int columnIndex, Object value) {
        Integer width = getColumnWidth(value);
        if (columnWidthMap.get(columnIndex) == null || columnWidthMap.get(columnIndex) < width) {
            columnWidthMap.put(columnIndex, width);
        }
    }

    public static XSSFCellStyle getSheetHeadStyle(XSSFSheet sheet) {
        XSSFCellStyle headStyle = sheet.getWorkbook().createCellStyle();
        headStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headStyle.setFillForegroundColor(new XSSFColor(Color.BLUE));
        XSSFFont font = sheet.getWorkbook().createFont();
        font.setColor(new XSSFColor(Color.WHITE));
        headStyle.setFont(font);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderTop(BorderStyle.THIN);
        return headStyle;
    }

    public static XSSFCellStyle getSheetColumnStyle(XSSFSheet sheet) {
        XSSFCellStyle styleColumn = sheet.getWorkbook().createCellStyle();
        styleColumn.setBorderBottom(CellStyle.BORDER_THIN);
        styleColumn.setBorderLeft(CellStyle.BORDER_THIN);
        styleColumn.setBorderRight(CellStyle.BORDER_THIN);
        styleColumn.setBorderTop(CellStyle.BORDER_THIN);
        return styleColumn;
    }

    public static XSSFCellStyle getSheetColumnStyle(XSSFSheet sheet, Color color) {
        XSSFCellStyle styleColumn = sheet.getWorkbook().createCellStyle();
        styleColumn.setBorderBottom(CellStyle.BORDER_THIN);
        styleColumn.setBorderLeft(CellStyle.BORDER_THIN);
        styleColumn.setBorderRight(CellStyle.BORDER_THIN);
        styleColumn.setBorderTop(CellStyle.BORDER_THIN);
        if (color != null) {
            styleColumn.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
            styleColumn.setFillForegroundColor(new XSSFColor(color));
        }
        return styleColumn;
    }

    public static class ColumnModel {
        private Object columnValue;
        private String columnName;
        private String dataField;
        private String suffix = "";
        private Color columnColor;
        private int cellType = Cell.CELL_TYPE_STRING;
        private XSSFCellStyle cellStyle;
        private boolean isDivide100;
        private Map<Object, Object> replaceMap;

        public ColumnModel(String columnName, String dataField) {
            this.columnName = columnName;
            this.dataField = dataField;
        }

        public ColumnModel(String columnName, String dataField, int cellType) {
            this.columnName = columnName;
            this.dataField = dataField;
            this.cellType = cellType;
        }


        public ColumnModel(String columnName, String dataField, String suffix, int cellType) {
            this.columnName = columnName;
            this.dataField = dataField;
            this.suffix = suffix;
            this.cellType = cellType;
        }

        public ColumnModel(String columnName, String dataField, int cellType, XSSFCellStyle cellStyle) {
            this.columnName = columnName;
            this.dataField = dataField;
            this.cellType = cellType;
            this.cellStyle = cellStyle;
        }

        public ColumnModel(String columnName, String dataField, int cellType, XSSFCellStyle cellStyle, boolean isDivide100) {
            this.columnName = columnName;
            this.dataField = dataField;
            this.cellType = cellType;
            this.cellStyle = cellStyle;
            this.isDivide100 = isDivide100;
        }


        public String getColumnName() {
            return columnName;
        }

        public String getDataField() {
            return dataField;
        }

        public Color getColumnColor() {
            return columnColor;
        }

        public int getCellType() {
            return cellType;
        }

        public XSSFCellStyle getCellStyle() {
            return cellStyle;
        }

        public String getSuffix() {
            return suffix;
        }

        public Map<Object, Object> getReplaceMap() {
            return replaceMap;
        }

        public void setReplaceMap(Map<Object, Object> replaceMap) {
            this.replaceMap = replaceMap;
        }

        public boolean isDivide100() {
            return isDivide100;
        }

        public Object getColumnValue() {
            return columnValue;
        }

        public void setColumnValue(Object columnValue) {
            this.columnValue = columnValue;
        }
    }

}
