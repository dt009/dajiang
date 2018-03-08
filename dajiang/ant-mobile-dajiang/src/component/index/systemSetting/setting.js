/**
 * @author v_duantao
 * @file 这是设置页面
 * @date 17/9/24 下午9:06
 */

import React, {Component} from 'react';

import './setting.less';

import BackHeader from 'backHeader/backHeader';
import ListItem from 'listItem/listItem';

export default class Setting extends Component {
    render() {
        return (
            <div className="my_setting">
                <BackHeader
                    path="/index/my"
                    title="设置"
                />
                <div className="setting_content">
                    {/*<ListItem path={'/account_setting'} title="账户设置">*/}
                        {/*<span>&#xe61a;</span>*/}
                    {/*</ListItem>*/}
                    {/* <ListItem
                        style={{marginTop: '0.3rem'}}
                        path={'/change_password'}
                        title="修改密码"
                    >
                        <span>&#xe6f9;</span>
                    </ListItem> */}
                    {/* <ListItem path={'/question_da_jiang'} title="常见问题">
                        <span>&#xe606;</span>
                    </ListItem> */}
                    <ListItem path={'/about'} title="关于我们">
                        <span>&#xe6c0;</span>
                    </ListItem>
                    <ListItem path={'/feedback'} title="意见反馈">
                        <span>&#xe615;</span>
                    </ListItem>
                    <ListItem style={{marginTop: '0.3rem'}} path={'/service_center'} title="联系客服">
                        <span>&#xe95a;</span>
                    </ListItem>
                </div>
            </div>
        )
    }
}
