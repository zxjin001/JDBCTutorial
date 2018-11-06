package com.mapeak.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil3 {

	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "root";
	
	static {
		//当 JdbcUtil 这份字节码被加载进 JVM 就立即执行，且只执行一次
		try
		{
		//加载注册驱动
		Class.forName(JdbcUtil.driverClassName);
		} catch (Exception ex) {
		}
	}
	
	public static Connection getConnection() {
		try{
			return DriverManager.getConnection(url, username, password);
		}catch (Exception ex) {
		}
		return null;
	}
}
