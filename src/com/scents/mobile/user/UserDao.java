package com.scents.mobile.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.scents.mobile.tools.JdbcUtils;

public class UserDao implements UserService{
	private JdbcUtils jdbcUtils;
	
	public UserDao(){
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean addUser(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into userinfo(id,company,department,name,phonenum) values(?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			jdbcUtils.releaseConn();
		}
		
		return flag;
	}

	@Override
	public boolean delUser(String[] id) {
		boolean flag = false;
		try {
			jdbcUtils.getConnection();
			String[] sql = new String[id.length];
			if(id !=null){
				for (int i = 0; i < sql.length; i++) {
					sql[i] = "delete from userinfo where id = '"+id[i]+"'";
				}
			}
			flag = jdbcUtils.deleteByBatch(sql);
		} catch (Exception e) {
		}finally{
			jdbcUtils.releaseConn();
		}

		return flag;
	}

	@Override
	public List<Map<String, Object>> listUser(String name, int start, int end) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "select * from userinfo where(1=1)";
		StringBuffer buffer = new StringBuffer(sql);
		List<Object> params = new ArrayList<Object>();
		if(name != null){
			buffer.append("and name like ?");
			params.add("%"+name+"%");
		}
		buffer.append("limit ?,?");
		params.add(start);
		params.add(end);
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(buffer.toString(), params);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			jdbcUtils.releaseConn();
		}
		
		return list;
	}

	@Override
	public int getItemCount() {
		int result = 0;
		Map<String, Object> map = null;
		String sql = " select count(*) mycount from userinfo ";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, null);
			result = Integer.parseInt(map.get("mycount").toString());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Map<String, Object> viewUser(String id) {
		Map<String, Object> map = null;
		try {
			String sql = "select * from userinfo where id = ?";
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			jdbcUtils.releaseConn();
		}
		return map;
	}

}
