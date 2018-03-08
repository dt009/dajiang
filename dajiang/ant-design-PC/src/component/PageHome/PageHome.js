/**
 * @author v_duantao
 * @file 主页 Home 页 的代码
 * @date 2017/11/20
 */

import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import { Carousel } from 'antd';
import Fetch from '../../common/Fetch/Fetch';

import './PageHome.less';


// 标题组件

class Title extends Component {
    constructor(props) {
        super(props);

    }

    render() {
        let style = {
            divStyle: {
                height: '30px',
                width: '100%',
                margin: '5px 0',
                display: 'flex'
            },
            spanFirst: {
                display: 'inline-block',
                height: '26px',
                border: '2px solid #fbb303',
                marginRight: '10px'
            },
            h3: {
                fontSize: '18px',
                lineHeight: '30px',
                flex: '1'
            },
            spanLast: {
                display: 'inline-block',
                marginRight: '0px',
                color: '#000',
                fontSize: '18px',
                lineHeight: '30px'
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

export default class PageHome extends Component {
    constructor() {
        super();
          this.state = {
            data: [],
            initialHeight: 200,
            professionalList: [],  // 大匠列表
            productList: [], // 产品列表
        };
    }

    componentWillMount() {
        this.fetchData();
    }

    fetchData = () => {
        // 获取轮播图的组件
        Fetch.get("public/banner/initBanners").then(res => {
            this.setState({
                data: res.data
            })
        });

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

    handleFilterDate = (value) => {
        let time = new Date(value);
        let year = time.getFullYear();
        let month = time.getMonth() + 1;
        let day = time.getDate();
        return `${year}/${month}/${day}`
    }

    render() {
        const { data } = this.state;
        console.log(data);
        return (
            <div className='page_home'>
                {/* 轮播 */}
                <Carousel
                    autoplay >
                    {data.map((item, key) => {
                        return <div key={key}>
                            <a href={item.recommentUrl ? item.recommentUrl : 'javascript:;'}>
                                <img src={item.recommentImagPath} alt=""/>
                            </a>
                        </div>
                    })}
                </Carousel>
                {/* 大匠 */}
                <Title
                    className={'border_one'}
                    title={'大匠'}
                    path={'/search/0'}
                />
                {
                    this.state.professionalList.map((item, key) => {
                        return (
                            <NavLink to={`/professional/${item.professionalId}`} key={key}><div className="dajiang_list">
                                <div className="title">
                                    <img src={item.userPhotoPath} alt=""/>
                                    <span>{item.professionalName}</span>
                                    {item.professionalPosition}-{item.professionalWorkunit}
                                    <i>{item.collectionNum}人关注</i>
                                </div>
                                <div className="description">
                                    简介：{item.professionalIndroduction}
                                </div>
                            </div></NavLink>
                        )
                    })
                }

                {/* 产品 */}
                <Title
                    className={'border_one'}
                    title={'产品'}
                    path={'/search/1'}
                />
                {
                    this.state.productList.map((item, key) => {
                        return (
                            <NavLink
                                to={`/product/home/${item.productStyle}/${item.productId}`}
                                key={key}
                            ><div className="shangpin_list">
                                <div className="head">
                                    <span>{item.productAuthorName}</span>
                                    {item.productTitle}
                                </div>
                                <div className="body">{item.productDesc}</div>
                                <div className="footer">
                                    <span>{this.handleFilterDate(item.productUpdatedt)}</span>
                                    购买量：{item.orderNum}人
                                </div>
                            </div></NavLink>
                        )
                    })
                }
            </div>
        )
    }
}


// class LeftNavButton extends React.Component {
//     render() {
//         return <button {...this.props}>Next</button>
//     }
// }
// class rightNavButton extends React.Component {
//     render() {
//         return <button {...this.props}>Next</button>
//     }
// }