/**
 * @author v_duantao
 * @file 登录
 * @date 2017/11/21
 */

import React, {Component} from 'react';
import './PageLogin.less';

import {NavLink} from 'react-router-dom';

import {message} from 'antd';

import Fetch from 'Fetch/Fetch';


export default class PageLogin extends Component {

    constructor(props) {
        super(props);
        this.state = {
            showError: false,  // 输入框的验证提示
            showSubmit: true,  // 是否可点击登录按钮
            isPass: 'password',
            loginName: '',
            loginPasswd: ''
        };
    }

    // 验证输入的用户名
    handleNameChange = e => {
        let value = e.target.value;
        let reg = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        this.setState({
            loginName: value,
            showError: false
        });
        if (value.length === 0) {
            message.error('账号不能为空')
        } else if (value && reg.test(value)) {
            this.setState({
                showError: false,
                showSubmit: true
            })
        } else {
            this.setState({
                showError: true,
                showSubmit: false
            })
        }
    };

    componentDidUpdate() {
        // console.log(this.state);
    }

    // 验证输入的密码
    handlePassword = e => {
        let value = e.target.value;
        let reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        this.setState({
            loginPasswd: value,
        });
        if (value.length === 0) {
            message.error('密码不能为空');
        } else if (!(value && reg.test(value))) {
            this.setState({
                showSubmit: false
            });
        }

    };

    // 登录的请求
    handleSubmit = () => {
        let state = this.state;
        let that = this;

        if (state.loginName.length === 0) {
            return message.error('请输入账号');
        }

        if (state.loginPasswd.length === 0) {
            return message.error('请输入密码');
        }
        this.setState({
            showSubmit: false
        });
        let data = {
            loginName: state.loginName,
            loginPasswd: state.loginPasswd,
        };

        Fetch.post('login', data).then(res => {
            if (res.flag === 1) {
                window.LOGIN_STATUS = 'Y';
                window.USER = res.data;
                message.success('登录成功..');
                setTimeout(() => {
                    that.props.history.go(-1);
                }, 1000);
            } else {
                that.setState({
                    showSubmit: true
                });
                message.error(res.message);
            }
        })
    };

    handleCheckPassword = () => {
        let isPass = this.state.isPass === 'password' ? 'text' : 'password';
        this.setState({
            isPass: isPass
        })
    };

    render() {
        return (
            <div className='page_login'>
                <div className='login_form'>
                    <div className='form_username'>
                        <span></span>
                        <input style={{
                            color: this.state.showError ? '#f00' : '#fff'
                        }} type="text"
                               placeholder="请输入账号"
                               onChange={this.handleNameChange}
                               onBlur={this.handleNameChange}
                        />
                    </div>
                    <div className="login_password_input">
                        <span></span>
                        <input type={this.state.isPass}
                               placeholder="输入数字和字母至少6位的密码"
                               onChange={this.handlePassword}
                               onBlur={this.handlePassword}
                        />
                        <span onClick={this.handleCheckPassword}></span>
                    </div>
                    <div className="login_other">
                        <span onClick={e => this.props.history.replace('/my/register/0')}>
                            注册
                        </span>
                        <span onClick={e => this.props.history.replace('/my/register/1')}>
                            忘记密码?
                        </span>
                    </div>
                    <div className="login_submit"
                         onClick={this.handleSubmit}
                    >
                        登录
                    </div>
                </div>
            </div>
        )
    }
}