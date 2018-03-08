/* github.com/zhouwd */
package com.dajiang.app.kuaiqian.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * 商户提交给快钱日志 t_user_kq_log
 *
 * @author zhouwd code generator
 */
public class UserKqLog extends BaseDTO {
    private Integer userKqLogId;

    /**
     * 字符集:  固定选择值：1、2、3
     * 1代表UTF-8; 2代表GBK; 3代表GB2312
     */
    private String inputcharset;

    /**
     * 接受支付结果的页面地址:  需要是绝对地址，与bgUrl不能同时为空
     * 当bgUrl为空时，快钱直接将支付结果GET到pageUrl
     * 当bgUrl不为空时，按照bgUrl的方式返回
     */
    private String pageurl;

    /**
     * 服务器接受支付结果的后台地址:  需要是绝对地址，与pageUrl不能同时为空
     * 快钱将支付结果发送到bgUrl对应的地址，并且获取商户按照约定格式输出的地址，显示页面给用户
     */
    private String bgurl;

    /**
     * 网关版本: 固定值：mobile1.0
     * 注意为小写字母
     * 移动网关：mobile1.0
     */
    private String version;

    /**
     * 移动网关版本，当version= mobile1.0时有效
     * phone代表手机版移动网关，pad代表平板移动网关，默认为phone
     */
    private String mobilegateway;

    /**
     * 网关页面显示语言种类  固定值：1
     * 1代表中文显示
     */
    private String language;

    /**
     * 签名类型   4代表DSA或者RSA签名方式
     */
    private String signtype;

    /**
     * 人民币账号    数字串
     * 本参数用来指定接收款项的人民币账号
     */
    private String merchantacctid;

    /**
     * 支付人姓名    英文或中文字符
     */
    private String payername;

    /**
     * 支付人联系方式类型:  固定值：1或者2
     * 1代表电子邮件方式；2代表手机联系方式
     */
    private String payercontacttype;

    /**
     * 支付人联系方式: 字符串
     * 根据payerContactType的方式填写对应字符，邮箱或者手机号码
     */
    private String payercontact;

    /**
     * 指定付款人:数字串
     * 类型固定值0，1，2，3
     * 0代表不指定
     * 1代表通过商户方ID指定付款人
     * 2代表通过快钱账户指定付款人
     * 3 代表付款方在商户方的会员编号(当需要支持保存信息功能的快捷支付时，,需上送此项)
     * 4代表企业网银的交通银行直连
     * 如果为空代表不需要指定
     */
    private String payeridtype;

    /**
     * 付款人标识:字符串
     * 当企业网银中的交通银行直连，此值不能为空。此参数需要传入交行企业网银的付款方银行账号
     * 当需要支持保存信息功能的快捷支付时，此值不能为空，此参数需要传入付款方在商户方的会员编号
     */
    private String payerid;

    /**
     * 付款人IP:付款人IP，商家传递获取到的客户端IP
     */
    private String payerip;

    /**
     * 商户订单号:字符串
     * 只允许使用字母、数字、- 、_,并以字母或数字开头
     * 每商户提交的订单号，必须在自身账户交易中唯一
     */
    private String orderid;

    /**
     * 商户订单金额:整型数字以分为单位。比方10元，提交时金额应为1000,商户页面显示金额可以转换成以元为单位显示
     */
    private String orderamount;

    /**
     * 商户订单提交时间:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101
     */
    private String ordertime;

    /**
     * 快钱时间戳:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101
     */
    private String ordertimestamp;

    /**
     * 商品名称:英文或中文字符串
     * 聚合支付参数aggregatePay不为空时，必填
     */
    private String productname;

    /**
     * 商品数量:整型数字
     */
    private Integer productnum;

    /**
     * 商品代码:字母、数字或 - 、_ 的组合
     * 如商户发布了优惠券，并只想对指定的某商品或某类商品进行优惠时，请将此参数与发布优惠券时设置的“适用商品”保持一致。只可填写一个代码。
     * 如果不使用优惠券，本参数不用填写
     */
    private String productid;

    /**
     * 商品描述:英文或中文字符串
     */
    private String productdesc;

    /**
     * 扩展字段1:英文或中文字符串
     * 支付完成后，按照原样返回给商户
     */
    private String ext1;

    /**
     * 英文或中文字符串
     * 支付完成后，按照原样返回给商户
     */
    private String ext2;

    /**
     * 聚合支付参数:26-1:[appId=123213,openId=8989,limitPay=0];
     * 25-1:[appId=123213]
     * 参数说明见2.4.5
     */
    private String aggregatepay;

    /**
     * 支付方式:固定选择值：00、21、21-1、21-2
     * 00代表显示快钱各支付方式列表；
     * 21 快捷支付
     * 21-1 代表储蓄卡快捷；21-2 代表信用卡快捷
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     * 其中”-”只允许在半角状态下输入
     */
    private String paytype;

