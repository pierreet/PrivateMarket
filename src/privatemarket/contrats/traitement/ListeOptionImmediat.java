package privatemarket.contrats.traitement;

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
import privatemarket.contrats.objet.Connection_DB;
import privatemarket.contrats.objet.Option;

/*CALL 0 PUT 1 */
@WebServlet("/ListeOptionImmediat")
public class ListeOptionImmediat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
	static Date date = new Date();;
	static String DateActuel = dateFormat.format(date);
	public static String _LISTE_OPERATIONS_OPTION_IMMEDIAT = "_LISTE_OPERATIONS_OPTION_IMMEDIAT";

	public ListeOptionImmediat() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_SELECT_OPERATIONS = "select * from privatemarket.stockoptionimmediat where"
			+ " bool = '0'and DateFinal > '"
			+ DateActuel
			+ "' and statut=? and idAcheteur=0 order by DateFinal asc";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] statut = request.getParameterValues("statut");
		ArrayList<Option> listeOption = Connection_DB.ListeOptionI(statut[0],
				_SQL_SELECT_OPERATIONS);
		session.setAttribute(ListeOptionImmediat._LISTE_OPERATIONS_OPTION_IMMEDIAT, listeOption);

		getServletContext().getRequestDispatcher("/ListeOptionImmediat.jsp")
				.forward(request, response);
	}

}
