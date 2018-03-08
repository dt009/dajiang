/**
 * @author v_duantao
 * @file 成为经纪人的页面
 * @date 17/9/24 下午8:39
 */

import React, {Component} from 'react';

import './createBroker.less';

import Fetch from 'fetch';
import Radio from 'formItem/radio/radio';
import Upload from 'upload/upload';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';
import DateInput from 'formItem/dateInput/dateInput';
import SelectInput from 'formItem/selectInput/selectInput';
import {WhiteSpace, TextareaItem, Toast} from 'antd-mobile';



const ckoIscertification = [
    {
        value: '0',
        label: '否'
    },
    {
        value: '1',
        label: '是'
    }
];
const ckoIssearch = [
    {
        value: '0',
        label: '不可见'
    },
    {
        value: '1',
        label: '可见'
    }
];


export default class CreateBroker extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ckoIssearch:'0',//是否可以被查找
            ckoIscertification:'0',// 是否实名认证
            eduList: [],        // 学历列表
            cityList: [],           // 城市列表
            regionId: [],           // 常驻城市
            radioValue: '0',
            isCertification:"none",
            ckoApplyEmail:'',
            ckoIdFront:'',
            ckoIdBack:'',
            ckoPhone:'',
            ckoIdcard:'',
            ckoApplyEmail:'',
            ckoNickname:'',
            ckoName:'',
            regionName:'',
            professionalIntroduction:''

        };
        this.ckoIscertification = this.getckoIscertification.bind(this);
        this.getckoIssearch = this.getckoIssearch.bind(this);
        this.ckoApplyEmail = this.ckoApplyEmail.bind(this);
        this.getckoIdFront = this.getckoIdFront.bind(this);
        this.getckoIdBack = this.getckoIdBack.bind(this);
        this.getckoPhone = this.getckoPhone.bind(this);
        this.getckoIdcard = this.getckoIdcard.bind(this);
        this.ckoApplyEmail = this.ckoApplyEmail.bind(this);
        this.getckoNickname = this.getckoNickname.bind(this);
        this.getckoName = this.getckoName.bind(this);
        this.getRegionIdValue = this.getRegionIdValue.bind(this);
        this.handleSave = this.handleSave.bind(this);
        this.getProfessionalIntroductionValue = this.getProfessionalIntroductionValue.bind(this);
    }
    // 获取常驻城市韩式
    getRegionIdValue(value) {
        this.setState({
            regionId: value[1]
        })
    }
    componentDidMount() {
        let that = this;
        // 获取学历列表
        Fetch.get('public/dict/queryDegreeCode').then(res => {
            let data = res.data;
            let eduList = [];
            data.map(item => {
                let li = {
                    value: item.itemCode,
                    label: item.itemValue
                };
                eduList.push(li);
            });
            that.setState({
                eduList: eduList
            })
        });

        // 获取城市
        this.getCityList(1);
        // this.getProfessionalTypeList(0);
    }
    getckoName(value){
        this.setState({
            ckoName:value
        })
    }
    getckoNickname(value){
        this.setState({
            ckoNickname:value
        })
    }
    ckoApplyEmail(value){
        this.setState({
            ckoApplyEmail:value
        })
    }

    getckoIdcard(value){
        this.setState({
            ckoIdcard:value
        })
    }
    getckoPhone(value){
        this.setState({
            ckoPhone: value
        })
    }
    componentDidUpdate(){
        // console.log(this.state);
    }
    getckoIdBack(value){
        this.setState({
            ckoIdBack: value
        })
    }
    getckoIssearch(value){
        this.setState({
            ckoIssearch: value
        })
    }
    ckoApplyEmail(value){
        this.setState({
            ckoApplyEmail: value
        })

    }
    getckoIdFront(value){
        this.setState({
            ckoIdFront: value
        })
    }
    getckoIscertification(value) {
        // console.log(this.state.isCertification)
        // console.log(this.state.radioValue)

        this.setState({
            ckoIscertification: value
        })
        // console.log(this.state.radioValue);
        if(this.state.ckoIscertification=="1"){
            this.setState({
                isCertification: "none"
            })
        }else{
            this.setState({
                isCertification: "block"
            })
        }

    }
    getProfessionalIntroductionValue(value) {
        this.setState({professionalIntroduction: value});
    }
    // 获取城市的函数
    getCityList(value) {
        if (value >= 33) {
            return false;
        }
        let that = this;
        let url = `public/region/queryByPid/${value}`;
        Fetch.get(url).then(res => {
            let data = res.data;
            let cityList = this.state.cityList;
            if (data.length !== 0) {
                if (value === 1) {
                    data.map(item => {
                        let li = {
                            value: item.regionId,
                            label: item.regionName,
                            children: this.getCityList(item.regionId)
                        };
                        cityList.push(li);
                    });
                } else {
                    let child = [];
                    data.map(item => {
                        let chilList = {
                            value: item.regionId,
                            label: item.regionName,
                        };
                        child.push(chilList);
                    });
                    cityList[value - 2].children = child;
                }
            }

            that.setState({
                cityList: cityList
            })
        })
    }
    handleSave(){
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        let emailTest = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let idCardText = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
        let param = this.state;



        // if (param.ckoIdcard.length === 0 && param.ckoIscertification == "1") {
        //     return  Toast.fail('请输入身份证号码', 1);
        // } else if(param.ckoIdcard.length !==0 && param.ckoIscertification == "0"){
        //     if (param.ckoIdFront.length === 0) {
        //         return  Toast.fail('请上传身份证正面照片', 1);
        //     }
        //     if (param.ckoIdBack.length === 0) {
        //         return  Toast.fail('请上传身份证反面照片', 1);
        //     }
        //
        // }
        // if (param.ckoPhone.length === 0) {
        //     return  Toast.fail('请输入手机号', 1);
        // } else if (!phoneTest.test(param.ckoPhone)){
        //     return  Toast.fail('手机号格式有误,重新输入', 1);
        // }
        //
        // if (param.ckoApplyEmail && !emailTest.test(param.ckoApplyEmail)) {
        //     return  Toast.fail('邮箱输入格式有误,重新输入', 1);
        // }
        // if (param.regionId.length === 0) {
        //     return  Toast.fail('请选择注册城市', 1);
        // }
        //
        //
        // if (param.ckoNickname.length === 0) {
        //     return  Toast.fail('请填写昵称', 1);
        // }
        // if (param.ckoName.length === 0) {
        //     return  Toast.fail('真实姓名', 1);
        // }

        // userId = "3";
        // let data = {
        //     ckoApplyEmail:this.state.ckoApplyEmail,
        //     ckoIdBack:this.state.ckoIdBack,
        //     ckoIdFront:this.state.ckoIdFront,
        //     ckoIdcard:this.state.ckoIdcard,
        //     ckoIscertification:this.state.ckoIscertification,
        //     ckoIssearch:this.state.ckoIssearch,
        //     ckoName:this.state.ckoName,
        //     ckoNickname:this.state.ckoNickname,
        //     regionId:this.state.regionId,
        //     // userId:userId
        //
        //
        // };
        let data = {
            professionalIntroduction:this.state.professionalIntroduction,
            ckoIssearch:this.state.ckoIssearch

        }
        Fetch.post('private/user/sendBeCKOVertif', data).then(res => {
            if (res.flag === 1) {
                Toast.success('提交成功, 等待审核', 1.5);
                window.location.hash = '/index/my';
            } else {
                Toast.fail(res.message, 1.5)
            }
        });
    }

    render() {
        // console.log(this.state.isCertification)

        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        let cardID = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        // console.log(this.state.cityList)
        // const isCertification = this.state.radioValue === '1'
        // ?
        // : "多谢夸奖"
        return (
            <div className="createBroker_component">
                <BackHeader path="/index/my" title="成为经纪人"/>
                {/* <div className="createBroker_container">
                    <Radio
                        data={ckoIscertification}
                        name="test"
                        value={this.state.ckoIscertification}
                        getRadioValue={this.ckoIscertification}
                        title="是否实名认证"
                    />
                </div> */}
                {/* <WhiteSpace size="sm"/> */}

                {/* <div className="createBroker_container"> */}
                    {/* <TextInput
                        label="昵称"
                        type="text"
                        placeholder="请输入昵称"
                        textValue={this.state.ckoNickname}
                        changeTextValue={this.getckoNickname}
                    /> */}
                    {/* <div style={{display:this.state.isCertification}}> */}
                        {/* <TextInput

                            label="真实姓名"
                            type="text"
                            placeholder="请输入姓名"
                            textValue={this.state.ckoName}
                            changeTextValue={this.getckoName}
                        />
                    </div> */}
                    {/* <TextInput
                        label="手机号"
                        type="text"
                        placeholder="请输入手机号码"
                        max={11}
                        test={phoneTest}
                        errTip="手机号输入格式有误, 请检查"
                        textValue={this.state.ckoPhone}
                        changeTextValue={this.getckoPhone}
                    /> */}
                {/* </div> */}
                {/* <WhiteSpace size="sm"/> */}

                {/* <div className="" > */}

                    {/* <TextInput
                        label="邮箱"
                        type="text"
                        placeholder="请输入邮箱"
                        textValue={this.state.ckoApplyEmail}
                        changeTextValue={this.ckoApplyEmail}
                    /> */}
                    {/* <SelectInput
                        data={this.state.cityList}
                        title="选择常驻城市"
                        label="常驻城市"
                        cols={2}
                        getChangeSelectValue={this.getRegionIdValue}
                    /> */}
                    {/* <span style={{display:this.state.isCertification}} >
                        <TextInput
                            label="身份证号"
                            type="text"
                            placeholder="请输入身份证"
                            max={18}
                            test={cardID}
                            errTip="手机号输入格式有误, 请检查"
                            textValue={this.state.ckoIdcard}
                            changeTextValue={this.getckoIdcard}
                        />
                    </span>
                    <WhiteSpace size="lg"/> */}
                    {/* <div className="Upload_isCertification" style={{display:this.state.isCertification}}>

                        <div className="photo_title">
                            身份证正面
                        </div>
                        <WhiteSpace size="sm"/>
                        <Upload
                            type="photograph"
                            id="photo_box1"
                            imgSrc={this.state.ckoIdFront}
                            container="photograph_box1"
                            content="必填"
                            change={this.getckoIdFront}
                        />
                        <WhiteSpace size="sm"/>
                        <div className="photo_title">
                            身份证反面
                        </div>
                        <WhiteSpace size="sm"/>
                        <Upload
                            type="photograph"
                            id="photo_box2"
                            imgSrc={this.state.ckoIdBack}
                            container="photograph_box2"
                            content="必填"
                            change={this.getckoIdBack}
                        />
                    </div>
                    <WhiteSpace size="sm"/> */}
                    <div className="textarea_content">
                        <TextareaItem
                            rows={3}
                            count={500}
                            placeholder="知识经纪人说明:"
                            value={this.state.professionalIntroduction}
                            onChange={this.getProfessionalIntroductionValue}
                        />
                    </div>
                    <div className="createBroker_container">
                        <Radio
                            data={ckoIssearch}
                            name="init"
                            value={this.state.ckoIssearch}
                            getRadioValue={this.getckoIssearch}
                            title="是否可以被查找"
                        />
                    </div>
                    <WhiteSpace size="lg"/>

                {/* </div> */}
                <div className="professional_submit" onClick={this.handleSave}>
                    保存
                </div>
                <WhiteSpace size="lg"/>
            </div>
        )
    }
}