    /**
     * 银行代码:银行的代码，仅在银行直连/快捷支付指定银行定制时使用。
     * 快捷支付指定银行定制:payType=21-1,21-2
     * 无卡支持指定银行定制:payType=15
     * 银行代码表见本文档3.2章节;
     * 指定银行定制默认开通.
     */
    private String bankid;

    /**
     * 发卡机构:字符串，固定值
     */
    private String cardissuer;

    /**
     * 卡号:整形数字
     * 提交给快钱的支付卡号
     */
    private String cardnum;

    /**
     * 同一订单禁止重复提交标志:固定选择值： 1、0
     * 1代表同一订单号只允许提交1次；0表示同一订单号在没有支付成功的前提下可重复提交多次。
     * 默认为0
     * 建议实物购物车结算类商户采用0；虚拟产品类商户采用1；
     */
    private String redoflag;

    /**
     * 提交方式:00:代表前台提交01：代表后台提交
     * 为空默认为前台提交。
     */
    private String submittype;

    /**
     * 正整数,0~ 2592000（30天）
     * 单位为秒
     * 默认为空，为空表示订单无超时时间
     * 订单超时计算规则：订单支付成功时间 减去订单提交时间（orderTime） 大于 订单超时时间（orderTimeOut）
     * 超时成功订单，快钱会自动发起退款。
     */
    private String ordertimeout;

    /**
     * 附加信息类型:字符串
     */
    private String extdatatype;

    /**
     * 附加信息:XML格式
     */
    private String extdatacontent;

    /**
     * 签名字符串:参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行商户私钥证书加密形成密文后进行1024位的Base64转码。
     */
    private String signmsg;

    /**
     * 参考交易信息类型:数字字符串
     * 3位交易的行业类型+3位版本号
     * 详见风险交易参考信息规则文档
     */
    private String referdatatype;

    /**
     * 参考交易信息:字符串(XML或其他格式)
     * 用于交易风险控制的交易参考信息
     * 商户可以选择不同版本的参考信息规则
     * 详见风险交易参考信息规则文档
     */
    private String referdata;

    /**
     * 获取 t_user_kq_log.user_kq_log_id
     *
     * @return t_user_kq_log.user_kq_log_id
     */
    public Integer getUserKqLogId() {
        return userKqLogId;
    }

    /**
     * 设置 t_user_kq_log.user_kq_log_id
     *
     * @param userKqLogId t_user_kq_log.user_kq_log_id
     */
    public void setUserKqLogId(Integer userKqLogId) {
        this.userKqLogId = userKqLogId;
    }

    /**
     * 获取 字符集:  固定选择值：1、2、3
     * 1代表UTF-8; 2代表GBK; 3代表GB2312 t_user_kq_log.inputCharset
     *
     * @return 字符集:  固定选择值：1、2、3
     * 1代表UTF-8; 2代表GBK; 3代表GB2312
     */
    public String getInputcharset() {
        return inputcharset;
    }

    /**
     * 设置 字符集:  固定选择值：1、2、3
     * 1代表UTF-8; 2代表GBK; 3代表GB2312 t_user_kq_log.inputCharset
     *
     * @param inputcharset 字符集:  固定选择值：1、2、3
     *                     1代表UTF-8; 2代表GBK; 3代表GB2312
     */
    public void setInputcharset(String inputcharset) {
        this.inputcharset = inputcharset == null ? null : inputcharset.trim();
    }

    /**
     * 获取 接受支付结果的页面地址:  需要是绝对地址，与bgUrl不能同时为空
     * 当bgUrl为空时，快钱直接将支付结果GET到pageUrl
     * 当bgUrl不为空时，按照bgUrl的方式返回
     * t_user_kq_log.pageUrl
     *
     * @return 接受支付结果的页面地址:  需要是绝对地址，与bgUrl不能同时为空
     * 当bgUrl为空时，快钱直接将支付结果GET到pageUrl
     * 当bgUrl不为空时，按照bgUrl的方式返回
     */
    public String getPageurl() {
        return pageurl;
    }

    /**
     * 设置 接受支付结果的页面地址:  需要是绝对地址，与bgUrl不能同时为空
     * 当bgUrl为空时，快钱直接将支付结果GET到pageUrl
     * 当bgUrl不为空时，按照bgUrl的方式返回
     * t_user_kq_log.pageUrl
     *
     * @param pageurl 接受支付结果的页面地址:  需要是绝对地址，与bgUrl不能同时为空
     *                当bgUrl为空时，快钱直接将支付结果GET到pageUrl
     *                当bgUrl不为空时，按照bgUrl的方式返回
     */
    public void setPageurl(String pageurl) {
        this.pageurl = pageurl == null ? null : pageurl.trim();
    }

