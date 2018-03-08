/**
 * 索取发票
 * ruixi
 */
import React  from 'react';
import Fetch from 'Fetch/Fetch';
import { Button, notification } from 'antd';

import './PageInvoice.less';

export default class PageInvoice extends React.Component {
    constructor() {
        super();
    };
    
    state = {
        list: [],
        total: 0,
        is_write: false,
        is_view: false,
        invoive: {
            rise: '',  // 抬头
            code: '',   // 纳税人识别号
            name: '',   // 收件人
            address: '',    // 地址
            email: '',  // 邮箱
            phone: ''   // 联系电话
        },
        is_show_disabled: false  // 输入框是否是编辑状态
    }

    componentWillUpdate() {

    }

    componentDidMount() {

    }

    componentWillMount() {
        this.getInvoiceList();
    }

    getInvoiceList = () => {
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

    gotoInvoiceWrite = () => {
        // 索取发票
        const { total } = this.state;
        if (total <= 0) {
            notification.open({ message: '你没有选择开票内容！' });
            return;
        }
        this.setState({ is_write: true });
    }

    cutInvoice = (item) => {
        // 选择list表项
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
                notification.open({ message: '申请成功.' });
                this.props.history.replace('/index/my');
            }
        });
    }
    
    hideShow = () => {
        this.setState({ is_write: false });
    }


    changeRise = (e) => {
        this.setState({
            invoive: {...this.state.invoive, rise: e.target.value}
        });
        console.log(this.state.invoive);
    }

    changeCode = (e) => {
        this.setState({
            invoive: {...this.state.invoive, code: e.target.value}
        });
    }

    changeName = (e) => {
        this.setState({
            invoive: {...this.state.invoive, name: e.target.value}
        });
    }

    changeAddress = (e) => {
        this.setState({
            invoive: {...this.state.invoive, address: e.target.value}
        });
    }

    changeEmail = (e) => {
        this.setState({
            invoive: {...this.state.invoive, email: e.target.value}
        });
    }
    
    changePhone = (e) => {
        this.setState({
            invoive: {...this.state.invoive, phone: e.target.value}
        });
    }

    next = () => {
        // 下一步 进入确认
        const {rise, code, name, address, email, phone} = this.state.invoive;
        if (!rise) { return notification.open({ message: '请填写发票抬头！...' }); }
        if (!code) { return notification.open({ message: '请填写纳税人识别号！...' }); }
        if (!name) { return notification.open({ message: '请填写收件人！...' }); }
        if (!address) { return notification.open({ message: '请填写发票寄送地址！...' }); }
        if (!email) { return notification.open({ message: '请填写电子邮箱！...' }); }
        if (!phone) { return notification.open({ message: '请填写联系电话！...' }); }
        this.setState({ is_show_disabled: true });
    }
    
    back = () => {
        this.setState({ is_show_disabled: false });
    }
    
    render() {
        const { list, total, is_show_disabled, is_write } = this.state;
        const {rise, code, name, address, email, phone} = this.state.invoive;
        return (
            <div className='page_invoice'>
                <div className='page_invoice_title'>发票助手</div>
                <div className="invoive_list">
                    {list.map((item, key) => {
                        return (
                            <div className="invoice_list_item" key={key}>
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
                                <div onClick={() => {this.cutInvoice(item);}} className={item.active ? 'list_item_btn active' : 'list_item_btn'}></div>
                            </div>
                        );
                    })}
                </div>
                <div className="invoice_footer">
                    <div className="total_money">待开票金额：￥{total}</div>
                    <div className="total_description">
                        <p>1. 申请纸质发票，如金额未满500元，快递费用货到付款需自行承担。</p>
                        <p>2. 单张发票限额10万，索取金额超过10万将拆分成多张发票开具。</p>
                        <p>3. 索取发票有效期为当年1月1日到当年12月31日。</p>
                    </div>
                    <div className="total_btn" onClick={this.gotoInvoiceWrite}>索取发票</div>
                </div>
                {is_write ? <div className="invoice_show">
                    {/* 整个遮罩浮层 */}
                    {  }
                    <div className="invoice_show_content">
                        <div className="invoice_show_content_head" onClick={this.hideShow}><span>X</span></div>
                        {is_show_disabled ? <div className="invoice_show_content_head_text">请确认发票信息...</div> : '' }
                        <div className="show_ipt_box">
                            <div className="ipt_item">
                                <div className="ipt_item_left"><span>*</span> 发票抬头：</div>
                                <div className="ipt_item_right">
                                    <input type="text" onChange={this.changeRise} value={rise} placeholder="请输入发票抬头" disabled={is_show_disabled}/>
                                </div>
                            </div>
                            <div className="ipt_item">
                                <div className="ipt_item_left"><span>*</span> 纳税人识别号：</div>
                                <div className="ipt_item_right">
                                    <input type="text" onChange={this.changeCode} value={code} placeholder="请输入纳税人识别号" disabled={is_show_disabled}/>
                                </div>
                            </div>
                            <div className="ipt_item">
                                <div className="ipt_item_left"><span>*</span> 收件人：</div>
                                <div className="ipt_item_right">
                                    <input type="text" onChange={this.changeName} value={name} placeholder="请输入收件人" disabled={is_show_disabled}/>
                                </div>
                            </div>
                            <div className="ipt_item">
                                <div className="ipt_item_left"><span>*</span> 发票寄送地址：</div>
                                <div className="ipt_item_right">
                                    <input type="text" onChange={this.changeAddress} value={address} placeholder="请输入发票寄送地址" disabled={is_show_disabled}/>
                                </div>
                            </div>
                            <div className="ipt_item">
                                <div className="ipt_item_left"><span>*</span> 电子邮箱：</div>
                                <div className="ipt_item_right">
                                    <input type="text" onChange={this.changeEmail} value={email} placeholder="请输入电子邮箱" disabled={is_show_disabled}/>
                                </div>
                            </div>
                            <div className="ipt_item">
                                <div className="ipt_item_left"><span>*</span> 联系电话：</div>
                                <div className="ipt_item_right">
                                    <input type="number" onChange={this.changePhone} value={phone} placeholder="请输入联系电话" disabled={is_show_disabled}/>
                                </div>
                            </div>
                            <div className="invoice_btn">
                                {is_show_disabled ? <div className="invoice_btn"><Button size='large' onClick={this.back}>上一步</Button><Button size='large' onClick={this.postMakeInvoice}>提交</Button></div> : <Button size='large' onClick={this.next}>下一步</Button>}
                            </div>
                        </div>
                    </div>
                </div> : ''}
            </div>
        );
    }
}
