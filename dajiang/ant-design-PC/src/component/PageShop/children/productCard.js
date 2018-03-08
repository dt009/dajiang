/**
 * @author v_duantao
 * @file 展示商品的卡片
 * @date 17/10/15 下午4:20
 */

import React, { Component } from 'react';

import { NavLink } from 'react-router-dom';

import './productCard.less';

// import { Modal, Button } from 'antd-mobile';


/**
 * @description         商品展示的卡片
 * path                 商品详情路径
 * productTitle         商品标题
 * productStatus        审核状态
 * productAuthorName    所属的大匠
 * productDesc          商品描述
 * productUpdatedt      时间
 * orderNum             购买人数
 * productPrice         价格
 * onChangePriceFunction    编辑价格的函数
 */

export default class ProductCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productPrice: ''
        };
        this.handleChangePriceValue = this.handleChangePriceValue.bind(this);
        this.handleFilterDate = this.handleFilterDate.bind(this);
        // this.handleClickEditPriceValue = this.handleClickEditPriceValue.bind(this);
        // this.handleStatus = this.handleStatus.bind(this)
    }

    handleChangePriceValue(value) {
        // this.setState({
        //     productPrice: value
        // })
    }

    handleFilterDate(value) {
        let time = new Date(value);
        let year = time.getFullYear();
        let month = time.getMonth() + 1;
        let day = time.getDate();
        return `${year}/${month}/${day}`
    }
    render() {
        let props = this.props;
        return (
            <div className="show_product_card">
                <NavLink to={props.path} className="product_show_card">
                    <div className="product_card_header">
                        <div className="header_title">
                            {props.productTitle}
                        </div>
                        <div className="product_status" onClick={this.handleStatus}>
                            {props.productStatus ? props.productStatus : ''}
                        </div>
                    </div>
                    <div className="product_card_content">
                        <div className="content_name">
                            {props.productAuthorName}
                        </div>
                        <div className="conent_detail">
                            {props.productDesc}
                        </div>
                    </div>
                    <div className="product_card_footer">
                        <div className="card_footer_date">
                            {this.handleFilterDate(props.productUpdatedt)}
                        </div>
                        <div className="card_footer_sun">
                            购买数量: {props.orderNum || 0}
                        </div>
                        <div className="card_footer_false"> </div>
                    </div>
                </NavLink>
                <div className="card_product_show_price" onClick={this.handleClickEditPriceValue}>
                    <span>￥</span>
                    <p>{props.productPrice}</p>
                </div>
            </div>
        )
    }
}
