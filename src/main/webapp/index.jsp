<%@page pageEncoding="utf-8" import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台登录-X-admin2.2</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" href="./css/font.css">
	<link rel="stylesheet" href="./css/xadmin.css">
	<!-- <link rel="stylesheet" href="./css/theme5.css"> -->
	<script src="./lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="./js/xadmin.js"></script>
	<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
	<script>
		// 是否开启刷新记忆tab功能
		// var is_remember = false;
	</script>

</head>
<body >

<!-- 顶部开始 -->
<div class="container">
	<div class="logo">
		<a href="./index.html">X-admin v2.2</a></div>
	<div class="left_open">
		<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
	</div>
	<ul class="layui-nav right" lay-filter="">
		<li class="layui-nav-item">
			<a href="javascript:;">admin</a>
			<dl class="layui-nav-child">
				<!-- 二级菜单 -->
				<dd>
					<a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>
				<dd>
					<a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
				<dd>
					<a href="./login.html">退出</a></dd>
			</dl>
		</li>
	</ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
	<div id="side-nav">
		<ul id="nav">
			<li>
				<a onclick="xadmin.add_tab('统计页面','welcome.html')">
					<i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
					<cite>会员管理</cite>
					<i class="iconfont nav_right">&#xe697;</i></a>

			</li>
			<li>
				<a href="javascript:;">
					<i class="iconfont left-nav-li" lay-tips="订单管理">&#xe723;</i>
					<cite>订单管理</cite>
					<i class="iconfont nav_right">&#xe697;</i></a>
				<ul class="sub-menu">
					<li>
						<a onclick="xadmin.add_tab('订单列表','order-list.html')">
							<i class="iconfont">&#xe6a7;</i>
							<cite>订单列表</cite></a>
					</li>
				</ul>
			</li>
			<li>
				<a href="javascript:;">
					<i class="iconfont left-nav-li" lay-tips="分类管理">&#xe723;</i>
					<cite>分类管理</cite>
					<i class="iconfont nav_right">&#xe697;</i></a>
				<ul class="sub-menu">
					<li>
						<a onclick="xadmin.add_tab('多级分类','cate.html')">
							<i class="iconfont">&#xe6a7;</i>
							<cite>多级分类</cite></a>
					</li>
				</ul>
			</li>
			<li>
				<a href="javascript:;">
					<i class="iconfont left-nav-li" lay-tips="系统统计">&#xe6ce;</i>
					<cite>系统统计</cite>
					<i class="iconfont nav_right">&#xe697;</i></a>
				<ul class="sub-menu">
					<li>
						<a onclick="xadmin.add_tab('拆线图','echarts1.html')">
							<i class="iconfont">&#xe6a7;</i>
							<cite>拆线图</cite></a>
					</li>
					<li>
						<a onclick="xadmin.add_tab('拆线图','echarts2.html')">
							<i class="iconfont">&#xe6a7;</i>
							<cite>拆线图</cite></a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
	<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
		<ul class="layui-tab-title">
			<li class="home">
				<i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
		<div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
			<dl>
				<dd data-type="this">关闭当前</dd>
				<dd data-type="other">关闭其它</dd>
				<dd data-type="all">关闭全部</dd></dl>
		</div>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<iframe src='./welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
			</div>
		</div>
		<div id="tab_show"></div>
	</div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
</body>
</html>