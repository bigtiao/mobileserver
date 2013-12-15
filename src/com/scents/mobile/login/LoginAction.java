package com.scents.mobile.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {
	
	private LoginService service;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		service = new LoginDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);
		boolean flag = service.login(params);
		if(flag){
			request.getSession().setAttribute("username", username);
			response.sendRedirect(path +"/main.jsp");
		}
		out.flush();
		out.close();
		
		
	}

}
