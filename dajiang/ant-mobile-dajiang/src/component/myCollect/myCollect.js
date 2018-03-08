/**
 * @author wackeCq
 * @file 这是收藏的界面
 * @date 17/9/23 下午4:32
 */
import React from 'react';
import BackHeader from 'backHeader/backHeader';
import Fetch from 'fetch';
import {Toast, Modal} from 'antd-mobile';
import ListCollect from './listCollect/listCollect'
// import TextInput from 'formItem/textInput/textInput';
import {WhiteSpace} from 'antd-mobile';
import {List} from 'antd-mobile';
const Item = List.Item;
const Brief = Item.Brief;
import AlloyFinger from 'AlloyFinger/AlloyFinger'
const alert = Modal.alert;

/**
 * @description    默认的开始的提示
 * @param       defaultActiveKey    当前的heander的名字
 * @param       0 代表用户协议服务协议  1政府信息公告  2其他信息
 * @param       实例 agreement/1
 */

export default class Collect extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            initCollection: []
        };
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
            this.props.history.push(`da_jiang_detail/${id}`);
        }
    }
    componentDidMount() {
        var that = this;
        let data = {}
        Fetch.post('private/user/initCollection').then(res => {
            if (res.flag == "1") {
                this.setState({initCollection: res.data})
            } else {
                Toast.fail(res.message, 1.5);
            }

        })
    }
    render() {
        return (
            <div>
                <BackHeader title="我的收藏" path="/index/my"/>
                <div>
                    {this.state.initCollection.map((item, key) => {
                        return (
                            <div key={key} className="alloy">
                                <AlloyFinger key={key} onLongTap={this.onLongTap.bind(this, key)} onTap={() => {
                                    this.onTap(item.professionalId);
                                }}>
                                    <div>
                                        <ListCollect url={item.userPhotoPath} name={item.professionalName} job={item.professionalPosition}/>
                                    </div>
                                </AlloyFinger>
                            </div>
                        )
                    })
}
                </div>
            </div>
        );
    };
}
