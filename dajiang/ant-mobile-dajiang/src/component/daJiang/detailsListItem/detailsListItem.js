/**
 * @author ruixi
 * @file 大匠详情页的list_item
 * @date 17/10/19
 */

 /**
  *  ListTitle   列表名
  *  Num    购买量
  *  NumMeasure     购买量单位
  *  Price      价格
  *  BtnText    按钮文字
  *  ItemContent    列表主体内容
  *  ListName   名字
  *  Id 跳转详情时所需的参数
  *
  */
import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import './detailsListItem.less';

export default class detailsListItem extends Component {
    constructor(props) {
        super(props);
    }

    handShoping = (e) => {
        e.preventDefault();
        e.stopPropagation();
    }

    gotoDetails = () => {
        const { productId, haveFlag, productStyle, prop, type } = this.props;
        // goods_detail 跳转参数 /productId/haveFlag/productStyle/1
        prop.history.push(`/goods_detail/${productId}/${haveFlag}/${productStyle}/1`);
        // if (type === 1) {
        //     // 专利
        //     prop.history.push(`/goods_detail/${productId}/${haveFlag}/${productStyle}/1`);
        // } else if (type === 2) {
        //     // 图文
        //     prop.history.push(`/goods_detail/${productId}/${haveFlag}/${productStyle}/1`);
        // } else if (type === 3) {
        //     // 视频
        //     prop.history.push(`/goods_detail/${productId}/${haveFlag}/${productStyle}/1`);
        // }
    }

    render() {
        const { ListTitle, Num, NumMeasure, Price, BtnText, ListName, ItemContent, productId, haveFlag, productStyle } = this.props;
        return (
            <div className='details_list_item' onClick={() => {this.gotoDetails()}}>
                <NavLink to={`/goods_detail/${productId}/${haveFlag}/${productStyle}/1`}>
                    <div className='details_list_item_head'>
                        {ListTitle}
                    </div>
                    <div className='details_list_item_body'>
                        <div className='item_left'>
                            {ListName}
                            <p>{ItemContent}</p>
                        </div>
                        <div className='item_right'>
                            <a className='btn' src='javascript:;'>{BtnText}</a>
                        </div>
                    </div>
                    <div className='details_list_item_footer'>
                        <div className='num'>购买量：{Num}{NumMeasure}</div>
                        <div className='price'>
                            <span>￥</span>
                            <span>{Price}</span>
                        </div>
                    </div>
                </NavLink>
            </div>
        )
    }
}
