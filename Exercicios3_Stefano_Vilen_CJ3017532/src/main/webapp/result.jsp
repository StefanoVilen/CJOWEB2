<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Resultado</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
  <h1>Resultado</h1>

  <p><strong>Nome:</strong> ${nome}</p>

  <h2>E-mails (${fn:length(emails)})</h2>
  <c:choose>
    <c:when test="${fn:length(emails) > 0}">
      <c:forEach var="em" items="${emails}">
        <p>${em}</p>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <p><em>Nenhum e-mail informado.</em></p>
    </c:otherwise>
  </c:choose>

  <h2>Cursos (${fn:length(cursos)})</h2>
  <c:choose>
    <c:when test="${fn:length(cursos) > 0}">
      <c:forEach var="c" items="${cursos}">
        <p>${c}</p>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <p><em>Nenhum curso selecionado.</em></p>
    </c:otherwise>
  </c:choose>

  <p><a href="index.jsp">Voltar</a></p>
</body>
</html>
