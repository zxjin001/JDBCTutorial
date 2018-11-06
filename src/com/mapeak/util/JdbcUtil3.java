package com.mapeak.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil3 {

	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "root";
	
	static {
		//�� JdbcUtil ����ֽ��뱻���ؽ� JVM ������ִ�У���ִֻ��һ��
		try
		{
		//����ע������
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
