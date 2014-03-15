<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.sessionUtilisateur.statut == 1}">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pages.css"media="screen" />
</head>
<body id="investisseur">
	<div id="top">
		<div id="topBody">
			<div class="logo">
				<img src="images/logo2.png" alt="privatemarket" />
			</div>
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
			<img src="images/text/investisseur.png" alt="" class="center" />
			<br /> <br />
			<%-- Vérification de la présence d'un objet utilisateur en session --%>
					<p class="center">Vous êtes une <b>Société</b> connecté avec l'adresse : <b>${sessionScope.sessionUtilisateur.email}</b></p>
				<br /><br /><center>
					<a href="" ><img src="images/icon/liste.png" alt="societes" /></a>
					<a href="" ><img src="images/icon/contrats.png" alt="societes" /></a>
					<a href="" ><img src="images/icon/compte.png" alt="compte" /></a>
					</center>
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