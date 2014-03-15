package fr.dauphine.mido.as.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.mido.as.projet.beans.Connection_DB;


public class AdminActivation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String _LISTE_OPERATIONS = "_LISTE_OPERATIONS_UTILISATEURS";


	private final static String _SQL_Activation = "UPDATE privatemarket.utilisateurs SET ValidationInvestisseur=1 WHERE idUtilisateur=?";

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(Connexion.verificationDroit(request) == 0) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				Connection_DB.ActivationProfil(id,_SQL_Activation);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.sendRedirect( "./utilisateurs" );
			
		}
	}

}
