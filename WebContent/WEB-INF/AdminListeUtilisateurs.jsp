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
					<a href="test.php"><div class="button">Ajouter une nouvelle société</div></a><br/><br/>
				<TABLE id="tab_societes" CELLPADDING="0" CELLSPACING="0">
				<thead>
					<TR>
						<TD align="center">idUtilisateur</TD>
						<TD align="center">Nom</TD>
						<TD align="center">Prénom</TD>
						<TD align="center">Email</TD>
						<TD align="center">Pays</TD>
						<TD align="center">Code Postal</TD>
						<TD align="center">Statut</TD>
						<TD align="center">Compte validé</TD>
						<TD align="center">Opération</TD>
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
					<TD align="center"><%=utilisateur.getIdCompte()%></TD>
					<TD align="center"><%=utilisateur.getNom()%></TD>
					<TD align="center"><%=utilisateur.getPrenom()%></TD>
					<TD align="center"><%=utilisateur.getEmail()%></TD>
					<TD align="center"><%=utilisateur.getPays()%></TD>
					<TD align="center"><%=utilisateur.getCodePostale()%></TD>
					<TD align="center"><%
					if(utilisateur.getStatut() == 0) 
						{ %>Administrateur<% } 
					else if(utilisateur.getStatut() == 1 ) 
						{ %>Société<% }
					else 
						{ %>Investisseur <% } %> 
					</TD>
					
					<TD align="center">
					
					<%
					 if(utilisateur.getValidationInvestisseur() == 0) { %> 
					 <a href="./AdminActivation?&id=<%=utilisateur.getIdCompte()%>" title="activation">Activation</a>
					 <%
					 
					 } else { %> <%=utilisateur.getValidationInvestisseur()%> <%} %> </TD>
					<TD align="center"><form action="./editProfil?&id=<%=i %>" method="Post">
							<INPUT type="submit" name="Envoyer" value="Consulter"></INPUT>
						</form></TD>
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