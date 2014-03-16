package fr.dauphine.mido.as.privatemarket.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.dauphine.mido.as.privatemarket.ejb.UtilisateurEJB;
import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;


@ManagedBean(name="gererUtilisateurBean")
@RequestScoped
public class GererUtilisateurBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur;
	private List<Utilisateur> listeUtilisateur;
	
	@EJB
	private UtilisateurEJB utilisateurEJB;
	
	public GererUtilisateurBean(){
		utilisateur = new Utilisateur();
	}
	
	public String inscrire(){
		utilisateurEJB.ajouter(utilisateur);
		FacesMessage message = new FacesMessage("Inscription validée");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "Votre inscription à bien été effectué";
	}
	
	public void supprimer(){
		utilisateurEJB.supprimer(utilisateur);
		FacesMessage message = new FacesMessage("Utilisateur supprimé");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void modifier(){
		utilisateurEJB.modifier(utilisateur);
		FacesMessage message = new FacesMessage("Utilisateur modifié");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}
	
	public List<Utilisateur> getListeUtilisateur(){
		if(listeUtilisateur==null){
			listeUtilisateur = utilisateurEJB.alltable();
		}
		return listeUtilisateur;
	}
	
}