/**
 * @author v_duantao
 * @file  我的页面展示
 * @date 17/9/18 下午5:15
 */

import React, {Component} from 'react';

import {NavLink} from 'react-router-dom';
import {Toast} from 'antd-mobile';

import Fetch from 'fetch';
import ListItem from 'listItem/listItem';

import './my.less';


/**
 * @description   通过用户来渲染不同的 dom
 * @param id  用户的权限
 * @return {*}  react element
 */

export default class My extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userPhotoPath: '',
            userNickname: '',
            userType: ''
        };
        this.handleLogout = this.handleLogout.bind(this);
    }


    componentDidMount() {
        let that = this;
        if(window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
            Fetch.post('private/user/initUserInfo', {}).then(res => {
                let data = res.data;
                if (res.flag === 1) {
                    that.setState({
                        userPhotoPath: data.userPhotoPath,
                        userNickname: data.userNickname,
                        userType: data.userType
                    })
                } else {
                    Toast.fail('初始化信息错误, 请检查网络', 1)
                }
            })
        }
    }
    // 根据用户什么渲染列表
    renderItem(id) {
        switch (id) {
            case 0:
            case 1:
                return (
                    <div style={{overflow: 'hidden', marginTop: '1px'}}>
                        <ListItem path={'/create_da_jiang'} title={'成为大匠'}>
                            <span>&#xe65b;</span>
                        </ListItem>
                        <ListItem path={'/create_broker'} title={'成为知识经纪人'}>
                            <span>&#xe604;</span>
                        </ListItem>
                    </div>
                );
            case 2:
            case 3:
                return (
                    <div>
                        <ListItem path={'/change_da_jiang_info'} title={'修改大匠资料'}>
                            <span>&#xe65b;</span>
                        </ListItem>
                    </div>
                );
            case 4:
            case 5:
                return (
                    <div>
                        <ListItem  path={'/change_broker_info'} title={'修改经济人资料'}>
                            <span>&#xe604;</span>
                        </ListItem>
                    </div>
                );
            default:
                return ''
        }
    }

    // 退出
    handleLogout() {
        let props = this.props;
        Fetch.post('loginOut', {}).then(res => {
            window.LOGIN_STATUS = 'N';
            if (res.flag === 1) {
                Toast.success('退出成功', 1);
                setTimeout(() => {
                    props.history.replace('/login');
                }, 1)
            } else {
                Toast.fail('退出失败, 请检查网络', 1.5);
            }
        })
    }

    render() {
        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'N') {
            this.props.history.replace('/login');
        }
        let renderContent = this.renderItem(this.state.userType);
        return (
            <div className="index_my">
                <div className="my_message">
                    <div className='message_info'>
                        <NavLink to="/change_info">
                            <img src={this.state.userPhotoPath || 'http://owu66z9w4.bkt.clouddn.com/o_1br91lokl178u121j1qlm1h41p4uf.png'} alt="头像"/>
                        </NavLink>
                        <NavLink to="/change_info" className="info_nick_name">
                            {this.state.userNickname || '用户'}
                        </NavLink>
                    </div>
                    <NavLink className={'message_account'} to="/my_account">
                        <span style={{fontFamily: 'iconfont'}}>&#xe669;</span>
                        我的账户
                    </NavLink>
                </div>
                <div className="my_list">
                    <ListItem style={{marginTop: '0.2rem'}} path={'/shopping_cart'} title={'我的购物车'}>
                        <span>&#xe631;</span>
                    </ListItem>
                    <ListItem style={{marginTop: '0.2rem'}} path={'/my_knowledge'} title={'我的知识'}>
                        <span>&#xe645;</span>
                    </ListItem>
                    <ListItem path={'/my_collect'} title={'我的收藏'}>
                        <span>&#xe601;</span>
                    </ListItem>
                    {renderContent}
                    <ListItem path={'/invoice'} title={'索取发票'}>
                        <span>&#xe65b;</span>
                    </ListItem>
                    <ListItem style={{marginTop: '0.2rem'}} path={'/system_setting'} title={'设置'}>
                        <span>&#xe619;</span>
                    </ListItem>
                </div>
                <div onClick={this.handleLogout} className="my_exit">
                    退出登录
                </div>
            </div>
        )
    }
}
