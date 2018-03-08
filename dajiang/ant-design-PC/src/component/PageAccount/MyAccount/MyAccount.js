/**
 * @author v_duantao
 * @file 我的账户页面
 * @date 2017/11/24
 */

import React, {Component} from 'react';

import './MyAccount.less';

import {Button, DatePicker} from 'antd';

import Fetch from 'Fetch/Fetch';


let date = new Date();
let year = date.getFullYear();
let month = date.getMonth() + 1;
let nowDate = `${year}-${month}`;

// 格式化日期的函数
function filterDate(value) {
    let date = new Date(value);
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    month = month < 10 ? '0' + month : month;
    let day = date.getDate();
    day = day < 10 ? '0' + day : day;
    let hour = date.getHours();
    hour = hour < 10 ? '0' + hour : hour;
    let min = date.getMinutes();
    min = min < 10 ? '0' + min : min;

    return `${year}年${month}月${day}日  ${hour}:${min}`
}

export default class MyAccount extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accountBalance: 0,  // 余额
            userPhotoPath: window.USER.userPhotoPath, // 头像
            accountList: [], // 资金记录
            date: nowDate, // 日期
        }
    }

    componentDidMount() {
        // 初始化信息
        this.fetchMoneyCord();
    }

    // 初始化函数
    fetchMoneyCord = () => {
        this.setState({
            accountList: []
        });
        Fetch.post('private/account/initBalance', {dayStr: this.state.date}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    accountBalance: data.accountBalance,
                    accountList: data.accountList
                })
            } else {
                this.props.history.replace('/error');
            }
        })
    };

    // 选择日期的函数
    onChangeDateValue = (date, dateString) => {
        this.setState({
            date: dateString
        }, () => {
            this.fetchMoneyCord()
        });
    };

    render() {
        const {MonthPicker} = DatePicker;
        return (
            <div className='page_account'>
                <div className='account_header'>
                    <div className='header_top'>
                        <div className='top_img'>
                            <img
                                src={this.state.userPhotoPath || 'http://owu66z9w4.bkt.clouddn.com/o_1bubfs4pjmdg98o151m18aj1gu1a.png'}
                                alt="用户头像"/>
                        </div>
                        <div className='top_balance'>
                            总资产: ￥&nbsp;
                            <span>
                                {this.state.accountBalance}
                            </span>
                            &nbsp;&nbsp;元(余额)
                        </div>
                    </div>
                    <div className='header_bottom'>
                        <Button
                            onClick={e => this.props.history.push('/user/account/recharge')}
                        >
                            充值
                        </Button>
                        <Button
                            onClick={e => this.props.history.push('/user/account/withdraw')}
                        >
                            提现
                        </Button>
                    </div>
                </div>
                <div className='account_date'>
                    <span>&#xe614;</span>
                    <span style={{
                        color: '#333',
                        marginLeft: '12px'
                    }}>资金记录</span>
                    <MonthPicker
                        className='select_date'
                        onChange={this.onChangeDateValue}
                        placeholder='请选择月份'
                    />
                </div>
                <div className='account_record'>
                    {
                        this.state.accountList.length === 0
                            ? <div
                                style={{
                                    height: '100px',
                                    width: '100%',
                                    fontSize: '24px',
                                    color: '#fbb601',
                                    textAlign: 'center',
                                    lineHeight: '100px',
                                }}
                            >没有交易记录</div>
                            : this.state.accountList.map((item, key) => {
                                return (
                                    <div className='record_item' key={key}>
                                        <div className='item_left'>
                                            <div className='left_top'>
                                                <span style={{color: '#fbb601'}}>
                                                    {item.productTypeName}
                                                </span>
                                                <span style={{color: '#666'}}>
                                                    {item.accountDesc}
                                                </span>
                                            </div>
                                            <div className='left_bottom'>
                                                {filterDate(item.accountInsertDT)}
                                            </div>
                                        </div>
                                        <div className='item_right'>
                                            {`￥ ${item.accountAmount} 元`}
                                        </div>
                                    </div>
                                )
                            })
                    }
                </div>
            </div>
        )
    }
}