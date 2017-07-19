<%--
  Created by IntelliJ IDEA.
  User: Decrain
  Date: 2017/3/9
  Time: 17:23
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
    <title>密文检索系统</title>
</head>
<body>
<jsp:forward page="Stu_retrieve.action"></jsp:forward>
</body>
</html>
