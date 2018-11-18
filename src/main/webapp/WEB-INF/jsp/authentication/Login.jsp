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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
        <link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
    </head>

<!-- Content  -->
    <body>

    <%@ include file="../Menu.jsp"%>

        <h1>Skráðu þig inn</h1>


        <sf:form method="POST" modelAttribute="user" action="/authentication/login">

            <fieldset>
                <table>
                    <tr>
                        <td> Nafn:</td>
                        <td><sf:input path="username" type="text" placeholder="Notandanafn"/></td>
                    </tr>
                    <tr>
                        <td>Lykilorð:</td>
                        <td><sf:password path="password" placeholder="Lykilorð"/></td>
                    </tr>
                </table>

                <input type="submit" VALUE="Skrá inn"/>
            </fieldset>
                <h2>
                    <a href="/authentication/signup">Búa til aðgang</a>
                    <a href="/">Til baka</a>
                </h2>
        </sf:form>
        <c:choose>
            <c:when test="${not empty user}">

                <table class="userInfo">
                        <tr>
                            <td>${user.username}</td>
                        <tr>
                        </tr>
                            <td>${user.password}</td>
                        <tr>
                        </tr>
                            <td>${user.email}</td>
                        </tr>
                </table>
            </c:when>
            <c:otherwise>
                <h3>Not logged in</h3>
            </c:otherwise>
        </c:choose>
    </body>
    <footer>
    </footer>
</html>
