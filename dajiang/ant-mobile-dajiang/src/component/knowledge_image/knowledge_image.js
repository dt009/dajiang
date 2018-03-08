/**
 * @author v_duantao
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */

import React, {Component} from 'react';
import BackHeader from 'backHeader/backHeader';

import {NavLink} from 'react-router-dom';
import ProductCard from "card/productCard/productCard";
import {
    Tabs,
    WhiteSpace,
    Badge,
    Carousel,
    NoticeBar,
    Toast
} from 'antd-mobile';
const TabPane = Tabs.TabPane;
import './knowledge_image.less';
import TextInput from 'formItem/textInput/textInput';
import ProductShow from '../ProductsShow/ProductsShow';
import Introduction from "./introduction/introduction"
import Fetch from 'fetch';

export default class KnowledgeImage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [
                '', '', ''
            ],
            initialHeight: 200,
            productPatentNumber: '',
            productDesc: '',
            productAuthorName: '',
            productAuthorName: '',
            productPrice: '',
            productTitle: "",
            productType: '',
            detailList: [],
            productId: ''
        }
        this.gettitle = this.gettitle.bind(this);
    }
    gettitle(value) {}
    callback(key) {}
    handleTabClick(key) {}
    componentWillMount() {
        // Fetch.get('public/product/initProducts').then(res => {
        //     this.setState({productList: res.data})
        // })
    }
    componentDidMount() {
        this.isSj(this.props.isSj)
    }
    isSj(type) {
        switch (type) {
            case "1":
                Fetch.post("public/product/initDocInfo/" + this.props.ProductId).then(res => {
                    var arr = []
                    res.data.detailList.map(function(item, key) {
                        if (item.productDetailType === 5) {
                            arr.push(item.productPath);
                        }
                    })
                    this.setState({
                        data: arr,
                        productPatentNumber: res.data.productPatentNumber,
                        productDesc: res.data.productDesc,
                        productAuthorName: res.data.productAuthorName,
                        productAuthorName: res.data.productAuthorName,
                        productPrice: res.data.productPrice,
                        productTitle: res.data.productTitle,
                        productType: res.data.productType,
                        userId: res.data.userId,
                        detailList: res.data.detailList,
                        productId: res.data.productId

                    })
                })
                break;
            case "2":
                Fetch.post("private/product/initDocInfo/" + this.props.ProductId).then(res => {
                    var arr = []
                    res.data.detailList.map(function(index, key) {
                        if (item.productDetailType === 5) {
                            arr.push(item.productPath);
                        }
                    });
                    this.setState({
                        data: arr,
                        productPatentNumber: res.data.productPatentNumber,
                        productDesc: res.data.productDesc,
                        productAuthorName: res.data.productAuthorName,
                        productAuthorName: res.data.productAuthorName,
                        productPrice: res.data.productPrice,
                        productTitle: res.data.productTitle,
                        productType: res.data.productType,
                        detailList: res.data.detailList,
                        productId: res.data.productId

                    })
                })
                break;
        }
    }

    handleSave() {

        Fetch.post("private/shoppingCart/saveShoppingCart/" + this.props.ProductId).then(res => {
            if (res.flag == "1") {
                Toast.info(res.message, 1.5);
            } else {
                Toast.info(res.message, 1.5);
            }
        })

    }
    saveSub() {
        let that = this;
        let aaa = `/note_content/${that.props.ProductId}/${that.state.userId}`
        window.location.hash = aaa;
    }
    renderFooter(type) {
        switch (type) {
            case "1":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/2`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.saveSub.bind(this)}>议价</div>
                        <div onClick={this.handleSave.bind(this)}>购物车</div>
                    </div>
                )
            case "2":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/2`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.saveSub.bind(this)}>议价</div>
                        <div onClick={this.handleSave.bind(this)}>购物车</div>
                    </div>
                )
            case "3":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/2`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.saveSub.bind(this)}>议价</div>
                        <div onClick={this.handleSave.bind(this)}>购物车</div>
                    </div>
                )
        }

    }
    render() {
        let renderFoo = this.renderFooter(this.props.haveFlag)

        return (
            <div>
                <BackHeader title="图文详情" path="/index/myshop/1"/>
                <NoticeBar marqueeProps={{
                    loop: true,
                    style: {
                        padding: '0 7.5px'
                    }
                }}>
                    温馨提示:未防止发生错误导致用户上传失败,请在pc端上传,这里只做详情展示,给你带来的不便，敬请谅解。谢谢;
                </NoticeBar>
                <div className="image_component">

                    <div className="video">
                        <Carousel className="my-carousel" autoplay={true} infinite selectedIndex={0} swipeSpeed={35} beforeChange={(from, to) => {}} afterChange={index => {}}>
                            {this.state.data.map(item => {
                                console.log(item);
                                return (
                                    <a href="/" key={item}>
                                        <img src={item} alt="icon" onLoad={() => {
                                            window.dispatchEvent(new Event('resize'));
                                            this.setState({initialHeight: null});
                                        }}/>
                                    </a>
                                )
                            })}
                        </Carousel>
                    </div>
                    <WhiteSpace size="sm"/>

                    <div className="">
                        <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="标题" status={this.state.productTitle}/>

                        <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="作者" status={this.state.productAuthorName}/>
                        <ProductShow haveFlag={this.props.haveFlag} isshow="2" name="售价" status={this.state.productPrice}/>
                        <ProductShow haveFlag={this.props.haveFlag} isshow="2" name="授权" status={this.state.productType == 1 ? '共享' : '已授权'}/>

                        <Introduction haveFlag={this.props.haveFlag} isshow="1" title="简介" content={this.state.productDesc}/> 
                        {this.state.detailList.map((item, key) => {
                            if (item.productDetailType === 3) {
                                return (
                                    <div className="component_acce" key={key}>
                                        <div className="accessory">
                                            <NavLink to={`/accessory/${item.productDetailUrl}`}>附件</NavLink>
                                        </div>
                                    </div>
                                )
                            }
                        })}

                    </div>
                </div>
                {renderFoo}
            </div>
        )
    }
}
