<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Validation error page</title>
</head>
<body style="background-color: rgba(250,252,209,0.75)">
<hr/>
<%@ include file="/jsp/home.jsp" %>
<h3>${errorMessage} : ${exception}</h3>
<br>
<%@ include file="/jsp/back.jsp" %>
</hr>
<%@ include file="/jsp/footer.jsp" %>
</body>

</html>
