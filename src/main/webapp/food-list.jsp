<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-27
  Time: 上午 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品管理</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="js/vue.js"></script>
</head>
<body>
    <div class="app">
        <div class="layui-card">
            <div class="layui-card-body">
                <form class="layui-form">
                    <blockquote class="layui-elem-quote">
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="菜品名" name="foodName">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="菜品类型" name="foodType">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="菜品状态" name="foodState">
                        </div>
                        <a class="layui-icon layui-icon-search layui-btn search_btn">查询</a>
                    </blockquote>
                </form>
            </div>
        </div>
            <div class="layui-card-body">
                <table class="layui-table layui-form">
                    <thead>
                        <tr>
                            <td>菜品名</td>
                            <td>菜品类型</td>
                            <td>菜品状态</td>
                            <td>操作</td>
                        </tr>
                    </thead>
                    <tbody>
                        <template v-for="food in list">
                            <tr>
                                <td>{{food.foodname}}</td>
                                <td>{{food.type.typename}}</td>
                                <td>{{food.foodstate}}</td>
                            </tr>
                        </template>
                    </tbody>
                </table>
            </div>
    </div>
</body>
</html>
