<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 26.08.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

Hello, Welcome! <br>

Please, fill the fields below: <br>
<form action="/users" method="post">
    Login<br>
    <input type="text" name="login" maxlength="20" required> <br>
    Password:<br>
    <input type="password" name="password" maxlength="20" required> <br>
    <input type="hidden" name="role" value="customer"/>
    <input type="hidden" name="method" value="register"/> <br>
    <%--<jsp:forward page="/registration2.jsp" />--%>
    <input type="submit" value="Next">
</form>

</body>
</html>
