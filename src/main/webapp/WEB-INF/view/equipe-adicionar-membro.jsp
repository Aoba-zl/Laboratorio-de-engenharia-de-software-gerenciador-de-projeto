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
		<div class="col-md-3 p-lg-4 mx-auto my-5 border border-black rounded-5" style="width: 30%;">
			<h1>Adicionar Membro</h1>
			<form action="./adicionar-membro" method="post">
				<div class="border rounded-3 p-2">
					<select class="form-select" name="comboBoxProjetista">
						<option disabled selected value="-1">Selecione um Projetista</option>
						<c:forEach var="p" items="${projetista}">
							<c:if test="${sessionScope.login.id != p.id}">
								<option value="${p.id}">${p.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="d-flex">
					<button class="btn btn-secondary ms-auto mt-2">Adicionar Membro</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>