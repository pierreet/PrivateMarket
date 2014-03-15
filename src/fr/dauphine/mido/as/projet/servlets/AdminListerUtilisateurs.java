package fr.dauphine.mido.as.projet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.projet.beans.Compte;
import fr.dauphine.mido.as.projet.beans.Connection_DB;


public class AdminListerUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String _LISTE_OPERATIONS = "_LISTE_OPERATIONS_UTILISATEURS";
	public static final String VUE   = "/WEB-INF/admin/AdminListeUtilisateurs.jsp";


	private final static String _SQL_SELECT_Liste_Utilisateurs = "select * from privatemarket.utilisateurs order by idUtilisateur desc";

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(Connexion.verificationDroit(request) == 0) {
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			ArrayList<Compte> listeTitre = Connection_DB.ListeUtilisateurs(_SQL_SELECT_Liste_Utilisateurs);
			session.setAttribute(_LISTE_OPERATIONS, listeTitre);
			getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

}
