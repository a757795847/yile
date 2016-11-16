$(document).ready(function(){
    $('.list input').iCheck({
        checkboxClass: 'icheckbox_polaris',
        radioClass: 'iradio_polaris',
        increaseArea: '-10%'
    });
    $('#btn').on('click', function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var code=$("#code").val();
        var remember = $("#polaris-checkbox-1").is(":checked");
        var automatic = $("#polaris-checkbox-2").is(":checked");
        console.log(username)
        console.log(password)
        $.ajax({
            type: 'POST',
            url: '/login',
            data: {
                'username': username,
                'password': password,
                'captcha':code,
                'AutomaticLogin':automatic,
                'RememberPwd':remember
            },
            dataType: 'json',
            success: function (data) {
                if(data.msg_error=='验证码错误'){
                    console.log('验证码错误');
                }else if(data.psd_beyond=='该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！'){
                    alert(data.psd_beyond);
                }else if(data.user_disable=='该用户已被停用!'){
                    alert(data.user_disable);
                }else{
                    alert(data.msg_nul);

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
    })

});
