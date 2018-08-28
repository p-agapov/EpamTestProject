<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tours list</title>
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
            <input type="hidden" name="method" value="getOrders">
            <input type="submit" class="btn-primary form-control" value="Show my orders">
        </form>


        <form action="logged" method="get">
            <input type="hidden" name="method" value="getSortedByPrice">
            <input type="submit" class="btn-primary form-control" value="Sort by price">
        </form>

        <form action="logged" method="get">
            <input type="hidden" name="method" value="getSortedByDiscount">
            <input type="submit" class="btn-primary form-control" value="Sort by discount">
        </form>

        <form action="logged" method="get">
            <input type="hidden" name="method" value="getFilteredByPrice">
            <input type="hidden" name="level" value="customer"/>
            <input required type="number" class="form-control" name="lower_bound" placeholder="Lower bound">
            <input required type="number" class="form-control" name="higher_bound" placeholder="Higher bound">
            <input type="submit" class="btn-primary form-control" value="Filter">
        </form>

        <H5>Sign as:
        <c:out value="${customer.getName()} ${customer.getSurname()}"/></H5>
    </div>
</div>
<div class="col-md-10">
    <table border="2" width="80%" align="center" id="customers">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>HOT!!!</th>
            <th>Discount</th>
            <th>Order</th>
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
                        <input type="submit" class="btn-primary form-control" value="Order and pay" style="float:left">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>