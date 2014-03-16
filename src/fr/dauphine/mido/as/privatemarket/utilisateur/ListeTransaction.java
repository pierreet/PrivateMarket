package fr.dauphine.mido.as.privatemarket.utilisateur;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Option;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Titre;
import fr.dauphine.mido.as.privatemarket.servlets.Connexion;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/ListeTransaction")
public class ListeTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
	static Date date = new Date();;
	static String DateActuel = dateFormat.format(date);
	public static String idAcheteur = "0";
	public static String _SQL_SELECT_Achat_Titre;
	public static String _SQL_SELECT_Achat_OPTION;
	// Enchere en cours et obtenus
	private static String _SQL_SELECT_Enchere_Titre_ENCOURS;
	private static String _SQL_SELECT_Enchere_OPTION;
	// Ventes
	private static String _SQL_SELECT_Vente_Titre;
	private static String _SQL_SELECT_Vente_Option;
	// Enchere en cours - finis ayant trouvé vendeur
	private static String _SQL_SELECT_Vente_Enchere_Titre;
	private static String _SQL_SELECT_Vente_Enchere_Option;

	public static String _ACHAT_TITRE = "_ACHAT_TITRE";
	public static String _ACHAT_OPTION_CALL = "_ACHAT_OPTION_CALL";
	public static String _ACHAT_OPTION_PUT = "_ACHAT_OPTION_PUT";
	public static String _ACHAT_ENCHERE_TITRE = "_ACHAT_ENCHERE_TITRE";
	public static String _ACHAT_ENCHERE_CALL = "_ACHAT_ENCHERE_CALL";
	public static String _ACHAT_ENCHERE_PUT = "_ACHAT_ENCHERE_PUT";

	public static String _VENTE_TITRE = "_VENTE_TITRE";
	public static String _VENTE_OPTION_CALL = "_VENTE_OPTION_CALL";
	public static String _VENTE_OPTION_PUT = "_VENTE_OPTION_PUT";
	public static String _VENTE_ENCHERE_TITRE = "_VENTE_ENCHERE_TITRE";
	public static String _VENTE_ENCHERE_CALL = "_VENTE_ENCHERE_CALL";
	public static String _VENTE_ENCHERE_PUT = "_VENTE_ENCHERE_PUT";

	public ListeTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void SetRequeteAchat(String id) {
		// Achats Immediat
		_SQL_SELECT_Achat_Titre = "select * from privatemarket.titre where "
				+ "idAcheteur='" + id
				+ "' and (statut=0 or (statut=1 and DateFin<'" + DateActuel
				+ "')) " + "order by DateFin desc";
		_SQL_SELECT_Achat_OPTION = "select * from privatemarket.stockoption where"
				+ " idAcheteur='"
				+ id
				+ "' and Statut=? order by DateFinal desc";
		// Enchere en cours et obtenus
		_SQL_SELECT_Enchere_Titre_ENCOURS = "select * from privatemarket.titre where "
				+ "idAcheteur='"
				+ id
				+ "' and statut=1 and DateFin>'"
				+ DateActuel + "' ORDER BY DateFin desc";
		_SQL_SELECT_Enchere_OPTION = "select * from privatemarket.stockoption where"
				+ " idAcheteur='"
				+ id
				+ "' and Statut=? order by DateFinal desc";

	}

	public static void SetRequeteVente(String id) {
		// Ventes
		_SQL_SELECT_Vente_Titre = "select * from privatemarket.titre where idVendeur='"
				+ id
				+ "' and ((statut=0 and idAcheteur!=0) or (statut=1 and DateFin<'"
				+ DateActuel + "')) ORDER BY DateFin desc";
		_SQL_SELECT_Vente_Option = "select * from privatemarket.stockoption where idVendeur='"
				+ id + "' and Statut=? order by DateFinal desc";
		// Enchere en cours - finis ayant trouvé vendeur
		_SQL_SELECT_Vente_Enchere_Titre = "select * from privatemarket.titre where idVendeur='"
				+ id + "' ORDER BY DateFin desc";
		_SQL_SELECT_Vente_Enchere_Option = "select * from privatemarket.stockoption where idVendeur='"
				+ id + "' and Statut=? order by DateFinal desc ";

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		idAcheteur = Connexion.getIdUtilisateur(request);
		SetRequeteAchat(idAcheteur);
		SetRequeteVente(idAcheteur);

		// ACHATS
		ArrayList<Titre> titreAchete = Connection_DB
				.ListeTitre(_SQL_SELECT_Achat_Titre);
		session.setAttribute(_ACHAT_TITRE, titreAchete);

		// OPTION CALL ACHETES
		ArrayList<Option> titreOptionCall = Connection_DB.ListeOption("0",
				_SQL_SELECT_Achat_OPTION);
		session.setAttribute(_ACHAT_OPTION_CALL, titreOptionCall);

		// OPTION PUT ACHETES
		ArrayList<Option> titreOptionPut = Connection_DB.ListeOption("1",
				_SQL_SELECT_Achat_OPTION);
		session.setAttribute(_ACHAT_OPTION_PUT, titreOptionPut);

		// ENCHERE OBTENUS ET EN COURS
		// TITRE
		ArrayList<Titre> AchatTitreEnchere = Connection_DB
				.ListeTitre(_SQL_SELECT_Enchere_Titre_ENCOURS);
		session.setAttribute(_ACHAT_ENCHERE_TITRE, AchatTitreEnchere);
		// OPTION CALL
		ArrayList<Option> AchatCallEnchere = Connection_DB.ListeOption("2",
				_SQL_SELECT_Enchere_OPTION);
		session.setAttribute(_ACHAT_ENCHERE_CALL, AchatCallEnchere);
		// OPTION PUT
		ArrayList<Option> AchatPutEnchere = Connection_DB.ListeOption("3",
				_SQL_SELECT_Enchere_OPTION);
		session.setAttribute(_ACHAT_ENCHERE_PUT, AchatPutEnchere);

		// VENTES
		ArrayList<Titre> titreVendu = Connection_DB
				.ListeTitre(_SQL_SELECT_Vente_Titre);
		session.setAttribute(_VENTE_TITRE, titreVendu);

		// OPTION CALL ACHETES
		ArrayList<Option> titreOptionCallV = Connection_DB.ListeOption("0",
				_SQL_SELECT_Vente_Option);
		session.setAttribute(_VENTE_OPTION_CALL, titreOptionCallV);

		// OPTION PUT ACHETES
		ArrayList<Option> titreOptionPutV = Connection_DB.ListeOption("1",
				_SQL_SELECT_Vente_Option);
		session.setAttribute(_VENTE_OPTION_PUT, titreOptionPutV);

		// ENCHERE OBTENUS ET EN COURS
		// TITRE
		ArrayList<Titre> AchatTitreEnchereV = Connection_DB
				.ListeTitre(_SQL_SELECT_Vente_Enchere_Titre);
		session.setAttribute(_VENTE_ENCHERE_TITRE, AchatTitreEnchereV);
		// OPTION CALL
		ArrayList<Option> AchatCallEnchereV = Connection_DB.ListeOption("2",
				_SQL_SELECT_Vente_Enchere_Option);
		session.setAttribute(_VENTE_ENCHERE_CALL, AchatCallEnchereV);
		// OPTION PUT
		ArrayList<Option> AchatPutEnchereV = Connection_DB.ListeOption("3",
				_SQL_SELECT_Vente_Enchere_Option);
		session.setAttribute(_VENTE_ENCHERE_PUT, AchatPutEnchereV);

		getServletContext().getRequestDispatcher(
				"/WEB-INF/ListeTransaction/ListeTransaction.jsp").forward(
				request, response);
	}
}