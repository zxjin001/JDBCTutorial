package com.mapeak.handler;

import java.sql.ResultSet;
import java.util.List;

//��������������淶��������
public interface IResultSetHandler {
	//��������
	List handle(ResultSet rs) throws Exception;
}
