package com.mapeak.handlers;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.mapeak.handler.IResultSetHandler2;

//��ʾ�ѽ�����е�һ�����ݣ���װ��һ������ר�����
//�������ֻ��һ�����ݵ����
public class BeanHandler<T> implements IResultSetHandler2<T> {

	// �ѽ�����е�һ�����ݣ���װ��ʲô���͵Ķ���
	private Class<T> classType;

	public BeanHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public T handle(ResultSet rs) throws Exception {
		// 1��������Ӧ���һ������
		T obj = this.classType.newInstance();
		// 2��ȡ��������еĵ�ǰ��������е�ĳһ�е�����
		BeanInfo beanInfo = Introspector.getBeanInfo(this.classType, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		if (rs.next()) {
			for (PropertyDescriptor pd : pds) {
				// ��ȡ���������������������������ͬ
				String columnName = pd.getName();
				Object value = rs.getObject(columnName);
				// 3�����øö���� setter ��������ĳһ�е����ݣ����ý�ȥ
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return obj;
	}
}
