package com.manash.target;

public class ShoppingStore {
	public float calculatetBillAmt(float price,int qty) {
		if(price<=0 || qty<=0)
			throw new IllegalArgumentException("Price And Qty Must be Greater Then Zero");
		else
	       return price*qty;		
	}
}
