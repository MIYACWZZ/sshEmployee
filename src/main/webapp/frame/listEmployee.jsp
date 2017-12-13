<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/9/20
  Time: 20:14
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
        <td align="center" style="font-size:24px; color:#999">员工管理</td>
    </tr>
</table>

<br/>

<a href="${pageContext.request.contextPath}/employee_saveUI.action">添加</a>

<table cellspacing="0" border="1" class="table1">
    <thead>
    <tr>
        <th width="450">姓名</th>
        <th width="450">性别</th>
        <th width="450">生日</th>
        <th width="450">入职时间</th>

        <th width="450">用户名</th>
        <th width="450">密码</th>
        <th width="450">电话</th>
        <th width="450">部门</th>
        <th width="450">编辑</th>
        <th width="450">删除</th>

    </tr>
    </thead>
    <tbody>
    <s:iterator value="list" var="e">
        <tr>
            <td align="center"><s:property value="#e.ename"/></td>
            <td align="center"><s:property value="#e.sex" /></td>
            <td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
            <td align="center"><s:date name="#e.joinday" format="yyyy-MM-dd"/></td>

            <td align="center"><s:property value="#e.username" /></td>
            <td align="center"><s:property value="#e.password" /></td>
            <td align="center"><s:property value="#e.ephone" /></td>
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


<table border="0" cellspacing="0" cellpadding="0" width="900px">
    <tr>
        <td align="right">
            <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
            <span>总记录数：<s:property value="totalCount"/> </span>&nbsp;&nbsp;每页<s:property value="pageSize"/> &nbsp;&nbsp;
            <span>
                <s:if test="currPage != 1">
                    <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="currPage !=totalPage">
                    <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="totalPage"/> ">[尾页]</a>&nbsp;&nbsp;
                </s:if>
            </span>
        </td>
    </tr>
</table>
</body>
</html>