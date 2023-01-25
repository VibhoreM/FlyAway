package com.simpli.p1;

import java.sql.SQLException;
//This class was created for testing purpose. This class will not be called in project
public class MainApp {

	public static void main(String[] args) {
		
		Data data = new Data();
		System.out.println("started");
		try {
			while(data.getRsSource().next()==true){
			String name = data.getRsSource().getString(1);
			System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
