package com.foodapp.dao;

import java.sql.ResultSet;

import com.foodapp.model.Orders;

public interface OrdersDAO {
	int insert(Orders o);
	int delete(int oid);
    ResultSet fetchall();
    String fetch(int oID);
    int update(int oID,String status);
}
