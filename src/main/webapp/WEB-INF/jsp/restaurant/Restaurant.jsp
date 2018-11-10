<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<c:choose>

<c:when test="${not empty restaurant}">

<!-- Head -->
<head>
    <title>${restaurant.name}</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css/"/>
    <link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
</head>
<body>
<header>
    <ul>
        <li style="float:left"><a href="/">ÉTA</a></li>
        <li><a href="/authentication/login" class="button">Login</a></li>
        <li><a href="/authentication/signup" class="button">Sign Up</a></li>
    </ul>

</header>
<h1>${restaurant.name}</h1>
<fieldset>
    <h3> Staðsetning:</h3> ${restaurant.location}
    <h3> Verð: </h3> ${restaurant.price}
    <c:if test="${not empty restaurant.genres}">
        <h3>Tegundir tengdar ${restaurant.name}:</h3>
        <table class="genres">
            <c:forEach var="genre" items="${restaurant.genres}">
                <tr>
                    <p>${genre}</p>
                </tr>
            </c:forEach>
        </table>
    </c:if>


</fieldset>
<fieldset>
    <h3>Umsagnir um ${restaurant.name}</h3>
    <c:choose>
        <c:when test="${not empty restaurant.reviewList}">
            <table class="notes">

                <c:forEach var="review" items="${restaurant.reviewList}">
                    <tr>
                        <div>
                            <h3 style="display: inline">${review.username} - </h3>
                            <p style="display: inline">Einkunn: ${review.rating}</p>
                        </div>
                        <p>${review.text}</p>

                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:otherwise>
            <p>Engar umsagnir til um þennan stað</p>
        </c:otherwise>
    </c:choose>
</fieldset>
<fieldset>
    <sf:form method="POST" modelAttribute="review" action="/restaurant/${restaurant.id}">

        <table>
            <tr>
                <td>
                    <h3>
                        Gefðu veitingastað umsögn
                    </h3>

                    <c:if test="${noUserForReview}">
                        <p>Þú verður að vera innskráð/ur til að geta gefið veitingastað umsögn</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><h3>Einkunn:</h3></td>
                <td>
                    <sf:select path="rating" type="int">
                        <sf:option value="1">1</sf:option>
                        <sf:option value="2">2</sf:option>
                        <sf:option value="3">3</sf:option>
                        <sf:option value="4">4</sf:option>
                        <sf:option value="5">5</sf:option>
                    </sf:select>
                </td>
            </tr>
            <tr>
                <td><h3>Umsögn: </h3></td>
                <td><sf:input path="text" type="text" placeholder="Umsögn um veitingastað"/></td>
            </tr>
        </table>
        <input type="submit" VALUE="Vista umsögn" class="submit-button"/>
    </sf:form>
</fieldset>
</c:when>
<c:otherwise>
    <h2>Engin veitingastaður finnst hér</h2>
</c:otherwise>
</c:choose>
</body>
</html>
