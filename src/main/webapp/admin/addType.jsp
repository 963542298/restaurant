<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-28
  Time: 下午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加菜品类型</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
</head>
<body>
<br>
<center>
    <div class="layui-form" >
        <div class="layui-form-item">
            <label class="layui-form-label" style="left: 20px">菜品类型名</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input typeName" style="width: 200px" placeholder="请输入菜品类型名">
            </div>
        </div>
    </div>
</center>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addType">添加</button>
            </div>
        </div>
    </div>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/vue.js"></script>
<script type="text/javascript" src="../js/addFood.js"></script>
</body>
</html>
