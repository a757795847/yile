<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta name="format-detection" content="telephone=no"/>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/weui.min.css">
    <link rel="stylesheet" href="../../css/jquery-weui.min.css">
    <link rel="stylesheet" href="../../css/Index.css">

</head>
<body>
<div class="header">
    <img src="../../img/04.png" class="img-responsive">
</div>

   <div class="index">
        <div><a href="">总体状况及销售记录</a></div>
        <div id="addtopLog"><a href="/device">新增上位机</a></div>
        <div><a href="">非现金支付</a></div>
    </div>

    <input type="hidden" value="${sessionScope.allowsAdd}" id="session">
    <ul class="nav">
        <li><a href="/home"><img src="../../img/16.png" class="img1"></a> <b></b></li>
        <li><a href="/machine/integrated"><img src="../../img/10.png" class="img2"></a> <b></b></li>
        <li class="topLog"><a href="/device"><img src="../../img/11.png" class="img3"></a> <b></b></li>
        <li><a href="#"><img src="../../img/12.png" class="img4"></a></li>
    </ul>


    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/jquery-weui.min.js"></script>
    <script src="../../js/index.js"></script>

</body>
</html>