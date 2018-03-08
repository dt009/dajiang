/**
 * @author v_duantao
 * @file 我的知识页面
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './PageKnowledge.less';

import {Tabs} from 'antd';
import Fetch from 'Fetch/Fetch';

export default class PageKnowledge extends Component {

    constructor(props) {
        super(props);
        this.state = {
            tabsType: '1', // 在哪一个tab 页中
            resultList: [],  // 结果列表
        }
    }

    componentDidMount() {
        let {params} = this.props.match;
        let type = params.tabsType;

        console.log(type)

        this.fetchShareKnowledgeList(type);
        this.setState({
            tabsType: type
        })
    }

    // 切换 tab 时的操作
    switchTabsType = key => {
        this.props.history.push(`/user/knowledge/${key}`)
    };

    // 共享知识
    fetchShareKnowledgeList = key => {
        Fetch.post(`private/myKnowLedges/initMyKnowLedges/${key}`, {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    resultList: data,
                })
            } else {
                this.props.history.push('/error')
            }
        })
    };

    handleFilterDate = value => {
        let time = new Date(value);
        let year = time.getFullYear();
        let month = time.getMonth() + 1;
        let day = time.getDate();
        return `${year}/${month}/${day}`
    };


    render() {
        const TabPane = Tabs.TabPane;
        let {props, state} = this;
        return (
            <div className='page_knowledge'>
                <Tabs defaultActiveKey={state.tabsType} onChange={this.switchTabsType}>
                    <TabPane tab="共享" key="1">
                        {
                            state.resultList.length === 0
                                ? '暂无共享知识'
                                : state.resultList.map((item, key) => {
                                    return (
                                        <div
                                            className="shangpin_list"
                                            key={key}
                                            onClick={e => this.props.history.push(`/product/knowledge/${item.productStyle}/${item.productId}`)}
                                        >
                                            <div className="head">
                                                <span>{item.productAuthorName}</span>
                                                {item.productTitle}
                                            </div>
                                            <div className="body">{item.productDesc}</div>
                                            <div className="footer">
                                                <span>{this.handleFilterDate(item.productUpdatedt)}</span>
                                                购买量：{item.orderNum}人
                                            </div>
                                        </div>
                                    )
                                })
                        }
                    </TabPane>
                    <TabPane tab="授权" key="2">
                        {
                            state.resultList.length === 0
                                ? '暂无授权知识'
                                : state.resultList.map((item, key) => {
                                    return (
                                        <div
                                            className="shangpin_list"
                                            key={key}
                                            onClick={e => this.props.history.push(`/product/knowledge/${item.productId}`)}
                                        >
                                            <div className="head">
                                                <span>{item.productAuthorName}</span>
                                                {item.productTitle}
                                            </div>
                                            <div className="body">{item.productDesc}</div>
                                            <div className="footer">
                                                <span>{this.handleFilterDate(item.productUpdatedt)}</span>
                                                购买量：{item.orderNum}人
                                            </div>
                                        </div>
                                    )
                                })
                        }
                    </TabPane>
                </Tabs>
            </div>
        )
    }
}