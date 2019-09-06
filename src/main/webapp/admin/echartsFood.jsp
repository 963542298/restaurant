<%--
  Created by IntelliJ IDEA.
  User: 陈奕迅
  Date: 2019/9/6
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>菜品统计</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="/restaurant/css/font.css">
    <link rel="stylesheet" href="/restaurant/css/xadmin.css">
    <script type="text/javascript" src="/restaurant/lib/layui/layui.js"></script>
    <script type="text/javascript" src="/restaurant/js/jquery.min.js"></script>
    <script type="text/javascript" src="/restaurant/js/ajaxutil.js"></script>
</head>

<body style="background-color: white;">

<center>
    <br />
    <label id="lbl" style="font-family: '微软雅黑';font-size: 20px;">菜品统计报表</label>
    <br />
    <!-- 面饼-->
    <div class="layui-fluid layui-inline">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body ">
                        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                        <div id="main" style="width: 400px;height:400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 柱状图-->
    <div class="layui-fluid layui-inline">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body ">
                        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                        <div id="main1" style="width: 400px;height:400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <img id="no" style="display: none;" src="images/暂无数据.png"/>
</center>
<!-- echars的js-->
<script src="/restaurant/js/echarts.min.js"></script>
<script type="text/javascript" src="/restaurant/js/echartsFood.js"></script>
</body>
</html>
