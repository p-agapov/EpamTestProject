<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new customer</title>
</head>
<body>
<H3>Adding new Customer</H3>
Please fill in form below.
<form action="customers" method="post">
    <input type="hidden" name="method" value="add"/>
    <input type="hidden" name="level" value="manager"/>
    <p><b>Name</b></p>
    <input required type="text" name="name" placeholder="Name">
    <p><b>Surname</b></p>
    <input required type="text" name="surname" placeholder="Surname">
    <p><b>Status (VIP or not)</b></p>
    <input type="checkbox" name="vip" placeholder="vip">
    <p><b>UserID (from users table)</b></p>
    <input required type="number" name="userid" placeholder="User ID">
    <input type="submit" value="Save">
</form>
</body>
</html>
