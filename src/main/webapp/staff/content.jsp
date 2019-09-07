<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8" import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>联系我们</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/restaurant/lib/layui/css/layui.css" media="all">
	<script type="text/javascript" src="/restaurant/lib/layui/layui.js"></script>
	<script type="text/javascript" src="/restaurant/js/jquery.min.js"></script>
	<script type="text/javascript" src="/restaurant/js/head.js"></script>
	<script type="text/javascript" src="/restaurant/js/photo.js"></script>
	<script type="application/ecmascript" src="/restaurant/js/jquery.min.js"></script>
	<script type="text/javascript" src="/restaurant/js/index.js"></script>
	<style>
		#footer {
			color: white;
			clear: both;
			text-align: center;
			padding: 20px;
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

<div style="padding: 240px; background-color: #F2F2F2;">
	<div class="layui-row layui-col-space10" align="center">
		<div class="layui-col-md12">
			<div class="layui-card">
				<div class="layui-card-header">我们的联系方式</div>
				<div class="layui-card-body">
					邮箱：1525688498@qq.com<br> 电话：15570907777<br>联系人：刘华强
				</div>
			</div>
		</div>
	</div>
</div>

<div id="footer" class="layui-bg-green" style="position: fixed; bottom: 0; left: 0; right: 0;">
	Copyright 2019 www.clubfood.com
</div>
</body>
</html>
