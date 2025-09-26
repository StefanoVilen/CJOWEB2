<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <title>Lista de Tarefas</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/styles.css" rel="stylesheet">
</head>
<body class="container py-4">

  <div class="d-flex align-items-center justify-content-between mb-3">
    <h1 class="m-0">Lista de Tarefas</h1>
    <a class="btn btn-success" href="task-form.jsp">Nova Tarefa</a>
  </div>

  <c:choose>
    <c:when test="${empty tasks}">
      <div class="alert alert-info">Nenhuma tarefa cadastrada ainda.</div>
    </c:when>
    <c:otherwise>
      <div class="table-responsive">
        <table class="table table-striped align-middle">
          <thead>
            <tr>
              <th>ID</th>
              <th>Descrição</th>
              <th>Data</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="t" items="${tasks}">
              <tr>
                <td><c:out value="${t.id}" /></td>
                <td><c:out value="${t.description}" /></td>
                <td><c:out value="${t.date}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </c:otherwise>
  </c:choose>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
