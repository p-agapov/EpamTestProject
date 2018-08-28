<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User search result</title>
</head>
<body>

Login =
<c:out value="${user.getLogin()}" default=" Data not found; "/>
Password =
<c:out value="${user.getPassword()}" default=" Data not found; "/>
Role =
<c:out value="${user.getRole()}" default=" Data not found; "/>

</body>
</html>
