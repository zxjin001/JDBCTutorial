package com.mapeak.dao;

import java.util.List;

import com.mapeak.domain.Student;

//封装 Student 对象的 CRUD 操作
public interface IStudentDao {
	//保存操作
	void save(Student stu);
	
	//删除操作
	void delete(Long id);
	
	//更新操作
	void update(Long id, Student stu);
	
	//获取指定 id 的学生对象
	Student get(Long id);
	
	//查询所有学生对象
	List<Student> listAll();
}
