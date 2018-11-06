package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DMLTest {
	
	//�� t_student ���������
	@Test
	public void insert() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES ('ŷ����', 14);";
		//1��������������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ�� SQL ���
		int row = st.executeUpdate(sql);
		//5���ͷ���Դ
		st.close();
		conn.close();
		System.out.println(row);
	}
	
	//�޸� t_student �м�¼
	@Test
	public void update() throws Exception {
		String sql = "UPDATE t_student SET name='ŷ��ѯ', age=39 WHERE id=2";
		//1��������������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ�� SQL ���
		int row = st.executeUpdate(sql);
		//5���ͷ���Դ
		st.close();
		conn.close();
		System.out.println(row);
		
	}
	
	//ɾ�� t_student �м�¼
	@Test
	public void delete() throws Exception {
		String sql = "DELETE FROM t_student WHERE id=2";
		//1��������������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//3������������
		Statement st = conn.createStatement();
		//4��ִ�� SQL ���
		int row = st.executeUpdate(sql);
		//5���ͷ���Դ
		st.close();
		conn.close();
		System.out.println(row);
	}
	
	
}
