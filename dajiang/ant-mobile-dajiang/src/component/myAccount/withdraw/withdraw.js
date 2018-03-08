/**
 * @author v_duantao
 * @file 提现页面
 * @date 2017/11/5
 */

import React, {Component} from 'react';
import './withdraw.less';

import Fetch from 'fetch';
import {WhiteSpace, Toast, Modal} from 'antd-mobile';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';

export default class Withdraw extends Component {
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
            Toast.fail('提现金额不蹦大于账户余额', 1)
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

        if (withdrawName.length === 0) {
            return Toast.fail('账户户名不能为空', 1.5);
        }
        if (withdrawBankname.length === 0) {
            return Toast.fail('账户银行不能为空', 1.5);
        }
        if (withdrawBankno.length === 0) {
            return Toast.fail('账户银行卡号不能为空', 1.5);
        } else {
            if (/^\d+$/.test(withdrawBankno)) {

            } else {
                return Toast.fail('账户银行卡号只能输入数字', 1.5)
            }
        }
        if (withdrawAmount.length === 0) {
            return Toast.fail('提现金额不能为空', 1.5);
        } else {
            if (/^\d{0,}(\.?\d{1,2}?)$/.test(withdrawAmount)) {

            } else {
                return Toast.fail('提现金额只能为数字', 1.5);
            }
        }
        if (Number(this.state.accountBalance) < Number(this.state.withdrawAmount)) {
            return Toast.fail('提现金融大于余额不能提现', 1)
        }

        Fetch.post('private/account/withdrawal', this.state).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    accountBalance: data
                });
                Modal.alert('申请成功', '5个工作日内到账, 请注意查看', [
                    {text: '确认', onPress: () => this.props.history.push('/my_account')}
                ])
            } else {
                this.props.history.push('/error');
            }
        })
    };

    render() {
        let test1 = /^\d+$/;
        let test2 = /^\d{0,}(\.?\d{1,2}?)$/;
        return (
            <div className='account_withdraw'>
                <BackHeader title='提现' path='/my_account'/>
                <div className='show_balance'>
                    ￥
                    {this.state.accountBalance || 0}
                    <span>元(可提现)</span>
                </div>
                <div className='withdraw_input'>
                    <TextInput
                        label='账户户名'
                        placeholder='账户的持有人姓名'
                        changeTextValue={this.handleChangeWithdrawNameValue}
                    />
                    <WhiteSpace/>
                    <TextInput
                        label='账户银行'
                        placeholder='账户的卡的银行名'
                        changeTextValue={this.handleChangeWithdrawBanknameValue}
                    />
                    <WhiteSpace/>
                    <TextInput
                        label='银行卡号'
                        test={test1}
                        errTip={'账户银行卡号只能输入数字'}
                        placeholder='账户银行的银行卡号'
                        changeTextValue={this.handleChangeWithdrawBanknoValue}
                    />
                    <WhiteSpace/>
                    <TextInput
                        label='提现金额'
                        test={test2}
                        errTip={'提现金额只能输数字'}
                        value={this.state.withdrawAmount}
                        placeholder={`提现不能大于${this.state.accountBalance}`}
                        changeTextValue={this.handleChangeWithdrawAmountValue}
                    />
                </div>
                <div className='withdraw_btn' onClick={this.handleSubmitWithdraw}>
                    提交
                </div>
            </div>
        )
    }
}