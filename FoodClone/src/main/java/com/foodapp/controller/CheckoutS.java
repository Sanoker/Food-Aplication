package com.foodapp.controller;

import com.foodapp.dao.OrdersDAO;
import com.foodapp.dao.OrderItemsDAO;
import com.foodapp.daoimpl.OrdersDaoImpl;
import com.foodapp.daoimpl.OrderItemsDaoImpl;
import com.foodapp.model.OrderItems;
import com.foodapp.model.Orders;
import com.foodapp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/CheckoutS")
public class CheckoutS extends HttpServlet {

    private OrdersDAO oDao;
    private OrderItemsDAO orderItemsDao;
    @Override
    public void init() {
        try {
            oDao = new OrdersDaoImpl();
            orderItemsDao = new OrderItemsDaoImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String userIDStr = (String) session.getAttribute("userID");
        String restaurantIDStr = (String) session.getAttribute("restaurantID");
        Cart cart = (Cart) session.getAttribute("cart");

        if (userIDStr != null && restaurantIDStr != null && cart != null && !cart.getItems().isEmpty()) {
            int userID = Integer.parseInt(userIDStr);
            int restaurantID = Integer.parseInt(restaurantIDStr);

            Orders order = new Orders();
            String paymentMethod = req.getParameter("paymentMethod");
            order.setUserID(userID);
            order.setRestaurantID(restaurantID);
            order.setTotalAmount(cart.getTotalAmount());
            order.setStatus("Pending");
            order.setPaymentMethod(paymentMethod);

            int orderID = oDao.insert(order);

            for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                CartItem cartItem = entry.getValue();
                OrderItems orderItem = new OrderItems(0, orderID,cartItem.getItemID(),cartItem.getQuantity(),
                		(int) (cartItem.getPrice() * cartItem.getQuantity()));
                orderItemsDao.insert(orderItem);
            }

            session.removeAttribute("cart");
            session.setAttribute("order", order);
            req.getRequestDispatcher("ordercomfirmation.jsp").include(req, res);
        } else {
            res.sendRedirect("cart.jsp");
        }
    }
}
