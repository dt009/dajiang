/**
 * @author v_duantao
 * @file 个人中心
 * @date 2017/11/22
 */

import React, {Component} from 'react';
import './PageUser.less';
import {NavLink, Route, Switch, Redirect} from 'react-router-dom';

import Fetch from 'Fetch/Fetch';
import {message} from 'antd';

import PageUserInfo from "../PageUserInfo/PageUserInfo";// 个人基本资料
import PageAccount from "../PageAccount/PageAccount"; // 我的账户
import PageCollect from "../PageCollect/PageCollect";// 我的收藏
import PageKnowledge from "../PageKnowledge/PageKnowledge"; // 我的知识
import PageShoppingCart from "../PageShoppingCart/PageShoppingCart"; // 我的购物车
import CreateProfessional from "../PageProfessional/CreateProfessional/CreateProfessional"; // 成为大匠
import ProfessionalMessage from "../PageProfessional/ProfessionalMessage/ProfessionalMessage"; // 修改大匠资料
import CreateBroker from "../PageBroker/CreateBroker/CreateBroker"; // 成为知识经纪人
import BrokerMessage from "../PageBroker/BrokerMessage/BrokerMessage"; // 修改知识经纪人资料
import PageInvoice from '../PageInvoice/PageInvoice';   // 索取发票页

export default class PageUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userType: '', // 用户角色的信息
        }
    }

    componentDidMount() {
        this.setState({
            userType: window.USER.userType
        });
    }

    handleLogout = () => {
        let props = this.props;
        Fetch.post('loginOut', {}).then(res => {
            window.LOGIN_STATUS = 'N';
            window.USER = [];
            if (res.flag === 1) {
                message.success('退出成功');
                setTimeout(() => {
                    props.history.replace('/my/login');
                }, 1)
            } else {
                message.error('退出失败, 请检查网络');
            }
        })
    };

    // 渲染不同的部分
    renderLsitItem = () => {
        let {userType} = this.state;

        switch (userType) {
            case 1:
            case 0:
                return (
                    <div>
                        <li>
                            <NavLink to='/user/create_professional'>成为大匠</NavLink>
                        </li>
                        <li>
                            <NavLink to='/user/create_broker'>成为经纪人</NavLink>
                        </li>
                    </div>
                );
                break;

            case 2 :
            case 3 :
                return (
                    <li>
                        <NavLink to='/user/professional_message'>修改大匠资料</NavLink>
                    </li>
                );
                break;

            case 4 :
            case 5 :
                return (
                    <li>
                        <NavLink to='/user/broker_message'>修改经纪人资料</NavLink>
                    </li>
                );
            default:

        }
    };

    render() {
        return (
            <div className='page_user clear'>
                <div className='user_left'>
                    <h2>个人中心</h2>
                    <ul className='left_nav'>
                        <li>
                            <NavLink to='/user/info'>个人资料</NavLink>
                        </li>
                        <li>
                            <NavLink to='/user/account'>我的账户</NavLink>
                        </li>
                        <li>
                            <NavLink to='/user/page_invoice'>发票索取</NavLink>
                        </li>
                        <li>
                            <NavLink to='/user/collect'>我的收藏</NavLink>
                        </li>
                        <li>
                            <NavLink to='/user/knowledge'>我的知识</NavLink>
                        </li>
                        <li>
                            <NavLink to='/user/shopping_cart'>我的购物车</NavLink>
                        </li>
                        {this.renderLsitItem()}
                        <li>
                            <a href="javascript:;" onClick={this.handleLogout}>退出</a>
                        </li>
                    </ul>
                </div>
                <div className='user_right'>
                    <Switch>
                        <Redirect exact from='/user' to='/user/info'/>
                        <Redirect exact from='/user/knowledge' to='/user/knowledge/1'/>
                        <Route path='/user/info' render={
                            props => (
                                <PageUserInfo {...props}/>
                            )
                        }/>
                        <Route path='/user/account' render={
                            props => (
                                <PageAccount {...props}/>
                            )
                        }/>
                        <Route path='/user/collect' render={
                            props => (
                                <PageCollect {...props}/>
                            )
                        }/>
                        <Route path='/user/knowledge/:tabsType' render={
                            props => (
                                <PageKnowledge {...props}/>
                            )
                        }/>
                        <Route path='/user/shopping_cart' render={
                            props => (
                                <PageShoppingCart {...props}/>
                            )
                        }/>
                        <Route path='/user/create_professional' render={
                            props => (
                                <CreateProfessional {...props}/>
                            )
                        }/>
                        <Route path='/user/professional_message' render={
                            props => (
                                <ProfessionalMessage {...props}/>
                            )
                        }/>
                        <Route path='/user/create_broker' render={
                            props => (
                                <CreateBroker {...props}/>
                            )
                        }/>
                        <Route path='/user/broker_message' render={
                            props => (
                                <BrokerMessage {...props}/>
                            )
                        }/>
                        <Route path='/user/page_invoice' component={PageInvoice}/>
                    </Switch>
                </div>
            </div>
        )
    }
}