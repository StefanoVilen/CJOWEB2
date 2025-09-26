<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="pt-BR" data-bs-theme="light">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>IFitness - Página de Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/styles.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div class="col-lg-4 offset-lg-4 col-sm-12 py-4">

      <c:choose>
        <c:when test="${result == 'registered'}">
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            Usuário cadastrado com sucesso. Faça o login.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
        </c:when>
        <c:when test="${result == 'loginError'}">
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            E-mail e/ou senha inválidos.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
        </c:when>
      </c:choose>

      <form action="loginServlet" method="post" novalidate>
        <h1 class="text-center mb-3">Login</h1>

        <div class="input-group mb-3">
          <span class="input-group-text">
            
          </span>
          <input type="email" name="email" id="email" placeholder="E-mail" required class="form-control">
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text">
            <
          </span>
          <input type="password" name="password" id="password" placeholder="Senha" required class="form-control">
        </div>

        <div class="mb-3">
          <button type="submit" class="btn btn-primary">Login</button>
        </div>

        <div class="mb-3">
          <a href="user-register.jsp" id="link" class="btn btn-secondary">Cadastrar</a>
        </div>
      </form>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="js/theme.js"></script>
</body>
</html>
