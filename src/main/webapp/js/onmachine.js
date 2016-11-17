
$("#calendar").calendar();  //打开弹窗
/*$("#calendar").calendar("setValue", ["2012-12-12"]);  //设置日期
$("#calendar").calendar("destroy");  //销毁*/

$("#Rightimg").click(function(){
    $("#Rightimg").addClass("transform");


});
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
            if(data.success=='添加成功'){
                $.alert('添加成功');
            }else if(data.failed=='添加失败'){
                $.alert('添加失败');
            }else{
                $.alert('请输入完整信息');
            }





        }
    })

});