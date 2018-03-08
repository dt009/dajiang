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
  * <ImgUpload MyId='' Width='4.5rem' Height='2.5rem' change={this.test} content="哈哈哈哈哈哈"/>
  * MyId: 唯一值 
  * Height: 组件的高度 2.3rem
  * Width: 宽度 2.3rem
  * change: 回传上传图片路径的方法
  * content: 没有图片时的提示
  * Image: 原有图片要显示的情况下 通过此属性传值
  * key: 用于标记循环引用时 组件位于数组中的第几个 不必填
  */
import React, {Component} from 'react';
import Fetch from 'fetch';
import './js/veCrop.js';
import './imgUpload.less';

export default class ImgUpload extends Component {
    constructor(props) {
        super(props);
        this.state = {
            is_show: false,
            tailor_img: '',
            img_src: '',
            img_base64: ''
        };
    }

    componentWillReceiveProps(nextProps) {
        
    }

    componentDidMount() {
        
    }

    showTailorImg = () => {
        this.setState({is_show: true}, () => {
            const { MyId } = this.props;
            let frameImg = this.frameImg = document.getElementById(`img_upload_frameImg_${MyId}`);
            let frame = document.getElementById(`img_upload_inner_${MyId}`);
            let cropFrame = document.getElementById(`img_upload_innerFrame_${MyId}`);
            console.log(frameImg);
            /**
             * 初始化裁剪对象
             */
            this.veCrop = new veCrop({
                img: frameImg,
                frame: frame,
                frameBorderWidth: 2,
                cropFrame: cropFrame
            });
            let ipt = this.refs.ipt;
            let self = this;
            ipt.addEventListener('change', function() {
                let file = this.files[0];
                if(!file) {
                    return;
                }
                let reader = new FileReader();
                // 将文件以Data URL形式进行读入页面
                reader.readAsDataURL(file);
                reader.onload = function() {
                    let base64 = this.result;
                    self.setState({
                        img_src: base64,
                        is_show: true
                    });
                };
            }, false);
            // 触发选择文件ipt
            ipt.click();
        });
    }

    hideImgTailor = () => {
        this.setState({ is_show: false });
    }

    // 裁剪图片
    tailorImg = () => {
        console.log('裁剪事件');
        this.veCrop.generate((base64) => {
            this.setState({
                img_base64: base64,
                is_show: false
            });
            this.pushImage(base64);
        });
    }

    // 旋转
    rotateImg = () => {
        let width  = 0;
        let height = 0;
        if (this.frameImg) {
            width = this.frameImg.width;
            height = this.frameImg.height;
        }
        let param = this.veCrop.getParam();
        param.deg += 90;
        let offsetX = 0;
        let offsetY = 0;
        if ((param.deg/90)%2 === 0) {
            offsetX = 0 - (width / 2);
            offsetY = 0 - (height / 2);
        } else {
            offsetX = 0 - (height / 2);
            offsetY = 0 - (width / 2);
        }
        param.offsetX = offsetX;
        param.offsetY = offsetY;
        this.veCrop.formatTransform(offsetX, offsetY, param.scale, param.deg);
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
                        console.log(json);
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

    render() {
        let {Width, Height, content, Image, MyId} = this.props;
        let left = Width ? -(Width.split('rem')[0] / 2) + 'rem' : '-50%';
        let top = Height ? -(Height.split('rem')[0] / 2) + 'rem' : '-1.6rem';
        let img_Style = {
            width: Width ? Width : '100%',
            height: Height ? Height : '3.2rem',
            overflow: 'hidden'
        };
        let img_Style_Box = {
            width: Width ? Width : '100%',
            height: Height ? Height : '3.2rem',
            overflow: 'hidden',
            left: '50%',
            top: '50%',
            marginLeft: left,
            marginTop: top
        };
        let total_style = {
            lineHeight: Height ? Height : '3.2rem'
        };

        return (
            <div className="img_upload" style={img_Style}>
                {this.state.is_show ? <div className="img_tailor">
                    {/* 裁剪中的盒子 */}
                    <div className="gold_inner" id={`img_upload_inner_${MyId}`}>
                        {/* 裁剪区域的大小 */}
                        <div id={`img_upload_innerFrame_${MyId}`} style={img_Style_Box} className="inner_frame"></div>
                        {/* 需要裁剪的原图 */}
                        <img src={this.state.img_src} id={`img_upload_frameImg_${MyId}`} className="frame_img"/>
                    </div>
                    <div className="btn-container">
                        {/* 上传按钮 及 获取img信息订单输入框 */}
                        <div className="img_upload_btn" onClick={this.rotateImg}>旋转</div>
                        <div className="img_upload_btn" onClick={this.tailorImg}>裁剪</div>
                        <div className="img_upload_btn" onClick={this.cancelImg}>取消</div>
                        <input type="file" ref="ipt" id="upload" accept="image/*" style={{display: 'none'}} className="file1"/>
                    </div>
                </div> : null}
                {/* 裁剪完之后的展示 */}
                <div className="img_exhibition" onClick={this.showTailorImg}>
                    {!this.state.img_base64 && !Image ? <div className="show_total_desciption" style={total_style}>{content ? content : 点击选择图片}</div> : null}
                    <img src={this.state.img_base64 || Image} alt=""/>
                </div>
            </div>
        )
    }
}
