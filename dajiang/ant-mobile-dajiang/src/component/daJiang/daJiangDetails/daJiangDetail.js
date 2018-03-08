/**
 * @author v_duantao
 * @file 大匠详情页
 * @date 17/10/13 下午6:53
 */

import React, {Component} from 'react';
import { NavLink } from 'react-router-dom';

import './daJiangDetails.less';
import BackHeader from 'backHeader/backHeader';
import ListItem from '../detailsListItem/detailsListItem';
import Fetch from 'fetch';

export default class DaJiangDetail extends Component {
    constructor(props) {
        super(props);
    }
    
    state = {
        detail: null,
        zhuanli_list: [],
        tuwen_list: [],
        shipin_list: [],
        active: 1,

    }    

    componentWillMount() {
        console.log(this.props);
        
        const { professional_id } = this.props.match.params;
        if (professional_id) {
            Fetch.post(`/public/professional/queryProfessionalById/${professional_id}`, {
                "condition": {
                    "keyWord":"",
                  "professionalTypeIds": [
                    
                  ],
                  "regionIds": [
                    
                  ]
                },
                "pageNum": 1,
                "pageSize": 1
            }).then((res) => {
                if (res.flag === 1) {
                    console.log(res);
                    this.setState({
                        detail: res.data
                    });
                }
            });

            this.fetchZhuanLiList();
        }
    }

    handCollect = (e) => {
        //  e: 0 未登录  1: 未收藏  2: 已收藏
        if (e === 0) {
            return false;
        } else if (e === 1) {
            this.fetchCollect(); 
        } else if (e === 2) {
            this.fetchUnCollect();
        }
    }

    fetchZhuanLiList = () => {
        this.setState({active: 1});
        const { professional_id } = this.props.match.params;
        Fetch.post(`/public/product/queryProductByProfessionalId/${professional_id}/1`, {
            "pageNum": 1,
            "pageSize": 10
        }).then((res) => {
            if (res.flag === 1) {
                this.setState({
                    zhuanli_list: res.data.list
                });
            }
        });
    }

    fetchTuWenList = () => {
        this.setState({active: 2});
        const { professional_id } = this.props.match.params;
        Fetch.post(`/public/product/queryProductByProfessionalId/${professional_id}/2`, {
            "pageNum": 1,
            "pageSize": 10
        }).then((res) => {
            if (res.flag === 1) {
                this.setState({
                    tuwen_list: res.data.list
                });
            }
        });
    }

    fetchShiPingList = () => {
        const { professional_id } = this.props.match.params;
        this.setState({active: 3});
        Fetch.post(`/public/product/queryProductByProfessionalId/${professional_id}/3`, {
            "pageNum": 1,
            "pageSize": 10
        }).then((res) => {
            if (res.flag === 1) {
                this.setState({
                    shipin_list: res.data.list
                });
            }
        });
    }

    fetchCollect = () => {
        const { professional_id } = this.props.match.params;
        Fetch.post(`/private/user/saveCollection/${professional_id}`, {}).then((res) => {
            if (res.flag === 1) {
                // 增加收藏数
                this.setState({detail: {...this.state.detail, collectionCount: this.state.detail.collectionCount + 1, collectionState: 2}});
            }
        });
    }

    fetchUnCollect = () => {
        const { professional_id } = this.props.match.params;
        Fetch.post(`private/user/deleteCollection/${professional_id}`, {}).then((res) => {
            if (res.flag === 1) {
                // 减少收藏数
                this.setState({ detail: {...this.state.detail, collectionCount: this.state.detail.collectionCount - 1, collectionState: 1}});
            }
        });
    }

