package com.mapeak.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mapeak.dao.IStudentDao;
import com.mapeak.domain.Student;

public class StudentDaoImpl2 implements IStudentDao {

	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/test";
	private String username = "root";
	private String password = "root";
	
	@Override
	public void save(Student stu) {
		String sql = "INSERT INTO t_student(id, name, age) VALUES (" + 
	stu.getId() + ", '" + stu.getName() + "', " + stu.getAge() + ")";

		System.out.println(sql);
		Connection conn = null;
		Statement st = null;
		try {
			// 1、加载注册驱动
			Class.forName(this.driverClassName);
			// 2、获取连接对象
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行 SQL
			st.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_student WHERE id = " + id;
		System.out.println(sql);
		Connection conn = null;
		Statement st = null;
		try {
			// 1、加载注册驱动
			Class.forName(this.driverClassName);
			// 2、获取连接对象
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行 SQL
			st.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	@Override
	public void update(Long id, Student stu) {
		String sql = "UPDATE t_student SET name = '" + stu.getName() + "', age = " + stu.getAge()
		+ " WHERE id = " + stu.getId();
		System.out.println(sql);
		Connection conn = null;
		Statement st = null;
		try {
			// 1、加载注册驱动
			Class.forName(this.driverClassName);
			// 2、获取连接对象
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行 SQL
			st.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = " + id + ";";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1、加载注册驱动
			Class.forName(this.driverClassName);
			// 2、获取连接对象
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行 SQL
			rs = st.executeQuery(sql);
			// ------------------------------------------
			// 处理结果集
			if (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				return stu;
			}
			// ------------------------------------------
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (st != null) {
						st.close();
					}
				} catch (Exception ex) {
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (Exception ex) {
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<Student> listAll() {
		List<Student> stus = new ArrayList();
		String sql = "SELECT * FROM t_student;";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1、加载注册驱动
			Class.forName(this.driverClassName);
			// 2、获取连接对象
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行 SQL
			rs = st.executeQuery(sql);
			// ------------------------------------------
			// 处理结果集
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stus.add(stu);
			}
			// ------------------------------------------
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 5、释放资源
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
			} finally {
				try {
					if (st != null) {
						st.close();
					}
				} catch (Exception ex) {
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (Exception ex) {
					}
				}
			}
		}
		return stus;
	}

}
