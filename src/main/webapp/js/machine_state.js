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

    console.log($('header').offset().top)
    var synthesize = '',internet = '', paper = '', metal = '', drink = '', coffee = '';
    var internetState = false, paperState = true, metalState = true;

    internet = internetState == true? 'internetOn':'internetOff';
    paper = paperState == true? 'paperOn':'paperOff';
    metal = metalState == true? 'metalOn':'metalOff';

    for(var i=0;i<22;i++){
        synthesize += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">C5A911241281</a></li><li>sohu11栋2号门</li><li class="'+internet+'">(07-17 13:21:07)</li>';
        synthesize += '<li><i class="'+paper+'"></i>/<i class="'+metal+'"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
        synthesize += '<ul><li>今日<span>(金额/次数)</span></li><li>故障轨道</li><li>缺货轨道</li><li>库存<span>(故障)</span></li><li></li></ul><ul><li>90.0/25</li><li>7</li>';
        synthesize += '<li>3</li><li>225(2)</li><li></li></ul><ul><li>柜子/连体箱</li><li>版本</li><li>钱箱</li><li></li></ul><ul><li>ABC</li><li>7寸综合/1.4.6</li>';
        synthesize += '<li>1元:20个; 5角:10个</li><li></li></ul></div></div>';

    }


    $('#synthesize .synthesize').after(synthesize);


    for(var i=0;i<22;i++){
        drink += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>未设定</li><li class="internetOn">(05-11 08:40:12)</li>';
        drink += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div>';
        drink += '<div class="hideTab"><ul><li>一元/5角个数</li><li>故障轨道</li><li>缺货轨道</li><li>在库件数<span>(故障)</span></li><li></li></ul><ul>';
        drink += '<li class="none">NONE/NONE</li><li>0</li><li>7</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>门状态</li>';
        drink += '<li class="minWord">温度模式/室内温度<br/>设置温度</li><li>左温度/右温度</li><li></li></ul><ul><li>-- / --</li><li>关</li><li>冷/17/18</li>';
        drink += '<li>---</li><li></li></ul><ul><li>轨道数</li><li>柜子/连体机</li><li>版本</li><li></li><li></li></ul><ul><li>7</li><li>A</li>';
        drink += '<li>光脚一号/1.1.2</li><li></li><li></li></ul></div></div>';
    }


    $('#drink .drink').after(drink);

    for(var i=0;i<22;i++){
        coffee += '<div class="tabContent"><div class="showTab"><ul><li><a href="#">023041952882</a></li><li>杭州以勒308—C</li><li class="internetOn">(07-11 08:40:12)</li>';
        coffee += '<li><i class="paperOn"></i>/<i class="metalOff"></i></li><li class="showBtn"><img src="../img/18.png" alt="下拉"></li></ul></div><div class="hideTab">';
        coffee += '<ul><li>一元/5角个数</li><li>机器类型</li><li>故障信息</li><li>咖啡品种</li><li></li></ul><ul><li>10/20</li><li>308-C</li>';
        coffee += '<li class="minWord">outcoffee命令发送3次对方无应答</li><li>0</li><li></li></ul><ul><li>今日<span>(金额/次数)</span></li><li>料盒</li><li>咖啡温度/保持温度</li>';
        coffee += '<li>柜子/连体机</li><li></li></ul><ul><li>90/18</li><li class="minWord">红茶/牛奶/白咖啡/巧克力/糖</li><li>98/95</li><li>---</li><li></li></ul><ul>';
        coffee += '<li>版本</li><li></li><li></li><li></li></ul><ul><li>308-C咖啡机/1.0.0</li><li></li><li></li><li></li></ul></div></div>';
    }


    $('#coffee .coffee').after(coffee);

    // $(document.body).infinite().on("infinite", function() {
    //     console.log('0')
    // });
    $('#synthesize').infinite().on("infinite", function() {
        var self = this;
        if(self.loading) return;
        self.loading = true;
        console.log(self);
        setTimeout(function() {
            $('#synthesize .synthesize').after(synthesize);
            self.loading = false;
        }, 1000);
    });
    $('#drink').infinite().on("infinite", function() {
        console.log('2')

    });
    $('#coffee').infinite().on("infinite", function() {
        console.log('3')

    });

        $("#tab1").infinite().on("infinite", function() {
            var self = this;
            if(self.loading) return;
            self.loading = true;
            console.log(self);
            setTimeout(function() {
                $(self).find(".content-padded").append("<p>我是加载的新内容。我是加载的新内容。。。我是加载的新内容。。。我是加载的新内容。。。我是加载的新内容。。。我是加载的新内容。。。我是加载的新内容。。。我是加载的新内容。。。我是加载的新内容。。。。。</p>");
                self.loading = false;
            }, 2000);   //模拟延迟
        });

})(jQuery)