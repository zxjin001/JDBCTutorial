package com.mapeak.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mapeak.util.JdbcUtil5;

public class txTest {

	@Test
	public void txPreparedStatementTest() throws Exception {
		
		Connection conn = JdbcUtil5.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn.setAutoCommit(false); //���������ֶ��ύ
			
			String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = 3;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "����");
			ps.setInt(2, 11);
			ps.executeUpdate();
		
			conn.commit();  //�ύ����
			
		} catch (Exception ex) {
			try{
				
				conn.rollback();  //�ع�����
				
			} catch (SQLException el) {
				el.printStackTrace();
			}
		}finally {
			JdbcUtil5.close(conn, ps, rs);
		}
	}
}
