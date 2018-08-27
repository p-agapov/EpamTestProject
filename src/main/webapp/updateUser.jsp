<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 25.08.2018
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>

<form action="users" method="post">
    Fill the fields: <br>
    Login:<br>
    <input type="text" name="login" maxlength="20" required> <br>
    Password: <br>
    <input type="password" name="password" maxlength="20" required> <br>
    Role: <br>
    <select name="role" required>
        <option>customer</option>
        <option>manager</option>
    </select>
    <%--<input type="text" name="role" maxlength="20"> <br>--%>
    <input type="hidden" name="id" value="${param.id}">
    <br>
    <%--<c:out value="${param.id}" default="no"/>--%>
    <input type="hidden" name="method" value="set"/>
    <input type="submit">
</form>
<br>
<c:out value="${yes}" default="No updates done yet"/>
<br>

<form action="users" method="get">
    <input type="hidden" name="method" value="getAll"/>
    <input type="submit" value="Back to users list">
</form>

</body>
</html>
