/**
 * @author v_duantao
 * @file
 * @date 17/9/18 下午5:22
 */

import React, {Component} from 'react';

import {
    Route
} from 'react-router-dom';

import Fetch from 'fetch';

import {Modal} from 'antd-mobile';

import Index from './component/index/index';  // 主页下的 tab 选项
import Home from './component/index/home/home'; // 主页

import Note from './component/index/note/note'; // 消息页
import NoteContent from './component/index/note/noteContent/noteContent';  // 消息详情页

import My from './component/index/my/my';  // 我的 页
import Login from './component/login/login'; // 登录页

import Register from './component/register/register'; // 注册页

import Error from "./component/error/error";  // 错误页
import MyShop from "./component/index/myShop/myShop"; // 我的店铺
import Search from "./component/index/search/search"; // 搜索页
import ChangeData from './component/changeInfo/changInfo';  // 修改基本资料的页面

import CreateDaJiang from './component/daJiang/createDaJiang/createDaJiang';  // 成为大匠的页面
import ChangeDaJiangInfo from './component/daJiang/changeDaJiangInfo/changeDaJiang'; // 修改大匠资料页面
import CreateBroker from './component/broker/createBroker/createBroker'; // 成为知识经纪人的页面

import ChangeBroker from './component/broker/changeBrokerInfo/changeBroker';  // 修改知识经济人的页面
import BrokerDetail from './component/broker/brokerDetail/brokerDetail';    //知识经济人详情页

import ShoppingCart from './component/shoppingCart/shoppingCart';  // 我的购物车页面

import MyCollect from './component/myCollect/myCollect'; // 我的收藏页面

import MyKnowledge from './component/myKnowledge/myKnowledge'; // 我的知识页面

import Setting from './component/index/systemSetting/setting'; // 设置页面

import MyAccount from './component/myAccount/myAccount';  // 我的账户页面
import Withdraw from './component/myAccount/withdraw/withdraw';  // 提现页面

import BecomeComponent from './component/become_component/become_component';//测试demo制定页面

import Feedback from './component/index/systemSetting/feedback/feedback';//这是反馈界面
import ChangePassword from './component/index/systemSetting/change_password/change_password';//修改密码
import ServiceCenter  from './component/index/systemSetting/serviceCenter/serviceCenter';//联系客服
import About  from './component/index/systemSetting/About/About';//关于我们
// import QuestionDaJiang  from './component/index/systemSetting/question/question';//常见问题
import Agreement from './component/agreement/agreement';//协议的部分
import DaJiangDetail from './component/daJiang/daJiangDetails/daJiangDetail';  // 大匠详情页
import GoodsDetail from './component/goodsDetail/goodsDetail'; // 商品详情页
import AccountSetting from './component/index/systemSetting/accountSetting/accountSetting';//账户设置的页面
// import NoPutaway from './component/index/myShop/noPutaway/noPutaway'
import Putaway from './component/putaway/putaway'
import KnowledgeVideo  from './component/knowledge_video/knowledge_video'
import KnowledgeImage  from './component/knowledge_image/knowledge_image'
import KnowledgePatents  from './component/knowledge_patents/knowledge_patents'
import Accessory from './component/accessory/accessory'
import Publish from './component/publish/publish';
import PatentType from './component/patent_technology/patent_technology';

import NotPutaway from './component/not_putaway/not_putaway';
import PatentVideo from './component/patent_video/patent_video';
import PatentImage from './component/patent_image/patent_image'
import Invoice from './component/invoice/invoice';  // 发票
import Recharge from './component/myAccount/recharge/recharge';     // 充值页面
import CloseAnAccount from './component/closeAnAccount/closeAnAccount';     // 结算页面


//ChangePassword




export default class RenderRoute extends Component {
    componentDidMount() {
        let pathName = this.props.location.pathname;

        if (pathName === '/' || pathName === '/index') {
            this.props.history.push('/index/home');
        } else {
            this.props.history.push(pathName);
        }
    }

