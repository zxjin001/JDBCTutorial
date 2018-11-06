package com.mapeak.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Util {
	public static ComboPooledDataSource getDataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}

	@Test
	public void test1() throws Exception {
		DataSource ds = C3p0Util.getDataSource();
		Connection conn = ds.getConnection();
		String sql = "SELECT * FROM t_student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getLong("id"));
		}
	}
	

	private static ComboPooledDataSource ds = null;
	
	static {
		// 当 JdbcUtil 这份字节码被加载进 JVM 就立即执行，且只执行一次
		try {
			Properties p = new Properties();
			// 加载和读取 db.properties 文件
			InputStream inStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("c3p0.properties");
			p.load(inStream);
			
			ds = new ComboPooledDataSource();
			ds.setUser(p.getProperty("c3p0.user"));
			ds.setPassword(p.getProperty("c3p0.password"));
			ds.setJdbcUrl(p.getProperty("c3p0.jdbcUrl"));
			ds.setDriverClass(p.getProperty("c3p0.driverClass"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			//从连接池中获取 Connection 对象
			return ds.getConnection();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void test2() throws Exception {
		Connection conn = C3p0Util.getConnection();
		String sql = "SELECT * FROM t_student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getLong("id"));
		}
	}
}
