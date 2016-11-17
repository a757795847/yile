<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta name="format-detection" content="telephone=no"/>
    <link rel="stylesheet" href="../../css/weui.min.css">
    <link rel="stylesheet" href="../../css/jquery-weui.min.css">
    <link rel="stylesheet" href="../../css/Onmachine.css">
</head>
<body>
<header>
    <a href=""><img src="../../img/07.png" class="img-responsive" id="Leftimg"></a>
        <p>新增上位机</p>
    <p></p>
    <a href=""><img src="../../img/08.png" class="img-responsive" id="Rightimg"></a>
</header>
    <div id="index">
        <div id="content">
                <h4 class="weui_media_title">运营商名称</h4>
                <h3 class="weui_media_title">杭州以勒自动售货机制造有限公司</h3>
            <div class="form">
                <h5>上位机设备ID(12位)</h5>
                <input type="text" class="weui_input" id="equipment">
                <span class="capital">(大写)</span>
                <h5>自动售货机型号</h5>
                <select class="form-control select2" id="model">
                    <option selected="selected">杭州</option>
                    <option>温州</option>
                    <option disabled="disabled">上海</option>
                    <option>宁波</option>
                    <option>金华</option>
                    <option>舟山</option>
                    <option>湖州</option>
                    <option>丽水</option>
                    <option>衢州</option>
                    <option>嘉兴</option>
                </select>
                <h5>启用日</h5>
                <input type="text" class="weui_input" id="calendar">

                <button type="button" id="btn">确定</button>
            </div>

        </div>

    </div>
    <div class="weui_tabbar">
    <a href="index.jsp" class="weui_tabbar_item weui_bar_item_on">
        <div>
            <img src="../../img/09.png" class="img-responsive">
            <b></b>
        </div>
    </a>
    <a href="" class="weui_tabbar_item">
        <div>
            <img src="../../img/10.png" class="img-responsive">
            <b></b>
        </div>
    </a>
    <a href="#tab3" class="weui_tabbar_item">
        <div>
            <img src="../../img/11.png" class="img-responsive">
            <b></b>
        </div>
    </a>
    <a href="#tab4" class="weui_tabbar_item cash">
        <div>
            <img src="../../img/12.png" class="img-responsive">
        </div>
    </a>
</div>


<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-weui.min.js"></script>
<script src="../../js/icheck.js"></script>
<script src="../../js/onmachine.js"></script>




</body>
</html>