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
import privatemarket.contrats.objet.Titre;

@WebServlet("/ListeTitreImmediat")
public class ListeTitreImmediat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String _PRECEDENTES_CONSULTATIONS_SQL = "_PRECEDENTES_CONSULTATIONS_SQL";
	public static String _LISTE_OPERATIONS_TITRE_IMMEDIAT = "_LISTE_OPERATIONS_TITRE_IMMEDIAT";
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
	static Date date = new Date();;
	static String DateActuel = dateFormat.format(date);

	public ListeTitreImmediat() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_SELECT_OPERATIONS = 
			"select * from privatemarket.titreimmediat where idAcheteur='0' and " +
			"DateFin> '" + DateActuel + "' order by Prix asc";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ArrayList<Titre> listeTitre = Connection_DB
				.ListeTitreI(_SQL_SELECT_OPERATIONS);
		session.setAttribute(_LISTE_OPERATIONS_TITRE_IMMEDIAT, listeTitre);
		getServletContext().getRequestDispatcher("/ListeTitreImmediat.jsp")
		.forward(request, response);
	}

}