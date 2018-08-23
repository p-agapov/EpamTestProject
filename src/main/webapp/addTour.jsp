<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new tour</title>
</head>
<body>
<form action="/tours" method="post">
    <input type="hidden" name="method" value="add"/>
    <input required type="text" name="name" placeholder="Name">
    <input required type="number" name="price" placeholder="Price">
    <input required type="checkbox" name="hot" placeholder="Hot">
    <input required type="number" name="discount" placeholder="Price">
    <input type="submit" value="Save">
</form>
</body>
</html>
