package com.rapideact.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rapideact.model.dao.UserDao;
import com.rapideact.model.entity.UserDto;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserLoginServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//入力フォームの値を受け取り
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		UserDto myUser = dao.findUser(id, password);
		
		boolean isLogin = (myUser != null && id.equals(myUser.getUser_id()) &&
				password.equals(myUser.getPassword()));
		HttpSession session = request.getSession();
		session.setAttribute("isLogin", isLogin);
		
		if(isLogin) {
			session.setAttribute("user_name", myUser.getUser_name());
			request.getRequestDispatcher("/ItemListServlet").forward(request, response);
		}else {
			request.setAttribute("error", "IDかパスワードが間違っています");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	

}
