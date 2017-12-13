<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/12/12
  Time: 7:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666"> 请假条申请</td>
    </tr>
    <tr>
        <td align="right">
            <a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.go(-1)">退回 </a>
        </td>
    </tr>
</table>
<br/>
<br>
<s:form id="saveForm" method="POST" action="center_leaveSave" namespace="/" theme="simple">
    <table style="font-size::16px">

        <tr>
            <td>请假理由：（请详细写上申请人的姓名和部门！否则视为无效！）</td>
            <td></td>
        </tr>
        <tr>
            <td width="10%"></td>
            <td>
                <s:textarea rows="5" cols="50" name="ldesc"/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
