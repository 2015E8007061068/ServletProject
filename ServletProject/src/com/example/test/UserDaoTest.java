package com.example.test;

import java.sql.Connection;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.entity.User;
import com.example.util.ConnectionFactory;

public class UserDaoTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn =ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setName("tom");
			tom.setPassword("123456");
			tom.setEmail("tom@gmail.com");
			
			userDao.save(conn, tom);
			conn.commit();
		} catch (Exception e) {
			try {
				//有异常的话进行事务回滚
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
