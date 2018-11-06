package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

//获取数据库连接对象
public class ConnectionTest {

	@Test
	public void test() throws Exception{
		//1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	
	   Thread.sleep(60000);
	}
	
	@Test
	public void test1() throws Exception{
		//1、加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
	   Connection conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
	
	   Thread.sleep(6000);
	}
	
	@Test
	public void test2() throws Exception{
		//1、加载注册驱动
		//2、获取连接对象
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	
	   Thread.sleep(60000);
	}
}
