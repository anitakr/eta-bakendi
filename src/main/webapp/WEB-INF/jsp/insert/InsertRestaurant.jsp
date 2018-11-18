<!-- Author: Elvar (eas20@hi.is) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html lang="en">
<!-- Head -->
<head>
    <title>Éta</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css/"/>
    <link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
</head>
<!-- Head -->


<!-- Content  -->
<body>
<%@ include file="../Menu.jsp"%>

<body>
<h1>
    Setja inn nýjan veitingastað
</h1>
<c:if test="${inserted}">
    <p>${newRestaurant.name} skráður!</p>
    <p style="display: inline">Klikkaðu hér til að skoða: </p><a
        href="/restaurant/${newRestaurant.id}">${newRestaurant.name}</a>
</c:if>
<fieldset>
    <sf:form method="POST" modelAttribute="restaurant" action="insert">

        <table>
            <tr>
                <td><h3>Nafn:</h3></td>
                    <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="name" type="text" placeholder="Nafn"/></td>
            </tr>
            <tr>
                <td><h3>Staðsetning</h3></td>
                    <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="location" type="text" placeholder="Staðsetning"/></td>
            </tr>

            <tr>
                <td><h3>Um veitingastað: </h3></td>
                    <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="description" type="text" placeholder="Sláu eitthvað inn um staðinn"/></td>
            </tr>
            <tr>
                <td><h3>Verð: </h3></td>
                <td><%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                    <sf:select path="price" type="text" placeholder="Veldu verð">
                        <sf:option value="Ódýrt">Ódýrt</sf:option>
                        <sf:option value="Miðlungs">Milli</sf:option>
                        <sf:option value="Dýrt">Dýrt</sf:option>
                    </sf:select>
                </td>
            </tr>
            <tr>
                <td>
                    Tegundir
                </td>
                <td>
                    <sf:checkboxes path="genres" items="${genres}"/>

                </td>
            </tr>

        </table>

        <input type="submit" VALUE="Vista nýjan veitingastað"/>

    </sf:form>
</fieldset>
</body>
</html>

