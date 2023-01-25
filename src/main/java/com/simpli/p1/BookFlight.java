package com.simpli.p1;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname = req.getParameter("pname");
		String s1 = req.getParameter("age");
		String s2 = req.getParameter("seats");
		String doj = req.getParameter("doj");
		int age = Integer.parseInt(s1);
		int seats = Integer.parseInt(s2);
		
		HttpSession session = req.getSession();
		String fid = (String)session.getAttribute("fid");
		session.setAttribute("pname", pname);
		
		
		Data d = new Data();
		
		int cost = d.getCost(fid);
		session.setAttribute("cost", cost);
		
		boolean b = d.updateBooking(fid, pname, doj, age, seats);
		
		if(b) {
			d.generateBookingDetails(fid, pname);
			ResultSet rs2 = d.getRsBookingDetails();
			session.setAttribute("BookingDetailsRs", rs2);
			d.generateFlightData(fid);
			ResultSet rs = d.getRsFlight();
			session.setAttribute("flightdata", rs);
			resp.sendRedirect("/FlyAway/Pay.jsp");
		}else {
			resp.sendRedirect("/FlyAway/Fail.html");
		}
		
	}
}
