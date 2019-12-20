<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Upload page</title>
</head>
<body>
<hr/>
<h3>File upload:</h3>
<hr/>
Select file:
<br/>
<form action="controller" method="post"
      enctype="multipart/form-data">
    <input type="hidden" name="command" value="upload"/>
    <input type=file name="file" accept="application/xml" required="required" title="no file"/>
    <br/>
    <input type="submit" value="Upload"/>
</form>
</hr>
<div id="footer" style="text-align: left">&copy; SIARHEI PORSH traning.by Task:XML
</div>
</body>
</html>
