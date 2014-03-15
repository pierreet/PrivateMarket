<%@page import="java.lang.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.dauphine.mido.as.projet.beans.Compte"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:if test="${sessionScope.sessionUtilisateur.statut == 0}">
<html lang="fr"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">
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
				<div class="center"><img src="images/text/register.png" alt="" /></div><br/><br/>
				<h:form>
				<table id="tab_register">	
					<tr>
						<td>Nom <span class="asterisque">*</span></td>
						<td>Prénom <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td>
							<h:inputText id="nom" value="#{inscrireBean.utilisateur.nom}"   label="Nom" />
        					<h:message id="nomMessage" for="nom" errorClass="asterisque" />
        				</td>
						<td>
							<h:inputText id="prenom" value="#{inscrireBean.utilisateur.prenom}"   label="Prenom"/>
        					<h:message id="prenomMessage" for="prenom" errorClass="asterisque" />
						</td>
					</tr>
					<tr class="sep">
						<td colspan="2">Email <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td colspan="2">
							<h:inputText id="email" value="#{inscrireBean.utilisateur.email}"  class="register size2" label="Email" >
								<f:validator binding="#{verificationEmail}" />
        					</h:inputText>
        					<h:message id="emailMessage" for="email" errorClass="asterisque" />
        				</td>
					</tr>
					<tr class="sep">
						<td>Pays <span class="asterisque">*</span></td>
						<td>Code Postal <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td><h:inputText id="pays" value="#{inscrireBean.utilisateur.pays}"   label="Pays"/>
        		<h:message id="paysMessage" for="pays" errorClass="asterisque" /></td>
						<td><h:inputText id="cp" value="#{inscrireBean.utilisateur.codePostale}"   label="Code Postal"/>
        		<h:message id="cpMessage" for="cp" errorClass="asterisque" /></td>
					</tr>
					<tr class="sep">
						<td>Mot de passe <span class="asterisque">*</span></td>
						<td>Confirmation mot de passe <span class="asterisque">*</span></td>
					</tr>
					<tr>
						<td><h:inputSecret id="mdp" value="#{inscrireBean.utilisateur.password}" binding="#{DeuxiemeMotDePasse}"  label="Mot de passe" />
        		<h:message id="mdpMessage" for="mdp" errorClass="asterisque" /></td>
						<td><h:inputSecret id="confirmation" value="#{inscrireBean.utilisateur.password}"   label="Confirmation mot de passe">
        			<f:attribute name="DeuxiemeMotDePasse" value="#{DeuxiemeMotDePasse}"/>
        			<f:validator validatorId="confirmationMotDePasseValidator"/>
        		</h:inputSecret>
        		<h:message id="confirmationMessage" for="confirmation" errorClass="asterisque" /></td>
					</tr>
				</table>
				#{inscrireBean.utilisateur.setStatut(2)}
				<h:inputHidden value="#{inscrireBean.utilisateur.statut}"  />
				<div class="loggin"><h:commandButton value="Valider" action="#{inscrireBean.inscrire}" styleClass="asterisque" image="images/menu/inscription.png"/></div>
				</h:form>
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