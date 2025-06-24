<%--
  Created by IntelliJ IDEA.
  User: ehadjadj
  Date: 04/06/2025
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="card-title mb-4">Formulaire Saisie Nom</h1>

            <form method="post" action="${pageContext.request.contextPath}/hello">
                <div class="mb-3">
                    <label for="name" class="form-label">Votre nom :</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="Entrez votre nom" required>
                </div>
                <button type="submit" class="btn btn-primary">Envoyer</button>
            </form>

            <c:if test="${not empty name}">
                <div class="alert alert-success mt-3">
                    Hello the World ${name}
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
