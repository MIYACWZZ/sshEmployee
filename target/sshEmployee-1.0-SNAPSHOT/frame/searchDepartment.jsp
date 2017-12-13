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
    <title>查询部门的所有员工</title>
</head>
<body>
<s:form id="findDepForm" method="POST" action="employee_findEmployeeByDid" namespace="/" theme="simple">
    <s:select name="department.did" list="list"  listKey="did" listValue="dname" headerKey="0" headerValue="--请选择--"/></td>
    <a href="javascript:document.getElementById('findDepForm').submit()">查询</a> &nbsp;&nbsp;
</s:form>



</body>
</html>
