/**
 * @author  wackeCq
 * @file    这是联系客服的界面
 * @date 17/9/29 下午9:22
 */

import React from 'react';
import BackHeader from 'backHeader/backHeader';
import {WhiteSpace} from 'antd-mobile';

export default class QuestionDaJiang extends React.Component {
    handleSave() {
    };
    render() {
        return (
            <div className="service_center">
                <BackHeader title="常见问题" path="/system_setting"/>
                <WhiteSpace size="lg"/>
                <div className="service_container">
                    <span className="iconfont">&#xe6f9;</span>
                    <span className="propsName">邮箱：</span>
                    <span className="propsService">service@dajiang.com</span>
                </div>
                <div className="service_container">
                    <span className="iconfont">&#xe6f9;</span>
                    <span className="propsName">联系客服</span>
                    <span className="propsService">010-12345678</span>
                </div>
            </div>
        );
    };
}
