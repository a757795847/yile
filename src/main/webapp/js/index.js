$(document).ready(function (){
   var session = $("#session").val();
    console.log(session);

    //if(session == 'false'){
  $(".topLog").remove();
  $("#addtopLog").remove();
    $(".nav li").css("width","33%");
    $(".img1").css({"width":"26%","marginTop":"7%"});
    $(".img4").css({"width":"47%","marginTop":"13%"});
    $(".img2").css({"width":"41%","marginTop":"9%"});
//}
});
$('#Rightimg').on('touchstart',function(){
    console.log("d");
    $("#Rightimg").addClass("transform");
});