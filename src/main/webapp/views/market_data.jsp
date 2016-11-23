<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">

    <meta name="format-detection" content="telephone=no"/>
    <title>以勒VM管理后台</title>
    <link rel="stylesheet" type="text/css" href="../css/weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery-weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/tabAll.css">
    <link rel="stylesheet" type="text/css" href="../css/market_data.css">

</head>
<body>
<header>
    <a href="" class="clear"><img src="../img/07.png" class="img-responsive" id="Leftimg"></a>
    <strong>销售数据</strong>
    <a href="" class="clear"><img src="../img/08.png" class="img-responsive" id="Rightimg"></a>
</header>
<ul class="tabHeader">
    <li>上机位</li>
    <li>销售时间(VM)</li>
    <li>
        <span>类</span>
        <span>别</span>
    </li>
    <li>轨道编号</li>
    <li>...</li>
</ul>
<section id="content">
    <div class="tabContent">
        <div class="showTab">
            <ul>
                <li>EBFA2C161971</li>
                <li>2016-07-20 08:20:03</li>
                <li>轨道</li>
                <li>62</li>
                <li class="showBtn"><img src="../img/18.png" alt="下拉"></li>
            </ul>
        </div>
        <div class="hideTab">
            <ul>
                <li>名称</li>
                <li>进价</li>
                <li>
                    价格
                </li>
                <li>支付方式</li>
                <li></li>
            </ul>
            <ul>
                <li>雪碧330ml</li>
                <li>1.92</li>
                <li>3.0</li>
                <li class="minWord">支付宝:4007762001<br/>201610086139752107</li>
                <li></li>
            </ul>
        </div>
    </div>
    <div class="tabContent">
        <div class="showTab">
            <ul>
                <li>EBFA2C161971</li>
                <li>2016-07-20 08:20:03</li>
                <li>轨道</li>
                <li>62</li>
                <li class="showBtn"><img src="../img/18.png" alt="下拉"></li>
            </ul>
        </div>
        <div class="hideTab">
            <ul>
                <li>名称</li>
                <li>进价</li>
                <li>
                    价格
                </li>
                <li>支付方式</li>
                <li></li>
            </ul>
            <ul>
                <li>雪碧330ml</li>
                <li>1.92</li>
                <li>3.0</li>
                <li class="minWord">支付宝:4007762001<br/>201610086139752107</li>
                <li></li>
            </ul>
        </div>
    </div>


    <div class="weui-infinite-scroll">
        <div class="infinite-preloader"></div><!-- 菊花 -->
        正在加载... <!-- 文案，可以自行修改 -->
    </div>

    <div class="noContent">
        -----------<span>没有内容了</span>-----------
    </div>
</section>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery-weui.min.js"></script>
<script type="text/javascript" src="../js/tab_data.js"></script>
<script type="text/javascript" src="../js/market_data.js"></script>
</body>
</html>