var req=new XMLHttpRequest();
function queryInfos() {
    //设置传送方式，对应的servlet或action路径，是否异步处理
    req.open("POST", "/info/queryinfos", true);
    //如果设置数据传送方式为post，则必须设置请求头信息
    req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //设置回调函数，当前操作完成后进行的操作
    req.onreadystatechange = callback;

    //Ajax请求发送的数据不是表单，需要拼接数据，格式和get方式一样
    var reqData = "ip=" + document.getElementById("ip").value;
    reqData += "&addr=" + document.getElementById("addr").value;
    reqData += "&time=" + document.getElementById("time").value;
    reqData += "&times=" + document.getElementById("times").value;

    //发送请求
    req.send(reqData);
}
//回调函数
function callback() {
    //如果Ajax和request的状态都正确则进行操作
    if (req.readyState == 4 && req.status == 200) {
        //获取后台返回的数据
        var response = req.responseText;
        //进行对象化处理
        //加上圆括号的目的是迫使eval函数在处理JavaScript代码的时候强制将括号内的表达式转化为对象，而不是作为语句来执行
        //由于json是以"{}"的方式来开始以及结束的，在JS中，它会被当成一个语句块来处理，所以必须强制性的将它转换成一种表达式。
        var jsonobject = eval("(" + response + ")");
        //获取数据的长度
        var datasize = jsonobject.size;
        //获取json中的数据数据
        var datas = jsonobject.datas;

        //删除原有的table数据
        var table = document.getElementById("table");
        var infos = document.getElementById("tbody");
        table.removeChild(infos);
        //此处必须创建tbody，否则无法加入到table中
        infos = document.createElement("tbody");

        //生成新的table数据元素并添加到table中
        for (var i = 0; i < datas.length; i++) {
            var tr = document.createElement("tr");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");

            td1.innerHTML = datas[i].ip;
            td2.innerHTML = datas[i].addr;
            td3.innerHTML = datas[i].time;
            td4.innerHTML = datas[i].times;

            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            infos.appendChild(tr);
        }
        table.appendChild(infos);
    }
}