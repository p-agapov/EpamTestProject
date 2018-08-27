<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours list</title>
</head>
<body>

<form action="registration1.jsp">
    <input type="submit" value="Register">
</form>

<form action="users" method="post">
    <input type="hidden" value="login">
    <input type="text" name="login" maxlength="20" required>
    <input type="password" name="password" maxlength="20" required>
    <input type="submit" value="Login">
</form>

<form action="tours" method="get">
    <input type="hidden" name="method" value="getSortedByPrice">
    <input type="submit" value="Sort by price">
</form>

<form action="tours" method="get">
    <input type="hidden" name="method" value="getSortedByDiscount">
    <input type="submit" value="Sort by discount">
</form>

<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>HOT!!!</td>
        <td>Discount</td>
    </tr>
    <c:forEach items="${tours}" var="tour">
        <tr>
            <td>${tour.getTourId()}</td>
            <td>${tour.getName()}</td>
            <td>${tour.getPrice()}</td>
            <td>${tour.isHot()}</td>
            <td>${tour.getDiscount()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>