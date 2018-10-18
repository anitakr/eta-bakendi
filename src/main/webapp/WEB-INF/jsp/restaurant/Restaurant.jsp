<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en" >

<head>
    <title>${restaurant.name}</title>
</head>
<body>
<h1>${restaurant.name} með id: ${restaurant.id}</h1>
<p> Staðsetning: </p>
<p>${restaurant.location}</p>
</body>
</html>
