package com.mapeak.handlers;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.handler.IResultSetHandler2;

public class BeanListHandler<T> implements IResultSetHandler2<List<T>> {
	
	// �ѽ�����е�һ�����ݣ���װ��ʲô���͵Ķ���
	private Class<T> classType;

	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while (rs.next()) {
		// 1��ÿһ�У���װ��һ������
		T obj = this.classType.newInstance();
		// ��ÿһ�ж�Ӧ�Ķ��󣬴洢�� List ������
		list.add(obj);
		// 2��ȡ��������еĵ�ǰ��������е�ĳһ�е�����
		BeanInfo beanInfo = Introspector.getBeanInfo(this.classType, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				// ��ȡ���������������������������ͬ
				String columnName = pd.getName();
				Object value = rs.getObject(columnName);
				// 3�����øö���� setter ��������ĳһ�е����ݣ����ý�ȥ
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return list;
	}

}
