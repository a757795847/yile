<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <title>以勒VM管理后台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta name="format-detection" content="telephone=no"/>
    <link rel="stylesheet" href="../../css/weui.min.css">
    <link rel="stylesheet" href="../../css/jquery-weui.min.css">
    <link rel="stylesheet" href="../../css/Onmachine.css">
</head>
<body>
<header>
    <a href="/home?123"><img src="../../img/07.png" class="img-responsive" id="Leftimg"></a>
        <p>新增上位机</p>
</header>
    <div id="index">
        <div id="content">
                <h4 class="weui_media_title">运营商名称</h4>
                <h4 class="weui_media_title" id="title">${sessionScope.dname}</h4>

                <div class="form">
                    <h5>上位机设备ID(12位)</h5>
                    <div class="caption">
                        <input type="text" class="weui_input" id="equipment">
                    <span class="capital">(大写)</span>
                </div>
                    <h5>自动售货机型号</h5>
                    <div class="vending">
                        <input type="text" id="model" value="请选择">
                        <span class="think"></span>
                    </div><h5>启用日</h5>
                    <div>
                        <input type="text" id="calendar"/>

                </div>
                <button type="button" id="btn">确定</button>
            </div>

        </div>
    </div>
<ul class="nav">
    <li><a href="/home?123"><img src="../img/09.png" class="img1"></a> <b></b></li>
    <li><a href="/machine/integrated?123"><img src="../img/10.png" class="img2"></a> <b></b></li>
    <li><a href="/device?123"><img src="../img/14.png" class="img3"></a> <b></b></li>
    <li><a href="/nonCash?123"><img src="../img/12.png" class="img4"></a></li>
</ul>


<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-weui.min.js"></script>
<script src="../../js/icheck.js"></script>
<script src="../../js/onmachine.js"></script>




</body>
</html>