(function($){
    $('.showBtn').on('touchstart',function(){
        var hideTab = $(this).parent().parent().next();
        hideTab.toggleSlide()
    })


})(jQuery)