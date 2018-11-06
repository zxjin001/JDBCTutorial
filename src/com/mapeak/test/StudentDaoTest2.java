package com.mapeak.test;

import java.sql.ResultSet;

import org.junit.Test;

import com.mapeak.dao.impl.StudentDaoImpl8;
import com.mapeak.domain.Student;
import com.mapeak.handler.IResultSetHandler2;
import com.mapeak.util.JdbcTemplate5;

public class StudentDaoTest2 {

	private StudentDaoImpl8 studentDao = new StudentDaoImpl8();
	@Test
	public void testSave() throws Exception {
		Student stu = new Student();
		stu.setAge(33);
		stu.setName("ÍõÃ§");
		int rows = studentDao.save(stu);
		System.out.println(rows);
	}

	@Test
	public void testDelete() throws Exception  {
		studentDao.delete(9L);
	}

	@Test
	public void testUpdate() throws Exception  {
		Student stu = new Student();
		stu.setId(20L);
		stu.setAge(66);
		stu.setName("Çó°Ü¶À¹Â");
		studentDao.update(stu);
	}
	
	@Test
	public void getCount() throws Exception {
		String sql = "SELECT COUNT(id) FROM t_student";
		Long totalCount = JdbcTemplate5.query(sql, new IResultSetHandler2<Long>() {

			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		});
		System.out.println(totalCount);
	}
	
}
