/**
 * @author v_duantao
 * @file 成为大匠
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './CreateProfessional.less';
import '../common/upload.less';
import Fetch from 'Fetch/Fetch'
import moment from 'moment';
//import Upload from '../upload/upload';
import ImgUpload from 'imgUpload/imgUpload';
import {Radio,Cascader,DatePicker,Input ,Select,Button, Modal, Checkbox, message} from 'antd';
const RadioGroup = Radio.Group;
const Option = Select.Option;

export default class CreateProfessional extends Component {
    constructor(props) {
        super(props);
        this.state = {
            professionalPhotoPath: '', // 本人照片
            professionalName: '',  // 大匠姓名
            professionalIdcard: '', // 身份证号码
            professionalGender: 1, // 性别
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
            sexList: [],
            cityList: [],
            city2List: []
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

        this.handleCityChange = this.handleCityChange.bind(this);
        this.handleCity2Change = this.handleCity2Change.bind(this);
    }

    componentDidMount() {
        // 获取性别
        /*Fetch.get('public/dict/querySexCode').then(res => {
         let data = res.data;
         this.setState({
         sexList: data
         })
         });*/
        /*Fetch.get('public/region/queryByPid/1').then(res => {
         let data = res.data;
         this.setState({
         cityList: data
         })
         })*/
    }

    getCityList(value) {
        let that = this;
        if (value >= 33) {
            return false;
        }
        let url = `public/region/queryByPid/${value}`;
        Fetch.get(url).then(res => {
            let data = res.data;
            if (data.length !== 0) {
                if (value === 1) {
                    data.map(item => {
                        let li = {
                            value: item.regionId,
                            label: item.regionName,
                            children: []
                        };
                        this.getCityList(item.regionId);
                        let cityList = this.state.cityList;
                        cityList.push(li);
                        this.setState({
                            cityList: cityList
                        })
                    });
                } else {
                    /*let cityList=that.state.cityList;
                     let parent=cityList.cityList[value-2];
                     console.log(cityList);
                     data.map(item => {
                     let chilList = {
                     value: item.regionId,
                     label: item.regionName
                     };

                     parent.children.push(chilList);
                     that.setState({
                     cityList: cityList
                     })
                     });*/
                }
            }
            console.log(this.state.cityList);
        })
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
    getProfessionalNameValue(event) {
        console.log(event.target.value);
        this.setState({
            professionalName: event.target.value
        })
    }

    // 获取性别
    getProfessionalGenderValue(e) {
        console.log(e.target.value)
        this.setState({
            professionalGender: e.target.value
        })
    }

    // 获取生日
    getProfessionalBirthValue(value) {
        let dateShowValue = this.handleFilterDateTime(value);
        console.log(dateShowValue);
        this.setState({
            professionalBirth: dateShowValue
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
        let dateShowValue = this.handleFilterDateTime(value);
        console.log(dateShowValue);
        this.setState({
            professionalWorkdt: dateShowValue
        })
    }

    // 获取最高学历
    getProfessionalHighEducValue(value) {
        console.log(value)
        this.setState({
            professionalHighEduc: value
        })
    }

    // 获取任职机构的函数
    getProfessionalWorkunitValue(event) {
        console.log('机构:', event.target.value);
        this.setState({
            professionalWorkunit: event.target.value
        })
    }

    // 获取职位的函数
    getProfessionalPositionValue(event) {
        console.log('职位:', event.target.value);
        this.setState({
            professionalPosition: event.target.value
        })
    }

    // 获取常驻城市韩式
    getRegionIdValue(value) {
        console.log(value);
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
    getProfessionalIntroductionValue(event) {
        console.log(event.target.value);
        this.setState({professionalIntroduction: event.target.value});
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

    handleCityChange(value) {
        Fetch.get('public/region/queryByPid/' + value).then(res => {
            let data = res.data;
            this.setState({
                city2List: data
            })
        })
    }

    handleCity2Change(value) {

    }

    handleFilterDateTime(value) {
        // 空或没有值 直接返回
        if (!value) {
            return value
        }

        // 时间戳做做处理
        if (value && typeof(value) === 'number') {
            let d = new Date(value);
            value = moment(d)
        }

        // moment 对象做处理
        let year = value._d.getFullYear();
        let month = value._d.getMonth() + 1;
        let day = value._d.getDate();
        return `${year}-${month}-${day}`;

    }

    // 保存提交
    handleProfessionalSubmit() {
        let phoneTest = /^1(3|4|5|7|8)[0-9]\d{8}$/;
        let emailTest = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let idCardText = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
        let param = this.state;
        let that = this;
        if (param.professionalPhotoPath.length === 0) {
            return alert('请上传本人传照片');
        }
        if (param.professionalName.length === 0) {
            return alert('请输入姓名');
        }
        if (param.professionalGender.length === 0) {
            return alert('请选择性别');
        }

        if (param.professionalWorkunit.length === 0) {
            return alert('请输入任职机构');
        }
        if (param.professionalPosition.length === 0) {
            return alert('请输入职位');
        }

        if (param.regionId.length === 0) {
            return alert('请选择注册城市');
        }

        if (param.professionalTypeId.length === 0) {
            return alert('请选择大匠分类');
        }

        if (param.professionalIdFront.length === 0) {
            return alert('请上传身份证正面照片');
        }
        if (param.professionalIdBack.length === 0) {
            return alert('请上传身份证反面照片');
        }
        Fetch.post('private/user/sendBeProfVerif', param).then(res => {
            if (res.flag === 1) {
                alert('提交成功', 1.5);
                setTimeout(() => {
                    that.props.history.push('/user/info')
                }, 1500)
            } else {
                alert(res.message)
            }
        });
    }

    render() {
        return (
            <div className='create_professional w-professional'>
                <div className='upload_avatarBox'>
                    <ImgUpload
                        Width='800px'
                        Height='420px'
                        MyId='info_avatar'
                        change={this.getPhotoPathValue}
                        content={'请上传头像'}
                        Image={this.state.professionalPhotoPath}
                        disabled={false}
                        Circle={false}
                    />
                </div>


                <div className="w-professional-baseIfo clearfix">
                    <div className="w-professional-inputBox clearfix"><label>姓名</label>
                        <input type="text" className="w-professional-input" onChange={this.getProfessionalNameValue}/>
                    </div>
                    <div className="w-professional-inputBox clearfix"><label>性别</label>
                        <div className="w-professional-input2">
                            <RadioGroup onChange={this.getProfessionalGenderValue}
                                        value={this.state.professionalGender}>
                                { window.LIST.sexList.map(function (item) {
                                    return <Radio value={item.value} key={item.value}>{item.label}</Radio>
                                })
                                }
                            </RadioGroup>
                        </div>
                    </div>
                    <div className="w-professional-inputBox clearfix"><label>生日</label>
                        <div className="w-professional-input2"><DatePicker onChange={this.getProfessionalBirthValue}/>
                        </div>
                    </div>
                    <div className="w-professional-inputBox clearfix"><label>注册城市</label>
                        <div className="w-professional-input2">
                            <Cascader options={window.LIST.cityList} onChange={this.getRegionIdValue}
                                      placeholder="选择常驻城市"/>
                        </div>
                    </div>
                    <div className="w-professional-inputBox clearfix"><label>大匠分类</label>
                        <div className="w-professional-input2">
                            <Cascader options={window.LIST.professionalTypeList}
                                      onChange={this.getProfessionalTypeIdValue}
                                      placeholder="选择大匠的分类"/>
                        </div>

                    </div>
                    <div className="w-professional-inputBox clearfix"><label>从业时间</label>
                        <div className="w-professional-input2">
                            <DatePicker onChange={this.getProfessionalWorkdtValue}/>
                        </div>
                    </div>
                    <div className="w-professional-inputBox clearfix"><label>职位</label>
                        <input type="text" className="w-professional-input"
                               placeholder="请输入职位"
                               value={this.state.professionalPosition}
                               onChange={this.getProfessionalPositionValue}
                        />
                    </div>
                    <div className="w-professional-inputBox clearfix"><label>任职机构</label>
                        <input type="text" className="w-professional-input"
                               placeholder="请输入所在的公司"
                               value={this.state.professionalWorkunit}
                               onChange={this.getProfessionalWorkunitValue}
                        />
                    </div>
                </div>
                <div className="w-professional-jj">
                    <h3 className="w-professional-jj-tit">大匠简介</h3>
                    <textarea placeholder="不可超过500字" onChange={this.getProfessionalIntroductionValue}>

                    </textarea>
                </div>
                <div className="w-idCardBoxGroup clearfix">
                    <div className="w-fl w-idCardBox">
                        <div className="w-idCardBox-hd clearfix">
                            <h3 className="w-idCardBox-title">上传身份证照片（正面）</h3>
                        </div>
                        <div className="w-idCardBox-bd">
                            <div className="upload_idCardBox">
                                <ImgUpload
                                    Width='378px'
                                    Height='243px'
                                    MyId='info_idCard1'
                                    change={this.getProfessionalIdFrontValue}
                                    content={'必填'}
                                    Image={this.state.professionalIdFront}
                                    disabled={false}
                                    Circle={false}
                                />
                            </div>
                        </div>


                    </div>
                    <div className="w-fr w-idCardBox">
                        <div className="w-idCardBox-hd clearfix">
                            <h3 className="w-idCardBox-title">上传身份证照片（反面）</h3>
                        </div>
                        <div className="w-idCardBox-bd">
                            <div className="upload_idCardBox">
                                <ImgUpload
                                    Width='378px'
                                    Height='243px'
                                    MyId='info_idCard2'
                                    change={this.state.professionalIdBack}
                                    content={'必填'}
                                    Image={this.state.professionalIdBack}
                                    disabled={false}
                                    Circle={false}
                                />
                            </div>

                        </div>
                    </div>
                </div>
                <button className="w-professional-submit" onClick={this.handleProfessionalSubmit}>提交</button>
            </div>
        )
    }
}