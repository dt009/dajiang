import React from 'react';
import BackHeader from 'backHeader/backHeader';
import TextInput from 'formItem/textInput/textInput';
import {WhiteSpace,TextareaItem ,Toast,Modal} from 'antd-mobile';
import Upload from 'upload/upload';
// import {Toast,Modal} from 'antd-mobile';
import SelectInput from 'formItem/selectInput/selectInput';
import Radio from 'formItem/radio/radio';
import Fetch from 'fetch';
import AlloyFinger from 'AlloyFinger/AlloyFinger'
const alert = Modal.alert;

import './publish.less'

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
    },{
        value:"3",
        label:"是"
    }
];

export default class Publish extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      productTitle:'',
      productPatentNumber:'',
      productAuthorName:'',
      TypeIds:'',
      Listvalue:'',
      radio:'1',
      textre:'',
      productPrice:'',
      productstate:"2",
      modal1:false,
      radio1:"2",
      newList:[],
      professionalIdFront:""

    }
    this.getproductTitle  = this.getproductTitle.bind(this);
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
  getSearchTypeValue(value){
    this.setState({
      radio:value
    })
  }
  onLongTap(e){
    console.log(e)


    alert('', '确定删除么???', [
    { text: '确定', onPress: () => {
        this.setState({
          newList:this.state.newList.splice(e,1)
        });
    } },
    { text: '取消', onPress: () => console.log('cancel') },

  ])
  }
  getSearchTypeValue1(value){
    this.setState({
      radio1:value
    })
  }
  stateClick(e){
    //   console.log(e.target.value)
      this.setState({
          productPrice:e.target.value
      })
  }
  getProfessionalTypeIdValue(value) {
    console.log(value)
      this.setState({
          TypeIds: value
      })
  }
  getpatentTypeListValue(value){
    this.setState({
      Listvalue:value
    })
  }
  getproductAuthorName(value){
    this.setState({
      productAuthorName:value
    })
  }
  handleTextrea(e){
      this.setState({
          textre:e
      })
  }
  getproductPatentNumber(value){
    this.setState({
      productPatentNumber:value
    })
  }
  getproductTitle(value){
    this.setState({
      productTitle:value
    })
  }
  componentWillUpdate(){
      console.log(this.state)
  }
  getProfessionalIdFrontValue(value){
    console.log(value);
    let sss = this.state.newList.concat(value)
    console.log(sss);
    this.setState({
        // professionalIdFront: value,
        newList:sss
    })

  }
  getProfessionalIdFrontValue1(value){
    this.setState({
        professionalIdFront1: value
    })
  }
  handleSaveSpan(){
    var that =this;
    if(!Number(this.state.productPrice)){
        Toast.fail("请正确输入", 1.5);
        return
    }
    if(this.state.newList == ""){
        Toast.fail("最少上传一张专利图片", 1.5);
        return
    }
    var  dataList = [];
    for(var i=0;i<this.state.newList.length;i++){
     dataList.push({"productPath":this.state.newList[i]})
    }
    var data = {
               detailApplyList:dataList,
               productAuthorName:this.state.productAuthorName,
               productDesc:this.state.textre,
               productPatentNumber:this.state.productPatentNumber,
               productPrice:this.state.productPrice,
               productPatentType:this.state.Listvalue[0],
               professionalTypeId:this.state.TypeIds[1],
               productType:this.state.radio,
               productTitle:this.state.productTitle,
               productStatus:1
           }

      if(this.state.productPrice == ""){
          Toast.fail("请输入金额", 1.5);
          return

      }
      Fetch.post('private/myshop/savePatentApplyProduct',data).then(res => {
        if(res.flag == "1"){
            that.props.history.push('/index/myshop/0');
        }else{
            Toast.fail(res.message, 1.5);
        }


      })
  }
  handleSave(){
       var that =this;
       if(!Number(this.state.productPrice)){
           Toast.fail("请正确输入", 1.5);
           return
       }
       if(this.state.newList == ""){
           Toast.fail("最少上传一张专利图片", 1.5);
           return
       }
       var  dataList = [];
       for(var i=0;i<this.state.newList.length;i++){
        dataList.push({"productPath":this.state.newList[i]})
       }
       var data = {
                  detailApplyList:dataList,
                  productAuthorName:this.state.productAuthorName,
                  productDesc:this.state.textre,
                  productPatentNumber:this.state.productPatentNumber,
                  productPrice:this.state.productPrice,
                  productPatentType:this.state.Listvalue[0],
                  professionalTypeId:this.state.TypeIds[1],
                  productType:this.state.radio,
                  productTitle:this.state.productTitle,
                  productStatus:3
              }
      Fetch.post('private/myshop/savePatentApplyProduct',data).then(res => {
          if(res.flag == "1"){
              that.props.history.push('/index/myshop/0');
          }else{
              Toast.fail(res.message, 1.5);
          }

      })

  }

  render(){
    return(
      <div>
        <BackHeader title="专利技术" path='/index/myshop/0'/>
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
          return(<div key={key} className="news">
            <AlloyFinger
                key={key}
                onLongTap={this.onLongTap.bind(this,key)}
            >
              <img src={item}/>
            </AlloyFinger>
          </div>
        )
        })
      }

          <Upload
              type="photograph"
              id="photo_box1"
              imgSrc={this.state.professionalIdFront}
              container="photograph_box1"
              content="必填"
              change={this.getProfessionalIdFrontValue}
          />

          <WhiteSpace size="sm"/>
          <div className="productDesc">
            <div>
              <span className="bj_title">编辑设计方案介绍</span>
              <span></span>
            </div>
            <div className=".wbk_body">
              <TextareaItem
                  rows={6}
                  placeholder="不可超过二百字"
                  onBlur={this.handleTextrea.bind(this)}
              />
            </div>
          </div>
          <div className="money">
            <span className="jg">价格：</span>
            <span className="money_2">￥<span><input type="text" className="text" placeholder={this.state.productPrice} onBlur={this.stateClick}/></span><span>(此价格含20%佣金)</span></span>
          </div>
          <div className="fl_title">
            <SelectInput
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
            />
            <div className="gx_sq">
              <Radio
                  data={radioData}
                  name="search"
                  value={this.state.radio}
                  getRadioValue={this.getSearchTypeValue}
              />
            </div>
          </div>
          <div className="bc_sj">
            <span className="gx_title" onClick={this.handleSaveSpan.bind(this)}>保存</span>
            <span className="sj_title"  onClick={this.handleSave}>上架</span>
          </div>
        </div>
      </div>
    )
  }
}
