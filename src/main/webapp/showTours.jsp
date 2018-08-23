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
                <%--<td>--%>
                <%--<form action = "updateUser.jsp" method="post">--%>
                <%--<input type="hidden" name="id" value="${user.getId()}">--%>
                <%--<input type="hidden" name="name" value="${user.getName()}">--%>
                <%--<input type="hidden" name="age" value="${user.getAge()}">--%>
                <%--<input type="submit" value="Изменить" style="float:left">--%>
                <%--</form>--%>
                <%--<form action="deleteUser.jsp" method="post">--%>
                <%--<input type="hidden" name="id" value="${user.getId()}">--%>
                <%--<input type="submit" value="Удалить" style="float:left">--%>
                <%--</form></td>--%>
        </tr>
    </c:forEach>
</table>

<form action="addTour.jsp">
    <input type="submit" value="Add new tour">
</form>
</body>
</html>