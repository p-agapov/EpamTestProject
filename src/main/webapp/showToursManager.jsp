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
        <form action="managerFrontPage.jsp" method="get">
            <input type="submit" class="btn-primary form-control" value="Back">
        </form>

        <form action="addTour.jsp">
            <input type="submit" class="btn-success form-control" value="Add new tour">
        </form>

        <form action="tours" method="post">
            <input type="hidden" name="level" value="manager"/>
            <input type="hidden" name="method" value="deleteAll">
            <input type="submit" class="btn-danger form-control" value="Delete all tours">
        </form>

        <p>Total tours: <c:out value="${tours.size()}"/></p>


        <form action="tours" method="get">
            <input type="hidden" name="method" value="getSortedByPrice">
            <input type="hidden" name="level" value="manager"/>
            <input type="submit" class="btn-primary form-control" value="Sort by price">
        </form>

        <form action="tours" method="get">
            <input type="hidden" name="method" value="getSortedByDiscount">
            <input type="hidden" name="level" value="manager"/>
            <input type="submit" class="btn-primary form-control" value="Sort by discount">
        </form>

        <form action="tours" method="get">
            <input type="hidden" name="method" value="getFilteredByPrice">
            <input type="hidden" name="level" value="manager"/>
            <input required type="number" class="form-control" name="lower_bound" placeholder="Lower bound">
            <input required type="number" class="form-control" name="higher_bound" placeholder="Higher bound">
            <input type="submit" class="btn-primary form-control" value="Filter">
        </form>
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
            <th>Options</th>
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
                        <input type="hidden" name="level" value="manager"/>
                        <input type="hidden" name="id" value="${tour.getTourId()}">
                        <input type="hidden" name="name" value="${tour.getName()}">
                        <input type="hidden" name="price" value="${tour.getPrice()}">
                        <input type="hidden" name="hot" value="${tour.isHot()?"on":""}">
                        <input type="hidden" name="discount" value="${tour.getDiscount()}">
                        <input type="submit" class="btn btn-primary form-control btn-xs" value="Change"style="float:left">
                    </form>
                    <form action="tours" method="post">
                        <input type="hidden" name="level" value="manager"/>
                        <input type="hidden" name="method" value="delete"/>
                        <input type="hidden" name="id" value="${tour.getTourId()}">
                        <input type="submit" class="btn btn-danger form-control btn-xs" value="Delete" style="float:left">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>