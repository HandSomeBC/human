package com.hbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConn {
	public static class DbConn {
		private static String driver = "oracle.jdbc.driver.OracleDriver";
		private static String url = "jdbc:oracle:thin:@192.168.0.219:1521:orcl";
		private static String user = "GDJS_TEST_HBC";
		private static String password = "123";
		private static Connection conn = null;
		static {
			/**
			 * db.driver=oracle.jdbc.OracleDriver
			 * db.url=jdbc:oracle:thin:@192.168.0.219:1521:orcl
			 * db.username=GDJS_TEST_HBC
			 * db.password=123
			 */
			try {
				Class.forName(driver);
				System.out.println("------加载驱动成功-----");
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("------连接成功-----");
			} catch (ClassNotFoundException e) {
				System.out.println("------加载驱动失败，驱动类未找到------");
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("------加载驱动失败------");
			}
		}

		public static Connection getConn() {
			return conn;
		}
	}
}
