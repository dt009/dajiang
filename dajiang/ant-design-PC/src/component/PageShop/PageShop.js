/**
 * @author wackeCq
 * @file 我的店铺
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './PageShop.less';
import { Tabs } from 'antd';
const TabPane = Tabs.TabPane;
import Fetch from '../../common/Fetch/Fetch';
import { NavLink } from 'react-router-dom';
import ProductCard from './children/productCard'
function callback(key) {
    console.log(key);
}
export default class PageShop extends Component { 
    constructor(props){
        super(props);
        this.state ={
            productList:[],
            queryHadAuditProducts:[],
            queryOnSaleProducts:[],
            querySaveProducts:[],
            isShow:true
        };
        this.handleKnowledge = this.handleKnowledge.bind(this);
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
    
    queryOnSaleProducts() {
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        Fetch.post('private/myshop/queryOnSaleProducts', data).then(res => {
            this.setState({ queryOnSaleProducts: res.data.list })
        })
    }
    querySaveProducts() {
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        Fetch.post('private/myshop/querySaveProducts', data).then(res => {
            this.setState({ querySaveProducts: res.data.list })
        })
    }
    queryHadAuditProducts() {
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        Fetch.post('private/myshop/queryHadAuditProducts', data).then(res => {
            this.setState({ queryHadAuditProducts: res.data.list })
        })
    }
    onhandleStatus(e) {
        alert(2);
    }
    componentWillMount() {
        Fetch.get('public/product/initProducts').then(res => {
            this.setState({ productList: res.data })
        })
        let data = {
            "pageNum": 1,
            "pageSize": 10
        }
        this.queryOnSaleProducts()
        this.querySaveProducts();
        this.queryHadAuditProducts();
        Fetch.post('private/myshop/querySubmitProducts', data).then(res => {
            this.setState({ querySubmitProducts: res.data.list })
        })
    }
    handleKnowledge() {
        this.setState({
            isShow: !this.state.isShow
        })
    }
    render() {
        // console.log(this.props.match.params.id)
        console.log(this.state);
        const putaway = this.props.match.params.id == 0 
        ? <div>
                <div className="product productSj">
                    {this.state.queryOnSaleProducts.map((item, key) => {
                        return (
                            <ProductCard 
                            key={key} 
                            path={`/product/putaway/${item.productStyle}/${item.productId}`} 
                            isSj="1" 
                            productTitle={item.productTitle} 
                            productPrice={item.productPrice} 
                            productAuthorName={item.productAuthorName} 
                            productDesc={item.productDesc} 
                            productStatus="已审核" 
                            collectionNum={item.collectionNum} 
                            productUpdatedt={item.productUpdatedt} 
                            onChangePriceFunction={this.getqueryOnSaleProducts.bind(this, key)} />)
                    })
                    }
                </div>
        </div>
        : <div>
            <Tabs defaultActiveKey="1" onChange={callback}>
                <TabPane tab="非原创" key="1">
                        <div className="product">
                            {this.state.queryHadAuditProducts.map((item, key) => {
                                return (
                                    <ProductCard 
                                    key={key} 
                                    // path={`/notputaway/${item.productId}/2/${item.productStyle}`}
                                    path={`/product/no_original/${item.productStyle}/${item.productId}`}
                                     
                                    isSj="2" 
                                    productId={item.productId} 
                                    productTitle={item.productTitle} 
                                    productPrice={item.productPrice} 
                                    productAuthorName={item.productAuthorName} 
                                    productDesc={item.productDesc} 
                                    collectionNum={item.collectionNum} 
                                    productUpdatedt={item.productUpdatedt} 
                                    onChangePriceFunction={this.getqueryHadAuditProducts.bind(this, key)} />)
                            })
                            }
                        </div>
                </TabPane>
                <TabPane tab="原创" key="2">
                        <div className="product">
                            {this.state.querySaveProducts.map((item, key) => {
                                return (
                                    <div key={key} data-productId={item.productId} className="alloy">
                                        <div>
                                            <ProductCard key={key} 
                                            path={`/product/original/${item.productStyle}/${item.productId}`}
                                            
                                            // path={`/patent/${item.productId}/1/${item.productStyle}`} 
                                            productId={item.productId} 
                                            isSj="2" 
                                            onhandleStatus={this.onhandleStatus.bind(this)} 
                                            productTitle={item.productTitle} 
                                            productPrice={item.productPrice} 
                                            productAuthorName={item.productAuthorName} 
                                            productDesc={item.productDesc} 
                                            productStatus="提交审核" 
                                            collectionNum={item.collectionNum} 
                                            productUpdatedt={item.productUpdatedt} 
                                            onChangePriceFunction={this.updateOffSaleProductPrice.bind(this, key)} /></div>
                                    </div>
                                )
                            })
                            }
                        </div>
                </TabPane>
            </Tabs>
        </div>
        
        return (
            <div className='page_shop'>
                <div className="title" onClick={this.handleKnowledge}>
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

                    <div className="knowledge_title">
                        <span onClick={e => this.props.history.push(`/product/publish/3/none`)}>视频知识</span>
                    </div>

                    <div className="knowledge_title">
                        <span onClick={e => this.props.history.push(`/product/publish/2/none`)}>图文知识</span>
                    </div>

                    <div className="knowledge_title" id="knowledge_title">
                        <NavLink to="/publish_patent">
                            <span>专利技术</span>
                        </NavLink>
                    </div>
                </div>
                <div className="container">
                    <NavLink to="/shop/0" >
                        <span className="tabs_icon"></span>
                        <span className="tabs_title tabs_0" style={{ borderBottom: this.props.match.params.id == 0 ? '3px solid #fbb601' : 'none'}}>上架</span>
                    </NavLink>
                    <div className="myshop_0"></div>
                    <NavLink to="/shop/1" className="footer_tabs">
                        <span className="tabs_icon"></span>
                        <span className="tabs_title tabs_1" style={{ borderBottom: this.props.match.params.id == 1 ? '3px solid #fbb601' : 'none' }}>未上架</span>
                    </NavLink>
                </div> 
                {putaway}         

            </div>
        )
    }
}