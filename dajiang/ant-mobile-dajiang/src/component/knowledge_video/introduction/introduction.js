/**
 * @author v_duantao
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */

import React, {Component} from 'react';
import BackHeader from 'backHeader/backHeader';

import {NavLink} from 'react-router-dom';
import ProductCard from "card/productCard/productCard";
import {Tabs, WhiteSpace, Badge} from 'antd-mobile';
const TabPane = Tabs.TabPane;
import './introduction.less'
import TextInput from 'formItem/textInput/textInput';

import Fetch from 'fetch';

export default class Introduction extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productList: []
        }
        this.gettitle = this.gettitle.bind(this);
    }
    gettitle(value) {}
    callback(key) {}
    handleTabClick(key) {}
    componentWillMount() {
        Fetch.get('public/product/initProducts').then(res => {
            this.setState({productList: res.data})
        })
    }
    render() {

        return (
            <div>
                <div className="Introduction">
                    <div className="title">{this.props.title}</div>
                    <div className="content">{this.props.content}</div>
                </div>
                <WhiteSpace size="sm"/>
            </div>

        )
    }
}
