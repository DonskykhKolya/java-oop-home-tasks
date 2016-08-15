package com.shpach.arraysumm;

public class MyThread implements Runnable {
	private int[] array;
	private int begin;
	private int end;
	private int summ;
	private Thread thr;
	private boolean finish = false;
	
	public MyThread(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr=new Thread(this);
		thr.start();
	}

	public MyThread() {
		super();
	}

	public int[] getArray() {
		return array;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	public int getSumm() {
		return summ;
	}

	public Thread getThr() {
		return thr;
	}

	public boolean isFinish() {
		return finish;
	}

	@Override
	public void run() {
		int temp;
		for (int i = begin; i < end; i++) {
			summ+=array[i];
		}
		finish=true;
	}
	

}
