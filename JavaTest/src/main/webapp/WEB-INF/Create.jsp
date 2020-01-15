<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Page</title>
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
	}
</style>
</head>
<body>
	<div class="container">
	 	<h1>Create a Show!</h1>
	    
	    <p><form:errors path="show.*"/></p>
	    
	    <form:form method="POST" action="/create/show" modelAttribute="show">
	     	<p>
	            <form:label path="title">Name:</form:label>
	            <form:input type="text" path="title"/>
	        </p>
	        <p>
	            <form:label path="network">Network:</form:label>
	            <form:input type="text" path="network"/>
	        </p>
	       
	        <button type="create">Create</button>
	    </form:form>
    </div>
    
</body>
</html>