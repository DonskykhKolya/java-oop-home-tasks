package com.shpach.board;

public class Main {

	public static void main(String[] args) {
		Board board=new Board();
		Triangle shape1=new Triangle(new Point(20,30),new Point(14,16),new Point(45,9) );
		Circle shape2=new Circle(new Point(13, 5), 25);
		Rectangle shape3= new Rectangle(new Point(3,30),new Point(12,16));
		board.insertShapeOnBoard(shape1, 3);
		board.insertShapeOnBoard(shape2, 2);
		System.out.println(board);
		board.insertShapeOnBoard(shape3, 2);
		board.insertShapeOnBoard(shape3, 1);	
		board.deleteShapeOnBoard(3);
		System.out.println(board);

	}

}
