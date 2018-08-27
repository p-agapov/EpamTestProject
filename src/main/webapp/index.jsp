<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Frontpage</title>
</head>
<body>

<form action="tours" method="get">
    <input type="hidden" name="level" value="nobody"/>
    <input type="hidden" name="method" value="getAll"/>
    <input type="submit" value="Begin">
</form>

</body>
</html>