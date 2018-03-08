/**
 * @author v_duantao
 * @file 商品页面
 * @date 2017/11/27
 */

import React, {Component} from 'react';
import './PageProduct.less';
import ProductImage from "./ProductImage/ProductImage"; // 图文详情
import ProductPatent from "./ProductPatent/ProductPatent"; // 专利详情
import ProductVideo from "./ProductVideo/ProductVideo"; // 视屏详情

import Fetch from 'Fetch/Fetch';

export default class PageProduct extends Component {
    constructor(props) {
        super(props);
        this.state = {
            position: '',
            productId: '',
            productStyle: '',
        }
    }

    componentDidMount() {
        let {props, state} = this;
        let {params} = props.match;
        let {position, productId, productStyle} = params;
        console.log(params);
        this.setState({
            position,
            productStyle,
            productId
        })
    }

    // 渲染不同的商品
    renderProductStyle = () => {
        let {productStyle, productId, position} = this.state;
        switch (productStyle) {
            // 专利
            case '1' :
                return (
                    <ProductPatent
                        position={position}
                        productId={productId}
                    />
                );
                break;
            // 图文
            case '2' :
                return (
                    <ProductImage
                        position={position}
                        productId={productId}
                    />
                );
                break;

            // 视频
            case '3' :
                return (
                    <ProductVideo
                        position={position}
                        productId={productId}
                    />
                );
                break;
            default:
                return (
                    <div>加载中....</div>
                )
        }
    };

    render() {
        return (
            <div className='page_product'>
                {this.renderProductStyle()}
            </div>
        )
    }
}