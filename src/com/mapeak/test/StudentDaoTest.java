package com.mapeak.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import com.mapeak.dao.IStudentDao;
import com.mapeak.dao.impl.StudentDaoImpl;
import com.mapeak.dao.impl.StudentDaoImpl11;
import com.mapeak.dao.impl.StudentDaoImpl12;
import com.mapeak.dao.impl.StudentDaoImpl6;
import com.mapeak.dao.impl.StudentDaoImpl7;
import com.mapeak.dao.impl.StudentDaoImpl9;
import com.mapeak.domain.Student;

public class StudentDaoTest {

	private IStudentDao studentDao = new StudentDaoImpl12();
	
	@Test
	public void testGet() {
		System.out.println(studentDao.get(5L));
	}

	@Test
	public void testListAll() {
		List<Student> stus = studentDao.listAll();
		for (Student stu : stus){
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSave() {
		Student stu = new Student();
		stu.setId(56L);
		stu.setAge(33);
		stu.setName("¶À¹ÂÇó°Ü");
		studentDao.save(stu);
	}

	@Test
	public void testDelete() {
		studentDao.delete(9L);
	}

	@Test
	public void testUpdate() {
		Student stu = new Student();
		stu.setId(20L);
		stu.setAge(66);
		stu.setName("Çó°Ü¶À¹Â");
		studentDao.update(20L, stu);
	}

}
