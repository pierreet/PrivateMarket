package fr.dauphine.mido.as.privatemarket.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;
import fr.dauphine.mido.as.privatemarket.forms.ConnexionForm;


@WebServlet("/MonCompte")
public class MonCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_EDIT_PROFIL   = "/WEB-INF/utilisateur/moncompte.jsp";
	public static final String VUE_NEW_PROFIL   = "/WEB-INF/admin/AdminNewProfil.jsp";
    public static final String ATT_FORM         = "form";
	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.utilisateurs SET " +
			"Nom=?, "+
			"Prenom=?, " + 
			"Email=?, " +
			"Pays=?, "+
			"CodePostale=?, "+
			"Password=? "+
			"WHERE idUtilisateur=?;";

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String page = request.getParameter("page");
		
		if(page == null) {
			getServletContext().getRequestDispatcher(VUE_EDIT_PROFIL).forward(request, response);
		}
		else {
			getServletContext().getRequestDispatcher(VUE_EDIT_PROFIL).forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        form.updateMonCompte( request );

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            //session.setAttribute( ATT_SESSION_USER, utilisateur );
    		response.setContentType("text/html");
    		String[] nom = request.getParameterValues("nom");
    		String[] prenom = request.getParameterValues("prenom");
    		String[] email = request.getParameterValues("email");
    		String[] pays = request.getParameterValues("pays");
    		String[] codep = request.getParameterValues("code_postale");
    		String[] mdp = request.getParameterValues("motdepasse");
    		
    	  HttpSession session = request.getSession(true);   
       	  Utilisateur utilisateur = ((Utilisateur) session.getAttribute("sessionUtilisateur"));
       	  utilisateur.setNom(nom[0]);
       	  utilisateur.setPrenom(prenom[0]);
       	  utilisateur.setEmail(email[0]);
       	  utilisateur.setPays(pays[0]);
       	  utilisateur.setCodePostale(Integer.parseInt(codep[0]));       	  
    		
        	try {
				Connection_DB.UpdateUtilisateur(nom[0],prenom[0],email[0],pays[0],codep[0],mdp[0],Connexion.getIdUtilisateur(request), _SQL_UPDATE_OPERATIONS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		response.sendRedirect( "./MonCompte?&page=save" );

        } else {
        	  request.setAttribute( ATT_FORM, form );
            /* Stockage du formulaire et du bean dans l'objet request */
            this.getServletContext().getRequestDispatcher( VUE_EDIT_PROFIL ).forward( request, response );
        }
	}

}