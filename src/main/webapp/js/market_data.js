(function ($) {
    tab('#content');
    var market = '';
    for(var i=0;i<22;i++){
        market += '<div class="tabContent"><div class="showTab"><ul><li>EBFA2C161971</li><li>2016-07-20 08:20:03</li><li>轨道</li><li>62</li>';
        market += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>名称</li><li>进价</li>';
        market += '<li>价格</li><li>支付方式</li><li></li></ul><ul><li>雪碧330ml</li><li>1.92</li><li>3.0</li>';
        market += '<li class="minWord">支付宝:4007762001<br/>201610086139752107</li><li></li></ul></div></div>';

    }

    //$('.weui-infinite-scroll').before(market);

    var loading = false;  //状态标记
    $(document.body).infinite(60).on("infinite", function() {
        console.log('到底啦');
        if(loading) return;
        loading = true;
        setTimeout(function() {
            $('.weui-infinite-scroll').before(market);

            //$(document.body).destroyInfinite();
            //$('.weui-infinite-scroll').css('display','none');
            loading = false;
        }, 1500);   //模拟延迟
    });
})(jQuery)