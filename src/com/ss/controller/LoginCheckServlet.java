package com.ss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.pojo.User;
import com.ss.service.UserService;
import com.ss.serviceImplement.UserImplement;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginC")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		UserService us = new UserImplement();
		u = us.login(u);
		if(u.getUsername()!= null&&u.getUsername() != ""){
			request.getSession().setAttribute("user", u);
			response.sendRedirect("main");
		}else{
			response.sendRedirect("login");
		}
	}

}
