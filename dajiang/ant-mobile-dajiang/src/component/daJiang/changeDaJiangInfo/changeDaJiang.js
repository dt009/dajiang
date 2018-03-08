/**
 * @author v_duantao
 * @file 修改大匠的基本资料的页面
 * @date 17/9/24 下午8:49
 */

import React, {Component} from 'react';
import './changeDaJiang.less';

import {WhiteSpace, TextareaItem, Toast} from 'antd-mobile';

import Fetch from 'fetch';
import BackHeader from 'backHeader/backHeader';
import Upload from 'upload/upload';
import TextInput from 'formItem/textInput/textInput';
import DateInput from 'formItem/dateInput/dateInput';
import SelectInput from 'formItem/selectInput/selectInput';


export default class ChangeDaJiangInfo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            professionalId: '', // 大匠 ID
            professionalPhotoPath: '', // 个人照片
            professionalName: '', // 姓名
            professionalPosition: '', // 职位
            professionalEmail: '', // 邮箱
            professionalHighEduc: '', // 最高学历
            professionalWorkunit: '', // 任职机构
            professionalPhone: '', // 手机号码
            professionalField: '', // 专业领域
            professionalTypeId: '', // 大匠分类
            professionalIntroduction: '', // 大匠简介
        };

        this.getPhotoPathValue = this.getPhotoPathValue.bind(this);
        this.getProfessionalPositionValue = this.getProfessionalPositionValue.bind(this);
        this.getProfessionalEmailValue = this.getProfessionalEmailValue.bind(this);
        this.getProfessionalHighEducValue = this.getProfessionalHighEducValue.bind(this);
        this.getProfessionalWorkunitValue = this.getProfessionalWorkunitValue.bind(this);
        this.getProfessionalPhoneValue = this.getProfessionalPhoneValue.bind(this);
        this.getProfessionalFieldValue = this.getProfessionalFieldValue.bind(this);
        this.getProfessionalTypeIdValue = this.getProfessionalTypeIdValue.bind(this);
        this.getProfessionalIntroductionValue = this.getProfessionalIntroductionValue.bind(this);
    }

    componentDidMount() {
        // 初始化页面
        let that = this;
        Fetch.post('private/professional/initProfess', {}).then(res => {
            let data = res.data;
            if(res.flag === 1) {
                that.setState({
                    professionalId: data.professionalId,
                    professionalName: data.professionalName,
                    professionalPhotoPath: data.professionalPhotoPath,
                    professionalPosition: data.professionalPosition,
                    professionalEmail: data.professionalEmail,
                    professionalHighEduc: data.professionalHighEduc,
                    professionalWorkunit: data.professionalWorkunit,
                    professionalPhone: data.professionalPhone,
                    professionalField: data.professionalField,
                    professionalTypeId: data.professionalTypeId,
                    professionalIntroduction: data.professionalIndroduction,
                })
            } else {
                Toast.fail('初始化失败, 请检查网络', 1)
            }
        })
        // 获取学历列表
    }


    componentDidUpdate () {
        // console.log(this.state);
    }



    // 获取本人照片的路径
    getPhotoPathValue(value) {
        this.setState({
            professionalPhotoPath: value
        })
    }

    // 获取职位的函数
    getProfessionalPositionValue(value) {
        this.setState({
            professionalPosition: value
        })
    }

    // 获取邮箱
    getProfessionalEmailValue(value) {
        this.setState({
            professionalEmail: value
        })
    }

    // 获取最高学历
    getProfessionalHighEducValue(value) {
        this.setState({
            professionalHighEduc: value[0]
        })
    }

    // 获取任职机构的函数
    getProfessionalWorkunitValue(value) {
        this.setState({
            professionalWorkunit: value
        })
    }

    // 获取手机号
    getProfessionalPhoneValue(value) {
        this.setState({
            professionalPhone: value
        })
    }

    // 获取专业领域的函数
    getProfessionalFieldValue(value) {
        this.setState({
            professionalField: value
        })
    }

    // 获取大匠分类
    getProfessionalTypeIdValue(value) {
        this.setState({
            professionalTypeId: value[1]
        })
    }

    // 获取大匠简介的函数
    getProfessionalIntroductionValue(value) {
        this.setState({professionalIntroduction: value});
    }

    // 提交按钮事件
    handleProfessionalSubmit = () => {
        let params = this.state;
        let that = this;
        Fetch.post('private/professional/sendProfVertif', params).then(res => {
            if (res.flag) {
                Toast.success('修改成功', 1);
                setTimeout(() => {
                    that.props.history.push('/index/my');
                }, 1000)
            } else {
                Toast.fail(res.data, 1.5);
            }
        })
    }

    render() {
        let emailTest = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;

        return (
            <div className="da_jiang_change">
                <BackHeader
                    path="/index/my"
                    title="修改大匠资料"
                />
                <Upload
                    type="photo"
                    id="photo_da_jiang"
                    imgSrc={this.state.professionalPhotoPath}
                    container="photo_da_jiang_box"
                    content="请上传本人照片"
                    change={this.getPhotoPathValue}
                />
                <div className="change_content">
                    <TextInput
                        label="姓名"
                        type="text"
                        placeholder="请输入姓名"
                        textValue={this.state.professionalName}
                        readOnly={true}
                        changeTextValue={this.getProfessionalNameValue}
                    />
                    <TextInput
                        label="职位"
                        type="text"
                        max="50"
                        placeholder="请输入在公司的职位"
                        textValue={this.state.professionalPosition}
                        changeTextValue={this.getProfessionalPositionValue}
                    />
                    <WhiteSpace size="sm"/>
                    <TextInput
                        label="邮箱"
                        type="text"
                        max="100"
                        test={emailTest}
                        placeholder="请输入邮箱"
                        errTip="请检查输入的邮箱"
                        textValue={this.state.professionalEmail}
                        changeTextValue={this.getProfessionalEmailValue}
                    />
                    <SelectInput
                        data={window.LIST.eduList}
                        title="选择学历"
                        label="最高学历"
                        cols={1}
                        getChangeSelectValue={this.getProfessionalHighEducValue}
                    />
                    <TextInput
                        label="任职机构"
                        type="text"
                        max="100"
                        placeholder="请输入所在的公司"
                        textValue={this.state.professionalWorkunit}
                        changeTextValue={this.getProfessionalWorkunitValue}
                    />
                    <WhiteSpace size="sm"/>
                    <TextInput
                        label="手机号"
                        type="text"
                        placeholder="请输入手机号码"
                        max={11}
                        test={phoneTest}
                        errTip="手机号输入格式有误, 请检查"
                        textValue={this.state.professionalPhone}
                        changeTextValue={this.getProfessionalPhoneValue}
                    />
                    <TextInput
                        label="专业领域"
                        type="text"
                        max="50"
                        placeholder="请输入专业领域"
                        textValue={this.state.professionalField}
                        changeTextValue={this.getProfessionalFieldValue}
                    />
                    <SelectInput
                        data={window.LIST.professionalTypeList}
                        title="选择大匠的分类"
                        label="大匠分类"
                        cols={2}
                        getChangeSelectValue={this.getProfessionalTypeIdValue}
                    />
                    <WhiteSpace size="sm"/>
                    <div className="professional_textarea">
                        <div className="textarea_title">
                            大匠简介
                        </div>
                        <div className="textarea_content">
                            <TextareaItem
                                rows={3}
                                count={500}
                                placeholder="不可超过500字"
                                value={this.state.professionalIntroduction}
                                onChange={this.getProfessionalIntroductionValue}
                            />
                        </div>
                    </div>
                    <WhiteSpace size="lg"/>
                    <div className="professional_submit" onClick={this.handleProfessionalSubmit}>
                        保存
                    </div>
                    <WhiteSpace size="lg"/>
                </div>
            </div>
        )
    }
}
