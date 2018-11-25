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
        <link rel="stylesheet" type="text/css" href="/css/styles.css/"/>
        <link rel="stylesheet" type="text/css" href="/css/forms.css/"/>
        <link rel="stylesheet" type="text/css" href="/css/login.css/"/>
        <link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
    </head>

<!-- Content  -->
    <body>
    <%@ include file="../Menu.jsp"%>

        <h1>Nýskráning</h1>
        <sf:form method="POST" modelAttribute="user" action="/signup">
            <fieldset>
                <table>
                    <tr>
                        <td> Nafn:</td>
                        <td><sf:input path="username" type="text" placeholder="Veldu notandanafn"/></td>
                        <td><sf:errors path="username"/></td>
                    </tr>
                    <tr>
                        <td>Lykilorð:</td>
                        <td><sf:password path="password" placeholder="Veldu lykilorð"/></td>
                        <td><sf:errors path="password"/></td>
                    </tr>
                    <tr>
                        <td>Netfang:</td>
                        <td><sf:input path="email" type="text" placeholder="Sláðu inn netfang"/></td>
                        <td><sf:errors path="email"/></td>
                    </tr>
                </table>
                <p>
                    Veitingastaðaeigandi
                    <sf:checkbox path="type" value="MANAGER"/>
                </p>
                    <input type="submit" VALUE="Skrá"/>
            </fieldset>

        </sf:form>

        <c:choose>
            <c:when test="${not empty currentUser}">
                <table class="userInfo">
                    <tr>
                        <td>${currentUser.username}</td>
                    <tr>
                    </tr>
                    <td>${currentUser.password}</td>
                    <tr>
                    </tr>
                    <td>${currentUser.email}</td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <h3>Not logged in</h3>
            </c:otherwise>
        </c:choose>
        <p>--------------------------</p>
        <c:choose>
        <c:when test="${not empty users}">
            <table class="users">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.username}</td>
                    <tr>
                    </tr>
                        <td>${user.password}</td>
                    <tr>
                    </tr>
                        <td>${user.email}</td>
                    </tr>
                    </tr>
                        <td>${user.type}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h3>No users!</h3>
        </c:otherwise>
        </c:choose>
    </body>
    <footer>
    </footer>
</html>
