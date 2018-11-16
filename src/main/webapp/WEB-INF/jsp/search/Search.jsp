<!-- Author: Elvar (eas20@hi.is) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en" >

<!-- Head -->
    <head>
        <title>Éta</title>
        <link rel="stylesheet" type="text/css" href="/css/index.css/"/>
        <link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
    </head>

<!-- Content  -->
    <body>
    <%@ include file="../Menu.jsp"%>

        <h1>Finndu þinn veitingastað</h1>

        <fieldset>
            <h3>Leita eftir nafni</h3>
                <sf:form method = "POST" modelAttribute="restaurant" action="search?useName=true">
                    <p>Veitingastaður: <sf:input path="name" type="text"/></p>
                    <input type="submit" name="submit" value="Leita" />

                </sf:form>
        </fieldset>


        <fieldset>
            <sf:form method="POST" modelAttribute="restaurant" action="search?useName=false">

                <h3>Verðbil</h3>

                    <sf:radiobuttons path="price" items="${prices}" checked="checked" />

                <h3>Tegund</h3>

                <sf:checkboxes path="genres" items="${genres}"/>


                </br>
                <input type="submit" name="submit" value="Leita" />
            </sf:form>
        </fieldset>
    <c:if test="${not empty results}">
        <fieldset>
        <h3>Leitarniðurstöður</h3>
        <c:forEach var="restaurant" items="${results}">
            <a href="/restaurant/${restaurant.id}">${restaurant.name}</a>
        </c:forEach>
        </fieldset>
    </c:if>

    </body>
    <footer>
    </footer>
</html>
