/**
 * @author v_duantao
 * @file
 * @date 17/9/20 下午2:23
 */


import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';

export default class Error extends Component {
    render() {
        return <div>
            <h2>这是错误页面</h2>
            <NavLink to="/index/home">主页</NavLink>
        </div>
    }
}