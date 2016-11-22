





$(document).ready(function (){
    $.ajax({
        type: 'GET',
        url: '/home',
        dataType: 'json',
        success: function (data) {
            console.log('bbb');
            console.log(data);
            console.log('111');
        }
        });
    
  $(".topLog").remove();
  $("#addtopLog").remove();
    $(".nav li").css("width","33%");
    $(".img1").css({"width":"26%","marginTop":"7%"});
    $(".img4").css({"width":"47%","marginTop":"13%"});
    $(".img2").css({"width":"41%","marginTop":"9%"});

})
