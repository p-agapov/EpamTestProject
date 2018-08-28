<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<form action="managerFrontPage.jsp" method="get">
    <input type="submit" value="Back">
</form>

<form action="users" method="get">
    <input type="hidden" name="method" value="get"/>
    Enter ID to find user:
    <input type="text" name="id" title="id"/>
    <input type="submit" value="Search" title="search">
</form>

<br><br>

<table border="2">
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>Role</td>
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
                    <input type="submit" value="Edit" style="float:left">
                </form>
                <form action="users" method="post" onsubmit="return(confirm('Realy?'))">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Delete" style="float:left">
                    <input type="hidden" name="method" value="delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="addUser.jsp" method="get">
    <input type="submit" value="Add user">
</form>

<br>
<form action="users" method="post" onsubmit="return(confirm('Realy?'))">
    <input type=submit value="Delete All">
    <input type="hidden" name="method" value="deleteAll"/>
</form>

<br>
<form action="users" method="get">
    <input type="hidden" name="method" value="count"/>
    <input type="submit" value="Count" title="count">
    Quantity of Users:
    <c:out value="${amount}" default=" No data "/>
</form>


</body>
</html>
