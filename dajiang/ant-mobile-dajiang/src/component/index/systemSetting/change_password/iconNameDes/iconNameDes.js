/**
 * @author v_duantao  and  wackeCq
 * @file iconNameDes 输入的当行文本组件
 * @date 17/9/27 下午5:24
 */

import React, {Component} from 'react';
import './iconNameDes.less';

import {
    Toast
} from 'antd-mobile';


/**
 * @description     单行文本的输入,  邮箱, 姓名, url地址, 手机号等等
 * @param       name                图标后面的名字   name
 * @param       label               前缀输入框的意义
 * @param       placeholder         顾名思义
 * @param       changeTextValue     数据传递的函数,父组件传入,父组件做数据处理
 * @param       textValue           默认显示的值
 * @param       test                输入内容的正则表达式, 验证
 * @param       errTip              失焦事件校检失败提示
 * @param       max                 限制输入长度
 * @param       type                输入框是密码输入还是文本输入  文本: text   密码: password
 */

export default class IconNameDes extends Component {
    constructor(props) {
        super(props);
        this.state = {
            textValue: props.textValue,  // 父组件传过来的默认值
            textTest: '',   // 校检失败 输入框的输入变色(颜色在样式表里)  值:  'text_err'  或  ''
            yuLiu: ''
        };

        this.handleInputTextChangeValue = this.handleInputTextChangeValue.bind(this);  // 输入改变
        this.handleTextValueTest = this.handleTextValueTest.bind(this);  // 校检
    }

    componentWillMount () {
        // console.log((this.state));
    }

    //  输入框内容改变把值传给父组件的函数
    handleInputTextChangeValue(e) {
        let props = this.props;
        let value = e.target.value;

        // 查看是否有长度限制
        if (props.max && value.length > props.max) {
            value = value.substring(value.length - props.max, value.length);
        }

        // 查看是否需要验证
        if (props.test) {
            if (props.test.test(value)) {
                // 通过
                this.setState({
                    textTest: ''
                })
            } else {
                // 未通过
                this.setState({
                    textTest: 'text_err'
                })
            }
        }

        //
        if (props.changeTextValue) {

            // 父组件接受改变的值
            props.changeTextValue(value)
        }
        this.setState({
            textValue: value
        });

    }

    // 校检输入的内容(失焦事件)
    handleTextValueTest(e) {
        let props = this.props;
        let value = e.target.value;
        if (props.test) {
            if (!props.test.test(value)) {
                Toast.fail(props.errTip, 1)
            }
        }
    }

    render() {
        let props = this.props;
        return (
            <div className="form_item">
                <div className="input_text">
                    <label>
                        <span className="propsLabel">{props.label}</span>
                        <span className="propsName">{props.name}</span>
                        <input className={this.state.textTest} type={props.type}
                               placeholder={props.placeholder}
                               value={this.state.textValue}
                               onChange={this.handleInputTextChangeValue}
                               onBlur={this.handleTextValueTest}
                        />
                    </label>
                </div>
            </div>
        )
    }
}
