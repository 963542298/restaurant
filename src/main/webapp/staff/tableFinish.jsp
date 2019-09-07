<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8" import="java.lang.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>使用页面</title>

	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="/restaurant/lib/layui/css/layui.css" media="all">
	<script type="text/javascript" src="/restaurant/lib/layui/layui.js" ></script>
	<script type="text/javascript" src="/restaurant/js/jquery.min.js" ></script>
	<script type="application/ecmascript" src="/restaurant/js/jquery.min.js"></script>
	<script type="text/javascript" src="/restaurant/js/index.js"></script>
	<style>
		#footer {
			color:white;
			clear:both;
			text-align:center;
			padding:10px;
		}
	</style>

</head>

<body>
<ul class="layui-nav layui-bg-green">
	<li class="layui-nav-item ">
		<a href="/restaurant/staff/head.jsp">首页</a>
	</li>
	<li class="layui-nav-item ">
		<a href="/restaurant/staff/tableFinish.jsp">已使用餐桌</a>
	</li>
	<li class="layui-nav-item">
		<a href="/restaurant/staff/tableParv.jsp">未使用餐桌</a>
	</li>
	<li class="layui-nav-item">
		<a href="/restaurant/staff/content.jsp">联系我们</a>
	</li>
	<li class="layui-nav-item layui-layout-right">
		<a id="out">退出</a>
	</li>
</ul>

<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
	桌号：
	<div class="layui-inline">
		<input class="layui-input" name="id" id="demoReload" autocomplete="off">
	</div>
	<button id="btn1" type="button" class="layui-btn layui-btn-normal
	  			layui-btn-radius" data-type="reload" lay-event="select">搜索</button>
	<button id="btn2" type="reset" class="layui-btn
	  			layui-btn-radius" data-type="reload" lay-event="reset">重置</button>
</script>

<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="fle" >闲置</a>
</script>

<script src="/restaurant/lib/layui/layui.js" charset="utf-8"></script>
<script src="/restaurant/js/tableFinish.js"></script>
<script type="text/javascript" src="/restaurant/js/head.js" ></script>
<div id="footer" class="layui-bg-green" style="position: fixed; bottom: 0; left: 0; right: 0;">
	Copyright 2019 www.clubfood.com
</div>
</body>
</html>
