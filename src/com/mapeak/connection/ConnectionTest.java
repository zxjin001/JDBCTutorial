package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

//��ȡ���ݿ����Ӷ���
public class ConnectionTest {

	@Test
	public void test() throws Exception{
		//1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	
	   Thread.sleep(60000);
	}
	
	@Test
	public void test1() throws Exception{
		//1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
	   Connection conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
	
	   Thread.sleep(6000);
	}
	
	@Test
	public void test2() throws Exception{
		//1������ע������
		//2����ȡ���Ӷ���
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	
	   Thread.sleep(60000);
	}
}
