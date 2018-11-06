package com.mapeak.handler.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.domain.Student;
import com.mapeak.handler.IResultSetHandler2;

//�ѽ������ÿһ�����ݷ�װ�� Student ����
public class StudentResultSetHandler2 implements IResultSetHandler2<List<Student>> {

	@Override
	public List<Student> handle(ResultSet rs) throws Exception {
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student stu = new Student();
			stu.setId(rs.getLong("id"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			list.add(stu);
		}
		return list;
	}

}
