/**
 * @author v_duantao
 * @file 日期输入组件
 * @date 17/9/28 上午10:24
 */

import React, {Component} from 'react';
import './dateInput.less';
import CustomChildren from '../showItemPicker/customChildren';

import moment from 'moment';

import {
    DatePicker,
    List
} from 'antd-mobile';


/**
 * @description     选择日期的组件
 *
 * @param       title       选择日期的组件的最上标题
 * @param       label       显示页面上的输入框的 label
 * @param       value       默认显示的时间
 * @param       getDateValue    父子组件建传值的函数
 */

// 日期选择组件
export default class DateInput extends Component {

    constructor(props) {
        super(props);
        this.state = {
            dateValue: this.handleFilterDateTime(props.value)
        };
        this.handleChangeDateValue = this.handleChangeDateValue.bind(this);
        this.handleFilterDateTime = this.handleFilterDateTime.bind(this);
    }

    // 选择日期是的
    handleChangeDateValue(value) {
        let dateShowValue = this.handleFilterDateTime(value);

        let sendValue = value._d.getTime();

        this.props.getDateValue(sendValue);

        this.setState({
            dateValue: dateShowValue
        })
    }

    /**
     * @description  格式化时间的函数
     * @param        value  三种可能  1: 没有值  2: 传入的是父组件传入的日期时间戳  3: moment对象
     * @return {*}
     */
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

    render() {
        let props = this.props;
        let minDate = moment('1950-01-01', 'YYYY-MM-DD');
        return (
            <div className="date_input">
                <DatePicker
                    mode="date"
                    title={props.title}
                    onChange={this.handleChangeDateValue}
                    value={moment()}
                    minDate={minDate}
                >
                    <CustomChildren
                        label={props.label}
                        showValue={this.state.dateValue || '例如: 2017-1-11'}
                    />
                </DatePicker>
            </div>
        )
    }
}