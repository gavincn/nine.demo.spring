<%--
  Created by IntelliJ IDEA.
  User: pingping
  Date: 三月/8/15
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>--%>
<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.*"%>
<%@page import="java.lang.Exception"%>
<%@ page import="org.apache.logging.log4j.Logger,org.apache.logging.log4j.LogManager" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
  Logger logger = LogManager.getLogger();
  exception = (Exception)request.getAttribute("exception");
//  logger.error("$$$$$$$$$$$$",e);
  response.setStatus(200);
  Throwable ex = null;
  if (exception != null)
    ex = exception;
  if (request.getAttribute("javax.servlet.error.exception") != null)
    ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

  if(ex == null)
    ex = new Exception("unkonw exception");

//  logger.error(ex.getMessage(), ex);
%>
<div style="overflow: auto">
  <a class="btn btn-primary" href="${ctx}">返回首页</a>
  <h2>error - 系统发生内部错误</h2>
  <br />
  <div>错误详细信息：</div>
  <div class="alert alert-error">
    <%=ex.getClass().getName() + "(" + ex.getLocalizedMessage() + ")"%><br />
    <br />
    <hr />
    <br />
    <%
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      out.print(sw);
    %>
  </div>

</div>
</body>
</html>
