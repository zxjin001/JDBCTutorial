package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DMLTest {
	
	//往 t_student 表插入数据
	@Test
	public void insert() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES ('欧阳修', 14);";
		//1、加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行 SQL 语句
		int row = st.executeUpdate(sql);
		//5、释放资源
		st.close();
		conn.close();
		System.out.println(row);
	}
	
	//修改 t_student 中记录
	@Test
	public void update() throws Exception {
		String sql = "UPDATE t_student SET name='欧阳询', age=39 WHERE id=2";
		//1、加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行 SQL 语句
		int row = st.executeUpdate(sql);
		//5、释放资源
		st.close();
		conn.close();
		System.out.println(row);
		
	}
	
	//删除 t_student 中记录
	@Test
	public void delete() throws Exception {
		String sql = "DELETE FROM t_student WHERE id=2";
		//1、加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//3、创建语句对象
		Statement st = conn.createStatement();
		//4、执行 SQL 语句
		int row = st.executeUpdate(sql);
		//5、释放资源
		st.close();
		conn.close();
		System.out.println(row);
	}
	
	
}
