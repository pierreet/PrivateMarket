<%@page import="java.util.ArrayList"%>
<%@page import="privatemarket.contrats.objet.Option"%>
<%@page import="privatemarket.contrats.objet.Entreprise"%>
<%@page import="privatemarket.contrats.objet.Vendeur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="_COMPTE_COURANT"
	class="privatemarket.contrats.objet.Option" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Option Achat Immediat</title>
</head>
<body>
	<CENTER>
		<h1>Données du Stock Option</h1>
		<TABLE border="1">
			<TBODY>
				<TR>

					<TD align="center">Type</TD>
					<TD align="center">Entreprise</TD>
					<TD align="center">Vendeur</TD>
					<TD align="center">Prix Initial</TD>
					<TD align="center">Prime</TD>
					<TD align="center">Strike</TD>
					<TD align="center">Date Initial</TD>
					<TD align="center">Date Final</TD>
					<TD align="center">Acheter</TD>
				</TR>
			</TBODY>
			<%
				Option option = (Option) session.getAttribute("_LISTE_OPERATIONS");
			%>
			<TBODY>
				<TR>
					<TD align="center">
						<%
							if (option.getStatut() == 0) {
						%> CALL <%
							}
						%> <%
 	if (option.getStatut() == 1) {
 %> PUT <%
 	}
 %>
					</TD>
					<TD align="center"><%=option.getNomEntreprise()%></TD>
					<TD align="center"><%=option.getNomVendeur()%></TD>
					<TD align="center"><%=option.getPrixInitial()%></TD>
					<TD align="center"><%=option.getPrime()%></TD>
					<TD align="center"><%=option.getStrike()%></TD>
					<TD align="center"><%=option.getDateInitial()%></TD>
					<TD align="center"><%=option.getDateFinal()%></TD>
					<TD><form action="/PrivateMarket/AchatOptionImmediat" method="Post">
						<input type="hidden" name="idTitre" value="<%=option.getIdSOI()%>">
						<INPUT type="submit" name="Envoyer" value="Acheter"></INPUT>
					</form></TD>

				</TR>
			</TBODY>


		</TABLE>
		<h1>Données de l'entreprise</h1>
		<TABLE border="1">
			<TBODY>
				<TR>

					<TD align="center">Nom de l'Entreprise</TD>
					<TD align="center">Annee</TD>
					<TD align="center">Code</TD>
					<TD align="center">Description</TD>
					<TD align="center">Secteur d'Activite</TD>


				</TR>
			</TBODY>
			<%
				Entreprise entreprise = (Entreprise) session
						.getAttribute("_Entreprise");
			%>
			<TBODY>
				<TR>
					<TD align="center"><%=entreprise.getNomEntreprise()%></TD>
					<TD align="center"><%=entreprise.getAnneeEntreprise()%></TD>
					<TD align="center"><%=entreprise.getCodeEntreprise()%></TD>
					<TD align="center"><%=entreprise.getDescriptionEntreprise()%></TD>
					<TD align="center"><%=entreprise.getSecteurEntreprise()%></TD>

				</TR>

			</TBODY>
		</TABLE>
		<h1>Données du Vendeur</h1>
		<TABLE border="1">
			<TBODY>
				<TR>

					<TD align="center">Nom</TD>
					<TD align="center">Prénom</TD>
					<TD align="center">Email</TD>
					<TD align="center">Pays</TD>



				</TR>
			</TBODY>
			<%
				Vendeur vendeur = (Vendeur) session.getAttribute("_Vendeur");
			%>
			<TBODY>
				<TR>
					<TD align="center"><%=vendeur.getNomUtilisateur()%></TD>
					<TD align="center"><%=vendeur.getPrenomUtilisateur()%></TD>
					<TD align="center"><%=vendeur.getEmailUtilisateur()%></TD>
					<TD align="center"><%=vendeur.getPaysUtilisateur()%></TD>

				</TR>

			</TBODY>
		</TABLE>

	</CENTER>
</body>
</html>