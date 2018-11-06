package com.mapeak.dao.impl;

import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;
import com.mapeak.util.JdbcTemplate1;

public class StudentDaoImpl8 {
	public int save(Student stu) throws Exception {
		String sql = "INSERT INTO t_student(name, age) VALUES (?, ?)";
		return JdbcTemplate1.update(sql, stu.getName(), stu.getAge());
	}
	
	public void delete(Long id) throws Exception {
		String sql = "DELETE FROM t_student WHERE id = ?";
		JdbcTemplate1.update(sql, id);
	}
	
	public void update(Student stu) throws Exception {
		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
		JdbcTemplate1.update(sql, stu.getName(), stu.getAge(), stu.getId());
	}

}
