package com.misitio.servlets;

import java.io.IOException;

import com.misitio.db.UsuarioDb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActivarCuentaServlet
 */
@WebServlet("/ActivarCuentaServlet")
public class ActivarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		UsuarioDb usuarioDB = new UsuarioDb();
		usuarioDB.activarCuenta(email);
		
		String mensaje = "Se ha activado la cuenta de forma correcta.";
		request.setAttribute("mensaje", mensaje );
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


}
