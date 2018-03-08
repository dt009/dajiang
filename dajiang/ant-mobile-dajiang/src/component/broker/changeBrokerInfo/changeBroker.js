/**
 * @author v_duantao and wackeCq
 * @file 修改知识经纪人的页面
 * @date 17/9/24 下午8:43
 */

import React, {Component} from 'react';
import './changeBroker.less'
import {WhiteSpace,Toast} from 'antd-mobile';
import Fetch from 'fetch';



import BackHeader from 'backHeader/backHeader';
import Radio from 'formItem/radio/radio';

import TextInput from 'formItem/textInput/textInput';
import SelectInput from 'formItem/selectInput/selectInput';


const radioData = [
    {
        value: '0',
        label: '不可见'
    },
    {
        value: '1',
        label: '可见'
    }
];

export default class ChangeBroker extends Component {
    constructor(props) {
        super(props);
        this.state = {
            radioValue: '0',
            ckoNickname:'',
            professionalPhone:'',
            ckoEmail:'',
            regionId: 0,
            detail: {},
            cityList: []
        };
        this.getRadioValue = this.getRadioValue.bind(this);
        this.getProfessionalNameValue = this.getProfessionalNameValue.bind(this);
        this.getProfessionalPhoneValue = this.getProfessionalPhoneValue.bind(this);
        this.getProfessionalEmailValue = this.getProfessionalEmailValue.bind(this);

    }
    getProfessionalPhoneValue(e){
        this.setState({
            professionalPhone:e
        })
    }
    getProfessionalEmailValue(e){
        this.setState({
            ckoEmail:e
        })
    }
    getProfessionalNameValue(e){
        this.setState({
            ckoNickname:e
        })
    }

    componentWillMount() {
        Fetch.post(`private/user/initCKO`, {}).then(
            res => {
                if (res.flag !== 1) {
                    return;
                }
                this.setState({
                    detail: res.data,
                    ckoNickname: res.data.ckoNickname || '',
                    professionalPhone: res.data.professionalPhone || '',
                    ckoEmail: res.data.ckoEmail || '',
                    radioValue: res.data.ckoIssearch + '' || '',
                    regionId: res.data.regionId || 0,
                });
            }
        );
        this.getCityList(1);
    }

    getRadioValue(value) {
        this.setState({
            radioValue: value
        })
    }
    handlesave = () => {
        // Toast.fail(this.state, 1.5)
        // Fetch.post('login', data).then(res => {
        //     if (res.flag === 1) {
        //         Toast.fail(res.message, 1.5);
        //     }else{
        //         Toast.fail("接口还没有",1.5)
        //     }
        // })
        let data = {...this.state.detail, ckoNickname: this.state.ckoNickname, ckoEmail: this.state.ckoEmail, ckoIssearch: this.state.radioValue / 1, regionId: this.state.regionId };
        Fetch.post(`private/user/updateCKO`, data).then(
            res => {
                if (res.flag !== 1) {
                    return;
                }
                Toast.info('修改知识经济人资料成功!', 1.5, () => {
                    this.props.history.replace('/index/my');
                });
            }
        );
    }

    // 获取常驻城市韩式
    setRegionId = (value) => {
        this.setState({
            regionId: value[1]
        })
    }

    // 获取城市的函数
    getCityList = (value) => {
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

    render() {
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        return (
            <div className="change_broker">
                <BackHeader
                    path="/index/my"
                    title="修改知识经济人资料"
                />
                <div className="broker_container">
                    {/* <TextInput
                        label="昵称"
                        type="text"
                        placeholder="请输入昵称"
                        textValue={this.state.ckoNickname}
                        changeTextValue={this.getProfessionalNameValue}
                    /> */}
                    <SelectInput
                        data={this.state.cityList}
                        title="选择常驻城市"
                        label="常驻城市"
                        cols={2}
                        getChangeSelectValue={this.setRegionId}
                    />
                    {/* <TextInput
                        label="手机号"
                        type="text"
                        placeholder="请输入手机号码"
                        max={11}
                        test={phoneTest}
                        errTip="手机号输入格式有误, 请检查"
                        textValue={this.state.professionalPhone}
                        changeTextValue={this.getProfessionalPhoneValue}
                    /> */}
                    <TextInput
                        label="邮箱"
                        type="text"
                        placeholder="请输入邮箱"
                        textValue={this.state.ckoEmail}
                        changeTextValue={this.getProfessionalEmailValue}
                    />
                </div>
                <div className="change_broker_content">
                    <Radio
                        data={radioData}
                        value={this.state.radioValue}
                        getRadioValue={this.getRadioValue}
                        title="是否可被查找"
                    />
                </div>
                <WhiteSpace size="lg"/>
                <div className="professional_submit" onClick = {this.handlesave}>
                    保存
                </div>
                <WhiteSpace size="lg"/>
            </div>
        )
    }
}
