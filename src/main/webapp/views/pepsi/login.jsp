<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta name="format-detection" content="telephone=no"/>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/weui.min.css">
    <link rel="stylesheet" href="../../css/jquery-weui.min.css">
    <link rel="stylesheet" href="../../css/all.css">
    <link rel="stylesheet" href="../../css/welcome.css">


</head>
<body>
<div class="header">
    <img src="../../img/01.png" class="img-responsive">
</div>
<div class="col-xs-8" id="Form">
    <div class="form-group">
        <img src="../../img/02.png" class="user">
        <input id="username" class="form-control" type="text" size="15"
               placeholder="登录名"/>

    </div>
    <div class="form-group">
         <img src="../../img/03.png" class="pass">
        <input id="password" class="form-control" type="password" size="15"
               placeholder="密码"/>
    </div>
    <div id="yanzheng">
        <input  id="code" type="text"class="form-control" placeholder="验证码"><b></b>
        <img src="/captcha" class="Image">
    </div>
    <ul class="list">
        <li>
            <input type="checkbox" id="polaris-checkbox-1">
            <label for="polaris-checkbox-1">记住密码</label>
        </li>
        <li>
            <input type="checkbox" id="polaris-checkbox-2">
            <label for="polaris-checkbox-2">自动登录</label>
        </li>
    </ul>

    <button type="button" id="btn">登录</button>

</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-weui.min.js"></script>
<script src="../../js/icheck.js"></script>
<script src="../../js/welcome.js"></script>


</body>
</html>