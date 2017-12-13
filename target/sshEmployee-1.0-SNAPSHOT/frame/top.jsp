<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/9/20
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
</style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
欢迎您：<s:property value="#session.existEmployee.ename" />&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/employee_exit.action" target="_top">退出</a>
</div>
</body>
</html>
