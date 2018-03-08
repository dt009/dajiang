/**
 * @author v_duantao
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */


import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import ListStore from '../listStore/listStore'
import './putaway.less'



import Fetch from 'fetch';

export default class Putaway extends Component {
    render() {
        return (
            <div className="putaway_componet">
                <div className="shop_publish">
                    <div>
                            {/* <ListStore
                                title={'建筑设计'}
                                pName={'段涛'}
                                introduce={'Grid-layout不是为了取代flex-layout，它是flex的补充。grid擅长二维布局，flex擅长一维布局。他们需要各司其职。'}
                                status={'审核中...'}
                                sum={50}
                                price={999}
                            /> */}

                    </div>
                </div>
            </div>
        )
    }
}
