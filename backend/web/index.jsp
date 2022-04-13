<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Xie Zhixuan
  Date: 2021/10/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>


<html>
  <head>
    <title>Welcome</title>
<%--    <script src="static/js/jquery-3.6.0.js"></script>--%>
<%--    <script src="static/js/myJsFunctions.js"></script>--%>
  </head>
  <body>
  <%=LocalDate.now()%>
  <br>


<%--  <script>--%>
<%--    function fa(){--%>
<%--      $.ajax(--%>
<%--              {--%>
<%--                url:"/course/allCourse",--%>
<%--                method:"post",--%>
<%--                data:{},--%>
<%--                success:function(data){--%>
<%--                  document.write(data);--%>
<%--                //  也只是在该页面打印,并不是真正意义上的跳转.--%>
<%--                }--%>
<%--              }--%>
<%--      );--%>
<%--    }--%>
<%--  </script>--%>

<%--  <button id="btn1" onclick="fa()">点击进入课程表</button>--%>

<%--  <script>--%>
<%--    var btn = document.getElementById('btn1')--%>
<%--    btn.onclick = function () {--%>

<%--        var req=new XMLHttpRequest();--%>
<%--        var url="/course/allCourse";--%>
<%--        req.open("POST",url);--%>
<%--        req.send();--%>

<%--        // window.location.href=url;--%>
<%--    //  又是重新的一次GET请求,无意义--%>
<%--    }--%>
<%--  </script>--%>


<%--  <form name="form1" action="/course" method="post">--%>
<%--      <input type="hidden" name="_method" value="PUT">--%>
<%--  </form>--%>

<%--  <a href="javascript: document.form1.submit()" >click to Course Schedule</a>--%>

<%--  --%>
  <a href="/course?page=1">click to Course Schedule</a>

<%--    <script>--%>
<%--      function httpReq(url,method,params) {--%>
<%--          var temp = document.createElement("form"); //创建form表单--%>
<%--          temp.action = url;--%>
<%--          temp.method = method;--%>
<%--          temp.style.display = "none";//表单样式为隐藏--%>

<%--          for (var parm in params) {--%>
<%--            var inputElement = document.createElement("input");--%>
<%--            inputElement.type = "text";--%>
<%--            inputElement.id = parm;--%>
<%--            inputElement.name = parm;--%>
<%--            inputElement.value = params[parm];--%>
<%--            temp.appendChild(inputElement);--%>
<%--          }--%>

<%--          document.body.appendChild(temp);--%>
<%--          temp.submit();--%>
<%--      }--%>
<%--    </script>--%>

<%--    <a href="javascript: httpReq('/course/allCourse','put')">点击进入课程表</a>--%>
  </body>
</html>
