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



import './goodsDetail.less';

export default class GoodsDetail extends Component {
    constructor(props){
        super(props);
        this.state ={
            ProductId:"",
            haveFlag:"",
            productStyle:'',
            isSj:''
        }
    }
    componentWillMount(){
        const { prodaustid, type, knowledgea, isSj } = this.props.match.params;
        let haveFlag = type;
        let ProductId = prodaustid;
        let productStyle = knowledgea;
        this.setState({
            ProductId:ProductId,
            haveFlag:haveFlag,
            productStyle:productStyle,
            isSj:isSj
        })
    }
    renderGoods(type){
        switch(type){
            case "1":
                console.log("this is goodsDetail 1");
                return(
                    <div>
                        <KnowledgePatents  ProductId={this.state.ProductId}
                              haveFlag={this.state.haveFlag}
                               productStyle={this.state.productStyle}
                               isSj = {this.state.isSj}

                           />

                    </div>
                )
            case "2":
            console.log("this is goodsDetail 2");
                return(
                    <div>
                        <KnowledgeImage ProductId={this.state.ProductId}  haveFlag={this.state.haveFlag} isSj = {this.state.isSj}  productStyle={this.state.productStyle}/>
                    </div>
                )
            case "3":
            console.log("this is goodsDetail 3");
                return(
                    <div>
                        <KnowledgeVideo ProductId={this.state.ProductId}  haveFlag={this.state.haveFlag} isSj = {this.state.isSj}  productStyle={this.state.productStyle} />

                    </div>
                )
        }
    }

    render() {
        const { prodaustid, type, knowledgea, isSj } = this.props.match.params;
        let haveFlag = type;
        let ProductId = prodaustid;
        let productStyle = knowledgea;
        let goodsDetail = this.renderGoods(productStyle);
        return (
            <div>
                {goodsDetail}
            </div>
        )
    }
}
