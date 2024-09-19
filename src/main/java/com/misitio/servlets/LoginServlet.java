package com.misitio.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import com.misitio.db.UsuarioDb;
import com.misitio.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(LoginServlet.class.getName());
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario user = new Usuario();
		UsuarioDb userDB = new UsuarioDb();
		String respuesta =null;
		String pagina=null;
		
		System.out.println("email:"+email);
		System.out.println("password:"+password);
		log.info("Usuario entrando al sistema: "+email);
		log.info("Usuario password: "+password);
		
		user = userDB.login(email, password);

		if(user==null) {
			respuesta = "Usuario no existe";
			pagina="index.jsp";
		}else if(!user.isActivo()) {
			respuesta = "Usuario no se encuentra activo, activa desde tu email";
			pagina="index.jsp";			
		}else {
			respuesta = "Acceso exitoso";
			pagina="inicio.jsp";
			request.setAttribute("usuario", user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
		
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher(pagina).forward(request, response);
	}


}
