/**
 * @author v_duantao
 * @file webpack 的生产配置文
 *
 * @date 17/9/23 上午11:12
 */

const path = require('path');

const webpack = require('webpack');

const HtmlWebpack = require('html-webpack-plugin');

const ET = require('extract-text-webpack-plugin');  // 样式插件

// const CleanPlugin = require('clean-webpack-plugin');

const svgDirs = [
    require.resolve('antd-mobile').replace(/warn\.js$/, ''),  // 1. 属于 antd-mobile 内置 svg 文件
    // path.resolve(__dirname, 'src/my-project-svg-foler'),  // 2. 自己私人的 svg 存放目录
];

// 你本地的码云的后端项目  前端的代码放置路径
const PATH = '/Users/v_duantao/dajiang/dajiang_1_5/dajiang-war/src/main/webapp/WEB-INF/html';


webpackConfig = {
    // 入口
    entry: {
        bundle: './src/index.js',
        vendor: ['react', 'react-dom', 'react-router-dom', 'antd-mobile']
    },

    // 出口
    output: {
        path: PATH,
        filename: "[name]_[chunkhash].js"
    },


    // 解析
    resolve: {
        mainFiles: ["index.web","index"],
        modules: [
            path.resolve(__dirname, "node_modules"),
            path.resolve(__dirname, "src/common")
        ],
        extensions: ['.js', '.jsx', '.css', '.less', '.json', '.jpg', '.png', '.gif', '.jpeg', '.svg', '.json',
            '.web.tsx', '.web.ts', '.web.jsx', '.web.js', '.ts', '.tsx', 'react.js']
    },

    // loader
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                exclude: /node_modules/,
                use: 'babel-loader'
            },
            {
                test: /\.less$/,
                use: ['css-hot-loader'].concat(ET.extract({
                    fallback: 'style-loader',
                    use: [
                        {
                            loader: 'css-loader'
                        },
                        {
                            loader: 'autoprefixer-loader'
                        },
                        {
                            loader: 'less-loader'
                        }
                    ]
                }))
            },
            {
                test: /\.css$/,
                use: ['css-hot-loader'].concat(ET.extract({
                    fallback: 'style-loader',
                    use: 'css-loader'
                }))
            },
            {
                test: /\.(png|jpe?g|gif)(\?.*)?$/,
                use: [
                    {
                        loader: 'url-loader',
                        // 配置 url-loader 的可选项
                        options: {
                            // 限制 图片大小 10000B，小于限制会将图片转换为 base64格式
                            limit: 10000,
                            // 超出限制，创建的文件格式
                            name: 'images/[name]_[hash:6].[ext]'
                        }
                    }
                ]
            },
            {
                test: /\.(svg)$/i,
                loader: 'svg-sprite-loader',
                include: svgDirs,  // 把 svgDirs 路径下的所有 svg 文件交给 svg-sprite-loader 插件处理
            }
        ],
        loaders: [
            { 
                test: /\.js$/, 
                exclude: /node_modules/, 
                loader: 'babel-loader?presets[]=react,presets[]=es2015,presets[]=stage-0' 
            }
        ]
    },

    // plugin
    plugins: [
        new webpack.optimize.CommonsChunkPlugin({
            name: 'vendor',
            minChunks: Infinity
        }),
        new ET('style_[hash:6].css'),
        new HtmlWebpack({
            template: './src/index.dev.html'
        }),
    ],

    // dev-server 配置
    devServer: {
        port: 8080,
        contentBase: '/dist/',
        proxy: {
            '/dj-api/*': {
                target: 'http://apidev.dajiangzaixian.com/',
                secure: false,
                changeOrigin: true
            }
        }
    }
};

module.exports = webpackConfig;
