<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index</title>
</head>
<body>


<%
    String redirectURL = "tours?method=getAll&level=nobody";
    response.sendRedirect(redirectURL);
%>

</body>
</html>