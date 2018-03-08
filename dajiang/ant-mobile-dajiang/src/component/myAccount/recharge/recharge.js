/**
 * @author ruixi
 * @file 充值
 * @date 17/11/05
 */

import React, {Component} from 'react';
import Fetch from 'fetch';
import BackHeader from 'backHeader/backHeader';
import {Toast} from 'antd-mobile';

import './recharge.less';

export default class Recharge extends Component {

    state = {
        price: '',
        is_weixin: false,
        is_zhifubao: false,
        is_yinlian: false,
        accountBalance: 0
    }

    componentWillMount() {
        // 初始化余额
        Fetch.post('private/account/initRecharge', {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    accountBalance: data.accountBalance
                })
            } else {
                this.props.history.push('/error')
            }
        })
    }

    handlePrice = (e) => {
        let value = e.target.value;
        this.setState({
            price: value.trim()
        });
    }

    handleWeiXin = () => {
        this.setState({
            is_weixin: true,
            is_zhifubao: false,
            is_yinlian: false
        });
    }

    handleZhiFuBao = () => {
        this.setState({
            is_weixin: false,
            is_zhifubao: true,
            is_yinlian: false
        });
    }

    handleYinLian = () => {
        this.setState({
            is_weixin: false,
            is_zhifubao: false,
            is_yinlian: true
        });
    }

    handleRecharge = () => {
        console.log();
        const { price, is_weixin, is_zhifubao, is_yinlian } = this.state;
        if (!price.trim()) {
            return Toast.fail('你没有输入充值金额！', 1);
        }
        if (is_weixin) {
            // 微信支付
        } else if (is_zhifubao) {
            // 支付宝
        } else if (is_yinlian) {
            // 银联
        }
    }

    render() {
        return (
            <div className="recharge">
                <BackHeader title='充值' path='/my_account'/>
                <div className="recharge_head">
                    ￥{this.state.accountBalance}元<span>(余额)</span>
                </div>
                <div className="recharge_ipt">
                    <div className="form_item">
                        <div className="input_text">
                            <label>
                                <span className="propsLabel">输入充值金额</span>
                                <input type='number'
                                    placeholder='请输入充值金额'
                                    value={this.state.price}
                                    onChange={this.handlePrice}
                                />
                            </label>
                        </div>
                    </div>
                </div>
                <div className="pattern_of_payment">
                    <div className="pay_list_item" onClick={this.handleWeiXin}>
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
                    </div>
                </div>
                <div className="recharge_btn" onClick={this.handleRecharge}>充值</div>
            </div>
        )
    }
}