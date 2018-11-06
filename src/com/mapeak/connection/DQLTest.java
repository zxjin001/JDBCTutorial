package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DQLTest {

	//获取统计信息
	@Test
	public void test1() throws Exception {
		String sql = "SELECT COUNT(id) rows FROM t_student;";
		// 1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3、创建语句对象
		Statement st = conn.createStatement();
		//------------------------------------------------
		// 4、执行 SQL 语句
		ResultSet rs = st.executeQuery(sql);
		// 处理结果集
		if (rs.next()){
			long totalCount = rs.getLong(1);
			System.out.println(totalCount);
			//System.out.println(rs.getLong("COUNT(id)"));
			System.out.println(rs.getLong("rows"));
		}
		//------------------------------------------------
		// 5、释放资源
		rs.close();
		st.close();
		conn.close();
	}
	

	//获取数据库条件筛选记录
	@Test
	public void test2() throws Exception {
		String sql = "SELECT * FROM t_student WHERE id=1;";
		// 1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3、创建语句对象
		Statement st = conn.createStatement();
		//------------------------------------------------
		// 4、执行 SQL 语句
		ResultSet rs = st.executeQuery(sql);
		// 处理结果集
		if (rs.next()){
			System.out.println(rs.getLong("id") + "," + rs.getString("name") + "," + rs.getInt("age"));
		}
		//------------------------------------------------
		// 5、释放资源
		rs.close();
		st.close();
		conn.close();
	}

	//获取所有记录
	@Test
	public void test3() throws Exception {
		String sql = "SELECT * FROM t_student;";
		// 1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3、创建语句对象
		Statement st = conn.createStatement();
		//------------------------------------------------
		// 4、执行 SQL 语句
		ResultSet rs = st.executeQuery(sql);
		// 处理结果集
		while (rs.next()){
			System.out.println(rs.getLong("id") + "," + rs.getString("name") + "," + rs.getInt("age"));
		}
		//------------------------------------------------
		// 5、释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
