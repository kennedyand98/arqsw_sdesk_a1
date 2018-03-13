<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Novo Chamado</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container align-center">
        <h3 class="page-header">Novo Chamado</h3>
        <form action="salvar_novo_chamado" method="get">
        	<div class="row">
        		<label>Descrição:</label>
                    <form:errors path="chamado.descricao" cssStyle="color:red"/><br>
                    <input type="text" id="descricao" name="descricao" class="form-control" >
        	</div>
        	<br><br>
        	<div class="row">
        		<label>Fila:</label>
        		<form:errors path="fila.id" cssStyle="color:red"/><br>
                <select class="form-control" name="id">
                	<option value="0"></option>
                    	<c:forEach var="fila" items="${filas}">
                            <option value="${fila.id}">${fila.nome}</option>
                        </c:forEach>
            	</select>
        	</div>
        	<div class="row center">
        		<br><br>
        		<button type="submit" class="btn btn-info botaoSalvar" >Salvar Chamado</button>
        	</div>
        </form>
    </div>
	
	
</body>
<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>