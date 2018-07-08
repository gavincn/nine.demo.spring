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
this is /jsp/login.jsp</br>
${message}
<div class="error ${param.error == true ? '' : 'hide'}">
  登陆失败<br>
  ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
</div>
<hr>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/login"><%--j_spring_security_check--%>
  <ul>
    <li>name:<input name="j_username"/></li>
    <li>password:<input name="j_password"/> </li>
    <li><input type="file" name="formFile"/></li>
    <li><input type="checkbox" name="_spring_security_remember_me"/>两周之内不必登陆</li>
    <li><input type="submit" value="submit"/></li>
  </ul>
</form>
<a href="/web/toupload">upload</a>
</body>
</html>