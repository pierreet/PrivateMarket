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


@WebServlet("/TitreDemandeEnchere")
public class TitreDemandeEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TitreDemandeEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.titre"
			+ " SET PrixActuel= ?, idAcheteur='5' where idTitre=?";
	private final static String _SQL_SELECT_OPERATIONS = "SELECT PrixActuel from privatemarket.titre where idTitre=?";

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] idTitre = request.getParameterValues("idTitre");
		double enchere = Double.parseDouble(request.getParameter("enchere"));
		Double PrixActuel = Connection_DB.getPrixActuel(idTitre[0], _SQL_SELECT_OPERATIONS );
		if (PrixActuel > enchere) {
			session.setAttribute("TRANSACTION", "KO");
		} else {
			try {
				Connection_DB.UpdatePrix(_SQL_UPDATE_OPERATIONS, enchere, idTitre[0]);
				session.setAttribute("TRANSACTION", "OK");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/WEB-INF/Titre/TransactionEnchere.jsp")
				.forward(request, response);

	}

}