package com.shpach.vector3d;

import static java.lang.Math.*;

public class Vector3d {
	private int i;
	private int j;
	private int k;

	public Vector3d(int i, int j, int k) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
	}

	public Vector3d() {
		super();
	}

	public double getLength() {
		double res = i * i + j * j + k * k;
		res = sqrt(res);
		return res;
	}

	public static Vector3d addition(Vector3d v1, Vector3d v2) {
		Vector3d res = new Vector3d(v1.i + v2.i, v1.j + v2.j, v1.k + v2.k);
		return res;
	}

	public static double scalarMultiplication(Vector3d v1, Vector3d v2) {
		double res = v1.i * v2.i + v1.j * v2.j + v1.k * v2.k;
		return res;
	}

	public static Vector3d vectorMultiplication(Vector3d v1, Vector3d v2) {
		int pi = v1.j * v2.k - v1.k * v2.j;
		int pj = v1.k * v2.i - v1.i * v2.k;
		int pk = v1.i * v2.j - v1.j * v2.i;
		return new Vector3d(pi, pj, pk);
	}

	@Override
	public String toString() {
		return "Vector3d [i=" + i + ", j=" + j + ", k=" + k + "]";
	}

}
