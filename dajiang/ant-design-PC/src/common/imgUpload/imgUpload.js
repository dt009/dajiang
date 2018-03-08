/**
 * @author ruixi
 * @file 图像裁剪上传组件
 * @date 17/11/04
 * 
 * 获取七牛 token     /private/qiniu/genQiNiuToken
 * 文件获取地址  http://owu66z9w4.bkt.clouddn.com/o_1bsqbf3rv1g001cp7tk11q281hid41.jpg
 * todo:
 *  
 *  1. 上传七牛云逻辑
 *  2. 裁剪框的宽高由父组件传值进行控制
 */


/**
 * <ImgUpload MyId='' Width='450px' Height='250px' change={this.test} Image={} content="哈哈哈哈哈哈" disabled={false} Circle={fals
e}/>
* MyId: 唯一值 
* Height: 组件的高度 
* Width: 宽度 
* change: 回传上传图片路径的方法   在此回调中返回图片上传后的路径
* content: 没有图片时的提示
* Image: 原有图片要显示的情况下 通过此属性传值
* key: 用于标记循环引用时 组件位于数组中的第几个 不必填
*/
import React, {Component} from 'react';
import Fetch from 'Fetch/Fetch';
import './imgUpload.less';
import AvatarEditor from 'react-avatar-editor';

import { InputNumber } from 'antd';

export default class ImgUpload extends Component {
    constructor(props) {
        super(props);
        this.state = {
            host_img_src: '',
            img_src: '',
            scale: 1,
            rotate: 0,
            slider_val: 1.00,
        };
    }

    componentWillReceiveProps(nextProps) {
        
    }

    componentDidMount() {
        
    }

    // 裁剪窗口的展示
    showTailorImg = () => {
        
        this.setState({ is_show: true }, () => {
            /**
             * 初始化裁剪对象
             */
            this.selectImage();
        });
    }

    selectImage = () => {
        let ipt = this.refs.ipt;
        ipt.addEventListener('change', (e) => {
            let file = e.target.files[0];
            if(!file) {
                return;
            }
            let reader = new FileReader();
            reader.onload = (base) => {
                let base64 = base.target.result;
                this.setState({
                    img_src: base64,
                    host_img_src: base64,
                    is_show: true
                });
                this.pushImage(base64);
            };
            // 将文件以Data URL形式进行读入页面
            reader.readAsDataURL(file);
            
        }, false);
        // 触发选择文件ipt
        ipt.click();
    }

    hideImgTailor = () => {
        this.setState({ is_show: false });
    }

    // 裁剪图片
    tailorImg = () => {
        console.log('裁剪事件');
        if (this.editor) {
            const canvas = this.editor.getImage();
            const base64 = canvas.toDataURL("image/png");
            this.setState({
                img_src: base64,
                is_show: false
            });
            return base64;
        }
    }

    // 顺时针旋转
    rotateImgClockwise = () => {
        let { rotate, slider_val, host_img_src, img_src } = this.state;
        console.log(host_img_src == img_src);
        let h_scale = slider_val;
        this.setState({ img_src: host_img_src }, () => {
            setTimeout(() => {
                this.setState({
                    rotate: rotate + 90,
                    slider_val: 1
                }, () => {
                    if (this.editor) {
                        const canvas = this.editor.getImage();
                        const base64 = canvas.toDataURL("image/png");
                        this.setState({
                            img_src: base64,
                            slider_val: h_scale,
                            rotate: 0
                        });
                    }
                });
            }, 0);
        });
    }

    // 逆时针旋转
    rotateImgAnticlockwise = () => {
        let { rotate, slider_val, host_img_src } = this.state;
        let h_scale = slider_val;
        this.setState({ img_src: host_img_src }, () => {
            setTimeout(() => {
                this.setState({
                    rotate: rotate + 270,
                    slider_val: 1
                }, () => {
                    if (this.editor) {
                        const canvas = this.editor.getImage();
                        const base64 = canvas.toDataURL("image/png");
                        this.setState({
                            img_src: base64,
                            slider_val: h_scale,
                            rotate: 0
                        });
                    }
                });
            }, 0);
        });
    }

    // 180°针旋转
    rotateImg180 = () => {
        let { rotate, slider_val, host_img_src } = this.state;
        this.setState({
            img_src: host_img_src,
            rotate: rotate + 180,
            slider_val: 1
        });
    }

