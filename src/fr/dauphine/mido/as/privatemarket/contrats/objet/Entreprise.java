package fr.dauphine.mido.as.privatemarket.contrats.objet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Entreprise {
	public static String _Entreprise = "_Entreprise";
	private String _SQL_SELECT_OPERATIONS = "SELECT * from privatemarket.entreprise where idEntreprise=?";
	DataSource datasource = null;
	private int IdEntreprise;
	private String NomEntreprise;
	private String AnneeEntreprise;
	private String CodeEntreprise;
	private String SecteurEntreprise;
	private String DescriptionEntreprise;

	public Entreprise(int id) throws SQLException  {
		this.IdEntreprise = id;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		datasource = Connection_DB.getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(_SQL_SELECT_OPERATIONS);
		preparedStatement.setString(1, String.valueOf(this.IdEntreprise));
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			this.setNomEntreprise(resultSet.getString(2));
			this.setAnneeEntreprise(resultSet.getString(3));
			this.setCodeEntreprise(resultSet.getString(4));
			this.setDescriptionEntreprise(resultSet.getString(5));
			this.setSecteurEntreprise(resultSet.getString(6));

		}
		try {
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage().toString());
		}

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

	public int getIdEntreprise() {
		return IdEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		IdEntreprise = idEntreprise;
	}

	public String getNomEntreprise() {
		return NomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		NomEntreprise = nomEntreprise;
	}

	public String getAnneeEntreprise() {
		return AnneeEntreprise;
	}

	public void setAnneeEntreprise(String anneeEntreprise) {
		AnneeEntreprise = anneeEntreprise;
	}

	public String getCodeEntreprise() {
		return CodeEntreprise;
	}

	public void setCodeEntreprise(String codeEntreprise) {
		CodeEntreprise = codeEntreprise;
	}

	public String getSecteurEntreprise() {
		return SecteurEntreprise;
	}

	public void setSecteurEntreprise(String secteurEntreprise) {
		SecteurEntreprise = secteurEntreprise;
	}

	public String getDescriptionEntreprise() {
		return DescriptionEntreprise;
	}

	public void setDescriptionEntreprise(String DescriptionEntreprise) {
		this.DescriptionEntreprise = DescriptionEntreprise;
	}
}
