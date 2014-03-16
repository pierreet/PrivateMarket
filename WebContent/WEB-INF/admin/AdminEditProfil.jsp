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
													<% 
				String message = request.getParameter("error");
				if(message != null) {
				if(message.equals("email")) {
				%>
				<table width="45%" align="center" class="tableaux2">
				<tr><td width="10%"><img src="images/icon/err.png" alt="error" /></td><td align="center">Erreur : L'email est dans un format incorrecte.</td></tr></table>
				<br/>	<br/>
				<% } } %>
				<FORM name="form" method="post" action="admin">
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
						<td colspan="2"><input type="text" value="<%=utilisateur.getEmail()%>" class="register size2" name="email" /><br/>

						<span class="erreur">${form.erreurs['email']}</span></td>
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
							<input type="hidden" value="<%=utilisateur.getIdUtilisateur()%>"  name="id" />
							<input type="hidden" value="<%=id%>"  name="id2" />
							<SELECT class="register size2" name="statut">
								<OPTION VALUE="<%=utilisateur.getStatut()%>">Actuellement : <%
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
				</FORM>
			
				<div class="loggin"><input class="send" type="submit" /><a  onclick="form.submit()"><img src="images/menu/envoyer.jpg" alt="send"/></a></div>
					<br/><br/><a href="./utilisateurs" title="logged" class="center">Retour à la liste des utilisateurs</a>
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