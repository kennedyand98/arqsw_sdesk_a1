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
<title>Fila criada com sucesso</title>
</head>
<body>
	<c:import url="Menu.jsp" />
		<div id="main" class="container">
        	<h3 class="page-header align-center center">Fila ${fila.nome }, criada com sucesso!</h3>
        </div>
</body>
<script>
	document.write="Preparando...";
	window.setTimeout("location.href='/arqsw_sdesk_a1/criar_nova_fila'", 5000)
</script>


</html>