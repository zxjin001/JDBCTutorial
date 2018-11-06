package com.mapeak.dao.impl;

import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;
import com.mapeak.handler.impl.StudentResultRetHandler;
import com.mapeak.handler.impl.StudentResultSetHandler2;
import com.mapeak.util.JdbcTemplate2;
import com.mapeak.util.JdbcTemplate3;
import com.mapeak.util.JdbcTemplate4;

public class StudentDaoImpl11 implements IStudentDao {

	@Override
	public List<Student> listAll() {
		return JdbcTemplate4.query("SELECT * FROM t_student"
				, new StudentResultSetHandler2());
	}

	@Override
	public Student get(Long id) {
		List<Student> list = JdbcTemplate4
				.query("SELECT * FROM t_student WHERE id = ?"
						, new StudentResultSetHandler2(), id);
		return list.size() == 1? list.get(0) : null;
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
