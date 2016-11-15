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
        console.log(username)
        console.log(password)
        $.ajax({
            type: 'POST',
            url: '/login',
            data: {
                'username': username,
                'password': password,
                'captcha':code
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