package com.shpach.hundredthreads;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		
		BigInteger a=MyThread.factorial(100);
		for (int i = 0; i < 100; i++) {
			Thread th=new Thread(new MyThread(),Integer.toString(i));
			th.start();
		}

	}

}
