<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers list</title>
</head>
<body>


<form action="managerFrontPage.jsp" method="get">
    <input type="submit" value="Back">
</form>

<form action="addCustomer.jsp">
    <input type="submit" value="Add new customer">
</form>

<form action="customers" method="post">
    <input type="hidden" name="method" value="deleteAll">
    <input type="submit" value="Delete all customers">
</form>

<p>All customers: <c:out value="${customers.size()}"/></p>

<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Surname</td>
        <td>VIP</td>
        <td>User ID</td>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.getCustomerId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getSurname()}</td>
            <td>${customer.isVIP()}</td>
            <td>${customer.getUserId()}</td>
            <td>
                <form action="updateCustomer.jsp" method="post">
                    <input type="hidden" name="id" value="${customer.getCustomerId()}">
                    <input type="hidden" name="name" value="${customer.getName()}">
                    <input type="hidden" name="surname" value="${customer.getSurname()}">
                    <input type="hidden" name="vip" value="${customer.isVIP()?"on":""}">
                    <input type="hidden" name="userid" value="${customer.getUserId()}">
                    <input type="submit" value="Change" style="float:left">
                </form>
                <form action="customers" method="post">
                    <input type="hidden" name="method" value="delete"/>
                    <input type="hidden" name="id" value="${customer.getCustomerId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
