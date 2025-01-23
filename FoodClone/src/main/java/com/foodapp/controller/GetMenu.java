package com.foodapp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.daoimpl.MenuDaoImpl;
import com.foodapp.daoimpl.RestaurantDaoImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetMenu")
public class GetMenu extends HttpServlet {
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MenuDaoImpl mDao=new MenuDaoImpl();
		RestaurantDaoImpl rDao=new RestaurantDaoImpl();
		int resid= Integer.parseInt(req.getParameter("restaurantID"));
		
		session=req.getSession();
		session.removeAttribute("cart");
		session.setAttribute("restaurantID", rDao.fetchOne(resid).split(":")[0]);
		session.setAttribute("restaurantName", rDao.fetchOne(resid).split(":")[1]);
		
		List<Menu> menuList = new ArrayList<>();
		try (ResultSet rs = mDao.fetchbyRestaurantID(resid)) {
			while (rs.next()) {
				Menu menu = new Menu(
					rs.getInt("menuID"),
					rs.getInt("restaurantID"),
					rs.getString("name"),
					rs.getString("description"),
					rs.getInt("price"),
					rs.getBoolean("isAvailable"),
					rs.getString("imagePath")
				);
				menuList.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("menu", menuList);
		req.getRequestDispatcher("menu.jsp").forward(req, res);
	}
}
