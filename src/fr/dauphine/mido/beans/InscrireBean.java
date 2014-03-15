package fr.dauphine.mido.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.dauphine.mido.as.ejb.UtilisateurEJB;
import fr.dauphine.mido.as.entities.Utilisateur;

@ManagedBean(name="inscrireBean")
@RequestScoped
public class InscrireBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur;
	
	@EJB
	private UtilisateurEJB utilisateurEJB;
	
	public InscrireBean(){
		utilisateur = new Utilisateur();
	}
	
	public void inscrire(){
		utilisateurEJB.ajouter(utilisateur);
		FacesMessage message = new FacesMessage("Inscription validée");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}
	
}