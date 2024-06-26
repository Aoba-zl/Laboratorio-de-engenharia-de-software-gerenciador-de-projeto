<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-3 p-lg-4 mx-auto my-5 border border-black rounded-5">
			<form action="/LBEGerenciadorDeProjetoSimples/atualizar/${codigo}" method="post">
				<h1>Atualizar</h1>
				<div class="form-floating mb-3 mt-4">
					<input type="text" value="${projetista.login.usuario}" class="form-control input-height" placeholder="Nome de Usuario" id="floatingInput" name="nomeUsuario">
					<label for="floatinInput" class="font-text">Nome de Usuario</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" value="${projetista.login.senha}" class="form-control input-height" placeholder="Senha" id="floatingInput" name="senha">
					<label for="floatinInput" class="font-text">Senha</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" value="${projetista.email}" class="form-control input-height" placeholder="Email" id="floatingInput" name="email">
					<label for="floatinInput" class="font-text">Email</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" value="${projetista.nome}" class="form-control input-height" placeholder="Nome" id="floatingInput" name="nome">
					<label for="floatinInput" class="font-text">Nome</label>
				</div>
				<div class="d-flex">
					<button name="botao" value="Excluir" class="btn btn-danger" >Excluir</button>
					<button name="botao" class="btn btn-secondary ms-auto mt-2" value="Atualizar">Atualizar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>