<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Projeto</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-4 p-lg-4 mx-auto my-5 border border-black rounded-5">
			<form action="./${codigo}" method="post">
				<h1>Adicionar Novo Projeto</h1>
				<div class="form-floating mb-3 mt-4">
					<input type="text" value="${projeto.nome}" class="form-control input-height" placeholder="Nome de Projeto" id="floatingInput" name="nomeProjeto">
					<label for="floatinInput" class="font-text">Nome do Projeto</label>
				</div>
				<div class="form-floating mb-3">
					<input type="date" value="${projeto.dataInicial}" max="9999-01-01" class="form-control input-height" placeholder="Data Inicial" id="floatingInput" name="dataInicial">
					<label for="floatinInput" class="font-text">Data Inicial</label>
				</div>
				<div class="form-floating mb-3">
					<input type="date" value="${projeto.dataFinal}" max="9999-01-01" class="form-control input-height" placeholder="Data Final" id="floatingInput" name="dataFinal">
					<label for="floatinInput" class="font-text">Data Final</label>
				</div>
				<div class="form-floating mb-3">
					<textarea class="form-control" style="min-height: 150px" placeholder="Descricao" id="floatingInput" name="descricao">${projeto.descricao}</textarea>
					<label for="floatinInput" class="font-text">Descrição</label>
				</div>
				<div class="d-flex">
					<button class="btn btn-secondary ms-auto mt-2">Confirmar Novo Projeto</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>