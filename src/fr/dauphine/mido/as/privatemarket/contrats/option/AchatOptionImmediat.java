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



@WebServlet("/AchatOptionImmediat")
public class AchatOptionImmediat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AchatOptionImmediat() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String _SQL_UPDATE_OPERATIONS = "UPDATE privatemarket.stockoption"
			+ " SET idAcheteur=?, DateFinal=? where idSOE=? and idAcheteur=0";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String[] idTitre = request.getParameterValues("idTitre");

		try {
			
			int a = Connection_DB.UpdateAcheteur(Connexion.getIdUtilisateur(request),idTitre[0], _SQL_UPDATE_OPERATIONS);
			if(a==1)
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
				"/WEB-INF/Option/TransactionOptionImmediat.jsp").forward(request, response);

	}

}