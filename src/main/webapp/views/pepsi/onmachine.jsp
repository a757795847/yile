<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <a href="#"><img src="../../img/08.png" class="img-responsive" id="Rightimg"></a>
</header>
    <div id="index">
        <div id="content">
                <h4 class="weui_media_title">运营商名称</h4>
                <h4 class="weui_media_title" id="title">杭州以勒自动售货机制造有限公司</h4>

                <div class="form">
                    <h5>上位机设备ID(12位)</h5>
                    <div class="caption">
                        <input type="text" class="weui_input" id="equipment">
                    <span class="capital">(大写)</span>
                </div>
                    <h5>自动售货机型号</h5>
                    <div class="vending">

                <select class="form-control select2" id="model">
                    <option selected="selected">F302</option>
                    <option>F303</option>
                    <option>F303P-A</option>
                    <option>F303P-B</option>
                    <option>F303V</option>
                    <option>F305</option>
                    <option>F305T</option>
                    <option>F306-DX</option>
                    <option>F306-GX</option>
                    <option>F306-HX</option>
                    <option>F307</option>
                    <option>F308-A</option>
                    <option>F308-B</option>
                    <option>F308-C</option>
                    <option>LF-306D-17G</option>
                    <option>LF-306D-22G</option>
                    <option>LF-306D-32G</option>
                    <option>LJ-503</option>
                    <option>LV-205-46G</option>
                    <option>LV-205A</option>
                    <option>LV-205C-17</option>
                    <option>LV-205F-A</option>
                    <option>FLV-205F-B</option>
                    <option>LV-205F-JJ</option>
                    <option>LV-205F-JJ-B</option>
                    <option>LV-205L-610A</option>
                    <option>LV-205L-610B</option>
                    <option>LV-205L610</option>
                    <option>LV-209</option>
                    <option>LV-32G-50</option>
                    <option>LV-WG01</option>
                    <option> LV-X01</option>
                    <option>LV-X02</option>
                    <option>LV205Y-46G</option>
                    <option>LV206-03</option>
                    <option>LV206-A</option>
                    <option>LV206-B</option>
                </select>
                        <span class="link"></span>
                    </div><h5>启用日</h5>
                    <div>

                <input type="text" class="weui_input" id="calendar">
                </div>
                <button type="button" id="btn">确定</button>
            </div>

        </div>

    </div>
    <ul class="nav">
        <li><a href="/home"><img src="../../img/09.png" class="img1"></a> <b></b></li>
        <li><a href="#"><img src="../../img/10.png" class="img2"></a> <b></b></li>
        <li><a href="/device"><img src="../../img/14.png" class="img3"></a> <b></b></li>
        <li><a href="#"><img src="../../img/12.png" class="img4"></a></li>
    </ul>


<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-weui.min.js"></script>
<script src="../../js/icheck.js"></script>
<script src="../../js/onmachine.js"></script>




</body>
</html>