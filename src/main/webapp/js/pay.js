(function ($) {
    
    tab('#content',2,0);
    $.showLoading("正在加载...");
    payAjax(true);
    var payId = '';
    $('#Rightimg').on('touchstart',function(){
        $("#Rightimg").addClass("transform");
        $('.noContent').css('display','none');
        $('.weui-infinite-scroll').css('display','none');
        $('#content').empty();
        setTimeout(function(){$("#Rightimg").removeClass("transform");},300)
        $.showLoading("正在加载...");
        payAjax(true);
    });

    function payAjax(on){
        if(on){
            var data = {}
        }else{
            var data = {
                'rd':payId
            }
        }
        $.ajax({
            type: 'GET',
            url: '/yile/nonCashData',
            data:data,
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                var pay = '' , stranidState='',stranidClass='';

                for(var i=0;i < data.length ; i++ ){
                    stranidClass = data[i].stranid == ''? 'retreat':'';
                    stranidState = data[i].stranid == ''? '退货处理':'有';
                    pay += '<div class="tabContent"><div class="showTab"><ul><li class="minName"><span>'+data[i].noncashName+'</span><span>'+data[i].deviceid+'</span></li><li>'+data[i].saletime.slice(5)+'</li><li>'+data[i].price+'</li><li>'+zhifuText(data[i].name)+'</li>';
                    pay += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>交易号(tranid)</li><li>支付者ID(openid)</li>';
                    pay += '<li>轨道</li><li>实际销售</li><li></li></ul><ul><li class="minWord">'+data[i].tranid+'</li>';
                    pay += '<li class="minWord">'+data[i].openid+'</li><li>'+data[i].trackno+'</li><li class="'+stranidClass+'">'+stranidState+'</li><li></li></ul></div></div>';

                }
                if(on){
                    $('#content').html(pay);
                }else{
                    $('#content').append(pay);
                }
                if(data.length < 30){
                    $('.weui-infinite-scroll').css('display','none');
                    if( on && data.length < 20){
                        $('.noContent').css('display','none');
                    }else{
                        $('.noContent').css('display','block');
                    }
                    loading = true;
                }else{
                    $('.weui-infinite-scroll').css('display','block')
                    loading = false;
                }

                payId = data[data.length-1].rd;

            },
            error: function (jqXHR) {
                $.hideLoading();
                $.toast("加载失败", "cancel");
            }
        })
    }
    var loading = false;  //状态标记
    $(document.body).infinite(60).on("infinite", function() {
        if(loading) return;
        loading = true;
        payAjax(false);
    });

    var innerWidth = window.screen.availWidth;
    function zhifuText(text){
        if(innerWidth < 375){
            if(text.length < 9 ){
                return text;
            }else{
                return '<p class="ellipsisWord">'+text+'</p>'
            }
        }else{
            if(text.length < 10 ){
                return text;
            }else{
                return '<p class="ellipsisWord">'+text+'</p>'
            }
        }

    }
})(jQuery)