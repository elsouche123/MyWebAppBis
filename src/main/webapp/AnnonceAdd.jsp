<%--
  Created by IntelliJ IDEA.
  User: LPT-ILAN
  Date: 23/06/2025
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une annonce</title>
    <!-- Bootstrap CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h3 class="card-title mb-4">Formulaire de saisie</h3>

            <form method="post" action="addAnnonce">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="Enter title" required>
                </div>

                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="3" placeholder="Description" required></textarea>
                </div>

                <div class="mb-3">
                    <label for="adress" class="form-label">Adress</label>
                    <input type="text" class="form-control" id="adress" name="adress" placeholder="Enter adress" required>
                </div>

                <div class="mb-3">
                    <label for="mail" class="form-label">Mail</label>
                    <input type="email" class="form-control" id="mail" name="mail" placeholder="Enter mail" required>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>

            <br>
            <a href="liste" class="btn btn-secondary">Retour à la liste des annonces</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
