/**
 * @author v_duantao
 * @file 图文详情页面
 * @date 2017/11/27
 */

import React, {Component} from 'react';
import './ProductImage.less';

import {NavLink} from 'react-router-dom';

import TextInput from 'FormItem/TextInput/TextInput';
import ImgUpload from 'imgUpload/imgUpload';
import Fetch from 'Fetch/Fetch';
import {Carousel, message, Radio, Button} from 'antd';

export default class ProductImage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            position: '', // 进入的位置
            productId: '', // 产品 Id
            productTitle: '', // 知识标题
            productAuthorName: '', // 知识的作者名
            productDesc: '', // 描述
            productPrice: '', // 价格
            productStatus: '', // 商品状态
            productType: '', //
            imgList: [], // 图片列表
            fileList: [], // 文件列表
            userId: '', // 商品所属人 ID
            productPutaway: false,  // 店铺上架和非原创为 true
            productReadOnly: false, // 不是在店铺进来的是 true
        }
    }

    componentDidMount() {
        let {props, state} = this;
        let {position, productId} = props;

        switch (position) {
            // 发布
            case 'publish' :
                alert('暂时发布不了!!!');
                this.setState({
                    productPutaway: true,
                    productReadOnly: false,
                });
                break;

            // 原创
            case 'original' :
                Fetch.post(`private/product/initApplyDocInfo/${productId}`, {}).then(res => {
                    let {flag, data} = res;
                    if (flag === 1) {
                        let {detailList} = data;
                        let imgList = [];
                        let fileList = [];
                        detailList.forEach(item => {
                            if (item.productDetailType === 3) {
                                fileList.push(item);
                            } else {
                                imgList.push(item);
                            }
                        });
                        this.setState({
                            productTitle: data.productTitle,
                            productAuthorName: data.productAuthorName,
                            productDesc: data.productDesc,
                            productPrice: data.productPrice,
                            productId: data.productId,
                            productStatus: data.productStatus,
                            productType: data.productType,
                            productPutaway: true,
                            productReadOnly: false,
                            userId: data.userId,
                            imgList,
                            fileList
                        })
                    } else {
                        props.history.push('/error');
                    }
                });
                break;

            // 非原创
            case 'no_original' :
                Fetch.post(`public/product/initDocInfo/${productId}`, {}).then(res => {
                    let {flag, data} = res;
                    if (flag === 1) {
                        let {detailList} = data;
                        let imgList = [];
                        let fileList = [];
                        detailList.forEach(item => {
                            if (item.productDetailType === 3) {
                                fileList.push(item);
                            } else {
                                imgList.push(item);
                            }
                        });
                        this.setState({
                            productTitle: data.productTitle,
                            productAuthorName: data.productAuthorName,
                            productDesc: data.productDesc,
                            productPrice: data.productPrice,
                            productId: data.productId,
                            productStatus: data.productStatus,
                            productType: data.productType,
                            productPutaway: true,
                            productReadOnly: false,
                            userId: data.userId,
                            imgList,
                            fileList
                        })
                    } else {
                        props.history.push('/error');
                    }
                });
                break;

            // 上架
            case 'putaway' :
                Fetch.post(`public/product/initDocInfo/${productId}`, {}).then(res => {
                    let {flag, data} = res;
                    if (flag === 1) {
                        let {detailList} = data;
                        let imgList = [];
                        let fileList = [];
                        detailList.forEach(item => {
                            if (item.productDetailType === 3) {
                                fileList.push(item);
                            } else {
                                imgList.push(item);
                            }
                        });
                        this.setState({
                            productTitle: data.productTitle,
                            productAuthorName: data.productAuthorName,
                            productDesc: data.productDesc,
                            productPrice: data.productPrice,
                            productId: data.productId,
                            productStatus: data.productStatus,
                            productType: data.productType,
                            productPutaway: true,
                            productReadOnly: false,
                            userId: data.userId,
                            imgList,
                            fileList
                        })
                    } else {
                        props.history.push('/error');
                    }
                });
                break;

            // 其他
            default:
                Fetch.post(`public/product/initDocInfo/${productId}`, {}).then(res => {
                    let {flag, data} = res;
                    if (flag === 1) {
                        let {detailList} = data;
                        let imgList = [];
                        let fileList = [];
                        detailList.forEach(item => {
                            if (item.productDetailType === 3) {
                                fileList.push(item);
                            } else {
                                imgList.push(item);
                            }
                        });
                        this.setState({
                            productTitle: data.productTitle,
                            productAuthorName: data.productAuthorName,
                            productDesc: data.productDesc,
                            productPrice: data.productPrice,
                            productId: data.productId,
                            productStatus: data.productStatus,
                            productType: data.productType,
                            productPutaway: false,
                            productReadOnly: true,
                            userId: data.userId,
                            imgList,
                            fileList
                        })
                    } else {
                        props.history.push('/error');
                    }
                });
                break;
        }

    }

    // 获取知识标题
    setProductTitleValue = value => {
        this.setState({
            productTitle: value
        });
    };

    // 获取知识作者的名字
    setProductAuthorNameValue = value => {
        this.setState({
            productAuthorName: value,
        })
    };

    // 获取商品描述的信息
    setProductDescValue = e => {
        let value = e.target.value;
        this.setState({
            productDesc: value
        })
    };

    // 添加到购物车
    handleAddShoppingCart = () => {
        Fetch.post(`private/shoppingCart/saveShoppingCart/${this.state.productId}`, {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                message.success('添加到购物车');
            } else {
                message.error(res.message)
            }
        })
    };

    // 修改价格
    changeProductPriceValue = e => {
        let value = e.target.value;
        this.setState({
            productPrice: value
        })
    };

    // 共享还是授权
    setProductTypeValue = e => {
        this.setState({
            productType: e.target.value
        })
    };

    render() {
        let {props, state} = this;
        const RadioGroup = Radio.Group;

        return (
            <div className='product_image'>
                <div className='img_carousel'>
                    <Carousel autoplay={true}>
                        {
                            state.imgList.map((item, key) => {
                                return (
                                    <div key={key}>
                                        <img
                                            style={{
                                                width: '1080px',
                                                height: '420px',
                                            }}
                                            src={item.productPath}
                                            alt={item.productDetailDesc}
                                        />
                                    </div>
                                )
                            })
                        }
                    </Carousel>
                </div>
                <div className='image_title_author'>
                    <div style={{marginTop: '10px'}}></div>
                    <TextInput
                        label={`标题 : `}
                        placeholder='请输入图文知识的标题'
                        readOnly={state.productReadOnly}
                        changeTextValue={this.setProductTitleValue}
                        textValue={state.productTitle}
                    />
                    <div style={{marginTop: '10px'}}></div>
                    <TextInput
                        label={`作者 : `}
                        placeholder='请输入作者的名字'
                        readOnly={state.productReadOnly}
                        changeTextValue={this.setProductAuthorNameValue}
                        textValue={state.productAuthorName}
                    />
                </div>
                {/* // TODO 发布时上传... */}
                {/*<div className='image_upload'>
                    <h3 className='upload_title'>上传封面</h3>
                    <ImgUpload
                        Width='400px'
                        Height='200px'
                        MyId='info_avatar'
                        change={this.getAvatarPathValue}
                        content={'请上传封面..'}
                    />
                </div>
                <div className='file_upload'>
                    <ImgUpload
                        Width='400px'
                        Height='200px'
                        MyId='info_avatar'
                        change={this.getAvatarPathValue}
                        content={'请上传封面..'}
                    />
                </div>*/}
                <div className='image_description'>
                    <h3>简介: </h3>
                    <textarea
                        value={state.productDesc}
                        readOnly={state.productReadOnly}
                        maxLength='500'
                        onChange={this.setProductDescValue}
                    ></textarea>
                </div>
                <div className='file_list'>
                    {
                        state.fileList.map((item, key) => {
                            return (
                                <div key={key} className='list_item'>
                                    <NavLink key={key} to={`/file_details/${item.productPath}`}>
                                        {item.productDetailTitle || `可读文件${ key + 1}`}
                                    </NavLink>
                                </div>
                            )
                        })
                    }
                </div>
                {
                    state.productPutaway && !state.productReadOnly
                        ? <div className='product_putaway'>
                            <div className='change_price'>
                                <span>价格: </span>
                                <span>(此价格含20%的佣金)</span>
                                <TextInput
                                    className='input_price'
                                    label={'￥'}
                                    placeholder='请输入价格'
                                    readOnly={false}
                                    changeTextValue={this.changeProductPriceValue}
                                    textValue={state.productPrice}
                                />
                            </div>
                            <div className='product_type'>
                                <RadioGroup onChange={this.setProductTypeValue} value={state.productType}>
                                    <Radio value={1}>共享</Radio>
                                    <Radio value={2}>授权</Radio>
                                </RadioGroup>
                            </div>
                            <div className='product_btn'>
                                <Button
                                    onClick={e => alert(11)}
                                >
                                    保存
                                </Button>
                                <Button
                                    onClick={e => alert(111)}
                                >
                                    上架
                                </Button>
                            </div>
                        </div>
                        : <div></div>
                }
                {
                    !state.productPutaway && state.productReadOnly
                        ? <div className='product_buy'>
                            <div
                                className='go_shopping'
                                onClick={this.handleAddShoppingCart}
                            >
                                &#xe609;
                            </div>
                            <div className='product_price'>
                                ￥<span>{state.productPrice}</span>
                            </div>
                            <div
                                className='buy'
                                onClick={e => props.history.push(`/note/${state.productId}/${state.userId}`)}
                            >
                                立即购买
                            </div>
                            <div
                                className='note'
                                onClick={e => alert('立即购买')}
                            >
                                议价
                            </div>
                        </div>
                        : <div></div>
                }
            </div>
        )
    }
}