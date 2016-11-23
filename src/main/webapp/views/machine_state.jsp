<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>总体状态</title>
    <link rel="stylesheet" type="text/css" href="../css/weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery-weui.min.css">
    <link rel="stylesheet" type="text/css" href="../css/tabAll.css">
    <link rel="stylesheet" type="text/css" href="../css/machine_state.css">
</head>
<body>
<header>
    <a href="/home"><img src="../img/07.png" class="img-responsive" id="Leftimg"></a>
    <ul class="machineHeader">
        <li class="active borderLeft">综合机</li>
        <li class="borderLeft">饮料机</li>
        <li>咖啡机</li>
    </ul>
    <a href="#"><img src="../img/08.png" class="img-responsive" id="Rightimg"></a>
</header>

<ul class="tabHeader">
    <li>上位机ID</li>
    <li>机器名称</li>
    <li>联网状态(最近联网)</li>
    <li>纸币/硬币找零</li>
    <li>...</li>
</ul>

<div class="weui_tab_bd">

    <div id="synthesize" class="weui_tab_bd_item weui_tab_bd_item_active">
        <div class="synthesize">

        </div>
        <div class="weui-infinite-scroll">
            <div class="infinite-preloader"></div>
            正在加载...
        </div>
        <div class="noContent">
            没有内容了
        </div>
    </div>
    <div id="drink" class="weui_tab_bd_item weui_tab_bd_item_active">
        <div class="drink">
            <div class="tabContent">
                    <div class="showTab">
                        <ul>
                            <li><a href="#">023041952882</a></li>
                            <li>未设定</li>
                            <li class="internetOn">(05-11 08:40:12)</li>
                            <li><i class="paperOn"></i>/<i class="metalOff"></i></li>
                            <li class="showBtn"><img src="../img/18.png" alt="下拉"></li>
                        </ul>
                    </div>
                    <div class="hideTab">
                        <ul>
                            <li>一元/5角个数</li>
                            <li>故障轨道</li>
                            <li>缺货轨道</li>
                            <li>在库件数<span>(故障)</span></li>
                            <li></li>
                        </ul>
                        <ul>
                            <li class="none">NONE/NONE</li>
                            <li>0</li>
                            <li>7</li>
                            <li>0</li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>今日<span>(金额/次数)</span></li>
                            <li>门状态</li>
                            <li class="minWord">温度模式/室内温度<br/>设置温度</li>
                            <li>左温度/右温度</li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>-- / --</li>
                            <li>关</li>
                            <li>冷/17/18</li>
                            <li>---</li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>轨道数</li>
                            <li>柜子/连体机</li>
                            <li>版本</li>
                            <li></li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>7</li>
                            <li>A</li>
                            <li>光脚一号/1.1.2</li>
                            <li></li>
                            <li></li>
                        </ul>
                    </div>
                </div>
            <div class="tabContent">
                    <div class="showTab">
                        <ul>
                            <li><a href="#">023041952882</a></li>
                            <li>未设定</li>
                            <li class="internetOff">(05-11 08:40:12)</li>
                            <li><i class="paperOn"></i>/<i class="metalOff"></i></li>
                            <li class="showBtn"><img src="../img/18.png" alt="下拉"></li>
                        </ul>
                    </div>
                    <div class="hideTab">
                        <ul>
                            <li>一元/5角个数</li>
                            <li>故障轨道</li>
                            <li>缺货轨道</li>
                            <li>在库件数<span>(故障)</span></li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>10/20</li>
                            <li>1</li>
                            <li>7</li>
                            <li>265(10)</li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>今日<span>(金额/次数)</span></li>
                            <li>门状态</li>
                            <li class="minWord">温度模式/室内温度<br/>设置温度</li>
                            <li>左温度/右温度</li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>90.0/25</li>
                            <li>开</li>
                            <li>冷/17/18</li>
                            <li>18/20</li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>轨道数</li>
                            <li>柜子/连体机</li>
                            <li>版本</li>
                            <li></li>
                            <li></li>
                        </ul>
                        <ul>
                            <li>7</li>
                            <li>A</li>
                            <li>光脚一号/1.1.2</li>
                            <li></li>
                            <li></li>
                        </ul>
                    </div>
                </div>
        </div>
        <div class="weui-infinite-scroll">
            <div class="infinite-preloader"></div>
            正在加载...
        </div>
    </div>
    <div id="coffee" class="weui_tab_bd_item weui_tab_bd_item_active">

        <div class="coffee">
            <div class="tabContent">
                <div class="showTab">
                    <ul>
                        <li><a href="#">023041952882</a></li>
                        <li>杭州以勒308—C</li>
                        <li class="internetOn">(07-11 08:40:12)</li>
                        <li><i class="paperOn"></i>/<i class="metalOff"></i></li>
                        <li class="showBtn"><img src="../img/18.png" alt="下拉"></li>
                    </ul>
                </div>
                <div class="hideTab">
                    <ul>
                        <li>一元/5角个数</li>
                        <li>机器类型</li>
                        <li>故障信息</li>
                        <li>咖啡品种</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>10/20</li>
                        <li>308-C</li>
                        <li><p class="minWord">outcoffee命令发送3次对方无应答</p></li>
                        <li>0</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>今日<span>(金额/次数)</span></li>
                        <li>料盒</li>
                        <li>咖啡温度/保持温度</li>
                        <li>柜子/连体机</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>90/18</li>
                        <li><p class="ellipsisWord">红茶/牛奶/白咖啡/巧克力/糖/吃饭/睡觉/打豆豆</p></li>
                        <li>98/95</li>
                        <li>---</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>版本</li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>308-C咖啡机/1.0.0</li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
            </div>
            <div class="tabContent">
                <div class="showTab">
                    <ul>
                        <li><a href="#">023041952882</a></li>
                        <li>杭州以勒307</li>
                        <li class="internetOn">(07-11 08:40:12)</li>
                        <li><i class="paperOn"></i>/<i class="metalOff"></i></li>
                        <li class="showBtn"><img src="../img/18.png" alt="下拉"></li>
                    </ul>
                </div>
                <div class="hideTab">
                    <ul>
                        <li>一元/5角个数</li>
                        <li>机器类型</li>
                        <li>故障信息</li>
                        <li>咖啡品种</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>0/15</li>
                        <li>307</li>
                        <li>无</li>
                        <li>11</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>今日<span>(金额/次数)</span></li>
                        <li>料盒</li>
                        <li>咖啡温度/保持温度</li>
                        <li>柜子/连体机</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>300/60</li>
                        <li class="minWord">红茶/牛奶/白咖啡/巧克力/糖</li>
                        <li>98/95</li>
                        <li>AB</li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>版本</li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    <ul>
                        <li>307咖啡机/1.0.0</li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="weui-infinite-scroll">
            <div class="infinite-preloader"></div>
            正在加载...
        </div>
    </div>
</div>

<ul class="nav">
    <li><a href="/home"><img src="../img/09.png" class="img1"></a> <b></b></li>
    <li><a href="/machine/integrated"><img src="../img/15.png" class="img2"></a> <b></b></li>
    <li><a href="/device"><img src="../img/11.png" class="img3"></a> <b></b></li>
    <li><a href="#"><img src="../img/12.png" class="img4"></a></li>
</ul>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery-weui.min.js"></script>
<script type="text/javascript" src="../js/tab_data.js"></script>
<script type="text/javascript" src="../js/machine_state.js"></script>
</body>
</html>