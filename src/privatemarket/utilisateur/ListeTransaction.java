package privatemarket.utilisateur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import privatemarket.contrats.objet.Connection_DB;
import privatemarket.contrats.objet.Option;
import privatemarket.contrats.objet.Titre;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/ListeTransaction")
public class ListeTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int idUser = 6;

	public ListeTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Achats Immediat
	private final static String _SQL_SELECT_Achat_Titre = "select * from privatemarket.titreimmediat where idAcheteur=5";
	private final static String _SQL_SELECT_Achat_OPTION = "select * from privatemarket.stockoptionimmediat where idAcheteur=5 and Statut=?";
	// Enchere en cours et obtenus
	private final static String _SQL_SELECT_Enchere_Titre =
			"select * from privatemarket.titreenchere where idAcheteur=5 ORDER BY DateFin desc";
	private final static String _SQL_SELECT_Enchere_OPTION= "select * from privatemarket.stockoptionenchere where idAcheteur=5 and Statut=?";
	// Ventes
	private final static String _SQL_SELECT_Vente_Titre = "select * from privatemarket.titreimmediat where idVendeur=5";
	private final static String _SQL_SELECT_Vente_Option = "select * from privatemarket.stockoptionimmediat where idVendeur=5";
	// Enchere en cours - finis ayant trouvé vendeur
	private final static String _SQL_SELECT_Vente_Enchere_Titre = "select * from privatemarket.titreenchere where idVendeur=5";
	private final static String _SQL_SELECT_Vente_Enchere_Option = "select * from privatemarket.stockoptionenchere where idVendeur=5";
	
	public static String _ACHAT_TITRE = "_ACHAT_TITRE";
	public static String _ACHAT_OPTION_CALL = "_ACHAT_OPTION_CALL";
	public static String _ACHAT_OPTION_PUT = "_ACHAT_OPTION_PUT";
	public static String _ACHAT_ENCHERE_TITRE = "_ACHAT_ENCHERE_TITRE";
	public static String _ACHAT_ENCHERE_CALL = "_ACHAT_ENCHERE_CALL";
	public static String _ACHAT_ENCHERE_PUT = "_ACHAT_ENCHERE_PUT";
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		//TITRE ACHETES
		ArrayList<Titre> titreAchete = Connection_DB
				.ListeTitreI(_SQL_SELECT_Achat_Titre);
		session.setAttribute(_ACHAT_TITRE, titreAchete);
		
		//OPTION CALL ACHETES
		ArrayList<Option> titreOptionCall = Connection_DB.ListeOptionI("0",
				_SQL_SELECT_Achat_OPTION);
		session.setAttribute(_ACHAT_OPTION_CALL, titreOptionCall);
		
		//OPTION PUT ACHETES
		ArrayList<Option> titreOptionPut = Connection_DB.ListeOptionI("1",
				_SQL_SELECT_Achat_OPTION);
		session.setAttribute(_ACHAT_OPTION_PUT, titreOptionPut);
		
		//ENCHERE OBTENUS ET EN COURS
			//TITRE
		ArrayList<Titre> AchatTitreEnchere = Connection_DB.ListeTitreE(_SQL_SELECT_Enchere_Titre);
		session.setAttribute(_ACHAT_ENCHERE_TITRE, AchatTitreEnchere);
			//OPTION CALL
		ArrayList<Option> AchatCallEnchere = Connection_DB.ListeOptionE("0", _SQL_SELECT_Enchere_OPTION);
		session.setAttribute(_ACHAT_ENCHERE_CALL, AchatCallEnchere);
			//OPTION PUT
		ArrayList<Option> AchatPutEnchere = Connection_DB.ListeOptionE("1", _SQL_SELECT_Enchere_OPTION);
		session.setAttribute(_ACHAT_ENCHERE_PUT, AchatPutEnchere);
		
		getServletContext().getRequestDispatcher("/ListeTransaction.jsp")
				.forward(request, response);
	}

}