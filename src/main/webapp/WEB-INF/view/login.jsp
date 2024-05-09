<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<!-- Script -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="/LBEGerenciadorDeProjetoSimples/resources/css/style.css">

<title>Gerenciador de Projeto Simples</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-3 p-lg-4 mx-auto my-5 border border-black rounded-5">
			<form action="login">
				<h1>Login</h1>
				<div class="form-floating mb-3 mt-4">
					<input type="text" class="form-control input-height" placeholder="Nome de Usuario" id="floatingInput" name="nomeUsuario">
					<label for="floatinInput" class="font-text">Nome de Usuario</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" class="form-control input-height" placeholder="Senha" id="floatingInput" name="senha">
					<label for="floatinInput" class="font-text">Senha</label>
				</div>
				<div class="d-flex">
					<div class="m-auto d-flex flex-md-row ms-5">
						<p class="m-auto">Não tem uma conta?</p>
						<a href="./cadastro">Cadastrar</a>
					</div>
					<a class="btn btn-secondary ms-auto mt-2" href="./projeto">Entrar</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>