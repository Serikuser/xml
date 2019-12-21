<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Upload page</title>
</head>
<body style="background-color: rgba(250,252,209,0.75)">
<h3>File upload:</h3>
<hr/>
Select file:
<br>
<form action="controller" method="post"
      enctype="multipart/form-data">
    <input type="hidden" name="command" value="upload"/>
    <input type=file name="file" accept="application/xml" required="required" title="no file"/>
    <br>
    <input type="submit" value="Upload"/>
</form>
<br>
<%@ include file="back.jsp" %>
</hr>
<%@ include file="footer.jsp" %>
</body>
</html>
