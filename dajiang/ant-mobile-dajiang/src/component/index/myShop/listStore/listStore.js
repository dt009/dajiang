/**
 * @author wackeCq
 * @file 我的店铺的 页面
 * @date 17/9/23 下午4:32
 */
import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import './listStore.less'
import {Modal, Button} from 'antd-mobile';


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

export default class ListStore extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productPrice: ''
        };
        this.handleChangePriceValue = this.handleChangePriceValue.bind(this);
        this.handleFilterDate = this.handleFilterDate.bind(this);
        this.handleClickEditPriceValue = this.handleClickEditPriceValue.bind(this);
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

    handleClickEditPriceValue() {
        let props = this.props;
        if (props.onChangePriceFunction) {
            let productPrice = props.productPrice.toString();
            let prompt = Modal.prompt;
            return (
                prompt('价格', '请输入要修改的价格', [
                    {text: '取消'},
                    {text: '确定', onPress: value => props.onChangePriceFunction(value)}
                ], 'default', productPrice)
            )
        }
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
                        <div className="product_status">
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
