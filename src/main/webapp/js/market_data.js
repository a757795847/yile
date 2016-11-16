(function($){
    $(document.body).infinite(50);
    $('.tabContent').on('touchstart',function(){
        function showTab(){
            $('.showBtn').find('img').css({
                'transform':'rotateX(0deg)',
                'transform-origin':'50% 50%'
            })
            $('.hideTab').css({
                'opacity':0,
                'transition':'opacity 0s'
            })
            $('.hideTab li').css({
                'height':0,
                'transition':'height 0.2s'
            })

        }

        var hideTab = $(this).find('.hideTab');
        if(hideTab.css('opacity') == 0){
            showTab();
            $(this).find('img').css({
                'transform':'rotateX(180deg)',
                'transform-origin':'50% 50%'
            })
            hideTab.css({
                'opacity':1,
                'top':'2.8125rem',
                'position':'initial',
                'transition': 'opacity .25s',
            });
            hideTab.find('li').css({
                'height':'1.406rem',
                'transition':'height .25s'
            })

        }else{
            $(this).find('img').css({
                'transform':'rotateX(0deg)',
                'transform-origin':'50% 50%'
            })
            showTab();
        }

    })


    // var loading = false;  //状态标记
    // $(document.body).infinite().on("infinite", function() {
    //     console.log('到底啦');
    //     if(loading) return;
    //     loading = true;
    //     setTimeout(function() {
    //         $("#list").append("<p> 我是新加载的内容 </p>");
    //         loading = false;
    //     }, 1500);   //模拟延迟
    // });
    
})(jQuery)