package com.mapeak.Keys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mapeak.util.JdbcUtil5;

public class TestKeys {

	// Statement ��ʽ
	@Test
	public void getStatementKeys() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES ('���߰���', 34)";
		Connection conn = JdbcUtil5.getConnection();
		Statement st = conn.createStatement();
		// ���ÿ��Ի�ȡ�Զ����ɵ�����
		int rows = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		// ���� rows ��ʾ��Ӱ������
		System.out.println(rows);
		// ��ȡ�Զ����ɵ�����
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) {
			System.out.println(rs.getLong(1));// ��ȡ�� 1 �У��� id ֵ
		}
		JdbcUtil5.close(conn, st, rs);
	}

	// PreparedStatement ��ʽ
	@Test
	public void getPreparedStatementKeys() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES (?, ?)";
		Connection conn = JdbcUtil5.getConnection();
		// ���ÿ��Ի�ȡ�Զ����ɵ�����
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "Sophie");
		ps.setInt(2, 22);
		int rows = ps.executeUpdate();
		// ���� rows ��ʾ��Ӱ������
		System.out.println(rows);
		// ��ȡ�Զ����ɵ�����
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			System.out.println(rs.getLong(1));// ��ȡ�� 1 �У��� id ֵ
		}
		JdbcUtil5.close(conn, ps, rs);
	}











}
