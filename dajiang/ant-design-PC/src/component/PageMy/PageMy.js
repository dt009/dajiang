/**
 * @author v_duantao
 * @file 登录注册的中间页
 * @date 2017/11/22
 */

import React, {Component} from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import PageLogin from "../PageLogin/PageLogin";  // 登录页面
import PageRegister from "../PageRegister/PageRegister"; // 注册和忘记密码页

export default class PageMy extends Component {
    constructor(props) {
        super(props);
        this.state = {

        }
    }

    componentDidMount() {
        let {hash} = window.location;
        this.props.getCurrentHash(hash)
    }

    componentWillUnmount() {
        this.props.getCurrentHash('')
    }

    render() {
        return (
            <div className='page_my'>
                <Switch>
                    <Redirect exact from='/my' to='/my/login'/>
                    <Route path='/my/login' render={
                        props => (
                            <PageLogin {...props}/>
                        )
                    }/>
                    <Route path='/my/register/:type' render={
                        props => (
                            <PageRegister {...props}/>
                        )
                    }/>
                </Switch>
            </div>
        )
    }
}