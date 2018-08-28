<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <style>
        body {
            font-family: "Lato", sans-serif;
        }


        tr:hover {background-color:#c5c5c5;}
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>

<div class="col-md-2">
    <%--<div class="jumbotron">--%>


        <form action="users" method="post">
            <input type="hidden" name="method" value="login">
            <br>
            <input type="text" class="form-control" name="login" maxlength="20" required>
            <input type="password" class="form-control" name="password" maxlength="20" required>
            <br>
            <input type="submit" class="btn-primary form-control" value="Login">
        </form>

        <form action="registration1.jsp">
            <input type="submit" class="btn-primary form-control" value="Register">
        </form>

        <br>
        <form action="tours" method="get">
            <input type="hidden" name="method" value="getSortedByPrice">
            <input type="submit" class="btn-primary form-control" value="Sort by price">
        </form>

        <form action="tours" method="get">
            <input type="hidden" name="method" value="getSortedByDiscount">
            <input type="submit" class="btn-primary form-control" value="Sort by discount">
        </form>
        <%--<a href="#">About</a>--%>
        <%--<a href="#">Services</a>--%>
        <%--<a href="#">Clients</a>--%>
        <%--<a href="#">Contact</a>--%>
    <%--</div>--%>
</div>

<div class="col-md-10">
    <%--<div class="jumbotron">--%>
    <div align="center">
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
    <%--</div>--%>
    </div>
    <%--<h2>Sidenav Example</h2>--%>
    <%--<p>This sidenav is always shown.</p>--%>
</div>

</body>
</html>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">--%>
<%--<meta charset="utf-8">--%>
<%--<title>Login</title>--%>
<%--</head>--%>
<%--<body style="background-color: #4b5257">--%>
<%--<div class="container-fluid">--%>
<%--<div class="row-fluid">--%>
<%--<div class="span2">--%>
<%--<form action="registration1.jsp">--%>
<%--<input type="submit" value="Register">--%>
<%--</form>--%>

<%--<form action="users" method="post">--%>
<%--<input type="hidden" name="method" value="login">--%>
<%--<input type="text" name="login" maxlength="20" required>--%>
<%--<input type="password" name="password" maxlength="20" required>--%>
<%--<input type="submit" value="Login">--%>
<%--</form>--%>

<%--<form action="tours" method="get">--%>
<%--<input type="hidden" name="method" value="getSortedByPrice">--%>
<%--<input type="submit" value="Sort by price">--%>
<%--</form>--%>

<%--<form action="tours" method="get">--%>
<%--<input type="hidden" name="method" value="getSortedByDiscount">--%>
<%--<input type="submit" value="Sort by discount">--%>
<%--</form>--%>
<%--</div>--%>
<%--<div class="span10">--%>
<%--<table border="2">--%>
<%--<tr>--%>
<%--<td>ID</td>--%>
<%--<td>Name</td>--%>
<%--<td>Price</td>--%>
<%--<td>HOT!!!</td>--%>
<%--<td>Discount</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${tours}" var="tour">--%>
<%--<tr>--%>
<%--<td>${tour.getTourId()}</td>--%>
<%--<td>${tour.getName()}</td>--%>
<%--<td>${tour.getPrice()}</td>--%>
<%--<td>${tour.isHot()}</td>--%>
<%--<td>${tour.getDiscount()}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<form action="registration1.jsp">--%>
<%--<input type="submit" value="Register">--%>
<%--</form>--%>

<%--<form action="users" method="post">--%>
<%--<input type="hidden" name="method" value="login">--%>
<%--<input type="text" name="login" maxlength="20" required>--%>
<%--<input type="password" name="password" maxlength="20" required>--%>
<%--<input type="submit" value="Login">--%>
<%--</form>--%>

<%--<form action="tours" method="get">--%>
<%--<input type="hidden" name="method" value="getSortedByPrice">--%>
<%--<input type="submit" value="Sort by price">--%>
<%--</form>--%>

<%--<form action="tours" method="get">--%>
<%--<input type="hidden" name="method" value="getSortedByDiscount">--%>
<%--<input type="submit" value="Sort by discount">--%>
<%--</form>--%>

<%--<table border="2">--%>
<%--<tr>--%>
<%--<td>ID</td>--%>
<%--<td>Name</td>--%>
<%--<td>Price</td>--%>
<%--<td>HOT!!!</td>--%>
<%--<td>Discount</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${tours}" var="tour">--%>
<%--<tr>--%>
<%--<td>${tour.getTourId()}</td>--%>
<%--<td>${tour.getName()}</td>--%>
<%--<td>${tour.getPrice()}</td>--%>
<%--<td>${tour.isHot()}</td>--%>
<%--<td>${tour.getDiscount()}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>

<%--</body>--%>
<%--</html>--%>