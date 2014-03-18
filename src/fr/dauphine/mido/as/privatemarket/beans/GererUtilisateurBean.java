package fr.dauphine.mido.as.privatemarket.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import fr.dauphine.mido.as.privatemarket.ejb.UtilisateurEJB;
import fr.dauphine.mido.as.privatemarket.entities.Utilisateur;


@ManagedBean(name="gererUtilisateurBean")
@RequestScoped
public class GererUtilisateurBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur;
	private List<Utilisateur> listeUtilisateur=null;
	private List<Utilisateur> listeMembreSociete=null;
	
	@EJB
	private UtilisateurEJB utilisateurEJB;
	
	public GererUtilisateurBean(){
		utilisateur = new Utilisateur();
	}
	
	public String inscrire(){
		utilisateurEJB.ajouter(utilisateur);
		return "Validation accepté";
	}
	
	public String supprimer(){
		utilisateurEJB.supprimer(utilisateur);
		return "Utilisateur supprimé";
	}
	
	public String modifier(){
		utilisateurEJB.modifier(utilisateur);
		return "";
	}
	
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur){
		this.utilisateur = utilisateur;
	}
	
	public List<Utilisateur> getListeUtilisateur(){
		if(listeUtilisateur==null){
			listeUtilisateur = utilisateurEJB.alltable();
		}
		return listeUtilisateur;
	}
	
	public List<Utilisateur> getListeMembreSociete(){
		if(listeMembreSociete==null){
			listeMembreSociete = utilisateurEJB.listeMembreSociete();
		}
		return listeMembreSociete;
	}
	
	public Utilisateur rechercheUtilisateur(int id){
		return utilisateurEJB.rechercherParId(id);
	}
		
}