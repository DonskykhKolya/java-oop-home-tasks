package com.shpach.multyTread;

import java.util.Arrays;
import java.util.Random;

import com.shpach.multyTread.SingleThreadSorting.Method;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[200000];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		int[] array2 = array.clone();
		int[] array3 = array.clone();
		int[] array4 = array.clone();
		long tstart = System.currentTimeMillis();
		sort(array);
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + "- Static method sort");
		tstart = System.currentTimeMillis();
		MultiThreadSorting.sort(array2, Runtime.getRuntime().availableProcessors(), Method.simple);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - MultiThread sort");
		tstart = System.currentTimeMillis();
		MultiThreadSorting.sort(array4, Runtime.getRuntime().availableProcessors(), Method.shell);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - MultiThread shell sort");
		tstart = System.currentTimeMillis();
		Arrays.sort(array3);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - Array sort");
	}

	static void sort(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) {
			int k = i - 1;
			temp = array[i];
			for (; k >= 0 && array[k] > temp;) {
				array[k + 1] = array[k];
				array[k] = temp;
				k--;
			}
		}
	}

}
