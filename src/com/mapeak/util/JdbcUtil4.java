package com.mapeak.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil4 {

	public static String driverClassName = "com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/test";
	public static String username = "root";
	public static String password = "root";
	
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
			Class.forName(JdbcUtil.driverClassName);
			return DriverManager.getConnection(url, username, password);
		}catch (Exception ex) {
		}
		return null;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (Exception ex) {
				}
			}
		}
	}
}
