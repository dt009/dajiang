/**
 * @author wackeCq
 * @file
 * @date 17/9/19 下午5:12
 */
import React, {Component} from 'react';
import {WingBlank, WhiteSpace} from 'antd-mobile';
import RegistForget from './regist_forget/regist_forget';
import "./register.less";//register css

const PlaceHolder = props => (
  <div style={{
    backgroundColor: '#ebebef',
    color: '#bbb',
    textAlign: 'center',
    height: '0.6rem',
    lineHeight: '0.6rem',
    width: '100%'
  }} {...props}>Block</div>
);

export default class Register extends Component {
  constructor() {
    super();
    this.state = {
      placeholder: '123'
    }
  };
  render() {
    let subRegist = this.props.location.search;
    const hashsearch = this.props.location.pathname.substring(this.props.location.pathname.length-1) == 0
    ? <div className="register_title">注册</div>
    : <div className="register_title">忘记密码</div>

    return (
      <div>
        <div className="register_forget">
          <div style={{
            padding: '1.2rem 0 0 0'
          }}>
            <WingBlank>
              {hashsearch}
            </WingBlank>
            <WingBlank size="md">
              <div className="register_container"></div>
            </WingBlank>
            <WingBlank size="sm">
              <RegistForget hashsearch={subRegist}  path={this.props.location.pathname} />
            </WingBlank>
          </div>
        </div>
      </div>
    )
  }
}
