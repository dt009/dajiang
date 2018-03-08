/**
 * @author v_duantao
 * @file 我的账户页面
 * @date 17/9/25 下午4:02
 */

import React, {Component} from 'react';
import './myAccount.less';
import {NavLink} from 'react-router-dom';
import Fetch from 'fetch';


import BackHeader from 'backHeader/backHeader';
import SelectInput from 'formItem/selectInput/selectInput';

let data = [
    {
        value: 2017,
        label: 2017,
        children: [
            {
                value: '2017-01',
                label: '01'
            },
            {
                value: '2017-02',
                label: '02'
            },
            {
                value: '2017-03',
                label: '03'
            },
            {
                value: '2017-04',
                label: '04'
            },
            {
                value: '2017-05',
                label: '05'
            },
            {
                value: '2017-06',
                label: '06'
            },
            {
                value: '2017-07',
                label: '07'
            },
            {
                value: '2017-08',
                label: '08'
            },
            {
                value: '2017-09',
                label: '09'
            },
            {
                value: '2017-10',
                label: '10'
            },
            {
                value: '2017-11',
                label: '11'
            },
            {
                value: '2017-12',
                label: '12'
            }
        ]
    },
    {
        value: 2018,
        label: 2018,
        children: [
            {
                value: '2018-01',
                label: '01'
            },
            {
                value: '2018-02',
                label: '02'
            },
            {
                value: '2018-03',
                label: '03'
            },
            {
                value: '2018-04',
                label: '04'
            },
            {
                value: '2018-05',
                label: '05'
            },
            {
                value: '2018-06',
                label: '06'
            },
            {
                value: '2018-07',
                label: '07'
            },
            {
                value: '2018-08',
                label: '08'
            },
            {
                value: '2018-09',
                label: '09'
            },
            {
                value: '2018-10',
                label: '10'
            },
            {
                value: '2018-11',
                label: '11'
            },
            {
                value: '2018-12',
                label: '12'
            }
        ]
    },
    {
        value: 2019,
        label: 2019,
        children: [
            {
                value: '2019-01',
                label: '01'
            },
            {
                value: '2019-02',
                label: '02'
            },
            {
                value: '2019-03',
                label: '03'
            },
            {
                value: '2019-04',
                label: '04'
            },
            {
                value: '2019-05',
                label: '05'
            },
            {
                value: '2019-06',
                label: '06'
            },
            {
                value: '2019-07',
                label: '07'
            },
            {
                value: '2019-08',
                label: '08'
            },
            {
                value: '2019-09',
                label: '09'
            },
            {
                value: '2019-10',
                label: '10'
            },
            {
                value: '2019-11',
                label: '11'
            },
            {
                value: '2019-12',
                label: '12'
            }
        ]
    }
];

let date = new Date();
let year = date.getFullYear();
let month = date.getMonth() + 1;
let nowDate = `${year}-${month}`;  // TODO 后台问题

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
            userPhotoPath: window.USER.userPhotoPath,
            date: nowDate,
            accountList: []
        }
    }

    componentDidMount() {
        this.fetchMoneyCord();
    }

    fetchMoneyCord = () => {
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

    changeDateValue = value => {
        this.setState({
            date: value[1]
        }, () => {
            this.fetchMoneyCord()
        });
    };

    render() {
        return (
            <div className='my_account'>
                <BackHeader title='我的账户' path={'/index/my'}/>
                <div className='account_header'>
                    <div className='header_message'>
                        <div className='header_img'>
                            <img src={this.state.userPhotoPath || 'http://owu66z9w4.bkt.clouddn.com/o_1bubfs4pjmdg98o151m18aj1gu1a.png'} alt=""/>
                        </div>
                        <div className='header_message'>
                            总资产:
                            <span className='message_capital'>
                            ￥
                            <span className='capital'>{this.state.accountBalance}</span>
                            元(余额)
                        </span>
                        </div>
                    </div>
                    <div className='account_operation'>
                        <NavLink className='recharge' to='/recharge'>充值</NavLink>
                        <NavLink className='withdraw' to='/withdraw'>提现</NavLink>
                    </div>
                </div>
                <div className='money_record'>
                    <div className='account_select'>
                        <span>&#xe614;</span>
                        <SelectInput
                            label='资金记录'
                            cols={2}
                            title='请选择时间'
                            data={data}
                            getChangeSelectValue={this.changeDateValue}
                        />
                    </div>
                </div>
                <div className='account_list'>
                    {
                        this.state.accountList.length !== 0
                            ?  this.state.accountList.map((item, key) => {
                                return (
                                    <div className='account_list_item' key={key}>
                                        <div className='list_left'>
                                            <div className='left_top'>
                                                <span className='name'>{item.productTypeName}</span>
                                                <span className='description'>{item.accountDesc}</span>
                                            </div>
                                            <div className='left_bottom'>
                                                {filterDate(item.accountInsertDT)}
                                            </div>
                                        </div>
                                        <div className='list_right'>
                                            {`￥${item.accountAmount || 0}元`}
                                        </div>
                                    </div>
                                )
                            })
                            : (
                                <div style={{
                                    textAlign: 'center',
                                    fontSize: '0.3rem',
                                    marginTop: '0.4rem'
                                }}>
                                    没有交易记录...
                                </div>
                            )

                    }
                </div>
            </div>
        )
    }
}