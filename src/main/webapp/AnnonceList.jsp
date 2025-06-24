<%--
  Created by IntelliJ IDEA.
  User: LPT-ILAN
  Date: 24/06/2025
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des annonces</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <h3 class="mb-4">Liste des annonces</h3>

    <c:if test="${not empty sessionScope.message}">
        <div class="alert alert-success">${sessionScope.message}</div>
        <c:remove var="message" scope="session"/>
    </c:if>

    <c:if test="${not empty sessionScope.error}">
        <div class="alert alert-danger">${sessionScope.error}</div>
        <c:remove var="error" scope="session"/>
    </c:if>

    <c:if test="${empty annonces}">
        <div class="alert alert-info">Aucune annonce disponible pour le moment.</div>
    </c:if>

    <c:if test="${not empty annonces}">
        <table class="table table-bordered table-hover">
            <thead class="table-light">
            <tr>
                <th>Titre</th>
                <th>Description</th>
                <th>Adresse</th>
                <th>Email</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="annonce" items="${annonces}">
                <tr>
                    <td>${annonce.title}</td>
                    <td>${annonce.description}</td>
                    <td>${annonce.adress}</td>
                    <td>${annonce.mail}</td>
                    <td>${annonce.date}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/annonce/update?id=${annonce.id}" class="btn btn-warning btn-sm">
                            <i class="bi bi-pencil"></i> Modifier
                        </a>
                        <a href="${pageContext.request.contextPath}/annonce/delete?id=${annonce.id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Voulez-vous vraiment supprimer cette annonce ?');">
                            <i class="bi bi-trash"></i> Supprimer
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/annonce/add" class="btn btn-outline-primary">
            <i class="bi bi-plus-lg"></i> Ajouter une annonce
        </a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
