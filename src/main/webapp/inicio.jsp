<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Bienvenido ${usuario.nombre}</h2>
	<a href="${pageContext.request.contextPath}/PedidosClienteServlet">Ver
		pedidos</a>
	<a href="${pageContext.request.contextPath}/LogoutServlet">Cerrar
		sesion</a>
</body>
</html>