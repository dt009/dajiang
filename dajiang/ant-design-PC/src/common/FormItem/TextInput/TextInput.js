/**
 * @author v_duantao
 * @file 单行文本输入
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './TextInput.less';

import {message, Icon} from 'antd';


/**
 * @description     单行文本的输入,  邮箱, 姓名, url地址, 手机号等等
 * @param       label               前缀输入框的意义
 * @param       placeholder         顾名思义
 * @param       changeTextValue     数据传递的函数,父组件传入,父组件做数据处理
 * @param       textValue           默认显示的值
 * @param       test                输入内容的正则表达式, 验证
 * @param       errTip              失焦事件校检失败提示
 * @param       max                 限制输入长度
 * @param       type                输入框是密码输入还是文本输入  文本: text   密码: password\
 * @param       readOnly            是否只读  默认 false
 */

export default class TextInput extends Component {
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
    componentWillReceiveProps(nextProps) {
        this.setState({
            textValue: nextProps.textValue,
        })
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
                message.error(props.errTip)
            }
        }
    }

    render() {
        let props = this.props;
        return (
            <div className="form_input">
                <div className="input_text">
                    <label>
                        <span className="props_label">{props.label}</span>
                        <input className={this.state.textTest} type={props.type}
                               placeholder={props.placeholder}
                               value={this.state.textValue}
                               onChange={this.handleInputTextChangeValue}
                               onBlur={this.handleTextValueTest}
                               readOnly={props.readOnly}
                        />
                    </label>
                </div>
            </div>
        )
    }
}
