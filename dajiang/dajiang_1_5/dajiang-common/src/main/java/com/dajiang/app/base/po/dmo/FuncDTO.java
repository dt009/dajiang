package com.dajiang.app.base.po.dmo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FuncDTO implements Serializable {
    private static final long serialVersionUID = -2154673076733216926L;
    private Integer id;
    private String key;
    private String value;
    private String label;
    private Boolean isSelectedAllChild;
    private Integer companyId;
    private Integer parentId;
    private String funcName;
    private String funcType;
    private String funcAction;
    private String funcDesc;
    private Integer displaySequence;
    private String icon;
    private List<FuncDTO> subFuncEntrys;
    private List<FuncDTO> children;
    private List<FuncDTO> buttonList = new ArrayList();

    public FuncDTO() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFuncName() {
        return this.funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncType() {
        return this.funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType;
    }

    public String getFuncAction() {
        return this.funcAction;
    }

    public void setFuncAction(String funcAction) {
        this.funcAction = funcAction;
    }

    public String getFuncDesc() {
        return this.funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public Integer getDisplaySequence() {
        return this.displaySequence;
    }

    public void setDisplaySequence(Integer displaySequence) {
        this.displaySequence = displaySequence;
    }

    public List<FuncDTO> getButtonList() {
        return this.buttonList;
    }

    public void setButtonList(List<FuncDTO> buttonList) {
        this.buttonList = buttonList;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<FuncDTO> getSubFuncEntrys() {
        return this.subFuncEntrys;
    }

    public void setSubFuncEntrys(List<FuncDTO> subFuncEntrys) {
        this.subFuncEntrys = subFuncEntrys;
    }

    public List<FuncDTO> getChildren() {
        return this.children;
    }

    public void setChildren(List<FuncDTO> children) {
        this.children = children;
    }

    public static long getSerialVersionUID() {
        return -2154673076733216926L;
    }

    public Boolean getIsSelectedAllChild() {
        return this.isSelectedAllChild;
    }

    public void setIsSelectedAllChild(Boolean isSelectedAllChild) {
        this.isSelectedAllChild = isSelectedAllChild;
    }
}