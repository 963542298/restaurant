<%--
  Created by IntelliJ IDEA.
  User: 陈奕迅
  Date: 2019/8/27
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script type="text/javascript" src="./js/jquery.min.js"></script>
    <script type="text/javascript" src="./js/vue.js"></script>
    <script type="text/javascript" src="./js/orders-query.js"></script>
</head>
<body>
    <div id="app">
        <table class="layui-table">
            <thead>
            <tr>
                <th>菜品名</th>
                <th>菜品类型</th>
                <th>数量</th>
            </tr>
            </thead>

            <tbody>
                <template v-for="details in list">
                    <tr>
                        <td>{{details.food.foodname}}</td>
                        <td>{{details.food.type.typename}}</td>
                        <td>{{details.num}}</td>
                    </tr>
                </template>
            </tbody>

        </table>
    </div>
</body>
</html>
