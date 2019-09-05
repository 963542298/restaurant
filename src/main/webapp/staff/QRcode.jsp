<%--
  Created by IntelliJ IDEA.
  User: 陈奕迅
  Date: 2019/9/4
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.4; minimum-scale=1.0; maximum-scale=2.0, user-scalable=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
</head>
<body>

<div id="qrcode"></div>
<script src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="../js/ajaxutil.js"></script>
<script>
    var tableCode = getQueryString("tableCode");
    jQuery(function(){
        jQuery('#qrcode').qrcode("http://192.168.2.202:8080/restaurant/phone-table.jsp?tableCode="+tableCode);
    })
</script>
</body>

