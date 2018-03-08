/**
 * @author wackeCq v_duantao
 * @file 大匠的展示卡片
 * @date 17/9/23 下午4:32
 */


import React from 'react';
import {Card, WhiteSpace} from 'antd-mobile';
import './card.less'

// 大将的展示界面

/**
 * @param props {object}
 *
 * @param name 姓名
 * @param occupation 职业
 * @param sex 性别
 * @param age 年龄
 * @param speciality 专业
 * @param  seeNumber  见过的人数
 * @param imgSrc  头像照路径
 * @param introduce 产品介绍
 * @param pName 产品名称
 * @param date 产品时间
 * @param sum 购买人数
 * @param price 产品价格
 */

export default class MobileCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    };

    render() {
        let props = this.props;

        // 标题
        let title = (
            <div style={{fontSize: '0.26rem'}}>
                <span style={{color: '#fbb303', marginRight: '0.1rem'}}>
                    {props.name}
                </span>
                <span>{props.occupation}</span>
            </div>
        );

        // 附加信息
        let extra = props.seeNumber ? (
            <span style={{color: '#fbb303', fontSize: '0.26rem'}}>
                {props.seeNumber}人见过
            </span>
        ) : '';

        // 男女信息
        let sex = props.sex === '男' ?
            (<span style={{fontFamily: 'iconfont'}} className="sex">简介: &#xe6a6;</span>)
            : (<span style={{fontFamily: 'iconfont'}} className="sex">简介: &#xe716;</span>);

        return (
            <Card className="show_card" full={false}>
                <Card.Header title={props.title || title}
                             thumb={props.imgSrc}
                             extra={extra}/>
                <Card.Body>
                    <div>{ props.sex ? sex : ''} {props.age} {props.speciality}</div>
                    <div style={{color: '#fbb303'}}>{props.pName}</div>
                    {
                        props.introduce ?
                        <div style={{marginTop: '0.1rem',borderBottom:'1px solid #ccc',paddingBottom:'0.2rem'}}>{props.introduce}</div> : ''
                    }
                </Card.Body>
                {
                    props.price ?
                        <Card.Footer className=".border_one_top" content={
                            <div className="card_footer">
                                <span>{props.date}</span>
                                <span style={{color: '#fbb303'}}>购买量: {props.sum}人</span>
                                <span>￥<span style={{color: '#fbb303',fontSize:'0.32rem'}}>{props.price}</span></span>
                            </div>
                        }/>
                     : ''
                }
            </Card>
        );
    };
}
