/**
 * @author wackeCq
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */

import React, {Component} from 'react';
import BackHeader from 'backHeader/backHeader';

import {NavLink} from 'react-router-dom';
import ProductCard from "card/productCard/productCard";
import {Tabs, WhiteSpace, Badge} from 'antd-mobile';
const TabPane = Tabs.TabPane;
import './ProductsShow.less';
import TextInput from 'formItem/textInput/textInput';




import Fetch from 'fetch';

export default class ProductShow extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productList: [],
            inputdata:""
        }
        this.gettitle = this.gettitle.bind(this);
        this.handleInputTextChangeValue =this.handleInputTextChangeValue.bind(this);
    }
    handleInputTextChangeValue(e){
        let props = this.props;
        let value = e.target.value;
        this.setState({
            inputdata:value
        })
        this.props.changeTextValue(value)

    }
    gettitle(value){

    }
    callback(key) {
    }
    handleTabClick(key) {
    }
    componentWillMount() {
        
    }
    haveFlag(type){
        switch(type){
            case "1":
                return(
                    <span className="status" >{this.props.status}</span>
                )
            case "2":
                return(
                    <span className="status" >{this.props.status}</span>
                )
            case "3":
                return(
                    <span className="status" >{this.props.status}</span>
                )
        }
    }
    render() {
     let haveFlag = this.haveFlag(this.props.haveFlag)
        return (
            <div>
                <div className="ProductShow">
                    <span className="name">{this.props.name}</span>
                    {haveFlag}
                </div>
                <WhiteSpace size="sm"/>
            </div>

        )
    }
}
