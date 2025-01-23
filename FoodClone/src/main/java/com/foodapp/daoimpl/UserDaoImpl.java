package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;
import com.foodapp.utilities.DBconnection;

public class UserDaoImpl implements UserDAO {
	static Connection con;
	private static final String insertQuery="insert into user(userName,password,email,adress) values(?,?,?,?)";
	private static final String deletQuery="delete from user where userID=?";
	private static final String fetchAllQuery="select * from user";
	private static final String fetchQueryid="select * from user where userID=?";
	private static final String fetchQueryemail="select * from user where email=?";
	private static final String updateQuery="update user set password=? where userID=?";
	static {
		con =DBconnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet results;

	@Override
	public int insert(User u) {
		try {
			pstmt=con.prepareStatement(insertQuery);
			pstmt.setString(1, u.getUserNameString());
			pstmt.setString(2, u.getPasswordString());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getAddressString());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int u) {
		try {
			pstmt=con.prepareStatement(deletQuery);
			pstmt.setInt(1, u);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ResultSet fetchall() {
		try {
			stmt=con.createStatement();
			results=stmt.executeQuery(fetchAllQuery);
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String fetch(int uid) {
		try {
			pstmt=con.prepareStatement(fetchQueryid);
			pstmt.setInt(1, uid);
			ResultSet r=pstmt.executeQuery();
			try {
				while (r.next()) {
					return (r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)
					+"  "+r.getString(4)+"  "+r.getString(5)); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String fetch(String email) {
		try {
			pstmt=con.prepareStatement(fetchQueryemail);
			pstmt.setString(1, email);
			ResultSet r=pstmt.executeQuery();
			try {
				while (r.next()) {
					return (r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)
					+"  "+r.getString(4)+"  "+r.getString(5)); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(int u, String pass) {
		try {
			pstmt=con.prepareStatement(updateQuery);
			pstmt.setString(1, pass);
			pstmt.setInt(2, u);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
