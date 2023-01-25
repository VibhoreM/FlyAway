package com.simpli.p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Airline")
public class Airline extends HttpServlet{

	private String url = "jdbc:mysql://localhost:3306/flyaway";
	private String user = "root";
	private String password = "root";

	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String aname = req.getParameter("aname");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into airlines values (?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,aname);

			int x = pstmt.executeUpdate();
			if(x>0) 
			{

				PrintWriter writer = resp.getWriter();
				writer.println("Airline added successfully");
				
				resp.sendRedirect("/FlyAway/Success.html");
				
			}
			else {
				PrintWriter writer = resp.getWriter();
				writer.println("Fail");
				
				resp.sendRedirect("/FlyAway/Fail.html");
			}
			pstmt.close();
			con.close();
		} 
		catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}



}
