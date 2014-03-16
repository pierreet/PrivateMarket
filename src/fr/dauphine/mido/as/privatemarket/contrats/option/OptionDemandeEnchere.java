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
import fr.dauphine.mido.as.privatemarket.servlets.Connexion;

@WebServlet("/OptionDemandeEnchere")
public class OptionDemandeEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OptionDemandeEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.stockoption"
			+ " SET idAcheteur=?, Prime= ? where idSOE=?";
	private final static String _SQL_SELECT_OPERATIONS = "SELECT Prime from privatemarket.stockoption"
			+ " where idSOE=?";

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
		Double PrixActuel = Connection_DB.getPrixActuel(idTitre[0],
				_SQL_SELECT_OPERATIONS);
		if (PrixActuel > enchere) {
			session.setAttribute("TRANSACTION", "KO");
		} else {
			try {
				Connection_DB.UpdatePrix(_SQL_UPDATE_OPERATIONS, enchere,
						idTitre[0], Connexion.getIdUtilisateur(request));
				session.setAttribute("TRANSACTION", "OK");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher(
				"/WEB-INF/Option/TransactionOption.jsp").forward(request,
				response);

	}

}