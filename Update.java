package com.jdbc1.PayrollService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	
	static Connection conn=null;
	
	public static void main(String[] args) throws SQLException {
		
		getSqlConnection();
		updateEmployeePayroll();	
	}
	final static void updateEmployeePayroll() throws SQLException {
		try {
			Connection conn = getSqlConnection();
			if(conn != null) {
				String update="update employee_payroll set salary=? where name ='Terisa'";
				
				PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setInt(1, 3000000);
		
			int rowUpdated = preparedStatement.executeUpdate();
			
			if (rowUpdated > 0) {
				System.out.println("data updated");
			}
			}
		}
		finally {
			if(conn != null)
				try {
					conn.close();
				}
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}	
		}		
	}

	final static Connection getSqlConnection() {
		
		String host = "jdbc:mysql://localhost:3306/payroll_service";
		String username = "root";
		String password = "root";
		try {
			conn = DriverManager.getConnection(host, username, password);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return conn;		
	}
}
