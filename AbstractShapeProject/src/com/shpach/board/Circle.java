package com.shpach.board;
import static java.lang.Math.*;

public class Circle extends Shape {
	private Point point = new Point();
	private double radius;

	public Circle(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	@Override
	double getPerimetr() {
		return 2*PI+radius;
	}

	@Override
	double getArea() {
		return PI*pow(radius,2);
	}
	@Override
	public String toString() {
		return "Circle [point=" + point + ", radius=" + radius +", Perimetr=" + getPerimetr() + ", Area="
				+ getArea() + "]";
	}
	
}
