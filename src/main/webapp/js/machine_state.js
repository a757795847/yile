(function ($) {
    function indexState(){
        //$('.weui-infinite-scroll').css('display','none');
        $.showLoading();
        synthesizeAjax(true);
    }
    indexState();
    $('#Rightimg').on('touchstart',function(){
        $("#Rightimg").addClass("transform");
        var index = $(this).attr('data-machine');
        setTimeout(function(){$("#Rightimg").removeClass("transform");},300)
        $.showLoading();
        console.log(index);
        switch(index){
            case 0:
                synthesizeAjax(true);
                break;
            case 1:
                drinkAjax(true);
                break;
            default:
                coffeeAjax(true);
        }


    });

    tab('#synthesize',4);
    tab('#drink',6);
    tab('#coffee',6);
    $('.machineHeader').on('touchstart','li',function(){
        $('.machineHeader li').removeClass('active');
        $(this).addClass('active');
        var index = $(this).index();
        $('.weui_tab_bd').find('.weui_tab_bd_item').removeClass('weui_tab_bd_item_active')
        $('.weui_tab_bd .weui_tab_bd_item').eq(index).addClass('weui_tab_bd_item_active')
        $('#Rightimg').attr('data-machine',index);
        $('.machineHeader li').eq(index-1).removeClass('borderLeft');
        if(index != 1){
            $('.machineHeader li').eq(index-2).addClass('borderLeft');
        }
    })
    var synthesizeLastId = '',drinkLastId = '',coffeeLastId = '';
    function synthesizeAjax(on){
        if(on){
            var data = {}
        }else{
            var data = {
                'rd':synthesizeLastId
            }
        }
        $.ajax({
            type: 'GET',
            url: '/integratedMachineData',
            data:data,
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                console.log(data);
                var synthesize = '',internet = '', paper = '', metal = '',newDate;
                for(var i=0;i<data.length;i++){
                    newDate = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    paper = data[i].billstatus == 'OK'? 'paperOn':'paperOff';
                    metal = data[i].coinstatus == 'OK'? 'metalOn':'metalOff';

                    synthesize += '<div class="tabContent"><div class="showTab"><ul><li><a href="/home?123">'+data[i].deviceid+'</a></li><li>'+data[i].vmname+'</li>';
                    synthesize += '<li class="'+internet+'">('+newDate+')</li>';
                    synthesize += '<li><i class="'+paper+'"></i>/<i class="'+metal+'"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    synthesize += '<ul><li>今日<span>(金额/次数)</span></li><li>故障轨道</li><li>缺货轨道</li><li>库存<span>(故障)</span></li><li>';
                    synthesize += '</li></ul><ul><li>'+data[i].today+'</li><li>'+data[i].guzhangguidaoNum+'</li><li>'+data[i].quehuoguidaoNum+'</li>';
                    synthesize += '<li>'+data[i].kucunNum+'('+data[i].guzhangguidaoNum+')</li><li></li></ul><ul><li>柜子/连体箱</li><li>版本</li>';
                    synthesize += '<li>钱箱</li><li></li></ul><ul><li>'+data[i]['guizi/liantiji']+'</li><li>'+wordNum(data[i].version)+'</li>';
                    synthesize += '<li>1元:'+data[i].coin1yuan+'个; 5角:'+data[i].coin5jiao+'个</li><li></li></ul></div></div>';

                }
                synthesizeLastId = data[data.length-1].deviceid;
                onBeack(data,'#synthesize','.synthesize',on,synthesize)
                //滚动加载
                loading = false
            },
            error: function (jqXHR) {
                $.toast("加载失败", "cancel");
                setTimeout(function(){
                    history.go(-1);
                },1000)
            }
        })
    }


    function drinkAjax(){
        $.ajax({
            type: 'GET',
            url: '/integratedMachineData',
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                console.log(data);
                var drink = '',internet = '', paper = '', metal = '',newDate;
                for(var i=0;i<0;i++){

                    newData = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    paper = data[i].billstatus == 'OK'? 'paperOn':'paperOff';
                    metal = data[i].coinstatus == 'OK'? 'metalOn':'metalOff';

                    drink += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>未设定</li><li class="internetOn">(05-11 08:40:12)</li>';
                    drink += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div>';
                    drink += '<div class="hideTab"><ul><li>一元/5角个数</li><li>故障轨道</li><li>缺货轨道</li><li>在库件数<span>(故障)</span></li><li></li></ul><ul>';
                    drink += '<li class="none">NONE/NONE</li><li>0</li><li>7</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>门状态</li>';
                    drink += '<li class="minWord">温度模式/室内温度<br/>设置温度</li><li>左温度/右温度</li><li></li></ul><ul><li>-- / --</li><li>关</li><li>冷/17/18</li>';
                    drink += '<li>---</li><li></li></ul><ul><li>轨道数</li><li>柜子/连体机</li><li>版本</li><li></li><li></li></ul><ul><li>7</li><li>A</li>';
                    drink += '<li>光脚一号/1.1.2</li><li></li><li></li></ul></div></div>';
                }

                drinkLastId = data[data.length-1].deviceid;
                //onBeack(data,drinkLoading,'#drink',on,drink)
                loading = false
            },
            error: function (jqXHR) {
                if (jqXHR.status == 400){

                }
            }
        })
    }

    function coffeeAjax(){
        $.ajax({
            type: 'GET',
            url: '/integratedMachineData',
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                console.log(data);
                var coffee = '',internet = '', paper = '', metal = '',newDate;
                for(var i=0;i<data.length;i++){
                    newData = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    paper = data[i].billstatus == 'OK'? 'paperOn':'paperOff';
                    metal = data[i].coinstatus == 'OK'? 'metalOn':'metalOff';

                    coffee += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>杭州以勒308—C</li><li class="internetOn">(07-11 08:40:12)</li>';
                    coffee += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    coffee += '<ul><li>一元/5角个数</li><li>机器类型</li><li>故障信息</li><li>咖啡品种</li><li></li></ul><ul><li>10/20</li><li>308-C</li>';
                    coffee += '<li class="minWord">outcoffee命令发送3次对方无应答</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>料盒</li><li>咖啡温度/保持温度</li>';
                    coffee += '<li>柜子/连体机</li><li></li></ul><ul><li>90/18</li><li class="minWord">红茶/牛奶/白咖啡/巧克力/糖</li><li>98/95</li><li>---</li><li></li></ul><ul>';
                    coffee += '<li>版本</li><li></li><li></li><li></li></ul><ul><li>308-C咖啡机/1.0.0</li><li></li><li></li><li></li></ul></div></div>';

                }

                loading = false;
                coffeeLastId = data[data.length-1].deviceid;
                //onBeack(data,drinkLoading,'#coffee',on,coffee);

            },
            error: function (jqXHR) {
                if (jqXHR.status == 400){

                }
            }
        })
    }

    var coffee = '',internet = '', paper = '', metal = '',newDate;
    for(var i=0;i<22;i++){
        newData = 1;
        internet = 1 ? 'internetOn':'internetOff';
        paper = 1 == 'OK'? 'paperOn':'paperOff';
        metal = 1 == 'OK'? 'metalOn':'metalOff';

        coffee += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>杭州以勒308—C</li><li class="internetOn">(07-11 08:40:12)</li>';
        coffee += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
        coffee += '<ul><li>一元/5角个数</li><li>机器类型</li><li>故障信息</li><li>咖啡品种</li><li></li></ul><ul><li>10/20</li><li>308-C</li>';
        coffee += '<li class="minWord">outcoffee命令发送3次对方无应答</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>料盒</li><li>咖啡温度/保持温度</li>';
        coffee += '<li>柜子/连体机</li><li></li></ul><ul><li>90/18</li><li class="minWord">红茶/牛奶/白咖啡/巧克力/糖</li><li>98/95</li><li>---</li><li></li></ul><ul>';
        coffee += '<li>版本</li><li></li><li></li><li></li></ul><ul><li>308-C咖啡机/1.0.0</li><li></li><li></li><li></li></ul></div></div>';

    }
    $('#coffee').find('.coffee').append(coffee);
    $('#coffee').find('.weui-infinite-scroll').css('display','block');
    function onBeack(data,id,childId,state,html,fu){
        var loading;
        if(state){
            $(id).find(childId).html(html);
            dataLength(state);
        }else{
            $(id).find(childId).append(html);
            dataLength();
        }
        function dataLength(state){
            if(data.length < 30){
                loading = true;
                $(id).find('.weui-infinite-scroll').css('display','none');
                if(state){
                    $(id).find('.noContent').css('display','none');
                }else{
                    $(id).find('.noContent').css('display','block');
                }
                $(id).destroyInfinite();
            }else{
                loading = false;
                $(id).find('.weui-infinite-scroll').css('display','block');
                $(id).find('.noContent').css('display','none');
            }
        }
        return loading

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
            return false;
        }else if( dataTimeYYYY == datasYYYY ){
            if( dateTimeshi - datesshi > 1){
                return false;
            }else if(dateTimeshi == datesshi ){
                if(dataTimefen - datasfen > 5 ){
                    return false;
                }else{
                    return true;
                }
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    function wordNum(text){
        var a = 0;
        for(var i = 0;i < text.length;i++){
            if( 'z' >= text[i] ){
                a++;
            }
        }
        if(a >= 11 && text.length < 14){
            return text;
        }else if(a >= 5 && text.length <= 10){
            return text;
        }else{
            return '<p class="ellipsisWord">'+text+'</p>'
        }

    }
    var loading = false;
    $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true;
        var index = $('#Rightimg').attr('data-machine');
        switch (index){
            case 0:
                console.log('1');
                setTimeout(synthesizeAjax(false),3000);
                break;
            case 1:
                console.log('2');
                setTimeout(drinkAjax(false),3000);
                break;
            default:
                console.log('3');
                setTimeout(coffeeAjax(false),3000);

        }
    });

    //后备选择
    // var bb = false;
    // $(window).scroll(function(){
    //     var sTop = $(window).scrollTop();
    //     var dTop = $(document).scrollTop();
    //     var a = $('#synthesize .weui-infinite-scroll').offset().top;
    //     var b = $('#drink .weui-infinite-scroll').offset().top;
    //     var c = $('#coffee .weui-infinite-scroll').offset().top;
    //     // console.log(sTop)
    //     // console.log(a)
    //     // console.log(a)
    //     if(a > 150 && a <260){
    //         if(bb) return;
    //         console.log('2')
    //         bb = true;
    //         setTimeout(function(){
    //             console.log('3')
    //             bb = false;
    //         },2000)
    //     }
    //     if(b > 150 && b <260){
    //         if(bb) return;
    //         console.log('2')
    //         bb = true;
    //         setTimeout(function(){
    //             console.log('3')
    //             bb = false;
    //         },2000)
    //     }
    //     if(c > 150 && c <260){
    //         if(bb) return;
    //         console.log('2')
    //         bb = true;
    //         setTimeout(function(){
    //             console.log('3')
    //             bb = false;
    //         },2000)
    //     }
    // })
})(jQuery)