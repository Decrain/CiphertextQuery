<%--
  Created by IntelliJ IDEA.
  User: Decrain
  Date: 2017/3/8
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">


    <script src="css/html5shiv.min.js"></script>
    <script src="css/respond.min.js"></script>
    <![endif]-->
    <title>密文检索系统</title>
</head>
<body>
<div class="container">
    <div  style="margin-top:50px;text-align: center;color:#4F94CD;">
        <h3>密文检索系统-字符搜索信息显示(共<s:property value="#session.StuList.size()"/>条)</h3>
    </div>
    <table class="table table-bordered table-striped">
       <%-- <caption>Student Info</caption>--%>
        <thead>
        <tr>
            <th>id</th>
            <th>String</th>
            <th>Integer</th>

        </tr>
        </thead>
        <tbody>
        <s:iterator value="#session.StuList" var="stu">
            <td name="id"><s:property value="#stu.id"/></td>
            <td name="name"><s:property value="#stu.name"/></td>

            <td name="num"><s:property value="#stu.num"/></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
</table>
<% session.invalidate();
%>
</body>
</html>
