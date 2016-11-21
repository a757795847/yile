function tab(tab) {
    $(tab).on('touchstart','.tabContent',function(){
        function showTab(){
            $('.showBtn').find('img').css({
                'transform':'rotateX(0deg)',
                'transform-origin':'50% 50%'
            })
            $(tab).find('.hideTab').css({
                'opacity':0,
                'transition':'opacity 0s'
            })
            $(tab).find('.hideTab li').css({
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
}

$(window).scroll(function(){
    sTop = $(window).scrollTop();
    if(sTop > 40){
        $('.tabHeader').addClass('tabHeaderPosition');
    }else if(sTop < 40){
        $('.tabHeader').removeClass('tabHeaderPosition');

    }
})

