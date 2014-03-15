<%@page import="java.util.ArrayList"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.objet.Titre"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.objet.Option"%>
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
<title>Liste Transaction</title>
</head>
<body id="investisseur">
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
					<img src="images/text/investisseur.png" alt="" />
				</center>
				<br /> <br />


				<div class="tr-left">
					<h1 class="center">ACHAT</h1>
					<br />

					<h1>Action(s) Achetée(s)</h1>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center" class="tr1">
						<thead>
							<TR>
								<TD align="center">Type de Contrat</TD>
								<TD align="center">Nom de l'Entreprise</TD>
								<TD align="center">Prix Initial</TD>
								<TD align="center">Consulter</TD>


							</TR>
						</thead>
						<%
							Titre titre = null;
							ArrayList<Titre> resultat = (ArrayList<Titre>) session
									.getAttribute("_ACHAT_TITRE");
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
							<TD align="center">
								<%
									if (titre.getStatut() == 0) {
								%>IMMEDIAT <%
									} else {
								%>ENCHERE <%
									}
								%>


							</TD>
							<TD align="center"><%=titre.getNomEntreprise()%></TD>
							<TD align="center"><%=titre.getPrix()%></TD>
							<TD align="center">
								<form action="/PrivateMarket/TitreImmediat" method="Post">
									<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
									<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form>
							</TD>


						</TR>
						<%
							}
						%>

					</TABLE>

					<h1>Call(s) Achete(s)</h1>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center" class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prix Initial</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option option = null;
							ArrayList<Option> AchatCallImmediat = (ArrayList<Option>) session
									.getAttribute("_ACHAT_OPTION_CALL");
							for (int i = 0; i < AchatCallImmediat.size(); i++) {
								option = (Option) AchatCallImmediat.get(i);
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
							<TD align="center">CALL</TD>
							<TD align="center"><%=option.getNomEntreprise()%></TD>
							<TD align="center"><%=option.getPrixInitial()%></TD>
	
							<TD align="center"><form
									action="/PrivateMarket/OptionImmediat" method="Post">
									<input type="hidden" name="idTitre"
										value="<%=option.getIdSOI()%>"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>


					<h1>Put(s) Acheté(s)</h1>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center" class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option option1 = null;
							ArrayList<Option> AchatPUTImmediat = (ArrayList<Option>) session
									.getAttribute("_ACHAT_OPTION_PUT");
							for (int i = 0; i < AchatPUTImmediat.size(); i++) {
								option1 = (Option) AchatPUTImmediat.get(i);
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
							<TD align="center">PUT</TD>
							<TD align="center"><%=option1.getNomEntreprise()%></TD>
							<TD align="center"><form
									action="/PrivateMarket/OptionImmediat" method="Post">
									<input type="hidden" name="idTitre"
										value="<%=option1.getIdSOI()%>"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>

					<h1>Achat: Enchere Titre</h1>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center" class="tr1">
						<thead>
							<TR>

								<TD align="center">Nom de l'Entreprise</TD>
								<TD align="center">Consulter</TD>


							</TR>
						</thead>
						<%
							Titre titreE = null;
							ArrayList<Titre> resultatTE = (ArrayList<Titre>) session
									.getAttribute("_ACHAT_ENCHERE_TITRE");
							for (int i = 0; i < resultatTE.size(); i++) {
								titreE = (Titre) resultatTE.get(i);

								if (i % 2 == 0) {
						%>

						<TR class="bl">
							<%
								}

									if (i % 2 != 0) {
							%>
						
						<TR class="wl">
							<%
								}
							%>
							<TD align="center"><%=titreE.getNomEntreprise()%></TD>
							<TD align="center">
								<form action="/PrivateMarket/TitreEnchere" method="Post">
									<input type="hidden" name="idTitre" value="<%=titreE.getId()%>">
									<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form>
							</TD>


						</TR>
						<%
							}
						%>

					</TABLE>

					<h1>Achat: Enchere Call</h1>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center" class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option optionAEC = null;
							ArrayList<Option> resultatAEC = (ArrayList<Option>) session
									.getAttribute("_ACHAT_ENCHERE_CALL");
							for (int i = 0; i < resultatAEC.size(); i++) {
								optionAEC = (Option) resultatAEC.get(i);

								if (i % 2 == 0) {
						%>

						<TR class="bl">
							<%
								}

									if (i % 2 != 0) {
							%>
						
						<TR class="wl">
							<%
								}
							%>
							<TD align="center">CALL</TD>
							<TD align="center"><%=optionAEC.getNomEntreprise()%></TD>
							<TD align="center"><form
									action="/PrivateMarket/OptionEnchere" method="Post">
									<input type="hidden" name="idTitre"
										value="<%=optionAEC.getIdSOI()%>"> <INPUT
										type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>
					<h1>Achat: Enchere Put</h1>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center" class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option optionAEP = null;
							ArrayList<Option> resultatAEP = (ArrayList<Option>) session
									.getAttribute("_ACHAT_ENCHERE_PUT");
							for (int i = 0; i < resultatAEP.size(); i++) {
								optionAEP = (Option) resultatAEP.get(i);

								if (i % 2 == 0) {
						%>

						<TR class="bl">
							<%
								}

									if (i % 2 != 0) {
							%>
						
						<TR class="wl">
							<%
								}
							%>
							<TD align="center">PUT</TD>
							<TD align="center"><%=optionAEP.getNomEntreprise()%></TD>
							<TD align="center"><form
									action="/PrivateMarket/OptionEnchere" method="Post">
									<input type="hidden" name="idTitre"
										value="<%=optionAEP.getIdSOI()%>"> <INPUT
										type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>
				</div>

				<div class="tr-left">
					<h1 class="center">VENTE</h1>
					<br />

					<h2>Liste des titre achat immédiat</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>
							<td>Nom de la société :</td>
							<td>Code :</td>
							<td>Création :</td>
							<td>Secteur d'activité :</td>
							<td>Action :</td>
						</thead>
						<tr class="bl">
							<td>Booba & Co</td>
							<td>FR00000BOCO</td>
							<td>14 Février 2014</td>
							<td>Musique souterraine</td>
							<td class="center">Voir</td>
						</tr>
						<tr class="wl">
							<td>SAMSUNG KOREAN & CO</td>
							<td>KR00000SAMKO</td>
							<td>12 Mars 2010</td>
							<td>Appareil éléctronique</td>
							<td class="center">Voir</td>
						</tr>
					</table>
					<h2>Liste des CALL achat immédiat</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>
							<td>Nom de la société :</td>
							<td>Code :</td>
							<td>Création :</td>
							<td>Secteur d'activité :</td>
							<td>Action :</td>
						</thead>
						<tr class="bl">
							<td>Booba & Co</td>
							<td>FR00000BOCO</td>
							<td>14 Février 2014</td>
							<td>Musique souterraine</td>
							<td class="center">Voir</td>
						</tr>
						<tr class="wl">
							<td>SAMSUNG KOREAN & CO</td>
							<td>KR00000SAMKO</td>
							<td>12 Mars 2010</td>
							<td>Appareil éléctronique</td>
							<td class="center">Voir</td>
						</tr>
					</table>
				</div>
				<br /> <br /> <a class="center" href="./logged">Retour à la
					page principal</a>

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
</body>
</html>







