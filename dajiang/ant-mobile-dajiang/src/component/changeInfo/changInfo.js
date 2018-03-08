/**
 * @author v_duantao
 * @file 修改基本资料的页面
 * @date 17/9/24 下午1:20
 */

import React, {Component} from 'react';
import './changeInfo.less';
import {Toast} from 'antd-mobile';

import Fetch from 'fetch';
import BackHeader from 'backHeader/backHeader';
import Upload from 'upload/upload';
import TextInput from 'formItem/textInput/textInput';


export default class ChangeData extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userPhotoPath: '', // 头像路径
            userNickname: '',  // 昵称
            userPhone: '', // 联系手机号
            userEmail: '', // 联系邮箱
        };

        this.getUserPhotoPathValue = this.getUserPhotoPathValue.bind(this);
        this.getUserNicknameValue = this.getUserNicknameValue.bind(this);
        this.getUserPhoneValue = this.getUserPhoneValue.bind(this);
        this.getUserEmailValue = this.getUserEmailValue.bind(this);
        this.handleClickSaveBtn = this.handleClickSaveBtn.bind(this);
    }

    componentDidUpdate () {
    }

    componentDidMount() {
        let that = this;
        Fetch.post('private/user/initUserInfo').then(res => {
            that.setState({
                userPhotoPath:res.data.userPhotoPath || 'http://owu66z9w4.bkt.clouddn.com/o_1br8rppu4vpg14ft96tjnc14cca.png',
                userNickname:res.data.userNickname || '',
                userPhone:res.data.userPhone || '',
                userEmail:res.data.userEmail || ''
            })
        })
    }

    // 获取头像路径的函数
    getUserPhotoPathValue(value) {
        this.setState({
            userPhotoPath: value
        })
    }

    // 获取昵称的函数
    getUserNicknameValue(value) {
        this.setState({
            userNickname: value
        })
    }

    // 获取联系手机号的函数
    getUserPhoneValue(value) {
        this.setState({
            userPhone: value
        })
    }

    //  获取联系邮箱的函数
    getUserEmailValue(value) {
        this.setState({
            userEmail: value
        })
    }

    // 点击保存按钮的函数
    handleClickSaveBtn() {
           let state = this.state;
           let that = this;

           Fetch.post('private/user/updateUserInfo', state).then(res => {
               if (res.flag === 1) {
                    Toast.success('保存成功', 1.5);
                    setTimeout(() => {
                        that.props.history.push('/index/my');
                    }, 1000)
               } else {
                   Toast.fail('失败,重新输入', 1.5)
               }
           })
    }

    render() {
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        return (
            <div className="change_info_base">
                <BackHeader
                    path="/index/my"
                    title="修改资料"
                />

                <div className="base_content">
                    <Upload
                        type="avatar"
                        id="base_info_change"
                        container="upload_avatar_box"
                        change={this.getUserPhotoPathValue}
                        imgSrc={this.state.userPhotoPath}
                    />
                    <TextInput
                        label="昵称"
                        placeholder="请输入昵称"
                        textValue={this.state.userNickname}
                        type="text"
                        changeTextValue={this.getUserNicknameValue}
                    />
                    <TextInput
                        label="联系手机"
                        placeholder="请输入手机号码"
                        max={11}
                        test={phoneTest}
                        errTip="输入的手机格式有误"
                        textValue={this.state.userPhone}
                        type="text"
                        changeTextValue={this.getUserPhoneValue}
                    />
                    <TextInput
                        label="联系邮箱"
                        placeholder="请输入邮箱地址"
                        // test={phoneTest}
                        // errTip="输入的手机格式有误"
                        textValue={this.state.userEmail}
                        type="text"
                        changeTextValue={this.getUserEmailValue}
                    />

                    <div className="content_btn" onClick={this.handleClickSaveBtn}>
                        保存
                    </div>
                </div>
            </div>
        )
    }
}
