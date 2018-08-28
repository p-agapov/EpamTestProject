<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add new customer</title>
</head>
<body>
<H3>Adding new Customer</H3>
Please fill in form below.
<form action="users" method="post">
    <input type="hidden" name="method" value="addCustomer"/>
    <input type="hidden" name="level" value="manager"/>
    <input type="hidden" name="user_id" value="${user_id}"/>
    <p><b>Name</b></p>
    <input required type="text" name="name" placeholder="Name">
    <p><b>Surname</b></p>
    <input required type="text" name="surname" placeholder="Surname">
    <p><b>Status (VIP or not)</b></p>
    <input type="checkbox" name="vip" placeholder="vip">
    <input type="submit" value="Save">
</form>
</body>
</html>
