<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/12/12
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666">请假条处理</td>
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
<s:form id="saveForm" method="POST" action="center_updateLeave" namespace="/" theme="simple">
    <s:hidden name="lid" value="%{model.lid }"></s:hidden>
    <table border='0' cellpadding="0"  cellspacing="10">
        <tr>
            <td>处理请假条状态：</td>
            <td><s:textfield name="lvalue" value="%{model.lvalue }"/></td>
        </tr>

    </table>
</s:form>
</body>
</html>
