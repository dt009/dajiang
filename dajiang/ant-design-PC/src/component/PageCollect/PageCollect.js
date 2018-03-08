/**
 * @author wackeCq
 * @file 我的收藏
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import './PageCollect.less';
import Fetch from '../../common/Fetch/Fetch';
import ListCollect from './children/collect'
import './children/collect.less'
import { message, Button } from 'antd'
import AlloyFinger from './AlloyFinger'


/**
 * @description  我的收藏页面
 * @param       defaultActiveKey    当前的heander的名字
 * @param       0 代表用户协议服务协议  1政府信息公告  2其他信息
 * @param       实例 agreement/1
 */

export default class PageCollect extends Component {
    constructor(props){
       super(props);
       this.state = {
           initCollection:[]
       } 
    }

    onLongTap(e) {
        alert('', '确定删除么???', [
            {
                text: '确定',
                onPress: () => {
                    Fetch.post('private/user/deleteCollection/' + this.state.initCollection[e].professionalId).then(res => {
                        if (res.flag == 1) {
                            this.componentDidMount()

                        }
                    })
                }
            }, {
                text: '取消',
                onPress: () => console.log('cancel')
            }
        ])

    }

    onTap = (id) => {
        if (id) {
            this.props.history.push(`/professional/${id}`);
        }
    }
    alloy = (id) => {
        if (id) {
            this.props.history.push(`/professional/${id}`);
        }
    }
    componentDidMount() {
        var that = this;
        let data = {}
        Fetch.post('private/user/initCollection').then(res => {
            if (res.flag == "1") {
                this.setState({ initCollection: res.data })
            } else {
                message.error(res.message,1.5);
            }

        })
    }
    render() {
        // console.log(this.state.initCollection)
        return (
            <div className='page_collect'>
                {/* 我的收藏页面.... */}
                {this.state.initCollection.map((item, key) => {
                    return (
                        <div key={key} className="alloy" onClick={() => this.alloy(item.professionalId)}>
                            <AlloyFinger key={key} onLongTap={this.onLongTap.bind(this, key)} onTap={() => {
                                this.onTap(item.professionalId);
                            }}>
                                <div>
                                    <ListCollect url={item.userPhotoPath} name={item.professionalName} job={item.professionalPosition} />
                                </div>
                            </AlloyFinger>
                        </div>
                    )
                })
                }
            </div>
        )
    }
}