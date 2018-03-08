/**
 * @author wackeCq a
 * @file 协议
 * @date 17/9/23 下午4:32
 */
import React from 'react';
import {Accordion, List} from 'antd-mobile';
import './agreement.less';
import BackHeader from 'backHeader/backHeader';


/**
 * @description    默认的开始的提示
 * @param       defaultActiveKey    当前的heander的名字
 * @param       0 代表用户协议服务协议  1政府信息公告  2其他信息
 * @param       实例 agreement/1
 */

export default class Agreement extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    onChange(key) {
        console.log(key)
    };
    render() {
        let pathname = this.props.location.pathname;
        let id = pathname.substring(pathname.length - 1);
        const path = this.props.location.search ? this.props.location.search.match(/path=(\S*)/)[1] : 'about'
        return (
            <div>
                <BackHeader
                    path = {`/${path}`}
                    title="规则中心"
                />
                <div className="component_init">
                    <Accordion accordion openAnimation={{}} defaultActiveKey={id} className="my-accordion" onChange={this.onChange}>
                        <Accordion.Panel header="用户协议服务协议">
                            <div className="container">
                                1.1 本《饿了么网上订餐平台服务协议》（以下简称本协议）为您（即商户）与上海拉扎斯信息科技有限公司（以下简称饿了么）就饿了么网上订餐服务达成的协议。饿了么在此特别提醒您认真阅读、充分理解本协议。商户应认真阅读、充分理解本协议中各条款，特别涉及免除或者限制饿了么责任的免责条款，对商户的权利限制的条款，法律适用、争议解决方式的条款。
                            </div>
                        </Accordion.Panel>
                        <Accordion.Panel header="大匠软件许可及服务协议" className="pad">
                            <div className="container">
                                1.2 请您审慎阅读并选择同意或不同意本协议，除非您接受本协议所有条款，否则您无权使用本协议项下相关服务。您的申请、使用、帐号获取和登录等行为表明您自愿接受本协议的全部内容并受其约束，不得以任何理由包括但不限于未能认真阅读本协议等作为纠纷抗辩理由。
                            </div>
                        </Accordion.Panel>
                        <Accordion.Panel header="大匠隐私政策" className="pad">
                            <div className="container">
                                1.3 本协议可由饿了么随时更新，更新后的协议条款一旦公布即代替原来的协议条款，不再另行个别通知。您可在网站查阅最新版协议条款。在饿了么修改本协议条款后，如果您不接受修改后的条款，请立即停止使用饿了么提供的服务，您继续使用饿了么提供的服务将被视为已接受了修改后的协议。
                            </div>
                        </Accordion.Panel>
                    </Accordion>
                </div>
            </div>
        )
    }
}
