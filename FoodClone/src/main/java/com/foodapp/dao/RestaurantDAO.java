package com.foodapp.dao;

import com.foodapp.model.Restaurant;
import java.sql.ResultSet;

public interface RestaurantDAO {
    int insert(Restaurant restaurant);
    int update(Restaurant restaurant);
    int delete(int restaurantID);
    ResultSet fetchAll();
    String fetchOne(int restaurantID);
}
