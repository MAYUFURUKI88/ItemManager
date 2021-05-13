package com.rapideact.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapideact.model.dao.ItemUpdDao;

@WebServlet("/ItemCrudServlet")
public class ItemCrudServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ItemCrudServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		ItemUpdDao dao = new ItemUpdDao();
//		ArrayList<ItemDto> list = dao.findItem();
		String item_id = request.getParameter("id");
		System.out.println(item_id);
		
		
		Map<String, String[]> form = request.getParameterMap();
		String dispatcher = 
				form.containsKey("add")?"/itemIns.jsp":
				form.containsKey("upd")?"/itemUpd.jsp":
				form.containsKey("del")?"/itemDel.jsp":
				null;
		if(dispatcher==null) {
			request.getRequestDispatcher("itemView.jsp").forward(request, response);
			
		}
		getServletContext().getRequestDispatcher(dispatcher).forward(request, response);
					
	}
}
