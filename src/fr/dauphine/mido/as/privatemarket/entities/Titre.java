package fr.dauphine.mido.as.privatemarket.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the titre database table.
 * 
 */
@Entity
public class Titre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTitre;

	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	private Date dateFin;

	private int idAcheteur;

	private int idEntreprise;

	private int idVendeur;

	private double prixActuel;

	@NotNull
	private double prixInitial;

	private int statut;

	public Titre() {
	}

	public int getIdTitre() {
		return this.idTitre;
	}

	public void setIdTitre(int idTitre) {
		this.idTitre = idTitre;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut() {
		Date date = new Date();
		this.dateDebut = date;
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

	public double getPrixActuel() {
		return this.prixActuel;
	}

	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}

	public double getPrixInitial() {
		return this.prixInitial;
	}

	public void setPrixInitial(double prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getStatut() {
		return this.statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

}