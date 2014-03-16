package fr.dauphine.mido.as.privatemarket.forms;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;


public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_PASS2   = "mdp2";
    private static final String CHAMP_GEN   = "general";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Utilisateur utilisateur = new Utilisateur();

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
       
        /* Connexion à la DB pour vérifié les informations. */
        try {
			connexionUsers(email,motDePasse,utilisateur);			
		} catch (Exception e) {
			 setErreur(CHAMP_GEN, e.getMessage() );
		}
        utilisateur.setPassword( motDePasse );
        utilisateur.setEmail( email );
      
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
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
                throw new Exception( "Le mot de passe doit contenir au moins 6 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    private void validationMotDePasse2( String motDePasse,String motDePasse2 ) throws Exception {
        if ( motDePasse != null  && motDePasse2 != null) {
            if ( motDePasse.length() < 6 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 6 caractères." );
            }
            else if(!motDePasse.equals(motDePasse2)) {
            	 throw new Exception( "Le mot de passe n'est pas identique" );
            	 
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    private void connexionUsers(String email, String mdp, Utilisateur utilisateur) throws Exception {
    		if(Connection_DB.getCompteLogin(email,mdp,utilisateur) == 0) {
    			  throw new Exception( "La combinaisons Email/Mot de passe est incorrecte.");
    		}
    }
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
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

    public void updateMonCompte( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String motDePasse2 = getValeurChamp( request, CHAMP_PASS2 );

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
     

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse2( motDePasse,motDePasse2 );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
       
      
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "";
        } else {
            resultat = "Erreur lors de la mise à jour du profil";
        }


    }
}