<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Chamados</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<section class="content">
    	<div class="container-fluid">
			<div class="col-lg-1 col-md-6 col-sm-6 col-xs-6">
				<a href="index" class="btn btn-info">Início</a>
				
			</div>
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-6">
				<h4 style="text-align:center">${fila.nome }</h4>
			</div><br><br>
			<table class="table table-bordered table-striped table-hover" border="1">
				<thead class="thead-dark">
					<tr>
						<th><p class="text-center">Número</p></th>
						<th><p class="text-center">Descrição</p></th>
						<th><p class="text-center">Abertura</p></th>
						<th><p class="text-center">Fechamento</p></th>
						<th><p class="text-center">Status</p></th>
						<th><p class="text-center">Tempo</p></th>
					</tr>
				</thead>
				<tbody>
					<!--  Começa o ForEach -->
		        	<c:forEach var="chamado" items="${chamados}">
		        		<tr>
		        			<td data-name="tblId">
		        				<p class="text-center">${chamado.numero}</p>
		        			</td>
		        			<td data-name="tblDescricao">
		        				<p class="text-center">${chamado.descricao}</p>
		       				</td>
		       				<td data-name="tblAbertura">
		       					<p class="text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${chamado.dataAbertura}"/> </p>
		       				</td>
		       				<td data-name="tblFechamento">
		       					<p class="text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${chamado.dataFechamento}"/></p>
		      				</td>
		      				<td data-name="nivel">
		      					<p class="text-center">${chamado.status}</p>
		      				</td>
		      				<c:set var="abertura" value="${chamado.dataAbertura.getTime() }"/>
		      				<c:set var="fechamento" value="${chamado.dataFechamento.getTime() }"/>
		      				<c:set var="tempo" value="${(fechamento - abertura)/(1000*60*60*24)}"/>
		      				<c:if test="${tempo lt 0 }"><c:set var="tempo" value="0"></c:set></c:if>
		      				<td data-name="tblStatus">
		      					<p class="text-center"><fmt:formatNumber type="number" value="${tempo }"></fmt:formatNumber></p>
	      					</td>
      					</tr>
		      		</c:forEach>
				</tbody>
			</table>
		</div>
	</section>	
</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>