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
</head>
<body>

<h1>Formulaire Saisie Nom</h1>

<form  method="post" action="hello">
    <label for="name">Votre nom :</label>
    <input type="text" name="name" id="name">
    <button type="submit">Envoyer</button>
</form>

<% String name = request.getParameter("name"); %>
<% if (name != null && !name.isEmpty()) { %>
<h2>Hello the World <%= name %></h2>
<% } %>

</body>
</html>
