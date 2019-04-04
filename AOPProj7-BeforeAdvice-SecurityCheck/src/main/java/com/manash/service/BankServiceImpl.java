package com.manash.service;

import com.manash.dao.BankServiceDAO;

public class BankServiceImpl implements BankService {
	private BankServiceDAO dao;

	public BankServiceImpl(BankServiceDAO dao) {
		this.dao = dao;
	}
	@Override
	public String withdraw(int accno, float amount) {
		int count=0;
		//use DAO
		count=dao.withdrawAmt(accno, amount);
		if(count==0)
			return "Account Number Not Found--->>Transaction Failed ";
		else
			return "Your account "+ accno+" Is Debited--->>Transaction Successed";
	}

}
