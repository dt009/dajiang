/**
 * @author v_duantao
 * @file
 * @date 17/9/18 下午5:17
 */

import React, {Component} from 'react';

import {NavLink} from 'react-router-dom';

import {Badge} from 'antd-mobile';

import Fetch from 'fetch';
import './index.less';


export default class Index extends Component {
    constructor(props) {
        super(props);
        this.state = {
            noteNumber: 0,
        }
    }

    componentDidMount() {
        let that = this;

        // 先查询一次
        Fetch.post('private/user/waitMessageTotal').then(res => {
            if (res.flag === 1) {
                that.setState({
                    noteNumber: res.data
                })
            }
        });
        // 轮询5分钟查询一次
        window.TIMER = setInterval(() => {
            Fetch.post('private/user/waitMessageTotal').then(res => {
                if (res.flag === 1) {
                    that.setState({
                        noteNumber: res.data
                    })
                }
            })
        }, 300000);
    }

    componentWillUnmount() {
        clearInterval(window.TIMER);
        window.TIMER = null;
    }

    render() {
        return (
            <div className="index_footer">
                <NavLink to="/index/home" className="footer_tabs">
                    <span className="tabs_icon"></span>
                    <span className="tabs_title">主页</span>
                </NavLink>
                <NavLink to="/index/myshop/0" className="footer_tabs">
                    <span className="tabs_icon"></span>
                    <span className="tabs_title">店铺</span>
                </NavLink>
                <NavLink to="/index/search/0" className="footer_tabs">
                    <span className="tabs_icon"></span>
                </NavLink>
                <NavLink to="/index/note" className="footer_tabs">
                    {
                        this.state.noteNumber !== 0
                            ? <Badge className="tabs_badge" text={this.state.noteNumber}/>
                            : null
                    }
                    <span className="tabs_icon"></span>
                    <span className="tabs_title">消息</span>
                </NavLink>
                <NavLink to="/index/my" className="footer_tabs">
                    <span className="tabs_icon"></span>
                    <span className="tabs_title">我的</span>
                </NavLink>
            </div>
        )
    }
}
