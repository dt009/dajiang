/**
 * 结算台页面
 *     /dj-api/private/order/createOrder/{productId}   下单接口   返回的数据传到结算台显示
 * 账户支付
 *         /private/order/payOrder
 * 余额支付 11、23
 * /private/order/payByBalance
 *      获取快钱签名
 *  /private/bill99/createSign/{orderId}
 * 第三方支付
 *   private/order/payByThird
 *  {
 *      orderId:“”，
 *      inviteCode:""
 *      }
 * 
 * orderAmount  订单金额
 * /private/bill99/createSign/{payChannel}/{orderId}  获取支付签名   
 * payChannel 取值：WX,ALI, 00
 * 支付方式：余额支付（ME）, 支付宝（ALI）,微信（WX），网银（BANK）
 * 
 * <form name="kqPay" action="https://www.99bill.com/mobilegateway/recvMerchantInfoAction.htm" method="post">
        <input type="hidden" name="inputCharset" value="<%=inputCharset%>" />
        <input type="hidden" name="pageUrl" value="<%=pageUrl%>" />
        <input type="hidden" name="bgUrl" value="<%=bgUrl%>" />
        <input type="hidden" name="version" value="<%=version%>" />
        <input type="hidden" name="mobileGateway" value="<%=mobileGateway%>" />    
        <input type="hidden" name="language" value="<%=language%>" />
        <input type="hidden" name="signType" value="<%=signType%>" />
        <input type="hidden" name="signMsg" value="<%=signMsg%>" />
        <input type="hidden" name="merchantAcctId" value="<%=merchantAcctId%>" />
        <input type="hidden" name="payerName" value="<%=payerName%>" />
        <input type="hidden" name="payerContactType" value="<%=payerContactType%>" />
        <input type="hidden" name="payerContact" value="<%=payerContact%>" />
        <input type="hidden" name="payerIdType" value="<%=payerIdType%>" />
        <input type="hidden" name="payerId" value="<%=payerId%>" />    
        <input type="hidden" name="orderId" value="<%=orderId%>" />
        <input type="hidden" name="orderAmount" value="<%=orderAmount%>" />
        <input type="hidden" name="orderTime" value="<%=orderTime%>" />
        <input type="hidden" name="productName" value="<%=productName%>" />
        <input type="hidden" name="productNum" value="<%=productNum%>" />
        <input type="hidden" name="productId" value="<%=productId%>" />
        <input type="hidden" name="productDesc" value="<%=productDesc%>" />
        <input type="hidden" name="ext1" value="<%=ext1%>" />
        <input type="hidden" name="ext2" value="<%=ext2%>" />
        <input type="hidden" name="payType" value="<%=payType%>" />
        <input type="hidden" name="bankId" value="<%=bankId%>" />
        <input type="hidden" name="redoFlag" value="<%=redoFlag%>" />
        <input type="hidden" name="pid" value="<%=pid%>" />  
        <input type="hidden" name="aggregatePay" value="<%=aggregatePay%>" />
        <input type="submit" name="submit" value="提交到快钱">
   </form>
 * 
 * ruixi
 */
import React  from 'react';
import Fetch from 'Fetch/Fetch';
import { notification } from 'antd';


import './closeAnAccount.less';

export default class closeAnAccount extends React.Component {
    constructor() {
        super();
    };
    
    state = {
        ipt_val: '',
        is_yue: false,
        is_kuaiqian: false,
        is_weixin: false,
        is_zhifubao: false,
        is_yinlian: false,
        productPrice: 0,
        accountBalance: 0
    }

    componentWillUpdate() {

    }

    componentDidMount() {

        console.log('closeAnAccount componentDidMount');
    }

    componentWillMount() {
        console.log(this.props);
        // this.getProduct();
        this.addOrder();
        this.getAccountBalance();
    }

