<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-27
  Time: 上午 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>菜品管理</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">

    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js"></script>
    <script type="text/javascript" src="../js/vue.js"></script>
    <script type="text/javascript" src="../js/food-list.js"></script>
</head>
<body>
    <div id="app">
        <div class="layui-card">
            <div class="layui-card-body">
                <form class="layui-form">
                    <blockquote class="layui-elem-quote">

                        <div class="layui-inline">
                            <label class="layui-form-label">菜品名</label>
                            <div class="layui-inline layui-show-xs-block">
                                <input class="layui-input foodName"  autocomplete="off" placeholder="请输入菜品名" name="foodName">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">菜品类型</label>
                            <div class="layui-input-block" style="width: 150px;">
                                <select class="foodType" name="foodType">
                                    <option value="-1"></option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">菜品状态</label>
                            <div class="layui-input-block" style="width: 150px;">
                                <select class="foodState">
                                    <option value="-1"></option>
                                    <option value="0">上架</option>
                                    <option value="1">已下架</option>
                                </select>
                            </div>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="layui-icon layui-icon-search layui-btn" @click="searchList()">查询</a>
                        <a class="layui-btn layui-icon layui-icon-refresh-1" @click="cleanForm()">重置</a>
                        <br/>
                        <br/>
                        <a class="layui-btn layui-icon layui-icon-add-1" @click="addType()">添加菜品类型</a>
                        <a class="layui-btn layui-icon layui-icon-add-1" @click="addFood()">添加菜品</a>

                    </blockquote>
                </form>
            </div>
        </div>
            <div class="layui-card-body">
                <table class="layui-table layui-form">
                    <thead>
                        <tr>
                            <td>菜品名</td>
                            <td>菜品类型</td>
                            <td>菜品状态</td>
                            <td>操作</td>
                        </tr>
                    </thead>
                    <tbody>
                        <template v-for="data in datas">
                            <tr>
                                <td>{{data.foodname}}</td>
                                <td>{{data.type.typename}}</td>
                                <td>
                                    <span v-if="data.foodstate==0">上架</span>
                                    <span v-if="data.foodstate==1">已下架</span>
                                </td>
                                <td>
                                    <a class='layui-btn layui-btn-sm layui-btn-info'
                                       @click="updateFoodState(data.foodid,data.foodname,data.foodstate)">
                                        <i class="layui-icon layui-icon-edit">{{data.foodstate==0?"下架":"上架"}}</i>
                                    </a>
                                    <a class='layui-btn layui-btn-sm layui-btn-danger'
                                       @click="deleteFood(data.foodid,data.foodname)">
                                        <i class="layui-icon layui-icon-delete">删除</i>
                                    </a>
                                </td>
                            </tr>
                        </template>
                    </tbody>
                </table>
            </div>
        <center>
            <div id="pageUtil"></div>
        </center>
    </div>
</body>
</html>
