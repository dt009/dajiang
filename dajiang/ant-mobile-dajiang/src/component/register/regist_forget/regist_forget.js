import React from 'react';
import './regist_forget.less'
import Fetch from 'fetch';
import {NavLink} from 'react-router-dom';
import {Toast} from 'antd-mobile';

export default class RegistForget extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            telError: null,
            passwordError: null,
            imageShow: true,
            userPhone: null,
            getcode: null,
            password: null,
            affirmPass: null,
            isPass: 'password',
            importCode: "",
            path: '',
            count: 60,
            liked: true
        }
        this.handleCheckPassword = this.handleCheckPassword.bind(this);
        this.affirmPass = this.affirmPass.bind(this);
        this.importCode = this.importCode.bind(this);

    }
    //手机号判断
    telCheck(event) {
        this.setState({userPhone: event.target.value})
        this.tel = event.target.value
        var reg = /^1[34578]\d{9}$/;
        if (reg.test(this.tel) == false) {
            this.setState({telError: "请输入正确的手机号"})
            Toast.info("请输入正确的手机号", 1.5);

        } else {
            this.setState({telError: ""})
        }
    };
    importCode(event) {
        this.code = event.target.value;
        var reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        if (reg.test(this.code) == false) {
            this.setState({importCode: "请输入正确验证码!"})
            Toast.info("请输入正确验证码!", 1.5);
        }

        this.setState({getcode: event.target.value})
    }
    componentDidUpdate() {}

    getCode() {
        let data = {
            userPhone: this.state.userPhone,
            useType: "USE_REGISTER"
        }
        Fetch.post('/public/user/sendVerificationCode', data).then(res => {

            if (res.flag == "1") {
                if (this.state.liked) {
                    Toast.info(res.message, 1.5);

                    this.timer = setInterval(function() {
                        var count = this.state.count;
                        this.state.liked = false;
                        count -= 1;
                        if (count < 1) {
                            this.setState({liked: true});
                            count = 60;
                            clearInterval(this.timer);
                        }
                        this.setState({count: count});
                    }.bind(this), 1000);
                }
            } else {
                Toast.info(res.message, 1.5);

            }

        })

    };
    confirmCode() {
        if (this.state.liked) {
            this.timer = setInterval(function() {
                var count = this.state.count;
                this.state.liked = false;
                count -= 1;
                if (count < 1) {
                    this.setState({liked: true});
                    count = 60;
                    clearInterval(this.timer);
                }
                this.setState({count: count});
            }.bind(this), 1000);
        }
        let data = {
            userPhone: this.state.userPhone,
            useType: "USE_RESETPWD"
        }
        Fetch.post('/public/user/sendVerificationCode', data).then(res => {
            Toast.info(res.message, 1.5);
        })

    };
    subRegister() {
        var reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        if (reg.test(this.state.password) == false) {
            Toast.info("密码为6-12位数字和字母!", 1.5);
            return
        }
        if (this.state.password !== this.state.affirmPass) {
            Toast.info("两次输入密码不一致", 1.5);
            return
        }
        if (this.state.userPhone != "" && this.state.password != '' && this.state.getcode != '') {
            let data = {
                userPhone: this.state.userPhone,
                vertifCode: this.state.getcode,
                password: this.state.password
            }
            Fetch.post('public/user/register', data).then(res => {
                if (res.flag == 1) {
                    Toast.info(res.message, 1.5);
                    window.location.hash = '/login';
                } else {
                    Toast.info(res.message, 1.5);
                }

            })
        } else {
            Toast.info("请输入完整", 1.5);
        }

    }
    subComplete() {
        var reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        if (reg.test(this.state.password) == false) {
            Toast.info("密码为6-12位数字和字母!", 1.5);
            return
        }
        if (this.state.password !== this.state.affirmPass) {
            Toast.info("两次输入密码不一致", 1.5);
            return
        }
        let data = {
            userPhone: this.state.userPhone,
            vertifCode: this.state.getcode,
            password: this.state.password,
            confirmPWD: this.state.affirmPass

        }
        Fetch.post('public/user/resetPassword', data).then(res => {

            if (res.flag == "1") {
                Toast.info(res.message, 1.5);
                setTimeout(function() {
                    window.location.hash = '/login';
                }, 1000);

            } else {
                Toast.info(res.message, 1.5);

            }
        })
    }
    //密码判断
    passwordCheck(event) {
        this.password = event.target.value;
        var reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        if (reg.test(this.password) == false) {
            this.setState({passwordError: "密码为6-20位数字和字母!"})
            Toast.info("密码为6-20位数字和字母!", 1.5);
        } else {
            this.setState({passwordError: ""})
        }
        this.setState({password: event.target.value})
    }
    //是否记住密码
    isRemember() {
        this.setState({
            imageShow: !this.state.imageShow
        })
    };
    handleCheckPassword() {
        let isPass = this.state.isPass === 'password'
            ? 'text'
            : 'password';
        this.setState({isPass: isPass})
    }
    componentDidUpdate() {
        console.log(this.state)
    }
    affirmPass(event) {
        this.setState({affirmPass: event.target.value});

    }

    render() {
        var text = this.state.liked
            ? '获取验证码'
            : this.state.count + '秒后重发';

        const subsearch = this.props.path.substring(this.props.path.length - 1) == 1
            ? <button onClick ={this.subComplete.bind(this)} className="subRegist register">完成</button>
            : <button onClick ={this.subRegister.bind(this)} className="subRegist register">注册</button>
        const getCode = this.props.path.substring(this.props.path.length - 1) == 1
            ? <div className="input_code" onClick={this.confirmCode.bind(this)}>{text}</div>
            : <div className="input_code" onClick={this.getCode.bind(this)}>{text}</div>
        const agreement = this.props.path.substring(this.props.path.length - 1) == 0
            ? <div className="agreement">我已阅读并同意用户<NavLink to="/agreement/0?path=register/0">协议</NavLink>
                </div>
            : ""

        var imageSrc = this.state.imageShow;
        return (
            <div className="register_input">
                <div>

                    <div className="input_ul">
                        <div className="input_username userTel">
                            <span className="userSpan1 userSpan"></span>
                            <input type="text" className="telInput" placeholder="请输入手机号" onBlur={(event) => this.telCheck(event)}/>
                        </div>
                        <div className="input_username userTel1">
                            <span className="userSpan2 userSpan"></span>
                            <input type="text" className="telInput1" className="print_code" placeholder="请输入验证码" onBlur={(event) => this.importCode(event)}/> {getCode}
                        </div>
                        <div className="input_username">
                            <span className="userSpan3"></span>
                            <input type={this.state.isPass} className="telInput" placeholder="请输入字母和数字的至少6位的密码" onBlur={(event) => this.passwordCheck(event)}/>
                            <span className="userSpan4" onClick={this.handleCheckPassword}></span>
                        </div>
                        <div className="input_username">
                            <span className="userSpan3"></span>
                            <input type={this.state.isPass} className="telInput" placeholder="请确认密码" onBlur={(event) => this.affirmPass(event)}/>
                            <span className="userSpan4" onClick={this.handleCheckPassword}></span>
                        </div>
                        <div className="rememberLi">
                            <img className="unSelected" onClick={() => this.isRemember()}/>
                        </div>
                        {agreement}
                        <div className="liAll">
                            {subsearch}
                        </div>
                    </div>
                </div>

            </div>
        )
    }
}