    render() {
        let alert = Modal.alert;
        return (
            <div id="router">
                <Route path="/index/home" render={
                    props => (
                        <Home {...props}/>
                    )
                }/>
                <Route path="/index/myshop/:id" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            // 判断权限
                            setTimeout(() => {
                                if(window.USER.userType === 0 || window.USER.userType === 1) {
                                    alert('提示', '亲爱的用户,您暂时还没有权限, 请联系客服', [
                                        {text: '确定', onPress: () => props.history.replace('/index/home') }
                                    ])
                                }
                            }, 0);
                            return (
                                <MyShop {...props}/>
                            )
                        } else {
                            props.history.replace('/login');
                        }
                    }
                } />

                {/* <Route path="/index/myshop/message/1" render={
                    props => (
                        <NoPutaway {...props}/>
                    )
                }/> */}
                <Route path="/Putaway/:productId" render={
                    props => (
                        <Putaway {...props}/>
                    )
                }/>
                <Route path="/index/search/:searchType" render={
                    props => (
                        <Search {...props}/>
                    )
                }/>
                <Route exact path="/index/my" render={
                    props => (<My {...props}/>)
                    // {
                    //     if (window.LOGIN_STATUS === 'Y') {
                    //         return <My {...props}/>
                    //     } else {
                    //         props.history.replace('/login');
                    //     }
                    // }
                }/>
                <Route path="/index/note" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <Note {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/publish" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <Publish {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                {/* Accessory */}
                <Route path="/accessory/:path" render={
                    props => {
                        // if (window.LOGIN_STATUS === 'Y') {
                        //     return <Accessory {...props}/>
                        // } else {
                        //     props.history.replace('/login')
                        // }
                        return <Accessory {...props}/>
                    }
                }/>

                <Route path="/note_content/:productId/:otherId"  render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <NoteContent {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/login" render={
                    props => (
                        <Login {...props}/>
                    )
                }/>
                <Route path="/register/:forget" render={
                    props => (
                        <Register {...props}/>
                        )
                    }/>
                <Route path="/error" render={
                    props => (
                        <Error {...props}/>
                    )
                }/>
                <Route path="/patent/:productId/:isSj/:productStyle" render={
                    props => (
                        <PatentType {...props}/>
                    )
                }/>
                <Route path="/Patentvideo/:productId/:isSj/:productStyle" render={
                    props => (
                        <PatentVideo {...props}/>
                    )
                }/>
                <Route path="/patentimage/:productId/:isSj/:productStyle" render={
                    props => (
                        <PatentImage {...props}/>
                    )
                }/>
                <Route path="/notputaway/:productId/:isSj/:productStyle" render={
                    props => (
                        <NotPutaway {...props}/>
                    )
                }/>
                <Route path="/change_info" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <ChangeData {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                {/* Knowledge */}
                <Route path="/knowledge_video" render={
                    props => (
                        <KnowledgeVideo {...props}/>
                    )
                }/>
                {/* Knowledge */}
                <Route path="/knowledge_image" render={
                    props => (
                        <KnowledgeImage {...props}/>
                    )
                }/>
                {/* Knowledge */}
                <Route path="/knowledge_patents" render={
                    props => (
                        <KnowledgePatents {...props}/>
                    )
                }/>
                <Route path="/create_da_jiang" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {

                            // 判断是否提交过审核
                            Fetch.post('private/user/initBeProfess').then(res => {
                                let data = res.data;
                                if (data) {
                                    let alert = Modal.alert;
                                    return alert('提示', '已经提交过审核请耐心等待', [
                                        {text: '确定', onPress: () => props.history.replace('/index/my') }
                                    ]);
                                }
                            });
                            return (
                                <CreateDaJiang {...props}/>
                            )
                        } else {
                            props.history.push('/login');
                        }
                    }
                }/>
                <Route path="/change_da_jiang_info" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <ChangeDaJiangInfo {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/create_broker" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            Fetch.post('private/user/initBeCKO').then(res => {
                                let data = res.data;
                                if (data) {
                                    let alert = Modal.alert;
                                    return alert('提示', '已经提交过审核请耐心等待', [
                                        {text: '确定', onPress: () => props.history.replace('/index/my') }
                                    ]);
                                }
                            });
                            return (
                                <CreateBroker {...props}/>
                            )
                        } else {
                            props.history.push('/login');
                        }

                    }
                }/>
                <Route path="/change_broker_info" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <ChangeBroker {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                {/* 知识经济人详情 */}
                <Route path="/broker_detail/:cko_key" render={
                    props => (
                        <BrokerDetail {...props}/>
                    )
                }/>
                {/* Invoice 发票 */}
                <Route path="/invoice" render={
                    props => (
                        <Invoice {...props}/>
                    )
                }/>
                {/* Recharge 充值 */}
                <Route path="/recharge" render={
                    props => (
                        <Recharge {...props}/>
                    )
                }/>
                {/* CloseAnAccount 结算台  type:  1 专利  2 图文   3 视频 */}
                <Route path="/close_an_account/:productId/:type" render={
                    props => (
                        <CloseAnAccount {...props}/>
                    )
                }/>
                <Route path="/shopping_cart" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <ShoppingCart {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/my_collect" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <MyCollect {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/my_knowledge" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <MyKnowledge {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/system_setting" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <Setting {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                {/* About */}
                <Route path="/about" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <About {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                {/* AccountSetting */}
                <Route path="/account_setting" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <AccountSetting {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/my_account" render={
                    props => {
                        if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                            return <MyAccount {...props}/>
                        } else {
                            props.history.replace('/login')
                        }
                    }
                }/>
                <Route path="/withdraw" render={
                    props => (<Withdraw {...props}/>)
                }/>
                {/* Agreement */}
                <Route path="/agreement/:id" render={
                    props => (
                        <Agreement {...props}/>
                    )
                }/>
                {/* <Route path="/question_da_jiang" render={
                    props => (
                        <QuestionDaJiang {...props}/>
                    )
                }/> */}
                {/* feedback */}
                {/* 这里是反馈页面 */}
                <Route path="/feedback" render={
                  props => (
                    <Feedback {...props} />
                  )
                }/>
                {/* 这里是修改密码 */}
                <Route path="/change_password" render={
                  props => {
                      if (window.LOGIN_STATUS && window.LOGIN_STATUS === 'Y') {
                          return <ChangePassword {...props}/>
                      } else {
                          props.history.replace('/login')
                      }
                  }
                }/>
                {/* 这里是联系客服的界面 */}
                    <Route path="/service_center" render={
                      props => (
                        <ServiceCenter {...props} />
                      )
                    }/>
                {/* 测试demo */}
                <Route path="/demo" render={
                    props => (
                        <BecomeComponent {...props}/>
                    )
                }/>
                <Route path="/da_jiang_detail/:professional_id" render={
                    props => (
                        <DaJiangDetail {...props}/>
                    )
                }/>
                <Route path="/goods_detail/:prodaustid/:type/:knowledgea/:isSj" render={
                    props => (
                        <GoodsDetail {...props}/>
                    )
                }/>

                {/*// 在最下边不要动*/}
                <Route path="/index" render={
                    props => (
                        <Index {...props}/>
                    )
                }/>

            </div>
        )
    }
}
