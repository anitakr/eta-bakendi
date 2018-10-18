<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">

<head>
    <title>Leitarniðurstöður</title>
</head>
<body>
<h1>Leitarniðurstöður</h1>
<c:forEach var="element" items="${results}">
    <a href="/restaurant/${element.id}">
        <h3>${element.name}</h3>
        <p>${element.location}</p>
    </a>
</c:forEach>
</body>
</html>
