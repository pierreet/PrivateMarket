package fr.dauphine.mido.as.privatemarket.contrats.objet;

public class Option {

private int idSOI;
private double PrixInitial;
private double PrimeInitial;
private double Prime;
private double Strike;
private String dateInitial;
private String dateFinal;
private int bool;
private int statut;
private int idEntreprise;
private int idVendeur;
private int idAcheteur;
private String NomEntreprise;
private String NomVendeur;
	public Option(){
		
	}
	public int getIdSOI() {
		return idSOI;
	}
	public void setIdSOI(int idSOI) {
		this.idSOI = idSOI;
	}
	public double getPrixInitial() {
		return PrixInitial;
	}
	public void setPrixInitial(double prixInitial) {
		PrixInitial = prixInitial;
	}
	public double getPrime() {
		return Prime;
	}
	public void setPrime(double prime) {
		Prime = prime;
	}
	public double getStrike() {
		return Strike;
	}
	public void setStrike(double strike) {
		Strike = strike;
	}
	public String getDateInitial() {
		return dateInitial;
	}
	public void setDateInitial(String dateInitial) {
		this.dateInitial = dateInitial;
	}
	public String getDateFinal() {
		return dateFinal;
	}
	public void setDateFinal(String dateFinal) {
		this.dateFinal = dateFinal;
	}
	public int getBool() {
		return bool;
	}
	public void setBool(int bool) {
		this.bool = bool;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	public int getIdEntreprise() {
		return idEntreprise;
	}
	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	public int getIdVendeur() {
		return idVendeur;
	}
	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}
	public int getIdAcheteur() {
		return idAcheteur;
	}
	public void setIdAcheteur(int idAcheteur) {
		this.idAcheteur = idAcheteur;
	}
	public String getNomEntreprise() {
		return NomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		NomEntreprise = nomEntreprise;
	}
	public String getNomVendeur() {
		return NomVendeur;
	}
	public void setNomVendeur(String nomVendeur) {
		NomVendeur = nomVendeur;
	}
	public double getPrimeInitial() {
		return PrimeInitial;
	}
	public void setPrimeInitial(double primeInitial) {
		PrimeInitial = primeInitial;
	}
}
