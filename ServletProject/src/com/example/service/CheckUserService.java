package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.entity.User;
import com.example.util.ConnectionFactory;

public class CheckUserService {
	private UserDao userDao = new UserDaoImpl();
	
	public boolean check(User user){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet = userDao.get(conn, user);
//			System.out.println(resultSet.getString(0));
			
			if(resultSet.next()){
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		System.out.println(user.getName()+user.getPassword());
		
		return false;
	}

}
