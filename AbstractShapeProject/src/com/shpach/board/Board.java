package com.shpach.board;

public class Board {
	private Shape[] shapes = new Shape[4];

	public Board(int socketsNumber) {
		super();
		this.shapes = new Shape[socketsNumber];
	}

	public Board() {
		super();
	}

	public boolean insertShapeOnBoard(Shape shape, int boardQuarter) {
		boolean res = false;
		if (shape == null) {
			System.out.println("Nothing to insert");
			return false;
		}
		if (boardQuarter < 0 || (boardQuarter > this.shapes.length)) {
			System.out.println("Wrong socket number");
			return false;
		}
		if (isQuarterFull(boardQuarter)) {
			System.out.println("socket " + boardQuarter + " is full");
			return false;
		}
		setShapes(shape, boardQuarter);
		return res;
	}

	public void deleteShapeOnBoard(int boardQuarter) {
		if (boardQuarter < 0 || (boardQuarter > this.shapes.length)) {
			System.out.println("Wrong socket number");
		}
		resetShapes(boardQuarter);

	}

	private void setShapes(Shape shape, int indx) {
		if (indx >= 0 && (indx < this.shapes.length)) {
			this.shapes[indx] = shape;
		}
	}

	private void resetShapes(int indx) {
		if (indx >= 0 && (indx < this.shapes.length)) {
			this.shapes[indx] = null;
		}
	}

	private boolean isQuarterFull(int indx) {
		if (indx >= 0 && (indx < this.shapes.length)) {
			if (this.shapes[indx] != null) {
				return true;
			}
		}
		return false;
	}

	public double totalArea() {
		double res = 0;
		for (Shape shape : shapes) {
			if (shape != null) {
				res += shape.getArea();
			}
		}
		return res;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Board: ").append(System.lineSeparator());
		for (Shape shape : shapes) {
			if (shape != null) {
				res.append(shape.getClass() + ": ").append(shape).append(System.lineSeparator());
			} else {
				res.append("Empty").append(System.lineSeparator());
			}
		}
		res.append("Total area: " + totalArea()).append(System.lineSeparator());
		return res.toString();

	}

}
