<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/11/27
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>查询员工详情</title>
</head>
<body>
<table cellspacing="0" border="1" class="table1">
    <thead>
    <tr>
        <th width="450">姓名</th>
        <th width="450">性别</th>
        <th width="450">生日</th>
        <th width="450">入职时间</th>

        <th width="450">用户名</th>
        <th width="450">密码</th>
        <th width="450">部门</th>
        <th width="450">编辑</th>
        <th width="450">删除</th>

    </tr>
    </thead>
    <tbody>
    <s:iterator value="findList" var="e">
        <tr>
            <td align="center"><s:property value="#e.ename"/></td>
            <td align="center"><s:property value="#e.sex" /></td>
            <td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
            <td align="center"><s:date name="#e.joinday" format="yyyy-MM-dd"/></td>

            <td align="center"><s:property value="#e.username" /></td>
            <td align="center"><s:property value="#e.password" /></td>
            <td align="center">
                <s:property value="#e.department.dname" />

            </td>
            <td align="center"><a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>">编辑</a></td>
            <td align="center"><a href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>">删除</a></td>
        </tr>
    </s:iterator>

    </tbody>
</table>
<br/>
</body>
</html>
