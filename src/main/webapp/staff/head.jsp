<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8" import="java.lang.*" %>

<!DOCTYPE html>
<html>
  <head>
    <title>餐桌订单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/restaurant/lib/layui/css/layui.css" media="all">
	  <script type="text/javascript" src="/restaurant/lib/layui/layui.js"></script>
	  <script type="text/javascript" src="/restaurant/js/head.js"></script>
	  <script type="text/javascript" src="/restaurant/js/photo.js"></script>
	  <style>
			#footer {
		    	color:white;
		    	clear:both;
		    	text-align:center;
		   		padding:20px;
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
				<a href="/restaurant/login.jsp">退出</a>
			</li>
		</ul>

		<div class="layui-carousel" id="test">
		  <div carousel-item="">
		    <div><img src="/restaurant/images/20190325162556_1.jpg"></div>
		    <div><img src="/restaurant/images/20190325162710_1.jpg"></div>
		    <div><img src="/restaurant/images/20190325162808_1.jpg"></div>
		    <div><img src="/restaurant/images/20190325162854_1.jpg"></div>
		    <div><img src="/restaurant/images/20190325163009_1.jpg"></div>
		  </div>
		</div>

		<div id="footer" class="layui-bg-green" style="position: fixed; bottom: 0; left: 0; right: 0;">
			Copyright 2019 www.clubfood.com
		</div>
  </body>
</html>
