package com.hibernate.JdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
					}
		catch (Exception e) {
			System.out.println("Oracle Dro=iver not available");
			e.printStackTrace();
		}
		
		String jdbcUrl ="jdbc:oracle:thin:@localhost:1521/orcl";
		String username = "hr";
		String password =  "oracle";
				
		try{
			System.out.println("Connecting to Database "+jdbcUrl);
			
			Connection myconn = DriverManager.getConnection(jdbcUrl,username,password);
			
			System.out.println("Connection Successful");
						
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
