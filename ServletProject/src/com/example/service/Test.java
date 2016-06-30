package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.entity.User;
import com.example.util.ConnectionFactory;

public class Test {
	
	
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		// TODO Auto-generated method stub
		Connection conn = null;
		User user = new User();
		user.setName("tom");
		user.setPassword("123456");
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet = userDao.get(conn, user);
//			System.out.println(resultSet.getString(0));
			
				if(resultSet.next()){
					System.out.println("dui");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
