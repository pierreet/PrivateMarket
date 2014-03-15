<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.dauphine.mido.as.projet.beans.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:if test="${sessionScope.sessionUtilisateur.statut == 0}">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css" media="screen"/>
</head>
<body id="societes">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="images/logo2.png" alt="privatemarket"/></div>
			<div class="menu">
				<a href="#"><img src="images/menu/liste.png" alt="liste" /></a>
				<a href="./deconnexion"><img src="images/menu/logout.jpg" alt="logout" /></a>
			</div>
		</div>
	</div>
		<div id="content">
		<div id="bg_body_top"></div>
		<div id="bg_body_center">
			<div id="bg_body">
				<img src="images/icon/utilisateur.png" alt="" class="center"/><br/><br/>

				
					<a href="./admin?&page=newProfil"><div class="button">Ajouter un nouvel utilisateur</div></a><br/><br/>
				<% 
				String message = request.getParameter("message");
				if(message != null) {
				if(message.equals("ok")) {
				%>
				<table width="45%" align="center" class="tableaux3">
				<tr><td width="10%"><img src="images/icon/ok.png" alt="error" /></td><td align="center">L'activation du membre à bien été effectué.</td></tr></table>
				<br/>	<br/>
				<%}} %>
				<TABLE id="tab_societes" CELLPADDING="0" CELLSPACING="0">
				<thead>
					<TR>
						<TD >id</TD>
						<TD >Nom</TD>
						<TD >Prénom</TD>
						<TD >Email</TD>
						<TD >Pays</TD>
						<TD >Code Postal</TD>
						<TD >Statut</TD>
						<TD >Compte validé</TD>
						<TD >Opération</TD>
					</TR>
				</thead>
				<% Compte utilisateur = null;
					ArrayList<Compte> resultat = (ArrayList<Compte>) session.getAttribute("_LISTE_OPERATIONS_UTILISATEURS");
					for (int i = 0; i < resultat.size(); i++) {
						utilisateur = (Compte) resultat.get(i); %>
				<% if (i % 2 == 0) { %>
				<TR class="bl">
				<% } %>
				<% if (i % 2 != 0) { %>
				<TR class="wl">
				<% } %>
					<TD ><%=utilisateur.getIdCompte()%></TD>
					<TD ><%=utilisateur.getNom()%></TD>
					<TD ><%=utilisateur.getPrenom()%></TD>
					<TD ><%=utilisateur.getEmail()%></TD>
					<TD ><%=utilisateur.getPays()%></TD>
					<TD ><%=utilisateur.getCodePostale()%></TD>
					<TD ><%
					if(utilisateur.getStatut() == 0) 
						{ %>Administrateur<% } 
					else if(utilisateur.getStatut() == 1 ) 
						{ %>Société<% }
					else 
						{ %>Investisseur <% } %> 
					</TD>
					
					<TD >
					
					<%
					if(utilisateur.getStatut() == 2) { 
					 if(utilisateur.getValidationInvestisseur() == 0) { %> 
					 <a href="./AdminActivation?&id=<%=utilisateur.getIdCompte()%>" title="activation">Activation</a>
					 <%
					 
					 } else { %> <%=utilisateur.getValidationInvestisseur()%> <% } 
					} else { %> N/A <% } %>
					 
					 </TD>
					<TD ><a href="./admin?&page=editProfil&id=<%=i %>">Consulter</a></TD>
				</TR>				
				<%	} %>
			</TABLE>
			<br/><br/><a href="./logged" title="logged" class="center">Retour sur la page d'administration</a>

				</div>
		</div>
		<div id="bg_body_foot"></div>
	</div>
	<div id="foot_body">
		<div class="copyright">
		Site web réalisé en J2EE par <b>Jacques CHAN, Vincent RATNAM, Thomas Souffir, Pierre-Etienne Crepy</b><br/>
		Dans le cadre d'un projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
	</div>
	</div>
</body>
</html>
</c:if>