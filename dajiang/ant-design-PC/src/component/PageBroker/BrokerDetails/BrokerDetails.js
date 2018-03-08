/**
 * @author wzn
 * @file 知识经济人详情页
 * @date 17/12/01
 */

import React, {Component} from 'react';
import { NavLink } from 'react-router-dom';

import './BrokerDetails.less';

import Fetch from 'Fetch/Fetch';

export default class brokerDetail extends Component {

    state = {
        detail: null,
        zhuanli_list: [],
        tuwen_list: [],
        shipin_list: [],
        active: 1,
        path:"http://owu66z9w4.bkt.clouddn.com/o_1bteq8bna1n341mkh1jsu1m0oj6ja.jpg"
    }

    componentWillMount() {
        console.log(this.props);
        const { brokerId  } = this.props.match.params;
        if (brokerId ) {
            Fetch.post(`/public/cko/queryCKOById/${brokerId }`, {}).then((res) => {
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
        const { brokerId  } = this.props.match.params;
        Fetch.post(`/public/product/queryProductByCkoId/${brokerId }/1`, {
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
        const { brokerId  } = this.props.match.params;
        Fetch.post(`/public/product/queryProductByCkoId/${brokerId }/2`, {
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
        const { brokerId  } = this.props.match.params;
        this.setState({active: 3});
        Fetch.post(`/public/product/queryProductByCkoId/${brokerId }/3`, {
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
       <div className="wrap">
           <div className="detail-wrap">
               <div className="title-wrap clearFix">
                   <div className="title-left">
                          < img src={userPhotoPath ? userPhotoPath : ''} alt=""/>
                       <span>{ckoNickname}</span><b></b>
                       <p> {ckoName}</p >
                   </div>
                   <div className="adress">{regionName}</div>
               </div>
               <div className="nav-bar">
                   <ul className="bar clearFix">
                       <li className={this.state.active === 1 ? ' current' : ''}><a href=" " onClick={this.fetchZhuanLiList}>技术专利</a ><div></div></li>
                       <li className={this.state.active === 2 ? 'current' : ''} onClick={this.fetchTuWenList}><a href="javascript:;">图文知识</a ><div></div></li>
                       <li className={this.state.active === 3 ? 'current last' : 'last'} onClick={this.fetchShiPingList}><a href="javascript:;">视频</a ><div></div></li>
                   </ul>
               </div>
                <div className=''>
                     {
                        this.state.zhuanli_list.length === 0
                            ?this.state.active ===1?<div className="con-hava">暂时没有相关专利...</div>:""
                            : this.state.active !==1?"":this.state.zhuanli_list.map((item, key) => {
                                return (
                                    <div
                                        className="con-wrap"
                                        key={key}
                                        onClick={e => this.props.history.push(`/product/broker/${item.productStyle}/${item.productId}`)}
                                    >
                                        <h2>{item.productTitle}</h2>
                                         <hr/>
                                         <div className="con-descript clearFix">
                                             <p className="name">{item.productAuthorName}</p >
                                             <p>{item.productDesc}</p >
                                             <span>购买</span>
                                         </div>
                                         <hr/>
                                         <div className="money clearFix">
                                             <span>购买人数：{item.orderNum ? item.orderNum : 0} 人</span>
                                             <i>¥<b>{item.productPrice}</b></i>
                                         </div>
                                    </div>
                                )
                            })
                    }

                     {
                     this.state.tuwen_list.length === 0
                         ? this.state.active ===2?<div className="con-hava">暂时没有相关图文...</div>:""
                         :  this.state.active !==2?"":this.state.tuwen_list.map((item, key) => {
                             return (
                                 <div
                                     className="con-wrap"
                                     key={key}
                                     onClick={e => this.props.history.push(`/product/broker/${item.productStyle}/${item.productId}`)}
                                 >
                                     <h2>{item.productTitle}</h2>
                                      <hr/>
                                      <div className="con-descript clearFix">
                                          <p className="name">{item.productAuthorName}</p >
                                          <p>{item.productDesc}</p >
                                          <span>购买</span>
                                      </div>
                                      <hr/>
                                      <div className="money clearFix">
                                          <span>购买人数：{item.orderNum ? item.orderNum : 0} 人</span>
                                          <i>¥<b>{item.productPrice}</b></i>
                                      </div>
                                 </div>
                             )
                         })
                      }
                     {
                        this.state.shipin_list.length === 0
                            ? this.state.active ===3?<div className="con-hava">暂时没有相关视频...</div>:""
                            :  this.state.active !==3?"":this.state.shipin_list.map((item, key) => {
                                return (
                                    <div
                                        className="con-wrap"
                                        key={key}
                                       onClick={e => this.props.history.push(`/product/broker/${item.productStyle}/${item.productId}`)}
                                    >
                                        <h2>{item.productTitle}</h2>
                                         <hr/>
                                         <div className="con-descript clearFix">
                                             <p className="name">{item.productAuthorName}</p >
                                             <p>{item.productDesc}</p >
                                             <span>购买</span>
                                         </div>
                                         <hr/>
                                         <div className="money clearFix">
                                             <span>购买人数：{item.orderNum ? item.orderNum : 0} 人</span>
                                             <i>¥<b>{item.productPrice}</b></i>
                                         </div>
                                    </div>
                                )
                            })
                        }
               </div>
           </div>
       </div>
        )
    }
}