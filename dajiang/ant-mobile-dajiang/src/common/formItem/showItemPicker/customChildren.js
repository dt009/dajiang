
/**
 * @author v_duantao
 * @file 一些选择器在页面中展示的部分
 * @date 17/9/28 下午5:40
 */

import React, {Component} from 'react';
import './customChildren.less';


/**
 * @description  选择器在页面中展示选择的部分
 *
 * @param       label       显示页面上的输入框的 label
 * @param       showValue   显示选中的值
 */

// 页面中展现出来的部分
export default class CustomChildren extends Component {
    render() {
        let props = this.props;
        return (
            <div
                className="custom_children_show"
                onClick={props.onClick}
            >
                <span>{props.label}</span>
                <div>{props.showValue}</div>
                <span>&#xe858;</span>
            </div>
        )
    }
}
