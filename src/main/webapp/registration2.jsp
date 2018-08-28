<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <meta charset="utf-8">
    <title>Registration Form</title>

    <style>
        .col-centered{
            float: none;
            margin: 0 auto;
        }
    </style>
</head>
<body style="background-color: #4b5257">
<div class="container">
    <div class="col-xs-30 col-sm-8 col-md-4 col-lg-4 col-centered">
        <div class="jumbotron">
            <h3>Let me know you</h3>
            <form action="logged" method="post">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Enter Name" required>
                </div>
                <div class="form-group">
                    <input type="text" name="surname" class="form-control" placeholder="Enter Surname" required>
                </div>
                <input type="hidden" name="method" value="add"/>
                <input type="hidden" name="vip" value="false"/>
                <input type="hidden" name="user_id" value="${userId}"/>
                <button type="submit" class="btn-primary form-control">Login</button>
            </form>
        </div>
</div>
</body>
