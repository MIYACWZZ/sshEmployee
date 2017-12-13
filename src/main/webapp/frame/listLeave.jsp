<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/12/11
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <style type="text/css">
        .table1 {
            border: 1px solid #ddd;
            width: 900px;

        }

        thead {
            background-color: lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
    <tr>
        <td align="center" style="font-size:24px; color:#999">员工请假条</td>
    </tr>
</table>

<br/>


<table cellspacing="0" border="1" class="table1">
    <thead>
    <tr>
        <th width="450">编号</th>
        <th width="450">申请人id</th>
        <th width="450">请假理由</th>
        <th width="450">状态</th>
        <th width="450">处理</th>
        <th width="450">删除</th>


    </tr>
    </thead>
    <tbody>
    <s:iterator value="%{#session.allLeave}" var="l">
        <tr>
            <td align="center"><s:property value="#l.lid"/></td>
            <td align="center"><s:property value="#l.leid" /></td>
            <td align="center"><s:property value="#l.ldesc" /></td>
            <td align="center" style="color: red"><s:property value="#l.lvalue"/></td>
            <td align="center"><a href="${pageContext.request.contextPath}/center_editLeave.action?lid=<s:property value="#l.lid"/>">处理</a></td>
            <td align="center"><a href="${pageContext.request.contextPath}/center_delLeave.action?lid=<s:property value="#l.lid"/>">删除</a></td>
        </tr>
    </s:iterator>

    </tbody>
</table>
<br/>

</body>
</html>
