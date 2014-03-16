package fr.dauphine.mido.as.privatemarket.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.dauphine.mido.as.privatemarket.ejb.EntrepriseEJB;
import fr.dauphine.mido.as.privatemarket.entities.Entreprise;


@ManagedBean(name="gererEntrepriseBean")
@RequestScoped
public class GererEntrepriseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Entreprise entreprise;
	private List<Entreprise> listeEntreprise;

	@EJB
	private EntrepriseEJB entrepriseEJB;
	
	public GererEntrepriseBean(){
		entreprise = new Entreprise();
	}
	
	public String inscrire(){
		entrepriseEJB.ajouter(entreprise);
		return "L'entreprise à bien été ajouté avec succès.";
	}
	
	public List<Entreprise> getListeEntreprise(){
		if(listeEntreprise==null){
			listeEntreprise = entrepriseEJB.alltable();
		}
		return listeEntreprise;
	}
	
	public Entreprise getEntreprise(String nom){
		return entrepriseEJB.rechercher(nom);
	}
	
	public Entreprise getEntreprise(){
		return entreprise;
	}
	
	public int getIdEntreprise(Entreprise e){
		return e.getIdEntreprise();
	}
}
