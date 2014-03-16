package fr.dauphine.mido.as.privatemarket.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * The persistent class for the utilisateurs database table.
 * 
 */
@Entity
@Table(name="utilisateurs")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idUtilisateur;

	private int codePostale;

	@NotNull( message = "Veuillez saisir votre adresse email" )
	@Pattern ( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
	private String email;

	@Column(name="idEntreprise")
	private int identreprise;

	@NotNull( message = "Veuillez saisir votre nom" )
	private String nom;

	@NotNull( message = "Veuillez saisir un mot de passe" )
	@Size( min = 6, message = "Le mot de passe doit contenir au moins 6 caractères" )
	private String password;

	private String pays;

	@NotNull( message = "Veuillez saisir votre prenom" )
	private String prenom;

	@NotNull
	private int statut;

	private int validationInvestisseur;

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public int getIdentreprise() {
		return this.identreprise;
	}

	public void setIdentreprise(int identreprise) {
		this.identreprise = identreprise;
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