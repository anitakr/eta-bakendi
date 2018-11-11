<%@ page contentType="text/html; charset=UTF-8" %>
<header>
    <ul>
        <li style="float:left"><a href="/">ÉTA</a></li>
        <c:choose>
            <c:when test="${not empty usersession}">
                <li><a href="./logout" class="button">Log out</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="./login" class="button">Login</a></li>
                <li><a href="./signup" class="button">Sign Up</a></li>
            </c:otherwise>
        </c:choose>

    </ul>
</header>