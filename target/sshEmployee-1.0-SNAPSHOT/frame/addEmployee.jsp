<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/9/20
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666"> 员工添加</td>
    </tr>
    <tr>
        <td align="right">
            <a href="#">保存</a> &nbsp;&nbsp;
            <a href="#">退回</a>
        </td>
    </tr>
</table>
<br/>


<table border='0' cellpadding="0" cellspacing="10">

    <tr>

        <td>姓名：</td>
        <td><input type="text"/></td>
        <td>性别：</td>
        <td><input type="text"/></td>
    </tr>
    <tr>
        <td>出生日期：</td>
        <td><input type="text"/></td>
        <td>入职时间：</td>
        <td><input type="text"/></td>
    </tr>

    <tr>
        <td>所属部门：</td>
        <td><select>
            <option>-----请--选--择----</option>
        </select></td>
        <td>编号：</td>
        <td><input type="text"/></td>
    </tr>
</table>


</body>
</html>