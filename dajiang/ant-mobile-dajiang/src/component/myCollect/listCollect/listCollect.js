/**
 * @author wackeCq a
 * @file 这是账户设置的界面
 * @date 17/9/23 下午4:32
 */
import React from 'react';
import BackHeader from 'backHeader/backHeader';
import Fetch from 'fetch';
import {Toast} from 'antd-mobile';
import TextInput from 'formItem/textInput/textInput';
import {WhiteSpace} from 'antd-mobile';
import './listCollect.less';
import AlloyFinger from 'AlloyFinger/AlloyFinger';

/**
 * @description    默认的开始的提示
 * @param       defaultActiveKey    当前的heander的名字
 * @param       0 代表用户协议服务协议  1政府信息公告  2其他信息
 * @param       实例 agreement/1
 */

export default class ListCollect extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            direction: '',
            isShow: true
        }
    }
    handleSave(evt) {
        this.setState({isShow: false})
        evt.currentTarget.remove()
    }
    componentWillUnmount() {
        if (this.state.isShow == false) {
            this.setState({isShow: true})
        }
    }
    onLongTap(evt) {
        alert(evt);
    }
    render() {
        return (
            <div>

                <div className="listCollect_component_title">
                    <div className="listCollect_component">
                        <img src={this.props.url} alt="头像"/>
                        <span className="name">{this.props.name}</span>
                        <span className="job">{this.props.job}</span>
                        <span className="iconfont delete" style={{
                            display: this.state.direction
                        }} onClick={this.handleSave.bind(this)}>&#xe607;</span>
                    </div>
                    <WhiteSpace size="md"/>
                </div>
            </div>

        )
    }
}
