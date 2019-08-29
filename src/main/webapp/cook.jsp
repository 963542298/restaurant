<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后厨</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <title>layui</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="../layui/css/layui.css"all">
        <script type="text/javascript" src="../layui/layui.js"></script>
        <script type="text/javascript" src="../jquera/jquery-3.4.1.js" ></script>
        <script type="text/javascript" src="js/vue.js"></script>
        <script type="text/javascript" src="../js/test4.js"></script>
</head>

<body>
<ul class="layui-nav layui-bg-green">
    <li class="layui-nav-item ">
        <a href="head.html">首页</a>
    </li>
    <li class="layui-nav-item ">
        <a href="table1.html">已使用餐桌</a>
    </li>
    <li class="layui-nav-item">
        <a href="table2.html">未使用餐桌</a>
    </li>
    <li class="layui-nav-item">
        <a href="">联系我们</a>
    </li>
    <li class="layui-nav-item">
        <a href="">退出</a>
    </li>
</ul>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>菜单</legend>
</fieldset>

<table class="layui-table" lay-skin="line">
    <colgroup>
        <col width="1600">
        <col>
    </colgroup>
    <thead>
    </thead>
    <tbody>
    <tr>
        <td>
            <div style="padding: 20px; background-color: #F2F2F2;" id="app">
                <div class="layui-row layui-col-space12">
                    <template v-for="file in list">
                        <div class="layui-col-md2">
                            <div class="layui-card">
                                <div class="layui-card-header layui-col-md4">{{file.foodName}}</div>
                                <div class="layui-card-header layui-col-md4">{{file.deskId}}</div>
                                <div class="layui-card-header layui-col-md4">{{file.foodNum}}</div>
                                <div class="layui-card-body">
                                    <img src="../img/7.png" />
                                </div>
                                <div>
                                    <a class="layui-btn layui-btn-mini layui-btn-danger">
                                        <i class="layui-icon layui-icon-edit"></i>完成
                                    </a>
                                </div>
                            </div>
                        </div>
                    </template>
                </div>
            </div>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
