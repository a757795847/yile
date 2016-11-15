$('#btn').on('click', function () {
   var userName = $('#userName').val();
   var password = $('#password').val();
    console.log(username)
    console.log(password)
    $.ajax({
        type: 'POST',
        url: '/login',
        data: {
            'username': userName,
            'password': password
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
