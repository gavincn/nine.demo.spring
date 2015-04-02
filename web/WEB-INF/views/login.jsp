<%--
  Created by IntelliJ IDEA.
  User: pingping
  Date: 三月/7/15
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
this is /jsp/login.jsp
${message}
<form method="post" enctype="multipart/form-data" action="/web/login">
  <ul>
    <li>name:<input name="name"/></li>
    <li>password:<input name="password"/> </li>
    <li><input type="file" name="formFile"/></li>
    <li><input type="submit" value="submit"/></li>
  </ul>
</form>

</body>
</html>