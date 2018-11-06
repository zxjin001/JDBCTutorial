package com.mapeak.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.domain.Student;

// JDBC 操作的模板类
public class JdbcTemplate2 {
	public static List<Student> query(String sql, Object... params) {
		List<Student> list = new ArrayList();
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try{
			conn = DruidUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// 设置占位符参数
			for (int i = 0; i < params.length; i++) {
				//setObject 方法设置参数值
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			//处理结果集，把每一行数据封装成一个对象
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil5.close(conn, ps, rs);
		}
		return list;
	}
}
