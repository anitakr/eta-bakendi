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
    </head>

<!-- Content  -->
    <body>
        <%@ include file="../Menu.jsp"%>


        <sf:form method="POST" modelAttribute="user" action="/authentication/login">

            <table>
                <tr>
                    <td> Name:</td>
                    <td><sf:input path="username" type="text" placeholder="Usersname"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><sf:password path="password" placeholder="Password"/></td>
                </tr>
            </table>

            <input type="submit" VALUE="Submit"/>

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
