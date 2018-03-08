/**
 * @author  本文件的创建者和修改者
 * @file    文件描述
 * @date 17/9/29 下午9:22
 */

import React from 'react';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';
import {NavLink} from 'react-router-dom';
import './About.less';

export default class About extends React.Component {
    handleSave() {
        alert("这里是修改密码的界面啊");
    };
    render() {
        return (
            <div className="component_about">
                <BackHeader title="关于我们" path='/system_setting'/>
                <div className="about">
                    <NavLink className='login_logo' to="/index/home"></NavLink>
                    <div className="about_title">大匠 2.0</div>
                </div>
                <div className="about_container">
                    大匠在线是全球领先的一站式、多元化、付费知识共享平台。公司致力于以共享经济实践响应中国互联网创新战略，特别在城乡建设、都市发展、工程建造领域，引领知识取费交易的数字化、网络化革新。通过我们的平台，线上和线下的知识传播和交易将完美融合，大匠可以将经验，见解，知识，技能转化为数字化产品，分享给每一个在线用户，真正实现知识盈余的共享经济。
                </div>
                <div className="about_footet">
                    <div>
                        <NavLink to="/agreement/1?path=about" className="footer_tabs">
                            <span>《大匠软件许可及服务协议》</span>
                        </NavLink>和<NavLink to="/agreement/2?path=about" className="footer_tabs">
                            <span>《大匠隐私政策》</span>
                        </NavLink>
                    </div>
                    <div>大匠公司 版权所有</div>
                    <div>Copyright &copy;&nbsp; 2011-2017 Dajiang.All Reghts Reserved.</div>
                </div>
            </div>
        );
    };
}
