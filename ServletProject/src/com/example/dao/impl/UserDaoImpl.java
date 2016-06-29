package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.dao.UserDao;
import com.example.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.
				prepareStatement("INSERT INTO tbl_user(name,password,email) VALUES(?,?,?)");
		ps.setString(1,user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
	}

	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		// TODO Auto-generated method stub
		String updateSql = "UPDATE tbl_user SET name = ?,password = ?,email = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4, id);
		ps.execute();
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();

	}

}
