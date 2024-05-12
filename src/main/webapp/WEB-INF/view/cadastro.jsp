<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Gerenciador de Projeto Simples</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-3 p-lg-4 mx-auto my-5 border border-black rounded-5">
			<form action="cadastro" method="post">
				<h1>Cadastro</h1>
				<div class="form-floating mb-3 mt-4">
					<input type="text" class="form-control input-height" placeholder="Nome de Usuario" id="floatingInput" name="nomeUsuario">
					<label for="floatinInput" class="font-text">Nome de Usuario</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" class="form-control input-height" placeholder="Senha" id="floatingInput" name="senha">
					<label for="floatinInput" class="font-text">Senha</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" class="form-control input-height" placeholder="Email" id="floatingInput" name="email">
					<label for="floatinInput" class="font-text">Email</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" class="form-control input-height" placeholder="Nome" id="floatingInput" name="nome">
					<label for="floatinInput" class="font-text">Nome</label>
				</div>
				<div class="d-flex">
					<button class="btn btn-secondary ms-auto mt-2" href="./login">Confirmar Cadastro</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>