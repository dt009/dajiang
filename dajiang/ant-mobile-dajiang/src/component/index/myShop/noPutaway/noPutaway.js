/**
 * @author v_duantao
 * @file 我的店铺页面
 * @date 17/9/23 上午11:59
 */


import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import ListStore from '../listStore/listStore'


import Fetch from 'fetch';

export default class NoPutaway extends Component {
    render() {
        return (
            <div className="index_my_shop_putaway">
                <div className="shop_publish">
                    <div>
                        <NavLink to="/index/myshop/putaway" className="footer_tabs">
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">123</span>
                        </NavLink>
                        <NavLink to="/index/myshop/noPutaway" className="footer_tabs">
                            <span className="tabs_icon"></span>
                            <span className="tabs_title">234</span>
                        </NavLink>
                        <NavLink  to="/da_jiang_detail">
                            <ListStore
                                name={'段涛'}
                                occupation={'web前端工程师'}
                                sex={'男'}
                                age={26}
                                speciality={'计算机专业'}
                                undergo={'许多高水平职业棋手想必都有过这样的经历(Experience)：在 长时间思考一着棋或评价一个局面时，思维突然'}
                                seeNumber={1000}
                                imgSrc={'http://owu66z9w4.bkt.clouddn.com/o_1br179rk08p75av1c16kf7vuc1d.png'}
                            />
                        </NavLink>
                    </div>
                </div>
            </div>
        )
    }
}
