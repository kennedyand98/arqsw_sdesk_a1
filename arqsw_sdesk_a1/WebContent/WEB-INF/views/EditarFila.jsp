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
<title>Editar Fila</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container align-center">
		<form action="editar_fila" method="POST">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
        <h3 class="page-header">Editar Fila</h3>
        	<div class="row">
        		<input type="hidden" id="id" name="id" value=${fila.id }>
        		<label>Nome da Fila:</label>
                	<input type="text" id="nome" value="${fila.nome }" name="nome" class="form-control" >
        	</div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">        	
        	<div class="row center">
        		<br><br>
        		<button type="submit" class="btn btn-info botaoSalvar" style="margin-bottom:15px" >Salvar</button>
        		<a href="criar_nova_fila" class="btn btn-warning" style="margin-bottom:15px" >Cancelar</a>
        	</div>
        </div>
        </form>
	</div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>