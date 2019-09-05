<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="js/vue.js"></script>
    <script type="text/javascript" src="js/foodState.js"></script>

    <title>后厨</title>
</head>
    <body class="index">
        <div id="type">

            <!-- 顶部开始 -->
            <div class="layui-header">
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
<%--                    <li class="layui-nav-item">--%>
<%--                        <a href="">退出</a>--%>
<%--                    </li>--%>
                </ul>
            </div>
            <!-- 顶部结束 -->
            <!-- 中部开始 -->
            <!-- 左侧菜单开始 -->
            <div class="left-nav">
                <div id="side-nav">
                    <ul id="nav">
                        <li>
                            <a @click="findFood(0)" href="javascript:;" >
                                <cite>全部</cite>

                            </a>
                        </li>
                        <template v-for="type in typeList">
                            <li>
                                <a @click="findFood(type.typeid)" href="javascript:;">
                                    <cite>{{type.typename}}</cite>
                                </a>
                            </li>
                        </template>
                    </ul>
                </div>
            </div>
            <!-- <div class="x-slide_left"></div> -->
            <!-- 左侧菜单结束 -->
            <!-- 右侧主体开始 -->
            <div class="layui-body">
                <div style="padding: 20px; background-color: #F2F2F2;">
                    <div class="layui-row layui-col-space12">
                        <template v-for="file in foodList">
                            <div class="layui-col-md2">
                                <div class="layui-card">
                                    <div class="layui-card-header">
                                        <div class="layui-col-md12">{{file.foodname}}</div>
                                    </div>
                                    <div class="layui-card-body">
                                        <img :src="'images/'+file.foodpath" width="150" height="100"/>
                                    </div>
                                    <div>
                                        <a class='layui-btn layui-btn-mini layui-btn-info' @click="UpOrDown(file.foodid,file.foodstate,file.type.typeid)" href="javascript:;" >
                                            {{file.foodstate==0?"下架":"上架"}}
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </template>
                    </div>
                </div>
            </div>
            <div class="page-content-bg"></div>
            <style id="theme_style"></style>
        </div>
    </body>

</html>