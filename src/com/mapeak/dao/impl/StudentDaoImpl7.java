package com.mapeak.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;
import com.mapeak.util.JdbcUtil;
import com.mapeak.util.JdbcUtil2;
import com.mapeak.util.JdbcUtil4;
import com.mapeak.util.JdbcUtil5;

public class StudentDaoImpl7 implements IStudentDao {

	public void save(Student stu) {
		String sql = "INSERT INTO t_student(id, name, age) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil2.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, 76);
			ps.setString(2, stu.getName());
			ps.setInt(3, stu.getAge());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil4.close(conn, ps, null);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_student WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil2.getConnection();
			// 3、创建语句对象
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			// 4、执行 SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			JdbcUtil4.close(conn, ps, null);
		}
	}

	@Override
	public void update(Long id, Student stu) {
		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil2.getConnection();
			// 3、创建语句对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setLong(3, id);
			// 4、执行 SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			JdbcUtil4.close(conn, ps, null);
		}
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil2.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				return stu;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil4.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Student> listAll() {
		List<Student> stus = new ArrayList();
		String sql = "SELECT * FROM t_student;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil5.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stus.add(stu);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil5.close(conn, ps, rs);
		}
		return stus;
	}

}
