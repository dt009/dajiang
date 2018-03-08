/**
 * @author v_duantao
 * @file 入口文件
 * @date 2017/11/12
 */

import React, {Component} from 'react';

import ReactDOM from 'react-dom';

import moment from 'moment'

import 'moment/locale/zh-cn';
moment.locale('zh-cn');

import {
    HashRouter as Router,
    Route,
} from 'react-router-dom';
import Fetch from 'Fetch/Fetch';

window.addEventListener('hashchange', function (newURL, oldURL) {
    if (newURL === oldURL) {
        window.ISRELOAD = false;
    } else {
        window.ISRELOAD = true;
    }
});

import 'style/style.less';
import PageLayout from "./component/PageLayout/PageLayout";
import dictionaryList from './common/utils/Dictionary.js'
window.LIST=dictionaryList;

Fetch.get('public/qiniu/queryDomain').then(res => {
    window.DOMAIN = res.domain;
});


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
            <div id='page_index_first'>
                {
                    this.state.isRender
                        ? <Router forceRefresh={false}>
                            <Route path='/' render={
                                props => (
                                    <PageLayout {...props}/>
                                )
                            }/>
                        </Router>
                        : '正在跳转中...'
                }
            </div>
        )
    }
}


ReactDOM.render(
    <App/>,
    document.getElementById('app')
);


if (module.hot) {
    module.hot.accept();
}