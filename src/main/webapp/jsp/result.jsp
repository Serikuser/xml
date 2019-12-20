<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<hr/>
<h3>File parsed with ${parseType} :</h3>
<hr/>

<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Tariff name:</th>
        <th>Operator:</th>
        <th>Launch date:</th>
        <th>Pay Roll:</th>
        <th>Parameters:</th>
        <th>Prices:</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="i" value="1"/>
    <c:forEach items="${tariffs}" var="tariff">
        <tr>
            <td>${i}</td>
            <td>${tariff.tariffName}</td>
            <td>${tariff.operator}</td>
            <td>${tariff.launchDate}</td>
            <td>${tariff.payroll}</td>
            <td>${tariff.parameters}</td>
            <td>${tariff.prices}</td>
        </tr>
        <c:set var="i" value="${i+1}"/>
    </c:forEach>
    </tbody>

</table>
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
