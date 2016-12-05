$(document).ready(function () {
    var session = $("#session").val();
    console.log(session);

    if(session == 'false') {
        $(".topLog").remove();
        $("#addtopLog").remove();
        $(".nav li").css("width", "33%");
        var sub = $(window).width();
        if (sub < '568') {
            console.log(sub);
            $(".img1").css({"width": "26%", "marginTop": "7%"});
            $(".img4").css({"width": "47%", "marginTop": "13%"});
            $(".img2").css({"width": "41%", "marginTop": "9%"});
        } else {
            console.log(sub);
            $(".nav").css("height", "3.5rem");
            $(".nav li b").css("marginTop", "14%");
        }
    }
});
$('#Rightimg').on('touchstart',function(){
    console.log("d");
    $("#Rightimg").addClass("transform");
});

window.onresize = function(){
    if(session == 'false') {
        var sub = $(window).width();
        if (sub <= '320') {
            console.log('0');
            $(".nav").css("height", "2.25rem");
            $(".nav").css("bottom", "0");
            $(".nav li b").css("marginTop", "10%");
            $(".img1").css({"width": "26%", "marginTop": "7%"});
            $(".img4").css({"width": "47%", "marginTop": "13%"});
            $(".img2").css({"width": "41%", "marginTop": "9%"});
        }
        else if (sub < '568') {
            console.log('1');
            $(".nav").css("height", "2.75rem");
            $(".nav li b").css("marginTop", "14%");
            $(".nav").css("bottom", "0");
            $(".img1").css({"width": "26%", "marginTop": "7%"});
            $(".img4").css({"width": "47%", "marginTop": "13%"});
            $(".img2").css({"width": "41%", "marginTop": "9%"});
        }else if(sub >='736'){
            console.log('5');
            $(".nav").css("height", "3.5rem");
            $(".nav").css("bottom", "3%");
            $(".img1").css({"width": "26%", "marginTop": "7%"});
            $(".img4").css({"width": "47%", "marginTop": "13%"});
            $(".img2").css({"width": "41%", "marginTop": "9%"});
            $(".nav li b").css("marginTop", "15%");
        }
        else {
            console.log('2');
            $(".nav").css("height", "3.5rem");
            $(".nav li b").css("marginTop", "14%");
            $(".nav").css("bottom", "0");
            $(".img1").css({"width": "26%", "marginTop": "7%"});
            $(".img4").css({"width": "47%", "marginTop": "13%"});
            $(".img2").css({"width": "41%", "marginTop": "9%"});

        }
    }
}