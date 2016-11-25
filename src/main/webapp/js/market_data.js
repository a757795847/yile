(function ($) {
    var loading = false;  //状态标记
    tab('#content');

    $('header a:eq(1)').on('touchstart',function(){
        $("#Rightimg").addClass("transform");
        $.showLoading("正在加载...");
        setTimeout(function(){$("#Rightimg").removeClass("transform");},300)
        marketDataAjax(false);
    });
    $('header a:eq(0)').on('touchstart',function(){
        history.go(-1);
    });
    marketDataAjax(true)
    function marketDataAjax(on){
        if(on){
            var data = {}
        }else{
            var data = {
                'rd':payId
            }
        }
        $.ajax({
            type: 'GET',
            url: '/saleDeviceData',
            data:data,
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                console.log(data);
                var market = '';
                for(var i=0;i<22;i++){
                    market += '<div class="tabContent"><div class="showTab"><ul><li>EBFA2C161971</li><li>2016-07-20 08:20:03</li><li>轨道</li><li>62</li>';
                    market += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>名称</li><li>进价</li>';
                    market += '<li>价格</li><li>支付方式</li><li></li></ul><ul><li>雪碧330ml</li><li>1.92</li><li>3.0</li>';
                    market += '<li>支付宝:4007762001201610086139712345</li><li></li></ul></div></div>';

                }
                if(on){
                    $('#content').html(market);
                }else{
                    $('#content').append(market);
                }
                if(data.length < 25){
                    $('.weui-infinite-scroll').css('display','none');
                    if(on){
                        $('.noContent').css('display','none');
                    }else{
                        $('.noContent').css('display','block');
                    }
                    loading = true;
                }else{
                    $('.weui-infinite-scroll').css('display','block')
                    loading = false;
                }

                payId = data[data.length-1].deviceid;

            },
            error: function (jqXHR) {
                $.toast("加载失败", "cancel");
            }
        })
    }

    $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true;
        marketDataAjax(true)
    });
    function wordNum(text){
        var a = 0;
        for(var i = 0;i < text.length;i++){
            if( 'z' >= text[i] ){
                a++;
            }
        }
        if(text.length <7){
            return text;
        }else if(a >= 11 && text.length < 14){
            return text;
        }else if(a > 5 && text.length < 10){
            return text;
        }else{
            return '<p class="ellipsisWord">'+text+'</p>'
        }

    }
})(jQuery)