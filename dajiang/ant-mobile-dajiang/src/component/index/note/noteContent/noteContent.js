/**
 * @author v_duantao
 * @file 消息详情页
 * @date 17/10/12 下午8:10
 */


import React, {Component} from 'react';

import './noteContent.less';
import {WhiteSpace} from 'antd-mobile';
import ReactPullLoad,{ STATS } from 'react-pullload';

import Fetch from 'fetch';
import BackHeader from 'backHeader/backHeader';

class SendUserNoteItem extends Component {
    render() {
        let { messageContent, icon } = this.props;
        
        return (
            <div className="list_send_note_item">
                <div className="item_img">
                    <img src={icon ? icon : "../images/logo.png"} alt=""/>
                </div>
                <div className="item_content">
                    {messageContent}
                </div>
            </div>
        )
    }
}

class UserSelfNoteItem extends Component {
    render() {
        let { messageContent, icon } = this.props;
        return (
            <div className="list_user_note_item">
                <div className="item_content">
                    {messageContent}
                </div>
                <div className="item_img">
                    <img src={icon ? icon : "../images/logo.png"} alt=""/>
                </div>
            </div>
        )
    }
}


export default class NoteContent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            myScroll: '',
            newNews: '', // 新的消息
            data: [], // 消息列表 
            action: STATS.init,   // 初始值实际上是一个空字符串
            hasMore: true,
            myId: '',
            myIcon: '',
            otherIcon: '',
            dom: null,
            messageMinId: 0,   // 记录当前消息中的最小消息id值，用于上翻时作为上翻起点标识
            if_send: true   // 是否可以发送消息 
        };
    }

    componentWillMount() {
        const { productId, otherId } = this.props.match.params;
        Fetch.post('private/message/queryCurrentMessages', { productId, otherId }).then(res => {
            if(!res.data) { return; }
            this.setState({
                data: res.data.list,
                myId: res.data.myId,
                myIcon: res.data.myIcon,
                otherIcon: res.data.otherIcon,
                messageMinId: res.data.messageMaxId - 9
            });
            this.state.dom ? this.state.dom.scrollTop = this.state.dom.scrollHeight : null;
        });
    }

    componentDidMount() {
        let props = this.props;
        let dom = document.querySelector('#note_content_list_top');
        this.setState({ dom });
    }

    getNewNewsValue = (e) => {
        let value = e.target.value;
        this.setState({
            newNews: value.trim()
        });
    }

    handleAddNewNote = () => {
        // 输入为空
        const { productId, otherId } = this.props.match.params;
        const { newNews } = this.state;
        if (!newNews ) { return; }
        if (!this.state.if_send) { return false; }
        this.setState({ if_send: false });
        Fetch.post('private/message/addTradeMessage', { productId, otherId, messageContent: newNews }).then(res => {
            this.setState({ if_send: true });
            if (!res.data) { return; }
            if (res.flag === 1 ) {
                this.state.data.push({
                    fromFlag: 1,
                    messageContent: newNews,
                    messageId: '',
                    messageSendDT: Date.now(),
                    myId: 1,
                    otherId
                })
                this.setState({
                    data: this.state.data,
                    newNews: ''
                });
                this.state.dom ? this.state.dom.scrollTop = this.state.dom.scrollHeight : null;
            }
        });
    }

    handleAction = (action) => {
        // console.info(action, this.state.action,action === this.state.action);
        // //new action must do not equel to old action
        if (action === this.state.action) {
          return false
        }
    
        if (action === STATS.refreshing) {//刷新
          this.handRefreshing();
        } else if (action === STATS.loading) {//加载更多
          this.handLoadMore();
        } else {
          //DO NOT modify below code
          this.setState({
            action: action
          })
        }
    }
    
    handRefreshing = () => {
        // 查看原先消息
        if (STATS.refreshing === this.state.action) {
          return false
        }
        //无更多内容则不执行后面逻辑
        if (!this.state.hasMore) {
            return;
        }
        // setTimeout(()=>{
        //   //refreshing complete
        //   this.setState({
        //     hasMore: true,
        //     action: STATS.refreshed
        //   });
        // }, 2000)
        
        const { productId, otherId } = this.props.match.params;
        Fetch.post('private/message/queryPrevMessages', { productId, otherId, messageMinId: this.state.messageMinId  }).then(res => {
            if (!res.data) { return; }
            if (res.flag === 1 ) {
                if ( res.data.list.length < 1 ){
                    // 没有新消息
                    setTimeout(() => {
                        this.setState({
                            hasMore: true,
                            action: STATS.refreshed
                        });}, 1000);
                } else {
                    setTimeout(() => {
                        this.setState({
                            data: res.data.list.concat(this.state.data),
                            messageMinId: res.data.messageMaxId - 9,
                            hasMore: true,
                            action: STATS.refreshed
                        });
                    }, 1000);
                }
            }
        });
    
        this.setState({
          action: STATS.refreshing
        })
    }
    
      handLoadMore = () => {
        //   刷新消息
        if (STATS.loading === this.state.action) {
            return false
        }
        if (this.loading_state) { return false; } 
        this.loading_state = true;
        //无更多内容则不执行后面逻辑
        if (!this.state.hasMore) {
            return;
        }
    
        const { productId, otherId } = this.props.match.params;
        Fetch.post('private/message/queryNextMessages', { productId, otherId }).then(res => {
            setTimeout(() => {this.loading_state = false;}, 2000);
            if (!res.data) { return; }
            if (res.flag === 1 ) {
                if ( res.data.list.length < 1 ){
                    // 没有新消息
                    setTimeout(() => {
                        this.setState({
                            hasMore: true,
                            action: STATS.reset
                        });
                    }, 1000);
                } else {
                    setTimeout(() => {
                        this.setState({
                            data: this.state.data.concat(res.data.list),
                            hasMore: true,
                            action: STATS.reset
                        });}, 1000);
                }
                this.state.dom ? this.state.dom.scrollTop = this.state.dom.scrollHeight : null;
            }
        });
    
        this.setState({
          action: STATS.loading
        })
      }

    render() {
        const { hasMore, data, myIcon, otherIcon, action } = this.state;
        return (
            <div className="note_content">
                <BackHeader path="/index/note" title="消息通知"/>
                <div id="wrapper" className="content_flex">
                
                    <ReactPullLoad 
                        id="note_content_list_top"
                        style={{position: 'absolute', height: '100%', width: '100%'}}
                        isBlockContainer={true}
                        downEnough={100}
                        distanceBottom={100}
                        action={action}
                        handleAction={this.handleAction.bind(this)}
                        hasMore={hasMore}
                        distanceBottom={1000}>
                            <div className="content_list">
                            {
                                data.map((item, key) => {
                                    return (
                                        item.fromFlag !== 1 ?
                                            <SendUserNoteItem
                                                messageContent={item.messageContent}
                                                icon={otherIcon}
                                                key={key}
                                            /> :
                                            <UserSelfNoteItem
                                                messageContent={item.messageContent}
                                                icon={myIcon}
                                                key={key}
                                            />
                                    )
                                })
                            }
                        </div>
                        
                    </ReactPullLoad>
                </div>
                <WhiteSpace size="sm"/>
                <div className="content_message_send">
                    <div className="send_input">
                        <input type="text" value={this.state.newNews} onChange={this.getNewNewsValue}/>
                    </div>
                    <div className="send_submit" onClick={this.handleAddNewNote}>发送</div>
                </div>
            </div>
        )
    }
}
