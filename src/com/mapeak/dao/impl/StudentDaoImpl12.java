package com.mapeak.dao.impl;

import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;
import com.mapeak.handler.impl.StudentResultRetHandler;
import com.mapeak.handler.impl.StudentResultSetHandler2;
import com.mapeak.handlers.BeanHandler;
import com.mapeak.handlers.BeanListHandler;
import com.mapeak.util.JdbcTemplate2;
import com.mapeak.util.JdbcTemplate3;
import com.mapeak.util.JdbcTemplate4;
import com.mapeak.util.JdbcTemplate5;

public class StudentDaoImpl12 implements IStudentDao {

	@Override
	public List<Student> listAll() {
		return JdbcTemplate5.query("SELECT * FROM t_student"
				, new BeanListHandler<>(Student.class));
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?;";
		Student stu = JdbcTemplate5.query(sql
				, new BeanHandler<>(Student.class), id);
		return stu;
	}

	@Override
	public void save(Student stu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Long id, Student stu) {
		// TODO Auto-generated method stub
		
	}


}
