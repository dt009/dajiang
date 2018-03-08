/**
 * @author wackeCq a
 * @file 这是账户设置的界面
 * @date 17/9/23 下午4:32
 */
import React from 'react';
// import './accountSetting.less';
import './become_component.less'
import BackHeader from 'backHeader/backHeader';
import {Link} from 'react-router-dom'
import {NavLink} from 'react-router-dom';
// import Collect from '/component/index/systemSetting/collect/collect'

/**
 * @description    默认的开始的提示
 * @param       defaultActiveKey    当前的heander的名字
 * @param       0 代表用户协议服务协议  1政府信息公告  2其他信息
 * @param       实例 agreement/1
 */

export default class BecomeComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    onChange(key) {
        console.log(key)
    };
    componentDidMount() {
        var option = {
            docId: "doc-hjvtf04rnj3y86q",
            token: "TOKEN",
            host: "BCEDOC",
            width: 600, // 文档容器宽度
            pn: 3, // 定位到第几页，可选
            ready: function(handler) { // 设置字体大小和颜色, 背景颜色（可设置白天黑夜模式）
                handler.setFontSize(1);
                handler.setBackgroundColor("#000");
                handler.setFontColor("#fff");
            },
            flip: function(data) { // 翻页时回调函数, 可供客户进行统计等
                console.log(data.pn);
            },
            fontSize: "big",
            toolbarConf: {
                page: true, // 上下翻页箭头图标
                pagenum: true, // 几分之几页
                full: false, // 是否显示全屏图标,点击后全屏
                copy: true, // 是否可以复制文档内容
                position: "center" // 设置 toolbar中翻页和放大图标的位置(值有left/center)
            } //文档顶部工具条配置对象,必选
        }
        new Document("reader", option);
    }
    render() {
        let pathname = this.props.location.pathname;
        let id = pathname.substring(pathname.length - 1);
        return (
            <div>
                <BackHeader path="/knowledge_image" title="附件"/>
                <div>
                    <div id="reader"></div>
                </div>
            </div>
        )
    }
}
