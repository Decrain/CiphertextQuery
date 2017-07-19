<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Decrain
  Date: 2017/3/7
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h3 >密文检索系统(部分信息显示)</h3>
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

        <div  style="margin-top:1px;text-align: center;">
                    <a href="query.jsp" target="_blank" style="  font-size:18px;">检索数据</a>
            <a href="add_success.jsp" target="_blank" style="  font-size:18px;">添加数据</a>

        </div>


</div>

<% session.invalidate();
System.out.println("清空session");
%>


</body>
</html>
