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
		<div class="col-md-10 p-lg-3 mx-auto my-5 border border-black rounded-5">
			<div class="d-flex justify-content-end">
				<a class="btn btn-success" href="./projeto/adicionar-projeto">Adicionar Projeto</a>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="col">Nome do Projeto</th>
						<th class="col">Data Inicial</th>
						<th class="col">Data Final</th>
						<th class="col">Descricao</th>
						<th class="col"></th>
						<th class="col"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><a href="./projeto/1/atividade">Nome do projeto</a></th>
						<td>Data inicial</td>
						<td>Data final</td>
						<td>Descricao</td>
						<td style="max-width: 24px; min-width: 50px">
							<form action="./projeto/atualizar/1" method="get">
								<button class="btn btn-success" name="botao">Atualizar</button>
							</form>
						</td>
						<td style="max-width: 24px; min-width: 50px">
							<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
  								Excluir
							</button>
							<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
								<div class="modal-dialog">
								 	<div class="modal-content">
									 	<div class="modal-header">
											<h1 class="modal-title fs-5" id="exampleModalLabel">Deseja realmente excluir o Projeto? </h1>
											<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">N�o</button>
											<form action="./projeto/excluir/1" method="post">
												<button class="btn btn-danger">Excluir</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>