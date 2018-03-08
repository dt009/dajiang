package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class InvoiceReqDTO extends BaseDTO {


    private Long userId;

    /**
     * 抬头
     */
    private String invoiceHeader;

    /**
     * 税务登记证号
     */
    private String invoiceTaxNumber;

    /**
     * 发票号码
     */
    private String invoiceCode;

    /**
     * 接收人姓名
     */
    private String invoiceReceiveName;

    /**
     * 发票接收地址
     */
    private String invoiceReceiveAddress;

    /**
     * 发票接收电子邮箱
     */
    private String invoiceReceiveEmail;

    /**
     * 联系人电话
     */
    private String invoiceReceiveTelephone;

    /**
     * 介质 1：纸质发票 ； 2：电子发票
     */
    private Integer invoiceMedium;

    /**
     * 发票申请时间
     */
    private Date invoiceApplyDt;

    private List<Integer> orderIdList;

    private String orderIdListStr;

    /**
     * 获取 t_invoice.user_id
     *
     * @return t_invoice.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 t_invoice.user_id
     *
     * @param userId t_invoice.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 抬头 t_invoice.invoice_header
     *
     * @return 抬头
     */
    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    /**
     * 设置 抬头 t_invoice.invoice_header
     *
     * @param invoiceHeader 抬头
     */
    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader == null ? null : invoiceHeader.trim();
    }

    /**
     * 获取 税务登记证号 t_invoice.invoice_tax_number
     *
     * @return 税务登记证号
     */
    public String getInvoiceTaxNumber() {
        return invoiceTaxNumber;
    }

    /**
     * 设置 税务登记证号 t_invoice.invoice_tax_number
     *
     * @param invoiceTaxNumber 税务登记证号
     */
    public void setInvoiceTaxNumber(String invoiceTaxNumber) {
        this.invoiceTaxNumber = invoiceTaxNumber == null ? null : invoiceTaxNumber.trim();
    }

    /**
     * 获取 发票号码 t_invoice.invoice_code
     *
     * @return 发票号码
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 设置 发票号码 t_invoice.invoice_code
     *
     * @param invoiceCode 发票号码
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    /**
     * 获取 接收人姓名 t_invoice.invoice_receive_name
     *
     * @return 接收人姓名
     */
    public String getInvoiceReceiveName() {
        return invoiceReceiveName;
    }

    /**
     * 设置 接收人姓名 t_invoice.invoice_receive_name
     *
     * @param invoiceReceiveName 接收人姓名
     */
    public void setInvoiceReceiveName(String invoiceReceiveName) {
        this.invoiceReceiveName = invoiceReceiveName == null ? null : invoiceReceiveName.trim();
    }

    /**
     * 获取 发票接收地址 t_invoice.invoice_receive_address
     *
     * @return 发票接收地址
     */
    public String getInvoiceReceiveAddress() {
        return invoiceReceiveAddress;
    }

    /**
     * 设置 发票接收地址 t_invoice.invoice_receive_address
     *
     * @param invoiceReceiveAddress 发票接收地址
     */
    public void setInvoiceReceiveAddress(String invoiceReceiveAddress) {
        this.invoiceReceiveAddress = invoiceReceiveAddress == null ? null : invoiceReceiveAddress.trim();
    }

    /**
     * 获取 发票接收电子邮箱 t_invoice.invoice_receive_email
     *
     * @return 发票接收电子邮箱
     */
    public String getInvoiceReceiveEmail() {
        return invoiceReceiveEmail;
    }

    /**
     * 设置 发票接收电子邮箱 t_invoice.invoice_receive_email
     *
     * @param invoiceReceiveEmail 发票接收电子邮箱
     */
    public void setInvoiceReceiveEmail(String invoiceReceiveEmail) {
        this.invoiceReceiveEmail = invoiceReceiveEmail == null ? null : invoiceReceiveEmail.trim();
    }

    /**
     * 获取 联系人电话 t_invoice.invoice_receive_telephone
     *
     * @return 联系人电话
     */
    public String getInvoiceReceiveTelephone() {
        return invoiceReceiveTelephone;
    }

    /**
     * 设置 联系人电话 t_invoice.invoice_receive_telephone
     *
     * @param invoiceReceiveTelephone 联系人电话
     */
    public void setInvoiceReceiveTelephone(String invoiceReceiveTelephone) {
        this.invoiceReceiveTelephone = invoiceReceiveTelephone == null ? null : invoiceReceiveTelephone.trim();
    }


    /**
     * 获取 介质 1：纸质发票 ； 2：电子发票 t_invoice.invoice_medium
     *
     * @return 介质 1：纸质发票 ； 2：电子发票
     */
    public Integer getInvoiceMedium() {
        return invoiceMedium;
    }

    /**
     * 设置 介质 1：纸质发票 ； 2：电子发票 t_invoice.invoice_medium
     *
     * @param invoiceMedium 介质 1：纸质发票 ； 2：电子发票
     */
    public void setInvoiceMedium(Integer invoiceMedium) {
        this.invoiceMedium = invoiceMedium;
    }

    /**
     * 获取 发票申请时间 t_invoice.invoice_apply_dt
     *
     * @return 发票申请时间
     */
    public Date getInvoiceApplyDt() {
        return invoiceApplyDt;
    }

    /**
     * 设置 发票申请时间 t_invoice.invoice_apply_dt
     *
     * @param invoiceApplyDt 发票申请时间
     */
    public void setInvoiceApplyDt(Date invoiceApplyDt) {
        this.invoiceApplyDt = invoiceApplyDt;
    }


    public List<Integer> getOrderIdList() {
        return orderIdList;
    }

    public void setOrderIdList(List<Integer> orderIdList) {
        this.orderIdList = orderIdList;
    }

    public String getOrderIdListStr() {
        if (orderIdList != null && orderIdList.size() > 0) {
            orderIdListStr = StringUtils.join(orderIdList, "~|~");
        }
        return orderIdListStr;
    }

}
