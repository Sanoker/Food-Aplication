package com.foodapp.dao;

import com.foodapp.model.Menu;

import java.sql.ResultSet;

public interface MenuDAO {
    int insert(Menu menu);
    int update(Menu menu);
    int delete(int menuID);
    ResultSet fetchAll();
    Menu fetchbyMenuID(int menuID);
    ResultSet fetchbyRestaurantID(int restaurantID);
}
