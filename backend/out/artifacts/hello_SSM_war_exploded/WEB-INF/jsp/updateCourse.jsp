<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>update course information</title>
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
                    <small></small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/course/update" method="post">
        <input type="hidden" name="id" value="${course.getId()}"/>
        name：<input type="text" name="name" value="${course.getName()}"/>
        hours：<input type="text" name="hours" value="${course.getHours()}"/>
        description：<input type="text" name="description" value="${course.getDescription() }"/>
        syllabus：<input type="text" name="syllabus" value="${course.getSyllabus() }"/>
        <input type="submit" value="submit"/>
    </form>
</div>