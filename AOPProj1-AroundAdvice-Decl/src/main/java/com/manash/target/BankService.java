package com.manash.target;

public class BankService  {
	public float findSimpleInterest(float p, int t, float rate) {
		float si=0.0f;
		si=(p*t*rate)/100.0f;
		
		return si;
	}

}
