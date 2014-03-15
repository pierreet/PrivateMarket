<%@page import="java.util.ArrayList"%>
<%@page import="fr.dauphine.mido.as.privatemarket.contrats.titre.TitreDemandeEnchere"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reponse Demande Enchere</title>
</head>
<body>
	<CENTER>


		<%
			String resultat = (String) session.getAttribute("TRANSACTION");
			if (resultat.equals("OK")) {
		%>
		<h1>OK</h1>
		<%
			}
			if (resultat.equals("KO")){
		%>
			<h1> KO</h1>
		<% } %>




	</CENTER>
</body>
</html>