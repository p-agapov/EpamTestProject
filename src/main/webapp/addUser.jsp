<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

<form action="users" method="post">
    Fill the fields:<br>
    Login<br>
    <input type="text" name="login" maxlength="20" required> <br>
    Password:<br>
    <input type="password" name="password" maxlength="20" required> <br>
    <br>
    <select name="role" required>
        <option>customer</option>
        <option>manager</option>
    </select>
    <input type="hidden" name="method" value="add"/>
    <br>
    <input type="submit">
</form>

</body>
</html>
