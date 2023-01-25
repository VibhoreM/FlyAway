<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
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
  	<h2>FlyAway - Search Flight</h2>
  	<form action="SearchFlight" method="post">
  	<span class="label-group">
		   	
				Enter Source:
				<select name = "source">
					<option value = " "> </option>
					<%
					
					Data data = new Data();
					while(data.getRsSource().next()==true){
					String name = data.getRsSource().getString(1);
					%>
					<option><%out.print(name); %></option>
					<%} %>
					
				</select>
				
				
				Enter Destination:
				<select name = "destination">
					<option value = " "> </option>
					<%
					while(data.getRsDestination().next()==true){
					String name = data.getRsDestination().getString(1);
					
					%>
					<option><%out.print(name); %></option>
					<%} %>
					
				</select>  
		
 	</span>	
 	<br><br>
 	<input type="submit">
  	</form>
  	</div>
	</div>
	
			
</body>
</html>