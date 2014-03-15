<%@page import="java.util.ArrayList"%>
<%@page import="privatemarket.contrats.objet.Option"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="_COMPTE_COURANT"
	class="privatemarket.contrats.objet.Option" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css"
	media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Option Immediat</title>

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
					ArrayList<Option> resultat = (ArrayList<Option>) session
							.getAttribute("_LISTE_OPERATIONS");
					for (int i = 0; i < resultat.size(); i++) {
						option = (Option) resultat.get(i);
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
					<TD align="center"><form action="/PrivateMarket/OptionImmediat" method="Post">
							<input type="hidden" name="idTitre"
								value="<%=option.getIdSOI()%>"> <INPUT type="submit"
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
	</div>
	<div id="foot_body">
		<div class="copyright">
			Site web r�alis� en J2EE par <b>Jacques CHAN, Vincent RATNAM,
				Thomas Souffir, Pierre-Etienne Crepy</b><br /> Dans le cadre d'un
			projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
	</div>
</body>
</html>