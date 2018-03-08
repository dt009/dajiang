/**
 * @author ruixi
 * @file 知识经济人详情页
 * @date 17/10/23
 */

import React, {Component} from 'react';
import { NavLink } from 'react-router-dom';

import './brokerDetail.less';
import BackHeader from 'backHeader/backHeader';
import ListItem from '../../daJiang/detailsListItem/detailsListItem';
import Fetch from 'fetch';

export default class brokerDetail extends Component {

    state = {
        detail: null,
        zhuanli_list: [],
        tuwen_list: [],
        shipin_list: [],
        active: 1,
    }    

    componentWillMount() {
        console.log(this.props);
        const { cko_key } = this.props.match.params;
        if (cko_key) {
            Fetch.post(`/public/cko/queryCKOById/${cko_key}`, {}).then((res) => {
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
        console.log("收藏或取消收藏");
    }

    fetchZhuanLiList = () => {
        this.setState({active: 1});
        const { cko_key } = this.props.match.params;
        Fetch.post(`/public/product/queryProductByCkoId/${cko_key}/1`, {
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
        const { cko_key } = this.props.match.params;
        Fetch.post(`/public/product/queryProductByCkoId/${cko_key}/2`, {
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
        const { cko_key } = this.props.match.params;
        this.setState({active: 3});
        Fetch.post(`/public/product/queryProductByCkoId/${cko_key}/3`, {
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

    render() {
        if(!this.state.detail) { return null; }
        const { regionName, ckoName, ckoNickname, userPhotoPath } = this.state.detail;
        return (
            <div className='broker_detail'>
                <BackHeader path='/index/search/2' title='知识经济人详情'/>
                <div className='broker_detail_body'>
                    <div className='broker_card'>
                        <img src={userPhotoPath ? userPhotoPath : ''} alt=""/>
                        <div>
                            <div>
                                {/* <span>{}</span> */}
                                {ckoNickname}
                            </div>
                            {ckoName}
                        </div>
                        <p>{regionName}</p>
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
                            this.state.zhuanli_list.map((item, key) => {
                                return (<ListItem ListTitle={item.productTitle} key={key} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'} 
                                    ItemContent={item.productDesc}
                                    ListName={item.productAuthorName}
                                    productId={item.productId}
                                    haveFlag={item.haveFlag}
                                    productStyle={item.productStyle}
                                    prop={this.props}
                                    type={1}
                                />)
                            })
                            : this.state.active ===1 ? <div className='detail_hint'>暂时没有相关专利...</div> : ''}
                        {this.state.active === 2 && this.state.tuwen_list && this.state.tuwen_list.length > 0 ?
                            this.state.tuwen_list.map((item, key) => {
                                return (<ListItem ListTitle={item.productTitle} key={key} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'} 
                                    ItemContent={item.productDesc}
                                    ListName={item.productAuthorName}
                                    productId={item.productId}
                                    haveFlag={item.haveFlag}
                                    productStyle={item.productStyle}
                                    prop={this.props}
                                    type={2}
                                />)
                            })
                            : this.state.active ===2 ? <div className='detail_hint'>暂时没有相关图文...</div> : ''}
                        {this.state.active === 3 && this.state.shipin_list && this.state.shipin_list.length > 0 ?
                            this.state.shipin_list.map((item, key) => {
                                return (<ListItem ListTitle={item.productTitle} key={key} Num={item.orderNum ? item.orderNum : 0} NumMeasure={'人'} Price={item.productPrice} BtnText={'购买'} 
                                    ItemContent={item.productDesc}
                                    ListName={item.productAuthorName}
                                    productId={item.productId}
                                    haveFlag={item.haveFlag}
                                    productStyle={item.productStyle}
                                    prop={this.props}
                                    type={3}
                                />)
                            })
                            : this.state.active ===3 ? <div className='detail_hint'>暂时没有相关视频...</div> : ''}
                    </div>
                </div>
            </div>
        )
    }
}
