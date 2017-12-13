<%--
  Created by IntelliJ IDEA.
  User: cheese
  Date: 2017/12/9
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<frameset rows="80,*">
    <frame name="top" src="${pageContext.request.contextPath}/frame/top.jsp">
    <frameset cols="150,*" id="main">

        <frame src="${pageContext.request.contextPath}/frame2/left2.jsp">
        <frame name="right" src="${pageContext.request.contextPath}/frame2/right2.jsp">
    </frameset>
</frameset>