<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new habbit</title>
    <link rel="stylesheet" href="../static/css/bootstrap3.css" th:href="@{/css/bootstrap3.css}">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Habits Builder</a>
        <button aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-target="#navbarColor01" data-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">

            <ul class="navbar-nav mr-auto">
                <li>
                    <a class="nav-link" href="ClientPage.html">Twój profil</a>
                </li>
                <li>
                    <a class="nav-link" href="clientPrizes.html">Twoje osiągnięcia</a>
                </li>
                <li>
                    <a class="nav-link" href="addHabit.html">Dodaj Habit</a>
                </li>

                <li>
                    <a class="nav-link" href="index.html">Wyloguj się</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<c:if test="${addHabitSuccess}">
    <div>Success</div>
</c:if>


<div class="card text-white bg-secondary mb-3" style=" margin: 50px; width: 60%">
    <form method="get" action="ClientServlet">
        <input type="hidden" name="command" value="ADD">


        <div style="margin: 30px; ">
            <h2>Utwórz nowy habit</h2>
            <legend>Podaj dane</legend>
            <label>Podaj nazwę</label>
            <div class="form-group">
                <input type="text" class="form-control" id="name" name="name" placeholder="Nazwa" required>
            </div>


            <label class="mt-4">Wybierz date</label>
            <div style="display: flex;flex-direction: row;justify-content: center;">
                <div>
                    <label for="start">Data początkowa</label>
                    <input type="date" id="start" name="start"
                           value="today"
                           min="today" max="2021-12-31"
                           required >
                </div>
            </div>
            <br/>

            <fieldset class="form-group" >
                <label>Podaj czas trwania aktywności (w minutach)</label> <br/>
                <input type="range" min="1" max="120" value="10" name="time" class="form-range" id="time" oninput="this.nextElementSibling.value = this.value"
                       required>
                <output>10</output>
            </fieldset>
            <br/>
            <label>Podaj godzinę rozpoczęcia</label>
            <br/>
            <input type="time" id="appt" name="appt"
                   min="00:00" max="23:59" required>

            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Utwórz habit</button>

            </fieldset>
        </div>
    </form>

</div>



</body>
</html>