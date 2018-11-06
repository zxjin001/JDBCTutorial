package com.mapeak.batch;

import java.sql.Connection;
import java.sql.Statement;

import com.mapeak.util.JdbcUtil5;

public class TestStatement {
	
	// Statement δʹ����������
	public void saveByStatement() throws Exception{
		Connection conn = JdbcUtil5.getConnection();
		for (int index = 0; index < 3000; index++){
			String sql="INSERT INTO t_student (name, age) VALUES ('AA', " + index + ")";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
	}
	
	// Statement ʹ����������
	public void SaveByStatementBatch() throws Exception{
		Connection conn = JdbcUtil5.getConnection();
		Statement st = conn.createStatement();
		for (int index = 0; index < 3000; index++){
			String sql="INSERT INTO t_student (name, age) VALUES ('AA', " + index + ")";
			st.addBatch(sql);  //�� SQL �洢������������
			if (index % 200 == 0) {
				st.executeBatch();  //ִ����������
				st.clearBatch();  //�����������
			}
		}
	}
}
