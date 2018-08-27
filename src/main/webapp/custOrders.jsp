<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 26.08.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Orders</title>
</head>
<body>
<%--<c:set>--%>

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
            <form action="/tours" method="get">
                <input type="hidden" name="method" value="get">
                <input type="hidden" name="id" value="tourId">
                <input type="button" value="Tour info">
            </form>
        </td>
    </tr>
</table>

</body>
</html>