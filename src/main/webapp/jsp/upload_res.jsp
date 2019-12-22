<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Parsed info</title>
</head>
<body style="background-color: rgba(250,252,209,0.75)">
<br>
<h3>File <c:out value="${fileName}"/> valid and uploaded.</h3>
<hr/>
Select parser:
<br/>
<form action="controller" method="get" name="drop_down_box">
    <input type="hidden"
           value="${file}" name="path">
    <select name="menu" size="1">
        <option selected="selected" value="DOM">DOM</option>
        <option value="SAX">SAX</option>
        <option value="StAX">StAX</option>
    </select>
    <input type="hidden" name="command" value="parse"/>
    <input type="submit" value="parse"/>
</form>
<br>
<%@ include file="back.jsp" %>
<%@ include file="footer.jsp" %>
</body>
</html>