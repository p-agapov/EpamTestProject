<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours list</title>
</head>
<body>
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
                <form action="updateTour.jsp" method="post">
                    <input type="hidden" name="id" value="${tour.getTourId()}">
                    <input type="hidden" name="name" value="${tour.getName()}">
                    <input type="hidden" name="price" value="${tour.getPrice()}">
                    <input type="hidden" name="hot" value="${tour.isHot()}">
                    <input type="hidden" name="discount" value="${tour.getDiscount()}">
                    <input type="submit" value="Change" style="float:left">
                </form>
                <form action="/tours" method="post">
                    <input type="hidden" name="method" value="delete"/>
                    <input type="hidden" name="id" value="${tour.getTourId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="addTour.jsp">
    <input type="submit" value="Add new tour">
</form>
</body>
</html>