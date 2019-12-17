<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Uploading Form</title>
</head>

<body>
<h3>File upload:</h3>
Select file:
<br/>
<form action="upload" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50"/>
    <br/>
    <input type="submit" value="Upload"/>
</form>

<form action="parse" method="get" name="drop_down_box">
    <select name="menu" size="1">
        <option selected="selected" value="DOM">DOM</option>
        <option value="SAX">SAX</option>
        <option value="StAX">StAX</option>
    </select>
    <input type="submit" value="Parse"/>
</form>

</body>

</html>