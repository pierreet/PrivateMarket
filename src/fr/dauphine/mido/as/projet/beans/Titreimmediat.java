package fr.dauphine.mido.as.projet.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the titreimmediat database table.
 * 
 */
@Entity
public class Titreimmediat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTitre;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	private Date dateFin;

	private int idAcheteur;

	private int idEntreprise;

	private int idVendeur;

	private double prix;

	public Titreimmediat() {
	}

	public int getIdTitre() {
		return this.idTitre;
	}

	public void setIdTitre(int idTitre) {
		this.idTitre = idTitre;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdAcheteur() {
		return this.idAcheteur;
	}

	public void setIdAcheteur(int idAcheteur) {
		this.idAcheteur = idAcheteur;
	}

	public int getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public int getIdVendeur() {
		return this.idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}