<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Equipe</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"/>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-3 p-lg-4 mx-auto my-5 border border-black rounded-5" style="width: 30%; min-height: 200px !important">
			<h1>Equipe</h1>
			<div class="border rounded-3 p-2" style="min-height: 460px !important;">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome do Projetista</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${equipe}">
							<tr>
								<td>${e.projetista.nome}</td>
								<td style="max-width: 24px; min-width: 50px">
									<c:if test="${sessionScope.login.id != e.projetista.id}">
										<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${e.projetista.id}">
			  								Excluir
										</button>
										<div class="modal fade" id="deleteModal${e.projetista.id}" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
											<div class="modal-dialog">
											 	<div class="modal-content">
												 	<div class="modal-header">
														<h1 class="modal-title fs-5" id="exampleModalLabel">Deseja realmente remover o usuário?</h1>
														<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
														<form action="./equipe/excluir/${e.projetista.id}" method="post">
															<button class="btn btn-danger">Excluir</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<a class="btn btn-secondary ms-auto mt-2" href="/LBEGerenciadorDeProjetoSimples/projeto/${codigoProjeto}/atividade">Voltar</a>
				</div>
				<div>
					<a class="btn btn-secondary ms-auto mt-2" href="./equipe/adicionar-membro">Adicionar Membro</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>