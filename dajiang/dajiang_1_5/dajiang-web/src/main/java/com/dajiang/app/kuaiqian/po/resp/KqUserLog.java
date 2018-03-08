/* github.com/zhouwd */
package com.dajiang.app.kuaiqian.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * 快钱返回商户日志 t_kq_user_log
 *
 * @author zhouwd code generator
 */
public class KqUserLog extends BaseDTO {
    private Integer kqUserLogId;

    /**
     * 人民币账号:数字串
     * 与提交订单时的快钱账号保持一致
     */
    private String merchantAcctid;

    /**
     * 网关版本:固定值：v2.0
     * 与提交订单时的网关版本号保持一致
     */
    private String version;

    /**
     * 网页显示语言种类:固定选择值：1
     * 1表示快钱支付网关网页是中文显示
     */
    private String language;

    /**
     * 签名类型:固定值：4
     * 与提交订单时的签名类型保持一致
     */
    private String signType;

    /**
     * 支付方式:固定选择值：00、10、11、12、13、14、17、19、21、22
     * 与提交订单时的支付方式保持一致
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     */
    private String payType;

    /**
     * 银行代码:字符串
     * 返回用户在实际支付时所使用的银行代码
     */
    private String bankId;

    /**
     * 与提交订单时的商户订单号保持一致
     */
    private String orderId;

    /**
     * 商户订单提交时间:数字串
     * 与提交订单时的商户订单提交时间保持一致
     */
    private String orderTime;

    /**
     * 商户订单金额:整型数字
     * 以分为单位。比方10元，提交时金额应为1000
     * 与提交订单时的商户订单金额保持一致
     */
    private String orderAmount;

    /**
     * 已绑短卡号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前六后四位信用卡号
     */
    private String bindCard;

    /**
     * 已绑短手机尾号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前三位后四位手机号码
     */
    private String bindMobile;

    /**
     * 快钱交易号:数字串
     * 该交易在快钱系统中对应的交易号
     */
    private String dealId;

    /**
     * 银行交易号:数字串
     * 该交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空
     */
    private String bankDealId;

    /**
     * 快钱交易时间:数字串
     * 快钱对交易进行处理的时间,格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     */
    private String dealTime;

    /**
     * 订单实际支付金额:整型数字
     * 返回在使用优惠券等情况后，用户实际支付的金额
     * 以分为单位。比方10元，提交时金额应为1000
     */
    private String payAmount;

    /**
     * 费用:整型数字
     * 快钱收取商户的手续费，单位为分（CNP支付、快捷支付等非实时结算类交易，通知时值为0）
     */
    private String fee;

    /**
     * 扩展字段1:字符串
     * 与提交订单时的扩展字段1保持一致
     */
    private String ext1;

    /**
     * 扩展字段2:字符串
     * 与提交订单时的扩展字段2保持一致
     */
    private String ext2;

    /**
     * 聚合支付参数:原样返回；商户未传则不返回该字段
     */
    private String aggregatePay;

    /**
     * 处理结果:10：支付成功
     */
    private String payResult;

    /**
     * 错误代码:失败时返回的错误代码，可以为空。
     * 详细资料见下文参考资料。
     */
    private String errCode;

    /**
     * 签名字符串:对于所有值不为空的参数及对应值，按照如上顺序及如下规则组成字符串
     * DSA或RSA方式：参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行快钱证书加密形成密文后进行1024位的Base64转码。
     */
    private String signMsg;

    /**
     * 获取 t_kq_user_log.kq_user_log_id
     *
     * @return t_kq_user_log.kq_user_log_id
     */
    public Integer getKqUserLogId() {
        return kqUserLogId;
    }

    /**
     * 设置 t_kq_user_log.kq_user_log_id
     *
     * @param kqUserLogId t_kq_user_log.kq_user_log_id
     */
    public void setKqUserLogId(Integer kqUserLogId) {
        this.kqUserLogId = kqUserLogId;
    }

    /**
     * 获取 人民币账号:数字串
     * 与提交订单时的快钱账号保持一致
     * t_kq_user_log.merchant_acctId
     *
     * @return 人民币账号:数字串
     * 与提交订单时的快钱账号保持一致
     */
    public String getMerchantAcctid() {
        return merchantAcctid;
    }

