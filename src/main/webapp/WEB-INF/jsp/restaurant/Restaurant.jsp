<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<c:choose>

<c:when test="${not empty restaurant}">

<head>
    <title>${restaurant.name}</title>
</head>
<body>
<div>
    <h1>${restaurant.name}</h1>
    <p> Staðsetning: ${restaurant.location}</p>
    <p> Tegund: ${restaurant.genre}</p>
    <p> Verð: ${restaurant.price}</p>
    <c:if test="${not empty restaurant.tags}">
        <h3>Tögg tegd ${restaurant.name}:</h3>
        <table class="tags">
            <c:forEach var="tag" items="${restaurant.tags}">
                <tr>
                    <p>${tag}</p>
                </tr>
            </c:forEach>
        </table>
    </c:if>


</div>
<div>
    <h3>Umsagnir um ${restaurant.name}</h3>
    <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty restaurant.reviewList}">
            <%--Create a table for the Postit Notes--%>
            <table class="notes">

                    <%--For each postit note, that is in the list that was passed in the model--%>
                    <%--generate a row in the table--%>
                    <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
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

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <p>Engar umsagnir til um þennan stað</p>
        </c:otherwise>
    </c:choose>
</div>

<sf:form method="POST" modelAttribute="review" action="/restaurant/${restaurant.id}">

    <table>
        <tr>
            <td>
                <h3>
                    Gefðu veitingastað umsögn
                </h3>
            </td>
        </tr>
        <tr>
            <td> Einkunn:</td>
            <td><%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
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
            <td> Umsögn:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
            <td><sf:input path="text" type="text" placeholder="Umsögn um veitingastað"/></td>
        </tr>
    </table>
    <input type="submit" VALUE="Vista umsögn"/>
</sf:form>
</c:when>
<c:otherwise>
    <h2>Engin veitingastaður finnst hér</h2>
</c:otherwise>
</c:choose>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</html>
