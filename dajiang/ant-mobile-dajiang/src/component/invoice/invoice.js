/**
 * 发票索取流程页面
 */
import React  from 'react';
import "./invoice.less";
import Fetch from 'fetch';
// import ImgUpload from 'imgUpload/imgUpload';
import {Toast} from 'antd-mobile';
import TextInput from 'formItem/textInput/textInput';

import BackHeader from 'backHeader/backHeader';


export default class Invoice extends React.Component {
    constructor() {
        super();
    };
    
    state = {
        list: [{
            orderId: 2,
            orderCode: null,
            productTitle: "999",
            orderAmount: 15,
            orderPaytype: null,
            orderDt: 1510378307000,
            date: '',
            active: false
        }],
        total: 0, // 开票金额
        page: 1,  // 判断到了第几页
        invoice_details: {},

        invoive: {
            rise: '',  // 抬头
            code: '',   // 纳税人识别号
            name: '',   // 收件人
            address: '',    // 地址
            email: '',  // 邮箱
            phone: ''   // 联系电话
        }
    }

    componentWillUpdate(){

    }

    componentDidMount() {

    }

    componentWillMount() {
        // 获取发票信息列表
        Fetch.post(`private/invoice/initAskInvoice`).then(res => {
            if (res.flag == 1) {
                let list = res.data;
                list instanceof Array && list.map(item => {
                    let date = new Date(item.orderDt);
                    item.date = `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`;
                    item.active = false;
                });
                this.setState({list});
            } else {
                this.props.history.replace('/login');
            }
        });
    }

    cutInvoice = (item) => {
        if(item.active) {
            item.active = false;
            let total = (this.state.total - item.orderAmount).toFixed(2);
            if (total < 0) {
                total = 0;
            }
            this.setState({
                list: this.state.list,
                total
            });
        } else {
            item.active = true;
            let total = (Number(this.state.total) + Number(item.orderAmount)).toFixed(2);
            this.setState({
                list: this.state.list,
                total
            });
        }
    }

    gotoInvoiceWrite = () => {
        const { total } = this.state;
        if (total <= 0) {
            Toast.fail('你没有选择开票内容！', 1);
            return;
        }
        this.setState({page: 2});
    }

    setInvoiceDetails = (obj, flag) => {
        // 获取发票信息
        if (!flag) {
            return this.setState({page: 1});
        }
        this.setState({
            page: 3,
            invoice_details: obj
        });
    }

    changeRise = (val) => {
        this.setState({
            invoive: {...this.state.invoive, rise: val}
        });
    }

    changeCode = (val) => {
        this.setState({
            invoive: {...this.state.invoive, code: val}
        });
    }

    changeName = (val) => {
        this.setState({
            invoive: {...this.state.invoive, name: val}
        });
    }

    changeAddress = (val) => {
        this.setState({
            invoive: {...this.state.invoive, address: val}
        });
    }

    changeEmail = (val) => {
        this.setState({
            invoive: {...this.state.invoive, email: val}
        });
    }
    
    changePhone = (val) => {
        this.setState({
            invoive: {...this.state.invoive, phone: val}
        });
    }

    gotoPage1 = () => {
        this.setState({page: 1});
    }
    
    gotoPage2 = () => {
        this.setState({page: 2});
    }

    gotoPage3 = () => {
        const {rise, code, name, address, email, phone} = this.state.invoive;
        if (!rise) { return Toast.fail('请填写发票抬头！', 1); }
        if (!code) { return Toast.fail('请填写纳税人识别号！', 1); }
        if (!name) { return Toast.fail('请填写收件人！', 1); }
        if (!address) { return Toast.fail('请填写发票寄送地址！', 1); }
        if (!email) { return Toast.fail('请填写电子邮箱！', 1); }
        if (!phone) { return Toast.fail('请填写联系电话！', 1); }
        this.setState({page: 3});
    }

    // 开具发票
    postMakeInvoice = () => {
        let orderIdList = [];
        this.state.list.map(item => {
            if (item.active) {
                orderIdList.push(item.orderId);
            }
        });
        let orderIdListStr = orderIdList.join("~|~");
        const {rise, code, name, address, email, phone} = this.state.invoive;
        Fetch.post(`private/invoice/saveInvoice`, {
            invoiceHeader: rise,
            invoiceMedium: 1,
            invoiceReceiveAddress: address,
            invoiceReceiveEmail: email,
            invoiceReceiveName: name,
            invoiceReceiveTelephone: phone,
            invoiceTaxNumber: code,
            orderIdList: orderIdList,
            orderIdListStr: orderIdListStr
        }).then(res => {
            if (res.flag == 1 && res.data == 1) {
                Toast.success('申请成功。', 1, () => {
                    this.props.history.replace('/index/my');
                });
            }
        });
    }

