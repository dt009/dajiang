/**
 * @author v_duantao
 * @file 判断是否登录过
 * @date 17/10/21 下午9:42
 */

import Fetch from '../fetch';

function isLoginFn() {
    if(!window.LOGIN_STATUS) {
        Fetch.post('isLogin', {}).then(res => {
            let data = res.data;
            if (res.flag === 1) {
                window.LOGIN_STATUS = data.loginStatus;
                window.USER = data.dataMap.user;
                if(window.LOGIN_STATUS === 'Y') {
                    console.log('用户已登录');
                } else {
                    console.log('用户未登录');
                }
            } else {
                window.location.hash = '/error'
            }
        });
    } else if (window.LOGIN_STATUS === 'Y') {
        console.log('用户已登录');
    } else {
        console.log('用户未登录');
    }
}

export default isLoginFn;


