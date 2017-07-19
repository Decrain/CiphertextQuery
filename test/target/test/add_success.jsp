<%--
  Created by IntelliJ IDEA.
  User: Decrain
  Date: 2017/3/6
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="zh-cn">
<body>

<head>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">


    <script src="css/html5shiv.min.js"></script>
    <script src="css/respond.min.js"></script>
    <![endif]-->
    <title>密文检索系统</title>
</head>
<div class="container">
    <div class="col-md-6 col-md-offset-1">
    <form role="form" action="Stu_add" method="post" id="addForm" name="addForm">
        <br/><br/>
        &nbsp; &nbsp; &nbsp; &nbsp;<div style="color:#4F94CD;">
        <h3>密文检索系统(添加数据)</h3>
    </div>
        <br/><br/>
        <div class="form-group">
            <label for="addName">输入字符</label>
            <input type="text" class="form-control" id="addName" name="name" placeholder="请输入字符如:abc">

        </div>

        <div class="form-group">
            <label for="addNum">输入数值</label>
            <input type="text" class="form-control" id="addNum" name="num" placeholder="请输入数值如:123">

        </div>


        <button type="submit" class="btn btn-default" style="color: #4F94CD;">添加数据</button>
        <button  class="btn btn-default" onclick="window.location.href='query.jsp'" value="检索"/>
        <a href="query.jsp" target="_blank">检索数据</a>

    </form>
    </div>


</div>
<% session.invalidate();
%>
</body>
</html>
