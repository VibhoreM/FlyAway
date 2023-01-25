package com.simpli.p1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	
	
	
	
	String Username = "Admin";
	String pwd;
	Path fileName = Path.of("./credentials.txt");//Pass set is 1
	
	String uname;
	String passwrd;
	
	
	
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPwd() {
		System.out.println("getting pass");
		try {
			String file_content = Files.readString(fileName);
			pwd = file_content;
			System.out.println("got pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pwd;
	}

	public void setPwd(String pwd) {
		//this.pwd = pwd;
		System.out.println("setting pass");
		try {
			
			Files.writeString(fileName, pwd);
			
			System.out.println("set pass");
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	public boolean verify() {	
		if(getUsername().equals(getUname()) && getPwd().equals(getPasswrd())){
			return true;
		}
		else {
			return false; 
			}
	}
	
	

	
}
