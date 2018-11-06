package com.mapeak.Blob;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.mapeak.util.JdbcUtil5;

public class BlobTest {
	//把照片存储到数据中
	@Test
	public void saveBlob() throws Exception {
		Connection conn = JdbcUtil5.getConnection();
		String sql = "INSERT INTO t_image (img) VALUES (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setBlob(1, new FileInputStream("D:/下载/20121101145508763771.png"));
		ps.executeUpdate();
		JdbcUtil5.close(conn, ps, null);
	}

	// 把 Blob 数据从数据库中获取并保存到磁盘
	@Test
	public void getBlob() throws Exception {
		Connection conn = JdbcUtil5.getConnection();
		String sql = "SELECT * FROM t_image WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 1L);
		ResultSet rs =  ps.executeQuery();
		if (rs.next()) {
			Blob blob = rs.getBlob("img");
			InputStream in = blob.getBinaryStream();
			//文件拷贝到本地
			Files.copy(in, Paths.get("C:/Users/zxjin/Desktop/pages/gt.png"));
		}
		JdbcUtil5.close(conn, ps, rs);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
