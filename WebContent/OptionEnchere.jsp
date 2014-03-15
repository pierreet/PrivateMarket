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
<title>Option Enchere</title>
<link rel="stylesheet" type="text/css" href="css/pages.css"
	media="screen" />
</head>

<body id="detail">
	<%
		Option option = (Option) session
				.getAttribute("_LISTE_OPERATIONS_OPTION_ENCHERE");
		Entreprise entreprise = (Entreprise) session
				.getAttribute("_Entreprise");
		Vendeur vendeur = (Vendeur) session.getAttribute("_Vendeur");
	%>
	<div id="top">
		<div id="topBody">
			<div class="logo">
				<img src="images/logo2.png" alt="privatemarket" />
			</div>
			<div class="menu"></div>
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
						<h2>Information général</h2>
						<table>
							<tr>
								<td width="200"><b>Nom de la société :</b></td>
								<td><%=entreprise.getNomEntreprise()%></td>
							</tr>
							<tr>
								<td><b>Date de création :</b></td>
								<td><%=entreprise.getAnneeEntreprise()%></td>
							</tr>
							<tr>
								<td><b>Secteur d'activité :</b></td>
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
								<td><b>Prénom :</b></td>
								<td><%=vendeur.getPrenomUtilisateur()%></td>
							</tr>
							<tr>
								<td><b>E-mail :</b></td>
								<td><%=vendeur.getEmailUtilisateur()%></td>
							</tr>
							<tr>
								<td><b>Pays:</b></td>
								<td><%=vendeur.getPaysUtilisateur()%></td>
							</tr>
							<tr>
								<td colspan="2">Le contrat est <b>vendu</b> par la
									société/investisseur
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
				<div class="right-achat">
					<form name="form" action="./OptionDemandeEnchere" method="Post">
						<div class="box-achat">
							<div class="prixEn">
								<%=option.getPrime()%><br /> <span>PRIVATE MARKET
									DONNées TEMPS RÉEL enchere minimum: <%=option.getPrime() + 0.01%></span>
							</div>
							<div class="box-input">
								<input type="text" class="input-en" name="enchere" />
							</div>
							<div class="right-button">
								<input type="hidden" name="idTitre" value="<%=option.getIdSOI()%>">
								<input class="send" type="submit" /><a onclick="form.submit()"><img
									src="images/icon/encherir.jpg" alt="encherir" /></a>
							</form>
							</div>
							<div class="prix-info">
								<h2>Information sur l'action</h2>
								<table align="center">
									<tr>
										<td width="300"><b>Type :</b></td>
										<td>Option <%
										if (option.getStatut() == 0) {
									%> CALL <%
										}

										if (option.getStatut() == 1) {
									%> PUT <%
										}
									%></td>
									</tr>
									<tr>
										<td width="300"><b>Prix initial :</b></td>
										<td><%=option.getPrixInitial()%></td>
									</tr>
									<tr>
										<td width="300"><b>Prix d'exercice :</b></td>
										<td><%=option.getStrike()%></td>
									</tr>
									<tr>
										<td width="300"><b>Prime Initial:</b></td>
										<td><%=option.getPrimeInitial()%></td>
									</tr>

									<td width="300"><b>Mode de négociation :</b></td>
									<td>Enchère</td>
									</tr>
									<tr>
										<td width="300"><b>Date de création du contrat :</b></td>
										<td><%=option.getDateInitial()%></td>
									</tr>
									<tr>
										<td width="300"><b>Date de fin du contrat :</b></td>
										<td><%=option.getDateFinal()%></td>
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
			Site web réalisé en J2EE par <b>Jacques CHAN, Vincent RATNAM,
				Thomas Souffir, Pierre-Etienne Crepy</b><br /> Dans le cadre d'un
			projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
</body>
</html>










