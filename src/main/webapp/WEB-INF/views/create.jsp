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
	<div class="col-md-6" >
		<form:form method="post" modelAttribute="person">
			<table class="table table-striped">
					
	            <form:input type="hidden" path="id"/> 
	       
	            <tr>
	                <td>GIMIMO METAI*</td>
	                <td> <form:input path="birthYear"/> 
	                	<form:errors path="birthYear"/>
	                </td>
	            </tr>
	            <tr>
	                <td>GIMIMO VALSTYBE</td>
	                <td> <form:input type="text" path="birthCountry" /> </td>
	            </tr>
	            <tr>   
	                <td>LYTIS*</td>
	                <td> <form:input type="text" path="gender" /> </td>
	            </tr>    
	            <tr>
	                <td>SEIMOS PADETIS</td>
	                <td> <form:input type="text" path="familyPosition" /> </td>
	            </tr>    
	            <tr>    
	                <td>VAIKAI</td>
	                <td> <form:input type="text" path="kids"/> </td>
	            </tr>    
	            <tr>    
	                <td>GATVE*</td>
	                <td> <form:input type="text" path="street"/> </td>
	            </tr>
			   
			</table>
				<button type="submit" class="btn btn-primary">
       				 Sukurti
   				</button>
		</form:form>
				
		
	</div>
</div>
</body>
</html>