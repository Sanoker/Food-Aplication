package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.daoimpl.UserDaoImpl;
import com.foodapp.model.User;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		String[] user=new UserDaoImpl().fetch(email).split(" ");
		String conformpassword=user[2];
		if(password.equals(conformpassword)) {
			session=req.getSession();
			session.setAttribute("username", user[1]);
			session.setAttribute("userID", user[0]);
			req.getRequestDispatcher("GetAllRestaurants").forward(req, res);
			
		}
		else {
			res.sendRedirect("rfailure.html");
		}
	}
}

