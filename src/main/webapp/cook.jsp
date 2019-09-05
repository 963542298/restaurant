<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">

    <!-- js -->
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="js/vue.js"></script>
    <script type="text/javascript" src="js/cook.js"></script>

    <title>后厨</title>
</head>
<body>

<ul class="layui-nav layui-bg-green">
    <li class="layui-nav-item ">
        <a href="cook.jsp">后厨</a>
    </li>
    <li class="layui-nav-item ">
        <a href="finish.jsp">完成</a>
    </li>
    <li class="layui-nav-item">
        <a href="foodState.jsp">菜品状态</a>
    </li>
<%--    <li class="layui-nav-item">--%>
<%--        <a href="">退出</a>--%>
<%--    </li>--%>
</ul>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>菜单</legend>
</fieldset>

<table class="layui-table" lay-skin="line">
    <colgroup>
        <col width="1600">
        <col>
    </colgroup>
    <div style="padding: 20px; background-color: #F2F2F2;" id="app">
                <div class="layui-row layui-col-space12">
                    <template v-for="file in list">
                        <div class="layui-col-md3">
                            <div class="layui-card">
                                <div class="layui-card-header">
                                    <div class="layui-col-md2">{{file.detailsid}}</div>
                                    <div class="layui-col-md4">{{file.foodName}}</div>
                                    <div class="layui-col-md4">{{file.orderCode}}号桌</div>
                                    <div class="layui-col-md2">{{file.num}}份</div>
                                </div>
                                <div class="layui-card-body">
                                    <img :src="'images/'+file.foodPath" width="270" height="180"/>>
                                </div>
                                <div>
                                    <a class='layui-btn layui-btn-mini layui-btn-info' @click="editDetailsState(file.detailsid)" href="javascript:;">
                                        <i class="layui-icon layui-icon-edit"></i> 完成
                                    </a>
                                </div>
                            </div>
                        </div>
                    </template>
                </div>
            </div>
</table>
</body>
</html>
