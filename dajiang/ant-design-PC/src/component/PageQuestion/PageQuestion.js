/**
 * @author v_duantao
 * @file 反馈问题
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import  './PageQuestion.less';

import { Radio } from 'antd';
const RadioGroup = Radio.Group;
import {message} from 'antd';
import {Button} from 'antd';
import Fetch from 'Fetch/Fetch';

export default class PageQuestion extends Component {
    constructor(props) {
        super(props);
        this.state = {
            feedbackType: '1',
            feedbackContent: '',
            showError: false,
        }
    }

    // 获取反馈类型
    setFeedbackTypeValue = e => {
        this.setState({
            feedbackType: e.target.value
        })
    };

    // 获取反馈内容
    setFeedbackContentValue = e => {
        let value = e.target.value;
        if (value.length <= 200) {
            this.setState({
                showError: false,
                feedbackContent: value
            })
        } else {
            this.setState({
                showError: true
            });
            message.error('输入不能超过200字', 1)
        }

    };

    // 提交反馈
    handleSubmitBtn = () => {
        Fetch.post('private/user/feedback', {
            ...this.state
        }).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                message.success('提交成功');
                this.props.history.go(-1)
            } else {
                message.error(res.message)
            }
        })
    };

    render() {
        return (
            <div className='page_question'>
                 <div className='question_type'>
                     <h2>反馈类型 : </h2>
                     <RadioGroup onChange={this.setFeedbackTypeValue} value={this.state.feedbackType}>
                         <Radio value='1'>系统反馈</Radio>
                         <Radio value='2'>上架反馈</Radio>
                         <Radio value='3'>其他反馈</Radio>
                     </RadioGroup>
                 </div>
                <div className='question_content'>
                    <h2>反馈内容 :</h2>
                    <textarea
                        onChange={this.setFeedbackContentValue}
                        placeholder='不超过200字'
                        style={{
                            color: this.state.showError
                                ? '#f00'
                                : '#333'
                        }}
                    >
                    </textarea>
                </div>
                <Button
                    onClick={this.handleSubmitBtn}
                >提交</Button>
            </div>
        )
    }
}