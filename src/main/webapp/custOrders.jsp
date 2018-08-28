<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Customer Orders</title>
</head>
<body>

Orders: <br>
<br>

<table border="2">
    <tr>
        <td>Order </td>
        <td>Tour Number</td>
        <td>Price</td>
        <td>Paid</td>
    </tr>
    <tr>
        <c:forEach items="${orders}" var="order">
            <td>${order.getOrderId()}</td>
            <td><c:set var="tourId" value="${order.getTourId()}"/>
                    ${order.getTourId}
            </td>
        </c:forEach>
        <td>
            <form action="tours" method="get">
                <input type="hidden" name="method" value="get">
                <input type="hidden" name="id" value="tourId">
                <input type="button" value="Tour info">
            </form>
        </td>
    </tr>
</table>

</body>
</html>