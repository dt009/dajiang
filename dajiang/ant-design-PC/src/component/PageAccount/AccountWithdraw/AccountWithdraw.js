/**
 * @author v_duantao
 * @file 提现页面
 * @date 2017/11/25
 */

import React, {Component} from 'react';
import './AccountWithdraw.less';

import Fetch from 'Fetch/Fetch';
import {message, Modal} from 'antd';

import TextInput from 'FormItem/TextInput/TextInput';

export default class AccountWithdraw extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accountBalance: '',  // 账户余额
            withdrawName: '',  // 账户持有人姓名
            withdrawBankname: '', // 银行名
            withdrawBankno: '', // 银行卡号
            withdrawAmount: '',  // 提现金额
        }
    }

    componentDidMount() {
        // 初始化余额
        Fetch.post('private/account/initWithdrawal', {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    accountBalance: data
                })
            } else {
                this.props.history.push('/error')
            }
        })
    }

    // 改变 银行卡账户持有人姓名
    handleChangeWithdrawNameValue = value => {
        this.setState({
            withdrawName: value
        })
    };

    // 改变 银行名
    handleChangeWithdrawBanknameValue = value => {
        this.setState({
            withdrawBankname: value
        })
    };

    // 改变 银行卡号
    handleChangeWithdrawBanknoValue = value => {
        this.setState({
            withdrawBankno: value
        })
    };

    // 改变 提现金额
    handleChangeWithdrawAmountValue = value => {
        if (Number(this.state.accountBalance) < Number(value)) {
            message.error('提现金额不蹦大于账户余额')
        }
        this.setState({
            withdrawAmount: value
        })
    };

    // 提交
    handleSubmitWithdraw = () => {
        let {
            withdrawName,  // 账户持有人姓名
            withdrawBankname, // 银行名
            withdrawBankno, // 银行卡号
            withdrawAmount,  // 提现金额
        } = this.state;

        let props = this.props;
        if (withdrawName.length === 0) {
            return message.error('账户户名不能为空');
        }
        if (withdrawBankname.length === 0) {
            return message.error('账户银行不能为空');
        }
        if (withdrawBankno.length === 0) {
            return message.error('账户银行卡号不能为空');
        } else {
            if (/^\d+$/.test(withdrawBankno)) {

            } else {
                return message.error('账户银行卡号只能输入数字')
            }
        }
        if (withdrawAmount.length === 0) {
            return Toast.fail('提现金额不能为空', 1.5);
        } else {
            if (/^\d{0,}(\.?\d{1,2}?)$/.test(withdrawAmount)) {

            } else {
                return message.error('提现金额只能为数字');
            }
        }
        if (Number(this.state.accountBalance) < Number(this.state.withdrawAmount)) {
            return message.error('提现金融大于余额不能提现')
        }

        Fetch.post('private/account/withdrawal', this.state).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    accountBalance: data
                });
                Modal.confirm({
                    title: '提示',
                    content: '申请成功, 5个工作日内到账, 请注意查看',
                    onOk() {
                        props.history.push('/user/account/my_account');
                    },
                    onCancel() {
                        props.history.push('/user/account/my_account');
                    },
                })
            } else {
                this.props.history.push('/error');
            }
        })
    };


    render() {
        let state = this.state;
        let test1 = /^\d+$/;
        let test2 = /^\d{0,}(\.?\d{1,2}?)$/;
        return (
            <div className='page_withdraw'>
                <div className='withdraw_header'>
                    {`￥ ${state.accountBalance} 元` }
                    <span>(余额)</span>
                </div>
                <div className='withdraw_content'>
                    <div className='empty'></div>
                    <TextInput
                        label='账户户名:'
                        placeholder='请输入账户的持有人姓名'
                        changeTextValue={this.handleChangeWithdrawNameValue}
                    />
                    <div className='empty'></div>
                    <TextInput
                        label='账户银行:'
                        placeholder='请输入账户的卡的银行名'
                        changeTextValue={this.handleChangeWithdrawBanknameValue}
                    />
                    <div className='empty'></div>
                    <TextInput
                        label='银行卡号:'
                        test={test1}
                        errTip={'账户银行卡号只能输入数字'}
                        placeholder='请输入账户银行的银行卡号'
                        changeTextValue={this.handleChangeWithdrawBanknoValue}
                    />
                    <div className='empty'></div>
                    <TextInput
                        label='提现金额:'
                        test={test2}
                        errTip={'提现金额只能输数字'}
                        value={this.state.withdrawAmount}
                        placeholder={`提现不能大于${this.state.accountBalance}`}
                        changeTextValue={this.handleChangeWithdrawAmountValue}
                    />
                </div>
                <div
                    className='withdraw_submit'
                    onClick={this.handleSubmitWithdraw}
                >
                    提交
                </div>
            </div>
        )
    }
}
