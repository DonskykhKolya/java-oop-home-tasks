package com.shpach.triangle;

import static java.lang.Math.*;

public class Main {

	public static void main(String[] args) {
		Triangle t1 = new Triangle(10, 30, 60);
		System.out.println("Var 1 " + t1);
		if (!t1.isValid()) {
			t1.setC((int) floor(t1.getA() + t1.getB() / 2));
			System.out.println("Var 2 " + t1);
		}
		if (!t1.setB(-15)) {
			System.out.println("Var 3 " + t1);
			t1.setB(t1.getA() + t1.getC() / 2);
			System.out.println("Var 4 " + t1);
		}

	}

}
