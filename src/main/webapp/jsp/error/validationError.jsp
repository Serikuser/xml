<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Validation error page</title>
</head>
<body style="background-color: rgba(250,252,209,0.75)">
<hr/>
<h3>File not valid with reason: ${exception}</h3>
<br>
<%@ include file="/jsp/back.jsp" %>
</hr>
<%@ include file="/jsp/footer.jsp" %>
</body>

</html>
