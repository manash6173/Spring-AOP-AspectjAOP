package com.manash.target;

public class BankService {
 
	public float calsSimpleIntAmt(float pAmt,float rate,float time) {
		return (pAmt*time*rate)/100.0f;
	}
	public float calsCompoundIntAmt(float pAmt,float rate,float time) {
		return (float) Math.pow((1+rate/100), time)-pAmt;
	}
}
