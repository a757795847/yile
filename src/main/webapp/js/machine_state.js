(function ($) {
    var loading = false;
    var synthesizeState = true;
    var drinkState = true;
    var coffeeState = true;
    var tabs = [];
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

    tab('#synthesize',4,70);
    tab('#drink',6,70);
    tab('#coffee',6,68);
    $('.machineHeader').on('touchstart','li',function(){
        $('.machineHeader li').removeClass('active');
        $(this).addClass('active');
        var index = $(this).index();
        $('.weui_tab_bd').find('.weui_tab_bd_item').removeClass('weui_tab_bd_item_active')
        $('.weui_tab_bd .weui_tab_bd_item').eq(index).addClass('weui_tab_bd_item_active')
        $('#Rightimg').attr('data-machine',index);
        if(tabs.length == 3){
            $('.machineHeader li').eq(index-1).removeClass('borderLeft');
            if(index != 1){
                $('.machineHeader li').eq(index-2).addClass('borderLeft');
            }
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
                var synthesize = '',internet = '', paper = '', metal = '',newDate='',guzhan,zhaoling;
                for(var i=0;i<data.length;i++){
                    newDate = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    if( data[i].billstatus.toUpperCase() == ''){
                        paper = ''
                    }else if(data[i].billstatus.toUpperCase() == 'OK'){
                        paper = 'paperOn';
                    }else{
                        paper = 'paperOff';
                    }
                    if( data[i].coinstatus.toUpperCase() == ''){
                        metal = ''
                    }else if(data[i].coinstatus.toUpperCase() == 'OK'){
                        metal = 'paperOn';
                    }else{
                        metal = 'paperOff';
                    }
                    if( data[i].coinoutstatus.toUpperCase() == ''){
                        zhaoling = ''
                    }else if(data[i].coinoutstatus.toUpperCase() == 'OK'){
                        zhaoling = 'paperOn';
                    }else{
                        zhaoling = 'paperOff';
                    }

                    data[i].today = data[i].today == '/0'? '--/--':data[i].today;
                    data[i]['guizi/liantiji'] = data[i]['guizi/liantiji'] == ''? '--':data[i]['guizi/liantiji'];
                    data[i].vmname = data[i].vmname == ''?'未设定':data[i].vmname;
                    guzhan = data[i].guzhangguidaoNum == 0? '':'('+data[i].guzhangguidaoNum+')';

                    synthesize += '<div class="tabContent"><div class="showTab"><ul><li><a href="/yile/saleList?'+data[i].deviceid+'">'+data[i].deviceid+'</a></li><li class="liCenter"><p class="ellipsisWord">'+data[i].vmname+'</p></li>';
                    synthesize += '<li class="'+internet+'">('+newDate+')</li><li>'+data[i].kucunNum+guzhan+'</li>';
                    synthesize += '<li class="showBtn"><img src="/img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    synthesize += '<ul><li>今日<span>(金额/次数)</span></li><li>纸币/硬币/硬币找零</li><li>缺货轨道</li><li>故障轨道</li><li>';
                    synthesize += '</li></ul><ul><li>'+data[i].today+'</li><li><i class="'+paper+'"></i>'+ (data[i].coinstatus.toUpperCase() == ''? '':'/') +'<i class="'+metal+'"></i>'+(data[i].coinoutstatus.toUpperCase() == ''? '':'/') +'<i class="'+zhaoling+'"></i></li><li>'+data[i].quehuoguidaoNum+'</li>';
                    synthesize += '<li>'+data[i].guzhangguidaoNum+'</li><li></li></ul><ul><li>版本</li><li>柜子/连体机</li>';
                    synthesize += '<li></li><li></li></ul><ul><li class="liCenter"><p class="ellipsisWord">'+data[i].version+'</p></li><li>'+data[i]['guizi/liantiji']+'</li>';
                    synthesize += '<li></li><li></li></ul></div></div>';
                    //data[i].version
                }
                if(data.length < 25){
                    synthesizeState = false;
                }else{
                    loading = false;
                }
                if(data.length != 0 ){
                    synthesizeLastId = data[data.length-1].rd;
                }

                onBeack(data,'#synthesize','.synthesize',on,synthesize);
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
                var drink = '',internet = '',newDate,guzhan;
                for(var i=0;i<data.length;i++){

                    newData = data[i].lastnettime.split('.')[0].substring(5);
                    internet = dataTimeAjax(data[i].lastnettime) ? 'internetOn':'internetOff';
                    data[i].today = data[i].today == '/--' ? '--/--':data[i].today;
                    data[i].tempnow = data[i].tempnow.replace(/-/g,'--')
                    data[i]['guizi/liantiji'] = data[i]['guizi/liantiji'] == ''? '--/--':data[i]['guizi/liantiji'];
                    data[i].vmname = data[i].vmname == ''?'未设定':data[i].vmname;
                    data[i].tempstatus = data[i].tempstatus.replace(/-/g,'--');
                    guzhan = data[i].guzhangguidaoNum == 0? '':'('+data[i].guzhangguidaoNum+')';

                    drink += '<div class="tabContent"><div class="showTab"><ul><li><a href="/yile/saleList?'+data[i].deviceid+'">'+data[i].deviceid+'</a></li><li class="liCenter"><p class="ellipsisWord">'+data[i].vmname+'</p></li>';
                    drink += '<li class="'+internet+'">('+newData+')</li>';
                    drink += '<li>'+data[i].doorstatus+'</i></li><li class="showBtn"><img src="/img/18.png" alt="下拉"></li></ul></div>';
                    drink += '<div class="hideTab"><ul><li>一元/5角个数</li><li>在库件数<span>(故障)</span></li><li>缺货轨道</li><li>轨道数</li><li></li></ul><ul>';
                    drink += '<li>'+data[i].number+'</li><li>'+data[i].kucunNum+guzhan+'</li><li>'+data[i].quehuoguidaoNum+'</li><li>'+data[i].tracknum+'</li>';
                    drink += '<li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>柜子/连体机</li><li>温度模式/室内温度/设置温度</li>';
                    drink += '<li></li></ul><ul><li>'+data[i].today+'</li><li>'+data[i]['guizi/liantiji']+'</li><li>'+data[i].tempstatus+'</li><li></li></ul>';
                    drink += '<ul><li>版本</li><li>左温度/右温度</li><li></li></ul><ul><li class="liCenter"><p class="ellipsisWord">'+data[i].version+'</p></li>';
                    drink += '<li>'+data[i].tempnow+'</li><li></li></ul></div></div>';
                }
                if(data.length < 25){
                    drinkState = false;
                }else{
                    loading = false;
                }
                if(data.length != 0 ) {
                    drinkLastId = data[data.length - 1].rd;
                }
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
                    if( data[i].billstatus.toUpperCase() == ''){

                    }
                    paper = data[i].billstatus.toUpperCase() == 'OK'? 'paperOn':'paperOff';
                    metal = data[i].coinstatus.toUpperCase() == 'OK'? 'metalOn':'metalOff';
                    data[i].errorstr = data[i].errorstr == ''? '无':data[i].errorstr;
                    data[i]['guizi/liantiji'] = data[i]['guizi/liantiji'] == ''? '--/--':data[i]['guizi/liantiji'];
                    data[i].today = data[i].today == '/--' ? '0/0':data[i].today;
                    data[i].vmname = data[i].vmname == ''?'未设定':data[i].vmname;

                    coffee += '<div class="tabContent"><div class="showTab"><ul><li><a href="/yile/saleList?'+data[i].deviceid+'">'+data[i].deviceid+'</a></li><li class="liCenter"><p class="ellipsisWord">'+data[i].vmname+'</p></li><li class="'+internet+'">('+newData+')</li>';
                    coffee += '<li>'+data[i].types+'</li><li class="showBtn"><img src="/img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
                    coffee += '<ul><li>一元/5角个数</li><li>纸币/硬币找零</li><li>柜子/连体机</li><li>咖啡品种</li><li></li></ul><ul><li>'+data[i].number+'</li><li><i class="'+paper+'"></i>/<i class="'+metal+'"></i></li>';
                    coffee += '<li>'+data[i]['guizi/liantiji']+'</li><li>'+data[i].coffeeNum+'</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>咖啡温度/保持温度</li><li>料盒</li>';
                    coffee += '<li></li></ul><ul><li>'+data[i].today+'</li><li>'+data[i].temp+'</li><li class="liCenter"><p class="ellipsisWord">'+data[i].foldname+'</p></li><li></li></ul><ul>';
                    coffee += '<li>版本</li><li>故障信息</li><li></li></ul><ul><li class="liCenter"><p class="ellipsisWord">'+data[i].version+'</p></li><li class="liCenter"><p class="ellipsisWord">'+data[i].errorstr+'</p></li><li></li></ul></div></div>';

                }

                if(data.length < 25){
                    coffeeState = false;
                }else{
                    loading = false;
                }
                if(data.length != 0 ) {
                    coffeeLastId = data[data.length - 1].rd;
                }
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
        var dataDate ,dataDateyue,dateTimeshi,dataTimefen;
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

        //dateTimeshi = dateTime.getHours().toString();
        var datesshi = datas.substring(11,13);
        if(dateTime.getHours() <10){
            dateTimeshi = dateTime.getHours();
            dateTimeshi = '0'+ dateTimeshi;
        }else{
            dateTimeshi = dateTime.getHours();
        }
        if(dateTime.getMinutes() <10){
            dataTimefen = dateTime.getMinutes();
            dataTimefen = '0'+ dataTimefen;
        }else{
            dataTimefen = dateTime.getMinutes();
        }

        var datasfen = datas.substring(14,16);
        if(dataTimeYYYY > datasYYYY){
            return false;
        }else if( dataTimeYYYY == datasYYYY ){
            if( dateTimeshi > datesshi ){
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
    for (var i=0;i<$('.machineHeader li').length;i++){
        var data = $('.machineHeader li').eq(i).attr('data-session')
        var key = $('.machineHeader li').eq(i).attr('data-name')
        if(data == 'true'){
            tabs.push(key);
        }
    }
    tabsList();
    function tabsList() {
        var aLi = $('.machineHeader').find('li');
        for (var i=0;i<tabs.length;i++){
            for (var j=0;j<aLi.length;j++){
                if($('.machineHeader').find('li').eq(j).attr('data-name') == tabs[i]){
                    if(tabs.length == 1){
                        $('.machineHeader').find('li').css('width','100%')
                        $('.machineHeader').find('li').eq(j).removeClass('none borderLeft active')
                        $('.machineHeader').find('li').eq(j).addClass('active')
                        $('.weui_tab_bd').find('#'+$('.machineHeader').find('li').eq(j).attr('data-name')).addClass('weui_tab_bd_item_active');
                    }else if(tabs.length == 2){
                        $('.machineHeader').find('li').css('width','50%')
                        $('.machineHeader').find('li').eq(j).removeClass('none borderLeft')
                        activeTab(tabs)
                    }else{
                        if(window.screen.width == 320){
                            $('.machineHeader').find('li').css('width','3rem')
                        }else {
                            $('.machineHeader').find('li').css('width','4rem')
                        }
                        $('.machineHeader').find('li').eq(j).removeClass('none borderLeft active')
                        $('.machineHeader').find('li').eq(1).addClass('borderLeft')
                        $('.machineHeader').find('li').eq(0).addClass('active')
                        $('.weui_tab_bd').find('.weui_tab_bd_item').removeClass('weui_tab_bd_item_active');
                        $('.weui_tab_bd').find('#synthesize').addClass('weui_tab_bd_item_active');
                    }
                }
            }
        }
        if(tabs.length == 0){
            $('.machineHeader').hide();
            $('.zhanwei').text('无机器')
        }else{
            $('.machineHeader').show();
            $('.zhanwei').text('')
        }
    }
    function activeTab(arr) {
        $('.weui_tab_bd').find('.weui_tab_bd_item').removeClass('weui_tab_bd_item_active');
        $('.machineHeader').find('li').removeClass('active');
        if(arr.indexOf('synthesize') != -1){
            $('.machineHeader').find('li').eq(0).addClass('active')
            $('.weui_tab_bd').find('#synthesize').addClass('weui_tab_bd_item_active');
        }else{
            if(arr.indexOf('drink') != -1){
                $('.machineHeader').find('li').eq(1).addClass('active')
                $('.weui_tab_bd').find('#drink').addClass('weui_tab_bd_item_active');
            }
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