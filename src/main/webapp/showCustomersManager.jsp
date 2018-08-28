<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #337AB7;
            color: white;
        }

        .line {
            padding: 30px;
        }
    </style>
</head>
<body>
<div class="col-md-2">
    <div class="line">
        <form action="managerFrontPage.jsp" method="get">
            <input type="submit" class="btn-primary form-control" value="Back">
        </form>

        <form action="customers" method="post">
            <input type="hidden" name="method" value="deleteAll">
            <input type="submit" class="btn-danger form-control" value="Delete all">
        </form>
        <br><br><br>

        <p>Total quantity: <c:out value="${customers.size()}"/></p>

    </div>
</div>
<div class="col-md-10">
    <table border="2" width="80%" align="center" id="customers">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>VIP</th>
            <th>User ID</th>
            <th>Option</th>
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
                        <input type="submit" class="btn btn-primary form-control btn-xs" value="Change" style="float:left">
                    </form>
                    <br>
                    <form action="customers" method="post">
                        <input type="hidden" name="method" value="delete"/>
                        <input type="hidden" name="id" value="${customer.getCustomerId()}">
                        <input type="submit" class="btn btn-danger form-control btn-xs" value="Удалить" style="float:left">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
