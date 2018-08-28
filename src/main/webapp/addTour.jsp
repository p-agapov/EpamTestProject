<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new tour</title>
    <title>Tours list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <style>
        body {
            font-family: "Lato", sans-serif;
        }
        .line {
            padding: 30px;
        }
    </style>
</head>
<body>
<div class="col-md-2">
    <div class="line">
        <form action="tours" method="post">
            <input type="hidden" name="method" value="add"/>
            <input type="hidden" name="level" value="manager"/>
            <input required type="text" class="form-control" name="name" placeholder="Name">
            <br>
            <input required type="number" class="form-control" name="price" placeholder="Price">
            <br>
            <input type="checkbox" name="hot" placeholder="Hot">
            <br>
            <input required type="number"class="form-control" name="discount" placeholder="Discount">
            <br>
            <input type="submit" class="btn-success form-control" value="Save">
        </form>
    </div>
</div>
</body>
</html>
