package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "769609310xd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertUserData(Connection conn) throws SQLException {

		String sql = "INSERT INTO tbl_user(id,name,password,email)" + "VALUES(10,'Tom','12345','tom@q63.com')";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向用户表插入了" + count + "条记录");

	}

	public static void insertAddressDate(Connection conn) throws SQLException {

		String sql = "INSERT INTO tbl_address(id,city,country,user_id)" + "VALUES(1,'shanghai','china','10')";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向地址表插入了" + count + "条记录");
		conn.close();

	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn=getConnection();
			//禁止事务的自动提交
			conn.setAutoCommit(false);
			insertUserData(conn);
			insertAddressDate(conn);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("====回滚事务=====");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
