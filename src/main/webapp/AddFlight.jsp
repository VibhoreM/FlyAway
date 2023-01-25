<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
	<div class="container" align="center">

		<div class="vertical-center">
			<h2>FlyAway - Add Flight</h2>
			<form action="Flight" method="post">
				
				<label>Flight ID</label>
				<input type="text" name="id"> <br><br> 
				 
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
				<br><br>
				
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
				<br><br>  
				
				Enter Airline:
				<select name = "airline">
					<option value = " "> </option>
					<%
					while(data.getRsAirline().next()==true){
					String name = data.getRsAirline().getString(1);
					%>
					<option><%out.print(name); %></option>
					<%}
					data.pstmt.close();
					data.con.close();%>
					
				</select>
				<br><br> 
				
				<label>Cost</label>
				<input type="text" name="cost"> <br><br> 
				
			 <input type="submit">
			</form>
		</div>
	</div>
</body>
</html>