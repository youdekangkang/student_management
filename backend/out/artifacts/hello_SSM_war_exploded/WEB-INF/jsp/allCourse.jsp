<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Course</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/static/js/jquery-3.6.0.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>Course List —— show all courses</small>
                </h1>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-4 column">

<%--      PUT method for adding      --%>
        <form name="form_add" action="/course" method="post">
            <input type="hidden" name="_method" value="PUT">
        </form>
            <a class="btn btn-primary" href="javascript:document.form_add.submit()">add Course</a>
        </div>


        <div class="col-md-4 column pull-right" >
<%--        GET method for searching--%>

<%--            <script>--%>
<%--                function s1(){--%>
<%--                    alert("触发点击函数");--%>
<%--                    console.log("old url:"+$("#form_search").action);--%>
<%--                    $("#form_search").action=$("#form_search").action+"/"+$("#cN").value;--%>
<%--                    console.log("new url"+$("#form_search").action);--%>
<%--                    $("#form_search").submit();--%>
<%--                }--%>

<%--            </script>--%>
<%--            <input type="text" value="请输出查询的课程名" name="Name" id="cN">--%>
<%--            <form action="/course" method="get" id="form_search">--%>
<%--                <input type="text" value="搜索" onclick="s1()">--%>
<%--            </form>--%>

            <script>
                function  s1(){
                    var url="/course/"+document.getElementById("courseName").value;
                    // window.open(url);
                    location.href=url;
                }
            </script>
            <input type="text" value="enter course to search"  id="courseName">
            <button id="btn_q" onclick="s1()">Search</button>
        </div>
    </div>


    <div class="row clearfix">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Time</th>
                    <th>Description</th>
                    <th>Syllabus</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${requestScope.get('list')}">
                    <tr>
                        <td>${course.getId()}</td>
                        <td>${course.getName()}</td>
                        <td>${course.getHours()}</td>
                        <td>${course.getDescription()}</td>
                        <td>${course.getSyllabus()}</td>
                        <td class="row" style="display: flex">
                            <form action=/course/${course.getId()} method="post">
                                <input type="submit" value="Update" class="form-inline" >
                            </form>
<%--                            <a href="${pageContext.request.contextPath}/course/toUpdateCourse/${course.getId()}">更改</a> |--%>

                            <form action=/course/${course.getId()} method="post">
                                <input type="hidden" name="_method" value="DELETE">
                                <input type="submit" value="Delete" class="form-inline">
                            </form>
<%--                            <a href="${pageContext.request.contextPath}/course/del/${course.getId()}">删除</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


           <form action="/course">
               <label for="pageNum">enter page</label>
               <input type="number" min="1" name="page" id="pageNum" placeholder="${page}">
           </form>

        </div>
    </div>
</body>