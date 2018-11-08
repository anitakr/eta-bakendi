<!-- Author: Elvar (eas20@hi.is) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html lang="en" >

<head>
    <title>Éta</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/insert.css"/>"/>

</head>

<body>
<h1>
    Setja inn nýjan veitingastað
</h1>
<c:if test="${inserted}">
    <p>${newRestaurant.name} skráður!</p>
    <p style="display: inline">Klikkaðu hér til að skoða: </p><a href="/restaurant/${newRestaurant.id}">${newRestaurant.name}</a>
</c:if>
<sf:form method="POST" modelAttribute="restaurant" action="/insert">

    <table>
        <tr>
            <td> Nafn:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
            <td><sf:input path="name" type="text" placeholder="Nafn"/></td>
        </tr>
        <tr>
            <td> Staðsetning:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
            <td><sf:input path="location" type="text" placeholder="Staðsetning"/></td>
        </tr>

        <tr>
            <td>Um veitingastað</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
            <td><sf:input path="description" type="text" placeholder="Sláu eitthvað inn um staðinn"/></td>
        </tr>
        <tr>
            <td> Verð:</td>
                <td><%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <sf:select path="price" type="text" placeholder="Veldu verð">
                    <sf:option value="Ódýrt">Ódýrt</sf:option>
                    <sf:option value="Miðlungs">Milli</sf:option>
                    <sf:option value="Dýrt">Dýrt</sf:option>
                </sf:select>
            </td>
        </tr>
        <tr>
            <td> Tegund:</td>
            <td>
            <sf:select path="genre" type="text" placeholder="Veldu tög">
                <sf:option value="Genre 1">Genre 1</sf:option>
                <sf:option value="Genre 2">Genre 2</sf:option>
                <sf:option value="Genre 3">Genre 3</sf:option>
                <sf:option value="Genre 4">Genre4</sf:option>
                <sf:option value="Genre 5">Genre 5</sf:option>
            </sf:select>
            </td>
        </tr>
        <tr>
            <td>
                Tögg
            </td>
            <td>
                <sf:checkboxes path="tags"  items="${tags}"/>

            </td>
        </tr>

    </table>

    <input type="submit" VALUE="Vista nýjan veitingastað"/>

</sf:form>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</html>

