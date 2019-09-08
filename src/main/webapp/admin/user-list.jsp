<%--
  Created by IntelliJ IDEA.
  User: mvpTT
  Date: 2019/9/4
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8" import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>人员列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <script  src = “https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js”> </script>
</head>

<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
    姓名：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off" maxlength="5">
    </div>
    <button id="btn1" type="button" class="layui-btn layui-btn-normal
	  			layui-btn-radius" data-type="reload" lay-event="select">搜索</button>
    <button id="btn2" type="reset" class="layui-btn
	  			layui-btn-radius" data-type="reload" lay-event="reset">重置</button>
    <button id="btn3" type="button" class="layui-btn layui-btn-warm
	  			layui-btn-radius" data-type="reload" lay-event="addUser">添加</button>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs  icon ion-locked" lay-event="fle" style="width: 27px"></a>
    <a class="layui-btn layui-btn-xs  layui-btn-danger" lay-event="del"><i class="layui-icon"></i></a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal icon ion-edit" lay-event="edit" style="width: 27px"></a>
</script>


<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/user-list.js" charset="utf-8"></script>

</body>
</html>
