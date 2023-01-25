package com.simpli.p1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Data {
	
	public ResultSet rsSource;
	public ResultSet rsDestination;
	public ResultSet rsAirline;
	public ResultSet rsFlight;
	public String aa;
	public ResultSet rsBookingDetails;
	
	
		
		public ResultSet getRsBookingDetails() {
		return rsBookingDetails;
	}

	public void setRsBookingDetails(ResultSet rsBookingDetails) {
		this.rsBookingDetails = rsBookingDetails;
	}

		public ResultSet getRsSource() {
		return rsSource;
	}

	public void setRsSource(ResultSet rsSource) {
		this.rsSource = rsSource;
	}

	public ResultSet getRsDestination() {
		return rsDestination;
	}

	public void setRsDestination(ResultSet rsDestination) {
		this.rsDestination = rsDestination;
	}

	public ResultSet getRsAirline() {
		return rsAirline;
	}

	public void setRsAirline(ResultSet rsAirline) {
		this.rsAirline = rsAirline;
	}

	public ResultSet getRsFlight() {
		return rsFlight;
	}

	public void setRsFlight(ResultSet rsFlight) {
		this.rsFlight = rsFlight;
	}

		private String url = "jdbc:mysql://localhost:3306/flyaway";
		private String user = "root";
		private String password = "root";
	
		public Connection con;
		public PreparedStatement pstmt;
	
	
	public Data()
	{
//		this.rsClass = rsClass;
//		this.rsStudent = rsStudent;
//		this.rsTeacher = rsTeacher;
		System.out.println("Constructor called");
		this.aa = "vibhore";
		this.generateSourceData();
		this.generateDestinationData();
		this.generateAirlineData();//
		this.generateFlightData();
		//this.generateFlightData();
	}
	
	public void generateSourceData(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM source";
			pstmt = con.prepareStatement(sql);
			
			setRsSource(pstmt.executeQuery());
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
		
		public void generateDestinationData(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM Destination";
				pstmt = con.prepareStatement(sql);
			
				setRsDestination(pstmt.executeQuery());
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void generateAirlineData(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM Airlines";
				pstmt = con.prepareStatement(sql);
			
				setRsAirline(pstmt.executeQuery());
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void generateFlightData(String source, String destination){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM Flight where source = ? and destination = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, source);
				pstmt.setString(2, destination);
				ResultSet rs = pstmt.executeQuery();
				setRsFlight(rs);
				System.out.println("generated data");
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void generateFlightData(String fid){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM Flight where id = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fid);
				
				ResultSet rs = pstmt.executeQuery();
				setRsFlight(rs);
				System.out.println("generated data");
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void generateFlightData(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM Flight";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				
				ResultSet rs = pstmt.executeQuery();
				setRsFlight(rs);
				System.out.println("generated data");
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public boolean updateBooking(String fid, String pname, String doj, int age, int seats){
			try {
				System.out.println("update booking called from Bookflight.java");
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "insert into booking values (?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fid);
				pstmt.setString(2, pname);
				pstmt.setInt(3, age);
				pstmt.setInt(4, seats);
				pstmt.setString(5, doj);
				int x = pstmt.executeUpdate();
				if(x>0) 
				{
					System.out.println("Booking added successfully");
					pstmt.close();
					con.close();
					return true;
				}
				else {
					
					System.out.println("Fail");
					pstmt.close();
					con.close();
					return false;
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return false;
			}
		
		
		}
		
		public int getCost(String fid){
			int cost=1;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT cost FROM Flight where id = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fid);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					cost = rs.getInt("cost");
				}
				
				System.out.println("generated cost data"+cost);
				return cost;
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return 0;
			}
		
		
		}
		
		public void generateBookingDetails(String fid, String pname){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM booking where fid = ? and pname = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fid);
				pstmt.setString(2, pname);
				ResultSet rs = pstmt.executeQuery();
				setRsBookingDetails(rs);
				System.out.println("generated data");
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
//		public void closeCon() throws SQLException {
//			pstmt.close();
//			con.close();
//		}
	
	
}


