<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Inscrição em Cursos de Extensão</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>Inscrição em Cursos de Extensão</h1>

	<form action="PersonServlet" method="post" accept-charset="UTF-8">
		<div class="field">
			<label for="nome">Nome do aluno:</label>
			<input type="text" id="nome" name="nome" required>
		</div>

		<div class="field">
			<label>E-mails do aluno (um ou mais):</label>
			<div id="emails-wrapper">
				<input type="email" name="emails" placeholder="email@exemplo.com" required>
			</div>
			<button type="button" id="add-email">+ adicionar outro e-mail</button>
		</div>

		<div class="field">
			<label>Selecione os cursos desejados (pode marcar mais de um):</label>
			<label class="chk">
				<input type="checkbox" name="cursos" value="Curso de Bootstrap"> Curso de Bootstrap
			</label>
			<label class="chk">
				<input type="checkbox" name="cursos" value="Curso de Animações em CSS 3"> Curso de Animações em CSS 3
			</label>
			<label class="chk">
				<input type="checkbox" name="cursos" value="Curso de Design Patterns"> Curso de Design Patterns
			</label>
		</div>

		<div class="actions">
			<input type="submit" value="Enviar inscrição">
		</div>
	</form>

	<script>
		// adicionar inputs de e-mail dinamicamente (mesmo name="emails")
		document.getElementById('add-email').addEventListener('click', function () {
			const wrapper = document.getElementById('emails-wrapper');
			const input = document.createElement('input');
			input.type = 'email';
			input.name = 'emails';
			input.placeholder = 'email@exemplo.com';
			wrapper.appendChild(input);
		});
	</script>
</body>
</html>
