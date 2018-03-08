/**
 * @author v_duantao
 * @file 上传组件
 * @date 17/9/26 上午10:43
 */

import React, {Component} from 'react';

import {Icon} from 'antd-mobile';

import './upload.less';
import Fetch from 'fetch';


/**
 * @description     七牛云上传
 *
 * @param    id         主要
 * @params  imgSrc   图片的路径
 * @param   type  方式  1. photograph(身份证, 资格证等)  2. photo:  本人照片  3.avatar 头像
 * @param   container  可拖拽文件的 dom id      头像为: upload_avatar_box    其他定制
 * @param   content     没有上传图片显示的内容    '必填', '选填',  '请上传本人照片'
 * @param   change      方法  上层组件传入, 可以传给上层组件七牛云返回的路径
 */
export default class Upload extends Component {
    constructor(props) {
        super(props);
        this.state = {
            imgSrc: props.imgSrc,
            isShow: true,
            isLoading: false,
        };
        this.handleChangeSrc = this.handleChangeSrc.bind(this);
    }

    componentWillReceiveProps(nextProps) {
        this.setState({
            imgSrc: nextProps.imgSrc,
        });

        // TODO 获取七牛云 domain

    }

    componentDidMount() {
        let that = this;
        let props = this.props;
        let Uploader = Qiniu.uploader({
            runtimes: 'html5,html4',      // 上传模式，依次退化
            browse_button: props.id,         // 上传选择的点选按钮，必需
            uptoken_url: '/dj-api/public/qiniu/genQiNiuToken',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
            get_new_uptoken: true,             // 设置上传文件的时候是否每次都重新获取新的uptoken
            // downtoken_url: '/downtoken',
            // Ajax请求downToken的Url，私有空间时使用，JS-SDK将向该地址POST文件的key和domain，服务端返回的JSON必须包含url字段，url值为该文件的下载地址
            unique_names: true,              // 默认false，key为文件名。若开启该选项，JS-SDK会为每个文件自动生成key（文件名）
            domain: window.DOMAIN,     // bucket域名，下载资源时用到，必需
            container: props.container,             // 上传区域DOM ID，默认是browser_button的父元素
            max_retries: 1,                     // 上传失败最大重试次数
            dragdrop: false,                     // 开启可拖曳上传
            drop_element: props.container,          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
            chunk_size: '4mb',                  // 分块上传时，每块的体积
            auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
            multi_selection: false, //  限制每次只能选中一个文件

            // 添加文件类型的上传限制, 手机端微信浏览器和其他都不支持
            // filters: {
            //     max_file_size: '100mb',
            //     prevent_duplicates: true,
            //     //Specify what files to browse for
            //     mime_types: [
            //         // {title : "flv files", extensions : "flv"} //限定flv后缀上传格式上传
            //         // {title : "Video files", extensions : "flv,mpg,mpeg,avi,wmv,mov,asf,rm,rmvb,mkv,m4v,mp4"}, //限定flv,mpg,mpeg,avi,wmv,mov,asf,rm,rmvb,mkv,m4v,mp4后缀格式上传
            //         {title: "Image files", extensions: "jpg,gif,png,jpeg"}, //限定jpg,gif,png后缀上传
            //         // {title : "Zip files", extensions : "zip"} //限定zip后缀上传
            //     ]
            // },
            init: {
                'FilesAdded': function (up, files) {
                    plupload.each(files, function (file) {
                        // 文件添加进队列后，处理相关的事情
                    });
                },
                'BeforeUpload': function (up, file) {
                    // 每个文件上传前，处理相关的事情
                    that.setState({
                        isShow: false,
                        isLoading: true
                    })
                },
                'UploadProgress': function (up, file) {
                    // 每个文件上传时，处理相关的事情
                },
                'FileUploaded': function (up, file, info) {
                    // 每个文件上传成功后，处理相关的事情
                    // 其中info是文件上传成功后，服务端返回的json，形式如：
                    // {
                    //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
                    //    "key": "gogopher.jpg"
                    //  }
                    // 查看简单反馈
                    let domain = up.getOption('domain');
                    let res = JSON.parse(info.response);
                    let sourceLink = domain + "/" + file.target_name; //获取上传成功后的文件的Url
//                var sourceLink = domain + "/" + res.key; //获取上传成功后的文件的Url
                    console.info("info====" + info.response);
                    console.info("result=====" + sourceLink);
                    that.setState({
                        imgSrc: `http://${sourceLink}`,
                        isLoading: false
                    });
                    that.handleChangeSrc(that.state.imgSrc);

                },
                'Error': function (up, err, errTip) {
                    //上传出错时，处理相关的事情
                    console.info("Error.up=" + up);
                    console.info("Error.err=" + err);
                    console.info("Error.errTip" + errTip)
                    that.setState({
                        isLoading: false
                    })
                },
                'UploadComplete': function () {
                    //队列文件处理完毕后，处理相关的事情
                },
            }
        });
    }

    handleChangeSrc(imgSrc) {
        this.props.change(imgSrc, this.props.type);
    }


    render() {
        let props = this.props;
        return (
            <div className="common_upload" id={props.container}>
                {
                    this.state.isLoading ? (
                        <div className="upload_cover">
                            <Icon
                                className={`cover_icon`}
                                type={'loading'}
                                size={'lg'}
                                color={'#fff'}
                            />
                        </div>
                    ) : ''
                }
                <div className={`upload_${props.type}`}>
                    {
                        props.type === 'avatar' ? (
                            <a href="javascript:;" id={props.id}>
                                <span>头像</span>
                                <div>
                                    <img src={this.state.imgSrc} alt=""/>
                                </div>
                                <span>&#xe858;</span>
                            </a>
                        ) : (
                            <a className={props.type} href="javascript:;" id={props.id}>
                                <img src={this.state.imgSrc} alt=""/>
                                {
                                    this.state.isShow ? (
                                        <span className="upload_content">
                                            {props.content}
                                        </span>
                                    ) : ''
                                }
                            </a>
                        )
                    }
                </div>
            </div>
        )
    }
}
