package com.mapeak.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil5 {
	private static Properties p = new Properties();
	static {
		// 当 JdbcUtil 这份字节码被加载进 JVM 就立即执行，且只执行一次
		try {
			// 加载和读取 db.properties 文件
			InputStream inStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties");
			p.load(inStream);

			// 加载注册驱动
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					p.getProperty("url"),        //获取 url 值
					p.getProperty("username"),   //获取 username 值
					p.getProperty("password"));  //获取 password 值
		} catch (Exception ex) {
		}
		return null;
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
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
