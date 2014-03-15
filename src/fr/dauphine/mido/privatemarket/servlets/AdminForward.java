package fr.dauphine.mido.privatemarket.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AdminForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_EDIT_PROFIL   = "/WEB-INF/admin/AdminEditProfil.jsp";
	public static final String VUE_NEW_PROFIL   = "/WEB-INF/admin/AdminNewProfil.jsp";



	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String page = request.getParameter("page");
	
		if(page.equals("editProfil")) {
			getServletContext().getRequestDispatcher(VUE_EDIT_PROFIL).forward(request, response);
		}
		if(page.equals("newProfil")) {
			getServletContext().getRequestDispatcher(VUE_NEW_PROFIL).forward(request, response);
		}
	}

}