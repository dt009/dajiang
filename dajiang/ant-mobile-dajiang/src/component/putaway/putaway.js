import React from 'react';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';
import {WhiteSpace, TextareaItem, Toast, Modal} from 'antd-mobile';
import Upload from 'upload/upload';
import SelectInput from 'formItem/selectInput/selectInput';
import Radio from 'formItem/radio/radio';
import Fetch from 'fetch';
import './putaway.less';
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

export default class Putaway extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            productTitle: '',
            productPatentNumber: '',
            productAuthorName: '',
            TypeIds: '',
            Listvalue: '',
            radio: '',
            textre: '',
            productPrice: '',
            productstate: "2",
            modal1: false,
            radio1: "2",
            defaultValue: "",
            professionalTypeId: '',
            textrev: "",
            productDesc: "",
            newList: []
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
onLongTap(e) {
    alert('', '确定删除么???', [
        {
            text: '确定',
            onPress: () => {
                console.log("2")
                console.log(this.state.newList.splice(e, 1))
                this.setState({
                    newList: this.state.newList.splice(e, 1)
                })
            }
        }, {
            text: '取消',
            onPress: () => console.log('cancel')
        }
    ])
}
onClose = key => () => {
    this.setState({[key]: false});
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
    var url = this.props.location.pathname.split("/");
    Fetch.post("public/product/initPatentInfo/" + url[2]).then(res => {
        if (res.data.productType == 1) {
            this.setState({radio: "1"})
            $("input[value='2']").attr("disabled", "disabled")
        }
        var detailList = [];
        for (var i = 0; i < res.data.detailList.length; i++) {
            detailList.push(res.data.detailList[i].productPath)
        }
        this.setState({
            productTitle: res.data.productTitle,
            productPatentNumber: res.data.productPatentNumber,
            productAuthorName: res.data.productAuthorName,
            newList: detailList,

            productPrice: res.data.productPrice,
            //    radio:res.data.productType,
            defaultValue: res.data.productDesc,
            productPatentType: res.data.productPatentType,
            professionalTypeId: res.data.professionalTypeId,
            professionalTypeId: res.data.professionalTypeId,
            productDesc: res.data.productDesc
        })
    })
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
    this.setState({textre: e})
}
getproductPatentNumber(value) {
    this.setState({productPatentNumber: value})
}
getproductTitle(value) {
    this.setState({productTitle: value})
}
componentWillUpdate() {
}
getProfessionalIdFrontValue(value) {
    let sss = this.state.newList.concat(value)
    this.setState({newList: sss})
}
getProfessionalIdFrontValue1(value) {
    this.setState({professionalIdFront1: value})
}
handlePutaway() {
    var that = this;
    var url = this.props.location.pathname.split("/");

    let data = {
        productId: url[2],
        productPrice: this.state.productPrice,
        productType: this.state.radio,
        productStatus: "6"
    }
    Fetch.post('private/myshop/updateOnSaleProductPrice', data).then(res => {
        if (res.flag == "1") {
            Toast.success(res.message, 1.5);

            that.props.history.push('/index/myshop/0');
        } else {
            Toast.fail(res.message, 1.5);
        }
    })
}
handleSaveSpan() {
    var url = this.props.location.pathname.split("/");
    var that = this;
    if (this.state.newList == "") {
        Toast.fail("最少上传一张专利图片", 1.5);
    }
    var dataList = [];
    for (var i = 0; i < this.state.newList.length; i++) {
        dataList.push({"productPath": this.state.newList[i]})
    }
    var data = {
        detailApplyList: dataList,
        productAuthorName: this.state.productAuthorName,
        productDesc: this.state.textre,
        productPatentNumber: this.state.productPatentNumber,
        productPrice: this.state.productPrice,
        productPatentType: this.state.Listvalue[0],
        professionalTypeId: this.state.TypeIds[1],
        productType: this.state.radio,
        productTitle: this.state.productTitle,
        productStatus: 1,
        productId: url[2]
    }

    if (this.state.productPrice == "") {
        Toast.fail("请输入金额", 1.5);
        return

    }
    Fetch.post('private/myshop/updatePatentApplyProduct', data).then(res => {
        if (res.flag == "1") {
            Toast.success(res.message, 1.5);

            that.props.history.push('/index/myshop/0');
        } else {
            Toast.fail(res.message, 1.5);
        }

    })
}
handleSave() {
    var url = this.props.location.pathname.split("/");
    var that = this;
    if (this.state.professionalIdFront == "") {
        Toast.fail("最少上传一张专利图片", 1.5);
    }
    var that = this;
    if (this.state.newList == "") {
        Toast.fail("最少上传一张专利图片", 1.5);
    }
    var dataList = [];
    for (var i = 0; i < this.state.newList.length; i++) {
        dataList.push({"productPath": this.state.newList[i]})
    }
    var data = {
        detailApplyList: dataList,
        productAuthorName: this.state.productAuthorName,
        productDesc: this.state.textre,
        productPatentNumber: this.state.productPatentNumber,
        productPrice: this.state.productPrice,
        productPatentType: this.state.Listvalue[0],
        professionalTypeId: this.state.TypeIds[1],
        productType: this.state.radio,
        productTitle: this.state.productTitle,
        productStatus: 1,
        productId: url[2]
    }

    Fetch.post('private/myshop/updatePatentApplyProduct', data).then(res => {
        if (res.flag == "1") {
            Toast.success(res.message, 1.5);
            that.props.history.push('/index/myshop/0');
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
                    <span className="gx_title" onClick={this.handleSaveSpan.bind(this)}>保存</span>
                    <span className="sj_title" onClick={this.handleSave}>上架</span>
                </div>
            )
        case "2":
            return (
                <div className="bc_sj">
                    <span className="handle_patent" onClick={this.handleSave}>保存</span>
                </div>
            )
    }
}

render() {
    var url = this.props.location.pathname.split("/");
    let isSave = this.isSave(url[3]);
    var url = this.props.location.pathname.split("/");
    return (
        <div>
            <BackHeader title="专利技术" path='/index/myshop/0'/>

            <div className="title">
                <div className="lb_title">
                    <TextInput label="标题" placeholder="请输入标题" //   disabled = {url[2]}
                        textValue={this.state.productTitle} type="text" readOnly changeTextValue={this.getproductTitle}/>
                    <TextInput label="专利号" placeholder="请输入专利号" textValue={this.state.productPatentNumber} readOnly={url[2] == "1"
                        ? "true"
                        : "false"} type="text" changeTextValue={this.getproductPatentNumber}/>
                    <TextInput label="作者" placeholder="请输入作者" textValue={this.state.productAuthorName} readOnly={url[2] == "1"
                        ? "true"
                        : "false"} type="text" changeTextValue={this.getproductAuthorName}/>
                </div>

                {this.state.newList.map((item, key) => {
                    return (
                        <div key={key} className="news">
                            <img src={item}/>
                        </div>
                    )
                })
}

                <WhiteSpace size="sm"/>
                <div className="productDesc">
                    <div>
                        <span className="bj_title">编辑设计方案介绍</span>
                        <span></span>
                    </div>
                    <div className=".wbk_body">
                        <TextareaItem rows={6} disabled={url[2] == "1"
                            ? "true"
                            : "false"} onBlur={this.handleTextrea.bind(this)} placeholder={this.state.defaultValue}/>
                    </div>
                </div>
                <div className="money">
                    <span className="jg">价格：</span>
                    <span className="money_2">￥<span><input type="text" className="text" placeholder={this.state.productPrice} onBlur={this.stateClick}/></span>
                        <span>(此价格含20%佣金)</span>
                    </span>
                </div>
                <div className="fl_title">

                    <div className="gx_sq">
                        <Radio data={radioData} name="search" value={this.state.radio == 1
                            ? "1"
                            : "2"} getRadioValue={this.getSearchTypeValue}/>
                    </div>
                </div>

                <div className="putaway_price" onClick={this.handlePutaway.bind(this)}>保存</div>
            </div>
        </div>
    )
}
}
