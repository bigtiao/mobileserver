package com.scents.mobile.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.scents.mobile.tools.DividePage;
import com.scents.mobile.tools.UUIDTools;

public class UserAction extends HttpServlet {

	private UserService service;

	public UserAction() {
		super();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("add")) {
			addUserinfo(request, response);
		} else if (action_flag.equals("list")) {
			listUserinfo(request, response);
		} else if (action_flag.equals("del")) {
			deleteUserinfo(request, response);
		} else if (action_flag.equals("view")) {
			viewUserinfo(request, response);
		}

		out.flush();
		out.close();
	}

	private void viewUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Map<String, Object> map = service.viewUser(id);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/mobile/2_1_5xs.jsp").forward(request,
				response);

	}

	private void deleteUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String ids[] = request.getParameterValues("ids");
		boolean flag = service.delUser(ids);
		if (flag) {
			response.sendRedirect(path
					+ "/servlet/UserAction?action_flag=list");
		}

	}

	private void listUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int recordCount = service.getItemCount();// 获得记录的总条数
		int currentPage = 1;// 当前页是第一页
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		DividePage pUtil = new DividePage(5, recordCount, currentPage);
		int start = pUtil.getFromIndex();
		int end = pUtil.getToIndex();
		// 已经进行分页之后的数据集合
		List<Map<String, Object>> list = service.listUser(name, start, end);
		request.setAttribute("pUtil", pUtil);
		request.setAttribute("listuser", list);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/mobile/2_1_5.jsp").forward(request,
				response);

	}

	private void addUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String department = request.getParameter("department");
		String phonenum = request.getParameter("phonenum");
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(company);
		params.add(department);
		params.add(phonenum);
		
		boolean flag = service.addUser(params);
		if(flag){
			response.sendRedirect(path + "/servlet/UserAction?action_flag=list");
		}
	}

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		service = new UserDao();
	}

}
