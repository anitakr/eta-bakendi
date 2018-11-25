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
    <link rel="stylesheet" type="text/css" href="/css/styles.css/"/>
    <link rel="stylesheet" type="text/css" href="/css/forms.css/"/>
    <link rel="stylesheet" type="text/css" href="/css/restaurant.css/"/>
    <link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
</head>
<body>
<%@ include file="../Menu.jsp"%>
<h1>${restaurant.name}</h1>
<fieldset>
    <h4> Staðsetning:</h4> ${restaurant.location}
    <h4> Verð: </h4> ${restaurant.price}
    <c:if test="${not empty restaurant.genres}">
        <h4>Tegundir tengdar ${restaurant.name}:</h4>
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
    <h4>Umsagnir um ${restaurant.name}</h4>
    <c:choose>
        <c:when test="${not empty restaurant.reviewList}">
            <table class="notes">

                <c:forEach var="review" items="${restaurant.reviewList}">
                    <tr>
                        <div>
                            <h4 style="display: inline">${review.username} - </h4>
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
                    <h4>
                        Gefðu veitingastað umsögn
                    </h4>

                    <c:if test="${noUserForReview}">
                        <p>Þú verður að vera innskráð/ur til að geta gefið veitingastað umsögn</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><h4>Einkunn:</h4></td>
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
                <td><h4>Umsögn: </h4></td>
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
