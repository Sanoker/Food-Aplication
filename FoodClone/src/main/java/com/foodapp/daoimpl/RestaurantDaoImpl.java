package com.foodapp.daoimpl;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.model.Restaurant;
import com.foodapp.utilities.*;

import java.sql.*;

public class RestaurantDaoImpl implements RestaurantDAO {

    Connection connection = DBconnection.connect();
    @Override
    public int insert(Restaurant restaurant) {
        try {
            String query = "INSERT INTO restaurant (restaurantID, name, cuisineType, deliveryTime, address, rattings, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, restaurant.getRestaurantID());
            statement.setString(2, restaurant.getName());
            statement.setString(3, restaurant.getCuisineType());
            statement.setInt(4, restaurant.getDeliveryTime());
            statement.setString(5, restaurant.getAddress());
            statement.setFloat(6, restaurant.getRatings());
            statement.setBoolean(7, restaurant.isActive());
            statement.setString(8, restaurant.getImagePath());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Restaurant restaurant) {
        try {
            String query = "UPDATE restaurant SET name = ?, cuisineType = ?, deliveryTime = ?, address = ?, rattings = ?, isActive = ?, imagePath = ? WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getCuisineType());
            statement.setInt(3, restaurant.getDeliveryTime());
            statement.setString(4, restaurant.getAddress());
            statement.setFloat(5, restaurant.getRatings());
            statement.setBoolean(6, restaurant.isActive());
            statement.setString(7, restaurant.getImagePath());
            statement.setInt(8, restaurant.getRestaurantID());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int restaurantID) {
        try {
            String query = "DELETE FROM restaurant WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, restaurantID);

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ResultSet fetchAll() {
        try {
            String query = "SELECT * FROM restaurant";
            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchOne(int restaurantID) {
        try {
            String query = "SELECT * FROM restaurant WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, restaurantID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) +":"+ resultSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Restaurant not found.";
    }
}
