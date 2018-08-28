<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 26.08.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <meta charset="utf-8">
    <title>Register</title>

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
            <h3>Fill in:</h3>
            <form action="users" method="post">
                <div class="form-group">
                    <input type="text" name="login" class="form-control" placeholder="Enter Username" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Enter password" required>
                    <input type="hidden" name="role" value="customer"/>
                    <input type="hidden" name="method" value="register"/>
                </div>
                <button type="submit" class="btn-primary form-control">Register</button>
            </form>
        </div>
    </div>
</div>
</body>