    /**
     * 获取 服务器接受支付结果的后台地址:  需要是绝对地址，与pageUrl不能同时为空
     * 快钱将支付结果发送到bgUrl对应的地址，并且获取商户按照约定格式输出的地址，显示页面给用户 t_user_kq_log.bgUrl
     *
     * @return 服务器接受支付结果的后台地址:  需要是绝对地址，与pageUrl不能同时为空
     * 快钱将支付结果发送到bgUrl对应的地址，并且获取商户按照约定格式输出的地址，显示页面给用户
     */
    public String getBgurl() {
        return bgurl;
    }

    /**
     * 设置 服务器接受支付结果的后台地址:  需要是绝对地址，与pageUrl不能同时为空
     * 快钱将支付结果发送到bgUrl对应的地址，并且获取商户按照约定格式输出的地址，显示页面给用户 t_user_kq_log.bgUrl
     *
     * @param bgurl 服务器接受支付结果的后台地址:  需要是绝对地址，与pageUrl不能同时为空
     *              快钱将支付结果发送到bgUrl对应的地址，并且获取商户按照约定格式输出的地址，显示页面给用户
     */
    public void setBgurl(String bgurl) {
        this.bgurl = bgurl == null ? null : bgurl.trim();
    }

    /**
     * 获取 网关版本: 固定值：mobile1.0
     * 注意为小写字母
     * 移动网关：mobile1.0 t_user_kq_log.version
     *
     * @return 网关版本: 固定值：mobile1.0
     * 注意为小写字母
     * 移动网关：mobile1.0
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置 网关版本: 固定值：mobile1.0
     * 注意为小写字母
     * 移动网关：mobile1.0 t_user_kq_log.version
     *
     * @param version 网关版本: 固定值：mobile1.0
     *                注意为小写字母
     *                移动网关：mobile1.0
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 获取 移动网关版本，当version= mobile1.0时有效
     * phone代表手机版移动网关，pad代表平板移动网关，默认为phone t_user_kq_log.mobileGateway
     *
     * @return 移动网关版本，当version= mobile1.0时有效
     * phone代表手机版移动网关，pad代表平板移动网关，默认为phone
     */
    public String getMobilegateway() {
        return mobilegateway;
    }

    /**
     * 设置 移动网关版本，当version= mobile1.0时有效
     * phone代表手机版移动网关，pad代表平板移动网关，默认为phone t_user_kq_log.mobileGateway
     *
     * @param mobilegateway 移动网关版本，当version= mobile1.0时有效
     *                      phone代表手机版移动网关，pad代表平板移动网关，默认为phone
     */
    public void setMobilegateway(String mobilegateway) {
        this.mobilegateway = mobilegateway == null ? null : mobilegateway.trim();
    }

    /**
     * 获取 网关页面显示语言种类  固定值：1
     * 1代表中文显示 t_user_kq_log.language
     *
     * @return 网关页面显示语言种类  固定值：1
     * 1代表中文显示
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置 网关页面显示语言种类  固定值：1
     * 1代表中文显示 t_user_kq_log.language
     *
     * @param language 网关页面显示语言种类  固定值：1
     *                 1代表中文显示
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * 获取 签名类型   4代表DSA或者RSA签名方式 t_user_kq_log.signType
     *
     * @return 签名类型   4代表DSA或者RSA签名方式
     */
    public String getSigntype() {
        return signtype;
    }

    /**
     * 设置 签名类型   4代表DSA或者RSA签名方式 t_user_kq_log.signType
     *
     * @param signtype 签名类型   4代表DSA或者RSA签名方式
     */
    public void setSigntype(String signtype) {
        this.signtype = signtype == null ? null : signtype.trim();
    }

    /**
     * 获取 人民币账号    数字串
     * 本参数用来指定接收款项的人民币账号 t_user_kq_log.merchantAcctId
     *
     * @return 人民币账号    数字串
     * 本参数用来指定接收款项的人民币账号
     */
    public String getMerchantacctid() {
        return merchantacctid;
    }

    /**
     * 设置 人民币账号    数字串
     * 本参数用来指定接收款项的人民币账号 t_user_kq_log.merchantAcctId
     *
     * @param merchantacctid 人民币账号    数字串
     *                       本参数用来指定接收款项的人民币账号
     */
    public void setMerchantacctid(String merchantacctid) {
        this.merchantacctid = merchantacctid == null ? null : merchantacctid.trim();
    }

    /**
     * 获取 支付人姓名    英文或中文字符 t_user_kq_log.payerName
     *
     * @return 支付人姓名    英文或中文字符
     */
    public String getPayername() {
        return payername;
    }

    /**
     * 设置 支付人姓名    英文或中文字符 t_user_kq_log.payerName
     *
     * @param payername 支付人姓名    英文或中文字符
     */
    public void setPayername(String payername) {
        this.payername = payername == null ? null : payername.trim();
    }

    /**
     * 获取 支付人联系方式类型:  固定值：1或者2
     * 1代表电子邮件方式；2代表手机联系方式
     * t_user_kq_log.payerContactType
     *
     * @return 支付人联系方式类型:  固定值：1或者2
     * 1代表电子邮件方式；2代表手机联系方式
     */
    public String getPayercontacttype() {
        return payercontacttype;
    }

