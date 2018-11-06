package com.mapeak.handler;

import java.sql.ResultSet;
import java.util.List;

//结果集处理器，规范处理结果集
public interface IResultSetHandler2<T> {
	//处理结果集
	//T 表示未知类型，最后处理完结果集就是该类型集合，而该类型由方法调用者来指定
	T handle(ResultSet rs) throws Exception;
}
