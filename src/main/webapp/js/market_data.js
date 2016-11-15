(function($){
    $('.tabContent').on('touchstart',function(){
        function showTab(){
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
            $(this).find('img').css({
                'transform':'rotateX(180deg)',
                'transform-origin':'50% 50%'
            })
            hideTab.css({
                'opacity':1,
                'top':'1.5rem',
                'position':'initial',
                'transition': 'opacity .25s',
            });
            hideTab.find('li').css({
                'height':'0.75rem',
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


})(jQuery)