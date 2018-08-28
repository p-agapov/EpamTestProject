<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
If your're here, you're MASTER.
Click one of the buttons below, fast!


<form action="users" method="post">
    <input type="hidden" name="level" value="manager"/>
    <input type="hidden" name="method" value="logout"/>
    <input type="submit" value="Logout">
</form>


<form action="tours" method="get">
    <input type="hidden" name="level" value="manager"/>
    <input type="hidden" name="method" value="getAll"/>
    <input type="submit" value="Tours">
</form>
<form action="users" method="get">
    <input type="hidden" name="method" value="getAll"/>
    <input type="submit" value="Users">
</form>
<form action="customers" method="get">
    <input type="hidden" name="method" value="getAll"/>
    <input type="submit" value="Customers">
</form>

</body>
</html>
