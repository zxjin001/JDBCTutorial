package com.mapeak.handler;

import java.sql.ResultSet;
import java.util.List;

//��������������淶��������
public interface IResultSetHandler2<T> {
	//��������
	//T ��ʾδ֪���ͣ���������������Ǹ����ͼ��ϣ����������ɷ�����������ָ��
	T handle(ResultSet rs) throws Exception;
}
