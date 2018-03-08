/**
 * @author v_duantao
 * @file 错误页面
 * @date 2017/11/27
 */

import React, {Component} from 'react';
import './PageError.less';


export default class PageError extends Component {

    historyGo = () => {
        window.history.go(-1);
    };

    render() {
        return (
            <div className='page_error'>
                请求出错
                <a href="javascript;;" onClick={this.historyGo}>
                    返回...
                </a>
            </div>
        )
    }
}