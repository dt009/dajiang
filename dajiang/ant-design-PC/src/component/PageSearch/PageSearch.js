/**
 * @author v_duantao
 * @file 搜索页
 * @date 2017/11/20
 */

import React, {Component} from 'react';

import './PageSearch.less';

import {Cascader, Radio, message, InputNumber, Input, Icon, Button} from 'antd';
import Fetch from "../../common/Fetch/Fetch";

export default class PageSearch extends Component {

    constructor(props) {
        super(props);
        this.state = {
            searchType: '0', // 搜索类型
            professionalFirstOptions: [], // 大匠分类的一级列表
            professionalTypeIds: [], // 大匠分类的 Id 的列表
            productStyleOptions: [], // 产品类型的列表
            productTypes: [], // 产品分类
            minPrice: 0,  // 最少价格
            maxPrice: '', // 最大的价格
            cityListOptions: [],
            regionIds: [],   // 注册城市
            keyWord: '', // 关键字
            resultDataList: [], // 结果
        }
    }

    handleFilterDate = value => {
        let time = new Date(value);
        let year = time.getFullYear();
        let month = time.getMonth() + 1;
        let day = time.getDate();
        return `${year}/${month}/${day}`
    };


    componentDidMount() {

        // 组件加载时的方法
        let {params} = this.props.match;
        let searchType = params.searchType;
        this.setState({
            searchType
        }, () => this.init());

        // 获取大匠的第一级分类的操作
        Fetch.get('public/professionalType/queryByPid/0', {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                let options = [];
                data.forEach(item => {
                    options.push({
                        label: item.professionalTypeName,
                        value: item.professionalTypeId,
                        isLeaf: false,
                    })
                });

                this.setState({
                    professionalFirstOptions: options
                })
            } else {
                message.error(res.message)
            }
        });

