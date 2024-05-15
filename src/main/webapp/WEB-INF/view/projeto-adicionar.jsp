<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Projeto</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-4 p-lg-4 mx-auto my-5 border border-black rounded-5">
			<form action="./adicionar-projeto" method="post">
				<h1>Adicionar Novo Projeto</h1>
				<div class="form-floating mb-3 mt-4">
					<input type="text" value="${nome}" class="form-control input-height" placeholder="Nome de Projeto" id="floatingInput" name="nomeProjeto">
					<label for="floatinInput" class="font-text">Nome do Projeto</label>
				</div>
				<div class="form-floating mb-3">
					<input type="date" value="${inicial}" class="form-control input-height" placeholder="Data Inicial" id="floatingInput" name="dataInicial">
					<label for="floatinInput" class="font-text">Data Inicial</label>
				</div>
				<div class="form-floating mb-3">
					<input type="date" value="${fina}" class="form-control input-height" placeholder="Data Final" id="floatingInput" name="dataFinal">
					<label for="floatinInput" class="font-text">Data Final</label>
				</div>
				<div class="form-floating mb-3">
					<textarea class="form-control" style="min-height: 150px; resize: none;" placeholder="Descricao" id="floatingInput" name="descricao">${descricao}</textarea>
					<label for="floatinInput" class="font-text">DescriÃ§Ã£o</label>
				</div>
				<div class="d-flex">
					<button class="btn btn-secondary ms-auto mt-2">Confirmar Novo Projeto</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>