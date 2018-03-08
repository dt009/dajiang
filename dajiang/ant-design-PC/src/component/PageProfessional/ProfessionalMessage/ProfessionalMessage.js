/**
 * @author v_duantao
 * @file 修改大匠的信息
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import Fetch from 'Fetch/Fetch'
import './ProfessionalMessage.less';
import '../common/upload.less';
//import Upload from '../upload/upload';
import ImgUpload from 'imgUpload/imgUpload';
//import SelectInput from '../common/formItem/selectInput/selectInput';
import CascaderInput from '../common/formItem/cascaderInput/cascaderInput';
import {Radio,Cascader,DatePicker,Input ,Select,Button, Modal, Checkbox, message} from 'antd';
const Option = Select.Option;
const { TextArea } = Input;
export default class ProfessionalMessage extends Component {
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
            edit:false
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
        this.handleEdit=this.handleEdit.bind(this);
    }

    componentDidMount() {
        // 初始化页面
        let that = this;
        Fetch.post('private/professional/initProfess', {}).then(res => {
            let data = res.data;
            if (res.flag === 1) {
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
                alert('初始化失败, 请检查网络')
            }
        });
        // 获取学历列表
    }
    getLabelValue(list,value){
        let label='';
        list.map((item,index) => {
            if (item.value == value) {
                label = item.label
            }else{
                if(item.children){
                    item.children.map(child=>{
                        if(child.value==value){
                            label = list[index].label+'-'+child.label;
                        }
                    })
                }
            }

        });
        return label;
    }

    // 获取本人照片的路径
    getPhotoPathValue(value) {
        this.setState({
            professionalPhotoPath: value
        })
    }

    // 获取职位的函数
    getProfessionalPositionValue(e) {
        this.setState({
            professionalPosition: e.target.value
        })
    }

    // 获取邮箱
    getProfessionalEmailValue(e) {
        this.setState({
            professionalEmail: e.target.value
        })
    }

    // 获取最高学历
    getProfessionalHighEducValue(value) {
        console.log(1);
        console.log(value);
        this.setState({
            professionalHighEduc: value
        })
    }

    // 获取任职机构的函数
    getProfessionalWorkunitValue(e) {
        this.setState({
            professionalWorkunit: e.target.value
        })
    }

    // 获取手机号
    getProfessionalPhoneValue(e) {
        this.setState({
            professionalPhone: e.target.value
        })
    }

    // 获取专业领域的函数
    getProfessionalFieldValue(e) {
        this.setState({
            professionalField: e.target.value
        })
    }

    // 获取大匠分类
    getProfessionalTypeIdValue(value) {
        console.log(value);
        this.setState({
            professionalTypeId: value[1]
        })
    }

    // 获取大匠简介的函数
    getProfessionalIntroductionValue(e) {
        this.setState({professionalIntroduction: e.target.value});
    }

    // 提交按钮事件
    handleProfessionalSubmit = () => {
        let params = this.state;
        let that = this;
        Fetch.post('private/professional/sendProfVertif', params).then(res => {
            if (res.flag) {
                this.setState({
                    edit:false
                });
                //alert('修改成功');
            } else {
                alert(res.data);
            }
        })
    }
    handleEdit(){
        this.setState({
            edit:true
        });
    }

    render() {

        return (
            <div className='professional_message w-professional'>
                <div className='upload_avatarBox'>
                    <ImgUpload
                        Width='800px'
                        Height='420px'
                        MyId='info_avatar'
                        change={this.getPhotoPathValue}
                        content={'请上传头像'}
                        Image={this.state.professionalPhotoPath}
                        disabled={!this.state.edit}
                        Circle={false}
                    />
                </div>
                <div className="w-professionalMessBox">
                    <div className="w-professionalMessBox-hd clearfix">
                        <h3 className="w-professionalMessBox-title">个人中心</h3>
                        {this.state.edit?(
                            <button type="button" className="w-professionalMess-btn"
                               onClick={this.handleProfessionalSubmit}>保存</button>
                        ):(
                            <button type="button" className="w-professionalMess-btn"
                               onClick={this.handleEdit}>编辑</button>
                        )}

                    </div>
                    <div className="w-professionalMessBox-bd">
                        <div className="w-professionalMessItem">
                            <div className="w-professionalMessInputBox clearfix">
                                <label>姓名</label>
                                <div className="w-professionalMessInputBox-r">
                                    <span>{this.state.professionalName}</span>
                                </div>
                            </div>
                            <div className="w-professionalMessInputBox clearfix">
                                <label>职位</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <input type="text" className="w-professionalMessInput-input"
                                               placeholder="请输入在公司的职位"
                                               value={this.state.professionalPosition}
                                               onChange={this.getProfessionalPositionValue}
                                               max="50"
                                        />
                                    </div>
                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.state.professionalPosition}
                                    </div>

                                </div>
                            </div>
                            <div className="w-professionalMessInputBox clearfix">
                                <label>邮箱</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <input type="text" className="w-professionalMessInput-input"
                                               placeholder="请输入邮箱"
                                               value={this.state.professionalEmail}
                                               onChange={this.getProfessionalEmailValue}
                                               max="100"
                                        />
                                    </div>
                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.state.professionalEmail}
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div className="w-professionalMessItem">
                            <div className="w-professionalMessInputBox clearfix">
                                <label>最高学历</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <Select placeholder="选择学历"
                                                onChange={this.getProfessionalHighEducValue}>
                                            {window.LIST.eduList.map(function (item) {
                                                return <Option value={item.value+''} key={item.value}>{item.label}</Option>
                                            })
                                            }
                                        </Select>
                                    </div>

                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.getLabelValue(window.LIST.eduList,this.state.professionalHighEduc)}
                                    </div>
                                </div>
                            </div>
                            <div className="w-professionalMessInputBox clearfix">
                                <label>任职机构</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <input type="text" className="w-professionalMessInput-input"
                                               placeholder="请输入所在的公司"
                                               value={this.state.professionalWorkunit}
                                               onChange={this.getProfessionalWorkunitValue}
                                               max="100"
                                        />
                                    </div>

                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.state.professionalWorkunit}
                                    </div>
                                </div>
                            </div>
                            <div className="w-professionalMessInputBox clearfix">
                                <label>手机号码</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <input type="text" className="w-professionalMessInput-input"
                                               placeholder="请输入手机号码"
                                               value={this.state.professionalPhone}
                                               onChange={this.getProfessionalPhoneValue}
                                               max="11"
                                        />
                                    </div>

                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.state.professionalPhone}
                                    </div>
                                </div>
                            </div>
                            <div className="w-professionalMessInputBox clearfix">
                                <label>专业领域</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <input type="text" className="w-professionalMessInput-input"
                                               label="专业领域"
                                               value={this.state.professionalField}
                                               onChange={this.getProfessionalFieldValue}
                                               max="50"
                                        />
                                    </div>

                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.state.professionalField}
                                    </div>
                                </div>
                            </div>
                            <div className="w-professionalMessInputBox clearfix">
                                <label>大匠分类</label>
                                <div className="w-professionalMessInputBox-r">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <CascaderInput
                                            data={window.LIST.professionalTypeList}
                                            title={this.state.professionalTypeId+''}
                                            placeholder="选择大匠的分类"
                                            cols={1}
                                            defaultValue={this.state.professionalTypeId+''}
                                            getChangeSelectValue={this.getProfessionalTypeIdValue}
                                        />
                                    </div>

                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {console.log('professionalTypeId',this.state.professionalTypeId)}
                                        {this.getLabelValue(window.LIST.professionalTypeList,this.state.professionalTypeId)}
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div className="">
                            <div className="w-professionalMessInsBox clearfix">
                                <h3 className="w-professionalMessInsBox-hd">大匠简介</h3>
                                <div className="w-professionalMessInsBox-bd">
                                    <div className={this.state.edit?'w-show':'w-hide'}>
                                        <textarea value={this.state.professionalIntroduction} placeholder="不可超过500字"
                                                  onChange={this.getProfessionalIntroductionValue}
                                                  className="w-professionalMessInsBox-textArea"></textarea>
                                    </div>

                                    <div className={this.state.edit?'w-hide':'w-show'}>
                                        {this.state.professionalIntroduction}
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        )
    }
}