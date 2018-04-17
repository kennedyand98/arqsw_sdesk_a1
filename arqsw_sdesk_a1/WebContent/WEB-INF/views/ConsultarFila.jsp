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
<title>Consultar - ${fila.nome }</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
       	<div class="col-md-12">
	       	<h3 class="page-header align-center center">Fila ${fila.nome }, com o ID: ${fila.id }</h3>
       	</div>
       	<div class="col-md-6" style="align-content:center">
       		<img alt="?" src="img/${fila.caminhoFigura }" class="img-responsive">
       	</div>
    </div>
</body>
</html>