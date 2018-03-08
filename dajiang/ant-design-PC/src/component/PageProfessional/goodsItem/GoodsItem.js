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
import './goodsItem.less';

export default class detailsListItem extends Component {

    handShoping = (e) => {
        e.preventDefault();
        e.stopPropagation();
        console.log("购买", this.props.Id);
    }

    gotoDetails = () => {
        console.log('跳转详情页');
    }

    render() {
        const { ListTitle, Num, NumMeasure, Price, BtnText, ListName, ItemContent, url, PriceUrl } = this.props;

        return (<div className="w-textItem">
            <div className="w-textItem-hd">
                {ListTitle}
            </div>
            <div className="w-textItem-bd">
                <NavLink to={url} className="w-textItem-name">{ListName}</NavLink>
                <p className="w-textItem-text">{ItemContent}</p>
                <NavLink to={PriceUrl} className="w-textItem-buy">{BtnText}</NavLink>
            </div>
            <div className="w-textItem-ft clearfix">
                <span>购买量：{Num}{NumMeasure}</span><span className="w-textItem-price"><sub>￥</sub>{Price}</span>
            </div>
        </div>)
    }
}