    /**
     * 设置 支付人联系方式类型:  固定值：1或者2
     * 1代表电子邮件方式；2代表手机联系方式
     * t_user_kq_log.payerContactType
     *
     * @param payercontacttype 支付人联系方式类型:  固定值：1或者2
     *                         1代表电子邮件方式；2代表手机联系方式
     */
    public void setPayercontacttype(String payercontacttype) {
        this.payercontacttype = payercontacttype == null ? null : payercontacttype.trim();
    }

    /**
     * 获取 支付人联系方式: 字符串
     * 根据payerContactType的方式填写对应字符，邮箱或者手机号码
     * t_user_kq_log.payerContact
     *
     * @return 支付人联系方式: 字符串
     * 根据payerContactType的方式填写对应字符，邮箱或者手机号码
     */
    public String getPayercontact() {
        return payercontact;
    }

    /**
     * 设置 支付人联系方式: 字符串
     * 根据payerContactType的方式填写对应字符，邮箱或者手机号码
     * t_user_kq_log.payerContact
     *
     * @param payercontact 支付人联系方式: 字符串
     *                     根据payerContactType的方式填写对应字符，邮箱或者手机号码
     */
    public void setPayercontact(String payercontact) {
        this.payercontact = payercontact == null ? null : payercontact.trim();
    }

    /**
     * 获取 指定付款人:数字串
     * 类型固定值0，1，2，3
     * 0代表不指定
     * 1代表通过商户方ID指定付款人
     * 2代表通过快钱账户指定付款人
     * 3 代表付款方在商户方的会员编号(当需要支持保存信息功能的快捷支付时，,需上送此项)
     * 4代表企业网银的交通银行直连
     * 如果为空代表不需要指定
     * t_user_kq_log.payerIdType
     *
     * @return 指定付款人:数字串
     * 类型固定值0，1，2，3
     * 0代表不指定
     * 1代表通过商户方ID指定付款人
     * 2代表通过快钱账户指定付款人
     * 3 代表付款方在商户方的会员编号(当需要支持保存信息功能的快捷支付时，,需上送此项)
     * 4代表企业网银的交通银行直连
     * 如果为空代表不需要指定
     */
    public String getPayeridtype() {
        return payeridtype;
    }

    /**
     * 设置 指定付款人:数字串
     * 类型固定值0，1，2，3
     * 0代表不指定
     * 1代表通过商户方ID指定付款人
     * 2代表通过快钱账户指定付款人
     * 3 代表付款方在商户方的会员编号(当需要支持保存信息功能的快捷支付时，,需上送此项)
     * 4代表企业网银的交通银行直连
     * 如果为空代表不需要指定
     * t_user_kq_log.payerIdType
     *
     * @param payeridtype 指定付款人:数字串
     *                    类型固定值0，1，2，3
     *                    0代表不指定
     *                    1代表通过商户方ID指定付款人
     *                    2代表通过快钱账户指定付款人
     *                    3 代表付款方在商户方的会员编号(当需要支持保存信息功能的快捷支付时，,需上送此项)
     *                    4代表企业网银的交通银行直连
     *                    如果为空代表不需要指定
     */
    public void setPayeridtype(String payeridtype) {
        this.payeridtype = payeridtype == null ? null : payeridtype.trim();
    }

    /**
     * 获取 付款人标识:字符串
     * 当企业网银中的交通银行直连，此值不能为空。此参数需要传入交行企业网银的付款方银行账号
     * 当需要支持保存信息功能的快捷支付时，此值不能为空，此参数需要传入付款方在商户方的会员编号
     * t_user_kq_log.payerId
     *
     * @return 付款人标识:字符串
     * 当企业网银中的交通银行直连，此值不能为空。此参数需要传入交行企业网银的付款方银行账号
     * 当需要支持保存信息功能的快捷支付时，此值不能为空，此参数需要传入付款方在商户方的会员编号
     */
    public String getPayerid() {
        return payerid;
    }

    /**
     * 设置 付款人标识:字符串
     * 当企业网银中的交通银行直连，此值不能为空。此参数需要传入交行企业网银的付款方银行账号
     * 当需要支持保存信息功能的快捷支付时，此值不能为空，此参数需要传入付款方在商户方的会员编号
     * t_user_kq_log.payerId
     *
     * @param payerid 付款人标识:字符串
     *                当企业网银中的交通银行直连，此值不能为空。此参数需要传入交行企业网银的付款方银行账号
     *                当需要支持保存信息功能的快捷支付时，此值不能为空，此参数需要传入付款方在商户方的会员编号
     */
    public void setPayerid(String payerid) {
        this.payerid = payerid == null ? null : payerid.trim();
    }

    /**
     * 获取 付款人IP:付款人IP，商家传递获取到的客户端IP t_user_kq_log.payerIP
     *
     * @return 付款人IP:付款人IP，商家传递获取到的客户端IP
     */
    public String getPayerip() {
        return payerip;
    }

