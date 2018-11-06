package com.mapeak.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DbcpUtil {
	//创建一个连接池对象
	public static DataSource getDataSource(){
		DruidDataSource ds = new DruidDataSource();
		//设置连接数据库的四要素
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxActive(5);
		ds.setInitialSize(3);
		return ds;
	}
	
	@Test
	public void test1() throws Exception {
		DataSource ds = DbcpUtil.getDataSource();
		Connection conn = ds.getConnection();
		String sql = "SELECT * FROM t_student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getLong("id"));
		}
	}
	
	private static DataSource ds = null;
	
	static {
		// 当 JdbcUtil 这份字节码被加载进 JVM 就立即执行，且只执行一次
		try {
			Properties p = new Properties();
			// 加载和读取 db.properties 文件
			InputStream inStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("druid.properties");
			p.load(inStream);
			
			ds = DruidDataSourceFactory.createDataSource(p);
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
		Connection conn = DbcpUtil.getConnection();
		String sql = "SELECT * FROM t_student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getLong("id"));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
