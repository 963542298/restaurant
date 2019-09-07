<%--
  Created by IntelliJ IDEA.
  User: 陈奕迅
  Date: 2019/9/7
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>订单统计</title>
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
    <br/>
    <label id="lbl" style="font-family: '微软雅黑';font-size: 20px;">订单统计报表</label>
    <br/>
    <br/>
    <div class="layui-form">
        <div class="layui-inline">
            <label class="layui-form-label">选择框</label>
        </div>
        <div class="layui-inline">
            <div>
                <select class="type">
                    <option value="-1"></option>
                    <option value="1">近三天</option>
                    <option value="2">近一个月</option>
                    <option value="3">近一年</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <button type="button" id="query" class="layui-btn">查询</button>
        </div>
    </div>

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
<script src="/restaurant/lib/layui/layui.all.js"></script>
<script type="text/javascript" src="/restaurant/js/echartsOrders.js"></script>
</body>
</html>
