package com.jdbc1.PayrollService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	static Connection conn = null;
	public static void main(String[] args) throws SQLException {
		
		getSqlConnection();
		insertNew();
		
	}
	final static void insertNew() throws SQLException {
		try {
			conn = getSqlConnection();
			if(conn != null) {
				System.out.println("connection established");
				String insert = "Insert into employee_payroll (id, name, gender, salary, start) values (?,?,?,?,?)";
				PreparedStatement preparedstatement = conn.prepareStatement(insert);
				preparedstatement.setInt(1,4);
				preparedstatement.setString(2, "tiger");
				preparedstatement.setString(3, "m");
				preparedstatement.setInt(4, 500000);
				preparedstatement.setString(5, "2021-01-01");
				
				int rowUpdated = preparedstatement.executeUpdate();
				if(rowUpdated > 0) {
					System.out.println("row updated");
				}
				
			}
		}
		finally {
			if(conn != null) {
				try {
				conn.close();
				}
				catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		}
	}

	final static Connection getSqlConnection() {
		String host = "jdbc:mysql://localhost:3306/payroll_service";
		String username ="root";
		String password ="root";
		try {
		conn =DriverManager.getConnection(host, username, password);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return conn;
	}
}
