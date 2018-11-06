package com.mapeak.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com.mapeak.util.JdbcUtil5;

public class TestPreparedStatement {
	// PreparedStatement δʹ����������
	public void saveByStatement() throws Exception{
		Connection conn = JdbcUtil5.getConnection();
		for (int index = 0; index < 3000; index++){
			String sql="INSERT INTO t_student (name, age) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "AA");
			ps.setInt(2, index);
			ps.executeUpdate();
		}
	}
	
	// PreparedStatement ʹ����������
	@Test
	public void SaveByStatementBatch() throws Exception{
		Connection conn = JdbcUtil5.getConnection();
		String sql="INSERT INTO t_student (id, name, age) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int index = 0; index < 3000; index++){
			ps.setInt(1, index + 5000);
			ps.setString(2, "AA");
			ps.setInt(3, index);
			ps.addBatch();  //��ӵ���������
			if (index % 200 == 0) {
				ps.executeBatch();  //ִ����������
				ps.clearBatch();  //�����������
				ps.clearParameters();   //�������
			}
		}
	}
}
