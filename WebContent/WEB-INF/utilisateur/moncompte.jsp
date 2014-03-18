<%@page import="java.lang.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.dauphine.mido.as.privatemarket.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css" media="screen"/>
</head>
<body id="register">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="images/logo2.png" alt="privatemarket"/></div>
			<div class="menu">
				<a href="./pages/listeEntreprises.xhtml"><img src="images/menu/liste.png" alt="liste" /></a>
				<a href="./deconnexion"><img src="images/menu/logout.jpg" alt="logout" /></a>
			</div>
		</div>
	</div>
		<div id="content">
		<div id="bg_body_top"></div>
		<div id="bg_body_center">
			<div id="bg_body">
			<div class="center"><h1 class="title">Modifier le profil de ${sessionScope.sessionUtilisateur.nom} ${sessionScope.sessionUtilisateur.prenom}</h1></div><br/><br/>
				<% 
				String message = request.getParameter("page");
				if(message != null) {
				if(message.equals("save")) {
				%>
				<table style="width:45%; text-align:center; margin:auto;" class="tableaux3">
				<tr><td width="10%"><img src="images/icon/ok.png" alt="error" /></td><td align="center">Votre profil a bien été mise à jour.</td></tr></table>
				<br/>	<br/>
				<%}} %>
				<FORM name="register" method="post" action="./MonCompte">
				<table id="tab_register">	
					<tr>
						<td>Nom <span class="asterisque"></span></td>
						<td>Prénom <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td><input type="text" value="${sessionScope.sessionUtilisateur.nom}" class="register" name="nom" /></td>
						<td><input type="text" value="${sessionScope.sessionUtilisateur.prenom}" class="register" name="prenom" /></td>
					</tr>
					<tr class="sep">
						<td colspan="2">Email <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" value="${sessionScope.sessionUtilisateur.email}" class="register size2" name="email" /><br/> <span class="erreur">${form.erreurs['email']}</span></td>
					</tr>
					<tr class="sep">
						<td>Pays <span class="asterisque"></span></td>
						<td>Code Postal <span class="asterisque"></span></td>
					</tr>
					<tr>
						<td><input type="text" value="${sessionScope.sessionUtilisateur.pays}"  class="register" name="pays" /></td>
						<td><input type="text" value="${sessionScope.sessionUtilisateur.codePostale}" class="register" name="code_postale" /></td>
					</tr>
					<tr class="sep">
						<td>Mot de passe <span class="asterisque">*</span></td>
						<td>Confirmation mot de passe <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td><input type="password" class="register" name="motdepasse" /><br/><span class="erreur">${form.erreurs['motdepasse']}</span></td>
						<td><input type="password" class="register" name="mdp2" /><br/><span class="erreur">${form.erreurs['motdepasse']}</span></td>
					</tr>
				</table>
				     <p class="${empty form.erreurs ? 'succes' : 'erreur'} center">${form.erreurs['general']}<br/><b>${form.resultat}</b></p>
				</FORM>
				<div class="loggin"><input class="send" type="submit" /><a  onclick="register.submit()"><img src="images/menu/envoyer.jpg" alt="send"/></a></div>
				
					<br/><br/><a class="center" href="./logged">Retour à la page principal</a>
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
