package com.mapeak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DQLTest {

	//��ȡͳ����Ϣ
	@Test
	public void test1() throws Exception {
		String sql = "SELECT COUNT(id) rows FROM t_student;";
		// 1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3������������
		Statement st = conn.createStatement();
		//------------------------------------------------
		// 4��ִ�� SQL ���
		ResultSet rs = st.executeQuery(sql);
		// ��������
		if (rs.next()){
			long totalCount = rs.getLong(1);
			System.out.println(totalCount);
			//System.out.println(rs.getLong("COUNT(id)"));
			System.out.println(rs.getLong("rows"));
		}
		//------------------------------------------------
		// 5���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}
	

	//��ȡ���ݿ�����ɸѡ��¼
	@Test
	public void test2() throws Exception {
		String sql = "SELECT * FROM t_student WHERE id=1;";
		// 1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3������������
		Statement st = conn.createStatement();
		//------------------------------------------------
		// 4��ִ�� SQL ���
		ResultSet rs = st.executeQuery(sql);
		// ��������
		if (rs.next()){
			System.out.println(rs.getLong("id") + "," + rs.getString("name") + "," + rs.getInt("age"));
		}
		//------------------------------------------------
		// 5���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}

	//��ȡ���м�¼
	@Test
	public void test3() throws Exception {
		String sql = "SELECT * FROM t_student;";
		// 1������ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		// 3������������
		Statement st = conn.createStatement();
		//------------------------------------------------
		// 4��ִ�� SQL ���
		ResultSet rs = st.executeQuery(sql);
		// ��������
		while (rs.next()){
			System.out.println(rs.getLong("id") + "," + rs.getString("name") + "," + rs.getInt("age"));
		}
		//------------------------------------------------
		// 5���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}
}
