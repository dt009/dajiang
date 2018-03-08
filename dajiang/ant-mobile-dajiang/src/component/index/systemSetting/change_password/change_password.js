/**
 * @author  本文件的创建者和修改者
 * @file    文件描述
 * @date 17/9/29 下午9:22
 */

import React from 'react';
import BackHeader from 'backHeader/backHeader';
import IconNameDes from './iconNameDes/iconNameDes';
import './change_password.less';
import Fetch from 'fetch';
import {Toast} from 'antd-mobile';
import {WhiteSpace} from 'antd-mobile';

export default class ChangePassword extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            oldPassword: "", //旧密码
            newPassword: "", //新密码
            confirmPWD: "", //确认密码
        };
        this.getProfessionalPhoneValue = this.getProfessionalPhoneValue.bind(this);
        this.getnewPassword = this.getnewPassword.bind(this);
        this.getconfirmPWD = this.getconfirmPWD.bind(this);

    };
    getconfirmPWD(value) {
        this.setState({confirmPWD: value})
    }
    getnewPassword(value) {
        this.setState({newPassword: value})
    }
    getProfessionalPhoneValue(value) {
        this.setState({oldPassword: value})
    }
    componentDidUpdate() {}
    handleSave() {
        let data = this.state

        Fetch.post('private/user/editPassword', data).then(res => {
            if (res.flag === 1) {
                setTimeout(function() {
                    Toast.fail(res.message, 1.5);
                    window.location.hash = '/index/my';
                }, 1000);
            } else {
                Toast.fail(res.message, 1.5);
            }
        })
    };
    // 验证输入的密码
    handlePassword(e) {
        let value = e.target.value;
        let reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,12}$/;
        this.setState({oldPassword: value});
        if (value.length === 0) {
            Toast.fail('密码不能为空', 1);
        } else if (!(value && reg.test(value))) {}

    };
    handleValue() {}
    render() {
        return (
            <div className="change_password">
                <BackHeader title="修改密码" path="/system_setting"/>
                <WhiteSpace size="lg"/>
                <IconNameDes type="password" key="1" placeholder="请输入6-12位旧密码" name="旧密码" label="&#xe6f9;" extValue={this.state.oldPassword} changeTextValue={this.getProfessionalPhoneValue}/>
                <IconNameDes type="password" key="2" placeholder="请输入6-12位新密码" label="&#xe6f9;" name="新密码" extValue={this.state.newPassword} changeTextValue={this.getnewPassword}/>
                <IconNameDes type="password" key="3" placeholder="再次输入新密码" label="&#xe6f9;" name="确认密码" extValue={this.state.confirmPWD} changeTextValue={this.getconfirmPWD}/>
                <div className="subSave" onClick={this.handleSave.bind(this)}>保存</div>
            </div>
        );
    };
}