    render() {
        const { list, total, page } = this.state;
        const {rise, code, name, address, email, phone} = this.state.invoive;
        if (page === 1) {
            return (
                <div className="invoice">
                    <BackHeader path="/index/my" title="发票索取"/>
                    {/* <ImgUpload MyId="121" Width='4.5rem' Height='4.5rem' change={this.test} content="哈哈哈哈哈哈" Image='http://owu66z9w4.bkt.clouddn.com/FqS4NRMtTfBiA7ubJkaTjmso1Ei3'/>
                    <ImgUpload MyId="123" change={this.test} content="哈哈哈哈哈哈" Image='http://owu66z9w4.bkt.clouddn.com/FqS4NRMtTfBiA7ubJkaTjmso1Ei3'/> */}
                    <div className="invoice_body">
                        <div className="invoice_list">
                            {list && list.map((item, key) => <div className="invoice_list_item" key={key} onClick={() => {
                                this.cutInvoice(item);
                            }}>
                                <div className="list_item_name">
                                    <span>购买产品名称</span>
                                    <span>{item.productTitle}</span>
                                </div>
                                <div className="list_item_price">
                                    <span>可开发票金额</span>
                                    <span>￥{item.orderAmount}</span>
                                </div>
                                <div className="list_item_data">
                                    <span>订单支付时间</span>
                                    <span>{item.date}</span>
                                </div>
                                <div className={item.active ? 'list_item_btn active' : 'list_item_btn'}></div>
                            </div>
                            )}
                            {list.length < 1 ? <div className="show_tishi">你没有可开票的订单。</div> : ''}
                        </div>
                        <div className="invoice_footer">
                            <div className="total_money">待开票金额：￥{total}</div>
                            <div className="total_btn" onClick={this.gotoInvoiceWrite}>索取发票</div>
                            <div className="total_description">
                                <p>1. 申请纸质发票，如金额未满500元，快递费用货到付款需自行承担。</p>
                                <p>2. 单张发票限额10万，索取金额超过10万将拆分成多张发票开具。</p>
                                <p>3. 索取发票有效期为当年1月1日到当年12月31日。</p>
                            </div>
                        </div>
                    </div>
                </div>
            );
        } else if (page === 2) {
            // 确认发票信息
            return (
                <div className="invoice_details">
                    <div className="back_header">
                        <a href="javascript:;" onClick={this.gotoPage1}>&#xe60d;</a>
                        发票信息填写
                    </div>
                    <div className="invoice_details_body">
                        <TextInput
                            label="发票抬头"
                            placeholder="请输入发票抬头"
                            textValue={rise}
                            type="text"
                            changeTextValue={this.changeRise}
                        />
                        <TextInput
                            label="纳税人识别号"
                            placeholder="请输入纳税人识别号"
                            textValue={code}
                            type="text"
                            changeTextValue={this.changeCode}
                        />
                        <TextInput
                            label="收件人"
                            placeholder="请输入收件人"
                            textValue={name}
                            type="text"
                            changeTextValue={this.changeName}
                        />
                        <TextInput
                            label="发票寄送地址"
                            placeholder="请输入发票寄送地址"
                            textValue={address}
                            type="text"
                            changeTextValue={this.changeAddress}
                        />
                        <TextInput
                            label="电子邮箱"
                            placeholder="请输入电子邮箱"
                            textValue={email}
                            type="text"
                            changeTextValue={this.changeEmail}
                        />
                        <TextInput
                            label="联系电话"
                            placeholder="请输入联系电话"
                            textValue={phone}
                            type="number"
                            changeTextValue={this.changePhone}
                        />
                        <div className="next_click" onClick={this.gotoPage3}>下一步</div>
                    </div>
                </div>
            )
        } else if (page === 3) {
            return (
                <div className="invoice_post">
                    <div className="back_header">
                        <a href="javascript:;" onClick={this.gotoPage2}>&#xe60d;</a>
                        发票信息确认
                    </div>
                    <div className="invoice_post_body">
                    <TextInput
                            label="发票抬头"
                            placeholder="请输入发票抬头"
                            textValue={rise}
                            type="text"
                            readOnly={true}
                        />
                        <TextInput
                            label="纳税人识别号"
                            placeholder="请输入纳税人识别号"
                            textValue={code}
                            type="text"
                            readOnly={true}
                        />
                        <TextInput
                            label="发票金额"
                            placeholder=""
                            textValue={`￥${total}`}
                            type="text"
                            readOnly={true}
                        />
                        <TextInput
                            label="收件人"
                            placeholder="请输入收件人"
                            textValue={name}
                            type="text"
                            readOnly={true}
                        />
                        <TextInput
                            label="发票寄送地址"
                            placeholder="请输入发票寄送地址"
                            textValue={address}
                            type="text"
                            readOnly={true}
                        />
                        <TextInput
                            label="电子邮箱"
                            placeholder="请输入电子邮箱"
                            textValue={email}
                            type="text"
                            readOnly={true}
                        />
                        <TextInput
                            label="联系电话"
                            placeholder="请输入联系电话"
                            textValue={phone}
                            type="number"
                            readOnly={true}
                        />
                    </div>

                    <div className="next_click" onClick={this.postMakeInvoice}>提交</div>
                </div>
            )
        }
        
    }
}
