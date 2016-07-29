package com.shpach.board;

import static java.lang.Math.*;

public class Triangle extends Shape {
	private Point p1 = new Point();
	private Point p2 = new Point();
	private Point p3 = new Point();

	public Triangle(Point x, Point y, Point z) {
		super();
		this.p1 = x;
		this.p2 = y;
		this.p3 = z;
	}

	public Triangle() {
		super();
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	@Override
	double getPerimetr() {
		double a = Point.getLength(p1, p2);
		double b = Point.getLength(p1, p3);
		double c = Point.getLength(p2, p3);
		return a + b + c;
	}

	@Override
	double getArea() {
		double a = Point.getLength(p1, p2);
		double b = Point.getLength(p1, p3);
		double c = Point.getLength(p2, p3);
		double p = a + b + c;
		return sqrt(p * (p - a) * (p - b) * (p - c));
	}

	@Override
	public String toString() {
		return "Triangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", Perimetr=" + getPerimetr() + ", Area="
				+ getArea() + "]";
	}
	

}