    // 请求快钱地址  跳转快钱支付
    postKuaiqian = (data) => {
        // fetch('https://www.99bill.com/mobilegateway/recvMerchantInfoAction.htm', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/x-www-form-urlencoded'
        //     },
        //     body: JSON.stringify(data)
        // }).then(res => {
        //     alert(res);
        // });

        let form1 = document.createElement("form");
        form1.name = "form_da_jiang"; 
        // 添加到 body 中 
        document.getElementById('form_test').appendChild(form1); 

        for(let i in data) {
            // 创建一个输入 
            let input = document.createElement("input"); 
            // 设置相应参数 
            input.type = "text"; 
            input.name = i;
            input.value = data[i];
            // 将该输入框插入到 form 中 
            form1.appendChild(input); 
        }
        // form 的提交方式 
        form1.method = "POST"; 
        // form 提交路径 
        form1.action = "https://www.99bill.com/mobilegateway/recvMerchantInfoAction.htm"; 
        // 对该 form 执行提交 
        form1.submit(); 
        // 删除该 form 
        document.getElementById('form_test').removeChild(form1); 
    }

    addOrder = () => {
        // 下单接口
        // 根据路由参数获取 product 
        const { productId, type } = this.props.match.params;
        Fetch.post(`private/order/createOrder/${productId}`).then(res => {
            if (res.flag === 1) {
                this.order = res.data;
                this.setState({
                    productPrice: res.data.orderAmount
                });
            }
        });
    }

    getProduct = () => {
        // 根据路由参数获取 product 
        const { productId, type } = this.props.match.params;
        console.log(type);
        if (type == 1) {
            // 专利
            Fetch.post(`public/product/initPatentInfo/${productId}`).then(res => {
                console.log(res);
                this.setState({
                    productPrice: res.data.productPrice
                });
            });
        } else if (type == 2) {
            // 图文
            Fetch.post(`public/product/initDocInfo/${productId}`).then(res => {
                console.log(res);
                this.setState({
                    productPrice: res.data.productPrice
                });
            });
        } else if (type == 3) {
            // 视频
            Fetch.post(`public/product/initVideoInfo/${productId}`).then(res => {
                console.log(res);
                this.setState({
                    productPrice: res.data.productPrice
                });
            });
        }
    }

