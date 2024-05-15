<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-3 p-lg-4 mx-auto my-5 border border-black rounded-5" style="width: 30%">
			<form action="/LBEGerenciadorDeProjetoSimples/login" method="post">
				<h1>Login</h1>
				<div class="form-floating mb-3 mt-4">
					<input type="text" class="form-control input-height" placeholder="Nome de Usuario" id="floatingInput" name="nomeUsuario">
					<label for="floatinInput" class="font-text">Nome de Usuario</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" class="form-control input-height" placeholder="Senha" id="floatingInput" name="senha">
					<label for="floatinInput" class="font-text">Senha</label>
				</div>
				<div class="d-flex">
					<div class="m-auto d-flex flex-md-row ms-5">
						<p class="m-auto">Não tem uma conta?</p>
						<a href="./cadastro">Cadastrar</a>
					</div>
					<button class="btn btn-secondary ms-auto mt-2">Entrar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>