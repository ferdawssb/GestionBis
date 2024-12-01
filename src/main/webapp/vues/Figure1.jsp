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


<sec:authorize   access="isAuthenticated()">
Bienvenu <sec:authentication  property="name"/>

(<a href="<c:url value="/logout" />" > Logout </a> )


</sec:authorize>





	<h1>Liste Des Départements</h1>
	<br>
	<br>


	<br>
	<br>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nom</td>
			<td></td>
			<td></td>
		</tr>



		<c:forEach items="${ldep}" var="dep">


			<tr>
				<td>${dep.id}</td>
				<td>${dep.nom }</td>
				<td><a href="${cxt}/projets/${dep.id}">Liste des projets</a></td>
				<td><a href="employes/dept/${dep.id}">Liste des employés</a></td>
		</c:forEach>
		</tr>
	</table>


	<br>
	<sec:authorize access="hasRole('ADMIN')">

		<a href="${cxt}/ajoutProjet">Ajouter un projet </a>

		<br>
		<a href="${cxt}/ajoutEmploye">Ajouter un employe</a>
	</sec:authorize>








</body>
</html>