<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
			<table class="table table-striped" id=tabela-projeto>
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
						<c:if test="${not empty projetos}">
							<c:forEach var="p" items="${projetos}" varStatus="loop">
							
								<th><c:out value="${p.nome}"/></th>
								<td><c:out value="${p.dataInicial}"/></td>
								<td><c:out value="${p.dataFinal}"/></td>
								<td><c:out value="${p.descricao}"/></td>
								<td style="max-width: 24px; min-width: 50px">
									<form action="./projeto/atualizar/${p.id}" method="get">
										<button class="btn btn-success" value="${p.id} name="botao" >Atualizar</button>
									</form>
								</td>
								<td>
								<td style="max-width: 24px; min-width: 50px">
									<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${p.id}"> Excluir </button>

									<div class="modal fade" id="deleteModal${p.id}" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
										<div class="modal-dialog">
										 	<div class="modal-content">
											 	<div class="modal-header">
													<h1 class="modal-title fs-5" id="exampleModalLabel">Deseja realmente excluir o Projeto?</h1>
													<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
													<form action="projeto" method="post">
														<button name="botao" value="Excluir" class="btn btn-danger" >Excluir</button>
														<input type="hidden" name="botaoId" value="${p.id}">
													</form>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>