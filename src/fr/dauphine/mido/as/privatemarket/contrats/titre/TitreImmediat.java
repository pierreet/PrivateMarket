package fr.dauphine.mido.as.privatemarket.contrats.titre;

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
import fr.dauphine.mido.as.privatemarket.contrats.objet.Titre;
import fr.dauphine.mido.as.privatemarket.contrats.objet.Vendeur;


@WebServlet("/TitreImmediat")
public class TitreImmediat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String _SQL_SELECT_OPERATIONS = "select * from privatemarket.titre where idTitre=? and statut=0";
	public static String _LISTE_OPERATIONS_TITRE_IMMEDIAT = "_LISTE_OPERATIONS_TITRE_IMMEDIAT";
	
	public TitreImmediat() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] idTitre = request.getParameterValues("idTitre");
		Titre listeTitre = Connection_DB.rechercheTitreUnique(idTitre[0],
				_SQL_SELECT_OPERATIONS);
		session.setAttribute(_LISTE_OPERATIONS_TITRE_IMMEDIAT, listeTitre);
		try {
			Entreprise entreprise = new Entreprise(listeTitre.getIdEntreprise());
			session.setAttribute(Entreprise._Entreprise, entreprise);
			Vendeur vendeur = new Vendeur(listeTitre.getIdVendeur());
			session.setAttribute(Vendeur._Vendeur, vendeur);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/Titre/TitreImmediat.jsp").forward(
				request, response);
	}

}