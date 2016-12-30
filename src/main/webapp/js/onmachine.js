
$("#calendar").calendar();
var date = new Date();
    year = date.getYear()+1900;
    moth = date.getMonth()+1;
    ri = date.getDate()
$("#calendar").val(year+'-'+moth+'-'+ri);
 //打开弹窗
/*$("#calendar").calendar("setValue", ["2012-12-12"]);  //设置日期
 $("#input").calendar("setValue", ["2012-12-12"]);
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
    var re=/^[A-Z0-9]{12}$/;
    if (deviceId =='') {
        $.alert('上位机设备ID不能为空');
    }else if(re.test(deviceId)==false){
        console.log('fdsf');
        $.alert('请输入12位含数字或大写字母的设备ID');
    } else if(deviceModel=="请选择"){
        $.alert('请选择自动售货机型号');
    }else {
        $.ajax({
            type: 'POST',
            url: '/yile/addDevice',
            data: {
                'deviceId': deviceId,
                'deviceModel': deviceModel,
                'deviceData': deviceData

            },
            dataType: 'json',
            success: function (data) {
                if (data.success != null) {
                    $.alert(data.success);
                } else {
                    $.alert(data.failed);
                }


            }
        })
    }

});
