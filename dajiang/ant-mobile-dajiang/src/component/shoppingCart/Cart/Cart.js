/**
 * @author wackeCq
 * @file 这是我的购物车页面
 * @date 17/9/24 下午9:01
 */


import React, {Component} from 'react';
import './Cart.less'




export default class Card extends Component {
    constructor(props){
        super(props);
        this.state = {

        }
    }
    render() {
        return (
            <div>
                <div className="Cart_component">
                    <div className="title">{this.props.title}</div>
                    <div><span className="name">{this.props.name}</span><span className="price">{this.props.price}</span></div>
                    <div className="dec"><span className="title_dec">{this.props.dec}</span></div>
                </div>
            </div>
        )
    }
}
