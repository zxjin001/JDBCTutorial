package com.mapeak.batch;

import java.sql.Connection;
import java.sql.Statement;

import com.mapeak.util.JdbcUtil5;

public class TestStatement {
	
	// Statement 未使用批量处理
	public void saveByStatement() throws Exception{
		Connection conn = JdbcUtil5.getConnection();
		for (int index = 0; index < 3000; index++){
			String sql="INSERT INTO t_student (name, age) VALUES ('AA', " + index + ")";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
	}
	
	// Statement 使用批量处理
	public void SaveByStatementBatch() throws Exception{
		Connection conn = JdbcUtil5.getConnection();
		Statement st = conn.createStatement();
		for (int index = 0; index < 3000; index++){
			String sql="INSERT INTO t_student (name, age) VALUES ('AA', " + index + ")";
			st.addBatch(sql);  //把 SQL 存储到批量操作中
			if (index % 200 == 0) {
				st.executeBatch();  //执行批量操作
				st.clearBatch();  //清除批量操作
			}
		}
	}
}
