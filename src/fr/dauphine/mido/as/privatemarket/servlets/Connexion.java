package fr.dauphine.mido.as.privatemarket.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;
import fr.dauphine.mido.as.privatemarket.forms.ConnexionForm;




public class Connexion extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/index.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Pr�paration de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requ�te et r�cup�ration du bean en r�sultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* R�cup�ration de la session depuis la requ�te */
        HttpSession session = request.getSession();
        

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur � la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
            response.sendRedirect( "./logged" );

        } else {
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_USER, utilisateur );
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }


    
      
    }
    public static int verificationDroit(HttpServletRequest request) {
    	  HttpSession session = request.getSession(true);   
    	  Utilisateur utilisateur = ((Utilisateur) session.getAttribute("sessionUtilisateur"));
    	  if(utilisateur != null)
    		  return utilisateur.getStatut();
    	  else 
    		  return 9;
    }
    
    public static String getIdUtilisateur(HttpServletRequest request) {
    	  HttpSession session = request.getSession(true);   
    	  Utilisateur utilisateur = ((Utilisateur) session.getAttribute("sessionUtilisateur"));
    	  if(utilisateur != null)
    		  return String.valueOf(utilisateur.getIdUtilisateur());
    	  
    	  return null;
    }
    
                                                                    
    
    }
