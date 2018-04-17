<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nova Fila</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container align-center">
		<form action="salvar_nova_fila" method="POST" enctype="multipart/form-data">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
        <h3 class="page-header">Nova Fila</h3>
        	<div class="row">
        		<label>Nome da Fila:</label>
                	<input type="text" id="nome" name="nome" class="form-control" >
        		<label>Imagem:</label>
        			<input type="file" id="file" name="file" class="form-control file">
        	</div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">        	
        	<div class="row center">
        		<br><br>
        		<button type="submit" class="btn btn-info botaoSalvar" style="margin-bottom:15px" >Criar Fila</button>
        	</div>
        </div>
        </form>
        <h3 class="page-header">Filas Existentes</h3>
        <div class="row">
        	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
        	<c:if test="${empty filas }">
        		<p class="bg-info">Não há filas cadastradas!</p>
        	</c:if>
        	<c:if test="${not empty filas }">
        		<c:if test="${not empty chamadosAbertosFila }">
        			<p class="bg-danger">Não é possível excluir a fila há pois há chamados abertos.</p>
        		</c:if>
        		<table class="table table-bordered table-striped table-hover" border="1">
					<thead class="thead-dark">
						<tr>
							<th><p class="text-center">Nome</p></th>
							<th><p class="text-center">Imagem</p></th>
							<th><p class="text-center">Ver</p></th>
							<th><p class="text-center">Editar</p></th>
							<th><p class="text-center">Excluir</p></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fila" items="${filas }">
							<tr>
								<td data-name="nome">
									<p class="text-center">${fila.nome }</p>
								</td>
								<td data-name="imagemFila">
									<img alt="?" src="img/${fila.caminhoFigura }" height="20" width="20" class="img-circle">
								</td>
								<td data-name="consultar">
									<p data-placement="top" data-toggle="tolltip" title="Consultar" class="text-center">
										<a href="consultarFila?id=${fila.id }" class="btn btn-default btn-xs text-center">
											<span class="glyphicon glyphicon-eye-open"></span>
										</a>
									</p>
								</td>
								<td data-name="editarFila">
									<p data-placement="top" data-toggle="tooltip" title="Edit" class="text-center">
										<a href="form_editar_fila?id=${fila.id }" class="btn btn-primary btn-xs text-center">
											<span class="glyphicon glyphicon-pencil"></span>
										</a>
									</p>
								</td>
								<td data-name="excluirFila">
									<p data-placement="top" data-toggle="tooltip" title="Delete" class="text-center">
										<a href="excluir_fila?id=${fila.id }" class="btn btn-danger btn-xs text-center">
											<span class="glyphicon glyphicon-trash"></span>
										</a>
									</p>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
        	</div>	
        </div>
    </div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>