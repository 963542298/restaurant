<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-28
  Time: 下午 7:10
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" import="java.lang.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加菜品</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.all.js"></script>
    <script type="text/javascript" src="js/vue.js"></script>
    <script type="text/javascript" src="js/addFood.js"></script>
</head>
<body>
    <div id="addFoodApp">
        <form class="layui-form" style="width: 80%;">
            <div class="layui-form-item">
                <label class="layui-form-label">菜品名</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input foodName" style="width: 212px" placeholder="请输入菜品名">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">菜品类型</label>
                    <div class="layui-input-block">
                        <select name="foodType" class="foodType" lay-filter="foodType">
                            <option value="-1"></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">菜品状态</label>
                    <div class="layui-input-block">
                        <select name="foodState" class="foodState" lay-filter="foodState">
                            <option value="-1"></option>
                            <option value="0">直接上架</option>
                            <option value="1">暂时下架</option>
                        </select>
                    </div>
                </div>
            </div>
            <label class="layui-form-label">菜品图片</label>
            <div class="layui-upload">
                <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo1">
                    <p id="demoText"></p>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit=""  lay-filter="addFood" id="test9">添加菜品</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
