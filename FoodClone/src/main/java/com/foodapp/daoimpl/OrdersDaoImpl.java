package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.foodapp.dao.OrdersDAO;
import com.foodapp.model.Orders;
import com.foodapp.utilities.DBconnection;

public class OrdersDaoImpl implements OrdersDAO {
	private static final String insertQuery = "insert into orders(userID,restaurantID,totalAmount,status,paymentMode) values(?,?,?,?,?)";
	private static final String deleteQuery = "delete from orders where ordersID=?";
	private static final String fetchAllQuery="select * from orders";
	private static final String fetchQuery="select * from user where ordersID=?";
	private static final String updateQuery="update user set status=? where ordersID=?";
	static Connection connection;
	static {
		connection=DBconnection.connect();
	}
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet results;
	@Override
	public int insert(Orders o) {
		try {
			pstmt=connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, o.getUserID());
			pstmt.setInt(2, o.getRestaurantID());
			pstmt.setDouble(3, o.getTotalAmount());
			pstmt.setString(4, o.getStatus());
			pstmt.setString(5, o.getPaymentMethod());
			pstmt.executeUpdate();
			int orderID=0;
			ResultSet i = pstmt.getGeneratedKeys();
			while (i.next()) {
				orderID=i.getInt(1);
			}
			return orderID;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int delete(int oid) {
		try {
			pstmt=connection.prepareStatement(deleteQuery);
			pstmt.setInt(1, oid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public ResultSet fetchall() {
		try {
			stmt=connection.createStatement();
			results=stmt.executeQuery(fetchAllQuery);
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String fetch(int oID) {
		try {
			pstmt=connection.prepareStatement(fetchQuery);
			pstmt.setInt(1, oID);
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
	public int update(int oID, String status) {
		try {
			pstmt=connection.prepareStatement(updateQuery);
			pstmt.setString(1, status);
			pstmt.setInt(2, oID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
