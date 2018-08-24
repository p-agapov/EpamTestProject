<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update tour</title>
</head>
<body>
<form action="/tours" method="post">
    <input type="hidden" name="method" value="set"/>
    <input type="hidden" name="id" value="${param.id}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="number" name="price" value="${param.price}" placeholder=${param.price}>
    <input type="checkbox" name="hot" value="${param.hot}" placeholder=${param.hot}>
    <input type="number" name="discount" value="${param.discount}" placeholder=${param.discount}>
    <input type="submit" value="Update">
</form>
</body>
</html>
