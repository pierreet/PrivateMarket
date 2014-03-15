package fr.dauphine.mido.as.privatemarket.contrats.traitement;

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


@WebServlet("/ListeOptionEnchere")
public class ListeOptionEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
	static Date date = new Date();;
	static String DateActuel = dateFormat.format(date);
	public static String _LISTE_OPERATIONS_OPTION_ENCHERE = "_LISTE_OPERATIONS_OPTION_ENCHERE";

	public ListeOptionEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_SELECT_Liste_Enchere = "select * from privatemarket.stockoption "
			+ "	where DateFinal > '"
			+ DateActuel
			+ "' and Statut=? order by DateFinal asc";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] statut = request.getParameterValues("type");
		ArrayList<Option> listeTitre = Connection_DB.ListeOption(statut[0],
				_SQL_SELECT_Liste_Enchere);
		session.setAttribute(_LISTE_OPERATIONS_OPTION_ENCHERE, listeTitre);

		getServletContext().getRequestDispatcher("/WEB-INF/ListeOptionetTitre/ListeOptionEnchere.jsp")
				.forward(request, response);
	}

}
