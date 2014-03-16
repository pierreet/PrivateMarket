<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen"/>
</head>
<body id="accueil">
	<div id="top">
		<div id="topBody">
			<div class="logo"><img src="images/logo.png" alt="betuf"/></div>
			<div class="menu">
				<a title="Accueil" href="#" class="menu_accueil"></a>
				<a title="Consulter des données" href="./pages/inscription.xhtml" class="menu_consulter"></a>
				<a title="Contact" href="#" class="menu_contact"></a>
			</div>
		</div>
	</div>
	<div id="content">
	<div id="bg_body">
		<div id="right" style="min-height:230px;" >
        <form name="login" method="post" action="./connexion">
      
			<div class="espace"><img src="images/admin.png" alt="espace administrateur" /><br/>
			<div class="input">
			
			<input type="text" name="email" value="<c:if test="${empty utilisateur.email}">E-Mail</c:if><c:out value="${utilisateur.email}"/>" onclick="this.value='';"/></div><div class="sep"></div>
			 <span class="erreur">${form.erreurs['email']}</span>
			<div class="input"><input type="password" name="motdepasse" value="Mot de passe" onclick="this.value='';" /></div><div class="sep"></div>	
			<div class="loggin"><input class="send" type="submit" /><a  onclick="login.submit()"><img src="images/loggin.png" alt="send"/></a></div>
		            
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.erreurs['general']}<br/><b>${form.resultat}</b></p>
                </div>
 	</form>

		</div>
		</div>
	</div>
	<div id="foot_body">
		<div class="icon"><img src="images/icon.jpg" alt="icon" /></div>
		<div class="welcome">
			Bienvenue<br/>
			<span>Sur le site PrivateMarket, experts en placement des produits financier sur le marché secondaire </span>
			<p>
			Notre rôle est de simplifié au maximum les transactions entre les sociétés et les investisseurs.<br/>
			Grâce à PrivateMarket, il vous sera simple d’introduire votre société, d’investisseurs<br/>
			sur le marché secondaire (actions, stock-options).<br/><br/>

			Les transactions sont garanties et sécurisées, inscrivez vous pour profiter pleinement du site internet.
			</p>
		</div>
	</div>
</body>
</html>