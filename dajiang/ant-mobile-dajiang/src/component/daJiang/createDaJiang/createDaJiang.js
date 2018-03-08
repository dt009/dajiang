/**
 * @author v_duantao
 * @file 成为大匠页面
 * @date 17/9/24 下午8:34
 */

import React, {Component} from 'react';

import './createDaJiang.less';
import {WhiteSpace, TextareaItem, Toast} from 'antd-mobile';

import Fetch from 'fetch';
import Upload from 'upload/upload';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';
import DateInput from 'formItem/dateInput/dateInput';
import SelectInput from 'formItem/selectInput/selectInput';


export default class CreateDaJiang extends Component {
    constructor(props) {
        super(props);
        this.state = {
            professionalPhotoPath: '', // 本人照片
            professionalName: '',  // 大匠姓名
            professionalIdcard: '', // 身份证号码
            professionalGender: '1', // 性别
            professionalBirth: '',  // 生日
            professionalPhone: '',  // 手机号
            professionalEmail: '',  // 邮箱
            professionalWorkdt: '', // 从业起始时间
            professionalHighEduc: '', // 最高学历
            professionalWorkunit: '', // 任职机构 所在公司
            professionalPosition: '', // 职位
            regionId: '',           // 常驻城市
            professionalField: '', // 专业领域
            professionalTypeId: '', // 大匠分类
            professionalIntroduction: '', // 大匠简介
            professionalIdFront: '', // 身份证正面
            professionalIdBack: '', // 身份证反面
            qualificationPicList: [], // 职业资格证书
            qualificationPicListNumber: [], // 职业资格证书个数
            certificatePicList: [], // 获奖证明
            certificatePicListNumber: [], // 获奖证明的个数
            otherPicList: [], // 其他材料
            otherPicListNumber: [], // 其他材料的个数
        };

        this.getPhotoPathValue = this.getPhotoPathValue.bind(this);
        this.getProfessionalNameValue = this.getProfessionalNameValue.bind(this);
        this.getProfessionalGenderValue = this.getProfessionalGenderValue.bind(this);
        this.getProfessionalBirthValue = this.getProfessionalBirthValue.bind(this);
        this.getProfessionalIdcardValue = this.getProfessionalIdcardValue.bind(this);
        this.getProfessionalPhoneValue = this.getProfessionalPhoneValue.bind(this);
        this.getProfessionalEmailValue = this.getProfessionalEmailValue.bind(this);
        this.getProfessionalWorkdtValue = this.getProfessionalWorkdtValue.bind(this);
        this.getProfessionalHighEducValue = this.getProfessionalHighEducValue.bind(this);
        this.getProfessionalWorkunitValue = this.getProfessionalWorkunitValue.bind(this);
        this.getProfessionalPositionValue = this.getProfessionalPositionValue.bind(this);
        this.getRegionIdValue = this.getRegionIdValue.bind(this);
        this.getProfessionalFieldValue = this.getProfessionalFieldValue.bind(this);
        this.getProfessionalTypeIdValue = this.getProfessionalTypeIdValue.bind(this);
        this.getProfessionalIntroductionValue = this.getProfessionalIntroductionValue.bind(this);
        this.getProfessionalIdFrontValue = this.getProfessionalIdFrontValue.bind(this);
        this.getProfessionalIdBackValue = this.getProfessionalIdBackValue.bind(this);
        this.getQualificationPicListValue = this.getQualificationPicListValue.bind(this);
        this.handleClickAddUpload = this.handleClickAddUpload.bind(this);
        this.getCertificatePicListValue = this.getCertificatePicListValue.bind(this);
        this.getOtherPicListValue = this.getOtherPicListValue.bind(this);
        this.handleProfessionalSubmit = this.handleProfessionalSubmit.bind(this);
    }

    componentDidMount() {
        let that = this;
    }


    componentDidUpdate() {
        // console.log(this.state);
    }

    // 获取本人照片的路径
    getPhotoPathValue(value) {
        this.setState({
            professionalPhotoPath: value
        })
    }

    // 获取大匠姓名
    getProfessionalNameValue(value) {
        this.setState({
            professionalName: value
        })
    }

    // 获取性别
    getProfessionalGenderValue(value) {
        this.setState({
            professionalGender: value[0]
        })
    }

    // 获取生日
    getProfessionalBirthValue(value) {
        this.setState({
            professionalBirth: value
        })
    }

    // 获取身份证号码
    getProfessionalIdcardValue(value) {
        this.setState({professionalIdcard: value});
    }

