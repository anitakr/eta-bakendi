<!-- Author: Elvar (eas20@hi.is) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <header>
        <ul>
            <li style="float:left"><a href="/">ÉTA</a></li>
            <li><a href="/authentication/login" class="button">Login</a></li>
            <li><a href="/authentication/signup" class="button">Sign Up</a></li>
        </ul>

    </header>

        <h1>Finndu þinn veitingastað</h1>

        <fieldset>
            <h3>Leita eftir nafni</h3>
                <form method = "POST" action="restaurant/Result.jsp">
                    <p>Veitingastaður: <input type = "text" name = "rest_name"></p>
                    <input type="submit" name="submit" value="Leita" />

                </form>
        </fieldset>


        <fieldset>
            <form method="post" action="restaurant/Result.jsp">

                <h3>Verðbil</h3>

                    <input type="radio" name="verð" value="ódýrt" /> Ódýrt
                    <input type="radio" name="verð" value="milli" /> Milli
                    <input type="radio" name="verð" value="dýrt" /> Dýrt

                <h3>Tegund</h3>

                    <input type="checkbox" name="tegund" value="italskur" /> Ítalskur
                    <input type="checkbox" name="tegund" value="tapas" /> Tapas
                    <input type="checkbox" name="tegund" value="vegan" /> Vegan
                    <input type="checkbox" name="tegund" value="skyndibiti" /> Skyndibiti
                    <input type="checkbox" name="tegund" value="pizza" /> Pizza
                    <input type="checkbox" name="tegund" value="tælenskur" /> Tælenskur
                    <input type="checkbox" name="tegund" value="kebab" />kebab

                    </br>
                    <input type="submit" name="submit" value="Leita" />
            </form>
        </fieldset>



    </body>
    <footer>
    </footer>
</html>
