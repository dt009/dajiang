/**
 * @author v_duantao
 * @file 搜索的页面
 * @date 17/9/23 下午12:02
 */

import React, {Component} from 'react';
import './search.less';
import {Toast} from 'antd-mobile';
import {NavLink} from 'react-router-dom';

import Fetch from 'fetch';
import SelectInput from 'formItem/selectInput/selectInput';
import Radio from 'formItem/radio/radio';
import TextInput from "formItem/textInput/textInput";
import ProfessionalCard from "card/professionalCard/professionalCard";
import ProductCard from "card/productCard/productCard";


const radioData = [
    {
        value: '0',
        label: '大匠'
    },
    {
        value: "1",
        label: '产品'
    },
    {
        value: "2",
        label: "知识经济人"
    }
];

export default class Search extends Component {
    constructor(props) {
        super(props);
        this.state = {
            searchType: '0', // 搜索类型
            keyWord: '',    // 关键字
            professionalTypeIds: [], // 大匠分类
            minPrice: 0,  // 最少价格
            maxPrice: '', // 最大的价格
            productTypes: [], // 产品分类
            regionIds: [],   // 注册城市
            resultDataList: [], // 结果
        };
        this.getSearchTypeValue = this.getSearchTypeValue.bind(this);
        this.renderOptionsContent = this.renderOptionsContent.bind(this);
        this.getRegionIdValue = this.getRegionIdValue.bind(this);
        this.getProfessionalTypeIdValue = this.getProfessionalTypeIdValue.bind(this);
        this.getKeyWordValue = this.getKeyWordValue.bind(this);
        this.getProductTypesListValue = this.getProductTypesListValue.bind(this);
        this.getMinPriceValue = this.getMinPriceValue.bind(this);
        this.getMaxPriceValue = this.getMaxPriceValue.bind(this);
        this.init = this.init.bind(this);
        this.renderResultList = this.renderResultList.bind(this);
    }

    componentDidMount() {

        let props = this.props;
        let searchType = props.match.params.searchType;
        this.setState({
            searchType: searchType
        }, () => this.init());
    }

    // 初始化信息
    init() {
        let props = this.props;
        let state = this.state;
        let that = this;
        let searchType = state.searchType;
        let url = 'public/professional/queryMoreProfessionals';
        let professionalTypeIds = state.professionalTypeIds[0] === 'empty'
            ? []
            : state.professionalTypeIds;
        let regionIds = state.regionIds[0] === 'empty'
            ? []
            : state.regionIds;
        let productTypes = state.productTypes[0] === 'empty'
            ? []
            : state.productTypes;
        let params = {
            condition: {
                keyWord: state.keyWord,
                professionalTypeIds: professionalTypeIds,
                regionIds: regionIds,
                maxPrice: state.maxPrice,
                minPrice: state.minPrice,
                productStyles: productTypes
            },
            pageSize: 100,
            pageNumber: 1
        };
        if (searchType === '1') {
            url = 'public/product/queryMoreProducts';
        } else if (searchType === '2') {
            url = 'public/cko/queryMoreCkos';
        }

        Fetch.post(url, params).then(res => {
            if (res.flag === 1) {
                that.setState({
                    resultDataList: res.data.list
                })
            } else {
                Toast.fail('请求错误, 重新搜索', 1)
            }

        })
    }

    componentDidUpdate() {
        // console.log(this.state.searchType);
        // console.log(this.state.resultDataList);
    }

    // 获取搜索类型
    getSearchTypeValue(value) {
        window.location.hash = '/index/search/' + value;
        this.setState({
            searchType: value,
            resultDataList: [],
            keyWord: '',
            professionalTypeIds: [],
            productTypes: [],
            regionIds: [],
        }, () => this.init())
    }

    // 获取关键字
    getKeyWordValue(value) {
        this.setState({
            keyWord: value
        })
    }

