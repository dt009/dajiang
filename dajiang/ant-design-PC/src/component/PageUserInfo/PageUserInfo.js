/**
 * @author v_duantao
 * @file 个人信息,基本资料
 * @date 2017/11/24
 */

import React, {Component} from 'react';
import './PageUserInfo.less';

import Fetch from 'Fetch/Fetch';
import TextInput from 'FormItem/TextInput/TextInput';
import ImgUpload from 'imgUpload/imgUpload';


import {Button, message} from 'antd';

export default class PageUserInfo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            readOnly: true, // 是否为只读
            userPhotoPath: '', // 头像路径
            userNickname: '',  // 昵称
            userPhone: '', // 联系手机号
            userEmail: '', // 联系邮箱
        }
    }

    componentDidMount() {
        Fetch.post(`private/user/initUserInfo`, {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {

                this.setState({
                    userPhotoPath: data.userPhotoPath, // 头像路径
                    userNickname: data.userNickname,  // 昵称
                    userPhone: data.userPhone, // 联系手机号
                    userEmail: data.userEmail, // 联系邮箱
                })

            } else {
                window.location.reload();
            }
        })
    }

    // 点击取消保存按钮
    switchButton = () => {
        let {state, props} = this;
        if (state.readOnly) {
            this.setState({
                readOnly: false
            })
        } else {

            Fetch.post('private/user/updateUserInfo', state).then(res => {
                let {flag, data} = res;
                console.log(res)
                if (flag === 1) {
                    this.setState({
                        readOnly: true,
                    })
                } else {
                    message.error('请检查输入后再保存...')
                }
            });


        }
    };

    // 获取昵称的函数
    getUserNicknameValue = value => {
        this.setState({
            userNickname: value
        })
    };

    // 获取联系手机号的函数
    getUserPhoneValue = value => {
        this.setState({
            userPhone: value
        })
    };

    //  获取联系邮箱的函数
    getUserEmailValue = value => {
        this.setState({
            userEmail: value
        })
    };

    // 获取头像的路径
    getAvatarPathValue = value => {
        this.setState({
            userPhotoPath: value
        })
    };


    render() {
        let {props, state} = this;
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        return (
            <div className='page_user_info'>
                <div className='info_type'>
                    <Button
                        onClick={this.switchButton}
                    >
                        {
                            state.readOnly
                                ? '编辑'
                                : '保存'
                        }
                    </Button>
                </div>
                <div className='info_list'>
                    <ImgUpload
                        Width='100px'
                        Height='100px'
                        MyId='info_avatar'
                        change={this.getAvatarPathValue}
                        content={'请上传头像'}
                        Image={state.userPhotoPath}
                        disabled={state.readOnly}
                        Circle={true}
                    />
                    <div className='empty'></div>
                    <TextInput
                        label="昵称 : "
                        placeholder="请输入昵称"
                        textValue={this.state.userNickname}
                        type="text"
                        changeTextValue={this.getUserNicknameValue}
                        readOnly={state.readOnly}
                    />
                    <div className='empty'></div>
                    <TextInput
                        label="联系手机 :"
                        placeholder="请输入手机号码"
                        max={11}
                        test={phoneTest}
                        errTip="输入的手机格式有误"
                        textValue={this.state.userPhone}
                        type="text"
                        changeTextValue={this.getUserPhoneValue}
                        readOnly={state.readOnly}
                    />
                    <div className='empty'></div>
                    <TextInput
                        label="联系邮箱 :"
                        placeholder="请输入邮箱地址"
                        // test={phoneTest}
                        // errTip="输入的手机格式有误"
                        textValue={this.state.userEmail}
                        type="text"
                        changeTextValue={this.getUserEmailValue}
                        readOnly={state.readOnly}
                    />

                </div>
            </div>
        )
    }
}