<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:set var="cxt" value="${pageContext.request.contextPath}" />

</head>
<body>



	<h1>Ajouter un Employe</h1>
	<br>
	<br>


	<form:form method="POST" action="${cxt}/saveEmploye" modelAttribute="e">
		<table>
			<tr>
				<td><form:label path="nom">Nom et Prénom</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="fonction">Fonction</form:label></td>
				<td><form:input path="fonction" /></td>
			</tr>
			<td><form:label path="dep.id">Département</form:label></td>
			<td><form:select path="dep.id" items="${ldep}" itemValue="id"
					itemLabel="nom" /></td>
			<tr>
			</tr>
			<td><form:label path="p.id">Projet</form:label></td>
			<td><form:select path="p.id" items="${lp}" itemValue="id"
					itemLabel="titre" /></td>
			<tr>
				<td><input type="submit" value="Enregistrer" /></td>
			</tr>
		</table>
	</form:form>

	<a href="${cxt}/home">Liste des départements </a>



</body>
</html>