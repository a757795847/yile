    $.ajax({
        type: 'GET',
        url: '/home',
        dataType: 'json',
        success: function (data) {
            console.log(data);
        }
        });
