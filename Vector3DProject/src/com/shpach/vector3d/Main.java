package com.shpach.vector3d;

public class Main {
	public static void main(String[] args) {
		Vector3d v1 = new Vector3d(2, 4, 10);
		Vector3d v2 = new Vector3d(4, 9, 15);
		System.out.println("vector v1 " + v1);
		System.out.println("vector v2 " + v2);
		Vector3d v3 = Vector3d.addition(v1, v2);
		System.out.println("addition v1+v2 " + v3);
		double sm = Vector3d.scalarMultiplication(v1, v2);
		System.out.println("scalar multiplication v1*v2 " + sm);
		Vector3d v4 = Vector3d.vectorMultiplication(v1, v2);
		System.out.println("vector multiplication v1*v2 " + v4);

	}
}
