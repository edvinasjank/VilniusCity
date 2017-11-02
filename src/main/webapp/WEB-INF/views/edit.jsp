<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class = "container">
	<h2>Vilniaus Miestas</h2>
	<br></br>
	<div>
		<form:form method="post" modelAttribute="person">
			<table class="table table-striped">
					
	            <form:input type="hidden" path="id" value="${selectedPerson.id}"/> 
	       
	            <tr>
	                <td>GIMIMO METAI</td>
	                <td> <form:input path="birthYear" value="${selectedPerson.birthYear}"/> 
	                	<form:errors path="birthYear"/>
	                </td>
	            </tr>
	            <tr>
	                <td>GIMIMO VALSTYBE</td>
	                <td> <form:input type="text" path="birthCountry" value="${selectedPerson.birthCountry}"  /> </td>
	            </tr>
	            <tr>   
	                <td>LYTIS</td>
	                <td> <form:input type="text" path="gender" value="${selectedPerson.gender}"  /> </td>
	            </tr>    
	            <tr>
	                <td>SEIMOS PADETIS</td>
	                <td> <form:input type="text" path="familyPosition" value="${selectedPerson.familyPosition}"  /> </td>
	            </tr>    
	            <tr>    
	                <td>VAIKAI</td>
	                <td> <form:input type="text" path="kids" value="${selectedPerson.kids}"  /> </td>
	            </tr>    
	            <tr>    
	                <td>GATVE</td>
	                <td> <form:input type="text" path="street" value="${selectedPerson.street}"  /> </td>
	            </tr>
			   
			</table>
				<button type="submit" class="btn btn-primary">
       				 Update
   				</button>
		</form:form>
				
		
	</div>
</div>
</body>
</html>