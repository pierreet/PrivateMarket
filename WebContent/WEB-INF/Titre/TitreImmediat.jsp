<%@page import="java.util.ArrayList"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.objet.Titre"%>
<%@page
	import="fr.dauphine.mido.as.privatemarket.contrats.objet.Entreprise"%>
<%@page
	import="fr.dauphine.mido.as.privatemarket.contrats.objet.Vendeur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${sessionScope.sessionUtilisateur.statut >= 0}">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/pages.css"
	media="screen" />
<title>Titre Achat Immediat</title>
</head>
<body id="detail">
	<%
		Titre titre = (Titre) session
					.getAttribute("_LISTE_OPERATIONS_TITRE_IMMEDIAT");
			Entreprise entreprise = (Entreprise) session
					.getAttribute("_Entreprise");
			Vendeur vendeur = (Vendeur) session.getAttribute("_Vendeur");
			String type = (String) session.getAttribute("TYPE");
	%>
	<div id="top">
		<div id="topBody">
			<div class="logo">
				<img src="images/logo2.png" alt="privatemarket" />
			</div>
			<div class="menu">
				<a href="./pages/listeEntreprises.xhtml"><img src="images/menu/liste.png"
					alt="liste" /></a> <a href="./deconnexion"><img
					src="images/menu/logout.jpg" alt="logout" /></a>
			</div>
		</div>
	</div>
	<div id="content">
		<div id="bg_body_top"></div>
		<div id="bg_body_center">
			<div id="bg_body">
				<div class="left-icon">
					<img src="images/icon/detail.png" alt="" />
				</div>
				<div class="right-content">
					<h1><%=entreprise.getNomEntreprise()%></h1>
					<div class="left-info">
						<h2>Information g�n�ral</h2>
						<table>
							<tr>
								<td width="200"><b>Nom de la soci�t� :</b></td>
								<td><%=entreprise.getNomEntreprise()%></td>
							</tr>
							<tr>
								<td><b>Date de cr�ation :</b></td>
								<td><%=entreprise.getNomEntreprise()%></td>
							</tr>
							<tr>
								<td><b>Secteur d'activit� :</b></td>
								<td><%=entreprise.getSecteurEntreprise()%></td>
							</tr>
							<tr>
								<td><b>Code :</b></td>
								<td><%=entreprise.getCodeEntreprise()%></td>
							</tr>
						</table>
					</div>
					<div class="right-info">
						<h2>Information du vendeur</h2>
						<table>
							<tr>
								<td width="100"><b>Nom :</b></td>
								<td><%=vendeur.getNomUtilisateur()%></td>
							</tr>
							<tr>
								<td><b>Pr�nom :</b></td>
								<td><%=vendeur.getPrenomUtilisateur()%></td>
							</tr>
							<tr>
								<td><b>E-mail :</b></td>
								<td><%=vendeur.getEmailUtilisateur()%></td>
							</tr>
							<tr>
								<td><b>Pays :</b></td>
								<td><%=vendeur.getPaysUtilisateur()%></td>
							</tr>
							<tr>
								<td colspan="2">Le contrat est <b>vendu</b> par la soci�t�
									ou par investisseur(faire une requete)
								</td>
							</tr>
						</table>
					</div>
					<div class="histoire">
						<h2>Histoire :</h2>
						<%=entreprise.getDescriptionEntreprise()%>
					</div>
				</div>
				<div class="left-contact">
					<a href="https://www.facebook.com/"><img
						src="images/icon/like.jpg" alt="like" /></a> <img
						src="images/icon/rss.jpg" alt="rss" /> <a
						href="mailto:contact@jacqueschan.fr"><img
						src="images/icon/email.jpg" alt="email" /></a> <a
						href="javascript:window.print()"><img
						src="images/icon/print.jpg" alt="print" /></a>
				</div>
				<%
					if (type.equals("ACHAT")) {
				%>
				<form name="form" action="./AchatTitreImmediat" method="Post">
					<div class="right-achat">
						<div class="box-achat">
							<div class="prix">
								<%=titre.getPrix()%>
								EUR<br /> <span>PRIVATE MARKET DONN�es DIFF�r�</span>
							</div>
							<div class="right-button">
								<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
								<input class="send" type="submit" /><a onclick="form.submit()">
									<img src="images/icon/acheter.jpg" alt="acheter" />
								</a>
				</form>
				<%
					} else {
				%><form name="form" action="" method="Post">
					<div class="right-achat">
						<div class="box-achat">
							<div class="prix">
								<%=titre.getPrix()%>
								EUR<br /> <span>PRIVATE MARKET DONN�es DIFF�r�</span>
							</div>
							<div class="right-button">
								<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
								<input class="send" type="submit" /><a onclick="form.submit()">
									<img src="images/icon/vendre.jpg" alt="vendre" />
								</a>
				</form>
				<%
					}
				%>
			</div>
			<div class="prix-info">
				<h2>Information sur l'action</h2>
				<table align="center">
					<tr>
						<td width="300"><b>Mode de n�gociation :</b></td>
						<td>R�alisation imm�diate</td>
					</tr>
					<tr>
						<td width="300"><b>Date de cr�ation du contrat :</b></td>
						<td><%=titre.getDateCreation()%></td>
					</tr>
					<tr>
						<td width="300"><b>Date de fin du contrat :</b></td>
						<td><%=titre.getDateFin()%></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div id="bg_body_foot"></div>
	</div>
	</div>
	<div id="foot_body">
		<div class="copyright">
			Site web r�alis� en J2EE par <b>Jacques CHAN, Vincent RATNAM,
				Thomas Souffir, Pierre-Etienne Crepy</b><br /> Dans le cadre d'un
			projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
</body>
	</html>
</c:if>
