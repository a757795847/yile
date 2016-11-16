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
                console.log(data);
                location.href = data.requestPathA;
            },
            error: function (jqXHR) {
                if (jqXHR.status == 400) {

                }
            }
        })
    })

});
