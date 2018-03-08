import React from 'react';
import {List, Checkbox, TextareaItem} from 'antd-mobile';
const CheckboxItem = Checkbox.CheckboxItem;
import {WhiteSpace} from 'antd-mobile';
import './feedback.less';
import Fetch from 'fetch';
import BackHeader from '../../../../common/backHeader/backHeader.js';
import Radio from 'formItem/radio/radio';
import {Toast} from 'antd-mobile';

//这里是feedback问题反馈的界面
export default class Feedback extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            radioValue: '1',
            userId: null,
            textre: ""
        };
        this.getRadioValue = this.getRadioValue.bind(this);

    }
    handleClick() {
        let that = this;
        let data = {
            feedbackType: this.state.radioValue,
            feedbackContent: this.state.textre
        }
        Fetch.post('/private/user/feedback', data).then(res => {
            if (res.flag === 1) {
                Toast.success('提交成功', 1.5);
                setTimeout(() => {
                    that.props.history.push('/index/my');
                }, 1000);
            } else {
                Toast.fail(res.message, 1.5);
            }
        })
    };
    handleRadioValueChange() {}
    handleTextrea(e) {
        this.setState({textre: e})
    }
    getRadioValue(value) {
        this.setState({radioValue: value})
    }
    componentDidMount() {
        function getCookie(name) {
            var arr,
                reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg))
                return unescape(arr[2]);
            else
                return null;
            }
        this.setState({userId: getCookie("userId")})
    }
    componentDidUpdate() {}

    render() {
        const data = [
            {
                value: '1',
                label: '系统反馈'
            }, {
                value: '2',
                label: '上架反馈'
            }, {
                value: '3',
                label: '其他反馈'
            }
        ];

        return (
            <div className="component_feedback">
                <BackHeader title="问题反馈" path="/system_setting"/>

                <div className="feedback">
                    <div className="feedback_header">
                        <div className="feedback_title">
                            反馈种类
                        </div>
                        <WhiteSpace size="lg"/>
                        <Radio data={data} value={this.state.radioValue} getRadioValue={this.getRadioValue} // title="1"
                        />
                    </div>
                    <div style={{
                        padding: "0.4rem"
                    }}>反馈</div>
                    <TextareaItem rows={6} placeholder="不可超过二百字" onBlur={this.handleTextrea.bind(this)}/>
                    <WhiteSpace size="lg"/>
                    <div className="subButton" onClick={this.handleClick.bind(this)}>提交</div>
                </div>
            </div>
        );
    };
}
