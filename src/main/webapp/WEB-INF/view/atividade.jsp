<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atividade</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div class="overflow-hidden p-md-5 m-md-3 text-center">
		<div class="col-md-10 p-lg-3 mx-auto my-5 border border-black rounded-5">
			<div class="d-flex justify-content-between border rounded-3">
				<div class="container border rounded-3">
					<h3>${projeto.nome}</h3>
					<div class="container border rounded-3">
						<div class="d-flex justify-content-between p-2" style="padding-right: 0rem !important; padding-left: 0rem !important;">
							<div>
								<a class="btn btn-secondary" href="/LBEGerenciadorDeProjetoSimples/projeto/${codigoProjeto}/atividade/equipe" style="min-width: 163.91px;">Membro da Equipe</a>
							</div>
							<div>
								<a class="btn btn-success" href="/LBEGerenciadorDeProjetoSimples/projeto/${codigoProjeto}/atividade/adicionar-atividade">Adicionar Atividade</a>
							</div>
						</div>
						<div class="border rounded-3 scroll" style="min-height: 510px; max-height: 510px">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Nome atividade</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${not empty atividades}">
										<c:forEach var="a" items="${atividades}">
											<tr>
												<th><a href="/LBEGerenciadorDeProjetoSimples/projeto/${codigoProjeto}/atividade/${a.id}">${a.nome}</a></th>
												<td style="max-width: 24px; min-width: 50px">
													<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${a.id}">
						  								Excluir
													</button>
													<div class="modal fade" id="deleteModal${a.id}" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
														<div class="modal-dialog">
														 	<div class="modal-content">
															 	<div class="modal-header">
																	<h1 class="modal-title fs-5" id="exampleModalLabel">Deseja realmente excluir a Atividade?</h1>
																	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
																	<form action="/LBEGerenciadorDeProjetoSimples/projeto/${codigoProjeto}/atividade/${a.id}/excluir" method="post">
																		<button class="btn btn-danger">Excluir</button>
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
				</div>
				<div class="container border rounded-3">
					<c:if test="${empty atividade}">
						<h3>Atividade</h3>
						<div class="container border rounded-3">
							<div class="p-2" style="padding-right: 0rem !important;">
								<div class="form-floating mb-3">
									<textarea class="form-control" style="min-height: 350px; resize: none;" placeholder="Descricao" id="floatingInput" name="descricao" disabled></textarea>
									<label for="floatinInput" class="font-text">Descrição</label>
								</div>
							</div>
							<div class="d-inline-block">
								<div class="d-flex flex-md-row">
									<p>Data Inicial:</p>
									<input type="date" class="form-control input-height" name="dataInicial" disabled>
								</div>
								<div class="d-flex flex-md-row">
									<p>Data Limite</p>
									<input type="date" class="form-control input-height" name="dataInicial" disabled>
								</div>
								<div class="p-2">
									<button class="btn btn-secondary" disabled>Alterar</button>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty atividade}">
						<h3>${atividade.nome}</h3> 
						<div class="container border rounded-3">
							<div class="p-2" style="padding-right: 0rem !important;">
								<div class="form-floating mb-3">
									<textarea class="form-control" style="min-height: 350px; resize: none;" placeholder="Descricao" id="floatingInput" name="descricao" disabled>${atividade.descricao}</textarea>
									<label for="floatinInput" class="font-text">Descrição</label>
								</div>
							</div>
							<div class="d-inline-block">
								<div class="d-flex flex-md-row">
									<p>Data Inicial:</p>
									<input type="date" class="form-control input-height" name="dataInicial" value="${atividade.dataInicial}" disabled>
								</div>
								<div class="d-flex flex-md-row">
									<p>Data Limite</p>
									<input type="date" class="form-control input-height" name="dataInicial" value="${atividade.dataFinal}" disabled>
								</div>
								<div class="p-2">
									<a class="btn btn-secondary" href="./${atividade.id}/atualizar">Alterar</a>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>