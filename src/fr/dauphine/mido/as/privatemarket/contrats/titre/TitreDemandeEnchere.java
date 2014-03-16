package fr.dauphine.mido.as.privatemarket.contrats.titre;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.privatemarket.contrats.objet.Connection_DB;
import fr.dauphine.mido.as.privatemarket.servlets.Connexion;

@WebServlet("/TitreDemandeEnchere")
public class TitreDemandeEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
	static Date date = new Date();;
	static String DateActuel = dateFormat.format(date);

	public TitreDemandeEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.titre"
			+ " SET idAcheteur=?, PrixActuel= ? where idTitre=? and DateFin>'"
			+ DateActuel + "'";
	private final static String _SQL_SELECT_OPERATIONS = "SELECT PrixActuel from privatemarket.titre where "
			+ "idTitre=? and DateFin>'" + DateActuel + "'";

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

		if (PrixActuel > enchere || PrixActuel == 0.0) {
			session.setAttribute("TRANSACTION", "KO");

		} else {
			try {
				Connection_DB.UpdatePrix(_SQL_UPDATE_OPERATIONS, enchere,
						idTitre[0], Connexion.getIdUtilisateur(request));
				session.setAttribute("TRANSACTION", "OK");
			} catch (SQLException e) {
				session.setAttribute("TRANSACTION", "KO");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher(
				"/WEB-INF/Titre/TransactionEnchere.jsp").forward(request,
				response);

	}
}