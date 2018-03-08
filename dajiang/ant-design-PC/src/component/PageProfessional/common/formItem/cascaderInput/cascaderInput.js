/**
 * @author v_duantao
 * @file 选择和联动选择组件
 * @date 17/9/28 下午5:18
 */

import React, {Component} from 'react';
import './cascaderInput.less';
import {Cascader} from 'antd';

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
            showSelectValue: [],
            value: []
        };
        this.handleSelectValue = this.handleSelectValue.bind(this);
        this.handleFilerData = this.handleFilerData.bind(this);

    }

    componentDidMount() {
        this.getDefaultSelectValue(this.props.defaultValue);
    }


    componentDidUpdate() {
    }

    componentWillReceiveProps(nextProps) {
        if (this.props.value !== nextProps.value) {


        }
    }


    // 过滤筛选数据
    handleFilerData(item, key, value, showData) {
        if (item.children) {
            item.children.map(item => {
                if (item.value === value[key]) {
                    key++;
                    showData.push(item.label);
                    this.handleFilerData(item, key, value, showData)
                }
            })
        } else {
            return showData;
        }
    }
    getDefaultSelectValue(value){
        //console.log('v',value);
        //console.log('this.props.data',this.props.data);
        let showData = [];
        this.props.data.map(item => {
            if(item.children){
                item.children.map(child=>{
                    //console.log(child.value);
                    //console.log(value);
                    if (child.value == value) {
                        showData.push(item.label);
                        showData.push(child.label);
                        //this.handleFilerData(item, key, value, showData)
                    }
                });
            }

        });
        this.setState({
            showSelectValue: showData
        })
    }
    // 选中的回调
    handleSelectValue(value) {
        if(!(value instanceof Array)) {
            return console.log('应该传入数组')
        }
        //console.log('value',value);
        //console.log('this.props.data',this.props.data);
        let showData = [];
        this.props.data.map(item => {
            let key = 0;
            if (item.value == value[key]) {
                key++;
                showData.push(item.label);
                this.handleFilerData(item, key, value, showData)
            }
        });
        this.props.getChangeSelectValue(value);

    }

    render() {
        let props = this.props;
        //console.log(props);
        return (
            <Cascader defaultValue={this.state.showSelectValue}
                      options={props.data}
                      onChange={this.handleSelectValue}
                      placeholder={props.placeholder}/>
        )
    }
}
