package com.mapeak.handler.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.domain.Student;
import com.mapeak.handler.IResultSetHandler;

//把结果集中每一行数据封装成 Student 对象
public class StudentResultRetHandler implements IResultSetHandler {

	@Override
	public List handle(ResultSet rs) throws Exception {
		List list = new ArrayList();
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
