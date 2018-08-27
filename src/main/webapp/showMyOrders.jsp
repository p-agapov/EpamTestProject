<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours list</title>
</head>
<body>


You:
<c:out value="${customer.getName()} ${customer.getSurname()}"/>


<form action="logged" method="get">
    <input type="hidden" name="method" value="getTours">
    <input type="submit" value="Show all tours">
</form>


<form action="logged" method="get">
    <input type="hidden" name="method" value="getSortedByPrice">
    <input type="submit" value="Sort by price">
</form>

<form action="logged" method="get">
    <input type="hidden" name="method" value="getSortedByDiscount">
    <input type="submit" value="Sort by discount">
</form>

<table border="2">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>HOT!!!</td>
        <td>Discount</td>
    </tr>
    <c:forEach items="${tours}" var="tour">
        <tr>
            <td>${tour.getName()}</td>
            <td>${tour.getPrice()}</td>
            <td>${tour.isHot()}</td>
            <td>${tour.getDiscount()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
