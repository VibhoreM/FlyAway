package com.simpli.p1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String source = req.getParameter("source");
		String destination = req.getParameter("destination");
		
		HttpSession session = req.getSession();
		
		
		Data d = new Data();
		d.generateFlightData(source, destination);
		ResultSet rs = d.getRsFlight();
		
		session.setAttribute("flights", rs);
		resp.sendRedirect("/FlyAway/Flights.jsp");
		
//		try {
//			if(rs.next()) 
//			 {
//				session.setAttribute("flights", rs);
//				resp.sendRedirect("/FlyAway/Flights.jsp");
//			}
//			else 
//			{
//				resp.sendRedirect("/FlyAway/NoFlight.jsp");
//			}
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		
		
//		boolean b = m.verify();
//		if(b)
//		{
//			
//			resp.sendRedirect("/FlyAway/AdminHome.html");
//		}
//		else {
//			resp.sendRedirect("/FlyAway/LoginFail.html");
//		}
			
		
	}
}