    // 获取账户余额
    getAccountBalance = () => {
        Fetch.post('private/account/initRecharge', {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    accountBalance: data.accountBalance
                })
            } else {
                // 
                this.props.history.replace('/my/login');
            }
        });
    }

    // 邀请码失去焦点事件  验证
    handleIptBlur = () => {
        if (!this.state.ipt_val) {
            return;
        }
        Fetch.post('private/account/validInviteCode', {
            inviteCode: this.state.ipt_val
        }).then(res => {
            let {flag, data, message} = res;
            if (flag === 1) {
                notification.open({
                    message: '验证成功...'
                });
                this.valid_code = this.state.ipt_val;
            } else {
                notification.open({
                    message: '验证失败...'
                });
                this.valid_code = null;
            }
        });
    }

    changeIpt = (e) => {
        if (!e.target.value.trim()) {
            return;
        }
        this.setState({ipt_val: e.target.value.trim()});
    }

    // 支付
    handleRecharge = () => {
        const { is_yue, is_weixin, is_zhifubao, is_yinlian, is_kuaiqian, productPrice } = this.state;
        if (!is_yue && !is_weixin && !is_zhifubao && !is_yinlian && !is_kuaiqian) {
            return notification.open({
                message: '请选择支付方式...'
            });
        }
        if (is_yue) {
            this.yuEPay();
        } else if (is_weixin) {
            this.weiXinPay();
        } else if (is_zhifubao) {
            this.zhiFuBaoPay();
        } else if (is_yinlian) {
            this.yinLianPay();
        } else if (is_kuaiqian) {
            this.kuaiQianPay();
        }

    }

    yuEPay = () => {
        console.log('余额支付');
        let data = {
            orderId: this.order.orderId
        };
        if (this.valid_code) {
            data.inviteCode = this.valid_code;
        }
        Fetch.post('private/order/payByBalance', { ...data }).then(res => {
            let {flag, data, message} = res;
            if (flag === 1) {
                notification.open({
                    message: '支付成功...'
                });
            } else {
                notification.open({
                    message: message
                });
            }
        });
    }

    weiXinPay = () => {
        console.log('微信支付');
        this.fetchPaySign('WX');
    }

    zhiFuBaoPay = () => {
        console.log('支付宝支付');
        this.fetchPaySign('ALI');
    }

    yinLianPay = () => {
        console.log('银联支付');
        this.fetchPaySign('BANK');
    }

    kuaiQianPay = () => {
        console.log('快钱支付');
        // /private/bill99/createSign/{orderId}
        // let data = {
        //     orderId: this.order.orderId,
        //     payChannel: "KQ"
        // };
        // if (this.valid_code) {
        //     data.inviteCode = this.valid_code;
        // }
        
        Fetch.post(`private/bill99/createSign/${this.order.orderId}`).then(res => {
            let {flag, data, message} = res;
            if (flag === 1) {
                // 进入支付流程
                let data = res.data;
                // let obj = {
                //     ...data,
                //     signMsg: encodeURIComponent(data.signMsg),
                //     pageUrl: encodeURIComponent(data.pageUrl),
                //     bgUrl: encodeURIComponent(data.bgUrl)
                // };
                // console.log(res.data);
                // console.log(obj);
                // console.log(JSON.stringify(obj));
                this.postKuaiqian(data);
            } else {
                notification.open({
                    message: message
                });
            }
        });
    }

    // 获取支付签名并进入支付流程  payChannel 支付方式  支付宝（ALI）,微信（WX），网银（BANK） 快钱（KQ）
    fetchPaySign = (payChannel) => {
        Fetch.post(`private/bill99/createSign/${payChannel}/${this.order.orderId}`).then(res => {
            let {flag, data, message} = res;
            if (flag === 1) {
                // 进入支付流程

            } else {
                notification.open({
                    message: message
                });
            }
        });
    }

    handleYuE = () => {
        this.setState({
            is_yue: true,
            is_kuaiqian: false,
            is_weixin: false,
            is_zhifubao: false,
            is_yinlian: false
        });
    }

    handleKuaiQian = () => {
        this.setState({
            is_yue: false,
            is_kuaiqian: true,
            is_weixin: false,
            is_zhifubao: false,
            is_yinlian: false
        });
    }

    handleWeiXin = () => {
        this.setState({
            is_yue: false,
            is_kuaiqian: false,
            is_weixin: true,
            is_zhifubao: false,
            is_yinlian: false
        });
    }

    handleZhiFuBao = () => {
        this.setState({
            is_yue: false,
            is_kuaiqian: false,
            is_weixin: false,
            is_zhifubao: true,
            is_yinlian: false
        });
    }

    handleYinLian = () => {
        this.setState({
            is_yue: false,
            is_kuaiqian: false,
            is_weixin: false,
            is_zhifubao: false,
            is_yinlian: true
        });
    }

    render() {
        const { productPrice, accountBalance } = this.state;
        return (
            <div className='close_an_account'>
                <div id="form_test"></div>
                <div className='close_an_account_head'>
                    <p>支付金额</p>
                    <p>￥{productPrice}元</p>
                    <div className="invite_code">
                        <div>请输入邀请码</div>
                        <div>
                            <input type="text" value={this.state.ipt_val} onBlur={this.handleIptBlur} onChange={this.changeIpt}/>
                        </div>
                    </div>
                </div>
                <div className="close_an_account_body">
                    <div className="zhifufangshi">请选择支付方式</div>
                    <div className="close_an_account_of_payment">
                        <div className="pay_list_item" onClick={this.handleYuE}>
                            <span></span>
                            <div>余额支付<i>（账户余额：{accountBalance ? accountBalance : 0}元）</i></div>
                            <em className={this.state.is_yue ? 'active' : ''}></em>
                        </div>
                        <div className="pay_list_item" onClick={this.handleKuaiQian}>
                            <span></span>
                            <div>快钱支付</div>
                            <em className={this.state.is_kuaiqian ? 'active' : ''}></em>
                        </div>
                        {/* <div className="pay_list_item" onClick={this.handleWeiXin}>
                            <span></span>
                            <div>微信支付</div>
                            <em className={this.state.is_weixin ? 'active' : ''}></em>
                        </div>
                        <div className="pay_list_item" onClick={this.handleZhiFuBao}>
                            <span></span>
                            <div>支付宝支付</div>
                            <em className={this.state.is_zhifubao ? 'active' : ''}></em>
                        </div>
                        <div className="pay_list_item" onClick={this.handleYinLian}>
                            <span></span>
                            <div>银联支付</div>
                            <em className={this.state.is_yinlian ? 'active' : ''}></em>
                        </div> */}
                    </div>
                    <div className="close_an_account_btn" onClick={this.handleRecharge}>支付</div>
                </div>
            </div>
        );
    }
}
