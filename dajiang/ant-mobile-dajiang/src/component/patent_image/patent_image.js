import React from 'react';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';
import {WhiteSpace, TextareaItem, Toast, Modal} from 'antd-mobile';
import Upload from 'upload/upload';
import SelectInput from 'formItem/selectInput/selectInput';
import Radio from 'formItem/radio/radio';
import Fetch from 'fetch';
import AlloyFinger from 'AlloyFinger/AlloyFinger';
const alert = Modal.alert;

const radioData = [
    {
        value: '1',
        label: '共享'
    }, {
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

export default class PatentImage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            productTitle: '',
            productPatentNumber: '',
            productAuthorName: '',
            TypeIds: '',
            Listvalue: '',
            radio: '',
            productPrice: '',
            productstate: "2",
            modal1: false,
            radio1: "2",
            defaultValue: "",
            professionalTypeId: '',
            textrev: "",
            productDesc: "",
            newList: [],
            detailListvideo: []

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

    }
    // getProfessionalTypeIdValue(){}\
  showModal = key => (e) => {
    e.preventDefault(); // 修复 Android 上点击穿透
    this.setState({[key]: true});
}
onClose = key => () => {
    this.setState({[key]: false});
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
    this.setState({radio: value})
}
componentDidMount() {
    const { productId, isSj, productStyle } = this.props.match.params;
    this.isYC(isSj)
}
isYC(type) {
    const { productId, isSj, productStyle } = this.props.match.params;
    switch (type) {
        case "1":
            var that = this;
            Fetch.post("public/product/initDocInfo/" + productId).then(res => {
                var detailList = [];
                var list1 = [];
                for (var i = 0; i < res.data.detailList.length; i++) {
                    if (res.data.detailList[i].productDetailType === 5) {
                        detailList.push(res.data.detailList[i].productPath);
                    }
                    if ((res.data.detailList[i].productDetailType === 1) || (res.data.detailList[i].productDetailType === 2) || (res.data.detailList[i].productDetailType === 3)) {
                        list1.push(res.data.detailList[i]);
                    }
                }
                if (isSj == 1) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})

                    } else {
                        that.setState({radio: "2"})
                    }
                }
                if (isSj == 2) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                if (isSj == 3) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                        $("input[value='2']").attr("disabled", "disabled")
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                this.setState({
                    productTitle: res.data.productTitle,
                    productPatentNumber: res.data.productPatentNumber,
                    productAuthorName: res.data.productAuthorName,
                    newList: detailList,
                    productPrice: res.data.productPrice,
                    defaultValue: res.data.productDesc,
                    textrev: res.data.productDesc,
                    productPatentType: res.data.productPatentType,
                    professionalTypeId: res.data.professionalTypeId,
                    productDesc: res.data.productDesc,
                    detailListvideo: list1
                })
            })
            break;
        case "2":
            var that = this;
            Fetch.post("public/product/initDocInfo/" + productId).then(res => {
                var detailList = [];
                var list2 = [];
                for (var i = 0; i < res.data.detailList.length; i++) {
                    if (res.data.detailList[i].productDetailType === 5) {
                        detailList.push(res.data.detailList[i].productPath);
                    }
                    if ((res.data.detailList[i].productDetailType === 1) || (res.data.detailList[i].productDetailType === 2) || (res.data.detailList[i].productDetailType === 3)) {
                        list2.push(res.data.detailList[i]);
                    }
                }
                if (isSj == 1) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                if (isSj == 2) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                if (isSj == 3) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                        $("input[value='2']").attr("disabled", "disabled")
                    } else {
                        that.setState({radio: "2"})
                    }
                }

                this.setState({
                    productTitle: res.data.productTitle,
                    productPatentNumber: res.data.productPatentNumber,
                    productAuthorName: res.data.productAuthorName,
                    newList: detailList,
                    productPrice: res.data.productPrice,
                    defaultValue: res.data.productDesc,
                    textrev: res.data.productDesc,
                    productPatentType: res.data.productPatentType,
                    professionalTypeId: res.data.professionalTypeId,
                    productDesc: res.data.productDesc,
                    detailListvideo: list2
                })
            })
            break;
        case "3":
            var that = this;
            Fetch.post("public/product/initDocInfo/" + productId).then(res => {
                var detailList = [];
                var list3 = [];
                for (var i = 0; i < res.data.detailList.length; i++) {
                    if (res.data.detailList[i].productDetailType === 5) {
                        detailList.push(res.data.detailList[i].productPath);
                    }
                    if ((res.data.detailList[i].productDetailType === 1) || (res.data.detailList[i].productDetailType === 2) || (res.data.detailList[i].productDetailType === 3)) {
                        list3.push(res.data.detailList[i]);
                    }
                }
                if (isSj == 1) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                if (isSj == 2) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                if (isSj == 3) {
                    if (res.data.productType == 1) {
                        that.setState({radio: "1"})
                        $("input[value='2']").attr("disabled", "disabled")
                    } else {
                        that.setState({radio: "2"})
                    }
                }
                this.setState({
                    productTitle: res.data.productTitle,
                    productPatentNumber: res.data.productPatentNumber,
                    productAuthorName: res.data.productAuthorName,
                    newList: detailList,
                    productPrice: res.data.productPrice,
                    defaultValue: res.data.productDesc,
                    textrev: res.data.productDesc,
                    productPatentType: res.data.productPatentType,
                    professionalTypeId: res.data.professionalTypeId,
                    productDesc: res.data.productDesc,
                    detailListvideo: list3
                })

            })
            break;
    }
}
getSearchTypeValue1(value) {
    this.setState({radio1: value})
}
stateClick(e) {
    this.setState({productPrice: e.target.value})
}
getProfessionalTypeIdValue(value) {
    this.setState({TypeIds: value})
}
getpatentTypeListValue(value) {
    this.setState({Listvalue: value})
}
getproductAuthorName(value) {
    this.setState({productAuthorName: value})
}
handleTextrea(e) {
    this.setState({textrev: e})
}
getproductPatentNumber(value) {
    this.setState({productPatentNumber: value})
}
getproductTitle(value) {
    this.setState({productTitle: value})
}
componentWillUpdate() {}
getProfessionalIdFrontValue(value) {
    let sss = this.state.newList.concat(value)
    this.setState({
        // professionalIdFront: value,
        newList: sss
    })
}
onLongTap(e) {

    alert('', '确定删除么???', [
        {
            text: '确定',
            onPress: () => {
                this.setState({
                    newList: this.state.newList.splice(e, 1)
                })
            }
        }, {
            text: '取消'
        }
    ])
}
getProfessionalIdFrontValue1(value) {
    this.setState({professionalIdFront1: value})
}
handleSaveSpanimage() {
    const { productId, isSj, productStyle } = this.props.match.params;
    var that = this;
    if (!Number(this.state.productPrice)) {
        Toast.fail("请正确输入", 1.5);
        return
    }
    let data = {
        productId: productId,
        productPrice: this.state.productPrice,
        productType: this.state.radio,
        productStatus: "5"
    }
    Fetch.post('private/myshop/updateOnSaleProductPrice', data).then(res => {
        if (res.flag == "1") {
            Toast.success(res.message, 1.5);

            that.props.history.push('/index/myshop/1');
        } else {
            Toast.fail(res.message, 1.5);
        }
    })
}
handleSave() {
    const { productId, isSj, productStyle } = this.props.match.params;
    var that = this;
    if (!Number(this.state.productPrice)) {
        Toast.fail("请正确输入", 1.5);
        return
    }
    let data = {
        productId: productId,
        productPrice: this.state.productPrice,
        productType: this.state.radio,
        productStatus: "6"
    }
    Fetch.post('private/myshop/updateOnSaleProductPrice', data).then(res => {
        if (res.flag == "1") {
            Toast.success(res.message, 1.5);

            that.props.history.push('/index/myshop/1');
        } else {
            Toast.fail(res.message, 1.5);
        }
    })

}
isSave(type) {
    switch (type) {
        case "1":
            return (
                <div className="bc_sj">
                    <span className="handle_patent" onClick={this.handleSave}>保存</span>

                </div>
            )
        case "2":
            return (
                <div className="bc_sj">
                    <span className="gx_title" onClick={this.handleSaveSpanimage.bind(this)}>保存</span>
                    <span className="sj_title" onClick={this.handleSave}>上架</span>
                </div>
            )
        case "3":
            return (
                <div className="bc_sj">
                    <span className="handle_patent" onClick={this.handleSave}>保存</span>

                </div>
            )
    }
}

