package com.jdbc1.PayrollService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Date {
	
	static Connection conn = null;
	public static void main(String[] args) throws SQLException {
		
		getSqlConnection();
		getDataBetweenDate();
		
	}
	final static void getDataBetweenDate() throws SQLException {
		try {
			Connection conn = getSqlConnection();
			if(conn != null) {
				System.out.println("connection established");
				String date = "Select * from employee_payroll where start between '2019-01-01' and '2021-01-01' ";
				Statement statement = conn.createStatement();
				ResultSet resultset = statement.executeQuery(date);
				while(resultset.next()) {
					int ID = resultset.getInt(1);
					String Name = resultset.getString(2);
					String Gender = resultset.getString(3);
					int Salary = resultset.getInt(4);
					int Date = resultset.getInt(5);
					
					String row =String.format("UserRecord: \n ID:%d, \n Name:%s, \n Gender:%s, \n Salary:%d, \n Date:%d", ID, Name, Gender, Salary, Date);
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
	
	final static Connection getSqlConnection() {
		
		String urlHost = "jdbc:mysql://localhost:3306/payroll_service";
		String username = "root";
		String password = "root";
		try {
		conn= DriverManager.getConnection(urlHost, username, password);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return conn;
		
	}

}
