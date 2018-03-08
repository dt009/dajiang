/**
 * @author v_duantao
 * @file 展示大匠的卡片
 * @date 17/10/15 下午2:22
 */

import React, {Component} from 'react';

import {NavLink} from 'react-router-dom';

import './professionalCard.less';


/**
 * @description     大匠的卡片展示
 *
 * path             点击卡片跳转的详情页面的路径
 * userPhotoPath    头像路径
 * professionalName 姓名
 * professionalPosition 职业
 * collectionNum    见过的人数
 * professionalIndroduction 简介
 * isDelete         是否显示删除
 * deleteCardFn     删除的函数
 */

export default class ProfessionalCard extends Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.handleClickDeleteFunction = this.handleClickDeleteFunction.bind(this);
    }

    handleClickDeleteFunction() {
        this.deleteCardFn()
    }

    render() {
        let props = this.props;
        let style = {marginLeft: '-1rem'};
        return (
            <div className="card_professional_show_card">
                <NavLink to={props.path} className="professional_show_card">
                    <div className="card_header">
                        <div className="header_img">
                            <img src={props.userPhotoPath} alt="头像"/>
                        </div>
                        <div className="header_name">
                            {props.professionalName}
                        </div>
                        <div className="header_occupation">
                            {props.professionalPosition}
                        </div>
                        <div className="header_collectionNum ">
                            {props.collectionNum || 0}人关注
                        </div>
                    </div>
                    <div className='card_professionalWorkunit'>
                        {props.professionalWorkunit}
                    </div>
                    <div className="card_footer">
                        <div className="footer_introduction" title={props.professionalIndroduction}>
                            简介: {props.professionalIndroduction || '这个大匠还没有简介'}
                        </div>
                    </div>
                </NavLink>
                {
                    props.isDelete ? (
                        <div className="professional_delete" onClick={this.handleClickDeleteFunction}>
                            <div className="delete_btn">删除</div>
                        </div>
                    ) : ''
                }
            </div>
        )
    }
}
