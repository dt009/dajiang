<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<%--<%--%>
<%--final String url = request.getContextPath() + "/layout/showIndex";--%>
<%--response.sendRedirect(response.encodeURL(url));--%>
<%--%>--%>
<html>
<head>
    <title>Title</title>
    <link type="text/plain" rel="stylesheet" href="http://localhost:8081/dj-api/common/ext/bootstrap/css/bootstrap.css">


</head>
<body>
<%--<div style="width:100%;text-align: right"><a>启动成功。</a></div>--%>

<%--<div id="container" style="position: relative;">--%>
<%--<a class="btn btn-default btn-lg " id="pickfiles" href="#" style="position: relative; z-index: 1;">--%>
<%--<i class="glyphicon glyphicon-plus"></i>--%>
<%--<span>选择文件</span>--%>
<%--</a>--%>
<%--<div id="html5_1bqsjh98jl61v3jdf3av89jb4_container" class="moxie-shim moxie-shim-html5"--%>
<%--style="position: absolute; top: 0px; left: 0px; width: 171px; height: 46px; overflow: hidden; z-index: 0;">--%>
<%--<input id="html5_1bqsjh98jl61v3jdf3av89jb4" type="file"--%>
<%--style="font-size: 999px; opacity: 0; position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;"--%>
<%--multiple="" accept=""></div>--%>

<%--<br>--%>


<%--</div>--%>
<button type="button" onclick="putb64()">发送</button>
<div id="myDiv">
    响应内容
</div>
<div width="600" height="600">
</div>

</body>
<script type="text/javascript" src="/dj-api/common/js/jquery.js"></script>
<script type="text/javascript" src="/dj-api/common/ext/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/dj-api/common/js/moxie.js"></script>
<script type="text/javascript" src="/dj-api/common/js/plupload.dev.js"></script>
<script type="text/javascript" src="/dj-api/common/js/ui.js"></script>
<script type="text/javascript" src="/dj-api/common/js/qiniu.js"></script>
<script>

    //    var uploader = Qiniu.uploader({
    //        runtimes: 'html5,html4',      // 上传模式，依次退化
    //        browse_button: 'pickfiles',         // 上传选择的点选按钮，必需
    //        uptoken_url: '/dj-api/public/qiniu/genQiNiuToken',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    //        get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    //        // downtoken_url: '/downtoken',
    //        // Ajax请求downToken的Url，私有空间时使用，JS-SDK将向该地址POST文件的key和domain，服务端返回的JSON必须包含url字段，url值为该文件的下载地址
    //        unique_names: true,              // 默认false，key为文件名。若开启该选项，JS-SDK会为每个文件自动生成key（文件名）
    //        domain: 'owu66z9w4.bkt.clouddn.com',     // bucket域名，下载资源时用到，必需
    //        container: 'container',             // 上传区域DOM ID，默认是browser_button的父元素
    //        max_file_size: '100mb',             // 最大文件体积限制
    //        max_retries: 3,                     // 上传失败最大重试次数
    //        dragdrop: true,                     // 开启可拖曳上传
    //        drop_element: 'container',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    //        chunk_size: '4mb',                  // 分块上传时，每块的体积
    //        auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
    //        init: {
    //            'FilesAdded': function (up, files) {
    //                plupload.each(files, function (file) {
    //                    console.info("FilesAdded.file=" + file);
    //                    // 文件添加进队列后，处理相关的事情
    //                });
    //            },
    //            'BeforeUpload': function (up, file) {
    //                console.info("BeforeUpload.up=" + up);
    //                console.info("BeforeUpload.file=" + file);
    //                // 每个文件上传前，处理相关的事情
    //            },
    //            'UploadProgress': function (up, file) {
    //                console.info("UploadProgress.up=" + up);
    //                console.info("UploadProgress.file=" + file);
    //                // 每个文件上传时，处理相关的事情
    //            },
    //            'FileUploaded': function (up, file, info) {
    //                // 每个文件上传成功后，处理相关的事情
    //                // 其中info是文件上传成功后，服务端返回的json，形式如：
    //                // {
    //                //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
    //                //    "key": "gogopher.jpg"
    //                //  }
    //                // 查看简单反馈
    //                var domain = up.getOption('domain');
    //                var res = JSON.parse(info.response);
    //                var sourceLink = domain + "/" + file.target_name; //获取上传成功后的文件的Url
    ////                var sourceLink = domain + "/" + res.key; //获取上传成功后的文件的Url
    //                console.info("info====" + info.response)
    //                console.info("result=====" + sourceLink);
    //            },
    //            'Error': function (up, err, errTip) {
    //                debugger;
    //                console.info("Error.up=" + up);
    //                console.info("Error.err=" + err);
    //                console.info("Error.errTip" + errTip)
    //                //上传出错时，处理相关的事情
    //            },
    //            'UploadComplete': function () {
    //                //队列文件处理完毕后，处理相关的事情
    //            },
    //        }
    //    });


    function putb64() {
        $.get("/dj-api/public/qiniu/genQiNiuToken", function (data) {
            var pic = "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";
            var url = "http://upload-z1.qiniu.com/putb64/-1"; //非华东空间需要根据注意事项 1 修改上传域名
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    document.getElementById("myDiv").innerHTML = xhr.responseText;
                }
            }

            xhr.open("POST", url, true);

            xhr.setRequestHeader("Content-Type", "application/octet-stream");
            xhr.setRequestHeader("Authorization", "UpToken " + data.uptoken);
            xhr.send(pic);
        });

    }
</script>
</html>
