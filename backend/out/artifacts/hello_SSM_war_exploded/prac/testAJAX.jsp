<%--
  Created by IntelliJ IDEA.
  User: Xie Zhixuan
  Date: 2021/10/26
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<%--    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>--%>
    <script>
        function x(){
            $.ajax(
                { "url":"/ajax/t1",
                    "method":"GET",
                    "data":{name:$("#userName").val()},
                    success:function (data,status){
                        alert(data+status);
                    }

                }
            );
        }

    </script>
</head>
<body>
<input type="text" id="userName" value="输入用户名" onblur="x()">

</body>
</html>
