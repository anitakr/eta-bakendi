<%@ page contentType="text/html; charset=UTF-8" %>
<header>
    <ul>
        <li style="float:left"><a href="/">ÉTA</a></li>
        <c:choose>
            <c:when test="${not empty user}">
                <li><a href="./authentication/logout" class="button">Skrá út</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="./authentication/login" class="button">Skrá inn</a></li>
                <li><a href="./authentication/signup" class="button">Nýskrá</a></li>
            </c:otherwise>
        </c:choose>

    </ul>
</header>