<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Environment Variables</title>
</head>
<body>
<h1>Environment Variables:</h1>
<table border="1">
    <tr>
        <th>Variable</th>
        <th>Value</th>
    </tr>
    <c:forEach items="${variablesList}" var="variable">
        <c:set var="splitVar" value="${variable.split(':')}"/>
        <tr>
            <td>${splitVar[0]}</td>
            <td>${splitVar[1]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>