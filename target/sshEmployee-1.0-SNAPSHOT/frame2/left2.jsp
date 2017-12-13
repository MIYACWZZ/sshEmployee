<%--
Created by IntelliJ IDEA.
User: cheese
Date: 2017/9/20
Time: 20:14
To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/dtree.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/frame/dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
    <div class="dtree">
        <script type="text/javascript">
            d = new dTree('d');
            d.add('01', '-1', '员工管理系统');
            d.add('0101', '01', '员工个人中心');
            d.add('010101', '0101', '公司通讯录', '${pageContext.request.contextPath}/center_findAll.action', '', 'right');
            d.add('010102', '0101', '请假条', '${pageContext.request.contextPath}/center_showLeave.action', '', 'right');
            d.add('010103', '0101', '打卡（暂时未开通）', '${pageContext.request.contextPath}/center_checkUI.action', '', 'right');


            document.write(d);
        </script>
    </div>
</table>

</body>
</html>
