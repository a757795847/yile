$(document).ready(function (){
    $.ajax({
        type: 'POST',
        url: '/allowsAdd',
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


});
