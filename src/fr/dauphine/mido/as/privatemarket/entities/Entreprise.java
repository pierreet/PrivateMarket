package fr.dauphine.mido.as.privatemarket.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEntreprise;

	private String annee;

	private String code;

	@Lob
	private String description;

	private int idMembre;

	private String nom;

	private String secteur_Activite;

	public Entreprise() {
	}

	public int getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSecteur_Activite() {
		return this.secteur_Activite;
	}

	public void setSecteur_Activite(String secteur_Activite) {
		this.secteur_Activite = secteur_Activite;
	}

}