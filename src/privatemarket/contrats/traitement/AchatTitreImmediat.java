package privatemarket.contrats.traitement;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import privatemarket.contrats.objet.Connection_DB;

@WebServlet("/AchatTitreImmediat")
public class AchatTitreImmediat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AchatTitreImmediat() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.titreimmediat"
			+ " SET idAcheteur='5' where idTitre=? and idAcheteur=0";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] idTitre = request.getParameterValues("idTitre");

		try {
			int a = Connection_DB.UpdateAcheteur(idTitre[0], _SQL_UPDATE_OPERATIONS);
			if(a == 1)
			session.setAttribute("TRANSACTION", "OK");
			else{
				session.setAttribute("TRANSACTION", "KO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("TRANSACTION", "KO");
		}

		getServletContext().getRequestDispatcher(
				"/TransactionTitreImmediat.jsp").forward(request, response);

	}

}