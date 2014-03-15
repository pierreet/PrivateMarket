<%@page import="java.util.ArrayList"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.objet.Titre"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css"
	media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Titre Enchere</title>
</head>
<body id="societes">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="images/logo2.png" alt="privatemarket"/></div>
			<div class="menu">
				<a href="./listeEntreprise" ><img src="images/menu/liste.png" alt="liste" /></a>
				<a href="./deconnexion" ><img src="images/menu/logout.jpg" alt="logout" /></a></div>
		</div>
	</div>
	<div id="content">
	<div id="bg_body_top"></div>
	<div id="bg_body_center">
		<div id="bg_body">
			<center>
				<img src="images/icon/contrats.png" alt="" />
			</center>
			<br /> <br />




			<TABLE id="tab_societes" CELLPADDING=0 CELLSPACING=0>
				<thead>
					<TR>

						<TD align="center">Nom de l'Entreprise</TD>
						<TD align="center">Nom de Vendeur</TD>
						<TD align="center">Prix Initial</TD>
						<TD align="center">Prix Actuel</TD>
						<TD align="center">Date Creation</TD>
						<TD align="center">Date Fin</TD>
						<TD align="center">Consulter</TD>


					</TR>
				</thead>
				<%
					Titre titre = null;
					ArrayList<Titre> resultat = (ArrayList<Titre>) session
							.getAttribute("_LISTE_OPERATIONS_TITRE_ENCHERE");
					for (int i = 0; i < resultat.size(); i++) {
						titre = (Titre) resultat.get(i);
				%>
				<%
					if (i % 2 == 0) {
				%>

				<TR class="bl">
					<%
						}
					%>
					<%
						if (i % 2 != 0) {
					%>
				
				<TR class="wl">
					<%
						}
					%>
					<TD align="center"><%=titre.getNomEntreprise()%></TD>
					<TD align="center"><%=titre.getNomVendeur()%></TD>
					<TD align="center"><%=titre.getPrix()%></TD>
					<TD align="center"><%=titre.getPrixActuel()%></TD>
					<TD align="center"><%=titre.getDateCreation()%></TD>
					<TD align="center"><%=titre.getDateFin()%></TD>
					<TD align="center">
						<form action="/PrivateMarket/TitreEnchere" method="Post">
							<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
							<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
						</form>
					</TD>


				</TR>
				<%
					}
				%>

			</TABLE>
		</div>
	</div>
	<div id="bg_body_foot"></div>
	</div>
	<div id="foot_body">
		<div class="copyright">
			Site web réalisé en J2EE par <b>Jacques CHAN, Vincent RATNAM,
				Thomas Souffir, Pierre-Etienne Crepy</b><br /> Dans le cadre d'un
			projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
	</div>
</body>
</html>