
$("#calendar").calendar();  //打开弹窗
/*$("#calendar").calendar("setValue", ["2012-12-12"]);  //设置日期
$("#calendar").calendar("destroy");  //销毁*/

$("#btn").click(function(){
    var deviceId=$("#equipment").val();
    var deviceModel=$("#model").val();
    var deviceData=$("#calendar").val();
    console.log(deviceId);
    $.ajax({
        type: 'POST',
        url: '/addDevice',
        data: {
            'deviceId': deviceId,
            'deviceModel': deviceModel,
            'deviceData':deviceData

        },
        dataType: 'json',
        success: function (data){
            console.log(data);
        }
    })

});