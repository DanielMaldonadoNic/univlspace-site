package com.misitio.servlets;

import java.io.IOException;

import com.misitio.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PedidosClienteServlet
 */
@WebServlet("/PedidosClienteServlet")
public class PedidosClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			Usuario usuario = (Usuario) session.getAttribute("user");
		
			if(usuario!=null) {
				System.out.println(usuario.getNombre());
				request.setAttribute("mensaje", "Mostrar pedidos de: "+usuario.getNombre());
			}
		}else {
			request.setAttribute("mensaje", "Loguearse primero");
		}
		
		request.getRequestDispatcher("pedidos.jsp").forward(request, response);
	
	
	}


}
