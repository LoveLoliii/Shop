package com.ss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.service.GoodsService;
import com.ss.serviceImplement.GoodsImplement;

/**
 * Servlet implementation class GoodsDeleteServlet
 */
@WebServlet("/delete")
public class GoodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDeleteServlet() {
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
//		boolean rs = false;
		int id = Integer.parseInt(request.getParameter("id"));
		GoodsService gs = new GoodsImplement();
		gs.deleteById(id);
//		request.setAttribute("rs", rs);
//		request.getRequestDispatcher("/main").forward(request, response);
		response.sendRedirect("main");
	}

}
