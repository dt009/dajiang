/**
 * @author wzn
 * @file 成为知识经经人
 * @date 2017/11/28
 */
import React, {Component} from 'react';
import './CreateBroker.less';
import {NavLink} from 'react-router-dom';
import { Radio,message,Cascader } from 'antd';
const RadioGroup = Radio.Group;
import Fetch from 'Fetch/Fetch';

export default class CreateBroker extends Component {
       constructor(props) {
               super(props);
               this.state = {
                    searchType:'',
               };
           }
          componentDidMount() {
                this.setState({searchType:1})
                // 初始化
                Fetch.post('private/user/initBeCKO', {}).then(res => {
                    let {flag, data} = res;
                if (flag === 1) {

                    if(data.ckoApplyStatus === 1){
                        //this.props.history.push('/')
                    }
                } else {
                    this.props.history.push('/error')
                }
            });
      }
       //单选
       handleSelect = (e) => {
          console.log('radio checked', e.target.value);
            this.setState({
                     searchType:  e.target.value
                 })
       }
       // 保存
       handleSubmit = () => {
           let that = this;
           let data = {
                ckoIssearch:this.state.searchType,
           };

           Fetch.post('private/user/sendBeCKOVertif', data).then(res => {
               if (res.flag === 1) {
                    return message.success('保存成功');
               } else {
                   message.error(res.message);
               }
           })
         };

       //渲染页面
       render() {
           return (
               <div className='broker_create'>
               <div className="">
                     <h2>成为知识经纪人申请须知</h2>
                      <hr />
                      <p className="apply-tit">协议</p>
                </div>
                       <div className="radio">
                            <b>是否可被查找</b>
                            <RadioGroup onChange={this.handleSelect} value={this.state.searchType}>
                                <Radio value={0}>是</Radio>
                                <Radio value={1}>否</Radio>
                            </RadioGroup>

                       </div>
                       <div>
                         <button className="apply-submit"   onClick={this.handleSubmit} >提交</button>

                       </div>
               </div>
           )
       }
}