    // 渲染查询的具体条件
    renderOptionsContent(value) {
        let add = {
            label: '选择',
            value: 'empty',
            children: [
                {
                    label: '请选择',
                    value: 'empty',
                }
            ]
        };
        let professionalTypeList = window.LIST.professionalTypeList.slice();
        professionalTypeList.unshift(add);
        let productStyleList = window.LIST.productStyleList.slice();
        productStyleList.unshift(add);
        let cityList = window.LIST.cityList.slice();
        cityList.unshift(add);
        if (value === '0') {
            return (
                <div>
                    <SelectInput
                        data={professionalTypeList}
                        title="选择大匠的分类"
                        label="大匠分类 :"
                        value="1"
                        cols={2}
                        getChangeSelectValue={this.getProfessionalTypeIdValue}
                    />
                </div>
            )
        } else if (value === '1') {
            return (
                <div className="search_product">
                    <SelectInput
                        data={professionalTypeList}
                        title="选择专业"
                        label="专业分类 :"
                        value="2"
                        cols={2}
                        getChangeSelectValue={this.getProfessionalTypeIdValue}
                    />
                    <div className="search_price">
                        <div className="price_label">价格 :</div>
                        <input
                            type="text"
                            value={this.state.minPrice}
                            onChange={this.getMinPriceValue}
                            placeholder="最小价格"
                        />
                        <span> - </span>
                        <input
                            type="text"
                            value={this.state.maxPrice}
                            onChange={this.getMaxPriceValue}
                            placeholder="最大价格"
                        />
                    </div>
                    <SelectInput
                        data={productStyleList}
                        title="产品分类"
                        label="产品类型 :"
                        value="3"
                        cols={1}
                        getChangeSelectValue={this.getProductTypesListValue}
                    />

                </div>
            )
        } else if (value === '2') {
            return (
                <div>
                    <SelectInput
                        data={cityList}
                        title="选择城市"
                        label="注册城市 :"
                        value="4"
                        cols={2}
                        getChangeSelectValue={this.getRegionIdValue}
                    />
                </div>
            )
        }
    }


    // 获取大匠分类
    getProfessionalTypeIdValue(value) {
        this.setState({
            professionalTypeIds: [value[1]]
        })
    }

    // 获取最小价格
    getMinPriceValue(e) {
        let value = e.target.value;
        this.setState({
            minPrice: Number(value)
        })
    }

    // 获取最大的价格
    getMaxPriceValue(e) {
        let value = e.target.value;
        this.setState({
            maxPrice: Number(value)
        })
    }


    // 获取常驻城市韩式
    getRegionIdValue(value) {
        this.setState({
            regionIds: [value[1]]
        })
    }


    // 获取产品分类的函数
    getProductTypesListValue(value) {
        this.setState({
            productTypes: value
        })
    }

    // 点击查询
    handleSearchSubmit = () => this.init()

    // 渲染结果
    renderResultList() {
        let state = this.state;
        let resultList = state.resultDataList;
        if (state.searchType === '0') {
            return resultList.map((item, key) => {
                return (
                    <ProfessionalCard
                        key={key}
                        path={`/da_jiang_detail/${item.professionalId}`}
                        userPhotoPath={item.userPhotoPath}
                        professionalName={item.professionalName}
                        professionalPosition={item.professionalPosition}
                        collectionNum={item.collectionNum}
                        professionalWorkunit={item.professionalWorkunit}
                        professionalIndroduction={item.professionalIndroduction}
                    />
                )
            })
        } else if (state.searchType === '1') {
            return resultList.map((item, key) => {
                return (
                    <ProductCard
                        key={key}
                        path={`/goods_detail/${item.productId}/${item.haveFlag}/${item.productStyle}/1`}
                        productTitle={item.productTitle}
                        productPrice={item.productPrice}
                        productAuthorName={item.productAuthorName}
                        productDesc={item.productDesc}
                        orderNum={item.orderNum}
                        productUpdatedt={item.productUpdatedt}
                    />
                )
            })
        } else if (state.searchType === '2') {
            return resultList.map((item, key) => {
                return (
                    <NavLink to={`/broker_detail/${item.ckoKey}`} key={key} className="broker_card">
                        <img className="card_img"
                             src={item.userPhotoPath || 'http://owu66z9w4.bkt.clouddn.com/o_1bsan1g091b71bf6oed193l181ua.jpeg'}
                             alt=""/>
                        <span className="card_ckoNickname">{item.ckoNickname}</span>
                        <span className="card_ckoName">{item.ckoName}</span>
                    </NavLink>
                )
            })
        }
    }

    render() {
        return (
            <div className="index_search">
                <div className="search_type">
                    <Radio
                        data={radioData}
                        name="search"
                        value={this.props.match.params.searchType}
                        getRadioValue={this.getSearchTypeValue}
                    />
                </div>
                <div className="search_options">
                    {this.renderOptionsContent(this.state.searchType)}
                </div>
                <div className="search_keyword">
                    <div className="keyword_input">
                        <span>&#xe60b;</span>
                        <TextInput
                            placeholder="搜索"
                            type="text"
                            textValue={this.state.keyWord}
                            changeTextValue={this.getKeyWordValue}
                        />
                    </div>
                    <div className="search_submit" onClick={this.handleSearchSubmit}>查询</div>
                </div>
                <div className="search_result_list">
                    {this.state.resultDataList.length === 0
                        ? '没有搜索的结果,重新搜索..'
                        : this.renderResultList()
                    }
                </div>
            </div>
        )
    }
}
