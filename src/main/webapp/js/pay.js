(function ($) {
    tab('#content');
    var pay = '',pay1 = '';


    for(var i=0;i<22;i++){
        pay += '<div class="tabContent"><div class="showTab"><ul><li class="minName">F90813151281</li><li>07-20 08:20:03</li><li>2.0</li><li>微信—福建市丰大</li>';
        pay += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>交易号(tranid)</li><li>支付者ID(openid)</li>';
        pay += '<li>轨道</li><li>实际销售</li><li></li></ul><ul><li class="minWord">400885200120160720935830169</li>';
        pay += '<li class="minWord">oQv75vr5SpLLf13e35mOB1fCsupk</li><li>32</li><li class="retreat">销售处理</li><li></li></ul></div></div>';

    }
    pay1 += '<div class="tabContent"><div class="showTab"><ul><li class="minName">F90813151281</li><li>07-20 08:20:03</li><li>2.0</li><li>微信—福建市丰大</li>';
    pay1 += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>交易号(tranid)</li><li>支付者ID(openid)</li>';
    pay1 += '<li>轨道</li><li>实际销售</li><li></li></ul><ul><li class="minWord">400885200120160720935830169</li>';
    pay1 += '<li class="minWord">oQv75vr5SpLLf13e35mOB1fCsupk</li><li>32</li><li class="retreat">销售处理</li><li></li></ul></div></div>';

    $('.weui-infinite-scroll').before(pay);

    var loading = false;  //状态标记
    $(document.body).infinite(60).on("infinite", function() {
        console.log('到底啦');
        if(loading) return;
        loading = true;
        setTimeout(function() {
            $('.weui-infinite-scroll').before(pay1);

            //$(document.body).destroyInfinite();
            //$('.weui-infinite-scroll').css('display','none');
            loading = false;
        }, 1500);   //模拟延迟
    });
})(jQuery)