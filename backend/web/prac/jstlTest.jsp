<%--
  Created by IntelliJ IDEA.
  User: Xie Zhixuan
  Date: 2021/10/25
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" >
Item <c:out value="${i}"/><p>
    </c:forEach>
</body>

</html>
