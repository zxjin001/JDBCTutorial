package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DDLTest {

	@Test
	public void test() throws Exception {

		String sql = "CREATE TABLE t_student (id bigint(20) PRIMARY KEY AUTO_INCREMENT, name varchar(20), age int(11));";
		// 1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3、创建语句对象
		Statement st = conn.createStatement();
		// 4、执行 SQL 语句
		int row = st.executeUpdate(sql);
		// 5、释放资源
		st.close();
		conn.close();

		System.out.println(row);
	}

	@Test
	public void testException() {
		String sql = "CREATE TABLE t_student (id bigint(20) PRIMARY KEY AUTO_INCREMENT, name varchar(20), age int(11));";
		// 声明需要关闭的资源
		Connection conn = null;
		Statement st = null;

		try {
			// 1、加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行 SQL 语句
			st.executeUpdate(sql);
		} catch (Exception e) {

		} finally {
			// 5、释放资源
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
