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

        <h1>Éta</h1>
        <h2>Þar sem þú finnur veitingastaðinn þinn</h2>

        <div class="main-content">
            <a href="/search">
                <div class="card">
                <div class="container">
                    <h4><b>Leita</b></h4>
                    <p>Smellið hér til að leita að veitingastað</p>
                </div>
                </div>
            </a>

            <a href="/insert/InsertRestaurant">
                <div class="card">
                <div class="container">
                    <h4><b>Bæta við</b></h4>
                    <p>Smellið hér til að bæta við veitingastað</p>
                </div>
                </div>
            </a>
        </div>


    </body>
    <footer>
    </footer>
</html>
