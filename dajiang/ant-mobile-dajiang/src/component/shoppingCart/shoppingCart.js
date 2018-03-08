/**
 * @author v_duantao
 * @file 这是我的购物车页面
 * @date 17/9/24 下午9:01
 */

import React, {Component} from 'react';
import {Modal} from 'antd-mobile';
import BackHeader from 'backHeader/backHeader';
import Card from './Cart/Cart';
import Fetch from 'fetch';
import AlloyFinger from 'AlloyFinger/AlloyFinger';
const alert = Modal.alert;
import {Link} from 'react-router-dom';
import './shoppingCart.less'

export default class ShoppingCart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            productId: ''
        }
    }
    onLongTap(e) {
        alert('', '确定删除么???', [
            {
                text: '确定',
                onPress: () => {
                    let data = {
                        "productId": this.state.data[e].productId
                    }
                    Fetch.post('private/shoppingCart/deleteShoppingCart/' + this.state.data[e].productId).then(res => {
                        if (res.flag == 1) {
                            this.componentDidMount()

                        }
                    })
                }
            }, {
                text: '取消',
                onPress: () => console.log('cancel')
            }
        ])
    }
    componentDidMount() {
        var that = this;
        let data = {}
        Fetch.post('private/shoppingCart/queryList', data).then(res => {
            if (res.flag == 1) {
                that.setState({data: res.data.list})
            } else {
                Toast.fail('初始化信息错误, 请检查网络', 1)

            }
        })

    }
    render() {
        return (
            <div>
                <BackHeader title="我的购物车" path='/index/my'/>
                <div>
                    {this.state.data.map((index, key) => {
                        return (
                            <div key={key} className="showModalvideo">
                                <Link to={`/goods_detail/${index.productId}/${index.haveFlag}/${index.productStyle}/1`}>
                                    <AlloyFinger key={key} onLongTap={this.onLongTap.bind(this, key)}>
                                        <div key={key}>
                                            <Card title={index.productTitle} name={index.productAuthorName} price={index.productPrice} dec={index.productDesc}/>
                                        </div>

                                    </AlloyFinger>
                                </Link>
                            </div>

                        )
                    })}
                </div>
            </div>
        )
    }
}
