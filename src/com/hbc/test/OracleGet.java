package com.hbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.hbc.util.OracleConn.DbConn;

public class OracleGet {
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Connection conn;

	public static void select(String sql) {
		conn = DbConn.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 获取Oracle中的数据
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			System.out.println("每条记录共有:" + columnCount + "列");
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnName = metaData.getColumnLabel(i);
					String value = rs.getString(i);
					System.out.print("当前列为：" + columnName);
					System.out.println("值为：" + value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOracleGet() {
		System.out.println("=======婚姻表======");
		String sql = "select * from marriage";
		OracleGet.select(sql);
		System.out.println("=======性别表======");
		OracleGet.select("select * from sex");
		System.out.println("=======人员表======");
		OracleGet.select("select * from human");
	}

}
