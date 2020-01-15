<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Task</title>
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
	    <h1>Show: ${show.title}</h1>
		<p>Network: ${show.network}</p>
		 <a href="/home">Go Back</a>
	     <a href="/edit/show/${show.id }">Edit</a>
    </div>
    
</body>
</html>