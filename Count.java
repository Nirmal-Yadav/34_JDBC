package com.jdbc1.PayrollService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Count {
	
	
	static Connection conn = null;
	public static void main(String[] args) throws SQLException {
		
		getSqlConnection();
		getMinMaxAvgSumCount();
		
	}
	public static void getMinMaxAvgSumCount() throws SQLException {
		try {
		Connection conn = GetConnection.getSqlConnection();
		if(conn != null) {
			System.out.println("Connection Established");
			
			String string = "Select gender, min(salary), max(salary), sum(salary), avg(salary), count(salary) from employee_payroll group by gender";
			java.sql.Statement statement =conn.createStatement();
			ResultSet resultset = statement.executeQuery(string);

			while(resultset.next()) {			
			String gender = resultset.getString(6);
			int min = resultset.getInt(1);
			int max = resultset.getInt(2);
			int sum = resultset.getInt(3);
			int avg = resultset.getInt(4);
			int count = resultset.getInt(5);
			
			String row =String.format("User Record: min:%d, max:%d, sum:%d, avg:%d, count:%d , gender:%s \n", min, max, sum, avg, count, gender);
			System.out.println(row);
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
	
	public static Connection getSqlConnection() {
		
		String host="jdbc:mysql://localhost:3306/payroll_service";
		String username="root";
		String password="root";
		try {
		conn =DriverManager.getConnection(host, username, password);
		
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return conn;
	}
}
