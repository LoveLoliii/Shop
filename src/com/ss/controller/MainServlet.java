package com.ss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.pojo.Goods;
import com.ss.service.GoodsService;
import com.ss.serviceImplement.GoodsImplement;
 
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MainServlet() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Goods> goodsList = new ArrayList<Goods>();
		GoodsService gs = new GoodsImplement();
		goodsList = gs.queryAll();
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
