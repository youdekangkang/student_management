function httpReq(url,method,params) {
    var temp = document.createElement("form"); //创建form表单
    temp.action = url;
    temp.method="post";
    temp.style.display = "none";//表单样式为隐藏

    var inputMethod=document.createElement("input");
    inputMethod.type="hidden";
    inputMethod.name="_method";
    inputMethod.value=method;

    alert(method);

    for (var parm in params) {
        var inputElement = document.createElement("input");
        inputElement.type = "text";
        inputElement.id = parm;
        inputElement.name = parm;
        inputElement.value = params[parm];
        temp.appendChild(inputElement);
    }

    document.body.appendChild(temp);
    temp.submit();
}