    // 重置 
    resetImage = () => {
        this.setState({
            img_src: this.state.host_img_src,
            slider_val: 1,
            rotate: 0
        });
    }

    // 获取token 上传图片 回传图片地址
    pushImage = (base64) => {
        if(!base64) {
            return;
        }
        const str = base64.split('base64,')[1];
        Fetch.get(`/private/qiniu/genQiNiuToken`,{}).then((res) => {
            console.log(res);
            let token = res.uptoken;
            if(res) {
                const url = "http://up-z1.qiniu.com/putb64/-1";
                let xhr = new XMLHttpRequest();
                xhr.onreadystatechange = () => {
                    if (xhr.readyState == 4){
                        console.log(xhr.responseText);
                        // 在此处回传获取到的 url
                        let json = JSON.parse(xhr.responseText);
                        let imgUrl = 'http://owu66z9w4.bkt.clouddn.com/' + json.key;
                        console.log(imgUrl);
                        this.props.change && this.props.change(imgUrl, this.props.key);
                    }
                }
            
                xhr.open("POST", url, true); 
                xhr.setRequestHeader("Content-Type", "application/octet-stream"); 
                xhr.setRequestHeader("Authorization", "UpToken " + token); 
                xhr.send(str);
            }
        });
    }
    cancelImg = () => {
        this.setState({is_show: false});
    }
    
    setEditorRef = (editor) => {
        window.editor = this.editor = editor;
    }

    onSliderChange = (e) => {
        this.setState({ slider_val: e});
    }

    render() {
        let { Width, Height, content, Image, MyId, Circle, disabled } = this.props;
        let { img_src, slider_val, rotate } = this.state;
        let img_Style = {
            width: Width ? Width : '100%',
            height: Height ? Height : '90%',
            overflow: 'hidden'
        };
        
        let total_style = {
            lineHeight: Height ? Height : '90%'
        };

        let img_style = Circle ? {borderRadius: '50%'} : {};

        let avatar_w = 200;
        let avatar_h = 200;
        if (typeof Height === 'string') {
            avatar_w = Number(Width.split('px')[0]);
        }
        if (typeof Width === 'string') {
            avatar_h = Number(Height.split('px')[0]);
        }

        return (
            <div className="img_upload" style={img_Style}>
                {this.state.is_show ? <div className="img_tailor">
                    <AvatarEditor
                        image={img_src}
                        ref={this.setEditorRef}
                        width={avatar_w || 200}
                        height={avatar_h || 200}
                        border={100}
                        color={[255, 255, 255, 0.6]} // RGBA
                        scale={slider_val}
                        rotate={rotate}
                    />
                    {/* <div style={{height: '50px'}}>
                        <Slider min={0} max={2} onChange={this.onSliderChange} value={this.state.slider_val} step={0.01} />
                    </div> */}
                    
                    <div className="btn_container">
                        <div className='flex3'>
                            放大倍数：<InputNumber
                                min={0}
                                max={2}
                                step={0.01}
                                value={slider_val}
                                onChange={this.onSliderChange}
                            />
                        </div>
                        {/* 上传按钮 及 获取img信息订单输入框 */}
                        <div className="img_upload_btn" onClick={this.resetImage}>重置</div>
                        <div className="img_upload_btn" onClick={this.rotateImgClockwise}>顺时针旋转</div>
                        <div className="img_upload_btn" onClick={this.rotateImgAnticlockwise}>逆时针旋转</div>
                        <div className="img_upload_btn" onClick={this.rotateImg180}>180°旋转</div>
                        <div className="img_upload_btn" onClick={this.selectImage}>重选</div>
                        <div className="img_upload_btn" onClick={this.tailorImg}>裁剪</div>
                        <div className="img_upload_btn" onClick={this.cancelImg}>取消</div>
                        <input type="file" ref="ipt" id="upload" accept="image/*" style={{display: 'none'}} className="file1"/>
                    </div>
                </div> : null}
                {/* 裁剪完之后的展示 */}
                <div className="img_exhibition" onClick={(e) => {if (!disabled) { this.showTailorImg(e); }}}>
                    {!img_src && !Image ? <div className="show_total_desciption" style={total_style}>{content ? content : '点击选择图片'}</div> : null}
                    {(img_src!=''||Image!='')?<img style={img_style} src={img_src || Image} alt=""/>:''}
                </div>
            </div>
        )
    }
}
