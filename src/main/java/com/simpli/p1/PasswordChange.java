package com.simpli.p1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PasswordChange")
public class PasswordChange extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd = req.getParameter("pwd");
		Model m = new Model();
		m.setPwd(pwd);
		resp.sendRedirect("/FlyAway/PassChangeSuccess.html");
	}

}
