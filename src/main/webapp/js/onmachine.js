
$("#calendar").calendar();  //打开弹窗
/*$("#calendar").calendar("setValue", ["2012-12-12"]);  //设置日期
$("#calendar").calendar("destroy");  //销毁*/

$('#Rightimg').on('touchstart',function(){
    console.log("d");
    $("#Rightimg").addClass("transform");
});

$("#model").select({
    title: "自动售货机型号",
    items: ["F302", "F303", "F303P-A", "F303P-B", "F303V", "F305", "F305T", "F306-DX", "F306-GX", "F306-HX", "F307", "F308-A",
        "F308-B", "F308-C", "LF-306D-17G", "LF-306D-22G", "LF-306D-32G", "LJ-503", "LV-205-46G", "LV-205A", "LV-205C-17", "LV-205F-A",
        "LV-205F-B", "LV-205F-JJ", "LV-205F-JJ-B", "LV-205L-610A", "LV-205L-610B", "LV-205L610", "LV-209", "LV-32G-50", "LV-WG01",
        "LV-X01", "LV-X02", "LV205Y-46G", "LV206-03", "LV206-A", "LV206-B"]
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
