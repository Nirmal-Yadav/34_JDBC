package com.jdbc1.PayrollService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



 public class Read { 
	 
	static Connection conn = null;
	 public static void main(String[] args) throws SQLException {
		
		 getSqlConnection();
		 readEmployeePayroll();
	}
	
	 final static void readEmployeePayroll() throws SQLException {
		 
	try {
 Connection conn = getSqlConnection();
 
	if(conn != null) {
		
		String read = "Select * from employee_payroll";
		java.sql.Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery(read);
		while(resultset.next()) {
			
		Integer id =resultset.getInt(1);
		String name = resultset.getString(2);
		Integer salary = resultset.getInt(4);
		String date = resultset.getString(5);
		String gender = resultset.getString(3);
		
		String row = String.format("User Record: \n ID:%d, \n Name:%s, \n Salary:%d, \n Date:%s, \n Gender:%s \n", id, name, salary, date, date, gender );
		System.out.println(row);
		}
	}
	}
	
	finally {
		if (conn != null) {
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
			
			
			String dbHostUrl="jdbc:mysql://localhost:3306/payroll_service";
			String username="root";
			String password="root";
			try {
				conn =DriverManager.getConnection(dbHostUrl, username, password);
			}
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			return conn;
		}
}