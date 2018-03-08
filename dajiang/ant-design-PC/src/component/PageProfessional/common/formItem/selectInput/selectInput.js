/**
 * @author v_duantao
 * @file 选择和联动选择组件
 * @date 17/9/28 下午5:18
 */

import React, {Component} from 'react';
import {Select} from 'antd';
const Option = Select.Option;
import './selectInput.less';

/**
 * @description     选择组件联动不联动都好
 *
 * @param       data        数据源, (数组)
 * @param       title       选择组件的标题
 * @param       label       展示部分的 label
 * @param       cols        选择组件的显示的列数
 * @param       getChangeSelectValue         父子组件传值的函数
 * @param       value       更新的标识  最好是 hash 值
 */


export default class SelectInput extends Component {
    constructor(props) {
        super(props);
        this.state = {
            defaultValue: '',
            showSelectValue: '',
            value: ''
        };
        this.handleSelectValue = this.handleSelectValue.bind(this);

    }

    componentDidMount() {
        this.getDefaultSelectValue(this.props.defaultValue);
    }

    componentWillReceiveProps(nextProps) {
        console.log('nextProps', nextProps);
        //this.setState({A: nextProps.A});
        this.getDefaultSelectValue(nextProps.defaultValue);
    }


    componentDidUpdate() {
    }

    shouldComponentUpdate() {
        return false
    }

    getDefaultSelectValue(value) {
        console.log('v', value);
        let defaultValue = '';
        if (value) {
            this.props.data.map(item => {
                if (item.value == value) {
                    defaultValue = item.label
                }
            });
        } else {

        }
        console.log('defaultValue', defaultValue);
        this.setState({
            defaultValue: defaultValue
        })
    }

    // 选中的回调
    handleSelectValue(value) {
        console.log('change', value);
        let trueValue = '';
        this.props.data.map(item => {
            if (item.label == value) {
                trueValue = item.value
            }
        });
        this.props.getChangeSelectValue(trueValue);

    }

    render() {
        let props = this.props;
        //this.getDefaultSelectValue(this.props.defaultValue);
        /*let defaultValue = '';
         if (this.props.defaultValue) {
         this.props.data.map(item => {
         if (item.value == this.props.defaultValue) {
         defaultValue=item.label
         }
         });
         }else{

         }*/
        return (
            <Select placeholder={props.placeholder} defaultvalue={this.state.defaultValue}
                    onChange={this.handleSelectValue}>
                {props.data.map(function (item) {
                    return <Option value={item.label} key={item.value}>{item.label}</Option>
                })
                }
            </Select>
        )
    }
}
