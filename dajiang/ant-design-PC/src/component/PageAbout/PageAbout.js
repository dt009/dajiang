/**
 * @author v_duantao
 * @file 关于我们的页面
 * @date 2017/11/26
 */

import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import './PageAbout.less';

export default class PageAbout extends Component {
    render() {
        return (    	
            <div className='page_about'>
	               <div className='banner_box'>
	            	
	            </div>
               大匠在线是全球领先的一站式、多元化、付费知识共享平台。
               公司致力于以共享经济实践响应中国互联网创新战略，
               特别在城乡建设、都市发展、工程建造领域，
               引领知识取费交易的数字化、网络化革新。
               通过我们的平台，线上和线下的知识传播和交易将完美融合，
               大匠可以将经验，见解，知识，技能转化为数字化产品，
               分享给每一个在线用户，真正实现知识盈余的共享经济。
               <div className="xieyi">
               《大匠软件许可及服务协议》和《大匠隐私政策》
               </div>
               <div id="cover"></div>                  
               <div id="xiyibox">
                  <div id="boxtitle">
                      <span id="closeBox">[关闭]</span>
                  </div>
               </div>
               <div className="banquan">
               大匠公司版权所有
               </div>
               <div className="banquanhao">
               Copyright 2011-2017 ©Dajiang. All Rights Reserved.
               </div>
            </div>           
        )
    }
}


// /*点击协议弹出框*/
// function $(eid) {
//         return document.getElementById(eid);
//     }
//     window.onload = function() {
//         var xieyi = $("xieyi");
//         // 点击打开登录框
//         xieyi.onclick = function() {
//             $("xieyibox").style.display = "block";
//             $("cover").style.display = "block";
//         }
//         // 点击关闭登录框
//         $("closeBox").onclick = function() {
//             $("xieyibox").style.display = "none";
//             $("cover").style.display = "none";
//         }
//         // 托拽登录框
//         $("boxtitle").onmousedown = function(event) {
//             event = event || window.event;
//             var ox = event.offsetX;
//             var oy = event.offsetY;
//
//             document.onmousemove = function(event) {
//                 event = event || window.event;
//                 var cx = event.pageX;
//                 var cy = event.pageY;
//
//
//                 var otop = cy - oy;
//                 var oleft = cx - ox;
//
//                 // 处理边界问题_处理元素的边界问题
//                 if(oleft < 0) {
//                     oleft = 0;
//                 } else if(oleft + $("xieyibox").offsetWidth > document.documentElement.clientWidth ) {
//                     oleft = document.documentElement.clientWidth - $("xieyibox").offsetWidth;
//                 }
//                 if(otop < 0) {
//                     otop = 0;
//                 } else if(otop + $("xieyibox").offsetHeight > document.documentElement.clientHeight) {
//                     otop = document.documentElement.clientHeight - $("xieyibox").offsetHeight;
//                 }
//
//                 // 处理鼠标的边界问题
//                 if(cx < 0 || cx > document.documentElement.clientWidth
//                     || cy < 0 || cy > document.documentElement.clientHeight){
//                         document.onmousemove = null;
//                 }
//
//
//                 $("xieyibox").style.left = oleft + "px";
//                 $("xieyibox").style.top = otop  + "px";
//             }
//
//             $("boxtitle").onmouseup = function() {
//                 document.onmousemove = null;
//             }
//         }
//     }
