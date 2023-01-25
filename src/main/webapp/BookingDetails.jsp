<%@page import="com.simpli.p1.Data"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
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
  	<h2>FlyAway - Flight Booking Details</h2>
  	<h2>Flight Successfully Booked</h2>
  	<form action="/FlyAway/SearchFlight.jsp" method="post">
  	
  	<table>
  <tr>
    <th>Flight ID</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Airline</th>
    <th>Cost</th>
  </tr>
  <%  	
  	ResultSet rs2 = (ResultSet) session.getAttribute("BookingDetailsRs");
 	 ResultSet rs = (ResultSet) session.getAttribute("flightdata");
  	
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

<table>
  <tr>
    <%
    ResultSetMetaData rsmd = rs2.getMetaData();
    int columnCount = rsmd.getColumnCount();
    for (int i = 1; i <= columnCount; i++) {
    %>
    <th><%= rsmd.getColumnName(i) %></th>
    <% } %>
  </tr>
  <%
    while (rs2.next()) {
    	String fid = rs2.getString(1);
  		String pname = rs2.getString(2);
  		int age = rs2.getInt(3);
  		int seats = rs2.getInt(4);
  		String doj = rs2.getString(5);
  		
  %>
  <tr>
    <td> <%out.print(fid); %>	</td>
    <td> <%out.print(pname); %>	</td>
    <td> <%out.print(age); %>	</td>
    <td> <%out.print(seats); %>	</td>
    <td> <%out.print(doj); }%>	</td>
  </tr>
  
</table>
  	<br><br>
   	<input type="submit" value="Back to Home" />
	</form>
  	
  	</div>
	</div>
	
			
</body>
</html>