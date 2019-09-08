<%--
  Created by IntelliJ IDEA.
  User: mvpTT
  Date: 2019/9/4
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="../css/font2.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <script type="text/javascript" src="../js/userAdd.js"></script>
</head>

<body>
<div class="layui-fluid">


    <form class="layui-form">
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline layui-col-md12">
                <input type="text" id="userName" name="userName" required="" lay-verify="required" autocomplete="off" class="layui-input aname" maxlength="5">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="userPhone" name="userPhone" required="" lay-verify="phone"
                       autocomplete="off" class="layui-input phone">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>性别
            </label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男" checked="">
                <input type="radio" name="sex" value="2" title="女">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-block">
                <input type="text" lay-verify="required" class="layui-input userBirthday" id="date">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>地址
            </label>
            <div class="layui-input-inline layui-col-md12">
                <input type="text" id="userAddress" name="userAddress" required="" lay-verify="required" autocomplete="off" class="layui-input aname">
            </div>

        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <div style="width: 340px; padding-left: 50px;">
                <button class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal layui-btn-fluid" lay-filter="userAdd" lay-submit="" type="button">
                    添加
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
