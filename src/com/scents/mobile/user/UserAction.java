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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
		request.getRequestDispatcher("/product/2_1_5xs.jsp").forward(request,
				response);

	}

	private void deleteUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String ids[] = request.getParameterValues("ids");
		boolean flag = service.delUser(ids);
		if (flag) {
			response.sendRedirect(path
					+ "/servlet/ProductAction?action_flag=list");
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
		request.getRequestDispatcher("/product/2_1_5.jsp").forward(request,
				response);

	}

	private void addUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 表单含有文件要提交
		String path = request.getContextPath();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 构建一个文件上传类
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		servletFileUpload.setFileSizeMax(3 * 1024 * 1024);
		servletFileUpload.setSizeMax(6 * 1024 * 1024);// 上传文件总大小
		List<FileItem> list = null;
		List<Object> params = new ArrayList<Object>();
		params.add(UUIDTools.getUUID());
		try {
			// 解析request的请求
			list = servletFileUpload.parseRequest(request);
			// 取出所有表单的值:判断非文本字段和文本字段
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("id")) {
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("name")) {
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("company")) {
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("department")) {
						params.add(fileItem.getString("utf-8"));
					}
					if (fileItem.getFieldName().equals("phonenum")) {
						params.add(fileItem.getString("utf-8"));
					}
				} else {
					try {
						String image = fileItem.getName();
						params.add(image);
						String upload_path = request.getRealPath("/upload");
						System.out.println("--->>" + upload_path);

						File real_path = new File(upload_path + "/" + image);
						fileItem.write(real_path);
						boolean flag = service.addUser(params);
						if (flag) {
							response.sendRedirect(path
									+ "/servlet/UserAction?action_flag=list");
						}
						// 把数据插入到数据库中
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		service = new UserDao();
	}

}
