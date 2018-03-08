/**
 * @author wackeCq a
 * @file 这是账户设置的界面
 * @date 17/9/23 下午4:32
 */
import React from 'react';
import './accountSetting.less';
import BackHeader from 'backHeader/backHeader';
import Fetch from 'fetch';
import {Toast} from 'antd-mobile';
import TextInput from 'formItem/textInput/textInput';
import {WhiteSpace} from 'antd-mobile';

/**
 * @description    默认的开始的提示
 * @param       defaultActiveKey    当前的heander的名字
 * @param       0 代表用户协议服务协议  1政府信息公告  2其他信息
 * @param       实例 agreement/1
 */

export default class accountSetting extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            bankAccName: '',
            bankName: '',
            bankCode: ''
        }
        this.getbankName = this.getbankName.bind(this);
        this.getbankCode = this.getbankCode.bind(this);
        this.getusername = this.getusername.bind(this);
        this.handleClickSaveBtn = this.handleClickSaveBtn.bind(this)

    }
    componentWillUpdate() {}
    componentDidMount() {
        let state = this.state;

        Fetch.get('public/bank/queryBankList').then(res => {
            if (res.flag === 1) {
                this.setState({bankAccName: res.data.bankAccName, bankName: res.data.bankName, bankCode: res.data.bankCode})
            } else {}
        })
    }
    onChange(key) {};
    getbankName(value) {
        this.setState({bankName: value})
    }
    getbankCode(value) {
        this.setState({bankCode: value})
    }
    getusername(value) {
        this.setState({bankAccName: value})
    }
    handleClickSaveBtn() {
        var that = this;
        let data = {
            bankAccName: this.state.bankAccName,
            bankCode: this.state.bankCode,
            bankNo: this.state.bankCode
        }

        Fetch.post('private/user/updateUserBank', data).then(res => {
            if (res.flag === 1) {
                Toast.success('保存成功', 1.5);
                that.props.history.push('/index/my');
            } else {
                Toast.fail('失败,重新输入', 1.5)
            }
        })

    }
    render() {
        let pathname = this.props.location.pathname;
        let id = pathname.substring(pathname.length - 1);
        return (
            <div>
                <BackHeader path="/system_setting" title="账户设置"/>
                <div className="component_setting">
                    <TextInput label="账户持有人" placeholder="请输入姓名" textValue={this.state.bankAccName} type="text" changeTextValue={this.getusername}/>
                    <WhiteSpace size="md"/>

                    <TextInput label="账户银行" placeholder="请输入银行名称" textValue={this.state.bankName} type="text" changeTextValue={this.getbankName}/>
                    <WhiteSpace size="md"/>

                    <TextInput label="账户账号" placeholder="请输入银行卡号" textValue={this.state.bankCode} type="text" changeTextValue={this.getbankCode}/>
                </div>
                <WhiteSpace size="md"/>

                <div className="content_btn" onClick={this.handleClickSaveBtn}>
                    保存
                </div>
            </div>
        )
    }
}
