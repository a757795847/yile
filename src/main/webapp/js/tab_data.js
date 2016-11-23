function tab(tab,rem) {
    var paX = 0,paY=0;
    var remHeight = 1.35 * rem + 'rem';
    console.log(rem);
    $(tab).on('click','.tabContent',function(e){
        function showTab(){
            $('.showBtn').find('img').css({
                'transform':'rotateX(0deg)',
                'transform-origin':'50% 50%'
            })
            $(tab).find('.hideTab').css({
                'opacity':0,
                'height':0,
                'transition':'opacity 0s'
            })
            $(tab).find('.hideTab li').css({
                'height':0,
                'transition':'height 0s'
            })
        }

        // $('.tabContent').find('.hideTab').hide();
        // $(this).find('.hideTab').show();
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
                'transition': 'opacity 0.25s',
                'height':remHeight,
            });
            hideTab.find('li').css({
                'height':'1.406rem',
                'transition':'height 0s'
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


