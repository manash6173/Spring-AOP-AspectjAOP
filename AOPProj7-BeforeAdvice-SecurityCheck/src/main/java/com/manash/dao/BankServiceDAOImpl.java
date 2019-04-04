package com.manash.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.manash.bo.UserInfoBO;

public class BankServiceDAOImpl implements BankServiceDAO {
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";

    private JdbcTemplate jt;

	public BankServiceDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public int withdrawAmt(int accno, float amount) {
		int count=0;
		//execute query
		count=jt.update(WITHDRAW_QUERY, amount,accno);
		return count;
	}
}
