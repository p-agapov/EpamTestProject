<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders list</title>
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
        <form action="logged" method="get">
            <input type="hidden" name="method" value="getTours">
            <input type="submit" class="btn-primary form-control" value="Show all tours">
        </form>


        <form action="logged" method="get">
            <input type="hidden" name="method" value="getSortedByPrice">
            <input type="submit" class="btn-primary form-control" value="Sort by price">
        </form>

        <form action="logged" method="get">
            <input type="hidden" name="method" value="getSortedByDiscount">
            <input type="submit" class="btn-primary form-control" value="Sort by discount">
        </form>
        <H3>You:</H3>
        <c:out value="${customer.getName()} ${customer.getSurname()}"/>
    </div>
</div>
<div class="col-md-10">
    <table border="2" width="80%" align="center" id="customers">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>HOT!!!</th>
            <th>Discount</th>
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
</div>
</body>
</html>
