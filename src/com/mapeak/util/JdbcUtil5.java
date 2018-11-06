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
		// �� JdbcUtil ����ֽ��뱻���ؽ� JVM ������ִ�У���ִֻ��һ��
		try {
			// ���غͶ�ȡ db.properties �ļ�
			InputStream inStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties");
			p.load(inStream);

			// ����ע������
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					p.getProperty("url"),        //��ȡ url ֵ
					p.getProperty("username"),   //��ȡ username ֵ
					p.getProperty("password"));  //��ȡ password ֵ
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
