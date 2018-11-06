package com.mapeak.handlers;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.handler.IResultSetHandler2;

public class BeanListHandler<T> implements IResultSetHandler2<List<T>> {
	
	// 把结果集中的一行数据，封装成什么类型的对象
	private Class<T> classType;

	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while (rs.next()) {
		// 1、每一行，封装成一个对象
		T obj = this.classType.newInstance();
		// 把每一行对应的对象，存储到 List 集合中
		list.add(obj);
		// 2、取出结果集中的当前光标所在行的某一列的数据
		BeanInfo beanInfo = Introspector.getBeanInfo(this.classType, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				// 获取对象的属性名，属性名和列名相同
				String columnName = pd.getName();
				Object value = rs.getObject(columnName);
				// 3、调用该对象的 setter 方法，把某一列的数据，设置进去
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return list;
	}

}
