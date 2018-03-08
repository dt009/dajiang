/**
 * @author v_duantao
 * @file 消息页面
 * @date 2017/11/20
 */

import React, {Component} from 'react';
import { NavLink } from 'react-router-dom';
import Fetch from 'Fetch/Fetch';
import { Menu, Icon, Input } from 'antd';
const SubMenu = Menu.SubMenu;
const { TextArea } = Input;

import './PageNote.less';
import ImgUpload from '../../common/imgUpload/imgUpload';


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

export default class PageNote extends Component {

    state = {
        openKeys: [],
        list: [{
            productTitle: '哈哈哈哈11',
            productId: 111,
            list: [{
                productId: 2,
                otherId: 3,
                otherPhotoPath: 'http://owu66z9w4.bkt.clouddn.com/o_1bsan1g091b71bf6oed193l181ua.jpeg',
                otherNickName: '晓晓'
            }]
        },{
            productTitle: '哈哈哈哈222',
            productId: 122,
            list: [{
                productId: 2,
                otherId: 3,
                otherPhotoPath: 'http://owu66z9w4.bkt.clouddn.com/o_1bsan1g091b71bf6oed193l181ua.jpeg',
                otherNickName: '晓晓'
            }]
        },{
            productTitle: '哈哈哈哈333',
            productId: 133,
            list: [{
                productId: 2,
                otherId: 3,
                otherPhotoPath: 'http://owu66z9w4.bkt.clouddn.com/o_1bsan1g091b71bf6oed193l181ua.jpeg',
                otherNickName: '晓晓'
            }]
        }],
        key_list: ['111', '122', '133'],
        dialogue: {
            dia_list: [],
            myId: '',
            myIcon: '',
            otherIcon: '',
            messageMinId: 0
        },
        ipt_val: '',
        if_send: true,
        is_dialogue: false,  // 是否有对话
        productId: '',
        otherId: ''
    }

    onOpenChange = (openKeys) => {
        // 选择某一个商品 展开某一个列表
        let id = '';
        const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1);
        if (this.state.key_list.indexOf(latestOpenKey) === -1) {
            this.setState({ openKeys });
            id = openKeys[0];
        } else {
            this.setState({
                openKeys: latestOpenKey ? [latestOpenKey] : [],
            });
            id = latestOpenKey;
        }
        if (!id) {
            return;
        }
        let url = `private/message/querySender/${id}`;
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
            this.state.list.map(item => {
                if (item.productId == id) {
                    item.list = res.data;
                }
            });
            this.setState({
                list: this.state.list
            });
        });
    }

    selectDialogue = (productId, otherId) => {
        this.setState({
            productId,
            otherId
        })
        // 选择某一个对话
        Fetch.post('private/message/queryCurrentMessages', { productId, otherId }).then(res => {
            if(!res.data) { return; }
            this.setState({
                dialogue: {
                    dia_list: res.data.list,
                    myId: res.data.myId,
                    myIcon: res.data.myIcon,
                    otherIcon: res.data.otherIcon,
                    messageMinId: res.data.messageMaxId - 9
                },
                is_dialogue: true
            })
        });

    }

    // 发送消息
    sendMessage = () => {
        const { productId, otherId, ipt_val, if_send } = this.state;
        if (!ipt_val ) { return; }
        if (!if_send) { return false; }
        this.setState({ if_send: false });
        Fetch.post('private/message/addTradeMessage', { productId, otherId, messageContent: ipt_val }).then(res => {
            this.setState({ if_send: true });
            if (!res.data) { return; }
            if (res.flag === 1 ) {
                this.state.dialogue.dia_list.push({
                    fromFlag: 1,
                    messageContent: ipt_val,
                    messageId: '',
                    messageSendDT: Date.now(),
                    myId: 1,
                    otherId
                });
                this.setState({
                    dialogue: this.state.dialogue,
                    ipt_val: ''
                });
            }
        });
    }

    iptChange = e => {
        this.setState({ipt_val: e.target.value});
    }

    componentWillMount() {
        Fetch.post('private/message/initMessage', {}).then(res => {
            if (res.flag === 0) {
                return this.props.history.replace('my/login');
            }
            let arr = [];
            res.data.map(item => {
                item.list = [];
                arr.push(item.productId);
            });
            this.setState({
                list: res.data,
                key_list: arr
            });
        });
    }

    render() {
        const { list, is_dialogue, ipt_val, dialogue } = this.state;
        const { dia_list, myId, myIcon, otherIcon } = dialogue;
        return (
            <div className='page_note clearfix'>
                {/* 消息页面
                <NavLink to='/close_an_account/212/1'>/close_an_account/212/1</NavLink>
                <ImgUpload MyId='123' Width='400px' Height='300px' change={this.test} content="哈哈哈哈哈哈" Image="" disabled={true} Circle={true}/> */}
                <div className='page_node_left'>
                    <Menu
                    mode="inline"
                    openKeys={this.state.openKeys}
                    onOpenChange={this.onOpenChange}
                    style={{ width: 240 }}>
                        {list.map(item => {
                            return <SubMenu key={item.productId} title={<span>{item.productTitle}</span>}>
                                {item.list.map((list_item, key) => {
                                    return <Menu.Item key={key}>
                                        <div className='list_item clearfix' onClick={e => {this.selectDialogue(list_item.productId, list_item.otherId);}}>
                                            <img src={list_item.otherPhotoPath} alt=""/>
                                            {list_item.otherNickName}
                                        </div>
                                    </Menu.Item>
                                })}
                            </SubMenu>
                        })}
                        {/* <SubMenu key="sub1" title={<span><Icon type="mail" /><span>Navigation One Navigation One Navigation One</span></span>}>
                            
                            <Menu.Item key="2">Option 2</Menu.Item>
                            <Menu.Item key="3">Option 3</Menu.Item>
                            <Menu.Item key="4">Option 4</Menu.Item>
                        </SubMenu>
                        <SubMenu key="sub2" title={<span><Icon type="appstore" /><span>Navigation Two</span></span>}>
                            <Menu.Item key="5">Option 5</Menu.Item>
                            <Menu.Item key="6">Option 6</Menu.Item>
                        </SubMenu>
                        <SubMenu key="sub4" title={<span><Icon type="setting" /><span>Navigation Three</span></span>}>
                            <Menu.Item key="9">Option 9</Menu.Item>
                            <Menu.Item key="10">Option 10</Menu.Item>
                            <Menu.Item key="11">Option 11</Menu.Item>
                            <Menu.Item key="12">Option 12</Menu.Item>
                        </SubMenu> */}
                    </Menu>
                </div>
                <div className='page_node_right'>
                    {is_dialogue ? <div className='bezel'>
                        <div className='bezel_body'>
                            {dia_list.map((item, key) => {
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
                            })}
                        </div>
                        <div className='bezel_footer'>
                            <div className='bezel_footer_left'>
                                <TextArea rows={4} value={ipt_val} onChange={this.iptChange} placeholder='请输入聊天内容...'/>
                            </div>
                            <div className='bezel_footer_right' onClick={this.sendMessage}>发送</div>
                        </div>
                    </div> : <div className='text_center'>请选择会话...</div> }
                </div>
            </div>
        )
    }
}