<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/11/1
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>查询某个员工</title>
</head>
<body>
<s:form id="findEmpForm" method="POST" action="employee_findEmployeeByEname" namespace="/" theme="simple">
    <s:textfield name="ename"/>
    <a href="javascript:document.getElementById('findEmpForm').submit()">模糊查询员工</a> &nbsp;&nbsp;
</s:form>



</body>
</html>
