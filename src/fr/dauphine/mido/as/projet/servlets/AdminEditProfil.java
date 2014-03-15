package fr.dauphine.mido.as.projet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AdminEditProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/WEB-INF/AdminEditProfil.jsp";

	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}