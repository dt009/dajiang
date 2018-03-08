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
    Modal,
    NoticeBar,
    Toast
} from 'antd-mobile';
const TabPane = Tabs.TabPane;
import './knowledge_video.less';
import TextInput from 'formItem/textInput/textInput';
import ProductShow from '../ProductsShow/ProductsShow';
import Introduction from "./introduction/introduction"

import Fetch from 'fetch';

export default class KnowledgeVideo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modal1: false,
            productPatentNumber: '',
            productDesc: '',
            productAuthorName: '',
            productAuthorName: '',
            productPrice: '',
            productTitle: "",
            productType: '',
            productCreatedt: '',
            productId: ''
        }
        this.gettitle = this.gettitle.bind(this);
    }
    gettitle(value) {}
    
    componentWillMount() {

    }

    renderFooter(type) {
        switch (type) {
            case "1":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/3`}>立即购买</NavLink>
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
                            <NavLink to={`/close_an_account/${this.state.productId}/3`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.saveSub.bind(this)}>议价</div>
                        <div onClick={this.handleSave.bind(this)}>
                            购物车</div>
                    </div>
                )
            case "3":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/3`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.saveSub.bind(this)}>议价</div>
                        <div onClick={this.handleSave.bind(this)}>购物车</div>
                    </div>
                )
        }

    }
    handleSave() {
        let that = this;

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
        let data = {
            messageContent: "你好，商品不能砍价啊。",
            otherId: this.state.userId,
            productId: this.props.ProductId
        }

        let aaa = `/note_content/${that.props.ProductId}/${that.state.userId}`
        console.log(aaa);
        window.location.hash = aaa;

    }
    componentDidMount() {
        this.setState({modal1: true});

    }
    componentDidMount() {
        let data = {
            ProductId: this.props.ProductId
        }
        this.isSj(this.props.isSj);
        // Fetch.post("public/product/initPatentInfo/" + this.props.ProductId).then(res => {
        //     var arr = []
        //     res.data.detailList.map(function(index, key) {
        //         arr.push(res.data.detailList[key].productPath)

        //     })
        //     function getLocalTime(nS) {
        //         return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
        //     }
        //     this.setState({
        //         data: arr,
        //         productPatentNumber: res.data.productPatentNumber,
        //         productDesc: res.data.productDesc,
        //         productAuthorName: res.data.productAuthorName,
        //         productAuthorName: res.data.productAuthorName,
        //         productPrice: res.data.productPrice,
        //         productTitle: res.data.productTitle,
        //         productCreatedt: getLocalTime(res.data.productCreatedt),
        //         userId: res.data.userId

        //     })
        // })

    }
    isSj(type) {
        switch (type) {
            case "1":

                Fetch.post("public/product/initVideoInfo/" + this.props.ProductId).then(res => {
                    var arr = []
                    res.data.detailList.map(function(index, key) {
                        arr.push(res.data.detailList[key].productPath)

                    })
                    this.setState({
                        data: arr,
                        productPatentNumber: res.data.productPatentNumber,
                        productDesc: res.data.productDesc,
                        productAuthorName: res.data.productAuthorName,
                        productAuthorName: res.data.productAuthorName,
                        productPrice: res.data.productPrice,
                        productTitle: res.data.productTitle,
                        productId: res.data.productId,
                        productType: res.data.productType
                    })
                })
                break;
            case "2":

                Fetch.post("private/product/initDocInfo/" + this.props.ProductId).then(res => {
                    var arr = []
                    res.data.detailList.map(function(index, key) {
                        arr.push(res.data.detailList[key].productPath)

                    })
                    this.setState({
                        data: arr,
                        productPatentNumber: res.data.productPatentNumber,
                        productDesc: res.data.productDesc,
                        productAuthorName: res.data.productAuthorName,
                        productAuthorName: res.data.productAuthorName,
                        productPrice: res.data.productPrice,
                        productTitle: res.data.productTitle,
                        productId: res.data.productId,
                        productType: res.data.productType
                    })
                })
                break;
        }
    }
    onClose = key => () => {
        this.setState({modal1: false});
    }
    render() {
        let renderFoo = this.renderFooter(this.props.haveFlag)
        return (
            <div className="">
                <BackHeader title="视频详情" path="/index/myshop/1"/>
                <NoticeBar marqueeProps={{
                    loop: true,
                    style: {
                        padding: '0 7.5px'
                    }
                }}>
                    温馨提示:未防止发生错误导致用户上传失败,请在pc端上传视频,这里只做详情展示,给你带来的不便，敬请谅解。谢谢;
                </NoticeBar>
                <div className="">
                    <video className="video_container" controls="controls" src="http://hjpukevyyyiysz0kbt4.exp.bcevod.com/mda-hjvesxcds7610yh2/mda-hjvesxcds7610yh2.mp4"></video>
                </div>
                <WhiteSpace size="sm"/>

                <div className="">
                    <ProductShow haveFlag={this.props.haveFlag} name="标题" status={this.state.productTitle} isshow="1"/>
                    <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="作者" status={this.state.productAuthorName}/>
                    <ProductShow haveFlag={this.props.haveFlag} isshow="2" name="授权" status={this.state.productType == 1 ? '共享' : '已授权'}/>
                    <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="发布时间" status={this.state.productCreatedt}/>
                    <ProductShow haveFlag={this.props.haveFlag} isshow="2" name="售价" status={this.state.productPrice}/>
                    <Introduction title="简介" content="有部分原因是视频的编码不正确，在mp4格式的视频中，只支持h.264的视频。我的项目中也遇到了这种情况，但不是视频编码的问题。我在自己的网络下测试时，没有这样的问题"/>

                </div>
                {renderFoo}
            </div>
        )
    }
}
