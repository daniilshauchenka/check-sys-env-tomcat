<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Environment Variables</title>
</head>
<body>
<h1>Properties:</h1>
<table border="1">
    <tr>
        <th>Variable</th>
        <th>Value</th>
    </tr>
    <c:forEach items="${propertiesList}" var="property">
        <c:set var="splitVar" value="${property.split(':')}"/>
        <tr>
            <td>${splitVar[0]}</td>
            <td>${splitVar[1]}</td>
        </tr>
    </c:forEach>
</table>
<h1>Environment Variables:</h1>
<table border="1">
    <tr>
        <th>Variable</th>
        <th>Value</th>
    </tr>
    <c:forEach items="${envList}" var="env">
        <c:set var="splitVar" value="${env.split(':')}"/>
        <tr>
            <td>${splitVar[0]}</td>
            <td>${splitVar[1]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>