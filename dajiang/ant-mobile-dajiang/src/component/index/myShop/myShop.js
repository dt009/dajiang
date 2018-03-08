/**
 * @author v_duantao and wackeCq
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */

import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import ListStore from './listStore/listStore'
import ProductCard from "card/productCard/productCard";
import {Tabs, WhiteSpace, Badge, Accordion, Modal} from 'antd-mobile';
const TabPane = Tabs.TabPane;
import AlloyFinger from 'AlloyFinger/AlloyFinger';
const alert = Modal.alert;

import './myShop.less';

import Fetch from 'fetch';


class PopupContent extends Component {
    constructor(props, context) {
        super(props, context);
        // this.state = {
        //     is_redirect: false,
        //     path: ''
        // }
     }
    onCreate = (sel) => {
        this.props.onClose();
        if (sel === 'patent') {
            // this.setState({ is_redirect: true, path: 'patent'});
            this.props.props.history.push('/knowledge/patent');
        }
        if (sel === 'image_text') {
            // this.setState({ is_redirect: true, path: 'image_text'});
            this.props.props.history.push('/knowledge/image_text');
        }
    }
    render() {
        // const { is_redirect, path } = this.state;
        // if (is_redirect) {
        //     return <Redirect to={`/sample/${path}`} />;
        // }
        return (
            <List renderHeader={() => `请选择创建知识类型`}>
                <List.Item onClick={() => { this.onCreate('patent'); }}>创建专利知识</List.Item>
                <List.Item onClick={() => { this.onCreate('image_text'); }}>创建图文知识</List.Item>
            </List>
        );
    }
}

