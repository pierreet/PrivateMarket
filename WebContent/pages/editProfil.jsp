<%@page import="java.lang.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.dauphine.mido.as.privatemarket.entities.*"%>
<!DOCTYPE html>
<html lang="fr"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">
    <h:head>
        <meta charset="utf-8" />
        <title>Inscription Investisseur</title>
   
        <link rel='stylesheet' media='screen' type='text/css' title='Design' href='../css/pages.css' />
    </h:head>
    <body id="register">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="../images/logo2.png" alt="privatemarket"/></div>
			<div class="menu">
				<a href="#"><img src="../images/menu/liste.png" alt="liste" /></a>
				<a href="./deconnexion"><img src="../images/menu/logout.jpg" alt="logout" /></a>
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
				<div class="center"><img src="../images/text/register.png" alt="" /></div><br/><br/>
				<h:form>
				<table id="tab_register">	
					<tr>
						<td>Nom <span class="asterisque">*</span></td>
						<td>Pr�nom <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td>
							<h:inputText id="nom" value="#{gererUtilisateurBean.utilisateur.setNom(}"   label="Nom" />
        					<h:message id="nomMessage" for="nom" errorClass="erreur" />
        				</td>
						<td>
							<h:inputText id="prenom" value="#{gererUtilisateurBean.utilisateur.prenom}"   label="Prenom"/>
        					<h:message id="prenomMessage" for="prenom" errorClass="erreur" />
						</td>
					</tr>
					<tr class="sep">
						<td colspan="2">Email <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td colspan="2">
							<h:inputText id="email" value="#{gererUtilisateurBean.utilisateur.email}"  class="register size2" label="Email" >
								<f:validator binding="#{verificationEmail}" />
        					</h:inputText>
        					<h:message id="emailMessage" for="email" errorClass="erreur" />
        				</td>
					</tr>
					<tr class="sep">
						<td>Pays <span class="asterisque">*</span></td>
						<td>Code Postal <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td><h:inputText id="pays" value="#{gererUtilisateurBean.utilisateur.pays}"   label="Pays"/>
        		<h:message id="paysMessage" for="pays" errorClass="erreur" /></td>
						<td><h:inputText id="cp" value="#{gererUtilisateurBean.utilisateur.codePostale}"   label="Code Postal"/>
        		<h:message id="cpMessage" for="cp" errorClass="erreur" /></td>
					</tr>
					<tr class="sep">
						<td>Mot de passe <span class="asterisque">*</span></td>
						<td>Confirmation mot de passe <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td><h:inputSecret id="mdp" value="#{gererUtilisateurBean.utilisateur.password}" binding="#{DeuxiemeMotDePasse}"  label="Mot de passe" />
        		<br/><h:message id="mdpMessage" for="mdp" errorClass="erreur" /></td>
						<td><h:inputSecret id="confirmation" value="#{gererUtilisateurBean.utilisateur.password}"   label="Confirmation mot de passe">
        			<f:attribute name="DeuxiemeMotDePasse" value="#{DeuxiemeMotDePasse}"/>
        			<f:validator validatorId="confirmationMotDePasseValidator"/>
        		</h:inputSecret>
        		<br/><h:message id="confirmationMessage" for="confirmation" errorClass="erreur" /></td>
					</tr>
				</table>
				#{gererUtilisateurBean.utilisateur.setStatut(2)}
				<h:inputHidden value="#{gererUtilisateurBean.utilisateur.statut}"  />
				<div class="loggin"><h:commandButton value="Valider" action="validinscription" styleClass="asterisque" image="../images/menu/inscription.png"/></div>
				</h:form>
			</div>
	
		<div id="bg_body_foot"></div>	</div>
	</div>
	<div id="foot_body">
		<div class="copyright">
		Site web réalisé en J2EE par <b>Jacques CHAN, Vincent RATNAM, Thomas SOUFFIR, Pierre-Etienne CREPY</b><br/>
		Dans le cadre d'un projet MASTER 2 MIAGE - IF <b>Paris Dauphine</b>.
		</div>
	</div>
</body>
</html>