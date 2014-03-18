<%@page import="java.util.ArrayList"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.objet.Titre"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.objet.Option"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${sessionScope.sessionUtilisateur.statut >= 0}">
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
				<center>
					<img src="images/text/investisseur.png" alt="" />
				</center>
				<br /> <br />


				<div class="tr-left">
					<h1 class="center">ACHATS</h1>
					<br />

					<h2>Action(s) Achetés (Immediat & Enchere)</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>
							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Nom de l'Entreprise</TD>
								<TD align="center">Prix</TD>
								<TD align="center">Date de Transaction</TD>
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
							<TD align="center"><%=titre.getDateFin()%></TD>
							<TD align="center">
								<%
									if (titre.getStatut() == 0) {
								%>
								<form action="./TitreImmediat" method="Post">
									<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
									<input type="hidden" name="type" value="vente"> <INPUT
										type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form> <%
 	} else {
 %>
								<form action="./TitreEnchere" method="Post">
									<input type="hidden" name="idTitre" value="<%=titre.getId()%>">
									<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form> <%
 	}
 %>
							</TD>


						</TR>
						<%
							}
						%>

					</TABLE>
					<h2>Enchere Titre en cours</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>
							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Nom de l'Entreprise</TD>
								<TD align="center">Prix Actuel</TD>
								<TD align="center">Date de Fin</TD>
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
							<TD align="center">ENCHERE</TD>
							<TD align="center"><%=titreE.getNomEntreprise()%></TD>
							<TD align="center"><%=titreE.getPrixActuel()%></TD>
							<TD align="center"><%=titreE.getDateFin()%></TD>
							<TD align="center">
								<form action="./TitreEnchere" method="Post">
									<input type="hidden" name="idTitre" value="<%=titreE.getId()%>">
									<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form>
							</TD>


						</TR>
						<%
							}
						%>

					</TABLE>
					<h2>Call(s) Acheté(s)</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prix(Strike)</TD>
								<TD align="center">Date</TD>
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
							<TD align="center"><%=option.getStrike()%></TD>
							<TD align="center"><%=option.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionImmediat"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=option.getIdSOI()%>"> <input type="hidden"
										name="type" value="vente"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>


					<h2>Put(s) Acheté(s)</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prix(Strike)</TD>
								<TD align="center">Date</TD>
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
							<TD align="center"><%=option1.getStrike()%></TD>
							<TD align="center"><%=option1.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionImmediat"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=option1.getIdSOI()%>"> <input type="hidden"
										name="type" value="vente"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>



					<h2>Enchere Call en cours & finis</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prix (Strike)</TD>
								<TD align="center">Date de Fin</TD>
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
							<TD align="center"><%=optionAEC.getStrike()%></TD>
							<TD align="center"><%=optionAEC.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionEnchere"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=optionAEC.getIdSOI()%>"> <INPUT
										type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>
					<h2>Enchere Put en cours & finis</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prix (Strike)</TD>
								<TD align="center">Date de Fin</TD>
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
							<TD align="center"><%=optionAEP.getStrike()%></TD>
							<TD align="center"><%=optionAEP.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionEnchere"
									method="Post">
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
					<h1 class="center">VENTES</h1>
					<br />
					<h2>Action(s) Vendu(s) (Immediat & Enchere)</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>
							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Nom de l'Entreprise</TD>
								<TD align="center">Prix</TD>
								<TD align="center">Date</TD>
								<TD align="center">Consulter</TD>


							</TR>
						</thead>
						<%
							Titre titreV = null;
								ArrayList<Titre> resultatV = (ArrayList<Titre>) session
										.getAttribute("_VENTE_TITRE");
								for (int i = 0; i < resultatV.size(); i++) {
									titreV = (Titre) resultatV.get(i);
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
									if (titreV.getStatut() == 0) {
								%>IMMEDIAT <%
									} else {
								%>ENCHERE <%
									}
								%>


							</TD>
							<TD align="center"><%=titreV.getNomEntreprise()%></TD>
							<TD align="center"><%=titreV.getPrix()%></TD>
							<TD align="center"><%=titreV.getDateFin()%></TD>
							<TD align="center">
								<form action="./TitreImmediat" method="Post">
									<input type="hidden" name="idTitre" value="<%=titreV.getId()%>">
									<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form>
							</TD>


						</TR>


						<%
							}
						%>
						<TR>
							<TD align="center"><INPUT type="submit" name="Envoyer"
								value="Action non Vendus"></INPUT></TD>
							<TD align="center"><INPUT type="submit" name="Envoyer"
								value="Action Vente Immédiat en cours"></INPUT></TD>
						</TR>
					</TABLE>
					<h2>Vente Titre Enchere en cours</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>
							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Nom de l'Entreprise</TD>
								<TD align="center">Prix Actuel</TD>
								<TD align="center">Date de Fin</TD>
								<TD align="center">Consulter</TD>

							</TR>
						</thead>
						<%
							Titre titreEV = null;
								ArrayList<Titre> resultatTEV = (ArrayList<Titre>) session
										.getAttribute("_VENTE_ENCHERE_TITRE");
								for (int i = 0; i < resultatTEV.size(); i++) {
									titreEV = (Titre) resultatTEV.get(i);

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
							<TD align="center">ENCHERE</TD>
							<TD align="center"><%=titreEV.getNomEntreprise()%></TD>
							<TD align="center"><%=titreEV.getPrixActuel()%></TD>
							<TD align="center"><%=titreEV.getDateFin()%></TD>
							<TD align="center">
								<form action="./TitreEnchere" method="Post">
									<input type="hidden" name="idTitre"
										value="<%=titreEV.getId()%>"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form>
							</TD>


						</TR>
						<%
							}
						%>

					</TABLE>


					<h2>Call(s) Vendu(s)</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prix</TD>
								<TD align="center">Date</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option optionV = null;
								ArrayList<Option> AchatCallImmediatV = (ArrayList<Option>) session
										.getAttribute("_VENTE_OPTION_CALL");
								for (int i = 0; i < AchatCallImmediatV.size(); i++) {
									optionV = (Option) AchatCallImmediatV.get(i);
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
							<TD align="center"><%=optionV.getNomEntreprise()%></TD>
							<TD align="center"><%=optionV.getPrixInitial()%></TD>
							<TD align="center"><%=optionV.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionImmediat"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=optionV.getIdSOI()%>"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>
					<h2>Put(s) Vendu(s)</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Date Transaction</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option option1V = null;
								ArrayList<Option> AchatPUTImmediatV = (ArrayList<Option>) session
										.getAttribute("_VENTE_OPTION_PUT");
								for (int i = 0; i < AchatPUTImmediatV.size(); i++) {
									option1V = (Option) AchatPUTImmediatV.get(i);
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
							<TD align="center"><%=option1V.getNomEntreprise()%></TD>

							<TD align="center"><%=option1V.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionImmediat"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=option1V.getIdSOI()%>"> <INPUT type="submit"
										name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>

					</TABLE>


					<h2>Enchere Call en cours & finis</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prime Actuel</TD>
								<TD align="center">Date de Fin</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option optionAECV = null;
								ArrayList<Option> resultatAECV = (ArrayList<Option>) session
										.getAttribute("_VENTE_ENCHERE_CALL");
								for (int i = 0; i < resultatAECV.size(); i++) {
									optionAECV = (Option) resultatAECV.get(i);

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
							<TD align="center"><%=optionAECV.getNomEntreprise()%></TD>
							<TD align="center"><%=optionAECV.getPrime()%></TD>
							<TD align="center"><%=optionAECV.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionEnchere"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=optionAECV.getIdSOI()%>"> <INPUT
										type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>
						<TR>
							<TD><INPUT type="submit" name="Envoyer"
								value="Enchere CALL non Vendus"></INPUT></TD>
						</TR>
					</TABLE>
					<h2>Enchere Put en cours & finis</h2>
					<table width="100%" CELLPADDING=0 CELLSPACING=0 align="center"
						class="tr1">
						<thead>

							<TR>
								<TD align="center">Type</TD>
								<TD align="center">Entreprise</TD>
								<TD align="center">Prime Actuel</TD>
								<TD align="center">Date de Final</TD>
								<TD align="center">Consulter</TD>
							</TR>


						</thead>
						<%
							Option optionAEPV = null;
								ArrayList<Option> resultatAEPV = (ArrayList<Option>) session
										.getAttribute("_VENTE_ENCHERE_PUT");
								for (int i = 0; i < resultatAEPV.size(); i++) {
									optionAEPV = (Option) resultatAEPV.get(i);

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
							<TD align="center"><%=optionAEPV.getNomEntreprise()%></TD>
							<TD align="center"><%=optionAEPV.getPrime()%></TD>
							<TD align="center"><%=optionAEPV.getDateFinal()%></TD>
							<TD align="center"><form action="./OptionEnchere"
									method="Post">
									<input type="hidden" name="idTitre"
										value="<%=optionAEPV.getIdSOI()%>"> <INPUT
										type="submit" name="Envoyer" value="Consulter"></INPUT>
								</form></TD>

						</TR>

						<%
							}
						%>
						<TR>
							<TD><INPUT type="submit" name="Envoyer"
								value="Enchere PUT non Vendus"></INPUT></TD>
						</TR>

					</TABLE>





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
</c:if>






