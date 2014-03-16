<!DOCTYPE html>
<html lang="fr"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">
    <h:head>
        <meta charset="utf-8" />
        <title>Investisseur</title>
   
        <link rel='stylesheet' media='screen' type='text/css' title='Design' href='./css/pages.css' />
    </h:head>
    <body id="register">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="./images/logo2.png" alt="privatemarket"/></div>
		</div>
	</div>
		<div id="content">
		<div id="bg_body_top"></div>
		<div id="bg_body_center">
		
			<div id="bg_body"><br/><br/>
			
		<%
			String resultat = (String) session.getAttribute("TRANSACTION");
			if (resultat.equals("OK")) {
		%>
				<table style="width:45%; text-align:center; margin:auto;" class="tableaux3">
				<tr><td width="10%"><img src="./images/icon/ok.png" alt="error" /></td><td align="center">
				Votre enchère à bien été pris en compte.
				</td></tr></table>
				<br/>	<br/>
		<%
			}
			if (resultat.equals("KO")){
		%>
				<table style="width:45%; text-align:center; margin:auto;" class="tableaux2">
				<tr><td width="10%"><img src="./images/icon/err.png" alt="error" /></td><td align="center">
				Erreur lors de votre enchère.<br/><br/>
				Si ce problème persiste, contactez l'administrateur du serveur ou le fournisseur de services Internet.
				</td></tr></table>
				<br/>	<br/>
		<% } %>


			
			
			

				
				<a class="center" href="./pages/indexContrats.html">Retour aux contrats</a>
			</div>
		</div>
		<div id="bg_body_foot"></div>
	</div>
	<div id="foot_body">
		<div class="copyright">
		Site web réalisé en J2EE par <b>Jacques CHAN, Vincent RATNAM, Thomas SOUFFIR, Pierre-Etienne CREPY</b><br/>
		Dans le cadre d'un projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
	</div>
</body>
</html>

