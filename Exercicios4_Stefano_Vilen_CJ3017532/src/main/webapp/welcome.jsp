<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>IFitness - Bem-vindo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">
  <h1>Bem-vindo, <c:out value="${sessionScope.loggedUser.name}" />!</h1>
  <p>Login realizado com sucesso.</p>
  <a class="btn btn-secondary" href="logout">Sair</a>
</body>
</html>
