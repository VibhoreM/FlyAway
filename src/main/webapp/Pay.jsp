<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
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
  	<h1>Fly-Away Flight Booking Portal - Payment Gateway</h1>
  	
  	<form action="/FlyAway/BookingDetails.jsp" method="post">
  	<span class="label-group">
		   		<%
		   			int cost = (int) session.getAttribute("cost"); 
		   		%>
		   		<label>Flight Cost: <%out.print(cost); %></label>
		   		
				<label>Enter bank Username: </label>
				<input type="text" name="username"> <br><br>
				
				<label>Enter bank password</label>
				<input type="password" name="password"> <br><br>
				
				
		
 	</span>	
 	<br><br>
 	<input type="submit" name = "Pay">
  	</form>
  	</div>
	</div>
	
			
</body>
</html>