    /**
     * 设置 付款人IP:付款人IP，商家传递获取到的客户端IP t_user_kq_log.payerIP
     *
     * @param payerip 付款人IP:付款人IP，商家传递获取到的客户端IP
     */
    public void setPayerip(String payerip) {
        this.payerip = payerip == null ? null : payerip.trim();
    }

    /**
     * 获取 商户订单号:字符串
     * 只允许使用字母、数字、- 、_,并以字母或数字开头
     * 每商户提交的订单号，必须在自身账户交易中唯一 t_user_kq_log.orderId
     *
     * @return 商户订单号:字符串
     * 只允许使用字母、数字、- 、_,并以字母或数字开头
     * 每商户提交的订单号，必须在自身账户交易中唯一
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * 设置 商户订单号:字符串
     * 只允许使用字母、数字、- 、_,并以字母或数字开头
     * 每商户提交的订单号，必须在自身账户交易中唯一 t_user_kq_log.orderId
     *
     * @param orderid 商户订单号:字符串
     *                只允许使用字母、数字、- 、_,并以字母或数字开头
     *                每商户提交的订单号，必须在自身账户交易中唯一
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * 获取 商户订单金额:整型数字以分为单位。比方10元，提交时金额应为1000,商户页面显示金额可以转换成以元为单位显示 t_user_kq_log.orderAmount
     *
     * @return 商户订单金额:整型数字以分为单位。比方10元，提交时金额应为1000,商户页面显示金额可以转换成以元为单位显示
     */
    public String getOrderamount() {
        return orderamount;
    }

