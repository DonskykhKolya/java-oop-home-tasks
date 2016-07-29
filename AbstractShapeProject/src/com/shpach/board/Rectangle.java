package com.shpach.board;

public class Rectangle extends Shape {
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	

	public Rectangle(Point p1, Point p3) {
		super();
		this.p1 = p1;
		this.p3 = p3;
		reSetP2P2();
	}

	public Rectangle() {
		super();
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
		reSetP2P2();
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
		reSetP2P2();
	}
	public Point getP2() {
		return p2;
	}

	public Point getP4() {
		return p4;
	}

	private void reSetP2P2() {
		p2=new Point(p1.getX(), p3.getY());
		p4=new Point(p3.getX(), p1.getY());

	}

	
	@Override
	double getPerimetr() {
		return 2*(Point.getLength(p1, p2)+Point.getLength(p2, p3));
	}

	@Override
	double getArea() {
		return Point.getLength(p1, p2)*Point.getLength(p2, p3);
	}

	@Override
	public String toString() {
		return "Rectangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", Perimetr=" + getPerimetr()
				+ ", Area=" + getArea() + "]";
	}

}
