<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 26.08.2018
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Name</title>
</head>
<body>

Please, fill the fields below: <br>
<form action="/customers" method="post">
    Name:<br>
    <input type="text" name="name" maxlength="20" required> <br>
    Surname:<br>
    <input type="text" name="surname" maxlength="20" required> <br>
    <input type="hidden" name="isVip" value="false"/>
    <input type="hidden" name="userId" value="${userId}"/>
    <input type="hidden" name="method" value="add"/>
    <%--<jsp:forward page="/customer.jsp" />--%> <br>
    <input type="submit" value="Next">
</form>


</body>
</html>
