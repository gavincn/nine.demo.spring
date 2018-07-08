<%--
  Created by IntelliJ IDEA.
  User: pingping
  Date: 7月/8/18
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload</title>
</head>
<body>
this is /jsp/upload.jsp</br>
<hr>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadfiles">
  <ul>
    <li><input type="file" name="formFile" multiple/></li>
    <li><input type="submit" value="submit"/></li>
  </ul>
</form>

</body>
</html>