//记住密码checkbox图片
var remember = $("#checkpass").is(":checked");
console.log(remember);
    $("#checkpass").click(function(){
            if(remember){
                $('#image1').hide();
                remember=false;
            }else{
                $('#image1').show();
                remember = true;
            }
    });

$("#image1").click(function(){
    if(remember){
        $('#image1').hide();
        remember=false;
    }else{
        $('#image1').show();
        remember = true;
    }
});

 var automatic = $("#checklogin").is(":checked");
console.log(automatic);
    $("#checklogin").click(function(event){
        event.stopPropagation();
       if(automatic){
           console.log('1');
           remember = false;
           $('#image1').hide();
           $('#image2').hide();
           automatic=false;
       }else{
           console.log('2');
           remember = true;
           $('#image1').show();
           $('#image2').show();
           automatic = true;
       }
        console.log(automatic);
        console.log(remember);
    });

$("#image2").click(function(event){
    event.stopPropagation();
    if(automatic){
        $('#image2').hide();
        remember = false;
        $('#image1').hide();
        automatic=false;
    }else{
        $('#image2').show();
        remember = true;
        $('#image1').show();
        automatic = true;
    }
    console.log(automatic);
});

//记住密码存取cookie
    var uName=$.cookie('yonghuming');
    var psw=$.cookie('mima');
    console.log(uName);
    console.log(psw);
    $('#username').val(uName);
    $('#password').val(psw);
    if(uName != null && uName != '' && psw != null && psw != '') {//选中保存秘密的复选框
        console.log('1');
        remember=true;
        console.log(remember);
         $('#image1').show();

    }
        $('#btn').on('click', function (){
        var username = $('#username').val();
        var password = $('#password').val();
        var code=$("#code").val();

        var automatic = $("#checklogin").is(":checked");
            console.log(typeof(automatic));
            console.log(typeof(remember));

        if(remember == true){//保存密码
            console.log(username);
            console.log(remember);
            $.cookie('yonghuming',username, {expires:7,path:'/'});
            $.cookie('mima',password, {expires:7,path:'/'});
        }else{//删除cookie
            $.cookie('yonghuming', '', { expires: -1, path: '/' });
            $.cookie('mima', '', { expires: -1, path: '/' });
        }

 //表单验证

            var apos=username.indexOf("@");
            var dotpos=username.lastIndexOf(".");
            if(username==""||password==""){
                $.alert(' 请输入用户名或密码');
                $(".Image").remove();
                var randomt = Math.floor(Math.random()*20);
                $("#yanzheng").append('<img src="/yile/captcha?'+ randomt +'" class="Image">');
            }else if(code==""){
                $.alert(' 请输入验证码');
                var randoma = Math.floor(Math.random()*20);
                $(".Image").remove();
                $("#yanzheng").append('<img src="/yile/captcha?'+ randoma +'" class="Image">');
            }
            else if(apos<1||dotpos-apos<2){
                $.alert(' 请输入有效的登录名(邮箱地址)');
                $(".Image").remove();
                var randome = Math.floor(Math.random()*20);
                $("#yanzheng").append('<img src="/yile/captcha?'+ randome +'" class="Image">');
            }
            else {
                $.ajax({
                    type: 'POST',
                    url: '/yile/login/post',
                    data: {
                        'username': username,
                        'password': password,
                        'captcha': code,
                        'AutomaticLogin': automatic,
                        'RememberPwd': remember
                    },
                    dataType: 'json',
                    success: function (data) {
                        console.log(data);
                        if (data.msg_error != null) {
                            $.alert(data.msg_error);
                            var randoms = Math.floor(Math.random()*20);
                            $(".Image").remove();
                            $("#yanzheng").append('<img src="/yile/captcha?'+ randoms +'" class="Image">');
                        }
                        else if (data.psd_beyond != null) {
                            $.alert(data.psd_beyond);
                        } else if (data.user_disable != null) {
                            $.alert(data.user_disable);
                        }else if(data.user_error != null){
                            $.alert(data.user_error);
                            var randomm = Math.floor(Math.random()*20);
                            $(".Image").remove();
                            $("#yanzheng").append('<img src="/yile/captcha?'+ randomm +'" class="Image">');
                            return ;
                        }else{
                            location.href = data.requestPathA;
                        }
                    },
                    error: function (jqXHR) {
                        if (jqXHR.status == 400) {

                        }
                    }
                })
            }

    });


        //验证码
$("#yanzheng").on('touchstart','.Image',function(){
    console.log("2");
        $(".Image").remove();
    var date = Math.floor(Math.random()*20);
    $("#yanzheng").append('<img src="/yile/captcha?'+ date +'" class="Image">');
   

   



});