export default class MyShop extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productList: [],
            isShow: true,
            queryOnSaleProducts: [],
            querySaveProducts: [],
            querySubmitProducts: [],
            queryHadAuditProducts: []
        }
    }
    callback(key) {}
    handleTabClick(key) {}
    componentWillMount() {
        Fetch.get('public/product/initProducts').then(res => {
            this.setState({productList: res.data})
        })
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        this.queryOnSaleProducts()
        this.querySaveProducts();
        this.queryHadAuditProducts();
        Fetch.post('private/myshop/querySubmitProducts', data).then(res => {
            this.setState({querySubmitProducts: res.data.list})
        })
    }
    handleKnowledge() {
        this.setState({
            isShow: !this.state.isShow
        })
    }
    onLongTap(e) {
        alert('', '确定删除么???', [
            {
                text: '确定',
                onPress: () => {
                    let data = {
                        "productId": this.state.querySaveProducts[e].productId
                    }
                    Fetch.post('private/myshop/deletePreSaleProducts/' + this.state.querySaveProducts[e].productId).then(res => {
                        if (res.flag == 1) {
                            this.querySaveProducts()

                        }
                    })
                }
            }, {
                text: '取消',
                onPress: () => console.log('cancel')
            }
        ])
    }
    onSwipe(evt) {
        if (evt.direction === "Left") {
            alert("left")
            this.setState({direction: "block"})
        }
        if (evt.direction === "Right") {
            alert("right")
            this.setState({direction: "none"})
        }
    }
    knowledgeVideo() {
        alert("温馨提示", '未避免发生不必要的错误，请在pc端上传谢谢', [
            {
                text: '确定',
                onPress: () => {}
            }, {
                text: '取消',
                onPress: () => console.log('cancel')
            }
        ])
    }
    knowledgeImage() {
        alert("温馨提示", '未避免发生不必要的错误，请在pc端上传谢谢', [
            {
                text: '确定',
                onPress: () => {}
            }, {
                text: '取消',
                onPress: () => console.log('cancel')
            }
        ])
    }

    getqueryOnSaleProducts(e, key) {
        let data = {
            "productId": this.state.queryOnSaleProducts[e].productId,
            "productPrice": key
        }
        Fetch.post('private/myshop/updateOnSaleProductPrice', data).then(res => {
            if (res.flag == 1) {
                this.queryOnSaleProducts()

            }
        })
    }
    getqueryHadAuditProducts(e, key) {
        let data = {
            "productId": this.state.queryHadAuditProducts[e].productId,
            "productPrice": key
        }
        Fetch.post('private/myshop/updateOnSaleProductPrice', data).then(res => {
            if (res.flag == 1) {
                this.queryHadAuditProducts()

            }
        })
    }
    updateOffSaleProductPrice(e, key) {
        let data = {
            "productId": this.state.querySaveProducts[e].productId,
            "productPrice": key
        }
        Fetch.post('private/myshop/updateOffSaleProductPrice', data).then(res => {
            if (res.flag == 1) {
                this.querySaveProducts()
            }
        })
    }
    querySaveProducts() {
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        Fetch.post('private/myshop/querySaveProducts', data).then(res => {
            this.setState({querySaveProducts: res.data.list})
        })
    }
    queryHadAuditProducts() {
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        Fetch.post('private/myshop/queryHadAuditProducts', data).then(res => {
            this.setState({queryHadAuditProducts: res.data.list})
        })
    }
    queryOnSaleProducts() {
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        Fetch.post('private/myshop/queryOnSaleProducts', data).then(res => {
            this.setState({queryOnSaleProducts: res.data.list})
        })
    }
    onhandleStatus(e) {
        alert(2);
    }
    render() {
        const putaway = this.props.match.params.id == 0
            ? <div>
                    <div className="product productSj">
                        {this.state.queryOnSaleProducts.map((item, key) => {
                            return (<ProductCard key={key} path={`/notputaway/${item.productId}/3/${item.productStyle}`} isSj="1" productTitle={item.productTitle} productPrice={item.productPrice} productAuthorName={item.productAuthorName} productDesc={item.productDesc} productStatus="已审核" collectionNum={item.collectionNum} productUpdatedt={item.productUpdatedt} onChangePriceFunction={this.getqueryOnSaleProducts.bind(this, key)}/>)
                        })
}
                    </div>
                </div>
            : <div>
                <Tabs defaultActiveKey="2" animated={false} onChange={this.callback.bind(this)} onTabClick={this.handleTabClick.bind(this)}>
                    <TabPane tab="非原创" key="1">
                        <div className="product">
                            {this.state.queryHadAuditProducts.map((item, key) => {
                                return (<ProductCard key={key} path={`/notputaway/${item.productId}/2/${item.productStyle}`} isSj="2" productId={item.productId} productTitle={item.productTitle} productPrice={item.productPrice} productAuthorName={item.productAuthorName} productDesc={item.productDesc} collectionNum={item.collectionNum} productUpdatedt={item.productUpdatedt} onChangePriceFunction={this.getqueryHadAuditProducts.bind(this, key)}/>)
                            })
}
                        </div>
                    </TabPane>
                    <TabPane tab="原创" key="2">
                        <div className="product">
                            {this.state.querySaveProducts.map((item, key) => {
                                return (
                                    <div key={key} data-productId={item.productId} className="alloy">
                                        <AlloyFinger key={key} onLongTap={this.onLongTap.bind(this, key)}>
                                            <div><ProductCard key={key} path={`/patent/${item.productId}/1/${item.productStyle}`} productId={item.productId} isSj="2" onhandleStatus ={this.onhandleStatus.bind(this)} productTitle={item.productTitle} productPrice={item.productPrice} productAuthorName={item.productAuthorName} productDesc={item.productDesc} productStatus="提交审核" collectionNum={item.collectionNum} productUpdatedt={item.productUpdatedt} onChangePriceFunction={this.updateOffSaleProductPrice.bind(this, key)}/></div>
                                        </AlloyFinger>
                                    </div>
                                )
                            })
}
                        </div>
                    </TabPane>
                </Tabs>
                <WhiteSpace size="sm"/>
            </div>

        return (
            <div className="index_my_shop">
                <div className="shop_publish">
                    <div className="title" onClick={this.handleKnowledge.bind(this)}>
                        {/* <NavLink to="/knowledge" className="footer_tabs"> */}
                        <span className="iconfont">&#xe640;</span>
                        <span>发布知识</span>
                        <span className="iconfont">&#xe608;</span>
                        {/* </NavLink> */}
                    </div>

                    <div style={{
                        display: this.state.isShow
                            ? "none"
                            : 'block'
                    }}>
                        <WhiteSpace size="sm"/>

                        <div className="knowledge_title" onClick={this.knowledgeVideo.bind(this)}>
                            <span>视频知识</span>
                        </div>

                        <div className="knowledge_title" onClick={this.knowledgeImage.bind(this)}>
                            <span>图文知识</span>
                        </div>

                        <div className="knowledge_title" id="knowledge_title">
                            <NavLink to="/publish">
                                <span>专利技术</span>
                            </NavLink>
                        </div>
                    </div>

                    <WhiteSpace size="sm"/>

                    <div className="container">
                        <NavLink to="/index/myshop/0">
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">上架</span>
                        </NavLink>
                        <span className="border">|</span>
                        <NavLink to="/index/myshop/1" className="footer_tabs">
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">未上架</span>
                        </NavLink>
                    </div>
                    <WhiteSpace size="sm"/>
                    {putaway}
                </div>
            </div>
        )
    }
}
