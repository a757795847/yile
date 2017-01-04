<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>杭州以勒自动售货机后台</title>
    <link rel="stylesheet" type="text/css" href="/css/weui.min.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery-weui.min.css">
    <link rel="stylesheet" type="text/css" href="/css/tabAll.css">
    <link rel="stylesheet" type="text/css" href="/css/machine_state.css">
</head>
<body>
<header>
    <img src="/img/07.png" class="img-responsive" id="Leftimg">
    <ul class="machineHeader">
        <li class=" borderLeft none" data-name="synthesize" data-session="${sessionScope.zongheji}">综合机</li>
        <li class="borderLeft none" data-name="drink" data-session="${sessionScope.yinliaoji}">饮料机</li>
        <li class="none" data-name="coffee" data-session="${sessionScope.kafeiji}">咖啡机</li>
    </ul>
    <img src="/img/08.png" data-machine="0" class="img-responsive" id="Rightimg">
</header>

<div class="weui_tab_bd">

    <div id="synthesize" class=" weui_tab_bd_item">
        <ul class="tabHeader">
            <li>上位机ID</li>
            <li>机器名</li>
            <li>联网状态(最近联网)</li>
           <!-- <li>库存<span>(故障)</span></li>-->
            <li>...</li>
        </ul>

        <div class="synthesize">

        </div>
        <div class="noContent">
            没有内容了
        </div>
    </div>
    <div id="drink" class=" weui_tab_bd_item">
        <ul class="tabHeader">
            <li>上位机ID</li>
            <li>机器名称</li>
            <li>联网状态(最近联网)</li>
            <li>门状态</li>
            <li>...</li>
        </ul>

        <div class="drink">
        </div>
        <div class="noContent">
            没有内容了
        </div>
    </div>
    <div id="coffee" class=" weui_tab_bd_item">
        <ul class="tabHeader">
            <li>上位机ID</li>
            <li>机器名称</li>
            <li>联网状态(最近联网)</li>
            <li>机器类型</li>
            <li>...</li>
        </ul>
        <div class="coffee">
        </div>
        <div class="noContent">
            没有内容了
        </div>
    </div>
</div>


<div class="weui-infinite-scroll">
    <div class="infinite-preloader"></div>
    正在加载...
</div>
<input type="hidden" value="${sessionScope.allowsAdd}" id="session">
<div class="zhanwei"></div>
<ul class="nav">
    <li><a href="/yile/home?123"><img src="/img/09.png" class="img1"></a> <b></b></li>
    <li><a href="/yile/machine/integrated?123"><img src="/img/15.png" class="img2"></a> <b></b></li>
    <li class="topLog"><a href="/yile/device?123"><img src="/img/11.png" class="img3"></a> <b></b></li>
    <li><a href="/yile/nonCash?123"><img src="/img/12.png" class="img4"></a></li>
</ul>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-weui.min.js"></script>
<script type="text/javascript" src="/js/tab_data.js"></script>
<script type="text/javascript" src="/js/machine_state.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>