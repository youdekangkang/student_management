<%--
  Created by IntelliJ IDEA.
  User: Xie Zhixuan
  Date: 2021/10/25
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>

<html>
<head>
    <title>add new Course</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>add new Course</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/course/add" method="post">
<%--        <input type="hidden" value="_method" value="PUT">--%>
        <div class="row">Course Name：<input type="text" name="name"/>               </div>
        <div class="row">Lasting Time：<input type="text" name="hours" />             </div>
        <div class="row">Description：<input type="text" name="description"/>        </div>
        <div class="row">Syllabus：<input type="text" name="syllabus" />          </div>
        <div class="row"><input type="submit" value="add">                    </div>
    </form>
</div>

</body>