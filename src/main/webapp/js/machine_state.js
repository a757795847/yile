(function ($) {
    var loading = false;
    var synthesizeState = true;
    var drinkState = true;
    var coffeeState = true;
    function indexState(){
        $.showLoading();
        synthesizeAjax(true);
        drinkAjax(true);
        coffeeAjax(true);
    }
    indexState();
    $('#Rightimg').on('touchend',function(){
        $("#Rightimg").addClass("transform");
        var index = $(this).attr('data-machine');
        setTimeout(function(){$("#Rightimg").removeClass("transform");},300)
        $.showLoading("正在加载...");
        switch(index){
            case '0':
                $('.synthesize').empty();
                synthesizeAjax(true);
                break;
            case '1':
                $('.drink').empty();
                drinkAjax(true);
                break;
            default:
                $('.coffee').empty();
                coffeeAjax(true);
        }


    });
    $('#Leftimg').on('touchend',function(){
        location.href = '/yile/home?123';
    });

    tab('#synthesize',4,68);
    tab('#drink',6,68);
    tab('#coffee',6,68);
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
        switch (index){
            case 0:
                if(synthesizeState){
                    $('.weui-infinite-scroll').css('display','block');
                }else{
                    $('.weui-infinite-scroll').css('display','none');
                };
                break;
            case 1:
                if(drinkState){
                    $('.weui-infinite-scroll').css('display','block');
                }else{
                    $('.weui-infinite-scroll').css('display','none');
                };
                break;
            default:
                if(coffeeState){
                    $('.weui-infinite-scroll').css('display','block');
                }else{
                    $('.weui-infinite-scroll').css('display','none');
                };
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
            url: '/yile/integratedMachineData',
            data:data,
            dataType: 'json',
            success: function (data) {
                
                $.hideLoading();
                var synthesize = '',internet = '', paper = '', metal = '',newDate;
                for(var i=0;i<data.length;i++){
                    newDate = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    paper = data[i].billstatus == 'OK'? 'paperOn':'paperOff';
                    metal = data[i].coinstatus == 'OK'? 'metalOn':'metalOff';
                    data[i].today = data[i].today == '/0'? '--/--':data[i].today;
                    data[i]['guizi/liantiji'] = data[i]['guizi/liantiji'] == ''? '—':data[i]['guizi/liantiji'];
                    data[i].vmname = data[i].vmname == ''?'未设定':data[i].vmname;

                    synthesize += '<div class="tabContent"><div class="showTab"><ul><li><a href="/yile/saleList?'+data[i].deviceid+'">'+data[i].deviceid+'</a></li><li>'+data[i].vmname+'</li>';
                    synthesize += '<li class="'+internet+'">('+newDate+')</li><li><i class="'+paper+'"></i>/<i class="'+metal+'"></i>';
                    synthesize += '</li><li class="showBtn"><img src="/img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    synthesize += '<ul><li>今日<span>(金额/次数)</span></li><li>故障轨道</li><li>缺货轨道</li><li>库存<span>(故障)</span></li><li>';
                    synthesize += '</li></ul><ul><li>'+data[i].today+'</li><li>'+data[i].guzhangguidaoNum+'</li><li>'+data[i].quehuoguidaoNum+'</li>';
                    synthesize += '<li>'+data[i].kucunNum+'('+data[i].guzhangguidaoNum+')</li><li></li></ul><ul><li>柜子/连体箱</li><li>版本</li>';
                    synthesize += '<li>钱箱</li><li></li></ul><ul><li>'+data[i]['guizi/liantiji']+'</li><li>'+wordNum(data[i].version)+'</li>';
                    synthesize += '<li>1元:'+data[i].coin1yuan+'个; 5角:'+data[i].coin5jiao+'个</li><li></li></ul></div></div>';
                    //data[i].version
                }
                if(data.length < 25){
                    synthesizeState = false;
                }else{
                    loading = false;
                }
                synthesizeLastId = data[data.length-1].rd;
                onBeack(data,'#synthesize','.synthesize',on,synthesize)
                //滚动加载
            },
            error: function (jqXHR) {
                $('.weui-infinite-scroll').css('display','none');
                synthesizeState = false
                $.hideLoading();
                $.toast("加载失败", "cancel");
                // setTimeout(function(){
                //     history.go(-1);
                // },1000)
            }
        })
    }

    function drinkAjax(on){
        if(on){
            var data = {}
        }else{
            var data = {
                'rd':synthesizeLastId
            }
        }
        $.ajax({
            type: 'GET',
            url: '/yile/drinkMachineData',
            data:data,
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                var drink = '',internet = '',newDate;
                for(var i=0;i<data.length;i++){

                    newData = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    data[i].today = data[i].today == '/--' ? '— / —':data[i].today;
                    data[i].tempnow = data[i].tempnow == '-/-'? '—':data[i].tempnow;
                    data[i]['guizi/liantiji'] = data[i]['guizi/liantiji'] == ''? '—':data[i]['guizi/liantiji'];
                    data[i].vmname = data[i].vmname == ''?'未设定':data[i].vmname;

                    drink += '<div class="tabContent"><div class="showTab"><ul><li><a href="/yile/saleList?'+data[i].deviceid+'">'+data[i].deviceid+'</a></li><li>'+data[i].vmname+'</li>';
                    drink += '<li class="'+internet+'">('+newData+')</li>';
                    drink += '<li>'+data[i].guzhangguidaoNum+'</i></li><li class="showBtn"><img src="/img/18.png" alt="下拉"></li></ul></div>';
                    drink += '<div class="hideTab"><ul><li>一元/5角个数</li><li>轨道数</li><li>缺货轨道</li><li>在库件数<span>(故障)</span></li><li></li></ul><ul>';
                    drink += '<li class="none">'+data[i].number+'/'+data[i].number+'</li><li>'+data[i].tracknum+'</li><li>'+data[i].quehuoguidaoNum+'</li><li>'+data[i].kucunNum+'</li>';
                    drink += '<li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>门状态</li><li class="minWord">温度模式/室内温度<br/>设置温度</li><li>左温度/右温度</li>';
                    drink += '<li></li></ul><ul><li>'+data[i].today+'</li><li>'+data[i].doorstatus+'</li><li>'+data[i].tempstatus+'</li><li>'+data[i].tempnow+'</li><li></li></ul>';
                    drink += '<ul><li>柜子/连体机</li><li>版本</li><li><li></li></li><li></li></ul><ul><li>'+data[i]['guizi/liantiji']+'</li>';
                    drink += '<li>'+data[i].version+'</li><li></li><li></li><li></li></ul></div></div>';
                }
                if(data.length < 25){
                    drinkState = false;
                }else{
                    loading = false;
                }
                drinkLastId = data[data.length-1].rd;
                onBeack(data,'#drink','.drink',on,drink);
            },
            error: function (jqXHR) {
                $('.weui-infinite-scroll').css('display','none');
                drinkState = false;
                $.hideLoading();
                $.toast("加载失败", "cancel");
            }
        })
    }

    function coffeeAjax(on){
        if(on){
            var data = {}
        }else{
            var data = {
                'rd':synthesizeLastId
            }
        }
        $.ajax({
            type: 'GET',
            url: '/yile/coffeeMachineData',
            dataType: 'json',
            success: function (data) {
                $.hideLoading();
                var coffee = '',internet = '', paper = '', metal = '',newDate='', errorData='';
                for(var i=0;i<data.length;i++){

                    newData = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    paper = data[i].billstatus == 'OK'? 'paperOn':'paperOff';
                    metal = data[i].coinstatus == 'OK'? 'metalOn':'metalOff';
                    data[i].errorstr = data[i].errorstr == ''? '无':data[i].errorstr;
                    data[i]['guizi/liantiji'] = data[i]['guizi/liantiji'] == ''? '—':data[i]['guizi/liantiji'];
                    data[i].today = data[i].today == '/--' ? '0/0':data[i].today;
                    data[i].vmname = data[i].vmname == ''?'未设定':data[i].vmname;

                    coffee += '<div class="tabContent"><div class="showTab"><ul><li><a href="/yile/saleList?'+data[i].deviceid+'">'+data[i].deviceid+'</a></li><li>'+data[i].vmname+'</li><li class="'+internet+'">('+newData+')</li>';
                    coffee += '<li><i class="'+paper+'"></i>/<i class="'+metal+'"></i></li><li class="showBtn"><img src="/img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    coffee += '<ul><li>一元/5角个数</li><li>机器类型</li><li>故障信息</li><li>咖啡品种</li><li></li></ul><ul><li>'+data[i].number+'</li><li>'+data[i].types+'</li>';
                    coffee += '<li>'+wordNum(data[i].errorstr)+'</li><li>'+data[i].coffeeNum+'</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>料盒</li><li>咖啡温度/保持温度</li>';
                    coffee += '<li>柜子/连体机</li><li></li></ul><ul><li>'+data[i].today+'</li><li>'+wordNum(data[i].foldname)+'</li><li>'+data[i].temp+'</li><li>'+data[i]['guizi/liantiji']+'</li><li></li></ul><ul>';
                    coffee += '<li>版本</li><li></li><li></li><li></li></ul><ul><li>'+data[i].version+'</li><li></li><li></li><li></li></ul></div></div>';

                }

                if(data.length < 25){
                    coffeeState = false;
                }else{
                    loading = false;
                }
                coffeeLastId = data[data.length-1].rd;
                onBeack(data,'#coffee','.coffee',on,coffee);

            },
            error: function (jqXHR) {
                $('.weui-infinite-scroll').css('display','none');
                coffeeState = false;
                $.hideLoading();
                $.toast("加载失败", "cancel");
            }
        })
    }

    function dataTimeAjax(data){
        var dataDateri ,dataDateyue,dateTimeshi,dataTimefen;
        var dateTime = new Date();
        var datas = data.split('.')[0];
        if(dateTime.getDate() <10){
            dataDate = '0'+dateTime.getDate();
        }else{
            dataDate = dateTime.getDate();
        }
        if(dateTime.getMonth() <10){
            dataDateyue = dateTime.getMonth()+1;
            dataDateyue = '0'+ dataDateyue;
        }else{
            dataDateyue = dateTime.getMonth()+1;
        }
        var dataTimeYYYY = dateTime.getFullYear()+'-'+dataDateyue+'-'+dataDate;
        var datasYYYY = datas.split(' ')[0];
        if(dateTime.getMonth() <10){
            dateTimeshi = dateTime.getHours();
            dateTimeshi = '0'+ dateTimeshi;
        }else{
            dateTimeshi = dateTime.getHours();
        }
        //dateTimeshi = dateTime.getHours().toString();
        var datesshi = datas.substring(11,13);
        if(dateTime.getHours() <10){
            dateTimeshi = dateTime.getHours();
            dateTimeshi = '0'+ dateTimeshi;
        }else{
            dateTimeshi = dateTime.getHours();
        }
        if(dateTime.getMinutes() <10){
            dataTimefen = dateTime.getHours();
            dataTimefen = '0'+ dataTimefen;
        }else{
            dataTimefen = dateTime.getMinutes();
        }
        
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
        if(text.length <7){
            return text;
        }else if(a >= 11 && text.length < 14){
            return text;
        }else if(a > 5 && text.length <= 10){
            return text;
        }else{
            return '<p class="ellipsisWord">'+text+'</p>'
        }

    }

    function onBeack(data,id,childId,state,html){
        if(state){
            $(id).find(childId).html(html);

        }else{
            $(id).find(childId).append(html);

        }
        if(data.length < 25){
            $('.weui-infinite-scroll').css('display','none');
            if(state && data.length < 20){
                $(id).find('.noContent').css('display','none');
            }else{
                $(id).find('.noContent').css('display','block');
            }
        }else{
            $('.weui-infinite-scroll').css('display','block');
            $(id).find('.noContent').css('display','none');
        }

    }


    $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true;
        var index = $('#Rightimg').attr('data-machine');
        switch (index){
            case '0':
                if(synthesizeState){
                    synthesizeAjax(false)
                }
                break;
            case '1':
                if(drinkState){
                    drinkAjax(false)
                }
                break;
            default:
                if(coffeeState){
                    coffeeAjax(false)
                }

        }
    });


})(jQuery)