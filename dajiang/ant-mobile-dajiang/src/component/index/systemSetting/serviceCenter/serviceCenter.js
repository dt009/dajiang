
/**
 * @author  wackeCq
 * @file    这是联系客服的界面
 * @date 17/9/29 下午9:22
 */

import React from 'react';
import BackHeader  from 'backHeader/backHeader';
import './serviceCenter.less';
import {NoticeBar} from 'antd-mobile';

export default class  ServiceCenter  extends React.Component {
    handleSave(){
        alert("这里是修改密码的界面啊");
    };
    render() {
        return (
            <div className="service_center">
                <BackHeader
                    title="客服中心"
                    path="/system_setting"
                />
                <NoticeBar marqueeProps={{ loop: true, style: { padding: '0 7.5px' } }}>
                     温馨提示:工作时间：工作日08:00-22:00,给你带来的不便，敬请谅解。谢谢;
                </NoticeBar>
                <div className="service_container">
                    <span className="iconfont">&#xe6f9;</span>
                    <span className="propsName">邮箱：</span>
                    <span className="propsService">service@dajiangzaixian.com</span>
                </div>
                <div className="service_container">
                    <span className="iconfont">&#xe6f9;</span>
                    <span className="propsName">联系客服</span>
                    <span className="propsService">010-57389853</span>
                </div>
                <div className="service_container">
                    <span className="iconfont">&#xe6f9;</span>
                    <span className="propsName">手机：</span>
                    <span className="propsService">15901097953</span>
                </div>
            </div>
        );
    };
}
