(function(){
    var showBtn = document.getElementsByClassName('showBtn');
    function showTab(){
        var hideNode ;
        for(var i=0;i<showBtn.length;i++){
            hideNode = showBtn[i].parentNode.parentNode.parentNode.childNodes;
            console.log(hideNode);
            for(var j=0;j<hideNode.length;j++){
                if(hideNode[j].className == "hideTab"){
                    console.log(hideNode[j].getAttribute('style').slice(':'));
                    //hideNode[j].style.display = hideNode[j].getAttribute('style').slice(':')[1]=='none'?'block:'none';
                }
            }
        }
    }

    for(var i=0;i<showBtn.length;i++){
        showBtn[i].onclick = function(){
            showTab();
        }
    }

})()