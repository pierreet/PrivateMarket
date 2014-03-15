package privatemarket.contrats.objet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Vendeur {
	public static String _Vendeur = "_Vendeur";
	private String _SQL_SELECT_OPERATIONS = "SELECT * from privatemarket.utilisateurs where idUtilisateur=?";
	DataSource datasource = null;
	private int IdUtilisateur;
	private String NomUtilisateur;
	private String PrenomUtilisateur;
	private String EmailUtilisateur;
	private String PaysUtilisateur;

	public Vendeur(int id) throws SQLException {
		this.IdUtilisateur = id;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		datasource = Connection_DB.getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(_SQL_SELECT_OPERATIONS);
		preparedStatement.setString(1, String.valueOf(this.IdUtilisateur));
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			this.setNomUtilisateur(resultSet.getString(2));
			this.setPrenomUtilisateur(resultSet.getString(3));
			this.setEmailUtilisateur(resultSet.getString(4));
			this.setPaysUtilisateur(resultSet.getString(5));

		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}


	public String get_SQL_SELECT_OPERATIONS() {
		return _SQL_SELECT_OPERATIONS;
	}

	public void set_SQL_SELECT_OPERATIONS(String _SQL_SELECT_OPERATIONS) {
		this._SQL_SELECT_OPERATIONS = _SQL_SELECT_OPERATIONS;
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public static String get_Vendeur() {
		return _Vendeur;
	}

	public static void set_Vendeur(String _Vendeur) {
		Vendeur._Vendeur = _Vendeur;
	}

	public int getIdUtilisateur() {
		return IdUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		IdUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return NomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		NomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return PrenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		PrenomUtilisateur = prenomUtilisateur;
	}

	public String getEmailUtilisateur() {
		return EmailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		EmailUtilisateur = emailUtilisateur;
	}

	public String getPaysUtilisateur() {
		return PaysUtilisateur;
	}

	public void setPaysUtilisateur(String paysUtilisateur) {
		PaysUtilisateur = paysUtilisateur;
	}

}
