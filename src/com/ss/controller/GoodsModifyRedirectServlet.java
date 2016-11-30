package com.ss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.pojo.Goods;
import com.ss.service.GoodsService;
import com.ss.serviceImplement.GoodsImplement;

/**
 * Servlet implementation class GoodsModifyRedirectServlet
 */
@WebServlet("/modifyRedirect")
public class GoodsModifyRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsModifyRedirectServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		GoodsService gs = new GoodsImplement();
		Goods g =new Goods();
		g = gs.query(id,"id");
		request.setAttribute("g", g);
		request.getRequestDispatcher("/modify.jsp").forward(request, response);
	}

}
