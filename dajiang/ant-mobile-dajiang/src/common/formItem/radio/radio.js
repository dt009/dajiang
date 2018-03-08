/**
 * @author v_duantao
 * @file 单选框组件
 * @date 17/9/29 上午11:21
 */

import React, {Component} from 'react';
import './radio.less';

/**
 * @description     单选框组件(简版, 没有禁用)
 * @param       value        默认值
 * @param       getRadioValue       父子组件间传值函数
 * @param       data        数据源  array
 * @param       title       显示的 label标题
 *
 */

export default class Radio extends Component {
    constructor(props) {
        super(props);
        this.state = {
            radioValue: props.value,
        };

        this.handleRadioValueChange = this.handleRadioValueChange.bind(this);
    }

    componentDidUpdate() {
        // console.log(this.state);
    }

    componentWillUpdate() {
        this.state.radioValue = this.props.value;
        // this.setState({
        //     radioValue: this.props.value
        // }, () => {
            console.log(this.state);
        // });
    }

    // componentDidMount() {
    //     if (this.props.value) {
    //         this.setState({
    //             radioValue: this.props.value
    //         })
    //     }
    // }

    handleRadioValueChange(e) {
        let target = e.target;
        let value = target.value;
        this.props.getRadioValue(value);

        this.setState({
            radioValue: value,
        })
    }


    render() {
        let props = this.props;
        return (
            <div className="common_radio">
                {
                    props.title ? (
                        <div className="radio_title">
                            {props.title}
                        </div>
                    ) : ''
                }
                <div className="radio_content">
                    {
                        props.data.map((item, key) => {
                            return (
                                <div className="radio_list" key={key}>
                                    <label className="radio_item">
                                        <input type="radio" name={props.name || "text"} checked={item.value === this.state.radioValue}
                                               value={item.value} onChange={this.handleRadioValueChange}/>
                                        <span>{item.label}</span>
                                    </label>
                                </div>
                            )
                        })
                    }
                </div>
            </div>
        )
    }
}
