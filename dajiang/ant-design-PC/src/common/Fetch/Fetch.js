/**
 * @author v_duantao
 * @file 初始化请求
 * @date 2017/11/20
 */

import 'whatwg-fetch';

// 某部分的请求头
let myHeaders = new Headers({
    'Content-type': 'application/json'
});

/**
 *
 * @param res
 * @constructor
 */
function FetchIntercept(res) {
    if (res.status != 200) {
        let url = '/error';
        window.location.hash = url;
    } else {
        return res.json();
    }
}

const PREURL = 'dj-api/';

/**
 * @type {{post: Fetch.post, get: Fetch.get}}
 */
let Fetch = {
    /**
     * @param url  请求的链接地址
     * @param data  {json} 传递的参数数据
     * @return {Promise.<TResult>}
     */
    post: function (url, data) {
        url = PREURL + url;
        return fetch(url, {
            credentials: 'include',
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(data)
        }).then(res => FetchIntercept(res))
    },

    /**
     * @param url  请求的链接地址
     * @param data  {json} 传递的参数数据
     * @return {Promise.<TResult>}
     */
    get: function (url) {
        url = PREURL + url;
        return fetch(url).then(res => FetchIntercept(res))
    }
};

export default Fetch;