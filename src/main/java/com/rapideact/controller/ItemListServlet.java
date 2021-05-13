package com.rapideact.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapideact.model.dao.ItemListDao;
import com.rapideact.model.entity.ItemDto;

@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ItemListServlet() {
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		ItemListDao dao = new ItemListDao();
		ArrayList<ItemDto> list = dao.getItemList();
		request.setAttribute("list", list);
		request.setAttribute("search_word", "");
		request.getRequestDispatcher("itemView.jsp").forward(request, response);
	}

}