render() {
    console.log( this.state );
    const { productId, isSj, productStyle } = this.props.match.params;
    let video = this.state.detailListvideo.map((index, key) => {
        return (
            <div key={key}>
                <div className="uploadbideo">上传的可读文件</div>
                <div>
                    <a href={index.productDetailUrl}>{index.productDetailTitle}</a>
                </div>
            </div>
        )
    })
    let isSave = this.isSave(isSj);
    let upload = isSj == "1"
        ? <Upload type="photograph" id="photo_box1" imgSrc={this.state.professionalIdFront} container="photograph_box1" content="必填" change={this.getProfessionalIdFrontValue}/>
        : ""
    let textItem = isSj == "1"
        ? <TextareaItem rows={6} editable onChange={this.handleTextrea.bind(this)} value={this.state.textrev} placeholder="请输入设计方案介绍"/>
        : <TextareaItem rows={6} disabled onChange={this.handleTextrea.bind(this)} value={this.state.textrev} placeholder="请输入设计方案介绍"/>
    let head = isSj == "1"
        ? <div className="lb_title">
                <TextInput label="标题" placeholder="请输入标题" //   disabled = {url[2]}
                    textValue={this.state.productTitle} type="text" changeTextValue={this.getproductTitle}/>

                <TextInput label="作者" placeholder="请输入作者" textValue={this.state.productAuthorName} type="text" changeTextValue={this.getproductAuthorName}/>
            </div>
        : <div className="lb_title">
            <TextInput label="标题" placeholder="请输入标题" //   disabled = {url[2]}
                readOnly={isSj == "1"
                ? "true"
                : "false"} textValue={this.state.productTitle} type="text" changeTextValue={this.getproductTitle}/>
            <TextInput label="作者" placeholder="请输入作者" textValue={this.state.productAuthorName} readOnly={isSj == "1"
                ? "true"
                : "false"} type="text" changeTextValue={this.getproductAuthorName}/>
        </div>
    return (
        <div>
            <BackHeader title="图文知识" path='/index/myshop/1'/>

            <div className="title">
                {head}

                {this.state.newList.map((item, key) => {
                    return (
                        <div key={key} className="news">
                            <AlloyFinger key={key} onLongTap={this.onLongTap.bind(this, key)}>
                                <img src={item}/>
                            </AlloyFinger>
                        </div>
                    )
                })
}

                {upload}
                {video}
                <WhiteSpace size="sm"/>
                <div className="productDesc">
                    <div>
                        <span className="bj_title">编辑设计方案介绍</span>
                        <span></span>
                    </div>
                    <div className=".wbk_body">
                        {textItem}
                    </div>
                </div>
                <div className="money">
                    <span className="jg">价格：</span>
                    <span className="money_2">￥<span><input type="text" className="text" placeholder={''} value={this.state.productPrice} onChange={this.stateClick}/></span>
                        <span>(此价格含20%佣金)</span>
                    </span>
                </div>
                <div className="fl_title">
                    <div className="gx_sq">
                        <Radio s data={radioData} name="search" value={this.state.radio} getRadioValue={this.getSearchTypeValue}/>
                    </div>
                </div>

                {isSave}
            </div>
        </div>
    )
}
}
