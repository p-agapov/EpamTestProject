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
    <input type="hidden" name="method" value="getOrders">
    <input type="submit" value="Show my orders">
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
            <td>
                <form action="logged" method="post">
                    <input type="hidden" name="method" value="buy">
                    <input type="hidden" name="tour_id" value="${tour.getTourId()}">
                    <input type="submit" value="Order and pay" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>