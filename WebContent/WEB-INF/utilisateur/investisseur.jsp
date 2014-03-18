<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.sessionUtilisateur.statut == 2}">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css"media="screen" />
</head>
<body id="investisseur">
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
				<div class="center"><img src="images/text/investisseur.png" alt="" /></div><br/><br/>
				<p class="center">Vous êtes un <b>Investisseur</b> connecté avec l'adresse : <b>${sessionScope.sessionUtilisateur.email}</b></p>
				<div class="center">
				<a href="./pages/listeEntreprises.xhtml" ><img src="images/icon/liste.png" alt="societes" /></a>
				<a href="pages/indexContrats.xhtml" ><img src="images/icon/contrats.png" alt="societes" /></a>
				<a href="./ListeTransaction" ><img src="images/icon/transactions.png" alt="transaction" /></a>
				<a href="./MonCompte" ><img src="images/icon/compte.png" alt="compte" /></a>
				</div>
				<br/><br/>
				
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