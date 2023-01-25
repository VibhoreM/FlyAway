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

@WebServlet("/Flight")
public class Flight extends HttpServlet{

	private String url = "jdbc:mysql://localhost:3306/flyaway";
	private String user = "root";
	private String password = "root";

	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String source = req.getParameter("source");
		String destination = req.getParameter("destination");
		String airline = req.getParameter("airline");
		String costString = req.getParameter("cost");
		int cost = Integer.parseInt(costString);
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into Flight values (?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,source);
			pstmt.setString(3,destination);
			pstmt.setString(4,airline);
			pstmt.setInt(5,cost);

			int x = pstmt.executeUpdate();
			if(x>0) 
			{

				PrintWriter writer = resp.getWriter();
				writer.println("Flight added successfully");
				
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
