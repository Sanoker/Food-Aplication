package com.foodapp.daoimpl;

import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;
import com.foodapp.utilities.*;

import java.sql.*;

public class MenuDaoImpl implements MenuDAO {

    Connection connection = DBconnection.connect();
	private ResultSet resultSet;


    @Override
    public int insert(Menu menu) {
        try {
            String query = "INSERT INTO menu (menuID, restaurantID, name, description, price, isAvailable, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, menu.getMenuID());
            statement.setInt(2, menu.getRestaurantID());
            statement.setString(3, menu.getName());
            statement.setString(4, menu.getDescription());
            statement.setInt(5, menu.getPrice());
            statement.setBoolean(6, menu.getisAvailable());
            statement.setString(7, menu.getImagePath());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Menu menu) {
        try {
            String query = "UPDATE menu SET restaurantID = ?, name = ?, description = ?, price = ?, isAvailable = ?, imagePath = ? WHERE menuID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, menu.getRestaurantID());
            statement.setString(2, menu.getName());
            statement.setString(3, menu.getDescription());
            statement.setInt(4, menu.getPrice());
            statement.setBoolean(5, menu.getisAvailable());
            statement.setString(6, menu.getImagePath());
            statement.setInt(7, menu.getMenuID());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int menuID) {
        try {
            String query = "DELETE FROM menu WHERE menuID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, menuID);

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ResultSet fetchAll() {
        try {
            String query = "SELECT * FROM menu";
            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Menu fetchbyMenuID(int menuID) {
        try {
            String query = "SELECT * FROM menu WHERE menuID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, menuID);
            Menu menu=null;
            ResultSet r= statement.executeQuery();
            while (r.next()) {
            	             
               menu=new Menu(r.getInt("menuID"),r.getInt("restaurantID"),r.getString("name"), r.getString("description"),
                	r.getInt("price"), r.getBoolean("isAvailable"), r.getString("imagePath"));
			}
            return menu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public ResultSet fetchbyRestaurantID(int restaurantID) {
		try {
            String query = "SELECT * FROM menu WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, restaurantID);

            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
}
