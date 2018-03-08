/**
 * @author v_duantao
 * @file 注册和忘记密码页面
 * @date 2017/11/22
 */

import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';

import './PageRegister.less';
import Fetch from 'Fetch/Fetch';

import {Button, Modal, Checkbox, message} from 'antd';


export default class PageRegister extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isForgetPassword: false, // 是否是忘记密码
            userPhone: '', // 用户手机号码
            vertifCode: '', // 验证码
            password: '', // 用户密码
            confirmPWD: '', // 确认密码
            userPhoneError: true, // 手机号错误
            codeDisabled: true, // 禁用
            codeLoading: false, // loading中
            downTime: 60, // 倒计时60秒
            isCountdown: false, // 是否进入倒计时
            timer: null, // 定时器
            codeError: true, // 验证码错误
            passwordError: true, // 密码错误
            isPasswordType: 'password', // 类型: text || password
            isPasswordPWDType: 'password', // 类型: text || password
            showModal: false, // 显示协议
            isAgree: true, // 统一协议
            isSubmitLoading: false, // 提交 loading
        }
    }

    componentDidMount() {
        console.log(this.props);
        let {match} = this.props;
        let {type} = match.params;
        if (type === '1') {
            this.setState({
                isForgetPassword: true
            })
        }
    }

    // 获取用户手机号
    setUserPhoneValue = e => {
        let value = e.target.value;
        let reg = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        if (value.length === 0) {
            return message.error('手机号不能为空..')
        } else if (value && reg.test(value)) {
            this.setState({
                userPhone: value,
                userPhoneError: false,
                codeDisabled: false
            })
        } else {
            this.setState({
                userPhoneError: true,
            })
        }
    };

    // 获取验证码
    fetchVerificationCode = () => {
        this.setState({
            codeLoading: true
        });
        let params = {
            userPhone: this.state.userPhone,
            useType: this.state.isForgetPassword
                ? 'USE_FORGET' : 'USE_REGISTER'
        };

        Fetch.post('public/user/sendVerificationCode', params).then(res => {
            this.setState({
                codeLoading: false,
            });
            let {flag} = res;
            if (flag === 1) {
                message.success('发送成功请注意查收...');
                this.setState({
                    codeDisabled: true,
                    isCountdown: true,

                }, () => { // 倒计时的函数
                    let timer = setInterval(() => {
                        let number = this.state.downTime;
                        number--;
                        if (number < 0) {
                            timer = null;
                            this.setState({
                                isCountdown: false,
                            })
                        }
                        this.setState({
                            downTime: number
                        })
                    }, 1000);
                })
            } else {
                message.error(res.message)
            }
        })
    };

    // 获取验证码
    setVerificationCodeValue = e => {
        let value = e.target.value;
        let reg = /^\d{6}$/;
        if(value.length === 0) {
            return message.error('验证码不能为空')
        } else if (value && reg.test(value)) {
            this.setState({
                codeError: false,
                vertifCode: value,
            })
        } else {
            this.setState({
                codeError: true
            })
        }
    };

    // 获取密码
    setPasswordValue = e => {
        let value = e.target.value;
        let reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;

        if (value.length === 0) {
            return message.error('密码不能为空..')
        } else if (value && reg.test(value)) {
            this.setState({
                passwordError: false,
                password: value,
            })
        } else {
            this.setState({
                passwordError: true
            })
        }
    };

    // 显示密码
    handleShowPasswordValue = (key, type) => {
        let text = type === 'password' ? 'text' : 'password';
        if (key === 1) {
            this.setState({
                isPasswordType: text,
            })
        } else {
            this.setState({
                isPasswordPWDType: text
            })
        }
    };

    // 获取确认密码
    setConfirmPWDValue = e => {
        this.setState({
            confirmPWD: e.target.value
        })
    }

    // 是否同意协议
    setIsAgreeValue = e => {
        let flag = e.target.checked;
        this.setState({
            isAgree: flag,
        })
    };

    // 提交
    onClickSubmitBtn = () => {
        this.setState({
            isSubmitLoading: true,
        });
        let state = this.state;
        let {isForgetPassword, userPhone, password, confirmPWD, vertifCode, isAgree} = state;
        let params = {
            userPhone,
            password,
            confirmPWD,
            vertifCode
        }
        if (!isAgree) {
            message.error('请阅读同意用户协议并同意..')
            return this.setState({
                isSubmitLoading: false
            });
        }

        if (state.userPhoneError) {
            message.error('请检查手机号...')
            return this.setState({
                isSubmitLoading: false
            });
        }

        if (state.codeError) {
            message.error('请检查验证码');
            return this.setState({
                isSubmitLoading: false
            });
        }

        if (state.passwordError) {
            message.error('请检查输入的密码')
            return this.setState({
                isSubmitLoading: false
            });
        }

        if (password === confirmPWD) {
            isForgetPassword
                ? Fetch.post('public/user/resetPassword', params).then(res => {
                    this.setState({
                        isSubmitLoading: false,
                    });
                    let {flag} = res;
                    if (flag === 1) {
                        message.success('密码重置成功...');
                        setTimeout(() => {
                            this.props.history.replace('/my/login')
                        }, 1000)
                    } else {
                        message.error(res.message)
                    }
                })
                : Fetch.post('public/user/register', params).then(res => {
                    this.setState({
                        isSubmitLoading: false,
                    });
                    let {flag} = res;
                    if (flag === 1) {
                        message.success('注册成功...');
                        setTimeout(() => {
                            this.props.history.replace('/my/login')
                        }, 1000)
                    } else {
                        message.error(res.message)
                    }
                })
        } else {
            message.error('确认密码和密码不一致...')
            return this.setState({
                isSubmitLoading: false
            });
        }
    };

    render() {
        let state = this.state;
        return (
            <div className='page_register'>
                <div className='register_form'>
                    <h2>
                        {
                            state.isForgetPassword
                                ? '忘记密码'
                                : '注册'
                        }
                    </h2>
                    <div className='form_phone'>
                        <span>&#xe605;</span>
                        <input
                            style={{
                                color: state.userPhoneError ? '#f00' : '#fff'
                            }}
                            type="text"
                            placeholder='请输入手机号'
                            onChange={this.setUserPhoneValue}
                            onBlur={this.handleNameChange}
                        />
                    </div>
                    <div className='form_code'>
                        <div className='code_content'>
                            <span>&#xe61d;</span>
                            <input
                                style={{
                                    color: state.codeError ? '#f00' : '#fff'
                                }}
                                type="text"
                                placeholder='请输入验证码'
                                onChange={this.setVerificationCodeValue}
                                onBlur={this.setVerificationCodeValue}
                            />
                        </div>
                        <Button
                            className='code_btn'
                            loading={state.codeLoading}
                            disabled={state.codeDisabled}
                            onClick={this.fetchVerificationCode}
                        >
                            {
                                state.isCountdown
                                    ? `${state.downTime}s后重发`
                                    : '获取验证码'
                            }
                        </Button>
                    </div>
                    <div className='form_password'>
                        <span>&#xe618;</span>
                        <input type={state.isPasswordType}
                               style={{
                                   color: state.passwordError ? '#f00' : '#fff'
                               }}
                               placeholder="输入数字和字母至少6位的密码"
                               onChange={this.setPasswordValue}
                               onBlur={this.setPasswordValue}
                        />
                        <span onClick={e => this.handleShowPasswordValue(1, state.isPasswordType)}>&#xe654;</span>
                    </div>
                    <div className='form_password'>
                        <span>&#xe618;</span>
                        <input type={state.isPasswordPWDType}
                               placeholder="再输入一次密码"
                               onChange={this.setConfirmPWDValue}
                        />
                        <span onClick={e => this.handleShowPasswordValue(-1, state.isPasswordPWDType)}>&#xe654;</span>
                    </div>
                    <div className='form_checkbox'>
                        {
                            state.isForgetPassword
                                ? null
                                : (
                                    <div>
                                        <Button
                                            className='checkbox_label'
                                            onClick={e => this.setState({showModal: true})}
                                        >
                                            阅读协议
                                        </Button>
                                        <Modal
                                            title='用户协议'
                                            visible={state.showModal}
                                            onOk={e => this.setState({isAgree: true, showModal: false})}
                                            onCancel={e => this.setState({showModal: false})}
                                            okText="确认"
                                            cancelText="取消"
                                        >
                                            协议能容
                                        </Modal>
                                        <Checkbox
                                            className='checkbox'
                                            defaultChecked={state.isAgree}
                                            checked={state.isAgree}
                                            onChange={this.setIsAgreeValue}
                                        />
                                    </div>
                                )
                        }
                    </div>
                    <Button
                        className='form_submit'
                        loading={state.isSubmitLoading}
                        onClick={this.onClickSubmitBtn}
                    >
                        {
                            state.isForgetPassword
                                ? '完成'
                                : '注册'
                        }
                    </Button>
                </div>
            </div>
        )
    }
}