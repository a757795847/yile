<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">

    <meta name="format-detection" content="telephone=no"/>
    <title>杭州以勒自动售货机后台</title>
    <link rel="stylesheet" type="text/css" href="../css/weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery-weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/tabAll.css">
    <link rel="stylesheet" type="text/css" href="../css/pay.css">
    <link rel="stylesheet" type="text/css" href="/css/machine_state.css">
</head>
<body>
<header>
    <a href="/yile/home?123" class="clear"><img src="../img/07.png" class="img-responsive" id="Leftimg"></a>
    <strong>非现金支付记录</strong>
    <a href="#" class="clear"><img src="../img/08.png" class="img-responsive" id="Rightimg"></a>
</header>
<ul class="tabHeader">
    <li>上位机</li>
    <li>支付时间</li>
    <li>金额</li>
    <li>支付收单</li>
    <li>...</li>
</ul>
<section id="content">

</section>
<div class="weui-infinite-scroll">
    <div class="infinite-preloader"></div><!-- 菊花 -->
    正在加载... <!-- 文案，可以自行修改 -->
</div>
<div class="noContent">
    没有内容了
</div>
<div class="zhanwei"></div>
<input type="hidden" value="${sessionScope.allowsAdd}" id="session">
<ul class="nav">
    <li><a href="/yile/home?123"><img src="../img/09.png" class="img1"></a> <b></b></li>
    <li><a href="/yile/machine/integrated?123"><img src="../img/10.png" class="img2"></a><b></b></li>
    <li class="topLog"><a href="/yile/device?123"><img src="../img/11.png" class="img3"></a><b></b></li>
    <li><a href="/yile/nonCash?123"><img src="../img/13.png" class="img4"></a></li>
</ul>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery-weui.min.js"></script>
<script type="text/javascript" src="../js/tab_data.js"></script>
<script type="text/javascript" src="../js/pay.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
</body>
</html>