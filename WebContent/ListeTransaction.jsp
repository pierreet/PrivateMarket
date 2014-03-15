<%@page import="java.util.ArrayList"%>
<%@page import="privatemarket.contrats.objet.Titre"%>
<%@page import="privatemarket.contrats.objet.Option"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="_COMPTE_COURANT"
	class="privatemarket.contrats.objet.Titre" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css"
	media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Transaction</title>
</head>
<body id="societes">
	<div id="top">
		<div id="topBody">
			<div class="logo">
				<img src="images/logo2.png" alt="privatemarket" />
			</div>
			<div class="menu"></div>
		</div>
	</div>

	<div id="bg_body_top"></div>
	<div id="bg_body_center">
		<div id="bg_body">
			<center>
				<img src="images/icon/contrats.png" alt="" />
			</center>
			<br /> <br />



			<h1>Action(s) Achetée(s)</h1>
			<TABLE id="tab_societes" CELLPADDING=0 CELLSPACING=0>
				<thead>
					<TR>

						<TD align="center">Nom de l'Entreprise</TD>
						<TD align="center">Nom de Vendeur</TD>
						<TD align="center">Prix Initial</TD>
						<TD align="center">Date Creation</TD>
						<TD align="center">Date Fin</TD>
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
					<TD align="center"><%=titre.getNomEntreprise()%></TD>
					<TD align="center"><%=titre.getNomVendeur()%></TD>
					<TD align="center"><%=titre.getPrix()%></TD>
					<TD align="center"><%=titre.getDateCreation()%></TD>
					<TD align="center"><%=titre.getDateFin()%></TD>
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
			<TABLE id="tab_societes" CELLPADDING=0 CELLSPACING=0>
				<thead>

					<TR>
						<TD align="center">Type</TD>
						<TD align="center">Entreprise</TD>
						<TD align="center">Vendeur</TD>
						<TD align="center">Prix Initial</TD>
						<TD align="center">Prime</TD>
						<TD align="center">Strike</TD>
						<TD align="center">Date Initial</TD>
						<TD align="center">Date Final</TD>
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
					<TD align="center"><%=option.getNomVendeur()%></TD>
					<TD align="center"><%=option.getPrixInitial()%></TD>
					<TD align="center"><%=option.getPrime()%></TD>
					<TD align="center"><%=option.getStrike()%></TD>
					<TD align="center"><%=option.getDateInitial()%></TD>
					<TD align="center"><%=option.getDateFinal()%></TD>
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
			<TABLE id="tab_societes" CELLPADDING=0 CELLSPACING=0>
				<thead>

					<TR>
						<TD align="center">Type</TD>
						<TD align="center">Entreprise</TD>
						<TD align="center">Vendeur</TD>
						<TD align="center">Prix Initial</TD>
						<TD align="center">Prime</TD>
						<TD align="center">Strike</TD>
						<TD align="center">Date Initial</TD>
						<TD align="center">Date Final</TD>
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
					<TD align="center"><%=option1.getNomVendeur()%></TD>
					<TD align="center"><%=option1.getPrixInitial()%></TD>
					<TD align="center"><%=option1.getPrime()%></TD>
					<TD align="center"><%=option1.getStrike()%></TD>
					<TD align="center"><%=option1.getDateInitial()%></TD>
					<TD align="center"><%=option1.getDateFinal()%></TD>
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
					<TD align="center"><%=titreE.getNomVendeur()%></TD>
					<TD align="center"><%=titreE.getPrix()%></TD>
					<TD align="center"><%=titreE.getPrixActuel()%></TD>
					<TD align="center"><%=titreE.getDateCreation()%></TD>
					<TD align="center"><%=titreE.getDateFin()%></TD>
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
			<TABLE id="tab_societes" CELLPADDING=0 CELLSPACING=0>
				<thead>

					<TR>
						<TD align="center">Type</TD>
						<TD align="center">Entreprise</TD>
						<TD align="center">Vendeur</TD>
						<TD align="center">Prix Initial</TD>
						<TD align="center">Prime Initial</TD>
						<TD align="center">Prime Courant</TD>
						<TD align="center">Strike</TD>
						<TD align="center">Date Initial</TD>
						<TD align="center">Date Final</TD>
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
					<TD align="center"><%=optionAEC.getNomVendeur()%></TD>
					<TD align="center"><%=optionAEC.getPrixInitial()%></TD>
					<TD align="center"><%=optionAEC.getPrimeInitial()%></TD>
					<TD align="center"><%=optionAEC.getPrime()%></TD>
					<TD align="center"><%=optionAEC.getStrike()%></TD>
					<TD align="center"><%=optionAEC.getDateInitial()%></TD>
					<TD align="center"><%=optionAEC.getDateFinal()%></TD>
					<TD align="center"><form action="/PrivateMarket/OptionEnchere"
							method="Post">
							<input type="hidden" name="idTitre"
								value="<%=optionAEC.getIdSOI()%>"> <INPUT type="submit"
								name="Envoyer" value="Consulter"></INPUT>
						</form></TD>

				</TR>

				<%
					}
				%>

			</TABLE>
			<h1>Achat: Enchere Put</h1>
			<TABLE id="tab_societes" CELLPADDING=0 CELLSPACING=0>
				<thead>

					<TR>
						<TD align="center">Type</TD>
						<TD align="center">Entreprise</TD>
						<TD align="center">Vendeur</TD>
						<TD align="center">Prix Initial</TD>
						<TD align="center">Prime Initial</TD>
						<TD align="center">Prime Courant</TD>
						<TD align="center">Strike</TD>
						<TD align="center">Date Initial</TD>
						<TD align="center">Date Final</TD>
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
					<TD align="center"><%=optionAEP.getNomVendeur()%></TD>
					<TD align="center"><%=optionAEP.getPrixInitial()%></TD>
					<TD align="center"><%=optionAEP.getPrimeInitial()%></TD>
					<TD align="center"><%=optionAEP.getPrime()%></TD>
					<TD align="center"><%=optionAEP.getStrike()%></TD>
					<TD align="center"><%=optionAEP.getDateInitial()%></TD>
					<TD align="center"><%=optionAEP.getDateFinal()%></TD>
					<TD align="center"><form action="/PrivateMarket/OptionEnchere"
							method="Post">
							<input type="hidden" name="idTitre"
								value="<%=optionAEP.getIdSOI()%>"> <INPUT type="submit"
								name="Envoyer" value="Consulter"></INPUT>
						</form></TD>

				</TR>

				<%
					}
				%>

			</TABLE>





		</div>
	</div>
	<div id="bg_body_foot"></div>
	<div id="foot_body">
		<div class="copyright">
			Site web réalisé en J2EE par <b>Jacques CHAN, Vincent RATNAM,
				Thomas Souffir, Pierre-Etienne Crepy</b><br /> Dans le cadre d'un
			projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
	</div>
</body>
</html>