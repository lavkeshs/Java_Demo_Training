package com.cybage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility {
	
	private static Connection con;
	public static Connection getMyConnection() {
		if(con==null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				
				String url="jdbc:mysql://localhost:3306/MyDB";
				con=DriverManager.getConnection(url,"root","root123");
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
			
		}
		return con;
	}
	
	public static void closeMyConnection() {
		try {
			if(con!=null)
			    con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
