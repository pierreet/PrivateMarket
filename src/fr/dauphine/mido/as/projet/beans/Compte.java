package fr.dauphine.mido.as.projet.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comptes database table.
 * 
 */
@Entity
@Table(name="comptes")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCompte;

	private int codePostale;

	private String email;

	private int idEntreprise;

	private String nom;

	private String password;

	private String pays;

	private String prenom;

	private int statut;

	private int validationInvestisseur;

	public Compte() {
	}

	public int getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public int getCodePostale() {
		return this.codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getStatut() {
		return this.statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getValidationInvestisseur() {
		return this.validationInvestisseur;
	}

	public void setValidationInvestisseur(int validationInvestisseur) {
		this.validationInvestisseur = validationInvestisseur;
	}

}