        // 获取产品类型
        Fetch.get('public/dict/queryProductStyle', {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                let option = [];
                data.forEach(item => {
                    option.push({
                        value: item.itemCode,
                        label: item.itemValue
                    })
                });

                this.setState({
                    productStyleOptions: option
                })

            } else {
                message.error(res.message)
            }
        });

        // 获取城市的第一级菜单
        Fetch.get('public/region/queryByPid/1', {}).then(res => {
            let {flag, data} = res;
            if (flag === 1) {
                let options = [];
                data.forEach(item => {
                    options.push({
                        label: item.regionName,
                        value: item.regionId,
                        isLeaf: false,
                    })
                });

                this.setState({
                    cityListOptions: options
                })
            } else {
                message.error(res.message)
            }
        })
    }

    init = () => {
        let props = this.props;
        let state = this.state;
        let that = this;
        let searchType = state.searchType;
        let url = 'public/professional/queryMoreProfessionals';

        let params = {
            condition: {
                keyWord: state.keyWord,
                professionalTypeIds: state.professionalTypeIds,
                regionIds: state.regionIds,
                maxPrice: state.maxPrice,
                minPrice: state.minPrice,
                productStyles: state.productTypes
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
            let {flag, data} = res;
            if (flag === 1) {
                that.setState({
                    resultDataList: data.list
                })
            } else {
                message.error('请求错误, 重新检查搜索条件')
            }
        })
    };

    // 搜索类型的变化执行的方法
    handleRadioChange = e => {
        let value = e.target.value;
        this.setState({
            searchType: value,
            resultDataList: [],
            keyWord: '',
            professionalTypeIds: [],
            productTypes: [],
            regionIds: [],
        }, () => {
            this.props.history.push(`/search/${value}`);
            this.init();
        })
    };

    // 获取大匠二级分类的函数
    fetchProfessionalSecondClassify = selectedOptions => {
        let PID = selectedOptions[0].value;
        const targetOption = selectedOptions[selectedOptions.length - 1]
        targetOption.loading = true;

        Fetch.get(`public/professionalType/queryByPid/${PID}`, {}).then(res => {
            targetOption.loading = false;
            let {flag, data} = res;
            if (flag === 1) {
                let option = [];
                data.forEach(item => {
                    option.push({
                        label: item.professionalTypeName,
                        value: item.professionalTypeId,
                    })
                });
                targetOption.children = option;
                this.setState({
                    professionalFirstOptions: [...this.state.professionalFirstOptions]
                })
            } else {
                message.error(res.message)
            }
        });
    };

    // 大匠分类的选择
    handleChangeProfessionalTypeIds = (value, selectedOptions) => {
        let ids = [value[value.length - 1]];
        this.setState({
            professionalTypeIds: ids
        })
    };

    // 选择产品分类
    handleChangeProductStyle = value => {
        this.setState({
            productTypes: value
        })
    };

    // 获取最小值
    handleChangeMinPriceValue = value => {
        this.setState({
            minPrice: value
        })
    };

    // 获取最大值
    handleChangeMaxPriceValue = value => {
        this.setState({
            maxPrice: value
        })
    };

    // 获取二级城市
    fetchCityListSecond = selectedOptions => {
        let PID = selectedOptions[0].value;
        const targetOption = selectedOptions[selectedOptions.length - 1]
        targetOption.loading = true;

        Fetch.get(`public/region/queryByPid/${PID}`, {}).then(res => {
            targetOption.loading = false;
            let {flag, data} = res;
            if (flag === 1) {
                let option = [];
                data.forEach(item => {
                    option.push({
                        label: item.regionName,
                        value: item.regionId,
                    })
                });
                targetOption.children = option;
                this.setState({
                    cityListOptions: [...this.state.cityListOptions]
                })
            } else {
                message.error(res.message)
            }
        });
    };

    // 城市分类选择
    handleChangeCity =  (value, selectedOptions) => {
        let ids = [value[value.length - 1]];
        this.setState({
            regionIds: ids
        })
    };

    // 获取关键词的的方法
    handleGetKeywordValue = e => {
        this.setState({
            keyWord: e.target.value
        })
    };

    // 渲染搜索条件
    renderSearchCondition = searchType => {

        let state = this.state;
        switch(searchType) {
            // 大匠
            case '0':
                return (
                    <div className='search_classify'>
                        <Cascader
                            className='professional_classify'
                            placeholder='请选择选择大匠'
                            displayRender={label => label.join(' - ')}
                            options={state.professionalFirstOptions}
                            loadData={this.fetchProfessionalSecondClassify}
                            onChange={this.handleChangeProfessionalTypeIds}
                            changeOnSelect={true}
                        />
                    </div>
                );
                break;

            // 产品
            case '1':
                return (
                    <div className='product_condition'>
                        <Cascader
                            className='professional_classify'
                            placeholder='请选择选择大匠'
                            displayRender={label => label.join(' - ')}
                            options={state.professionalFirstOptions}
                            loadData={this.fetchProfessionalSecondClassify}
                            onChange={this.handleChangeProfessionalTypeIds}
                            changeOnSelect={true}
                        />
                        <InputNumber
                            className='min_price'
                            formatter={value => `￥ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
                            parser={value => value.replace(/\￥\s?|(,*)/g, '')}
                            min={0}
                            onChange={this.handleChangeMinPriceValue}
                        />
                         -
                        <InputNumber
                            className='max_price'
                            formatter={value => `￥ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
                            parser={value => value.replace(/\￥\s?|(,*)/g, '')}
                            min={state.minPrice}
                            onChange={this.handleChangeMaxPriceValue}
                        />
                        <Cascader
                            className='product_style'
                            placeholder='选择产品类型'
                            options={state.productStyleOptions}
                            onChange={this.handleChangeProductStyle}
                        />
                    </div>
                );
                break;

            // 经纪人
            case '2':
                return (
                    <div className='broker_condition'>
                        <Cascader
                            className='city_list'
                            placeholder='请选择城市'
                            displayRender={label => label.join(' - ')}
                            options={state.cityListOptions}
                            loadData={this.fetchCityListSecond}
                            onChange={this.handleChangeCity}
                            changeOnSelect={true}
                        />
                    </div>
                );
                break;
            default:

        }
    };

    // 点击查询
    handleSearchSubmit = () => this.init();

    // 渲染结果
    renderResultList = () => {
        let {searchType, resultDataList} = this.state;
        switch (searchType) {
            // 大匠
            case '0' :
                return resultDataList.map((item, key) => {
                    return (
                        <div
                            className="dajiang_list"
                            key={key}
                        >
                            <div className="title">
                                <img
                                    src={item.userPhotoPath}
                                    alt=""
                                    onClick={e => this.props.history.push(`/professional/${item.professionalId}`)}
                                />
                                <span>{item.professionalName}</span>
                                {item.professionalPosition}
                                <i>{item.collectionNum}人关注</i>
                            </div>
                            <div className="description">
                                简介：{item.professionalIndroduction}
                            </div>
                        </div>
                    )
                })
                break;

            // 产品
            case '1':
                return resultDataList.map((item, key) => {
                    return (
                        <div
                            className="shangpin_list"
                            key={key}
                            onClick={e => this.props.history.push(`/product/search/${item.productStyle}/${item.productId}`)}
                        >
                            <div className="head">
                                <span>{item.productAuthorName}</span>
                                {item.productTitle}
                            </div>
                            <div className="body">{item.productDesc}</div>
                            <div className="footer">
                                <span>{this.handleFilterDate(item.productUpdatedt)}</span>
                                购买量：{item.orderNum}人
                            </div>
                        </div>
                    )
                });

            // 经纪人
            case '2':
                return resultDataList.map((item, key) => {
                    return (
                        <div
                            className='broker_card'
                            key={key}
                            onClick={e => this.props.history.push(`/broker/${item.ckoKey}`)}
                        >
                            <img src={item.userPhotoPath} alt=""/>
                            <span className='ckoName'>{item.ckoNickname}</span>
                            <span>{item.ckoName}</span>

                        </div>
                    )
                })
        }
    };


    render() {
        const RadioGroup = Radio.Group;
        let state = this.state;
        return (
            <div className='page_search'>
                <div className='search_radio'>
                    <RadioGroup onChange={this.handleRadioChange} value={state.searchType}>
                        <Radio value='0'>大匠</Radio>
                        <Radio value='1'>产品</Radio>
                        <Radio value='2'>知识经纪人</Radio>
                    </RadioGroup>
                </div>
                <div className='search_condition'>
                    {this.renderSearchCondition(state.searchType)}
                </div>
                <div className='search_keyword'>
                    <Input
                        style={{width: '300px'}}
                        placeholder='请输入关键字'
                        prefix={<Icon type="search" />}
                        onChange={this.handleGetKeywordValue}
                    />
                    <Button onClick={this.handleSearchSubmit}>搜索</Button>
                </div>
                <div className='result_list'>
                    {this.state.resultDataList.length === 0
                        ? '没有搜索的结果,重新搜索..'
                        : this.renderResultList()
                    }
                </div>
            </div>
        )
    }
}