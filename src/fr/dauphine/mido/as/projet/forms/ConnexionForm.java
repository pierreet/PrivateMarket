package fr.dauphine.mido.as.projet.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import fr.dauphine.mido.as.projet.beans.Compte;
import fr.dauphine.mido.as.projet.beans.Connection_DB;

public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_GEN   = "general";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Compte connecterUtilisateur( HttpServletRequest request ) {
        /* R�cup�ration des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Compte utilisateur = new Compte();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
     

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
       
        /* Connexion � la DB pour v�rifi� les informations. */
        try {
			connexionUsers(email,motDePasse,utilisateur);			
		} catch (Exception e) {
			 setErreur(CHAMP_GEN, e.getMessage() );
		}
        utilisateur.setPassword( motDePasse );
        utilisateur.setEmail( email );
      
        /* Initialisation du r�sultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s de la connexion.";
        } else {
            resultat = "�chec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 6 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 6 caract�res." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    private void connexionUsers(String email, String mdp, Compte utilisateur) throws Exception {
    		if(Connection_DB.getCompteLogin(email,mdp,utilisateur) == 0) {
    			  throw new Exception( "La combinaisons Email/Mot de passe est incorrecte.");
    		}
    }
    /*
     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}