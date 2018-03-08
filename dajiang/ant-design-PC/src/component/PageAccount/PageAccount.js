/**
 * @author v_duantao
 * @file 我的账户
 * @date 2017/11/24
 */

import React, {Component} from 'react';
import {Route, Switch, Redirect} from 'react-router-dom';

import './PageAccount.less';
import MyAccount from "./MyAccount/MyAccount";
import AccountRecharge from "./AccountRecharge/AccountRecharge";
import AccountWithdraw from "./AccountWithdraw/AccountWithdraw";

export default class PageAccount extends Component {
    render() {
        return (
            <Switch>
                <Redirect exact from='/user/account' to='/user/account/my_account'/>
                <Route path='/user/account/my_account' render={
                    props => (
                        <MyAccount {...props}/>
                    )
                }/>
                <Route path='/user/account/recharge' render={
                    props => (
                        <AccountRecharge {...props}/>
                    )
                }/>
                <Route path='/user/account/withdraw' render={
                    props => (
                        <AccountWithdraw {...props}/>
                    )
                }/>
            </Switch>
        )
    }
}