package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtill {

	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC연결오류");
		} catch (SQLException e) {
			System.out.println("db연결 오류");
		}
		
		return null;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	public static void close(ResultSet rs,PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
