<%--
  Created by IntelliJ IDEA.
  User: Decrain
  Date: 2017/3/7
  Time: 13:36
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
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">


    <script src="css/html5shiv.min.js"></script>
    <script src="css/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <br/>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <div style="color:#4F94CD;">
    <h3>密文检索系统(查找数据)</h3>
    </div>

   <form role="form" action="Stu_queryByNum" method="post" id="queryByNumForm" name="queryNumForm">
        <div class="input-group">
            <input type="text" class="form-control input-lg" id="queryNum" name="num" placeholder="输入数字如:123">
            <span>
                <br/><button type="submit" class="btn btn-default">数值检索</button>
                </span>

        </div>

    </form>

 <br/><br/>
    <form role="form" action="Stu_queryByName" method="post" id="queryByNameForm" name="queryNameForm">
        <div class="input-group">
            <input type="text" class="form-control input-lg" id="queryName" name="name" placeholder="输入字符串如:abc"></input>
            <span> <br/><button type="submit" class="btn btn-default">字符检索</button>
                </span>

        </div>

    </form>

    <br/><br/>
    <form role="form" action="Stu_queryMohuName" method="post" id="queryMohuNameForm" name="queryMohuNameForm">
        <div class="input-group">
            <input type="text" class="form-control input-lg" id="queryMohuName" name="name" placeholder="输入字符串如:abc"></input>
            <span> <br/><button type="submit" class="btn btn-default">模糊检索</button>
                </span>

        </div>

    </form>
</div>


</div>

</body>
</html>
