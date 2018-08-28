<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <meta charset="utf-8">
    <title>Registration Form</title>

    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .sidenav {
            height: 100%;
            width: 300px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #6d7479;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .sidenav a {
            padding: 6px 6px 6px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .main {
            margin-left: 300px; /* Same as the width of the sidenav */
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
    </style>
</head>
<body style="background-color: #4b5257">
<div class="container">

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
<%--<html>--%>
<%--<head>--%>
    <%--<title>Registration Name</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--Please, fill the fields below: <br>--%>
<%--<form action="logged" method="post">--%>
    <%--<input type="hidden" name="method" value="add"/>--%>
    <%--Name:<br>--%>
    <%--<input type="text" name="name" maxlength="20" required> <br>--%>
    <%--Surname:<br>--%>
    <%--<input type="text" name="surname" maxlength="20" required> <br>--%>
    <%--<input type="hidden" name="vip" value="false"/>--%>
    <%--<input type="hidden" name="user_id" value="${userId}"/>--%>
    <%--<input type="submit" value="Next">--%>
<%--</form>--%>


<%--</body>--%>
<%--</html>--%>
