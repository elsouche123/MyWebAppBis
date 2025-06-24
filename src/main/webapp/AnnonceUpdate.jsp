<%--
  Created by IntelliJ IDEA.
  User: LPT-ILAN
  Date: 24/06/2025
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Mettre à jour une annonce</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="card shadow-sm">
    <div class="card-body">
      <h3 class="card-title mb-4">Mise à jour de l'annonce</h3>

      <!-- Gestion des messages -->
      <c:if test="${not empty sessionScope.message}">
        <div class="alert alert-success">${sessionScope.message}</div>
        <c:remove var="message" scope="session"/>
      </c:if>

      <c:if test="${not empty sessionScope.error}">
        <div class="alert alert-danger">${sessionScope.error}</div>
        <c:remove var="error" scope="session"/>
      </c:if>

      <c:if test="${not empty message}">
        <div class="alert alert-warning">${message}</div>
      </c:if>

      <form method="post" action="${pageContext.request.contextPath}/annonce/update">
        <input type="hidden" name="id" value="${annonce.id}">

        <div class="mb-3">
          <label for="title" class="form-label">Titre</label>
          <input type="text" class="form-control" id="title" name="title" value="${annonce.title}" required>
        </div>

        <div class="mb-3">
          <label for="description" class="form-label">Description</label>
          <textarea class="form-control" id="description" name="description" rows="3" required>${annonce.description}</textarea>
        </div>

        <div class="mb-3">
          <label for="adress" class="form-label">Adresse</label>
          <input type="text" class="form-control" id="adress" name="adress" value="${annonce.adress}" required>
        </div>

        <div class="mb-3">
          <label for="mail" class="form-label">Email</label>
          <input type="email" class="form-control" id="mail" name="mail" value="${annonce.mail}" required>
        </div>

        <button type="submit" class="btn btn-primary">Mettre à jour</button>
        <a href="${pageContext.request.contextPath}/annonce/liste" class="btn btn-secondary">Retour à la liste</a>
      </form>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
