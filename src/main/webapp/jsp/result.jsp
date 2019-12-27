<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Result</title>
</head>
<body style="background-color: rgba(250,252,209,0.75)">
<h3>File parsed with ${parseType} :</h3>
<%@ include file="home.jsp" %>
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
<br>
<%@ include file="back.jsp" %>
</hr>
<%@ include file="footer.jsp" %>
</body>
</html>
