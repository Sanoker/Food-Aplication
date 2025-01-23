package com.foodapp.dao;

import com.foodapp.model.OrderItems;

import java.sql.ResultSet;

public interface OrderItemsDAO {
    int insert(OrderItems orderItem);
    int update(OrderItems orderItem);
    int delete(int orderItemID);
    ResultSet fetchAll();
    String fetchOne(int orderItemID);
}
