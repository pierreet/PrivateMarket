package fr.dauphine.mido.as.privatemarket.contrats.option;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Entreprise;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Option;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Vendeur;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/OptionImmediat")
public class OptionImmediat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String _LISTE_OPERATIONS_OPTION_IMMEDIAT = "_LISTE_OPERATIONS_OPTION_IMMEDIAT";

	public OptionImmediat() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_SELECT_OPERATIONS = "select * from privatemarket.stockoption where idSOE=?";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] idTitre = request.getParameterValues("idTitre");
		String[] idType = request.getParameterValues("type");

		if (idType[0].equals("vente")) {
			session.setAttribute("TYPE", "VENTE");
		} else {
			session.setAttribute("TYPE", "ACHAT");
		}
		Option listeTitre = Connection_DB.rechercheOptionUnique(idTitre[0],
				_SQL_SELECT_OPERATIONS);
		session.setAttribute(OptionImmediat._LISTE_OPERATIONS_OPTION_IMMEDIAT,
				listeTitre);
		try {
			Entreprise entreprise = new Entreprise(listeTitre.getIdEntreprise());
			session.setAttribute(Entreprise._Entreprise, entreprise);
			Vendeur vendeur = new Vendeur(listeTitre.getIdVendeur());
			session.setAttribute(Vendeur._Vendeur, vendeur);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher(
				"/WEB-INF/Option/OptionImmediat.jsp")
				.forward(request, response);
	}

}