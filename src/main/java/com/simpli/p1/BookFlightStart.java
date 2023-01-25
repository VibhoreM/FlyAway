package com.simpli.p1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookFlightStart")
public class BookFlightStart extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid = req.getParameter("fid");
		HttpSession session = req.getSession();
		session.setAttribute("fid", fid);
		resp.sendRedirect("/FlyAway/BookFlight.jsp");
	}
}
