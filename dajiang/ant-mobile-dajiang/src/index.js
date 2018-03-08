/**
 * @author v_duantao
 * @file
 * @date 17/9/18 下午3:04
 */

import React, {Component} from 'react';

import ReactDOM from 'react-dom';

import {
    HashRouter as Router,
    Route
} from 'react-router-dom';


import RenderRoute from './route';
import Fetch from './common/fetch';


((function (doc, win) {
    var docEle = doc.documentElement,
        evt = "onorientationchange" in window ? "orientationchange" : "resize",
        fn = function () {
            // 414 是设计稿 iPhone 6 Plus 的宽度。。。实际需要的时候，需要把 414 换成真实设计稿的宽度
            // docEle.style.fontSize = (100 / 414) + "vw";
            var width = docEle.clientWidth;
            width && (docEle.style.fontSize = (width / 6.4) + "px");
            // 于是以后的所有的长度，都直接使用设计稿里的长度的数字，但是把单位换成 rem。。。不用程序员去换算百分比
        };
    win.addEventListener(evt, fn, false);
    doc.addEventListener("DOMContentLoaded", fn, false);
})(document, window));
window.LOGIN_STATUS = 'N';


// 样式引入顺序不能错,  先引入 antd-mobile 的样式, 在引入 自己写的样式
import 'antd-mobile/dist/antd-mobile.css';   // antd-mobile 自己的样式

import './style/wacke';  // wackeCq


import 'antd-mobile/lib/icon/style/index.css';
import 'style/common.less';  // 自己重写的样式
import getDictionaryList from 'utils/getDictionaryList';

getDictionaryList();

window.addEventListener('hashchange', function (newURL, oldURL) {
    if (newURL === oldURL) {
        window.ISRELOAD = false;
    } else {
        window.ISRELOAD = true;
    }
});

Fetch.get('public/qiniu/queryDomain').then(res => {
    window.DOMAIN = res.domain;
})


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isRender: false
        }
    }

    componentWillMount() {
        let that = this;
        Fetch.post('isLogin', {}).then(res => {

            let data = res.data;
            if (res.flag === 1) {
                window.LOGIN_STATUS = data.loginStatus;
                window.USER = data.dataMap.user;
            } else {
                that.props.history.push('/error');
            }

            if (window.LOGIN_STATUS === 'Y') {
                console.log('已登录');
            } else {
                console.log('未登录');
            }
            this.setState({
                isRender: true
            })

        })
    }

    render() {
        return (
            <div id="app_is_render">
                {
                    this.state.isRender ? <Router forceRefresh={false}>
                        <Route path='/' render={
                            props => (
                                <RenderRoute {...props}/>
                            )
                        }/>
                    </Router> : '正在跳转中...'
                }
            </div>
        )
    }
}

ReactDOM.render(
    <div>
        <App/>
    </div>,
    document.getElementById('app')
);

if (module.hot) {
    module.hot.accept();
}
