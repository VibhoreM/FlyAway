<%@page import="com.simpli.p1.Data"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight Results</title>
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
  	<h2>FlyAway - Search Flight Results</h2>
  	<form >
  	
  	<table>
  <tr>
    <th>Flight ID</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Airline</th>
    <th>Cost</th>
  </tr>
  <%
  	ResultSet rs = (ResultSet) session.getAttribute("flights");
  	
  	while(rs.next()){
  		String id = rs.getString("id");
  		String source = rs.getString("source");
  		String destination = rs.getString("destination");
  		String airline = rs.getString("airline");
  		int cost = rs.getInt("cost");
  		
  %>
  <tr>
    <td> <%out.print(id); %>	</td>
    <td> <%out.print(source); %>	</td>
    <td> <%out.print(destination); %>	</td>
    <td> <%out.print(airline); %>	</td>
    <td> <%out.print(cost); }%>	</td>
  </tr>
  
  
 
</table>

<br><br>
 	
 
  	</form>
  	
  	<h2>FlyAway - Book Flight</h2>
			<form action="BookFlightStart" method="post">
				
				 
				
				Enter Flight ID to Book flight:
				<select name = "fid">
					<option value = " "> </option>
					<%
					
					Data data = new Data();
					data.generateFlightData();
					while(data.getRsFlight().next()==true){
					String name = data.getRsFlight().getString(1);
					%>
					<option><%out.print(name); %></option>
					<%} %>
					
				</select>
				
			 <input type="submit" value = "Proceed to Booking">
			</form>
  	
  	
  	</div>
	</div>
	
			
</body>
</html>