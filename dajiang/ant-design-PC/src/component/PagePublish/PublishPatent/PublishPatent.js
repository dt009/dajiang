

import React from 'react';
// import Fetch from '../../common/Fetch/Fetch';
import Fetch from '../../../common/Fetch/Fetch';
// import TextInput from './children/textInput/textInput'
import TextInput from '../../../common/FormItem/TextInput/TextInput';
import ImgUpload from '../../../common/imgUpload/imgUpload'
import { Input } from 'antd';
const { TextArea } = Input;
import { Radio } from 'antd';
const RadioGroup = Radio.Group;
import './PublishPatent.less';
import { Cascader } from 'antd';


const radioData = [
    {
        value: '1',
        label: '共享'
    },
    {
        value: "2",
        label: '授权'
    }
];
const radioData1 = [
    {
        value: '2',
        label: '否'
    }, {
        value: "3",
        label: "是"
    }
];

export default class PublishPatent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            productTitle: '',
            productPatentNumber: '',
            productAuthorName: '',
            TypeIds: '',
            Listvalue: '',
            radio: '1',
            textre: '',
            productPrice: '',
            productstate: "2",
            modal1: false,
            radio1: "2",
            newList: [],
            professionalIdFront: "",
            radioValue: 1,
            queryPatentType:[],
            queryProductStyle:[],
            professionalFirstOptions:[],
            professionalTypeIds: [],
            handleChangeCityCodeIds:[]           
            

        }
        this.getproductTitle = this.getproductTitle.bind(this);
        this.getproductPatentNumber = this.getproductPatentNumber.bind(this);
        this.getproductAuthorName = this.getproductAuthorName.bind(this);
        this.getProfessionalTypeIdValue = this.getProfessionalTypeIdValue.bind(this);
        this.getpatentTypeListValue = this.getpatentTypeListValue.bind(this);
        this.getSearchTypeValue = this.getSearchTypeValue.bind(this)
        this.getProfessionalIdFrontValue = this.getProfessionalIdFrontValue.bind(this);
        this.getProfessionalIdFrontValue1 = this.getProfessionalIdFrontValue1.bind(this);
        this.stateClick = this.stateClick.bind(this);
        this.getSearchTypeValue1 = this.getSearchTypeValue1.bind(this);
        this.handleSave = this.handleSave.bind(this);
        this.onChange = this.onChange.bind(this);
        this.gethandleChangeCityCodeIds = this.gethandleChangeCityCodeIds.bind(this)


    }
    // getProfessionalTypeIdValue(){}\
    showModal = key => (e) => {
        e.preventDefault(); // 修复 Android 上点击穿透
        this.setState({
            [key]: true,
        });
    }
    onClose = key => () => {
        this.setState({
            [key]: false,
        });
        // alert(1);
        this.handleSave()
    }
    onWrapTouchStart = (e) => {
        // fix touch to scroll background page on iOS
        if (!/iPhone|iPod|iPad/i.test(navigator.userAgent)) {
            return;
        }
        const pNode = closest(e.target, '.am-modal-body');
        if (!pNode) {
            e.preventDefault();
        }
    }
    getSearchTypeValue(value) {
        this.setState({
            radio: value
        })
    }
    onLongTap(e) {
        console.log(e)


        alert('', '确定删除么???', [
            {
                text: '确定', onPress: () => {
                    this.setState({
                        newList: this.state.newList.splice(e, 1)
                    });
                }
            },
            { text: '取消', onPress: () => console.log('cancel') },

        ])
    }
    getSearchTypeValue1(value) {
        this.setState({
            radio1: value
        })
    }
    componentDidMount() {
        // 获取大匠的第一级分类的操作
        Fetch.get('public/dict/queryPatentType', {}).then(res => {
            let { flag, data } = res;
            if (flag === 1) {
                let options = [];
                data.forEach(item => {
                    options.push({
                        label: item.itemValue,
                        value: item.itemCode,
                        isLeaf: false,
                    })
                });
                console.log(options)
                this.setState({
                    queryPatentType: options
                })
            } else {
                message.error(res.message)
            }
        });
        let { params } = this.props.match;
        let searchType = params.searchType;
        this.setState({
            searchType
        });

        // 获取大匠的第一级分类的操作
        Fetch.get('public/professionalType/queryByPid/0', {}).then(res => {
            let { flag, data } = res;
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
    }
    // 获取大匠二级分类的函数
    fetchProfessionalSecondClassify = selectedOptions => {
        let PID = selectedOptions[0].value;
        const targetOption = selectedOptions[selectedOptions.length - 1]
        targetOption.loading = true;

        Fetch.get(`public/professionalType/queryByPid/${PID}`, {}).then(res => {
            targetOption.loading = false;
            let { flag, data } = res;
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
            let { flag, data } = res;
            if (flag === 1) {
                that.setState({
                    resultDataList: data.list
                })
            } else {
                message.error('请求错误, 重新检查搜索条件')
            }
        })
    };
    stateClick(e) {
        //   console.log(e.target.value)
        this.setState({
            productPrice: e.target.value
        })
    }
    getProfessionalTypeIdValue(value) {
        console.log(value)
        this.setState({
            TypeIds: value
        })
    }
    getpatentTypeListValue(value) {
        this.setState({
            Listvalue: value
        })
    }
    getproductAuthorName(value) {
        this.setState({
            productAuthorName: value
        })
    }
    handleChangeProfessionalTypeIds = (value, selectedOptions) => {
        let ids = [value[value.length - 1]];
        this.setState({
            professionalTypeIds: ids
        })
    };
    handleTextrea(e) {
        console.log(e.target.value);
        this.setState({
            textre: e.target.value
        })
    }
    getproductPatentNumber(value) {
        this.setState({
            productPatentNumber: value
        })
    }
    getproductTitle(value) {
        this.setState({
            productTitle: value
        })
    }
    componentWillUpdate() {
        console.log(this.state)
    }
    getProfessionalIdFrontValue(value) {
        console.log(value);
        let sss = this.state.newList.concat(value)
        console.log(sss);
        this.setState({
            // professionalIdFront: value,
            newList: sss
        }, () => {
            console.log(this.state.newList);
        })

    }
    getProfessionalIdFrontValue1(value) {
        this.setState({
            professionalIdFront1: value
        })
    }
    gethandleChangeCityCodeIds(value){
        console.log(value);
        this.setState({
            handleChangeCityCodeIds: value
        })
    }
    handleSaveSpan() {
        var that = this;
        if (!Number(this.state.productPrice)) {
            Toast.fail("请正确输入", 1.5);
            return
        }
        if (this.state.newList == "") {
            Toast.fail("最少上传一张专利图片", 1.5);
            return
        }
        var dataList = [];
        for (var i = 0; i < this.state.newList.length; i++) {
            dataList.push({ "productPath": this.state.newList[i] })
        }
        var data = {
            detailApplyList: dataList,
            productAuthorName: this.state.productAuthorName,
            productDesc: this.state.textre,
            productPatentNumber: this.state.productPatentNumber,
            productPrice: this.state.productPrice,
            productPatentType: this.state.handleChangeCityCodeIds[0],
            professionalTypeId: this.state.professionalTypeIds[0],
            productType: this.state.radioValue,
            productTitle: this.state.productTitle,
            productStatus: 1
        }

        if (this.state.productPrice == "") {
            Toast.fail("请输入金额", 1.5);
            return

        }
        Fetch.post('private/myshop/savePatentApplyProduct', data).then(res => {
            if (res.flag == "1") {
                that.props.history.push('/shop/1');
            } else {
                Toast.fail(res.message, 1.5);
            }


        })
    }
    onChange = (e) => {
        console.log('radio checked', e.target.value);
        this.setState({
            radioValue: e.target.value,
        });
    }
    
    handleSave() {
        var that = this;
        if (!Number(this.state.productPrice)) {
            Toast.fail("请正确输入", 1.5);
            return
        }
        if (this.state.newList == "") {
            Toast.fail("最少上传一张专利图片", 1.5);
            return
        }
        var dataList = [];
        for (var i = 0; i < this.state.newList.length; i++) {
            dataList.push({ "productPath": this.state.newList[i] })
        }
        var data = {
            detailApplyList: dataList,
            productAuthorName: this.state.productAuthorName,
            productDesc: this.state.textre,
            productPatentNumber: this.state.productPatentNumber,
            productPrice: this.state.productPrice,
            productPatentType: this.state.handleChangeCityCodeIds[0],
            professionalTypeId: this.state.professionalTypeIds[0],
            productType: this.state.radioValue,
            productTitle: this.state.productTitle,
            productStatus: 3
        }
        Fetch.post('private/myshop/savePatentApplyProduct', data).then(res => {
            if (res.flag == "1") {
                that.props.history.push('/shop/0');
            } else {
                Toast.fail(res.message, 1.5);
            }

        })

    }
    render() {
        return (
            <div>
                <div className="title">
                    <div className="lb_title">
                        <TextInput
                            label="标题"
                            placeholder="请输入标题"
                            textValue={this.state.productTitle}
                            type="text"
                            changeTextValue={this.getproductTitle}
                        />
                        <TextInput
                            label="专利号"
                            placeholder="请输入专利号"
                            textValue={this.state.productPatentNumber}
                            type="text"
                            changeTextValue={this.getproductPatentNumber}
                        />
                        <TextInput
                            label="作者"
                            placeholder="请输入作者"
                            textValue={this.state.productAuthorName}
                            type="text"
                            changeTextValue={this.getproductAuthorName}
                        />
                    </div>
                    {this.state.newList.map((item, key) => {
                        return (
                        <div key={key} className="news">
                            <img src={item} />
                        </div>
                        )
                    })
                    }

                    <ImgUpload
                        type="photograph"
                        MyId="photo_box1"
                        Width="200px"
                        Height="200px"
                        Image={'http://owu66z9w4.bkt.clouddn.com/o_1bsqbf3rv1g001cp7tk11q281hid41.jpg'}
                        container="photograph_box1"
                        content="必填"
                        change={this.getProfessionalIdFrontValue}
                    />

                    <div className="productDesc">
                        <div>
                            <span className="bj_title">编辑设计方案介绍</span>
                            <span></span>
                        </div>
                        <div className=".wbk_body">
                            <TextArea
                                rows={6}
                                placeholder="不可超过二百字"
                                onBlur={this.handleTextrea.bind(this)}
                            />
                        </div>
                    </div>
                    <div className="money">
                        <span className="jg">价格：</span>
                        <span className="money_2">￥<span><input type="text" className="text" placeholder={this.state.productPrice} onBlur={this.stateClick} /></span><span>(此价格含20%佣金)</span></span>
                    </div>
                    <div className="fl_title">
                        {/* <SelectInput
                            data={window.LIST.patentTypeLsit}
                            title="专利分类"
                            label="专利分类 :"
                            cols={1}
                            getChangeSelectValue={this.getpatentTypeListValue}
                        />
                        <SelectInput
                            data={window.LIST.professionalTypeList}
                            title="选择专业"
                            label="专业分类 :"
                            cols={2}
                            getChangeSelectValue={this.getProfessionalTypeIdValue}
                       />*/}
                        <div className="cityDiv">
                            <span >专利分类</span>
                            <Cascader className="cascader"
                                options={this.state.queryPatentType}
                                onChange={this.gethandleChangeCityCodeIds}
                                changeOnSelect={true}
                            />
                        </div>
                        <div className="cityDiv">
                            <span >专业分类</span>
                            <Cascader className="cascader"
                                options={this.state.professionalFirstOptions}
                                // loadData={this.fetchProvinceSecond}
                                loadData={this.fetchProfessionalSecondClassify}

                                onChange={this.handleChangeProfessionalTypeIds}
                                changeOnSelect={true}
                            />
                        </div>
                       
                        <div className="gx_sq">
                            {/*<Radio
                                data={radioData}
                                name="search"
                                value={this.state.radio}
                                getRadioValue={this.getSearchTypeValue}
                            />*/}
                            <RadioGroup onChange={this.onChange} value={this.state.radioValue}>
                                <Radio value={1}>共享</Radio>
                                <Radio value={2}>授权</Radio>
                            </RadioGroup>
                        </div>
                    </div>
                    <div className="bc_sj">
                        <span className="gx_title" onClick={this.handleSaveSpan.bind(this)}>保存</span>
                        <span className="sj_title" onClick={this.handleSave}>上架</span>
                    </div>
                </div>
                
            </div>
                )
    }
}
