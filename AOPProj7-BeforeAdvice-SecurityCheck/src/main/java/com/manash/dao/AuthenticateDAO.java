package com.manash.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.manash.bo.UserInfoBO;

public class AuthenticateDAO {
	private static final String VERIFYUSER_QUERY="SELECT COUNT(*) FROM USERLIST WHERE USERN=? AND PWD=?";
	private JdbcTemplate jt;

	public AuthenticateDAO(JdbcTemplate jt) {
		this.jt = jt;
	}
	public int verifyUser(UserInfoBO bo) {
		int count=0;
		//send and execute the sql query
		count=jt.queryForObject(VERIFYUSER_QUERY, Integer.class,bo.getUname(),bo.getPwd());
		return count;
		
	}

}
