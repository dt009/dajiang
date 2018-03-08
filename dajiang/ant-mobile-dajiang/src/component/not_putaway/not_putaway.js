/**
 * @author wackeCq
 * @file 商品详情页
 * @date 17/10/13 下午6:58
 */

import React, {Component} from 'react';
import KnowledgeVideo from "../knowledge_video/knowledge_video";
import KnowledgeImage from "../knowledge_image/knowledge_image";
import KnowledgePatents from "../knowledge_patents/knowledge_patents";
import Patent from '../patent_technology/patent_technology'

export default class NotPutaway extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ProductId: "",
            haveFlag: "",
            productStyle: '',
            isSj: ''
        }
    }
    componentWillMount() {
        const { productId, isSj, productStyle } = this.props.match.params;
        this.setState({ProductId: productId, haveFlag: isSj, productStyle: productStyle});
        let goodsDetail = this.renderGoods(productStyle);
    }
    renderGoods(type) {
        const { productId, isSj, productStyle } = this.props.match.params;
        switch (type) {
            case "1":
                this.props.history.replace(`/patent/${productId}/${isSj}/${productStyle}`);
                break;
            case "2":
                this.props.history.replace(`/patentimage/${productId}/${isSj}/${productStyle}`);
                break;
            case "3":
                this.props.history.replace(`/patentvideo/${productId}/${isSj}/${productStyle}`);
                break;
        }
    }
    render() {
        return (
            <div>
                
            </div>
        )
    }
}
