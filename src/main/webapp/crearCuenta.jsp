<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Crear Cuenta</h1>
	<div class="container">
		<div class="row">
			<form action="CrearCuentaServlet" method="post">
				<div class="mb-3 row">
					<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
					<div class="col-sm-10">
						<input type="text" name="nombre" class="form-control" id="nombre">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="apellidos" class="col-sm-2 col-form-label">Apllidos</label>
					<div class="col-sm-10">
						<input type="text" name="apellidos" class="form-control"
							id="apellidos">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
					<div class="col-sm-10">
						<input type="number" name="telefono" class="form-control" id="telefono">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="email@example.com">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="password" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" id="password">
					</div>
				</div>
				<div class="mb-3 row">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</form>
		</div>
		<div class="row">
			<a href="crearCuenta.jsp">Crear cuenta</a> <a
				href="RecuperarPassword.jsp">Recuperar password</a>
		</div>

	</div>
</body>
</html>