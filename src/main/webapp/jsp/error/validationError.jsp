<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
    <title>Validation error page</title>
</head>
<body>
<hr/>
<h3>File not valid with reason: ${exception}</h3>
<hr/>
<form action="controller" method="get" name="back">
    <input type="hidden" name="command" value="back"/>
    <input type="submit" value="back" name="action">
</form>
</hr>
<div id="footer" style="text-align: left">&copy; SIARHEI PORSH traning.by Task:XML
</div>
</body>

</html>
