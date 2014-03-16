<%@page import="java.lang.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.dauphine.mido.as.privatemarket.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:if test="${sessionScope.sessionUtilisateur.statut == 0}">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css" media="screen"/>
</head>
<body id="register">
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
			<% 
			Utilisateur utilisateur = null;
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Utilisateur> resultat = (ArrayList<Utilisateur>) session.getAttribute("_LISTE_OPERATIONS_UTILISATEURS");
			utilisateur = (Utilisateur) resultat.get(id);
			%>
			<div class="center"><h1 class="title">Modifier le profil de <%=utilisateur.getPrenom()%> <%=utilisateur.getNom()%></h1></div><br/><br/>
			
				<FORM name="register" method="post" action="http://google.fr">
				<table id="tab_register">	
					<tr>
						<td>Nom <span class="asterisque"></span></td>
						<td>Prénom <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td><input type="text" value="<%=utilisateur.getNom()%>" class="register" name="nom" /></td>
						<td><input type="text" value="<%=utilisateur.getPrenom()%>" class="register" name="prenom" /></td>
					</tr>
					<tr class="sep">
						<td colspan="2">Email <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" value="<%=utilisateur.getEmail()%>" class="register size2" name="email" /></td>
					</tr>
					<tr class="sep">
						<td>Pays <span class="asterisque"></span></td>
						<td>Code Postal <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td><input type="text" value="<%=utilisateur.getPays()%>"  class="register" name="pays" /></td>
						<td><input type="text" value="<%=utilisateur.getCodePostale()%>" class="register" name="code_postale" /></td>
					</tr>
					<tr class="sep">
						<td colspan="2">Statut <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td colspan="2"><div class="styled-select">
							<SELECT class="register size2" name="fonction">
								<OPTION VALUE="<%=utilisateur.getCodePostale()%>">Actuellement : <%
								if(utilisateur.getStatut() == 0) 
									{ %>Administrateur<% } 
								else if(utilisateur.getStatut() == 1 ) 
									{ %>Société<% }
								else 
									{ %>Investisseur <% } %> </OPTION>
								<OPTION VALUE="0">Administrateur</OPTION>
								<OPTION VALUE="1">Société</OPTION>
								<OPTION VALUE="2">Investisseur</OPTION>
							</SELECT></div></td>
					</tr>
					<tr class="sep">
						<td colspan="2">Membre de la société <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td colspan="2"><div class="styled-select">
							<SELECT class="register size2" name="fonction">
								<OPTION VALUE="<%=utilisateur.getCodePostale()%>">Actuellement : <%
								if(utilisateur.getStatut() == 0) 
									{ %>Administrateur<% } 
								else if(utilisateur.getStatut() == 1 ) 
									{ %>Société<% }
								else 
									{ %>Investisseur <% } %> </OPTION>
								<OPTION VALUE="0">Administrateur</OPTION>
								<OPTION VALUE="1">Société</OPTION>
								<OPTION VALUE="2">Investisseur</OPTION>
							</SELECT></div></td>
					</tr>
				</table>
				<div class="loggin"><input class="send" type="submit" /><a  onclick="register.submit()"><img src="images/menu/envoyer.jpg" alt="send"/></a></div>
			</div>
	
		<div id="bg_body_foot"></div>	</div>
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