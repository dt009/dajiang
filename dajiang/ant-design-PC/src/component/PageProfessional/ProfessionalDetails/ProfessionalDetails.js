/**
 * @author v_duantao
 * @file 大匠详情
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './ProfessionalDetails.less';
import Fetch from 'Fetch/Fetch'
import GoodsItem from '../goodsItem/GoodsItem';
export default class ProfessionalDetails extends Component {

    state = {
        detail: null,
        zhuanli_list: [],
        tuwen_list: [],
        shipin_list: [],
        active: 1,

    }
    componentWillMount() {
        console.log(this.props);
        console.log(this.props.match.params);
        const { professional_id} = this.props.match.params;
        console.log(professional_id);
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
            "pageSize": 1000
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
        // regionStr 大匠地址  professionalIndroduction 大匠详情
        const { professionalName, professionalPhotoPath, professionalField, professionalIndroduction, regionStr, collectionCount, collectionState, professionalWorkunit, professionalPosition } = this.state.detail;
        return (
            <div className='w-profDetail'>
                <div className="w-profDetail_avtar">
                    {professionalPhotoPath ? (<img src={professionalPhotoPath}/>) : (<p className="w-profDetail_avtar_no">暂未上传图片</p>)}


                    <div className="w-profDetail_ifo">
                        <span className="w-profDetail_ifo_left">{professionalName}</span>
                        <span className="w-profDetail_ifo_left">{professionalPosition}</span>
                        <span className="w-profDetail_ifo_left">{professionalWorkunit}</span>
                        <span className="w-profDetail_ifo_right">{regionStr ? regionStr : '未设置'}</span>
                    </div>
                    <div onClick={() => { this.handCollect(collectionState); }} className="w-profDetail_fav">
                        {collectionCount}人收藏                  
                    </div>


                </div>
                <div className="w-profDetail_intr">
                    <p>
                        简介：{ professionalIndroduction ? professionalIndroduction : '该大匠比较懒，暂时还没有添加简介~~~' }
                    </p>
                </div>
                <ul className="w-tabs clearfix">
                    <li className={this.state.active === 1 ? 'active' : ''}>
                        <a href="javascript:;" onClick={this.fetchZhuanLiList}>专利技术</a><div className="w-tabs-line"></div>
                    </li>
                    <li className={this.state.active === 2 ? 'active' : ''}>
                        <a href="javascript:;" onClick={this.fetchTuWenList}>图文知识</a><div className="w-tabs-line"></div>
                    </li>
                    <li className={this.state.active === 3 ? 'active' : ''}>
                        <a href="javascript:;" onClick={this.fetchShiPingList}>视频</a><div className="w-tabs-line"></div>
                    </li>
                </ul>
                <div>

                    {this.state.active === 1 && this.state.zhuanli_list && this.state.zhuanli_list.length > 0 ?
                        this.state.zhuanli_list.map((item) => {
                            return <GoodsItem key={item.productId} ListTitle={"建筑设计"} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'}
                                      ItemContent={item.productDesc}
                                      ListName={item.productTitle}
                                      Id={item.productId} url={`/product/putaway/${item.productStyle}/${item.productId}`}
                                      url={`/product/professional/1/${item.productId}`}
                                      PriceUrl={`/close_an_account/${item.productId}/1`}
                            />
                        })
                        : this.state.active ===1 ? <div className='detail_hint'>暂时没有相关专利...</div> : ''}
                    {this.state.active === 2&& this.state.tuwen_list && this.state.tuwen_list.length > 0 ?
                        this.state.tuwen_list.map((item) => {
                            return <GoodsItem key={item.productId} ListTitle={"建筑设计"} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'}
                                      ItemContent={item.productDesc}
                                      ListName={item.productTitle}
                                      Id={item.productId}
                                      url={`/product/professional/2/${item.productId}`}
                                      PriceUrl={`/close_an_account/${item.productId}/2`}
                            />
                        })
                        : this.state.active ===2 ? <div className='detail_hint'>暂时没有相关图文...</div> : ''}
                    {this.state.active === 3&& this.state.shipin_list && this.state.shipin_list.length > 0 ?
                        this.state.shipin_list.map((item) => {
                            return <GoodsItem key={item.productId} ListTitle={"建筑设计"} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'}
                                      ItemContent={item.productDesc}
                                      ListName={item.productTitle}
                                      Id={item.productId}
                                      url={`/product/professional/3/${item.productId}`}
                                      PriceUrl={`/close_an_account/${item.productId}/3`}
                            />
                        })
                        : this.state.active ===3 ? <div className='detail_hint'>暂时没有相关视频...</div> : ''}
                </div>
            </div>
        )
    }
}