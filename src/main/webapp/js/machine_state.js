(function ($) {
    
    tab('#synthesize');
    tab('#drink');
    tab('#coffee');
    $('.machineHeader').on('touchstart','li',function(){
        $('.machineHeader li').removeClass('active');
        $(this).addClass('active');
        var index = $(this).index();
        $('.weui_tab_bd').find('.weui_tab_bd_item').css('display','none');
        $('.weui_tab_bd .weui_tab_bd_item').eq(index).css('display','block');
        $('.machineHeader li').eq(index-1).removeClass('borderLeft');
        if(index != 1){
            $('.machineHeader li').eq(index-2).addClass('borderLeft');
        }
    })

    var synthesize = '',internet = '', paper = '', metal = '', drink = '', coffee = '';

    synthesizeAjax();
    function synthesizeAjax(){
        $.ajax({
            type: 'GET',
            url: '/integratedMachineData',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                var internetState , paperState , metalState,newData;
                newData = data.mapData.lastnettime.split('.')[0].substring(5);

                //for(var i=0;i<data.mapData;i++){

                    internet =  dataTimeAjax(data.mapData.lastnettime) ? 'internetOn':'internetOff';
                    paper = data.mapData.billstatus == 'OK'? 'paperOn':'paperOff';
                    metal = data.mapData.coinstatus == 'OK'? 'metalOn':'metalOff';

                    synthesize += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">'+data.mapData.deviceid+'</a></li><li>'+wordNum(data.mapData.vmname)+'</li>';
                    synthesize += '<li class="'+internet+'">('+newData+')</li>';
                    synthesize += '<li><i class="'+paper+'"></i>/<i class="'+metal+'"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    synthesize += '<ul><li>今日<span>(金额/次数)</span></li><li>故障轨道</li><li>缺货轨道</li><li>库存<span>(故障)</span></li><li>';
                    synthesize += '</li></ul><ul><li>'+data.mapData.today+'</li><li>'+data.mapData.guzhangguidaoNum+'</li><li>'+data.mapData.quehuoguidaoNum+'</li>';
                    synthesize += '<li>'+data.mapData.kucunNum+'('+data.mapData.guzhangguidaoNum+')</li><li></li></ul><ul><li>柜子/连体箱</li><li>版本</li>';
                    synthesize += '<li>钱箱</li><li></li></ul><ul><li>'+data.mapData['guizi/liantiji']+'</li><li>'+data.mapData.version+'</li>';
                    synthesize += '<li>1元:'+data.mapData.coin1yuan+'个; 5角:'+data.mapData.coin5jiao+'个</li><li></li></ul></div></div>';

                //}
                $('#synthesize .synthesize').append(synthesize);
            },
            error: function (jqXHR) {
                if (jqXHR.status == 400){

                }
            }
        })
    }
    function dataTimeAjax(data){
        var dateTime = new Date();
        var datas = data.split('.')[0];
        var dataTimeYYYY = dateTime.getFullYear()+'-'+(dateTime.getMonth()+1)+'-'+dateTime.getDate();
        var datasYYYY = datas.split(' ')[0];
        var dateTimeshi = dateTime.getHours().toString();
        var datesshi = datas.substring(11,13);
        var dataTimefen = dateTime.getMinutes().toString();
        var datasfen = datas.substring(14,16);
        if(dataTimeYYYY > datasYYYY){
            return true;
        }else if( dataTimeYYYY == datasYYYY ){
            if( dateTimeshi - datesshi > 1){
                return true;
            }else if(dateTimeshi == datesshi ){
                if(dataTimefen - datasfen > 5 ){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    function wordNum(text){
        if(text.length > 10 && text.length < 15){
            return '<p class="ellipsisWord">'+text+'</p>'
        }else if(text.length > 15){
            return '<p class="ellipsisWord">'+text.substring(0,15)+'...</p>'
        }
        return text;
    }


    for(var i=0;i<22;i++){
        drink += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>未设定</li><li class="internetOn">(05-11 08:40:12)</li>';
        drink += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div>';
        drink += '<div class="hideTab"><ul><li>一元/5角个数</li><li>故障轨道</li><li>缺货轨道</li><li>在库件数<span>(故障)</span></li><li></li></ul><ul>';
        drink += '<li class="none">NONE/NONE</li><li>0</li><li>7</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>门状态</li>';
        drink += '<li class="minWord">温度模式/室内温度<br/>设置温度</li><li>左温度/右温度</li><li></li></ul><ul><li>-- / --</li><li>关</li><li>冷/17/18</li>';
        drink += '<li>---</li><li></li></ul><ul><li>轨道数</li><li>柜子/连体机</li><li>版本</li><li></li><li></li></ul><ul><li>7</li><li>A</li>';
        drink += '<li>光脚一号/1.1.2</li><li></li><li></li></ul></div></div>';
    }


    $('#drink .drink').append(drink);

    // for(var i=0;i<22;i++){
    //     coffee += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>杭州以勒308—C</li><li class="internetOn">(07-11 08:40:12)</li>';
    //     coffee += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
    //     coffee += '<ul><li>一元/5角个数</li><li>机器类型</li><li>故障信息</li><li>咖啡品种</li><li></li></ul><ul><li>10/20</li><li>308-C</li>';
    //     coffee += '<li class="minWord">outcoffee命令发送3次对方无应答</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>料盒</li><li>咖啡温度/保持温度</li>';
    //     coffee += '<li>柜子/连体机</li><li></li></ul><ul><li>90/18</li><li class="minWord">红茶/牛奶/白咖啡/巧克力/糖</li><li>98/95</li><li>---</li><li></li></ul><ul>';
    //     coffee += '<li>版本</li><li></li><li></li><li></li></ul><ul><li>308-C咖啡机/1.0.0</li><li></li><li></li><li></li></ul></div></div>';
    // }


    $('#coffee .coffee').append(coffee);

    //下拉刷新
    var synthesizeLoading = false;  //状态标记
    $('#synthesize').infinite().on("infinite", function() {
        if(synthesizeLoading) return;
        synthesizeLoading = true;
        console.log('1');
        if(synthesizeLoading){
            synthesizeLoading = false;
        }
    });
    var drinkLoading = false;  //状态标记
    $('#drink').infinite().on("infinite", function() {
        if(drinkLoading) return;
        drinkLoading = true;
        console.log('drink');
        if(drinkLoading){
            drinkLoading = false;
        }

    });
    var coffeeLoading = false;  //状态标记
    $('#coffee').infinite().on("infinite", function() {
        if(coffeeLoading) return;
        coffeeLoading = true;
        console.log('coffee');
        if(coffeeLoading){
            coffeeLoading = false;
        }

    });
})(jQuery)