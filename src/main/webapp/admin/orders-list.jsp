<%--
  Created by IntelliJ IDEA.
  User: 陈奕迅
  Date: 2019/8/26
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <title>订单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">

    <!-- js -->
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js"></script>
    <script type="text/javascript" src="../js/vue.js"></script>
    <script type="text/javascript" src="../js/orders-list.js"></script>
</head>
<body>
<div id="app">
    <blockquote class="layui-elem-quote news_search">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input id="ordercode" type="text" id="ordercode" placeholder="请输入订单编号" class="layui-input search_input">
            </div>
            <button id="query" class="layui-btn search_btn">查询</button>

            <button id="reset" class="layui-btn reset_btn"><i class="layui-icon">&#xe666;</i>重置</button>
        </div>
    </blockquote>
    <div class="layui-form links_list">
        <table class="layui-table">
            <colgroup>
                <col width="25%">
                <col width="30%">
                <col width="45%">
            </colgroup>

            <thead>
            <tr>
                <th>订单编号</th>
                <th>下单时间</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody class="users_content">
            <template v-for="orders in list">
                <tr>
                    <td>{{orders.ordercode}}</td>
                    <td>{{orders.ordertime}}</td>
                    <td>
                        <button class="layui-btn" @click="findDetailsByOrdersId(orders.orderid)">查看订单详情</button>
                    </td>
                </tr>
            </template>
            </tbody>
        </table>
    </div>
</div>
<center>
    <div id="laypage"></div>
</center>

</body>
</html>
