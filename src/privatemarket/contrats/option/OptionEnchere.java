package privatemarket.contrats.option;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import privatemarket.contrats.objet.Connection_DB;
import privatemarket.contrats.objet.Entreprise;
import privatemarket.contrats.objet.Option;
import privatemarket.contrats.objet.Vendeur;

@WebServlet("/OptionEnchere")
public class OptionEnchere extends HttpServlet {
	public static String _LISTE_OPERATIONS_OPTION_ENCHERE = "_LISTE_OPERATIONS_OPTION_ENCHERE";
	private static final long serialVersionUID = 1L;
	private final static String _SQL_SELECT_TITRE = "select * from privatemarket.stockoptionenchere"
			+ " where idSOE=?";

	public OptionEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] idTitre = request.getParameterValues("idTitre");
		Option listeTitre = Connection_DB.rechercheOptionUnique(idTitre[0],
				_SQL_SELECT_TITRE, 1);
		session.setAttribute(OptionEnchere._LISTE_OPERATIONS_OPTION_ENCHERE, listeTitre);
		try {
			Entreprise entreprise = new Entreprise(listeTitre.getIdEntreprise());
			session.setAttribute(Entreprise._Entreprise, entreprise);
			Vendeur vendeur = new Vendeur(listeTitre.getIdVendeur());
			session.setAttribute(Vendeur._Vendeur, vendeur);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/OptionEnchere.jsp").forward(
				request, response);
	}

}