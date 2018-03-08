/**
 * @author v_duantao
 * @file 项目的头尾布局
 * @date 2017/11/20
 */

import React, {Component} from 'react';

import {
    Route,
    NavLink,
    Switch,
    Redirect
} from 'react-router-dom';

import './PageLayout.less';
import PageHome from '../PageHome/PageHome'; // 主页
import PageNote from '../PageNote/PageNote'; // 消息页
import PageSearch from "../PageSearch/PageSearch"; // 搜索页
import PageMy from "../PageMy/PageMy"; // 登录注册页
import PageUser from "../PageUser/PageUser"; // 个人中心页
import PageAbout from "../PageAbout/PageAbout";// 关于我们
import PageQuestion from "../PageQuestion/PageQuestion"; // 问题反馈
import PageShop from "../PageShop/PageShop"; // 我的店铺
import PageError from "../PageError/PageError"; // 错误页面
import PageProduct from "../PageProduct/PageProduct"; // 商品详情页
import BrokerDetails from "../PageBroker/BrokerDetails/BrokerDetails"; // 知识经纪人详情页
import ProfessionalDetails from "../PageProfessional/ProfessionalDetails/ProfessionalDetails"; // 大匠详情页
import closeAnAccount from '../PageCloseAnAccount/closeAnAccount';  // 结算页
import PublishPatent from '../PagePublish/PublishPatent/PublishPatent'
import FileDetail from "../PageProduct/ProductImage/FileDetail/FileDetail"; // 文件可读页

export default class PageLayout extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isShowBackgroundImage: false,  // 是否显示背景图
        }
    }

    componentDidMount() {

    }

    setIsShowBackgroundImageValue = hash => {
        if (hash === '#/my/login' || hash === '#/my/register/0' || hash === '#/my/register/1') {
            this.setState({
                isShowBackgroundImage: true
            })
        } else {
            this.setState({
                isShowBackgroundImage: false
            })
        }
    };


    render() {
        return (
            <div className='page_layout'>
                <div className='page_header'>
                    <div className='header_top'></div>
                    <div className='header_content'>
                        <div className='logo_box'>
                            <NavLink className='logo' to="/home"></NavLink>
                        </div>
                        <ul className='nav_list'>
                            <li><NavLink to='/home'>首页</NavLink></li>
                            <li><NavLink to='/note'>消息</NavLink></li>
                            <li><NavLink to='/search'>查找</NavLink></li>
                            {
                                (window.USER && window.USER.userType === 0) || (window.USER && window.USER.userType === 1)
                                    ? <span></span>
                                    : <li><NavLink to='/shop'>店铺</NavLink></li>
                            }
                            {
                                window.LOGIN_STATUS === 'Y'
                                    ? <li><NavLink to='/user'>个人中心</NavLink></li>
                                    : <li><NavLink to='/my'>登录/注册</NavLink></li>
                            }
                        </ul>
                    </div>
                </div>
                <div className={
                    this.state.isShowBackgroundImage
                        ? 'page_content is_login'
                        : 'page_content'
                }>
                    <div className='content_cover'
                         style={{
                             background: this.state.isShowBackgroundImage
                                 ? 'rgba(0, 0, 0, 0.8)'
                                 : ''
                         }}
                    >
                        <div className='content_box clear'>
                            <Switch>
                                <Redirect exact from='/' to='/home'/>
                                <Redirect exact from='/search' to='/search/0'/>
                                <Redirect exact from='/shop' to='/shop/0'/>
                                <Route path='/home' render={
                                    props => (
                                        <PageHome {...props}/>
                                    )
                                }/>
                                <Route path='/note' render={
                                    props => (
                                        <PageNote {...props}/>
                                    )
                                }/>
                                <Route path='/search/:searchType' render={
                                    props => (
                                        <PageSearch {...props}/>
                                    )
                                }/>
                                <Route path='/my' render={
                                    props => (
                                        <PageMy
                                            {...props}
                                            getCurrentHash={hash => this.setIsShowBackgroundImageValue(hash)}
                                        />
                                    )
                                }/>
                                <Route path='/user' render={
                                    props => (
                                        <PageUser {...props}/>
                                    )
                                }/>
                                <Route path='/about' render={
                                    props => (
                                        <PageAbout {...props}/>
                                    )
                                }/>
                                <Route path='/question' render={
                                    props => (
                                        <PageQuestion {...props}/>
                                    )
                                }/>
                                {/* 0 上架 1 是未上架 */}
                                <Route path='/shop/:id' render={
                                    props => (
                                        <PageShop {...props}/>
                                    )
                                }/>
                                <Route path='/error' render={
                                    props => (
                                        <PageError {...props}/>
                                    )
                                }/>
                                {/* position: 进入的位置 productStyle: 产品类型  productId: 商品id */}
                                <Route path='/product/:position/:productStyle/:productId' render={
                                    props => (
                                        <PageProduct {...props}/>
                                    )
                                }/>
                               {/* 发布专利 */}
                                <Route path='/publish_patent' render={
                                    props => (
                                        <PublishPatent  {...props} />
                                    )
                                } />
                                {/* brokerId: 经纪人的Id标识或其他 */}
                                <Route path='/broker/:brokerId' render={
                                    props => (
                                        <BrokerDetails {...props}/>
                                    )
                                }/>
                                {/* professional_id: 大匠的Id标识或其他 */}
                                <Route path='/professional/:professional_id' render={
                                    props => (
                                        <ProfessionalDetails {...props}/>
                                    )
                                }/>
                                {/* CloseAnAccount 结算台  type:  1 专利  2 图文   3 视频 */}
                                <Route path='/close_an_account/:productId/:type' component={closeAnAccount} />

                                <Route path='/file_details/:path' render={
                                    props => (
                                        <FileDetail {...props}/>
                                    )
                                }/>

                            </Switch>
                        </div>
                    </div>
                </div>
                <div className='page_footer'>
                    <div className='footer_content'>
                        {/* HTML ====>>>>> 王思彤 */}
                        <div id="footcan">
                            <div className="foot-left">
                                <h2 className="linkbt">联系我们</h2>
                                <ul className="list">
                                    <li className="li1">咨询热线：400-820-0974</li>
                                    <li className="li2">E-mail：service@dajiangzaixian.com</li>
                                    <li className="li3">公司电话：010-57389853</li>
                                    <li className="li4">公司地址：北京朝阳区望京合生麒麟社1号楼1108室</li>                                    
                                </ul>
                            </div>
                            <div className="foot-center">
                                <h2 className="linkbt">大匠在线</h2>
                                  <div className="gywm"><NavLink to='/about'>关于我们</NavLink></div>
                                  <div className="jrwm"><a href="##">加入我们</a></div>
                            </div>
                            <div className="foot-center_2">
                                <h2 className="linkbt">使用说明</h2>
                                  <div className="tkfw"><a href="##">条款服务</a></div>
                                  <div className="sybz"><a href="##">使用帮助</a></div>
                                  <div className="wtfk"><NavLink to='/question'>问题反馈</NavLink></div>
                            </div>
                            <div className="foot-right">
                                <h2 className="linkbt">微信公众号</h2>
                                  <div className='ewm_box'>
                                    <NavLink className='ewm' to="/home"></NavLink>
                                  </div>                  
                            </div>                            
                        </div>
                    </div>
                    <div className='footer_footer'>
                        北京大匠在线科技有限公司 版权所有 备案号：xxxxxxx dajiangzaixian.com &copy;
                    </div>
                </div>
            </div>
        )
    }
}