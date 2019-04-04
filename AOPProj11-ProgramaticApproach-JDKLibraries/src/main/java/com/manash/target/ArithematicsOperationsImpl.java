package com.manash.target;

public final class ArithematicsOperationsImpl implements ArithematicsOperations{
	@Override
	public final  float add(float x,float y) {
		return x+y;
	}
	@Override
	public final float sub(float x,float y) {
		return x-y;
	}
	@Override
	public final float mul(float x,float y) {
		return x*y;
	}
	@Override
	public final float div(float x,float y) {
		return x/y;
	}
}
