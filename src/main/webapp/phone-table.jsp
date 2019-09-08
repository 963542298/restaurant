<%--
  Created by IntelliJ IDEA.
  User: 陈奕迅
  Date: 2019/8/28
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0" />
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>自助订餐</title>
    <link rel="stylesheet" type="text/css" href="css/swiper.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="lib/layui/css/layui.css">
<%--    <style>--%>
<%--        .nav-lf{ position:absolute; left:0; width:1rem; background-color:#E5E5E5; font-size:0.15rem; text-align:center;}--%>
<%--    </style>--%>
</head>

<body>

<!-- 头图片 -->

<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="images/index/shop_1.jpg"></div>
        <div class="swiper-slide"><img src="images/index/shop_1.jpg"></div>
        <div class="swiper-slide"><img src="images/index/shop_1.jpg"></div>
    </div>
</div>



<!-- 分类 -->
<div id="app" class="nav-lf">
    <ul id="nav">
        <template v-for="type in list">
            <li><a :href="'#st'+type.typeid">{{type.typename}}</a><b></b></li>
<%--            <div v-if="type.typeid == 1">--%>
<%--                <li class="current"><a :href="'#st'+type.typeid">{{type.typename}}</a><b></b></li>--%>
<%--            </div>--%>
<%--            <div v-else>--%>
<%--                <li><a :href="'#st'+type.typeid">{{type.typename}}</a><b></b></li>--%>
<%--            </div>--%>
        </template>
    </ul>
</div>

<%--   --%>
<div id="app2"  class="container">
    <template v-for="types in typeList">
        <div class="section" :id="'st'+types.typeid">
            <template v-for="food in types.foodList">
                <div class="prt-lt">
                    <div class="lt-lt">
                        <img :src="'images/'+food.foodpath">
                    </div>
                    <div class="lt-ct">
                        <p :id="food.foodid">{{food.foodname}}</p>
                    </div>
                    <div class="lt-rt">
                        <input type="button" class="minus" onclick="minus(this)"  value="-">
                        <p class="result" style="font-size: larger">0</p>
                        <input type="button" class="add" onclick="add(this)" value="+">
                    </div>
                </div>
            </template>
        </div>
    </template>
    <div class="prt-lt" style="height: 0.45rem;">

    </div>
</div>


<footer class="layui-footer">
    <div class="ft-lt"></div>
    <div class="ft-rt">
        <p id="ok">选好了</p>
    </div>
</footer>



<script type="text/javascript" src="js/vue.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
    //加
    function add(obj){
        var p = $(obj).parent().find("p");
        var num = parseInt(p.html())+1;
        p.html(num);
    }

    //减
    function minus(obj) {
        var p = $(obj).next();
        p.html(parseInt(p.html())-1);
        if(parseInt(p.html())<0){
            p.html(0);
        }
    }
</script>
<script type="text/javascript" src="lib/layui/layui.js"></script>
<script type="text/javascript" src="js/Adaptive.js"></script>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/swiper.min.js"></script>
<script type="text/javascript" src="js/jquery.nav.js"></script>
<script type="text/javascript">
    <!-- 头图片 -->
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        spaceBetween: 30,
    });

    $(function() {
        $('#nav').onePageNav();
    });
</script>
<script type="text/javascript" src="js/waypoints.min.js"></script>
<script type="text/javascript" src="js/navbar2.js"></script>
<script type="text/javascript" src="js/ajaxutil.js"></script>
<script type="text/javascript" src="js/phone-table.js"></script>
</body>
</html>
