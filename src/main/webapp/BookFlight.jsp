<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Flight</title>
<style>
			.label-group {
			    display: flex;
			    justify-content: space-between;
			}
			</style>
</head>
<body>
	<div class="container" align="center">
	<div class="vertical-center">
  	<h1>Welcome to Fly-Away Flight Booking Portal</h1>
  	<h2>FlyAway - Book Flight</h2>
  	<form action="BookFlight" method="post">
  	<span class="label-group">
		   		<%
		   			String fid = (String) session.getAttribute("fid"); 
		   		%>
		   		<label>Flight ID: <%out.print(fid); %></label>
		   		
				<label>Passenger name</label>
				<input type="text" name="pname"> <br><br>
				
				<label>Passenger Age</label>
				<input type="text" name="age"> <br><br>
				
				<label>Number of seats</label>
				<input type="text" name="seats"> <br><br>
				
				<label>Date of Journey</label>
				<input type="text" name="doj"> <br><br>
		
 	</span>	
 	<br><br>
 	<input type="submit">
  	</form>
  	</div>
	</div>
	
			
</body>
</html>