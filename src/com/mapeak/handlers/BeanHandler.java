package com.mapeak.handlers;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.mapeak.handler.IResultSetHandler2;

//表示把结果集中的一行数据，封装成一个对象，专门针对
//结果集中只有一行数据的情况
public class BeanHandler<T> implements IResultSetHandler2<T> {

	// 把结果集中的一行数据，封装成什么类型的对象
	private Class<T> classType;

	public BeanHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public T handle(ResultSet rs) throws Exception {
		// 1、创建对应类的一个对象
		T obj = this.classType.newInstance();
		// 2、取出结果集中的当前光标所在行的某一列的数据
		BeanInfo beanInfo = Introspector.getBeanInfo(this.classType, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		if (rs.next()) {
			for (PropertyDescriptor pd : pds) {
				// 获取对象的属性名，属性名和列名相同
				String columnName = pd.getName();
				Object value = rs.getObject(columnName);
				// 3、调用该对象的 setter 方法，把某一列的数据，设置进去
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return obj;
	}
}
