/**
 * @author v_duantao
 * @file
 * @date 17/9/18 下午5:14
 */


import React, {Component} from 'react';

import {NavLink} from 'react-router-dom';

import Fetch from 'fetch';
import ProfessionalCard from "card/professionalCard/professionalCard";
import ProductCard from "card/productCard/productCard";

import AppCaro from '../../Carousel/Carousel'

import './home.less';


// 标题组件

class Title extends Component {
    constructor(props) {
        super(props);

    }

    render() {
        let style = {
            divStyle: {
                height: '0.42rem',
                width: '100%',
                marginTop: '0.25rem',
                display: 'flex'
            },
            spanFirst: {
                display: 'inline-block',
                height: '0.24rem',
                border: '0.04rem solid #fbb303',
                marginRight: '0.1rem'
            },
            h3: {
                fontSize: '0.3rem',
                flex: '1'
            },
            spanLast: {
                display: 'inline-block',
                marginRight: '0.1rem',
                color: '#000',
                fontSize: '0.1rem'
            }
        };

        let props = this.props;
        return (
            <div className={props.className} style={style.divStyle}>
                <span style={style.spanFirst}></span>
                <h3 style={style.h3}>{props.title}</h3>
                <NavLink to={props.path} style={style.spanLast} className="icon-sanjiao">查看更多</NavLink>
            </div>
        )
    }
}


export default class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            professionalList: [],  // 大匠列表
            productList: [], // 产品列表
        }
    }

    componentWillUpdate(){
        console.log(this.state)
    }

    componentDidMount() {

        // 获取大匠列表
        Fetch.get('public/professional/initProfessionals').then(res => {
            this.setState({
                professionalList: res.data
            })
        });


        Fetch.get('public/product/initProducts').then(res => {
            this.setState({
                productList: res.data
            })
        })
    }

    render() {
        return (
            <div className="index_home">
                {/* <div className="home_carousel"> */}
                <AppCaro />
                {/* </div> */}
                <div className="home_show">
                    <Title
                        className={'border_one'}
                        title={'大匠'}
                        path={'/index/search/0'}
                    />
                    <div className="home_description">
                        {
                            this.state.professionalList.map((item, key) => {
                                return (
                                    <ProfessionalCard
                                        key={key}
                                        path={`/da_jiang_detail/${item.professionalId}`}
                                        userPhotoPath={item.userPhotoPath}
                                        professionalName={item.professionalName}
                                        professionalPosition={item.professionalPosition}
                                        professionalWorkunit={item.professionalWorkunit}
                                        collectionNum={item.collectionNum}
                                        professionalIndroduction={item.professionalIndroduction}
                                    />
                                )
                            })
                        }
                    </div>
                    <Title
                        title={'产品'}
                        path={'/index/search/1'}
                    />
                    <div className="product">
                        {
                            this.state.productList.map((item, key) => {
                                return (
                                    <ProductCard
                                        key={key}
                                        path={`/goods_detail/${item.productId}/${item.haveFlag}/${item.productStyle}/1`}
                                        productTitle={item.productTitle}
                                        productPrice={item.productPrice}
                                        productAuthorName={item.productAuthorName}
                                        productDesc={item.productDesc}
                                        orderNum={item.orderNum}
                                        productUpdatedt={item.productUpdatedt}
                                    />
                                )
                            })
                        }
                    </div>
                </div>
            </div>
        )
    }
}
