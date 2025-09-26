<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <title>Nova Tarefa</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/styles.css" rel="stylesheet">
</head>
<body class="container py-4">

  <h1 class="mb-3">Nova Tarefa</h1>

  <c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
  </c:if>

  <form action="tasks" method="post" class="row g-3">
    <div class="col-12">
      <label for="description" class="form-label">Descrição*</label>
      <input type="text" id="description" name="description" class="form-control" required maxlength="255">
    </div>
    <div class="col-12">
      <label for="date" class="form-label">Data*</label>
      <input type="date" id="date" name="date" class="form-control" required>
    </div>
    <div class="col-12">
      <button type="submit" class="btn btn-primary">Adicionar</button>
      <a class="btn btn-secondary" href="tasks">Ver Lista</a>
    </div>
  </form>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
