<%--
  Created by IntelliJ IDEA.
  User: Xie Zhixuan
  Date: 2021/10/28
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>user Space</title>
    <%
        String username = (String)session.getAttribute("username");
//        String picturePath=request.getServletContext().getRealPath("/images")+"/"+username+".jpg";
//        String picturePath=request.getServletContext().getRealPath("/WEB-INF/jsp/images")+"\\"+username+".jpg";
        String picturePath="/pic/"+username+".jpg";
        System.out.println(picturePath);
    %>

</head>
<body>



<form action="/user/space" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>

<br>

<a href="/user/download">获取你上传的头像</a>

<br>
${sessionScope.get("username")}
<br>

<img src="<%=picturePath%>" />
<span>from <%=picturePath%></span>


<br>
<form action="/user" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="log Out">
</form>


</body>
</html>
