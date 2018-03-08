/**
 * @author v_duantao
 * @file    消息页面
 * @date 17/9/18 下午5:16
 */

import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';

import './note.less';

import {Badge} from 'antd-mobile';

import Fetch from 'fetch';

class NoteListItem extends Component {
    render() {
        let props = this.props;
        return (
            <div className="note_list_item">
                <NavLink to={props.path}>
                    <img src={props.sendUserPhotoPath} alt=""/>
                    <span>{props.sendUserNickName || '暂未设置名字' }</span>
                    <time>{props.sendDt}</time>
                </NavLink>
            </div>
        )
    }
}

class NoteGroupItem extends Component {
    constructor(props) {
        super(props);
        this.state = {
            noteListItemData: [],
            isShowListItem: false
        };
        this.handleAddNoteListItem = this.handleAddNoteListItem.bind(this);
    }

    componentDidMount() {

    }

    handleAddNoteListItem() {
        let state = this.state;
        let productId = this.props.productId;

        if (state.noteListItemData.length === 0) {
            let url = `private/message/querySender/${productId}`
            Fetch.post(url, {}).then(res => {
                if(!res.data) { return; }
                res.data.map((item) => {
                    let str = '';
                    if (item.sendDt) {
                        let date = new Date(item.sendDt);
                        str = date.getMonth() + 1 + '月' + (date.getDate()) + '日 ' + (date.getHours()) + ':' + (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() );
                    }
                    item.date = str;
                });
                this.setState({
                    noteListItemData: res.data,
                    isShowListItem: true
                });
            });
        } else {
            if (state.isShowListItem) {
                this.setState({
                    isShowListItem: false
                })
            } else {
                this.setState({
                    isShowListItem: true
                })
            }
        }

    }

    render() {
        let props = this.props;
        return (
            <div>
                <div className="note_group_item" onClick={this.handleAddNoteListItem}>
                    <Badge className="note_group_badge" text={props.waitCount}/>
                    {/* <img className="group_item_img" src="./images/logo.png" alt=""/> */}
                    <span className="group_item_title">{props.productTitle}</span>
                    <span className="group_item_icon">&#xe858;</span>
                </div>
                <div className="group_item_list">
                    {
                        this.state.isShowListItem ?
                            this.state.noteListItemData.map((item, key) => {
                                return (
                                    <NoteListItem
                                        key={key}
                                        sendUserPhotoPath={item.otherPhotoPath}
                                        sendUserNickName={item.otherNickName}
                                        sendDt={item.date}
                                        sendUserId={item.otherId}
                                        path={`/note_content/${item.productId}/${item.otherId}`}
                                    />
                                )
                            }) : ''
                    }
                </div>
            </div>
        )
    }
}

export default class Note extends Component {
    constructor(props) {
        super(props);
        this.state = {
            noteGroupData: [],
        }
    }

    componentWillMount() {
        Fetch.post('private/message/initMessage', {}).then(res => {
            this.setState({
                noteGroupData: res.data
            });

            // "productId": 1,   
            // "productTitle": '系统消息',
            // "waitCount": 3
        });
    }

    componentDidMount() {
        // this.setState({
        //     noteGroupData: [
        //         {
        //             "productId": 1,
        //             "productTitle": '系统消息',
        //             "waitCount": 3
        //         },
        //         {
        //             "productId": 2,
        //             "productTitle": '列表1',
        //             "waitCount": 4
        //         },
        //         {
        //             "productId": 3,
        //             "productTitle": '列表2',
        //             "waitCount": 6
        //         },
        //         {
        //             "productId": 1,
        //             "productTitle": '系统消息',
        //             "waitCount": 3
        //         },
        //         {
        //             "productId": 2,
        //             "productTitle": '列表1',
        //             "waitCount": 4
        //         },
        //         {
        //             "productId": 3,
        //             "productTitle": '列表2',
        //             "waitCount": 6
        //         }
        //     ]
        // })
    }

    render() {
        let state = this.state;
        return (
            <div className="index_note">
                <div className="note_list">
                    {
                        state.noteGroupData.map((item, key) => {
                            return (
                                <NoteGroupItem
                                    key={key}
                                    productTitle={item.productTitle}
                                    waitCount={item.waitCount}
                                    productId={item.productId}
                                />
                            )
                        })
                    }
                </div>
            </div>
        )
    }
}