package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DDLTest {

	@Test
	public void test() throws Exception {

		String sql = "CREATE TABLE t_student (id bigint(20) PRIMARY KEY AUTO_INCREMENT, name varchar(20), age int(11));";
		// 1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3������������
		Statement st = conn.createStatement();
		// 4��ִ�� SQL ���
		int row = st.executeUpdate(sql);
		// 5���ͷ���Դ
		st.close();
		conn.close();

		System.out.println(row);
	}

	@Test
	public void testException() {
		String sql = "CREATE TABLE t_student (id bigint(20) PRIMARY KEY AUTO_INCREMENT, name varchar(20), age int(11));";
		// ������Ҫ�رյ���Դ
		Connection conn = null;
		Statement st = null;

		try {
			// 1������ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 2����ȡ���Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			// 3������������
			st = conn.createStatement();
			// 4��ִ�� SQL ���
			st.executeUpdate(sql);
		} catch (Exception e) {

		} finally {
			// 5���ͷ���Դ
			try {
				if (st != null)
					st.close();
			} catch (Exception e) {
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