    render() {
        if(!this.state.detail) { return null; }
        console.log(this.props);
        // regionStr 大匠地址  professionalIndroduction 大匠详情
        const { professionalName, professionalPhotoPath, professionalField, professionalIndroduction, regionStr, collectionCount, collectionState, professionalWorkunit, professionalPosition } = this.state.detail;
        return (
            <div className='dajiang_details'>
                {/* 这是大匠详情页 */}
                <BackHeader path='/index/search/0' title='大匠详情'/>
                <div className='dajiang_details_body'>
                    <div className='dajiang_card'>
                        <img src={professionalPhotoPath} alt={professionalPhotoPath ? '' : '暂未上传图片'}/>
                        <div className='dajiang_card_title'>
                            <div>{professionalName}</div>
                            <div>{professionalPosition}-{professionalWorkunit}</div>
                            <div>{regionStr ? regionStr : '未设置'}</div>
                        </div>
                        <div className='dajiang_collect'>
                            <div onClick={() => { this.handCollect(collectionState); }}>
                                {collectionCount}人收藏
                                {collectionState === 2 ? <span>&#xe603;</span> : ''}
                                {collectionState === 1 ? <span>&#xe683;</span> : ''}
                            </div>
                        </div>
                    </div>
                    <div className='dajiang_info'>
                        {/* 简介：雷蒙德·罗维（Raymond Loewy）1889年出生于法国巴黎是美国工业设计的重要奠基人之一，一生从事工业产品设计、包装设计及平面设计,参与项目多达数千个，设计领域极为广泛，代表了第一代美国工业设计师涉猎的广泛。 */}
                        简介：{ professionalIndroduction ? professionalIndroduction : '该大匠比较懒，暂时还没有添加简介~~~' }
                    </div>
                    <div className="container">
                        <a className={this.state.active === 1 ? ' footer_tabs active' : 'footer_tabs'} onClick={this.fetchZhuanLiList}>
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">专利技术</span>
                        </a>
                        <span className="border">|</span>
                        <a className={this.state.active === 2 ? 'footer_tabs active' : 'footer_tabs'} onClick={this.fetchTuWenList}>
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">图文知识</span>
                        </a>
                        <span className="border">|</span>
                        <a className={this.state.active === 3 ? 'footer_tabs active' : 'footer_tabs'} onClick={this.fetchShiPingList}>
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">视频</span>
                        </a>
                    </div>
                    <div>
                        {this.state.active === 1 && this.state.zhuanli_list && this.state.zhuanli_list.length > 0 ?
                            this.state.zhuanli_list.map((item, key) => 
                                <ListItem ListTitle={item.productTitle} key={key} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'} 
                                    ItemContent={item.productDesc}
                                    ListName={item.productAuthorName}
                                    productId={item.productId}
                                    haveFlag={item.haveFlag}
                                    productStyle={item.productStyle}
                                    type={1}
                                    prop={this.props}
                                />
                            )
                            : this.state.active ===1 ? <div className='detail_hint'>暂时没有相关专利...</div> : ''}
                        {this.state.active === 2&& this.state.tuwen_list && this.state.tuwen_list.length > 0 ?
                            this.state.tuwen_list.map((item, key) =>
                                <ListItem ListTitle={item.productTitle} key={key} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'} 
                                    ItemContent={item.productDesc}
                                    ListName={item.productAuthorName}
                                    productId={item.productId}
                                    haveFlag={item.haveFlag}
                                    productStyle={item.productStyle}
                                    prop={this.props}
                                    type={2}
                                />
                            )
                            : this.state.active ===2 ? <div className='detail_hint'>暂时没有相关图文...</div> : ''}
                        {this.state.active === 3&& this.state.shipin_list && this.state.shipin_list.length > 0 ?
                            this.state.shipin_list.map((item, key) =>
                                <ListItem ListTitle={item.productTitle} key={key} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'} 
                                    ItemContent={item.productDesc}
                                    ListName={item.productAuthorName}
                                    productId={item.productId}
                                    haveFlag={item.haveFlag}
                                    productStyle={item.productStyle}
                                    prop={this.props}
                                    type={3}
                                />
                            )
                            : this.state.active ===3 ? <div className='detail_hint'>暂时没有相关视频...</div> : ''}
                    </div>
                </div>
            </div>
        )
    }
}
