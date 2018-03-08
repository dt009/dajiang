import React from 'react';
import { ImagePicker } from 'antd-mobile';

//移动端测试ok

const data = [];

export default class ImagePickerExample extends React.Component {
  // state = {
  //   files: data,
  // }
  constructor() {
    super();
    this.state = {
      files: data,
    }
  };
  onChange(files, type, index){
    console.log(files, type, index);
    this.setState({
      files,
    });
  }
  render() {
    const { files } = this.state;
    return (
      <div>
        <ImagePicker
          files={files}
          onChange={this.onChange.bind(this)}
          onImageClick={(index, fs) => console.log(index, fs)}
          selectable={files.length < 5}
        />
      </div>
    );
  }
}

// ReactDOM.render(<ImagePickerExample />, mountNode);
