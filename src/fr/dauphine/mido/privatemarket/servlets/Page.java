package fr.dauphine.mido.privatemarket.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_VALID_INSCRIPTION   = "/WEB-INF/utilisateur/validInscription.jsp";



	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String page = request.getParameter("page");
		if(page.equals("validInscription")) {
			getServletContext().getRequestDispatcher(VUE_VALID_INSCRIPTION).forward(request, response);
		}

	}

}