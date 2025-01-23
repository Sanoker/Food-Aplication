package com.foodapp.controller;

import java.io.IOException;
import com.foodapp.dao.MenuDAO;
import com.foodapp.daoimpl.MenuDaoImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartS")
public class CartS extends HttpServlet {

	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null) {
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		
		MenuDAO mDao=null;
		try {
			mDao=new MenuDaoImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String action=req.getParameter("action");
		
		try {
			int itemID=Integer.parseInt(req.getParameter("menuID"));
			if("add".equals(action)){
				Menu menuItem=mDao.fetchbyMenuID(itemID);
				if(menuItem!=null) {
					int quantity=1;
					CartItem cartItem=new CartItem(menuItem.getMenuID(), 
							menuItem.getRestaurantID(), 
							menuItem.getName(), 
							quantity, 
							menuItem.getPrice());
					cart.add(cartItem);
				}
			}else if("update".equals(action)) {
				int q=Integer.parseInt(req.getParameter("quantity"));
				cart.update(itemID, q);
			}else if("remove".equals(action)) {
				cart.RemoveItem(itemID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("cart", cart);
		req.getRequestDispatcher("cart.jsp").forward(req, res);
	}
}
