<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users</title>
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

        <form action="addUser.jsp" method="get">
            <input type="submit" class="btn-success form-control" value="Add user">
        </form>

        <form action="users" method="post" onsubmit="return(confirm('Realy?'))">
            <input type=submit class="btn-danger form-control" value="Delete All">
            <input type="hidden" name="method" value="deleteAll"/>
        </form>

        <form action="users" method="get">
            <input type="hidden" name="method" value="get"/>
            <h5>Enter ID to find user:</h5>
            <input type="text" class="form-control" name="id" title="id"/>
            <input type="submit" value="Search" class="btn-primary form-control" title="search">
        </form>
        <h5>Total quantity:
            <c:out value="${users.size()}"/></h5>
        </form>
    </div>
</div>
<div class="col-md-10">
    <table border="2" width="80%" align="center" id="customers">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Role</th>
            <th>Options</th>
        </tr>
        <tr>
            <td>${defUser.getId()}</td>
            <td>${defUser.getLogin()}</td>
            <td>${defUser.getRole()}</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td><c:out value="${user.getLogin()}" default="no"/></td>
                <td>${user.getRole()}</td>
                <td>
                    <form action="updateUser.jsp" method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="hidden" name="login" value="${user.getLogin()}">
                        <input type="hidden" name="password" value="${user.getPassword()}">
                        <input type="hidden" name="role" value="${user.getRole()}">
                        <input type="submit" class="btn-primary form-control" value="Edit" style="float:left">
                    </form>
                    <form action="users" method="post" onsubmit="return(confirm('Realy?'))">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="submit" class="btn-danger form-control" value="Delete" style="float:left">
                        <input type="hidden" name="method" value="delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
