/**
 * @author v_duantao
 * @file 我的知识页面
 * @date 17/9/24 下午8:56
 */

import React, {Component} from 'react';
// import { Tabs, WhiteSpace } from 'antd-mobile';
import {Tabs, WhiteSpace, Badge, Accordion, Modal} from 'antd-mobile';
const TabPane = Tabs.TabPane;
import Fetch from 'fetch';
import ProductCard from "card/productCard/productCard";

import './myKnowledge.less';

import BackHeader from 'backHeader/backHeader';

export default class MyKnowledge extends Component {
    constructor(props) {
        super(props);
        this.state = {
            queryHadAuditProducts: [],
            queryHadAuditProducts1: []

        }
    }
    componentDidMount() {
        this.getqueryOnSaleProducts()
    }
    getqueryOnSaleProducts() {
        Fetch.post('private/myKnowLedges/initMyKnowLedges/2').then(res => {
            if (res.flag == 1) {
                this.setState({queryHadAuditProducts: res.data})

            }
        })
    }
    getqueryOnSaleProducts1() {
        Fetch.post('private/myKnowLedges/initMyKnowLedges/1').then(res => {
            if (res.flag == 1) {
                this.setState({queryHadAuditProducts1: res.data})

            }
        })
    }

    render() {
        const tabs = [
            {
                title: 'First Tab'
            }, {
                title: 'Second Tab'
            }, {
                title: 'Third Tab'
            }
        ];
        return (
            <div className="my_knowledge">
                <BackHeader path="/index/my" title="我的知识"/>

                <Tabs defaultActiveKey="2" animated={false}>
                    <TabPane tab="共享" key="1">
                        <div className="">
                            {this.state.queryHadAuditProducts1.map((item, key) => {
                                return (<ProductCard key={key} path={`/notputaway/${item.productId}/2/${item.productStyle}`} isSj="2" productId={item.productId} productTitle={item.productTitle} productPrice={item.productPrice} productAuthorName={item.productAuthorName} productDesc={item.productDesc} collectionNum={item.collectionNum} productUpdatedt={item.productUpdatedt}/>)
                            })
}
                        </div>

                    </TabPane>
                    <TabPane tab="授权" key="2">

                        <div className="">
                            {this.state.queryHadAuditProducts.map((item, key) => {
                                return (<ProductCard key={key} path={`/notputaway/${item.productId}/2/${item.productStyle}`} isSj="2" productId={item.productId} productTitle={item.productTitle} productPrice={item.productPrice} productAuthorName={item.productAuthorName} productDesc={item.productDesc} collectionNum={item.collectionNum} productUpdatedt={item.productUpdatedt}/>)
                            })
}
                        </div>
                    </TabPane>
                </Tabs>

            </div>
        )
    }
}
