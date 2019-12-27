<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style type="text/css">
    input.button {
        width: 40px;
        height: 40px;
        border: 0;
        display: flex;
    }
</style>
<body>
<form action="controller" method="GET">
    <input type="hidden" name="command" value="home"/>
    <input type="image" src="/XMLParser/resources/images/homeButton.png" alt="submit" class="button"/>
</form>
</body>