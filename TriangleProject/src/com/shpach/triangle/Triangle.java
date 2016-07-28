package com.shpach.triangle;

import static java.lang.Math.*;

public class Triangle {
	private int a = 0;
	private int b = 0;
	private int c = 0;

	public Triangle(int a, int b, int c) {
		super();
		if (a > 0)
			this.a = a;
		if (b > 0)
			this.b = b;
		if (!setC(c)) {
			this.c = 0;
		}
	}

	public Triangle() {
		super();
	}

	public int getA() {
		return a;
	}

	public boolean setA(int a) {
		if (a <= 0)
			return false;
		if (a < (this.b + this.c)) {
			this.a = a;
			return true;
		} else
			return false;
	}

	public int getB() {
		return b;
	}

	public boolean setB(int b) {
		if (b <= 0)
			return false;
		if (b < (this.a + this.c)) {
			this.b = b;
			return true;
		} else
			return false;
	}

	public int getC() {
		return c;
	}

	public boolean setC(int c) {
		if (c <= 0)
			return false;
		if (c < (this.b + this.a)) {
			this.c = c;
			return true;
		} else
			return false;
	}

	public boolean isValid() {
		if (a * b * c != 0) {
			return true;
		} else {
			return false;
		}
	}

	public double area() {
		if (isValid()) {
			double p = (a + b + c) / 2;
			double s = sqrt(p * (p - a) * (p - b) * (p - c));
			return s;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c +", area="+area()+ "]";
	}
	

}
