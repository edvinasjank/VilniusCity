
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta charset="UTF-8">
	<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/css/style.css" />" rel="stylesheet">
	<script src="<c:url value="/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
</head>
<body>
<div class = "container">
	<h2>Vilniaus Miestas</h2>
	<div align="right">
		<a class="btn btn-info" href="<c:url value="/create" />">Sukurti</a>
	</div>
	<form method="get" action="find" id="form">
	    <div>
	    	<input type="text" value="${street}" id="street" name="street"/>
	    	
	    	<button class="btn btn-default" type="submit">Ieskoti</button>
	    </div>
	</form>
	<div >
		<c:choose>
    		<c:when test="${not empty persons}">
    			
				<table class="table table-striped">
					<thead>
			            <tr>
			                <th>#</th>
			                <th>GIMIMO METAI</th>
			                <th>GIMIMO VALSTYBE</th>
			                <th>LYTIS</th>
			                <th>SEIMOS PADETIS</th>
			                <th>VAIKAI</th>
			                <th>GATVE</th>
			            </tr>
					</thead>
		            <tbody>
		            	<c:forEach items="${persons}" var="person">
			            	<tr>
			           			<td></td>
					            <td>${person.birthYear}</td>
					            <td>${person.birthCountry}</td>
					            <td>${person.gender}</td>
					            <td>${person.familyPosition}</td>
								<td>${person.kids}</td>
								<td>${person.street}</td>
								<td>
									<a href="<c:url value="/edit/${person.id}"/>">
										<span class="glyphicon glyphicon-edit"></span>
									</a>
								</td>
								<td>
									<a href="<c:url value="/delete/${person.id}"/>">
										<span class="glyphicon glyphicon-trash"></span>
									</a>
								</td>	
						    </tr>
						</c:forEach>
		            </tbody>         
		                            
				</table>
			</c:when>                    
	      	<c:otherwise>
		    	<br>  </br>           
		          <div class="alert alert-info">
		              No people found matching your search criteria
		          </div>
	     	</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>
