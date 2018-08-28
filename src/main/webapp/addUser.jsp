<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
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
            <input type="text" class="form-control" name="login" maxlength="20" required placeholder="Login">
            <br>
            <input type="password" class="form-control"  name="password" maxlength="20" required placeholder="Password">
            <br>
            <select name="role" class="form-control"  required>
                <option>customer</option>
                <option>manager</option>
            </select>
            <input type="hidden" name="method" value="add"/>
            <br>
            <input type="submit" class="btn-success form-control">
        </form>
    </div>
</div>
</body>
</html>
