package com.mapeak.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.domain.Student;
import com.mapeak.handler.IResultSetHandler;

// JDBC ������ģ����
public class JdbcTemplate3 {
	public static List query(String sql, 
			IResultSetHandler handler, Object... params) {
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try{
			conn = DruidUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// ����ռλ������
			for (int i = 0; i < params.length; i++) {
				//setObject �������ò���ֵ
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			//������������ÿһ�����ݷ�װ��һ������
			list = handler.handle(rs);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil5.close(conn, ps, rs);
		}
		return list;
	}
}
