package com.simpli.p1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginVerify")
public class LoginVerify extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		HttpSession session = req.getSession();
		
		//System.out.println(uname);
		//System.out.println(pwd);
		
		Model m = new Model();
		m.setUname(uname);
		m.setPasswrd(pwd);
		
		
		
		boolean b = m.verify();
		if(b)
		{
			
			resp.sendRedirect("/FlyAway/AdminHome.html");
		}
		else {
			resp.sendRedirect("/FlyAway/LoginFail.html");
		}
			
		
	}
}
