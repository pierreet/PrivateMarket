package fr.dauphine.mido.as.privatemarket.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.dauphine.mido.as.privatemarket.ejb.TitreEJB;
import fr.dauphine.mido.as.privatemarket.entities.Titre;


@ManagedBean(name="gererTitreBean")
@RequestScoped
public class GererTitreBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Titre titre;
	
	@EJB
	private TitreEJB titreEJB;
	
	public GererTitreBean(){
		titre = new Titre();
	}
	
	public String inscrire(){
		titreEJB.ajouter(titre);
		return "Titre ajouté";
	}
	
	public Titre getTitre(){
		return titre;
	}
	
}
