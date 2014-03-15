package fr.dauphine.mido.as.projet.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connection_DB {
	public static DataSource datasource = null;
	public static String NomDataSource = "privatemarket";

	public Connection_DB() {

	}
	public static int getCompteLogin(String email, String password, Compte utilisateur) throws SQLException {
		String Requetes = "select * from privatemarket.utilisateurs where email=? and password=? ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		datasource = Connection_DB.getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(Requetes);
		preparedStatement.setString(1, String.valueOf(email));
		preparedStatement.setString(2, String.valueOf(password));
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			setUtilisateur(resultSet);
			utilisateur.setStatut(resultSet.getInt("Statut"));
	
		}
		try {
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage().toString());
		}

		return 1;
	}
	public static ArrayList<Compte> ListeUtilisateurs(String requete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Compte> resultat = null;
		
		datasource = getDataSource();
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(requete);
			resultSet = preparedStatement.executeQuery();
			resultat = new ArrayList<Compte>();
			while (resultSet.next()) {
				resultat.add(setUtilisateur(resultSet));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				System.err.println(e2.getMessage().toString());
			}
		}
		return resultat;
	}
	
	public static void ActivationProfil(int id, String requete) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		datasource = getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(requete);
		preparedStatement.setString(1, String.valueOf(id));
		preparedStatement.executeUpdate();
		try {
			preparedStatement.close();
			connection.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage().toString());
		}

	}
	public static Compte setUtilisateur(ResultSet resultSet)
			throws NumberFormatException, SQLException {
			Compte utilisateur = new Compte();
			utilisateur.setStatut(resultSet.getInt("Statut"));
			utilisateur.setIdCompte(resultSet.getInt("idUtilisateur"));
			utilisateur.setPassword(resultSet.getString("Password"));
			utilisateur.setNom(resultSet.getString("prenom"));
			utilisateur.setCodePostale(resultSet.getInt("CodePostale"));
			utilisateur.setPrenom(resultSet.getString("prenom"));
			utilisateur.setPays(resultSet.getString("pays"));		
			utilisateur.setValidationInvestisseur(resultSet.getInt("validationInvestisseur"));
			utilisateur.setIdEntreprise(resultSet.getInt("idEntreprise"));		
			utilisateur.setEmail(resultSet.getString("email"));
			return utilisateur;
	}
	
	
	
	
	
	public static String getNomEntreprise(int idEntreprise) throws SQLException {
		String Requetes = "select * from privatemarket.entreprise where idEntreprise=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String nom = "";
		datasource = Connection_DB.getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(Requetes);
		preparedStatement.setString(1, String.valueOf(idEntreprise));
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			nom = (resultSet.getString(2));
		}
		try {
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage().toString());
		}

		return nom;
	}


	public static DataSource getDataSource() {

		if (null == datasource) {
			try {
				InitialContext initialContext = new InitialContext();
				datasource = (DataSource) initialContext
						.lookup("java:jboss/datasources/" + NomDataSource);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return datasource;
	}
}
