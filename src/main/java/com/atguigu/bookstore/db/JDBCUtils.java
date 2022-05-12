package com.atguigu.bookstore.db;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.atguigu.bookstore.exception.DBException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * JDBC 的工具类
 *
 */
public class JDBCUtils {

	private static ComboPooledDataSource dataSource = null;
	// private static DataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource("javawebapp");
		// dataSource = new ComboPooledDataSource();
		// dataSource.setUser("root");// 用户姓名
		// dataSource.setPassword("root");// 用户密码
		// dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/bookstore");//
		// MySQL数据库连接url
		// try {
		// dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		// } catch (PropertyVetoException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	// 获取数据库连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("数据库连接错误!");
		}
	}

	// 关闭数据库连接
	public static void release(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("数据库连接错误!");
		}
	}

	// 关闭数据库连接
	public static void release(ResultSet rs, Statement statement) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("数据库连接错误!");
		}

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("数据库连接错误!");
		}
	}

}
