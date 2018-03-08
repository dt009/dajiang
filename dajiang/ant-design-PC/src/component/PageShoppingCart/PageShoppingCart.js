/**
 * @author v_duantao
 * @file 我的购物车
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './PageShoppingCart.less';
import Fetch from 'Fetch/Fetch';

export default class PageShoppingCart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            resultList: [], // 结果列表
        }
    }

    componentDidMount() {
        Fetch.post(`private/shoppingCart/queryList`, {
            pageNum: 1,
            pageSize: 1000,
        }).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                this.setState({
                    resultList: data.list,
                })
            } else {
                this.props.history.push('/error')
            }
        })
    }

    handleFilterDate = value => {
        let time = new Date(value);
        let year = time.getFullYear();
        let month = time.getMonth() + 1;
        let day = time.getDate();
        return `${year}/${month}/${day}`
    };

    render() {
        let {props, state} = this;
        return (
            <div className='page_shopping_cart'>
                {
                    state.resultList.length === 0
                        ? '购物车为空'
                        : <div className='shop_list'>
                            {
                                state.resultList.map((item, key) => {
                                    return (
                                        <div
                                            className="shangpin_list"
                                            key={key}
                                            onClick={e => this.props.history.push(`/product/shopping/${item.productStyle}/${item.productId}`)}
                                        >
                                            <div className="head">
                                                <span>{item.productAuthorName}</span>
                                                {item.productTitle}
                                            </div>
                                            <div className="body">{item.productDesc}</div>
                                            <div className="footer">
                                                <span>{this.handleFilterDate(item.shoppingcartInsertdt)}</span>
                                                购买量：{item.orderNum}人
                                            </div>
                                        </div>
                                    )
                                })
                            }
                        </div>
                }
            </div>
        )
    }
}