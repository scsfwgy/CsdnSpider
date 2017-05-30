package com.gaoyuan.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.gaoyuan.base.BaseClass;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-10 下午2:07:09
 * @details 
 */
public class C3p0Utils extends BaseClass{
	private static ComboPooledDataSource cpds = null;

	public static DataSource getDataSource() {
		return cpds;
	}

	public static Connection getConnection() {
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	static {

		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/csdndb");
			// cpds.setJdbcUrl("jdbc:mysql://112.74.63.9:3306/spider_csdn");
			cpds.setUser("root");
			cpds.setPassword("123456");

			// the settings below are optional -- c3p0 can work with defaults
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(50);
			cpds.setInitialPoolSize(5);
			// 防止链接失效
			cpds.setIdleConnectionTestPeriod(60);
			// 缓冲相关
			cpds.setMaxStatements(30);
			cpds.setMaxStatementsPerConnection(30);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // loads the jdbc driver

	}

	public static void release(ResultSet rs, Statement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
