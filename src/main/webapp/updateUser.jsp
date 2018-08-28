<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <input type="hidden" name="id" value="${param.id}">
    <br>
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
