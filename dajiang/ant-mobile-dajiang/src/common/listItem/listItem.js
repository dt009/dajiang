/**
 * @author v_duantao
 * @file ListItem, 一些一样的展示列表
 * @date 17/9/29 下午8:24
 */

import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import './listItem.less';



/**
 *  @description  列表
 *
 *  @param style 样式
 *  @param path  路由跳转的路径
 *  @param  title  标题显示的内容
 *  @param  children  前一个字体图标
 */
export default class ListItem extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        let props = this.props;
        return (
            <NavLink style={props.style} to={props.path} className="list_item">
                {props.children}
                <p>{props.title}</p>
                <span>&#xe858;</span>
            </NavLink>
        )
    }
}