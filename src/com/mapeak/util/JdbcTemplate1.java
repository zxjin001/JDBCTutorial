package com.mapeak.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

// JDBC ������ģ����
public class JdbcTemplate1 {
	public static int update(String sql, Object ...params) throws Exception {
		Connection conn = null;
		PreparedStatement ps= null;
		try{
			conn = DruidUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// ����ռλ������
			for (int i = 0; i < params.length; i++) {
				//setObject �������ò���ֵ
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil5.close(conn, ps, null);
		}
		return 0;
	}
}
