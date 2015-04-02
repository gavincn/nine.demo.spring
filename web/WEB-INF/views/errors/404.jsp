<%--
  Created by IntelliJ IDEA.
  User: pingping
  Date: 三月/8/15
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
</head>
<body>
<%
  Exception e = (Exception)request.getAttribute("exception");
  out.print(e.getMessage());
%>
</body>
</html>
