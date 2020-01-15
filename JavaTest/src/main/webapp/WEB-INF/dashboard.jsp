<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
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
	<div class="top">
	<a href="/logout">Log Out</a>
	</div>
	<div class="mid">
	 	  <table>
        <thead>
            <tr>
                <th>Show</th>
                <th>Network</th>
                <th>Avg Rating</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${shows }" var="item">
	            <tr>
	                <td><a href="/show/show/${item.id}">${item.title}</a></td>
	                <td>${item.network}</td>
	                
	            </tr>
            </c:forEach>
            
        </tbody>
    </table>
    </div>
    <div class="bottom">
    <a href="/create/show">Add a show</a>
    </div>
    </div>
</body>
</html>