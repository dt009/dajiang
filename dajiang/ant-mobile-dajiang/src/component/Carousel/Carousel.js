import { Carousel, WhiteSpace, WingBlank } from 'antd-mobile';
import React  from 'react';
import "./Carousel.less"
import Fetch from 'fetch';


export default class AppCaro extends React.Component {
  constructor() {
  super();
    this.state = {
      data: [],
      initialHeight: 200,
    };
};
    componentWillUpdate(){
        console.log(this.state)
    }

  componentDidMount() {

      // 获取轮播图的组件
      Fetch.get("public/banner/initBanners").then(res => {
          console.log(res)
          var arr=[]
          res.data.map(function(index,key){
            //   console.log(res.data.detailList[key].productPath)
              arr.push(res.data[key].recommentImagPath)

          })
          this.setState({
              data:arr
          })
      })
    //   Fetch.get('public/banner/initBanners').then(res => {
    //       console.log(res);
    //       this.setState({
    //           data: res.data
    //       })
    //   });
    // simulate img loading
    // setTimeout(() => {
    //   this.setState({
    //     data: ['AiyWuByWklrrUDlFignR', 'TekJlZRVCjLFexlOCuWn', 'IJOtIlfsYdTyaDTRVrLI'],
    //   });
    // }, 100);
  }
  render() {
    const hProp = this.state.initialHeight ? { height: this.state.initialHeight } : {};
    return (
      <div className="comCar">
        <WingBlank>
          {/* <div className="sub-title">normal</div> */}
          <Carousel
            className="my-carousel"
            autoplay={true}
            infinite
            selectedIndex={1}
            swipeSpeed={35}
            // beforeChange={(from, to) => console.log(`slide from ${from} to ${to}`)}
            // afterChange={index => console.log('slide to', index)}
          >
            {this.state.data.map(ii => (
              <a href="/" key={ii} style={hProp}>
                <img
                  src={ii}
                  alt="icon"
                  onLoad={() => {
                    // fire window resize event to change height
                    window.dispatchEvent(new Event('resize'));
                    this.setState({
                      initialHeight: null,
                    });
                  }}
                />
              </a>
            ))}
          </Carousel>

          <WhiteSpace />

        </WingBlank>
    </div>
    );
  }
}
