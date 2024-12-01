<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
</head>
<body>
	<h1>Liste Des Employés</h1>
	<br>

	<h1>Département:${d.nom}</h1>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nom</td>
			<td>Fonction</td>
			<td></td>
		</tr>



		<c:forEach items="${lemp }" var="emp">


			<tr>
				<td>${emp.id}</td>
				<td>${emp.nom}</td>
				<td>${emp.fonction }</td>
		</c:forEach>
		</tr>
	</table>


	<br>
	<a href="${cxt}/home">Liste des départements </a>
	<br>
	<sec:authorize access="hasRole('ADMIN')">
	
	<a href="${cxt}/ajoutEmploye">Ajouter un employe</a>
	</sec:authorize>





</body>
</html>