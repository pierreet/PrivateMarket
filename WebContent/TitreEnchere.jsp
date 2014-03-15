<%@page import="java.util.ArrayList"%>
<%@page import="privatemarket.contrats.objet.Titre"%>
<%@page import="privatemarket.contrats.objet.Entreprise"%>
<%@page import="privatemarket.contrats.objet.Vendeur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="_COMPTE_COURANT"
	class="privatemarket.contrats.objet.Titre" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Titre Enchere</title>
</head>
<body>
	<CENTER>
		<h1>Données du Titre</h1>
		<TABLE border="1">
			<TBODY>
				<TR>

					<TD align="center">Nom de l'Entreprise</TD>
					<TD align="center">Nom de Vendeur</TD>
					<TD align="center">Prix</TD>
					<TD align="center">Prix Actuel</TD>
					<TD align="center">Date Creation</TD>
					<TD align="center">Date Fin</TD>


				</TR>
			</TBODY>
			<%
				Titre titre = (Titre) session.getAttribute("_LISTE_OPERATIONS");
			%>
			<TBODY>
				<TR>
					<TD align="center"><%=titre.getNomEntreprise()%></TD>
					<TD align="center"><%=titre.getNomVendeur()%></TD>
					<TD align="center"><%=titre.getPrix()%></TD>
					<TD align="center"><%=titre.getPrixActuel()%></TD>
					<TD align="center"><%=titre.getDateCreation()%></TD>
					<TD align="center"><%=titre.getDateFin()%></TD>




				</TR>

			</TBODY>
		</TABLE>

		<h1>Encherir</h1>
		<form action="/PrivateMarket/TitreDemandeEnchere" method="Post">
			<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
			<input size="4" maxlength="7" name=enchere></input><br></br> Enchere
			minimum: <%=titre.getPrixActuel() + 1%>
			<INPUT type="submit" name="Envoyer" value="Encherir "></INPUT>
			Attention Action Définitive!
		</form>
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