package com.mapeak.Keys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mapeak.util.JdbcUtil5;

public class TestKeys {

	// Statement 方式
	@Test
	public void getStatementKeys() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES ('王者霸气', 34)";
		Connection conn = JdbcUtil5.getConnection();
		Statement st = conn.createStatement();
		// 设置可以获取自动生成的主键
		int rows = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		// 这里 rows 表示受影响行数
		System.out.println(rows);
		// 获取自动生成的主键
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) {
			System.out.println(rs.getLong(1));// 获取第 1 列，即 id 值
		}
		JdbcUtil5.close(conn, st, rs);
	}

	// PreparedStatement 方式
	@Test
	public void getPreparedStatementKeys() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES (?, ?)";
		Connection conn = JdbcUtil5.getConnection();
		// 设置可以获取自动生成的主键
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "Sophie");
		ps.setInt(2, 22);
		int rows = ps.executeUpdate();
		// 这里 rows 表示受影响行数
		System.out.println(rows);
		// 获取自动生成的主键
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			System.out.println(rs.getLong(1));// 获取第 1 列，即 id 值
		}
		JdbcUtil5.close(conn, ps, rs);
	}











}
