/**
 * @author v_duantao
 * @file 顶部返回组件
 * @date 17/9/29 上午10:56
 */


import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import './backHeader.less';

/**
 * @description     头部返回组件
 *
 * @param       path        返回到的组件路径
 * @param       title     标题
 */
export default class BackHeader extends Component {
    render() {
        let props = this.props;
        return (
            <div className="back_header">
                {/* <NavLink to={props.path}>&#xe60d;</NavLink> */}
                <a href="javascript:history.go(-1)">&#xe60d;</a>
                {props.title}
            </div>
        )
    }
}
