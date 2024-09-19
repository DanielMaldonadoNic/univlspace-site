package com.misitio.servlets;

import java.io.IOException;

import com.misitio.db.UsuarioDb;
import com.misitio.mail.EmailService;
import com.misitio.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class CrearCuentaServlet
 */
@WebServlet("/CrearCuentaServlet")
public class CrearCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setApellidos(apellidos);
		user.setTelefono(telefono);
		user.setEmail(email);
		user.setPassword(password);
		
		
		UsuarioDb userDB = new UsuarioDb();
		String mensaje = userDB.crearUsuario(user);
		
		EmailService emailService = new EmailService();
		emailService.sendEmail(user.getNombre(), user.getEmail());
		
		System.out.println(nombre);
		System.out.println(email);
		System.out.println(password);
		System.out.println(mensaje);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
