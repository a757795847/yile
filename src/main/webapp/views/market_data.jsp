<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">

    <meta name="format-detection" content="telephone=no"/>
    <title>以勒运营商后台系统</title>
    <link rel="stylesheet" type="text/css" href="../css/weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery-weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/tabAll.css">
    <link rel="stylesheet" type="text/css" href="../css/market_data.css">

</head>
<body>
<header>
    <a href="javascript:;" class="clear"><img src="../img/07.png" class="img-responsive" id="Leftimg"></a>
    <strong>销售数据</strong>
    <a href="javascript:;" class="clear"><img src="../img/08.png" class="img-responsive" id="Rightimg"></a>
</header>
<ul class="tabHeader">
    <li>上机位</li>
    <li>销售时间(VM)</li>
    <li>类别</li>
    <li>轨道编号</li>
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
<p class="records">最近没有销售记录</p>
<div class="zhanwei"></div>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery-weui.min.js"></script>
<script type="text/javascript" src="../js/tab_data.js"></script>
<script type="text/javascript" src="../js/market_data.js"></script>
</body>
</html>