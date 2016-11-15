(function($){
    $('.showBtn').on('touchstart',function(){
        var hideTab = $(this).parent().parent().next();
        hideTab.css({
            'opacity':1,
            'top':'0.75rem'
        });
        hideTab.find('li').css('height','0.75rem')
    })


})(jQuery)