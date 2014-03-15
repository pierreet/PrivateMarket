package fr.dauphine.mido.as.privatemarket.contrats.objet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connection_DB {
	public static DataSource datasource = null;
	public static String NomDataSource = "PrivateMarket";

	public Connection_DB() {

	}

	public static Titre setTitre(ResultSet resultSet)
			throws NumberFormatException, SQLException {
		Titre titre = new Titre();
		titre.setId(new Integer(resultSet.getString(1)).intValue());
		titre.setPrix(new Double(resultSet.getString(2)));
		titre.setPrixActuel(new Double(resultSet.getString(3)));
		titre.setDateCreation(resultSet.getString(4));
		titre.setDateFin(resultSet.getString(5));
		titre.setIdEntreprise(new Integer(resultSet.getString(6)));
		titre.setIdVendeur(new Integer(resultSet.getString(7)));
		titre.setIdAcheteur(new Integer(resultSet.getString(8)));
		titre.setStatut(new Integer(resultSet.getString(9)));
		titre.setNomEntreprise(Connection_DB.getNomEntreprise(titre
				.getIdEntreprise()));
		titre.setNomVendeur(Connection_DB.getNomVendeur(titre.getIdVendeur()));
		return titre;
	}

	public static Option setOption(ResultSet resultSet)
			throws NumberFormatException, SQLException {
		Option option = new Option();
		option.setIdSOI(new Integer(resultSet.getString(1)).intValue());
		option.setPrixInitial(new Double(resultSet.getString(2)));
		option.setPrimeInitial(new Double(resultSet.getString(3)));
		option.setPrime(new Double(resultSet.getString(4)));
		option.setStrike(new Double(resultSet.getString(5)));
		option.setDateInitial(resultSet.getString(6));
		option.setDateFinal(resultSet.getString(7));
		option.setStatut(new Integer(resultSet.getString(8)));
		option.setIdEntreprise(new Integer(resultSet.getString(9)));
		option.setIdVendeur(new Integer(resultSet.getString(11)));
		option.setNomEntreprise(getNomEntreprise(option.getIdEntreprise()));
		option.setNomVendeur(getNomVendeur(option.getIdVendeur()));
		return option;
	}

	public static String getNomVendeur(int idVendeur) throws SQLException {
		String Requetes = "select * from privatemarket.utilisateurs where idUtilisateur=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String nom = "";
		datasource = Connection_DB.getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(Requetes);
		preparedStatement.setString(1, String.valueOf(idVendeur));
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			nom = resultSet.getString(2);
			nom += " " + resultSet.getString(3);

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

	public static Titre rechercheTitreUnique(String id, String Requete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Titre titre = new Titre();
		datasource = getDataSource();
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(Requete);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				titre = setTitre(resultSet);

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
		return titre;
	}

	public static Option rechercheOptionUnique(String id, String Requete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		datasource = getDataSource();
		Option option = new Option();
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(Requete);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				option = setOption(resultSet);

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
		return option;
	}

	public static ArrayList<Titre> ListeTitre(String requete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Titre> resultat = null;
		datasource = getDataSource();
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(requete);
			resultSet = preparedStatement.executeQuery();
			resultat = new ArrayList<Titre>();
			while (resultSet.next()) {

				resultat.add(Connection_DB.setTitre(resultSet));

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

	

	public static ArrayList<Option> ListeOption(String statut, String requete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Option> resultat = null;
		datasource = getDataSource();
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, statut);
			resultSet = preparedStatement.executeQuery();
			resultat = new ArrayList<Option>();
			while (resultSet.next()) {
				resultat.add(Connection_DB.setOption(resultSet));
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

	public static int UpdateAcheteur(String idTitre, String requete)
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		datasource = getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(requete);
		preparedStatement.setString(1, idTitre);
		int tmp = preparedStatement.executeUpdate();
		try {
			preparedStatement.close();
			connection.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage().toString());
		}
		return tmp;
	}

	public static double getPrixActuel(String idTitre, String requete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		datasource = getDataSource();
		double valeur = 0;
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, idTitre);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				valeur = new Double(resultSet.getString(1));

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
		return valeur;
	}

	public static void UpdatePrix(String requete, double NouveauPrix,
			String idTitre) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		datasource = getDataSource();
		connection = datasource.getConnection();
		preparedStatement = connection.prepareStatement(requete);
		preparedStatement.setString(1, String.valueOf(NouveauPrix));
		preparedStatement.setString(2, idTitre);
		preparedStatement.executeUpdate();
		try {
			preparedStatement.close();
			connection.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage().toString());
		}

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
