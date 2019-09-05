<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/28
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>自助餐点餐系统-登录</title>
	<link rel="stylesheet" href="lib/layui/css/layui.css">
	<link rel="stylesheet" href="css/login2.css">
	<script type="text/javascript" src="lib/layui/layui.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/ajaxutil.js"></script>
	<!--		<script type="text/javascript" src="js/login.js"></script>-->

	<script type="text/javascript" src="js/xadmin.js"></script>

	<style type="text/css">
		.login-bg{
			background:url(images/bg.png) no-repeat center;
			margin-top: 800px;
			background-size: cover;
			overflow: hidden;
		}
	</style>

</head>
<body class="login-bg">

<div id="container" >

	<div class="admin-login-background" >
		<div class="layui-input-inline" style="color: red;text-align: center;">
			${msg }
		</div>
		<form class="layui-form" action="login.action" method="post">
			<div>
				<i class="layui-icon layui-icon-username admin-icon admin-icon-username"></i>
				<input type="text" name="accountname" placeholder="请输入帐号" lay-verify="required" autocomplete="off" class="layui-input admin-input admin-input-username">
			</div>
			<div>
				<i class="layui-icon layui-icon-password admin-icon admin-icon-password"></i>
				<input type="password" name="accountpwd" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input admin-input">
			</div>

			<div class="layui-form-item">
				<label  class="layui-form-label">
				</label>
				<div style="width: 300px; ">
					<button class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal layui-btn-fluid" lay-filter="login" lay-submit="">
						登陆
					</button>
				</div>
			</div>

		</form>
	</div>
</div>


</body>
</html>
