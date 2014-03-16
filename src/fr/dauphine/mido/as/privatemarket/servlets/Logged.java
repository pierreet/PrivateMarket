package fr.dauphine.mido.as.privatemarket.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;


public class Logged extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_ADMIN        = "/WEB-INF/admin/index.jsp";
    public static final String VUE_SOCIETE      = "/WEB-INF/utilisateur/societe.jsp";
    public static final String VUE_INVEST       = "/WEB-INF/utilisateur/investisseur.jsp";
    public static final String VUE_UNINVEST       = "/WEB-INF/utilisateur/investisseur-na.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */	
       HttpSession session = request.getSession(true);   
       Utilisateur utilisateur = ((Utilisateur) session.getAttribute("sessionUtilisateur"));
       
       
       /* On vérifie que l'utilisateur est connecté */	
     if(utilisateur != null) {
    	  /* Si l'utilisateur est un administrateur, forward vers vue Admin  */	
       if(utilisateur.getStatut() ==  0) {
       	this.getServletContext().getRequestDispatcher( VUE_ADMIN ).forward( request, response );
       }
         /* Si l'utilisateur est une société, forward vers vue Société  */	
       else if(utilisateur.getStatut() == 1) {
       	this.getServletContext().getRequestDispatcher( VUE_SOCIETE ).forward( request, response );
       }
       /* Si l'utilisateur est un investisseur, forward vers vue Investisseur  */	
       else if(utilisateur.getStatut() == 2) {
    	   if(utilisateur.getValidationInvestisseur() == 1) {
    		   	this.getServletContext().getRequestDispatcher( VUE_INVEST ).forward( request, response ); }
    	   else { 
    		 	this.getServletContext().getRequestDispatcher( VUE_UNINVEST ).forward( request, response ); }
       }
     }
     /* Si l'utilisateur n'est pas connecté, hop page d'acceuil  */	
       else 
       {
    	   response.sendRedirect( "./" );
       
       }
    }
}