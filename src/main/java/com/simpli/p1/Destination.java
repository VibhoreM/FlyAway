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

@WebServlet("/Destination")
public class Destination extends HttpServlet{

	private String url = "jdbc:mysql://localhost:3306/flyaway";
	private String user = "root";
	private String password = "root";

	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String dname = req.getParameter("dname");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into Destination values (?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dname);

			int x = pstmt.executeUpdate();
			if(x>0) 
			{

				PrintWriter writer = resp.getWriter();
				writer.println("Destination added successfully");
				
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
