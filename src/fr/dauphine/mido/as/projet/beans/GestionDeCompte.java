package fr.dauphine.mido.as.projet.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projet.beans.Compte;


@ManagedBean
@SessionScoped
public class GestionDeCompte implements Serializable{	
	private static final long serialVersionUID = 1L;
	private Compte compte = new Compte();
	
	public GestionDeCompte(){
	}
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public void setIdCompte(int id){
		getCompte().setIdCompte(id);
	}
	
	public int getIdCompte(){
		return getCompte().getIdCompte();
	}
	
	public void setEmail(String email){
		getCompte().setEmail(email);
	}
	
	public String getEmail(){
		return getCompte().getEmail();
	}
	
	public void setPassword(String password){
		getCompte().setPassword(password);
	}
	
	public String getPassword(){
		return getCompte().getPassword();
	}
	
	public void setStatut(int statut){
		getCompte().setStatut(statut);
	}
	
	public int getStatut(){
		return getCompte().getStatut();
	}
	
	public void setNom(String nom){
		getCompte().setNom(nom);
	}
	
	public String getNom(){
		return getCompte().getNom();
	}
	
	public void setPrenom(String prenom){
		getCompte().setPrenom(prenom);
	}
	
	public String getPrenom(){
		return getCompte().getPrenom();
	}
	
	public void setPays(String pays){
		getCompte().setPays(pays);
	}
	
	public String getPays(){
		return getCompte().getPays();
	}
	
	public String getResponse() {
		String retour = null;
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PrivateMarket");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(getCompte());
		et.commit();
		setCompte(em.find(Compte.class, getIdCompte()));
		retour = "insertion ok";
		return retour;
	}
}
