package com.mapeak.handler;

import java.sql.ResultSet;
import java.util.List;

//结果集处理器，规范处理结果集
public interface IResultSetHandler {
	//处理结果集
	List handle(ResultSet rs) throws Exception;
}
