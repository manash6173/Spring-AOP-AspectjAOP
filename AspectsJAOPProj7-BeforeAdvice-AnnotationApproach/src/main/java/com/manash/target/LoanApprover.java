package com.manash.target;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component("target")
public class LoanApprover {
	public String approveLoan(String loanType,int amount,String approver) {
		Calendar cal=null;
		int month=0;
		//get System Date
		cal=Calendar.getInstance();
		//get months
		month=cal.get(Calendar.MONTH);
		System.out.println(month);
		if(loanType.equalsIgnoreCase("agri")) {
			if(amount<=50000) {
				if(month>=6 && month<=11)
					return "Loan is Approved By::"+approver+" Of Loan amount:"+amount+"On:"+cal;
			}
		}
		return "Loan Is Rejected By::"+approver+" Of Loan Amount:"+amount+" On:"+cal.getTime();
	}

}
