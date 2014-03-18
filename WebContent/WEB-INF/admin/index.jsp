<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Vérification de la présence d'un objet utilisateur en session --%>
<c:if test="${sessionScope.sessionUtilisateur.statut == 0}">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css"media="screen" />
</head>
<body id="admin">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="images/logo2.png" alt="privatemarket"/></div>
			<div class="menu">
				<a href="./pages/listeEntreprises.xhtml" ><img src="images/menu/liste.png" alt="liste" /></a>
				<a href="./deconnexion" ><img src="images/menu/logout.jpg" alt="logout" /></a></div>
		</div>
	</div>
	<div id="content">
	<div id="bg_body_top"></div>
	<div id="bg_body_center">
		<div id="bg_body">
			<img src="images/text/admin.png" alt="" class="center" />
			<br /> <br />
					<p class="center">Vous êtes un <b>Administrateur</b> connecté avec l'adresse : <b>${sessionScope.sessionUtilisateur.email}</b></p>
				
				<br /><br /><div class="center">
					<a href="./pages/listeEntreprises.xhtml"><img src="images/icon/societes.png" alt="societes" /></a>
					<a href="./utilisateurs"><img src="images/icon/utilisateur.png" alt="societes" /></a>
					<a href="pages/indexContrats.xhtml"><img	src="images/icon/contrats.png" alt="societes" /></a>
						<a href="./ListeTransaction" ><img src="images/icon/transactions.png" alt="transaction" /></a>
				<a href="./MonCompte" ><img src="images/icon/compte.png" alt="compte" /></a>
						</div>
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
	</div>
</body>
</html>
</c:if>