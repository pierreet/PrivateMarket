package fr.dauphine.mido.as.privatemarket.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.forms.ConnexionForm;



public class AdminForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_FORM         = "form";
	public static final String VUE_EDIT_PROFIL   = "/WEB-INF/admin/AdminEditProfil.jsp";
	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.utilisateurs SET " +
			"Nom=?, "+
			"Prenom=?, " + 
			"Email=?, " +
			"Pays=?, "+
			"CodePostale=?, "+
			"Statut=? "+
			"WHERE idUtilisateur=?;";
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String page = request.getParameter("page");
	
		if(page.equals("editProfil")) {
			getServletContext().getRequestDispatcher(VUE_EDIT_PROFIL).forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */

        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        form.updateAdminCompte( request );
      
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        response.setContentType("text/html");
        String[] id  = request.getParameterValues("id");
        String[] id2  = request.getParameterValues("id2");
        if ( form.getErreurs().isEmpty() ) {
            //session.setAttribute( ATT_SESSION_USER, utilisateur );
    		
    		String[] nom = request.getParameterValues("nom");
    		String[] prenom = request.getParameterValues("prenom");
    		String[] email = request.getParameterValues("email");
    		String[] pays = request.getParameterValues("pays");
    		String[] codep = request.getParameterValues("code_postale");
    		String[] statut = request.getParameterValues("statut");
    		
    		
        	try {
				Connection_DB.UpdateUtilisateur(nom[0],prenom[0],email[0],pays[0],codep[0],statut[0],id[0], _SQL_UPDATE_OPERATIONS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		response.sendRedirect( "./utilisateurs?&message=edit" );

        } else {
        	   request.setAttribute( ATT_FORM, form );
        	   /*  Stockage du formulaire et du bean dans l'objet request */
        	   
           	   response.sendRedirect("admin?&page=editProfil&id="+id2[0]+"&error=email" );

        }
	}
}