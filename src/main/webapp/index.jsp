<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Frontpage</title>
</head>
<body>

<%
    String redirectURL = "/showToursNobody.jsp";
    response.sendRedirect(redirectURL);
%>

</body>
</html>