    // 获取手机号
    getProfessionalPhoneValue(value) {
        this.setState({
            professionalPhone: value
        })
    }

    // 获取邮箱
    getProfessionalEmailValue(value) {
        this.setState({
            professionalEmail: value
        })
    }

    // 获取从业起始时间
    getProfessionalWorkdtValue(value) {
        this.setState({
            professionalWorkdt: value
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

    // 获取职位的函数
    getProfessionalPositionValue(value) {
        this.setState({
            professionalPosition: value
        })
    }

    // 获取常驻城市韩式
    getRegionIdValue(value) {
        this.setState({
            regionId: value[1]
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

    // 获取身份证正面
    getProfessionalIdFrontValue(value) {
        this.setState({professionalIdFront: value})
    }

    // 获取身份证反面
    getProfessionalIdBackValue(value) {
        this.setState({professionalIdBack: value})
    }


    // 添加组件
    handleClickAddUpload(e) {
        let target = e.target;
        let type = target.attributes.type.nodeValue;
        switch (type) {
            case '1':
                let num = this.state.qualificationPicListNumber;
                num.push('1');
                this.setState({
                    qualificationPicListNumber: num
                });
                break;
            case '2':
                let num2 = this.state.certificatePicListNumber;
                num2.push('2');
                this.setState({
                    certificatePicListNumber: num2
                });
                break;
            case '3':
                let num3 = this.state.otherPicListNumber;
                num3.push('3');
                this.setState({
                    otherPicListNumber: num3
                });
                break;
        }
    }

    // 获取职业资格证书
    getQualificationPicListValue(value) {
        let list = this.state.qualificationPicList;
        list.push(value);
        this.setState({qualificationPicList: list})
    }

    // 获取获奖证明
    getCertificatePicListValue(value) {
        let list = this.state.certificatePicList;
        list.push(value);
        this.setState({certificatePicList: list})
    }

    // 获取其他材料
    getOtherPicListValue(value) {
        let list = this.state.otherPicList;
        list.push(value);
        this.setState({otherPicList: list})
    }

    // 保存提交
    handleProfessionalSubmit() {
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        let emailTest = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let idCardText = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
        let param = this.state;
        let that = this;
        if (param.professionalPhotoPath.length === 0) {
            return Toast.fail('请上传本人传照片', 1);
        }
        if (param.professionalName.length === 0) {
            return Toast.fail('请输入姓名', 1);
        }
        if (param.professionalGender.length === 0) {
            return Toast.fail('请选择性别', 1);
        }
        // if (param.professionalIdcard.length === 0) {
        //     return  Toast.fail('请输入身份证号码', 1);
        // } else if (!idCardText.test(param.professionalIdcard)) {
        //     return  Toast.fail('身份证号码格式错误, 重新输入', 1);
        // }

        // if (param.professionalPhone.length === 0) {
        //     return  Toast.fail('请输入手机号', 1);
        // } else if (!phoneTest.test(param.professionalPhone)){
        //     return  Toast.fail('手机号格式有误,重新输入', 1);
        // }

        // if (param.professionalHighEduc.length === 0) {
        //     return  Toast.fail('请选择最高学历', 1);
        // }

        if (param.professionalWorkunit.length === 0) {
            return Toast.fail('请输入任职机构', 1);
        }
        if (param.professionalPosition.length === 0) {
            return Toast.fail('请输入职位', 1);
        }
        // if (param.professionalEmail && !emailTest.test(param.professionalEmail)) {
        //     return  Toast.fail('邮箱输入格式有误,重新输入', 1);
        // }

        if (param.regionId.length === 0) {
            return Toast.fail('请选择注册城市', 1);
        }

        // if (param.professionalField.length === 0) {
        //     return  Toast.fail('请输入专业领域', 1);
        // }

        if (param.professionalTypeId.length === 0) {
            return Toast.fail('请选择大匠分类', 1);
        }

        // if (param.professionalIdFront.length === 0) {
        //     return Toast.fail('请上传身份证正面照片', 1);
        // }
        // if (param.professionalIdBack.length === 0) {
        //     return Toast.fail('请上传身份证反面照片', 1);
        // }
        // if (param.qualificationPicList.length === 0) {
        //     return  Toast.fail('请上传职业资格证', 1);
        // }
        Fetch.post('private/user/sendBeProfVerif', param).then(res => {
            if (res.flag === 1) {
                Toast.success('提交成功', 1.5);
                setTimeout(() => {
                    that.props.history.push('/index/my')
                }, 1500)
            } else {
                Toast.fail(res.message, 1.5)
            }
        });
    }

    render() {
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        let emailTest = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let idCardText = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
        return (
            <div className="da_jiang_box">
                <BackHeader path="/index/my" title="成为大匠"/>
                <div className="box_content">
                    <Upload
                        type="photo"
                        id="photo_da_jiang"
                        imgSrc={this.state.professionalPhotoPath}
                        container="photo_da_jiang_box"
                        content="请上传本人照片"
                        change={this.getPhotoPathValue}
                    />
                    <div className="content_list">
                        <TextInput
                            label="姓名"
                            type="text"
                            placeholder="请输入姓名"
                            textValue={this.state.professionalName}
                            changeTextValue={this.getProfessionalNameValue}
                        />
                        <SelectInput
                            data={window.LIST.sexList}
                            title="请选择性别"
                            label="性别"
                            cols={1}
                            getChangeSelectValue={this.getProfessionalGenderValue}
                        />
                        <TextInput
                            label="任职机构"
                            type="text"
                            max="100"
                            placeholder="请输入所在的公司"
                            textValue={this.state.professionalWorkunit}
                            changeTextValue={this.getProfessionalWorkunitValue}
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
                        <SelectInput
                            data={window.LIST.cityList}
                            title="选择常驻城市"
                            label="常驻城市"
                            cols={2}
                            getChangeSelectValue={this.getRegionIdValue}
                        />
                        <DateInput
                            label="从业时间"
                            title="请选择从业时间"
                            value={this.state.professionalWorkdt}
                            getDateValue={this.getProfessionalWorkdtValue}
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
                        <div className="photo_title">
                            身份证正面
                        </div>
                        <WhiteSpace size="sm"/>
                        <Upload
                            type="photograph"
                            id="photo_box1"
                            imgSrc={this.state.professionalIdFront}
                            container="photograph_box1"
                            content="可选"
                            change={this.getProfessionalIdFrontValue}
                        />
                        <WhiteSpace size="sm"/>
                        <div className="photo_title">
                            身份证反面
                        </div>
                        <WhiteSpace size="sm"/>
                        <Upload
                            type="photograph"
                            id="photo_box2"
                            imgSrc={this.state.professionalIdBack}
                            container="photograph_box2"
                            content="可选"
                            change={this.getProfessionalIdBackValue}
                        />
                        {/*<DateInput*/}
                        {/*label="生日"*/}
                        {/*title="请选择出生日期"*/}
                        {/*value={this.state.professionalBirth}*/}
                        {/*getDateValue={this.getProfessionalBirthValue}*/}
                        {/*/>*/}
                        {/*<TextInput*/}
                        {/*label="身份证号"*/}
                        {/*type="text"*/}
                        {/*max="18"*/}
                        {/*test={idCardText}*/}
                        {/*placeholder="请输入身份证号码"*/}
                        {/*textValue={this.state.professionalIdcard}*/}
                        {/*changeTextValue={this.getProfessionalIdcardValue}*/}
                        {/*/>*/}
                        <WhiteSpace size="sm"/>
                        {/*<TextInput*/}
                        {/*label="手机号"*/}
                        {/*type="text"*/}
                        {/*placeholder="请输入手机号码"*/}
                        {/*max={11}*/}
                        {/*test={phoneTest}*/}
                        {/*errTip="手机号输入格式有误, 请检查"*/}
                        {/*textValue={this.state.professionalPhone}*/}
                        {/*changeTextValue={this.getProfessionalPhoneValue}*/}
                        {/*/>*/}
                        {/*<TextInput*/}
                        {/*label="邮箱"*/}
                        {/*type="text"*/}
                        {/*max="100"*/}
                        {/*test={emailTest}*/}
                        {/*errTip="请检查邮箱输入"*/}
                        {/*placeholder="请输入邮箱"*/}
                        {/*textValue={this.state.professionalEmail}*/}
                        {/*changeTextValue={this.getProfessionalEmailValue}*/}
                        {/*/>*/}

                        <WhiteSpace size="sm"/>
                        {/*<SelectInput*/}
                        {/*data={window.LIST.eduList}*/}
                        {/*title="选择学历"*/}
                        {/*label="最高学历"*/}
                        {/*cols={1}*/}
                        {/*getChangeSelectValue={this.getProfessionalHighEducValue}*/}
                        {/*/>*/}

                        {/*<TextInput*/}
                        {/*label="专业领域"*/}
                        {/*type="text"*/}
                        {/*max="50"*/}
                        {/*placeholder="请输入专业领域"*/}
                        {/*textValue={this.state.professionalField}*/}
                        {/*changeTextValue={this.getProfessionalFieldValue}*/}
                        {/*/>*/}


                        {/*=============   各种证书  ======================*/}
                        {/*<WhiteSpace size="sm"/>*/}
                        {/*<div className="photo_title">*/}
                        {/*职业资格证书*/}
                        {/*<span type="1" onClick={this.handleClickAddUpload}>添加更多</span>*/}
                        {/*</div>*/}
                        {/*<WhiteSpace size="sm"/>*/}
                        {/*<Upload*/}
                        {/*type="photograph"*/}
                        {/*id="photo_box3"*/}
                        {/*imgSrc={this.state.qualificationPicList[0]}*/}
                        {/*container="photograph_box3"*/}
                        {/*content="必填"*/}
                        {/*change={this.getQualificationPicListValue}*/}
                        {/*/>*/}
                        {/*{*/}
                        {/*this.state.qualificationPicListNumber.map((item, key) => {*/}
                        {/*let now = new Date();*/}
                        {/*let time = now.getTime();*/}
                        {/*return (*/}
                        {/*<Upload*/}
                        {/*key={key}*/}
                        {/*type="photograph"*/}
                        {/*id={`photo_box${time}`}*/}
                        {/*imgSrc={this.state.qualificationPicList[key + 1]}*/}
                        {/*container={`photograph_box${time}`}*/}
                        {/*content="选填"*/}
                        {/*change={this.getQualificationPicListValue}*/}
                        {/*/>*/}
                        {/*)*/}
                        {/*})*/}
                        {/*}*/}
                        {/*<WhiteSpace size="sm"/>*/}
                        {/*<div className="photo_title">*/}
                        {/*获奖证明*/}
                        {/*<span type="2" onClick={this.handleClickAddUpload}>添加更多</span>*/}
                        {/*</div>*/}
                        {/*<WhiteSpace size="sm"/>*/}
                        {/*<Upload*/}
                        {/*type="photograph"*/}
                        {/*id="photo_box4"*/}
                        {/*imgSrc={this.state.certificatePicList[0]}*/}
                        {/*container="photograph_box4"*/}
                        {/*content="选填"*/}
                        {/*change={this.getCertificatePicListValue}*/}
                        {/*/>*/}
                        {/*{*/}
                        {/*this.state.certificatePicListNumber.map((item, key) => {*/}
                        {/*let now = new Date();*/}
                        {/*let time = now.getTime();*/}
                        {/*return (*/}
                        {/*<Upload*/}
                        {/*key={key}*/}
                        {/*type="photograph"*/}
                        {/*id={`photo_box${time}`}*/}
                        {/*imgSrc={this.state.certificatePicList[key+1]}*/}
                        {/*container={`photograph_box${time}`}*/}
                        {/*content="选填"*/}
                        {/*change={this.getCertificatePicListValue}*/}
                        {/*/>*/}
                        {/*)*/}
                        {/*})*/}
                        {/*}*/}
                        {/*<WhiteSpace size="sm"/>*/}
                        {/*<div className="photo_title">*/}
                        {/*其他材料*/}
                        {/*<span type="3" onClick={this.handleClickAddUpload}>添加更多</span>*/}
                        {/*</div>*/}
                        {/*<WhiteSpace size="sm"/>*/}
                        {/*<Upload*/}
                        {/*type="photograph"*/}
                        {/*id="photo_box5"*/}
                        {/*imgSrc={this.state.otherPicList[0]}*/}
                        {/*container="photograph_box5"*/}
                        {/*content="选填"*/}
                        {/*change={this.getOtherPicListValue}*/}
                        {/*/>*/}
                        {/*{*/}
                        {/*this.state.otherPicListNumber.map((item, key) => {*/}
                        {/*let now = new Date();*/}
                        {/*let time = now.getTime();*/}
                        {/*return (*/}
                        {/*<Upload*/}
                        {/*key={key}*/}
                        {/*type="photograph"*/}
                        {/*id={`photo_box${time}`}*/}
                        {/*imgSrc={this.state.otherPicList[key + 1]}*/}
                        {/*container={`photograph_box${time}`}*/}
                        {/*content="选填"*/}
                        {/*change={this.getOtherPicListValue}*/}
                        {/*/>*/}
                        {/*)*/}
                        {/*})*/}
                        {/*}*/}
                        <WhiteSpace size="lg"/>
                        <div className="professional_submit" onClick={this.handleProfessionalSubmit}>
                            提交
                        </div>
                        <WhiteSpace size="lg"/>
                    </div>
                </div>
            </div>
        );
    }
}