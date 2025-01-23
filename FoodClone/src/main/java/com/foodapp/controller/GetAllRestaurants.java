package com.foodapp.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.daoimpl.RestaurantDaoImpl;
import com.foodapp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetAllRestaurants")
public class GetAllRestaurants extends HttpServlet {
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RestaurantDaoImpl rDao=new RestaurantDaoImpl();
		List<Restaurant> restaurantList = new ArrayList<>();

        try (ResultSet rset = rDao.fetchAll()) {
            while (rset.next()) {
                Restaurant restaurant = new Restaurant(
                    rset.getInt("restaurantID"),
                    rset.getString("name"),
                    rset.getString("cuisineType"),
                    rset.getInt("deliveryTime"),
                    rset.getString("address"),
                    rset.getFloat("rattings"),
                    rset.getBoolean("isActive"),
                    rset.getString("imagePath")
                );
                restaurantList.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session=req.getSession();
        session.setAttribute("restaurants", restaurantList);
        req.getRequestDispatcher("home.jsp").forward(req, res);
	}
}
