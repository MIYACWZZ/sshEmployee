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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/BeatPicker.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demos.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/prism.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/BeatPicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/prism.js"></script>
</head>
<body>

<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666">员工编辑</td>
    </tr>
    <tr>
        <td align="right">
            <a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.go(-1)">退回</a>
        </td>
    </tr>
</table>
<br/>
<br>
<s:form id="saveForm" method="POST" action="employee_update" namespace="/" theme="simple">
    <s:hidden name="eid" value="%{model.eid }"></s:hidden>
    <table border='0' cellpadding="0"  cellspacing="10">

        <tr>

            <td>姓名：</td>
            <td><s:textfield name="ename" value="%{model.ename }"/></td>
            <td>性别：</td>
            <td><s:radio name="sex" list="{'男','女'}" value="%{model.sex }"/></td>
        </tr>
        <tr>

            <td>用户名：</td>
            <td><s:textfield name="username" value="%{model.username }"/></td>
            <td>密码：</td>
            <td><s:textfield name="password" value="%{model.password }"/></td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><%--<s:textfield name="birthday" value="%{model.birthday }" />--%>
                <input type="text" name="birthday" data-beatpicker="true" value="${model.birthday}" />
            </td>
            <td>入职时间：</td>
            <td>
                <%--<s:textfield name="joinDate" value="%{model.joinday }" />--%>
                <input type="text" name="joinday" data-beatpicker="true" value="${model.joinday}" />

            </td>
        </tr>

        <tr>
            <td>所属部门：</td>
            <td><s:select name="department.did" list="list"  value="%{model.department.did}" listKey="did" listValue="dname" headerKey="0" headerValue="--请选择--"/></td>
            <td>编号：</td>
            <td><s:textfield name="eno" value="%{model.eno }"/></td>
        </tr>
    </table>
</s:form>
</body>
</html> 