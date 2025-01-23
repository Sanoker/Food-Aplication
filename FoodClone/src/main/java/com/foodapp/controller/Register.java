package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.daoimpl.UserDaoImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String name= req.getParameter("username");
	String password= req.getParameter("password");
	String conformpassword= req.getParameter("conformpassword");
	String email= req.getParameter("email");
	String address= req.getParameter("address");
	if(password.equals(conformpassword)) {
		UserDaoImpl udao=new UserDaoImpl();
		User u=new User(name,password,email,address);
		int i= udao.insert(u);
		if(i==1) {
			res.sendRedirect("rsuccess.html");
		}
		else {
			res.sendRedirect("rfailure.html");
		}
	}
	else {
		res.sendRedirect("rfailure.html");
	}
 }
}
