package com.mapeak.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil2 {

	public static String driverClassName = "com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/test";
	public static String username = "root";
	public static String password = "root";
	
	public static Connection getConnection() {
		try{
			Class.forName(JdbcUtil.driverClassName);
			return DriverManager.getConnection(url, username, password);
		}catch (Exception ex) {
		}
		return null;
	}
}
