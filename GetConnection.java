package com.jdbc1.PayrollService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	public static void main(String[] args) throws SQLException {
		
		connectionEstablished();
	}
	
		final static void connectionEstablished() {
		Connection connection =null;
		try {
			Connection conn=getSqlConnection();
			if(conn != null) {
				System.out.println("connection estalished");
			}
		}
		finally {
			try {
				if(connection != null)
					connection.close();
			}
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			
			
		}
		}
		
		static Connection getSqlConnection() {
			
			Connection conn = null;
			String dbHostUrl="jdbc:mysql://localhost:3306/payroll_service";
			String username="root";
			String password="root";
			try {
				conn=DriverManager.getConnection(dbHostUrl, username, password);
			}
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			return conn;
		}
		
}
