package com.mapeak.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mapeak.util.JdbcUtil5;

public class LoginTest {
	
	@Test
	public void loginByStatementTest() throws Exception {
		String sql = "SELECT FROM t_student WHERE name = '' OR 1=1 '' AND password = '11'";
		Connection conn = JdbcUtil5.getConnection();
		Statement st = conn.createStatement();  // Statement
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()){
			System.out.println("登入成功");
		}else {
			System.out.println("登入失败");
		}
		JdbcUtil5.close(conn, st, rs);
	}
	
	@Test
	public void loginByPreparedStatementTest() throws Exception {
		String sql = "SELECT FROM t_student WHERE name = ? AND password = ?";
		Connection conn = JdbcUtil5.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);  //PreparedStatement
		ps.setString(1, "' OR 1=1 ''");
		ps.setString(2, "11");
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			System.out.println("登入成功");
		}else {
			System.out.println("登入失败");
		}
		JdbcUtil5.close(conn, ps, rs);
	}
}
