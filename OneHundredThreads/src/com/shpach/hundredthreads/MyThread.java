package com.shpach.hundredthreads;

import java.math.BigInteger;

public class MyThread implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		int number = 0;
		try {
			number = Integer.parseInt(name);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException trying parse " + name);
			return;
		}
		System.out.println("factorial of thread "+name+" is "+factorial(number));

	}
	public static BigInteger factorial(int n){
		if (n<0) return BigInteger.ZERO;
		 BigInteger ret = BigInteger.ONE;
	        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
	        return ret;
	}

}