    /**
     * 设置 人民币账号:数字串
     * 与提交订单时的快钱账号保持一致
     * t_kq_user_log.merchant_acctId
     *
     * @param merchantAcctid 人民币账号:数字串
     *                       与提交订单时的快钱账号保持一致
     */
    public void setMerchantAcctid(String merchantAcctid) {
        this.merchantAcctid = merchantAcctid == null ? null : merchantAcctid.trim();
    }

    /**
     * 获取 网关版本:固定值：v2.0
     * 与提交订单时的网关版本号保持一致 t_kq_user_log.version
     *
     * @return 网关版本:固定值：v2.0
     * 与提交订单时的网关版本号保持一致
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置 网关版本:固定值：v2.0
     * 与提交订单时的网关版本号保持一致 t_kq_user_log.version
     *
     * @param version 网关版本:固定值：v2.0
     *                与提交订单时的网关版本号保持一致
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 获取 网页显示语言种类:固定选择值：1
     * 1表示快钱支付网关网页是中文显示 t_kq_user_log.language
     *
     * @return 网页显示语言种类:固定选择值：1
     * 1表示快钱支付网关网页是中文显示
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置 网页显示语言种类:固定选择值：1
     * 1表示快钱支付网关网页是中文显示 t_kq_user_log.language
     *
     * @param language 网页显示语言种类:固定选择值：1
     *                 1表示快钱支付网关网页是中文显示
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * 获取 签名类型:固定值：4
     * 与提交订单时的签名类型保持一致
     * t_kq_user_log.sign_type
     *
     * @return 签名类型:固定值：4
     * 与提交订单时的签名类型保持一致
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 设置 签名类型:固定值：4
     * 与提交订单时的签名类型保持一致
     * t_kq_user_log.sign_type
     *
     * @param signType 签名类型:固定值：4
     *                 与提交订单时的签名类型保持一致
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * 获取 支付方式:固定选择值：00、10、11、12、13、14、17、19、21、22
     * 与提交订单时的支付方式保持一致
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     * t_kq_user_log.pay_type
     *
     * @return 支付方式:固定选择值：00、10、11、12、13、14、17、19、21、22
     * 与提交订单时的支付方式保持一致
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置 支付方式:固定选择值：00、10、11、12、13、14、17、19、21、22
     * 与提交订单时的支付方式保持一致
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     * t_kq_user_log.pay_type
     *
     * @param payType 支付方式:固定选择值：00、10、11、12、13、14、17、19、21、22
     *                与提交订单时的支付方式保持一致
     *                25-1表示飞凡通H5、25-2表示飞凡通扫码
     *                26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     *                27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 获取 银行代码:字符串
     * 返回用户在实际支付时所使用的银行代码 t_kq_user_log.bank_id
     *
     * @return 银行代码:字符串
     * 返回用户在实际支付时所使用的银行代码
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * 设置 银行代码:字符串
     * 返回用户在实际支付时所使用的银行代码 t_kq_user_log.bank_id
     *
     * @param bankId 银行代码:字符串
     *               返回用户在实际支付时所使用的银行代码
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    /**
     * 获取 与提交订单时的商户订单号保持一致 t_kq_user_log.order_id
     *
     * @return 与提交订单时的商户订单号保持一致
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置 与提交订单时的商户订单号保持一致 t_kq_user_log.order_id
     *
     * @param orderId 与提交订单时的商户订单号保持一致
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取 商户订单提交时间:数字串
     * 与提交订单时的商户订单提交时间保持一致 t_kq_user_log.order_time
     *
     * @return 商户订单提交时间:数字串
     * 与提交订单时的商户订单提交时间保持一致
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * 设置 商户订单提交时间:数字串
     * 与提交订单时的商户订单提交时间保持一致 t_kq_user_log.order_time
     *
     * @param orderTime 商户订单提交时间:数字串
     *                  与提交订单时的商户订单提交时间保持一致
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    /**
     * 获取 商户订单金额:整型数字
     * 以分为单位。比方10元，提交时金额应为1000
     * 与提交订单时的商户订单金额保持一致 t_kq_user_log.order_amount
     *
     * @return 商户订单金额:整型数字
     * 以分为单位。比方10元，提交时金额应为1000
     * 与提交订单时的商户订单金额保持一致
     */
    public String getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置 商户订单金额:整型数字
     * 以分为单位。比方10元，提交时金额应为1000
     * 与提交订单时的商户订单金额保持一致 t_kq_user_log.order_amount
     *
     * @param orderAmount 商户订单金额:整型数字
     *                    以分为单位。比方10元，提交时金额应为1000
     *                    与提交订单时的商户订单金额保持一致
     */
    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount == null ? null : orderAmount.trim();
    }

    /**
     * 获取 已绑短卡号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前六后四位信用卡号 t_kq_user_log.bind_card
     *
     * @return 已绑短卡号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前六后四位信用卡号
     */
    public String getBindCard() {
        return bindCard;
    }

    /**
     * 设置 已绑短卡号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前六后四位信用卡号 t_kq_user_log.bind_card
     *
     * @param bindCard 已绑短卡号:数字串
     *                 可为空
     *                 信用卡快捷支付绑定卡信息后返回前六后四位信用卡号
     */
    public void setBindCard(String bindCard) {
        this.bindCard = bindCard == null ? null : bindCard.trim();
    }

    /**
     * 获取 已绑短手机尾号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前三位后四位手机号码 t_kq_user_log.bind_mobile
     *
     * @return 已绑短手机尾号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前三位后四位手机号码
     */
    public String getBindMobile() {
        return bindMobile;
    }

    /**
     * 设置 已绑短手机尾号:数字串
     * 可为空
     * 信用卡快捷支付绑定卡信息后返回前三位后四位手机号码 t_kq_user_log.bind_mobile
     *
     * @param bindMobile 已绑短手机尾号:数字串
     *                   可为空
     *                   信用卡快捷支付绑定卡信息后返回前三位后四位手机号码
     */
    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile == null ? null : bindMobile.trim();
    }

    /**
     * 获取 快钱交易号:数字串
     * 该交易在快钱系统中对应的交易号 t_kq_user_log.deal_id
     *
     * @return 快钱交易号:数字串
     * 该交易在快钱系统中对应的交易号
     */
    public String getDealId() {
        return dealId;
    }

    /**
     * 设置 快钱交易号:数字串
     * 该交易在快钱系统中对应的交易号 t_kq_user_log.deal_id
     *
     * @param dealId 快钱交易号:数字串
     *               该交易在快钱系统中对应的交易号
     */
    public void setDealId(String dealId) {
        this.dealId = dealId == null ? null : dealId.trim();
    }

    /**
     * 获取 银行交易号:数字串
     * 该交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空 t_kq_user_log.bank_deal_id
     *
     * @return 银行交易号:数字串
     * 该交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空
     */
    public String getBankDealId() {
        return bankDealId;
    }

    /**
     * 设置 银行交易号:数字串
     * 该交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空 t_kq_user_log.bank_deal_id
     *
     * @param bankDealId 银行交易号:数字串
     *                   该交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空
     */
    public void setBankDealId(String bankDealId) {
        this.bankDealId = bankDealId == null ? null : bankDealId.trim();
    }

    /**
     * 获取 快钱交易时间:数字串
     * 快钱对交易进行处理的时间,格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] t_kq_user_log.deal_time
     *
     * @return 快钱交易时间:数字串
     * 快钱对交易进行处理的时间,格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     */
    public String getDealTime() {
        return dealTime;
    }

    /**
     * 设置 快钱交易时间:数字串
     * 快钱对交易进行处理的时间,格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] t_kq_user_log.deal_time
     *
     * @param dealTime 快钱交易时间:数字串
     *                 快钱对交易进行处理的时间,格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     */
    public void setDealTime(String dealTime) {
        this.dealTime = dealTime == null ? null : dealTime.trim();
    }

    /**
     * 获取 订单实际支付金额:整型数字
     * 返回在使用优惠券等情况后，用户实际支付的金额
     * 以分为单位。比方10元，提交时金额应为1000 t_kq_user_log.pay_amount
     *
     * @return 订单实际支付金额:整型数字
     * 返回在使用优惠券等情况后，用户实际支付的金额
     * 以分为单位。比方10元，提交时金额应为1000
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     * 设置 订单实际支付金额:整型数字
     * 返回在使用优惠券等情况后，用户实际支付的金额
     * 以分为单位。比方10元，提交时金额应为1000 t_kq_user_log.pay_amount
     *
     * @param payAmount 订单实际支付金额:整型数字
     *                  返回在使用优惠券等情况后，用户实际支付的金额
     *                  以分为单位。比方10元，提交时金额应为1000
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount == null ? null : payAmount.trim();
    }

    /**
     * 获取 费用:整型数字
     * 快钱收取商户的手续费，单位为分（CNP支付、快捷支付等非实时结算类交易，通知时值为0）
     * t_kq_user_log.fee
     *
     * @return 费用:整型数字
     * 快钱收取商户的手续费，单位为分（CNP支付、快捷支付等非实时结算类交易，通知时值为0）
     */
    public String getFee() {
        return fee;
    }

    /**
     * 设置 费用:整型数字
     * 快钱收取商户的手续费，单位为分（CNP支付、快捷支付等非实时结算类交易，通知时值为0）
     * t_kq_user_log.fee
     *
     * @param fee 费用:整型数字
     *            快钱收取商户的手续费，单位为分（CNP支付、快捷支付等非实时结算类交易，通知时值为0）
     */
    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
    }

    /**
     * 获取 扩展字段1:字符串
     * 与提交订单时的扩展字段1保持一致
     * t_kq_user_log.ext1
     *
     * @return 扩展字段1:字符串
     * 与提交订单时的扩展字段1保持一致
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置 扩展字段1:字符串
     * 与提交订单时的扩展字段1保持一致
     * t_kq_user_log.ext1
     *
     * @param ext1 扩展字段1:字符串
     *             与提交订单时的扩展字段1保持一致
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 获取 扩展字段2:字符串
     * 与提交订单时的扩展字段2保持一致
     * t_kq_user_log.ext2
     *
     * @return 扩展字段2:字符串
     * 与提交订单时的扩展字段2保持一致
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置 扩展字段2:字符串
     * 与提交订单时的扩展字段2保持一致
     * t_kq_user_log.ext2
     *
     * @param ext2 扩展字段2:字符串
     *             与提交订单时的扩展字段2保持一致
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * 获取 聚合支付参数:原样返回；商户未传则不返回该字段 t_kq_user_log.aggregate_pay
     *
     * @return 聚合支付参数:原样返回；商户未传则不返回该字段
     */
    public String getAggregatePay() {
        return aggregatePay;
    }

    /**
     * 设置 聚合支付参数:原样返回；商户未传则不返回该字段 t_kq_user_log.aggregate_pay
     *
     * @param aggregatePay 聚合支付参数:原样返回；商户未传则不返回该字段
     */
    public void setAggregatePay(String aggregatePay) {
        this.aggregatePay = aggregatePay == null ? null : aggregatePay.trim();
    }

    /**
     * 获取 处理结果:10：支付成功 t_kq_user_log.pay_result
     *
     * @return 处理结果:10：支付成功
     */
    public String getPayResult() {
        return payResult;
    }

    /**
     * 设置 处理结果:10：支付成功 t_kq_user_log.pay_result
     *
     * @param payResult 处理结果:10：支付成功
     */
    public void setPayResult(String payResult) {
        this.payResult = payResult == null ? null : payResult.trim();
    }

    /**
     * 获取 错误代码:失败时返回的错误代码，可以为空。
     * 详细资料见下文参考资料。
     * t_kq_user_log.err_code
     *
     * @return 错误代码:失败时返回的错误代码，可以为空。
     * 详细资料见下文参考资料。
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * 设置 错误代码:失败时返回的错误代码，可以为空。
     * 详细资料见下文参考资料。
     * t_kq_user_log.err_code
     *
     * @param errCode 错误代码:失败时返回的错误代码，可以为空。
     *                详细资料见下文参考资料。
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode == null ? null : errCode.trim();
    }

    /**
     * 获取 签名字符串:对于所有值不为空的参数及对应值，按照如上顺序及如下规则组成字符串
     * DSA或RSA方式：参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行快钱证书加密形成密文后进行1024位的Base64转码。
     * t_kq_user_log.sign_msg
     *
     * @return 签名字符串:对于所有值不为空的参数及对应值，按照如上顺序及如下规则组成字符串
     * DSA或RSA方式：参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行快钱证书加密形成密文后进行1024位的Base64转码。
     */
    public String getSignMsg() {
        return signMsg;
    }

    /**
     * 设置 签名字符串:对于所有值不为空的参数及对应值，按照如上顺序及如下规则组成字符串
     * DSA或RSA方式：参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行快钱证书加密形成密文后进行1024位的Base64转码。
     * t_kq_user_log.sign_msg
     *
     * @param signMsg 签名字符串:对于所有值不为空的参数及对应值，按照如上顺序及如下规则组成字符串
     *                DSA或RSA方式：参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行快钱证书加密形成密文后进行1024位的Base64转码。
     */
    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg == null ? null : signMsg.trim();
    }
}