<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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