    /**
     * 设置 商户订单金额:整型数字以分为单位。比方10元，提交时金额应为1000,商户页面显示金额可以转换成以元为单位显示 t_user_kq_log.orderAmount
     *
     * @param orderamount 商户订单金额:整型数字以分为单位。比方10元，提交时金额应为1000,商户页面显示金额可以转换成以元为单位显示
     */
    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount == null ? null : orderamount.trim();
    }

    /**
     * 获取 商户订单提交时间:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101
     * t_user_kq_log.orderTime
     *
     * @return 商户订单提交时间:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101
     */
    public String getOrdertime() {
        return ordertime;
    }

    /**
     * 设置 商户订单提交时间:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101
     * t_user_kq_log.orderTime
     *
     * @param ordertime 商户订单提交时间:数字串，一共14位
     *                  格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     *                  例如：20071117020101
     */
    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    /**
     * 获取 快钱时间戳:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101 t_user_kq_log.orderTimestamp
     *
     * @return 快钱时间戳:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101
     */
    public String getOrdertimestamp() {
        return ordertimestamp;
    }

    /**
     * 设置 快钱时间戳:数字串，一共14位
     * 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     * 例如：20071117020101 t_user_kq_log.orderTimestamp
     *
     * @param ordertimestamp 快钱时间戳:数字串，一共14位
     *                       格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
     *                       例如：20071117020101
     */
    public void setOrdertimestamp(String ordertimestamp) {
        this.ordertimestamp = ordertimestamp == null ? null : ordertimestamp.trim();
    }

    /**
     * 获取 商品名称:英文或中文字符串
     * 聚合支付参数aggregatePay不为空时，必填
     * t_user_kq_log.productName
     *
     * @return 商品名称:英文或中文字符串
     * 聚合支付参数aggregatePay不为空时，必填
     */
    public String getProductname() {
        return productname;
    }

    /**
     * 设置 商品名称:英文或中文字符串
     * 聚合支付参数aggregatePay不为空时，必填
     * t_user_kq_log.productName
     *
     * @param productname 商品名称:英文或中文字符串
     *                    聚合支付参数aggregatePay不为空时，必填
     */
    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    /**
     * 获取 商品数量:整型数字 t_user_kq_log.productNum
     *
     * @return 商品数量:整型数字
     */
    public Integer getProductnum() {
        return productnum;
    }

    /**
     * 设置 商品数量:整型数字 t_user_kq_log.productNum
     *
     * @param productnum 商品数量:整型数字
     */
    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    /**
     * 获取 商品代码:字母、数字或 - 、_ 的组合
     * 如商户发布了优惠券，并只想对指定的某商品或某类商品进行优惠时，请将此参数与发布优惠券时设置的“适用商品”保持一致。只可填写一个代码。
     * 如果不使用优惠券，本参数不用填写
     * t_user_kq_log.productId
     *
     * @return 商品代码:字母、数字或 - 、_ 的组合
     * 如商户发布了优惠券，并只想对指定的某商品或某类商品进行优惠时，请将此参数与发布优惠券时设置的“适用商品”保持一致。只可填写一个代码。
     * 如果不使用优惠券，本参数不用填写
     */
    public String getProductid() {
        return productid;
    }

    /**
     * 设置 商品代码:字母、数字或 - 、_ 的组合
     * 如商户发布了优惠券，并只想对指定的某商品或某类商品进行优惠时，请将此参数与发布优惠券时设置的“适用商品”保持一致。只可填写一个代码。
     * 如果不使用优惠券，本参数不用填写
     * t_user_kq_log.productId
     *
     * @param productid 商品代码:字母、数字或 - 、_ 的组合
     *                  如商户发布了优惠券，并只想对指定的某商品或某类商品进行优惠时，请将此参数与发布优惠券时设置的“适用商品”保持一致。只可填写一个代码。
     *                  如果不使用优惠券，本参数不用填写
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * 获取 商品描述:英文或中文字符串 t_user_kq_log.productDesc
     *
     * @return 商品描述:英文或中文字符串
     */
    public String getProductdesc() {
        return productdesc;
    }

    /**
     * 设置 商品描述:英文或中文字符串 t_user_kq_log.productDesc
     *
     * @param productdesc 商品描述:英文或中文字符串
     */
    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc == null ? null : productdesc.trim();
    }

    /**
     * 获取 扩展字段1:英文或中文字符串
     * 支付完成后，按照原样返回给商户
     * t_user_kq_log.ext1
     *
     * @return 扩展字段1:英文或中文字符串
     * 支付完成后，按照原样返回给商户
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置 扩展字段1:英文或中文字符串
     * 支付完成后，按照原样返回给商户
     * t_user_kq_log.ext1
     *
     * @param ext1 扩展字段1:英文或中文字符串
     *             支付完成后，按照原样返回给商户
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 获取 英文或中文字符串
     * 支付完成后，按照原样返回给商户 t_user_kq_log.ext2
     *
     * @return 英文或中文字符串
     * 支付完成后，按照原样返回给商户
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置 英文或中文字符串
     * 支付完成后，按照原样返回给商户 t_user_kq_log.ext2
     *
     * @param ext2 英文或中文字符串
     *             支付完成后，按照原样返回给商户
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * 获取 聚合支付参数:26-1:[appId=123213,openId=8989,limitPay=0];
     * 25-1:[appId=123213]
     * 参数说明见2.4.5
     * t_user_kq_log.aggregatePay
     *
     * @return 聚合支付参数:26-1:[appId=123213,openId=8989,limitPay=0];
     * 25-1:[appId=123213]
     * 参数说明见2.4.5
     */
    public String getAggregatepay() {
        return aggregatepay;
    }

    /**
     * 设置 聚合支付参数:26-1:[appId=123213,openId=8989,limitPay=0];
     * 25-1:[appId=123213]
     * 参数说明见2.4.5
     * t_user_kq_log.aggregatePay
     *
     * @param aggregatepay 聚合支付参数:26-1:[appId=123213,openId=8989,limitPay=0];
     *                     25-1:[appId=123213]
     *                     参数说明见2.4.5
     */
    public void setAggregatepay(String aggregatepay) {
        this.aggregatepay = aggregatepay == null ? null : aggregatepay.trim();
    }

    /**
     * 获取 支付方式:固定选择值：00、21、21-1、21-2
     * 00代表显示快钱各支付方式列表；
     * 21 快捷支付
     * 21-1 代表储蓄卡快捷；21-2 代表信用卡快捷
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     * 其中”-”只允许在半角状态下输入
     * t_user_kq_log.payType
     *
     * @return 支付方式:固定选择值：00、21、21-1、21-2
     * 00代表显示快钱各支付方式列表；
     * 21 快捷支付
     * 21-1 代表储蓄卡快捷；21-2 代表信用卡快捷
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     * 其中”-”只允许在半角状态下输入
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * 设置 支付方式:固定选择值：00、21、21-1、21-2
     * 00代表显示快钱各支付方式列表；
     * 21 快捷支付
     * 21-1 代表储蓄卡快捷；21-2 代表信用卡快捷
     * 25-1表示飞凡通H5、25-2表示飞凡通扫码
     * 26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     * 27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     * 其中”-”只允许在半角状态下输入
     * t_user_kq_log.payType
     *
     * @param paytype 支付方式:固定选择值：00、21、21-1、21-2
     *                00代表显示快钱各支付方式列表；
     *                21 快捷支付
     *                21-1 代表储蓄卡快捷；21-2 代表信用卡快捷
     *                25-1表示飞凡通H5、25-2表示飞凡通扫码
     *                26-1表示微信公众号支付、26-2表示微信WAP、26-3表示微信扫码
     *                27-1表示支付宝服务窗、27-2表示支付宝WAP、27-3表示支付宝扫码
     *                其中”-”只允许在半角状态下输入
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    /**
     * 获取 银行代码:银行的代码，仅在银行直连/快捷支付指定银行定制时使用。
     * 快捷支付指定银行定制:payType=21-1,21-2
     * 无卡支持指定银行定制:payType=15
     * 银行代码表见本文档3.2章节;
     * 指定银行定制默认开通.
     * t_user_kq_log.bankId
     *
     * @return 银行代码:银行的代码，仅在银行直连/快捷支付指定银行定制时使用。
     * 快捷支付指定银行定制:payType=21-1,21-2
     * 无卡支持指定银行定制:payType=15
     * 银行代码表见本文档3.2章节;
     * 指定银行定制默认开通.
     */
    public String getBankid() {
        return bankid;
    }

    /**
     * 设置 银行代码:银行的代码，仅在银行直连/快捷支付指定银行定制时使用。
     * 快捷支付指定银行定制:payType=21-1,21-2
     * 无卡支持指定银行定制:payType=15
     * 银行代码表见本文档3.2章节;
     * 指定银行定制默认开通.
     * t_user_kq_log.bankId
     *
     * @param bankid 银行代码:银行的代码，仅在银行直连/快捷支付指定银行定制时使用。
     *               快捷支付指定银行定制:payType=21-1,21-2
     *               无卡支持指定银行定制:payType=15
     *               银行代码表见本文档3.2章节;
     *               指定银行定制默认开通.
     */
    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    /**
     * 获取 发卡机构:字符串，固定值 t_user_kq_log.cardIssuer
     *
     * @return 发卡机构:字符串，固定值
     */
    public String getCardissuer() {
        return cardissuer;
    }

    /**
     * 设置 发卡机构:字符串，固定值 t_user_kq_log.cardIssuer
     *
     * @param cardissuer 发卡机构:字符串，固定值
     */
    public void setCardissuer(String cardissuer) {
        this.cardissuer = cardissuer == null ? null : cardissuer.trim();
    }

    /**
     * 获取 卡号:整形数字
     * 提交给快钱的支付卡号 t_user_kq_log.cardNum
     *
     * @return 卡号:整形数字
     * 提交给快钱的支付卡号
     */
    public String getCardnum() {
        return cardnum;
    }

    /**
     * 设置 卡号:整形数字
     * 提交给快钱的支付卡号 t_user_kq_log.cardNum
     *
     * @param cardnum 卡号:整形数字
     *                提交给快钱的支付卡号
     */
    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    /**
     * 获取 同一订单禁止重复提交标志:固定选择值： 1、0
     * 1代表同一订单号只允许提交1次；0表示同一订单号在没有支付成功的前提下可重复提交多次。
     * 默认为0
     * 建议实物购物车结算类商户采用0；虚拟产品类商户采用1；
     * t_user_kq_log.redoFlag
     *
     * @return 同一订单禁止重复提交标志:固定选择值： 1、0
     * 1代表同一订单号只允许提交1次；0表示同一订单号在没有支付成功的前提下可重复提交多次。
     * 默认为0
     * 建议实物购物车结算类商户采用0；虚拟产品类商户采用1；
     */
    public String getRedoflag() {
        return redoflag;
    }

    /**
     * 设置 同一订单禁止重复提交标志:固定选择值： 1、0
     * 1代表同一订单号只允许提交1次；0表示同一订单号在没有支付成功的前提下可重复提交多次。
     * 默认为0
     * 建议实物购物车结算类商户采用0；虚拟产品类商户采用1；
     * t_user_kq_log.redoFlag
     *
     * @param redoflag 同一订单禁止重复提交标志:固定选择值： 1、0
     *                 1代表同一订单号只允许提交1次；0表示同一订单号在没有支付成功的前提下可重复提交多次。
     *                 默认为0
     *                 建议实物购物车结算类商户采用0；虚拟产品类商户采用1；
     */
    public void setRedoflag(String redoflag) {
        this.redoflag = redoflag == null ? null : redoflag.trim();
    }

    /**
     * 获取 提交方式:00:代表前台提交01：代表后台提交
     * 为空默认为前台提交。 t_user_kq_log.submitType
     *
     * @return 提交方式:00:代表前台提交01：代表后台提交
     * 为空默认为前台提交。
     */
    public String getSubmittype() {
        return submittype;
    }

    /**
     * 设置 提交方式:00:代表前台提交01：代表后台提交
     * 为空默认为前台提交。 t_user_kq_log.submitType
     *
     * @param submittype 提交方式:00:代表前台提交01：代表后台提交
     *                   为空默认为前台提交。
     */
    public void setSubmittype(String submittype) {
        this.submittype = submittype == null ? null : submittype.trim();
    }

    /**
     * 获取 正整数,0~ 2592000（30天）
     * 单位为秒
     * 默认为空，为空表示订单无超时时间
     * 订单超时计算规则：订单支付成功时间 减去订单提交时间（orderTime） 大于 订单超时时间（orderTimeOut）
     * 超时成功订单，快钱会自动发起退款。
     * t_user_kq_log.orderTimeOut
     *
     * @return 正整数, 0~ 2592000（30天）
     * 单位为秒
     * 默认为空，为空表示订单无超时时间
     * 订单超时计算规则：订单支付成功时间 减去订单提交时间（orderTime） 大于 订单超时时间（orderTimeOut）
     * 超时成功订单，快钱会自动发起退款。
     */
    public String getOrdertimeout() {
        return ordertimeout;
    }

    /**
     * 设置 正整数,0~ 2592000（30天）
     * 单位为秒
     * 默认为空，为空表示订单无超时时间
     * 订单超时计算规则：订单支付成功时间 减去订单提交时间（orderTime） 大于 订单超时时间（orderTimeOut）
     * 超时成功订单，快钱会自动发起退款。
     * t_user_kq_log.orderTimeOut
     *
     * @param ordertimeout 正整数,0~ 2592000（30天）
     *                     单位为秒
     *                     默认为空，为空表示订单无超时时间
     *                     订单超时计算规则：订单支付成功时间 减去订单提交时间（orderTime） 大于 订单超时时间（orderTimeOut）
     *                     超时成功订单，快钱会自动发起退款。
     */
    public void setOrdertimeout(String ordertimeout) {
        this.ordertimeout = ordertimeout == null ? null : ordertimeout.trim();
    }

    /**
     * 获取 附加信息类型:字符串 t_user_kq_log.extDataType
     *
     * @return 附加信息类型:字符串
     */
    public String getExtdatatype() {
        return extdatatype;
    }

    /**
     * 设置 附加信息类型:字符串 t_user_kq_log.extDataType
     *
     * @param extdatatype 附加信息类型:字符串
     */
    public void setExtdatatype(String extdatatype) {
        this.extdatatype = extdatatype == null ? null : extdatatype.trim();
    }

    /**
     * 获取 附加信息:XML格式 t_user_kq_log.extDataContent
     *
     * @return 附加信息:XML格式
     */
    public String getExtdatacontent() {
        return extdatacontent;
    }

    /**
     * 设置 附加信息:XML格式 t_user_kq_log.extDataContent
     *
     * @param extdatacontent 附加信息:XML格式
     */
    public void setExtdatacontent(String extdatacontent) {
        this.extdatacontent = extdatacontent == null ? null : extdatacontent.trim();
    }

    /**
     * 获取 签名字符串:参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行商户私钥证书加密形成密文后进行1024位的Base64转码。 t_user_kq_log.signMsg
     *
     * @return 签名字符串:参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行商户私钥证书加密形成密文后进行1024位的Base64转码。
     */
    public String getSignmsg() {
        return signmsg;
    }

    /**
     * 设置 签名字符串:参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行商户私钥证书加密形成密文后进行1024位的Base64转码。 t_user_kq_log.signMsg
     *
     * @param signmsg 签名字符串:参数1={参数1}&参数2={参数2}&……&参数n={参数n}然后进行商户私钥证书加密形成密文后进行1024位的Base64转码。
     */
    public void setSignmsg(String signmsg) {
        this.signmsg = signmsg == null ? null : signmsg.trim();
    }

    /**
     * 获取 参考交易信息类型:数字字符串
     * 3位交易的行业类型+3位版本号
     * 详见风险交易参考信息规则文档
     * t_user_kq_log.referDataType
     *
     * @return 参考交易信息类型:数字字符串
     * 3位交易的行业类型+3位版本号
     * 详见风险交易参考信息规则文档
     */
    public String getReferdatatype() {
        return referdatatype;
    }

    /**
     * 设置 参考交易信息类型:数字字符串
     * 3位交易的行业类型+3位版本号
     * 详见风险交易参考信息规则文档
     * t_user_kq_log.referDataType
     *
     * @param referdatatype 参考交易信息类型:数字字符串
     *                      3位交易的行业类型+3位版本号
     *                      详见风险交易参考信息规则文档
     */
    public void setReferdatatype(String referdatatype) {
        this.referdatatype = referdatatype == null ? null : referdatatype.trim();
    }

    /**
     * 获取 参考交易信息:字符串(XML或其他格式)
     * 用于交易风险控制的交易参考信息
     * 商户可以选择不同版本的参考信息规则
     * 详见风险交易参考信息规则文档
     * t_user_kq_log.referData
     *
     * @return 参考交易信息:字符串(XML或其他格式)
     * 用于交易风险控制的交易参考信息
     * 商户可以选择不同版本的参考信息规则
     * 详见风险交易参考信息规则文档
     */
    public String getReferdata() {
        return referdata;
    }

    /**
     * 设置 参考交易信息:字符串(XML或其他格式)
     * 用于交易风险控制的交易参考信息
     * 商户可以选择不同版本的参考信息规则
     * 详见风险交易参考信息规则文档
     * t_user_kq_log.referData
     *
     * @param referdata 参考交易信息:字符串(XML或其他格式)
     *                  用于交易风险控制的交易参考信息
     *                  商户可以选择不同版本的参考信息规则
     *                  详见风险交易参考信息规则文档
     */
    public void setReferdata(String referdata) {
        this.referdata = referdata == null ? null : referdata.trim();
    }
}