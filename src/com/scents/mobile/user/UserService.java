package com.scents.mobile.user;

import java.util.List;
import java.util.Map;

public interface UserService {
	public boolean addUser(List<Object> params);

	public boolean delUser(String[] id);
	// 提取所有产品的信息
	public List<Map<String, Object>> listUser(String name,int start,int end);
	
	public int getItemCount();
	
	public Map<String,Object> viewUser(String id);

}
