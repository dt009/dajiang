/**
 * @author v_duantao
 * @file
 * @date 17/9/18 下午5:12
 */

import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import {Toast} from 'antd-mobile';

import Fetch from 'fetch';


import './login.less';

export default class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            showError: false,  // 输入框的验证提示
            showSubmit: true,  // 是否可点击登录按钮
            isPass: 'password',
            loginName: '',
            loginPasswd: ''
        };

        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handlePassword = this.handlePassword.bind(this);
        this.handleCheckPassword = this.handleCheckPassword.bind(this);
    }

    // 验证输入的用户名
    handleNameChange(e) {
        let value = e.target.value;
        let reg = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        this.setState({
            loginName: value,
            showError: false
        });
        if (value.length === 0) {
            Toast.fail('账号不能为空', 1)
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
    }

    componentDidUpdate() {
        // console.log(this.state);
    }

    // 验证输入的密码
    handlePassword(e) {
        let value = e.target.value;
        let reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        this.setState({
            loginPasswd: value,
        });
        if (value.length === 0) {
            Toast.fail('密码不能为空', 1);
        } else if (!(value && reg.test(value))) {
            this.setState({
                showSubmit: false
            });
        }

    }

    // 登录的请求
    handleSubmit() {
        let state = this.state;
        let that = this;

        if (state.loginName.length === 0) {
            return Toast.fail('请输入账号', 1.5);
        }

        if (state.loginPasswd.length === 0) {
            return Toast.fail('请输入密码', 1.5);
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
                that.props.history.push('/index/my');
            } else {
                that.setState({
                    showSubmit: true
                });
                Toast.fail(res.message, 1.5);
            }
        })
    }

    handleCheckPassword() {
        let isPass = this.state.isPass === 'password' ? 'text' : 'password';
        this.setState({
            isPass: isPass
        })
    }

    render() {
        return (
            <div className="login">
                <NavLink className='login_logo' to="/index/home">
                </NavLink>
                <div className="login_form">
                    <div className="login_userName">
                        <span></span>
                        <input style={{
                            color: this.state.showError ? '#f00' : '#fff'
                        }} type="text"
                               placeholder="请输入账号"
                               onChange={this.handleNameChange}
                               onBlur={this.handleNameChange}
                        />
                    </div>
                    <div className="login_password">
                        <span></span>
                        <input type={this.state.isPass}
                               placeholder="输入数字和字母至少6位的密码"
                               onChange={this.handlePassword}
                               onBlur={this.handlePassword}
                        />
                        <span onClick={this.handleCheckPassword}></span>
                    </div>
                    <div className="login_other">
                        <NavLink to="/register/0">
                            注册
                        </NavLink>
                        <NavLink to="/register/1">
                            忘记密码?
                        </NavLink>
                    </div>
                    <div className="login_submit">
                        <button onClick={this.handleSubmit}>登录</button>
                    </div>
                </div>
            </div>
        )
    }
}
