/**
 * @author v_duantao
 * @file 文件阅读器
 * @date 2017/12/3
 */

import React, {Component} from 'react';
import './FileDetail.less'

export default class FileDetail extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    onChange(key) {
        console.log(key)
    };
    componentDidMount() {
        let path = this.props.match.params.path;
        let option = {
            docId: path,
            token: "TOKEN",
            host: "BCEDOC",
            serverHost: 'http://doc.bj.baidubce.com',
            width: 1080, // 文档容器宽度
            pn: 1, // 定位到第几页，可选
            ready: function(handler) { // 设置字体大小和颜色, 背景颜色（可设置白天黑夜模式）
                handler.setFontSize(1);
                handler.setBackgroundColor("#fff");
                handler.setFontColor("#000");
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
        };
        new Document("reader", option);
    }
    render() {
        let pathname = this.props.location.pathname;
        let id = pathname.substring(pathname.length - 1);
        return (
            <div>
                <div>
                    <div id="reader"></div>
                </div>
            </div>
        )
    }
}
