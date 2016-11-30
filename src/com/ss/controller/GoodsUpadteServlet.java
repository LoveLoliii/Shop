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
 * Servlet implementation class GoodsUpadteServlet
 */
@WebServlet("/update")
public class GoodsUpadteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpadteServlet() {
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
		request.setCharacterEncoding("utf-8");
		Goods g = new Goods();
		boolean rs = false;
		g.setId(Integer.parseInt(request.getParameter("id")));
		g.setGoodsName(request.getParameter("goodsName"));
		g.setType(request.getParameter("type"));
		g.setStock(Integer.parseInt(request.getParameter("stock")));
		g.setPrice(Float.parseFloat(request.getParameter("price")));
		
		GoodsService gs = new GoodsImplement();
		rs = gs.update(g);
		request.setAttribute("rs", rs);
		response.sendRedirect("main");
		//request.getRequestDispatcher("/main").forward(request, response); 导致浏览器地址栏未变 用户再次刷新 会提交原servlet动作
		
		
	}

}
