var remember = $("#checkpass").is(":checked");
var automatic = $("#checklogin").is(":checked");
    $("#checkpass").click(function(){
        console.log('44');
        if(remember){
            $("image1").addClass("block");
        }else{
            $("image1").removeClass("block");
            console.log('11');
        }

    });
    var uName=$.cookie('yonghuming');
    var psw=$.cookie('mima');
    console.log(uName);
    console.log(psw);
    $('#username').val(uName);
    $('#password').val(psw);
    if(uName != null && uName != '' && psw != null && psw != '') {//选中保存秘密的复选框
        console.log('1')
        $("#polaris-checkbox-1").attr('checked', true);
       $(".icheckbox_polaris").addClass("checked");

    }




    $('#btn').on('click', function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var code=$("#code").val();
        var remember = $("#hehe").is(":checked");
        var automatic = $("#jiji").is(":checked");

        console.log(remember);

        if(remember == true){//保存密码
            console.log(username);
            console.log(remember);
            $.cookie('yonghuming',username, {expires:7,path:'/'});
            $.cookie('mima',password, {expires:7,path:'/'});
        }else{//删除cookie
            $.cookie('username', '', { expires: -1, path: '/' });
            $.cookie('password', '', { expires: -1, path: '/' });
        }





        // console.log(username);
        // console.log(remember);
            if(username==""||password==""){
                $.alert(' 请输入用户名或密码');
            }else if(code==""){
                $.alert(' 请输入验证码');
            }else {
                $.ajax({
                    type: 'POST',
                    url: '/login',
                    data: {
                        'username': username,
                        'password': password,
                        'captcha': code,
                        'AutomaticLogin': automatic,
                        'RememberPwd': remember
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.msg_error == '验证码错误') {
                            $.alert('验证码错误');
                        } else if (data.psd_beyond == '该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！') {
                            $.alert('该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！');
                        } else if (data.user_disable == '该用户已被停用!') {
                            $.alert('该用户已被停用!');
                        }


                        // if(data.msg_error){

                        // }

                        // location.href = data.requestPathA;
                    },
                    error: function (jqXHR) {
                        if (jqXHR.status == 400) {

                        }
                    }
                })
            }
    });



$("#yanzheng").on('touchstart','.Image',function(){
    console.log("2");
        $(".Image").remove();
    var date = Math.floor(Math.random()*20);
    $("#yanzheng").append('<img src="/captcha?'+ date +'" class="Image">');
   

   



});
