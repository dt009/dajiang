/**
 * @author wzn
 * @file 修改知识经经人资料
 * @date 2017/11/28
 */
import React, {Component} from 'react';
import './BrokerMessage.less';
import {NavLink} from 'react-router-dom';
import { Radio,message,Cascader } from 'antd';
const RadioGroup = Radio.Group;
import Fetch from 'Fetch/Fetch';

export default class BrokerMessage extends Component {
      constructor(props) {
           super(props);
           this.state = {
                showError: false,
                showSubmit: true,
                emailbox: '',
                city: '',
                selectData:'1',
                professionalFirstOptions:''
           };
       }
      componentDidMount() {
       this.setState({ selectData:1})
            // 初始化
            Fetch.post('private/user/initBeCKO', {}).then(res => {
                let {flag, data} = res;
                if (flag === 1) {
                    this.setState({
                        selectData:data.ckoIssearch,
                        city:data.regionId,
                        emailbox:data.ckoApplyEmail

                    })
                    if(data.ckoApplyStatus === 1){
                        //this.props.history.push('/')
                    }
                } else {
                    this.props.history.push('/error')
                }
            });
            // 获取大匠的第一级分类的操作
            Fetch.get('public/region/queryByPid/1', {}).then(res => {
                let {flag, data} = res;
                if (flag === 1) {
                    let options = [];
                    data.forEach(item => {
                    options.push({
                    label: item.regionName,
                    value: item.regionId,
                    isLeaf: false,
                    })
                    });

                    this.setState({
                    professionalFirstOptions: options
                    })
                } else {
                    message.error(res.message)
                }
            });
      }
       // 二级查询
       fetchProvinceSecond = selectedOptions => {
        let PID = selectedOptions[0].value;
        const targetOption = selectedOptions[selectedOptions.length - 1]
        targetOption.loading = true;

        Fetch.get(`public/region/queryByPid/${PID}`, {}).then(res => {
            targetOption.loading = false;
            let {flag, data} = res;
            if (flag === 1) {
                let option = [];
                data.forEach(item => {
                    option.push({
                        label: item.regionName,
                        value: item.regionId,
                    })
                });
                targetOption.children = option;
                this.setState({
                    professionalFirstOptions: [...this.state.professionalFirstOptions]
                })
            } else {
                message.error(res.message)
            }
        });
    };
       // 邮箱检验
       handleEmailBox = e => {
           let emailbox = e.target.value;
           let reg =/\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;;
           this.setState({
               emailbox: emailbox,
               showError: false
           });
           if (emailbox.length === 0||!emailbox ||!reg.test(emailbox) ) {
               message.error('邮箱格式不正确');
           } else {
               this.setState({
                   showError: false,
                   showSubmit: true
               })
           }
       };
       handleChangeEmail=e=>{
          let emailbox = e.target.value;
           this.setState({
                         emailbox: emailbox,
                         showError: false
                     });
       }
       //单选
       handleSelect = (e) => {
          console.log('radio checked', e.target.value);
            this.setState({
                     selectData:  e.target.value
                 })
       }
       // 保存
       handleSubmit = () => {
           let state = this.state;
           let that = this;
           if (state.city.length === 0) {
               return message.error('请选择城市');
           }
           if (state.emailbox.length === 0) {
               return message.error('请输入邮箱');
           }
           this.setState({
               showSubmit: false
           });
           let data = {
                ckoApplyEmail: this.state.emailbox,
                ckoIssearch:this.state.selectData,
                regionId:this.state.city
           };

           Fetch.post('private/user/sendBeCKOVertif', data).then(res => {
               if (res.flag === 1) {
                    return message.success('保存成功');
               } else {
                   that.setState({
                       showSubmit: true
                   });
                   message.error(res.message);
               }
           })
         };
       //级联选择
       handleOptions = (value, selectedOptions) =>{
            this.state.city=value;
         }
       handleChangeCityCodeIds = (value, selectedOptions) => {
            this.state.city=value[value.length-1];
       };
       //渲染页面
       render() {
           return (
               <div className='broker_messages'>
                   <div className='border_bao'>
                      <span> 知识经纪人中心</span>
                      <div className='border_you'>
                          <div id="log" className="login_submit"
                             onClick={this.handleSubmit} >
                              保存
                          </div>
                      </div>
                  </div>
                   <hr />
                   <div className="bao2">
                        <div className="cityDiv">
                            <span >注册城市</span>
                             <Cascader className="cascader"
                             placeholder='请选择城市'
                                options={this.state.professionalFirstOptions}
                                loadData={this.fetchProvinceSecond}
                                onChange={this.handleChangeCityCodeIds}
                                changeOnSelect={true}
                              />
                       </div>
                       <div className="cityDiv">
                            <span>邮箱</span>
                            <span className="spanClass"><input type="text"
                            value={this.state.emailbox}
                             placeholder="请输入邮箱"
                             onBlur={this.handleEmailBox}
                             onChange={this.handleChangeEmail}
                             />
                             </span>
                       </div>
                       <div className="cityDiv">
                            <b>是否可被查找</b>
                            <RadioGroup onChange={this.handleSelect} value={this.state.selectData}>
                                <Radio value={0}>是</Radio>
                                <Radio value={1}>否</Radio>
                            </RadioGroup>
                       </div>
                  </div>
               </div>
           )
       }
}