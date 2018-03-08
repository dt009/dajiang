/**
 * @author v_duantao
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */

import React, {Component} from 'react';
import BackHeader from 'backHeader/backHeader';
import {HashRouter as Router, Route} from 'react-router-dom';
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
import './knowledge_patents.less';
import TextInput from 'formItem/textInput/textInput';
import ProductShow from '../ProductsShow/ProductsShow';
import Introduction from "./introduction/introduction"

import Fetch from 'fetch';

export default class KnowledgeImage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            // productList: [],
            data: [],
            initialHeight: 200,

            productPatentNumber: '',
            productDesc: '',
            productAuthorName: '',
            productAuthorName: '',
            productPrice: '',
            productType: '',
            productTitle: "",
            userId: '',
            professionalTypeId: '',
            productId: ''
        },

        this.gettitle = this.gettitle.bind(this);
        this.getProfessionalPhoneValue = this.getProfessionalPhoneValue.bind(this);
        this.getproductPatentNumber = this.getproductPatentNumber.bind(this);
        this.getproductAuthorName = this.getproductAuthorName.bind(this);
        this.getproductDesc = this.getproductDesc.bind(this);
        this.getproductType = this.getproductType.bind(this);
        this.getValueTitle = this.getValueTitle.bind(this);
    }
    getValueTitle(e) {
        this.state({productTitle: e})
    }
    getproductType(e) {
        this.setState({productType: e})
    }
    getproductDesc(value) {
        this.setState({productDesc: value})
    }
    getproductAuthorName(value) {
        this.setState({productAuthorName: value})
    }
    getproductPatentNumber(value) {
        this.setState({productPatentNumber: value})
    }
    gettitle(value) {}
    callback(key) {}
    handleTabClick(key) {}
    componentWillMount() {
        // Fetch.get('public/product/initProducts').then(res => {
        //     this.setState({productList: res.data})
        // })
    }
    componentWillUpdate() {}

    componentDidMount() {
        this.isSj(this.props.isSj)

    }
    handlecart() {
        Fetch.post("private/shoppingCart/saveShoppingCart/" + this.props.ProductId).then(res => {
            if (res.flag == 1) {
                Toast.success(res.message, 1);
            } else {
                Toast.fail(res.message, 1);
            }
        })
    }
    isSj(type) {
        switch (type) {
            case "1":
                Fetch.post("public/product/initPatentInfo/" + this.props.ProductId).then(res => {
                    var arr = [];
                    console.log("1111111111", res);
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
                        productType: res.data.productType,
                        productTitle: res.data.productTitle,
                        userId: res.data.userId,
                        professionalTypeId: res.data.professionalTypeId,
                        productId: res.data.productId

                    })
                })
                break;
            case "2":

                Fetch.post("private/product/initApplyPatentInfo/" + this.props.ProductId).then(res => {
                    var arr = [];
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
                        productType: res.data.productType,
                        productTitle: res.data.productTitle,
                        userId: res.data.userId,
                        professionalTypeId: res.data.professionalTypeId,
                        productId: res.data.productId

                    })
                })

                break;
        }
    }

    getProfessionalPhoneValue(value) {
        this.setState({productPrice: value})
    }
    handleClickPrice() {
        let that = this;
        let aaa = `/note_content/${that.props.ProductId}/${that.state.userId}`
        window.location.hash = aaa;

    }
    handleSave() {
        let that = this;
        var data;
        if (this.state.data[1] == undefined) {
            var data = {
                "detailApplyList": [
                    {
                        "productDetailType": 1,
                        "productPath": this.state.data[0]
                    }
                ],
                productAuthorName: this.state.productAuthorName,
                productDesc: this.state.productDesc,
                productPatentNumber: this.state.productPatentNumber,
                productPatentType: 1,
                productPrice: this.state.productPrice,
                productStatus: 3,
                productType: 1,
                productTitle: this.state.productTitle,
                professionalTypeId: this.state.professionalTypeId,
                productId: this.props.ProductId
            }
        } else {
            var data = {
                "detailApplyList": [
                    {
                        "productDetailType": 1,
                        "productPath": this.state.data[0]
                    }, {
                        "productDetailType": 1,
                        "productPath": this.state.data[1]
                    }
                ],
                productAuthorName: this.state.productAuthorName,
                productDesc: this.state.productDesc,
                productPatentNumber: this.state.productPatentNumber,
                productPatentType: 1,
                productPrice: this.state.productPrice,
                productStatus: 3,
                productType: 1,
                productTitle: this.state.productTitle,
                professionalTypeId: this.state.professionalTypeId,
                productId: this.props.ProductId
            }
        }

        Fetch.post("private/myshop/updatePatentApplyProduct", data).then(res => {
            if (res.flag == "1") {
                Toast.info(res.message, 1.5);
                window.location.hash = '/index/myshop/0';
            } else {
                Toast.info(res.message, 1.5);
            }
        })

    }
    saveSub() {
        let that = this;
        var data;
        if (this.state.data[1] == undefined) {
            var data = {
                "detailApplyList": [
                    {
                        "productDetailType": 1,
                        "productPath": this.state.data[0]
                    }
                ],
                productAuthorName: this.state.productAuthorName,
                productDesc: this.state.productDesc,
                productPatentNumber: this.state.productPatentNumber,
                productPatentType: 1,
                productPrice: this.state.productPrice,
                productStatus: 1,
                productType: 1,
                productTitle: this.state.productTitle,
                professionalTypeId: this.state.professionalTypeId,
                productId: this.props.ProductId
            }
        } else {
            var data = {
                "detailApplyList": [
                    {
                        "productDetailType": 1,
                        "productPath": this.state.data[0]
                    }, {
                        "productDetailType": 1,
                        "productPath": this.state.data[1]
                    }
                ],
                productAuthorName: this.state.productAuthorName,
                productDesc: this.state.productDesc,
                productPatentNumber: this.state.productPatentNumber,
                productPatentType: 1,
                productPrice: this.state.productPrice,
                productStatus: 1,
                productType: 1,
                productTitle: this.state.productTitle,
                professionalTypeId: this.state.professionalTypeId,
                productId: this.props.ProductId
            }
        }

        Fetch.post("private/myshop/updatePatentApplyProduct", data).then(res => {
            if (res.flag == "1") {
                Toast.info(res.message, 1.5);
                window.location.hash = '/index/myshop/1';
            } else {
                Toast.info(res.message, 1.5);
            }
        })
    }
    renderFooter(type) {
        console.log('哈哈啊啊啊啊啊啊啊啊啊啊啊啊');
        console.log(this.state);
        switch (type) {
            case "1":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/1`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.handleClickPrice.bind(this)}>议价</div>
                        <div onClick={this.handlecart.bind(this)}>购物车</div>
                    </div>
                )
            case "2":
                return (
                    <div className="productStyle">
                        {/* <div className="save" onClick = {this.saveSub.bind(this)}>保存</div>
                        <div style={{display:this.props.isSj =="1" ? "none" : "block"}} onClick = {this.handleSave.bind(this)}> 上架</div> */}
                    </div>
                )
            case "3":
                return (
                    <div className="productStyle">
                        <div className="accountfrom">
                            <NavLink to={`/close_an_account/${this.state.productId}/1`}>立即购买</NavLink>
                        </div>
                        <div className="product_none"></div>
                        <div className="save" onClick={this.handleClickPrice.bind(this)}>议价</div>
                        <div onClick={this.handlecart.bind(this)}>购物车</div>
                    </div>
                )
        }

    }
    render() {
        let renderFoo = this.renderFooter(this.props.haveFlag);

        return (
            <div>
                <BackHeader title="专利详情" path="/index/myshop/1"/>
                <NoticeBar marqueeProps={{
                    loop: true,
                    style: {
                        padding: '0 7.5px'
                    }
                }}>
                    温馨提示:未防止发生错误导致用户上传失败,请在pc端上传视频,这里只做详情展示,给你带来的不便，敬请谅解。谢谢;
                </NoticeBar>
                <div className="image_component">

                    <div className="video">
                        <Carousel className="my-carousel" autoplay={false} infinite selectedIndex={0} swipeSpeed={35} beforeChange={(from, to) => console.log(`slide from ${from} to ${to}`)} afterChange={index => console.log('slide to', index)}>
                            {this.state.data.map(ii => (
                                <a href="/" key={ii}>
                                    <img src={ii} alt="icon" onLoad={() => {
                                        window.dispatchEvent(new Event('resize'));
                                        this.setState({initialHeight: null});
                                    }}/>
                                </a>
                            ))}
                        </Carousel>
                    </div>
                    <WhiteSpace size="sm"/>

                    <div className="">
                        <ProductShow haveFlag={this.props.haveFlag} name="标题" status={this.state.productTitle} isshow="1" changeTextValue={this.getValueTitle}/>
                        <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="专利号" status={this.state.productPatentNumber} changeTextValue={this.getproductPatentNumber}/>

                        <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="作者" status={this.state.productAuthorName} changeTextValue={this.getproductAuthorName}/>
                        <ProductShow haveFlag={this.props.haveFlag} isshow="1" name="专业类别" status="建筑设计"/>
                        <ProductShow haveFlag={this.props.haveFlag} isshow="2" name="售价" status={this.state.productPrice} changeTextValue={this.getProfessionalPhoneValue}/>
                        <ProductShow haveFlag={this.props.haveFlag} isshow="2" name="授权" status={this.state.productType == 1 ? '共享' : '已授权'} changeTextValue={this.getproductType}/>

                        <Introduction haveFlag={this.props.haveFlag} isshow="1" title="简介" content={this.state.productDesc}/>

                    </div>
                </div>
                {renderFoo}
            </div>
        )
    }
}
