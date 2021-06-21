<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YourPage</title>
    <link rel="stylesheet" href="../static/css/bootstrap3.css" th:href="@{/css/bootstrap3.css}">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Habits Builder</a>
        <button aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation"
                class="navbar-toggler" data-target="#navbarColor01" data-toggle="collapse" type="button">
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


<div class="card text-white bg-secondary mb-3" style=" margin: 10px; width: 50%; display: inline-block ">

    <div style="margin: 10px">
        <h1>Witaj Brad Pitt!</h1>
    </div>
</div>

<div class="top-right" style="margin: 50px">
    <div class="card text-white bg-secondary mb-3" style=" margin: 10px; width: 100%">
        <div style="margin: 10px">
            <h1>Miejsce na coś </h1>
        </div>
    </div>
</div>


<div class="card text-white bg-secondary mb-3" style=" margin: 10px; width: 50%; display: inline-grid">

    <div style="margin: 10px">
        <div>
            <h2>Twój plan na dziś</h2>
            <table class="table table-hover" style="table-layout: fixed">
                <thead>
                <tr class="table-primary">
                    <th scope="row">Habit</th>
                    <th>Godzina</th>
                    <th>Postępy</th>
                    <th></th>


                </tr>
                </thead>
                <c:forEach var="habit" items="${habits}">

                    <c:url var="updateLink" value="ClientServlet">
                        <c:param name="command" value="UPDATE"></c:param>
                        <c:param name="leaveID" value="${habit.id}"></c:param>
                    </c:url>

                    <c:url var="deleteLink" value="ClientServlet">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="leaveID" value="${habit.id}"></c:param>
                    </c:url>

                    <tbody>
                    <td>${habit.name}</td>
                    <td>${habit.time}</td>
                    <td>${habit.status}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="Basic example">
                            <a href="${updateLink}">
                                <button type="button" class="btn btn-sm btn-primary">Modyfikuj</button>
                            </a>
                            <a href="${deleteLink}">
                                <button type="button" class="btn btn-sm  btn-primary">Usuń</button>
                            </a>
                        </div>
                    </td>


                    </tbody>
                </c:forEach>

            </table>
        </div>


    </div>


</div>


<div class="card text-white bg-secondary mb-3" style=" margin: 10px; ">

    <div style="margin: 10px">

        <div>
            <h2>Twój plan na ten tydzień</h2>
            <table class="table table-hover" style="table-layout: fixed">
                <thead>
                <tr class="table-primary">
                    <th scope="row">Pn</th>
                    <th>Wt</th>
                    <th>Śr</th>
                    <th>Czw</th>
                    <th>Pt</th>
                    <th>Sb</th>
                    <th>Nd</th>

                </tr>
                <c:forEach var="habit" items="${weeklyHabits}">

                <tbody>

                <td>${habit}</td>
                <td>${habit}</td>
                <td>${habit}</td>
                <td>${habit}</td>
                <td>${habit}</td>
                <td>${habit}</td>
                </tbody>

                </c:forEach>

                </thead>
            </table>
        </div>
    </div>
</div>

</body>
</html>