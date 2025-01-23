package com.foodapp.daoimpl;

import com.foodapp.dao.OrderItemsDAO;
import com.foodapp.model.OrderItems;
import com.foodapp.utilities.*;
import com.foodapp.utilities.DBconnection;

import java.sql.*;

public class OrderItemsDaoImpl implements OrderItemsDAO {

    Connection connection = DBconnection.connect();

    @Override
    public int insert(OrderItems orderItem) {
        try {
            String query = "INSERT INTO orderitems (orderItemID, orderID, menuID, quantity, itemTotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderItem.getOrderItemID());
            statement.setInt(2, orderItem.getOrderID());
            statement.setInt(3, orderItem.getMenuID());
            statement.setInt(4, orderItem.getQuantity());
            statement.setInt(5, orderItem.getItemTotal());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(OrderItems orderItem) {
        try {
            String query = "UPDATE orderitems SET orderID = ?, menuID = ?, quantity = ?, itemTotal = ? WHERE orderItemID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderItem.getOrderID());
            statement.setInt(2, orderItem.getMenuID());
            statement.setInt(3, orderItem.getQuantity());
            statement.setInt(4, orderItem.getItemTotal());
            statement.setInt(5, orderItem.getOrderItemID());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int orderItemID) {
        try {
            String query = "DELETE FROM orderitems WHERE orderItemID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderItemID);

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ResultSet fetchAll() {
        try {
            String query = "SELECT * FROM orderitems";
            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchOne(int orderItemID) {
        try {
            String query = "SELECT * FROM orderitems WHERE orderItemID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderItemID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "OrderItemID: " + resultSet.getInt(1) + ", OrderID: " + resultSet.getInt(2) +
                       ", MenuID: " + resultSet.getInt(3) + ", Quantity: " + resultSet.getInt(4) +
                       ", ItemTotal: " + resultSet.getInt(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Order item not found.";
    }
}
