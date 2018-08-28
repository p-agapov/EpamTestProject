<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Control pannel</title>
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
        <h5>Control panel</h5>
        <form action="users" method="post">
            <input type="hidden" name="level" value="manager"/>
            <input type="hidden" name="method" value="logout"/>
            <input type="submit" class="btn-primary form-control" value="Logout">
        </form>

        <form action="tours" method="get">
            <input type="hidden" name="level" value="manager"/>
            <input type="hidden" name="method" value="getAll"/>
            <input type="submit" class="btn-primary form-control" value="Tours">
        </form>
        <form action="users" method="get">
            <input type="hidden" name="method" value="getAll"/>
            <input type="submit" class="btn-primary form-control" value="Users">
        </form>
        <form action="customers" method="get">
            <input type="hidden" name="method" value="getAll"/>
            <input type="submit"class="btn-primary form-control"  value="Customers">
        </form>
    </div>
</div>
<div class="col-md-10">
</div>
</body>
</html>
