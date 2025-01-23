package com.foodapp.dao;
import java.sql.ResultSet;

import com.foodapp.model.User;

public interface UserDAO {
    int insert(User u);
    int delete(int u);
    ResultSet fetchall();
    String fetch(int uid);
    int update(int u,String pass);
	String fetch(String email);
}
