package com.scents.mobile.login;

import java.util.List;
import java.util.Map;

import com.scents.mobile.jdbc.JdbcUtils;

public class LoginDao implements LoginService {
	JdbcUtils jdbcUtils = null;
	
	public LoginDao(){
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean login(List<Object> params) {
		boolean flag = false;
		String sql = "select * from admin where username = ? and password = ?";
		
		try {
			jdbcUtils.getConnection();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			flag = !map.isEmpty()?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}

		return flag;
	}

}
