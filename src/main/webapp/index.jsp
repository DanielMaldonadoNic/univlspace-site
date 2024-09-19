<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio consultor plataformas digitales</title>

</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<body>
	<h2>Bienvenido a curso de plataformas digitales.</h2>

	<div class="container">
		<div class="row">
			<form action="LoginServlet" method="post">
				<div class="mb-3 row">
					<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="email"
							id="staticEmail" placeholder="email@example.com">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"
							id="inputPassword">
					</div>
				</div>
				<div class="mb-3 row">
					<button class="btn btn-primary">Enviar</button>
				</div>
			</form>
		</div>
		<div class="row">
			<a href="crearCuenta.jsp">Crear cuenta</a> <a
				href="RecuperarPassword.jsp">Recuperar password</a>
		</div>

		<label class="badge text-bg-info"> ${mensaje} </label>
		
		<label class="badge text-bg-danger"> ${respuesta}</label>
		
		
	</div>


</body>
</html>