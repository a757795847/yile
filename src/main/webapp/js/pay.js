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
                console.log(data);
                $.hideLoading();
                var pay = '' , stranidState='',stranidClass='';

                for(var i=0;i < data.length ; i++ ){
                  //  stranidClass = data[i].flag == ''? 'retreat':'';
                    stranidState = data[i].flag == '退款处理'? 'paperOff':'';
                    pay += '<div class="tabContent"><div class="showTab"><ul><li class="minName"><span>'+data[i].noncashName+'</span><span>'+data[i].deviceid+'</span></li><li>'+data[i].saletime.slice(5)+'</li><li class="liCenter"><p class="ellipsisWord">'+data[i].price+'</p></li><li class="liCenter"><p class="ellipsisWord">'+data[i].name+'</p></li>';
                    pay += '<li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab"><ul><li>交易号(tranid)</li><li>支付者ID(openid)</li>';
                    pay += '<li>轨道</li><li>实际销售</li><li></li></ul><ul><li class="liCenter"><p class="ellipsisWord">'+data[i].tranid+'</p></li>';
                    pay += '<li class="liCenter"><p class="ellipsisWord">'+data[i].openid+'</p></li><li>'+data[i].trackno+'</li><li><i class='+stranidState+'></i>'+data[i].flag+'</li><li></li></ul></div></div>';

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

                if(data.length == 0){
                    $('.noContent').css('display','block');
                    $('.noContent').text('无现金支付记录');
                }else{
                    payId = data[data.length-1].rd;
                }

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
    
})(jQuery)