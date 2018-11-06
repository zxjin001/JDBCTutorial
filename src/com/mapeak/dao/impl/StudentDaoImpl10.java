package com.mapeak.dao.impl;

import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;
import com.mapeak.handler.impl.StudentResultRetHandler;
import com.mapeak.util.JdbcTemplate2;
import com.mapeak.util.JdbcTemplate3;

public class StudentDaoImpl10 implements IStudentDao {

	@Override
	public List<Student> listAll() {
		return JdbcTemplate3.query("SELECT * FROM t_student", new StudentResultRetHandler());
	}

	@Override
	public Student get(Long id) {
		List<Student> list = JdbcTemplate3
				.query("SELECT * FROM t_student WHERE id = ?", new StudentResultRetHandler(), id);
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
