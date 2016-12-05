(function ($) {
    var urlId = location.search.split('?')[1];
    $.showLoading("正在加载...");
    if(urlId == ''){
        history.go(-1);
    }
    var loading = false;  //状态标记
    tab('#content',2,0);

    $('#Rightimg').on('touchstart',function(){
        $("#Rightimg").addClass("transform");
        $('.noContent').css('display','none');
        $('.weui-infinite-scroll').css('display','none');
        $('#content').empty();
        $.showLoading("正在加载...");
        setTimeout(function(){$("#Rightimg").removeClass("transform");},300)
        marketDataAjax(true);
    });
    $('#Leftimg').on('touchend',function(){
        history.go(-1);
    });
    marketDataAjax(true)
    function marketDataAjax(on){
        if(on){
            var data = {
                'did':urlId
            }
        }else{
            var data = {
                'did':urlId,
                'rd':payId
            }
        }
        $.ajax({
            type: 'GET',
            url: '/yile/saleDeviceData',
            data:data,
            dataType: 'json',
            success: function (data) {
                if(data.length == 0 && on){
                    $('.records').css('display','block')
                }

                $.hideLoading();
                var market = '',a = '',b='';
                for(var i=0;i<data.length;i++){
                    a = data[i].payway.split(':')[0];
                    b = data[i].payway.split(':')[1];
                    market += '<div class="tabContent"><div class="showTab"><ul><li>'+data[i].deviceid+'</li><li>'+data[i].saletime+'</li><li>'+data[i].outtype+'</li><li>'+data[i].trackno+'</li>';
                    market += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>名称</li><li>进价</li>';
                    market += '<li>价格</li><li>支付方式</li><li></li></ul><ul><li>'+wordNum(data[i].mingcheng)+'</li><li>'+data[i].buyprice+'</li><li>'+data[i].price+'</li>';
                    market += '<li>'+wordNum(data[i].payway)+'</li><li></li></ul></div></div>';
                }
                if(on){
                    $('#content').html(market);
                }else{
                    $('#content').append(market);
                }
                if(data.length < 30){
                    $('.weui-infinite-scroll').css('display','none');
                    if(on && data.length < 20){
                        $('.noContent').css('display','none');
                    }else{
                        $('.noContent').css('display','block');
                    }
                    loading = true;
                }else{
                    payId = data[data.length-1].rd;
                    $('.weui-infinite-scroll').css('display','block')
                    loading = false;
                }


            },
            error: function (jqXHR) {
                $.hideLoading();
                $.toast("加载失败", "cancel");
            }
        })
    }

    $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true;
        marketDataAjax(false)
    });

    function wordNum(text){
        var a = 0;
        for(var i = 0;i < text.length;i++){
            if( 'z' >= text[i] ){
                a++;
            }
        }
        if(text.length < 10){
            return text;
        }else if(a <= 15 && text.length < 19){
            return text;
        }else{
            return '<p class="ellipsisWord">'+text+'</p>'
        }

    }
})(jQuery)