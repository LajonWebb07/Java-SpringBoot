<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<style>
	body{
		display:flex;
		justify-content:space-around;
	}
	.container {
		display:inline-block;
		vertical-align:top;
		width:450px;
		padding:100px;
	}
	.top{
	display:inline-block;
	text-align: left;
	padding: 50px;
	}
	.bottom{
	display:inline-block;
	text-align: center;
	padding: 20px;
	}
	button{
		background-color: rgb(127, 255, 212);
		border-radius:5px;
		padding: 10px 15px;
		border-color:black;
		color:rgb(139,0,139);
		margin: 30px;
	}
</style>
</head>
<body>
	<div class="container">
	 	<h1>Edit Your Edit!</h1>
	    
	    <p><form:errors path="show.*"/></p>
	    
	    <form:form method="POST" action="/edit/show/${show.id }" modelAttribute="show">
	     <p>
	            <form:label path="title">Show</form:label>
	            <form:input type="text" path="title"/>
	        </p>
	        <p>
	            <form:label path="network">Network</form:label>
	            <form:input type="text" path="network"/>
	        </p>
	        <%-- <p>
	            <form:label path="">Ratings</form:label>
   	        	 <form:select path = "ratings">
                     	<c:forEach items="${ratings }" var="rating">
                       <form:option value="${rating }" label="${rating}" />
                       </c:forEach>
                  </form:select>  
	        </p> --%>
	       
	        <button type="edit">Edit</button>
	    </form:form>
	    <a href="/delete/show/${show.id }">Delete</a>
	    <div class="bottom">
	   <a href="/rate/show/${show.id }">Rate!</a>
    </div>
    </div>
</body>
</html>