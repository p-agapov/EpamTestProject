<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit user</title>
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
        <form action="users" method="post">
            <input type="text" name="login" class="form-control"  maxlength="20" required placeholder="Login">
            <br>
            <input type="password" name="password" class="form-control"  maxlength="20" required placeholder="Password">
            <br>
            <select name="role" class="form-control"  required>
                <option>customer</option>
                <option>manager</option>
            </select>
            <input type="hidden" name="id" value="${param.id}">
            <br>
            <input type="hidden" name="method" value="set"/>
            <input type="submit" class="btn-success form-control">
        </form>
        <br>
        <c:out value="${yes}" default="No updates done yet"/>
        <br>

        <form action="users" method="get">
            <input type="hidden" name="method" value="getAll"/>
            <input type="submit" value="Back" class="btn-primary form-control">
        </form>
    </div>
</div>
</body>
</html>
