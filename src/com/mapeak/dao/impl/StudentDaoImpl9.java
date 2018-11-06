package com.mapeak.dao.impl;

import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;
import com.mapeak.util.JdbcTemplate2;

public class StudentDaoImpl9  implements IStudentDao {

	@Override
	public List<Student> listAll() {
		return JdbcTemplate2.query("SELECT * FROM t_student");
	}

	@Override
	public Student get(Long id) {
		List<Student> list = JdbcTemplate2
				.query("SELECT * FROM t_student WHERE id = ?", id);
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
