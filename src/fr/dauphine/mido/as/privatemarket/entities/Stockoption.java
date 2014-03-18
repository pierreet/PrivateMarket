package fr.dauphine.mido.as.privatemarket.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the stockoption database table.
 * 
 */
@Entity
public class Stockoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSOE;

	@Temporal(TemporalType.DATE)
	private Date dateFinal;

	@Temporal(TemporalType.DATE)
	private Date dateInitial;

	private int idAcheteur;

	private int idEntreprise;

	private int idVendeur;

	private double prime;

	private double primeInitial;

	private double prixInitial;

	private int statut;

	private double strike;

	public Stockoption() {
	}

	public int getIdSOE() {
		return this.idSOE;
	}

	public void setIdSOE(int idSOE) {
		this.idSOE = idSOE;
	}

	public Date getDateFinal() {
		return this.dateFinal;
	}

	public void setDateFinal(Date dateFinal) {
		this.dateFinal = dateFinal;
	}

	public Date getDateInitial() {
		return this.dateInitial;
	}

	public void setDateInitial(Date dateInitial) {
		this.dateInitial = dateInitial;
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

	public double getPrime() {
		return this.prime;
	}

	public void setPrime(double prime) {
		this.prime = prime;
	}

	public double getPrimeInitial() {
		return this.primeInitial;
	}

	public void setPrimeInitial(double primeInitial) {
		this.primeInitial = primeInitial;
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

	public double getStrike() {
		return this.strike;
	}

	public void setStrike(double strike) {
		this.strike = strike;
	}

}